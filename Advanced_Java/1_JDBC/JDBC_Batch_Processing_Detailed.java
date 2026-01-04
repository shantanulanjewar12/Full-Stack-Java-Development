/*
 * =============================================================================
 *                     JDBC BATCH PROCESSING (IN DETAIL)
 * =============================================================================
 *
 * Batch Processing allows us to execute MULTIPLE SQL statements
 * together in a SINGLE database call.
 *
 * Instead of:
 *  - Sending one query at a time to DB
 *
 * We:
 *  - Group queries
 *  - Execute them together
 *
 * =============================================================================
 * WHY BATCH PROCESSING?
 * =============================================================================
 *
 * ✔ Improves performance
 * ✔ Reduces network calls
 * ✔ Used in bulk insert/update
 *
 * =============================================================================
 * REAL-WORLD USE CASE
 * =============================================================================
 *
 * - Inserting thousands of records from Excel
 * - Uploading CSV files
 * - Bulk user registration
 *
 * =============================================================================
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_Batch_Processing_Detailed {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static void main(String[] args) {

        /*
         * =============================================================================
         * SQL QUERY WITH PLACEHOLDERS
         * =============================================================================
         */

        String insertQuery =
                "INSERT INTO student (id, name, age) VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(insertQuery)) {

            /*
             * =============================================================================
             * ADD MULTIPLE RECORDS TO BATCH
             * =============================================================================
             */

            // Record 1
            ps.setInt(1, 301);
            ps.setString(2, "Amit");
            ps.setInt(3, 22);
            ps.addBatch();

            // Record 2
            ps.setInt(1, 302);
            ps.setString(2, "Neha");
            ps.setInt(3, 21);
            ps.addBatch();

            // Record 3
            ps.setInt(1, 303);
            ps.setString(2, "Ravi");
            ps.setInt(3, 23);
            ps.addBatch();

            /*
             * =============================================================================
             * EXECUTE BATCH
             * =============================================================================
             */

            int[] results = ps.executeBatch();

            System.out.println("Batch executed successfully!");
            System.out.println("Number of statements executed: " + results.length);

        }
        catch (SQLException e) {

            System.out.println("Batch execution failed!");
            e.printStackTrace();
        }
    }
}

/*
 * =============================================================================
 * IMPORTANT METHODS
 * =============================================================================
 *
 * addBatch()      → Adds SQL to batch
 * executeBatch()  → Executes all SQL statements together
 *
 * =============================================================================
 * INTERVIEW IMPORTANT POINTS
 * =============================================================================
 *
 * 1. Batch processing improves performance.
 * 2. Used for bulk operations.
 * 3. executeBatch() returns int[].
 * 4. Can be combined with Transactions.
 *
 * =============================================================================
 */
