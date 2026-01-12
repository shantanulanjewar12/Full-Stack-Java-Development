package Types_Of_Statement;

/*
 * =============================================================================
 *                  JDBC PREPAREDSTATEMENT (IN DETAIL)
 * =============================================================================
 *
 * PreparedStatement is the MOST IMPORTANT statement in JDBC.
 *
 * Package:
 *   java.sql
 *
 * PreparedStatement is a CHILD of Statement.
 *
 * =============================================================================
 * JDBC HIERARCHY POSITION
 * =============================================================================
 *
 * java.sql.Statement
 *        |
 *        v
 * java.sql.PreparedStatement
 *
 * =============================================================================
 * WHAT IS PREPAREDSTATEMENT?
 * =============================================================================
 *
 * PreparedStatement is used to execute:
 * ✔ DYNAMIC SQL QUERIES
 *
 * DYNAMIC QUERY means:
 * - SQL query structure is fixed
 * - Values are provided at runtime
 *
 * Example:
 *   INSERT INTO student VALUES (?, ?, ?);
 *
 * =============================================================================
 * PLACEHOLDERS ( ? )
 * =============================================================================
 *
 * ? is called a PLACEHOLDER.
 *
 * It represents a value that will be supplied later.
 *
 * =============================================================================
 * HOW PREPAREDSTATEMENT WORKS (INTERNAL FLOW)
 * =============================================================================
 *
 * 1. SQL query is sent to database
 * 2. Database COMPILES the query ONCE
 * 3. Query plan is stored
 * 4. Values are passed later
 * 5. Query is executed
 *
 * RESULT:
 * ✔ Faster execution
 * ✔ Better performance
 *
 * =============================================================================
 * ADVANTAGES (VERY IMPORTANT 🔥)
 * =============================================================================
 *
 * ✔ Prevents SQL Injection
 * ✔ Faster than Statement
 * ✔ Secure
 * ✔ Reusable
 * ✔ Used in REAL PROJECTS
 *
 * =============================================================================
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatement_Detailed {

    private static final String URL  = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static void main(String[] args) {

        insertData();
        readData();
        updateData();
        deleteData();
    }

    /*
     * =============================================================================
     * INSERT USING PREPAREDSTATEMENT
     * =============================================================================
     *
     * SQL:
     * INSERT INTO student VALUES (?, ?, ?);
     *
     * JDBC METHOD:
     * executeUpdate()
     *
     * =============================================================================
     */

    public static void insertData() {

        String insertQuery =
                "INSERT INTO student (id, name, branch) VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(insertQuery)) {

            ps.setInt(1, 201);
            ps.setString(2, "Mahesh");
            ps.setString(3, "IT");

            int rows = ps.executeUpdate();

            System.out.println("INSERT → Rows Inserted: " + rows);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * =============================================================================
     * READ (SELECT) USING PREPAREDSTATEMENT
     * =============================================================================
     *
     * SQL:
     * SELECT * FROM student WHERE branch = ?;
     *
     * JDBC METHOD:
     * executeQuery()
     *
     * =============================================================================
     */

    public static void readData() {

        String selectQuery =
                "SELECT * FROM student WHERE branch = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(selectQuery)) {

            ps.setString(1, "IT");

            ResultSet rs = ps.executeQuery();

            System.out.println("\n---- DATA USING PREPAREDSTATEMENT ----");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("branch")
                );
            }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * =============================================================================
     * UPDATE USING PREPAREDSTATEMENT
     * =============================================================================
     *
     * SQL:
     * UPDATE student SET branch = ? WHERE id = ?;
     *
     * =============================================================================
     */

    public static void updateData() {

        String updateQuery =
                "UPDATE student SET branch = ? WHERE id = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(updateQuery)) {

            ps.setString(1, "CSE");
            ps.setInt(2, 201);

            int rows = ps.executeUpdate();

            System.out.println("\nUPDATE → Rows Updated: " + rows);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * =============================================================================
     * DELETE USING PREPAREDSTATEMENT
     * =============================================================================
     *
     * SQL:
     * DELETE FROM student WHERE id = ?;
     *
     * =============================================================================
     */

    public static void deleteData() {

        String deleteQuery =
                "DELETE FROM student WHERE id = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(deleteQuery)) {

            ps.setInt(1, 201);

            int rows = ps.executeUpdate();

            System.out.println("\nDELETE → Rows Deleted: " + rows);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
 * =============================================================================
 * STATEMENT vs PREPAREDSTATEMENT (INTERVIEW 🔥)
 * =============================================================================
 *
 * | Feature            | Statement | PreparedStatement |
 * |--------------------|----------|------------------|
 * | Query Type         | Static   | Dynamic          |
 * | SQL Injection Safe | ❌ No    | ✅ Yes           |
 * | Performance        | Slow     | Fast             |
 * | Used in Projects   | ❌ No    | ✅ Yes           |
 *
 * =============================================================================
 * INTERVIEW QUESTIONS
 * =============================================================================
 *
 * Q1. Why PreparedStatement is faster?
 * → Query is compiled once
 *
 * Q2. Why PreparedStatement is secure?
 * → No query concatenation
 *
 * Q3. Which JDBC statement is used in real projects?
 * → PreparedStatement
 *
 * =============================================================================
 */
