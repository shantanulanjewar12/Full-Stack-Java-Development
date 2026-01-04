/*
 * =============================================================================
 *                          JDBC RESULTSET
 * =============================================================================
 *
 * ResultSet is an interface that represents the result
 * of a SELECT query executed on the database.
 *
 * It works like a TABLE stored in memory.
 *
 * =============================================================================
 * IMPORTANT POINT
 * =============================================================================
 *
 * ResultSet cursor initially points:
 * → BEFORE the first row
 *
 * We must move cursor using next() method.
 *
 * =============================================================================
 * TYPES OF RESULTSET
 * =============================================================================
 *
 * 1️⃣ TYPE_FORWARD_ONLY   (Default)
 * 2️⃣ TYPE_SCROLL_INSENSITIVE
 * 3️⃣ TYPE_SCROLL_SENSITIVE
 *
 * =============================================================================
 * RESULTSET CONCURRENCY MODES
 * =============================================================================
 *
 * 1️⃣ CONCUR_READ_ONLY
 * 2️⃣ CONCUR_UPDATABLE
 *
 * =============================================================================
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_ResultSet {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {

        /*
         * =============================================================================
         * DEFAULT RESULTSET (FORWARD ONLY)
         * =============================================================================
         */

        String query = "SELECT * FROM student";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("Forward Only ResultSet:");

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println(id + " | " + name + " | " + age);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        /*
         * =============================================================================
         * SCROLLABLE RESULTSET
         * =============================================================================
         */

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(
                     query,
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\nScrollable ResultSet:");

            // Move to last row
            rs.last();
            System.out.println("Last Row → " + rs.getInt("id"));

            // Move to first row
            rs.first();
            System.out.println("First Row → " + rs.getInt("id"));

            // Move to specific row
            rs.absolute(2);
            System.out.println("Row 2 → " + rs.getString("name"));

            // Move backwards
            rs.previous();
            System.out.println("Previous Row → " + rs.getString("name"));

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

/*
 * =============================================================================
 * RESULTSET METHODS (IMPORTANT)
 * =============================================================================
 *
 * next()        → Move to next row
 * previous()    → Move to previous row
 * first()       → Move to first row
 * last()        → Move to last row
 * absolute(n)   → Move to nth row
 *
 * =============================================================================
 * INTERVIEW IMPORTANT POINTS
 * =============================================================================
 *
 * 1. ResultSet cursor starts before first row.
 * 2. Default ResultSet is TYPE_FORWARD_ONLY.
 * 3. Scrollable ResultSet allows bidirectional movement.
 * 4. ResultSet works only with SELECT queries.
 *
 * =============================================================================
 */
