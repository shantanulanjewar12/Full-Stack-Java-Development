/*
 * =============================================================================
 *              JDBC CRUD OPERATIONS – THEORY + COMMANDS + WORKING
 * =============================================================================
 *
 * CRUD OPERATIONS are the MOST IMPORTANT part of JDBC.
 *
 * CRUD stands for:
 *
 * C → CREATE  → INSERT data into database
 * R → READ    → SELECT data from database
 * U → UPDATE  → MODIFY existing data
 * D → DELETE  → REMOVE data from database
 *
 * Every backend application (Spring, Hibernate, REST API)
 * internally performs CRUD operations.
 *
 * =============================================================================
 * DATABASE USED
 * =============================================================================
 *
 * Database Name : testdb
 * Table Name    : student
 *
 * SQL COMMAND:
 *
 * CREATE TABLE student (
 *   id INT PRIMARY KEY,
 *   name VARCHAR(50),
 *   branch VARCHAR(50)
 * );
 *
 * =============================================================================
 * JDBC CLASSES USED IN CRUD
 * =============================================================================
 *
 * DriverManager     → Creates DB connection
 * Connection        → Represents DB session
 * PreparedStatement→ Executes SQL safely
 * ResultSet         → Holds SELECT results
 *
 * =============================================================================
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class _4_JDBC_CRUD_Theory_Commands_Working {

    private static final String URL  = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static void main(String[] args) {

        insertOperation();
        readOperation();
        updateOperation();
        deleteOperation();
    }

    /*
     * =============================================================================
     * C → CREATE OPERATION (INSERT)
     * =============================================================================
     *
     * SQL COMMAND:
     *
     * INSERT INTO student VALUES (?, ?, ?);
     *
     * MEANING:
     * - Inserts a NEW record into table
     *
     * WORKING:
     * 1. SQL query is precompiled
     * 2. Values are placed in placeholders (?)
     * 3. Query is executed
     *
     * JDBC METHOD USED:
     * executeUpdate()
     *
     * RETURN VALUE:
     * - Number of rows affected (int)
     *
     * =============================================================================
     */

    public static void insertOperation() {

        String insertSQL =
                "INSERT INTO student (id, name, branch) VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(insertSQL)) {

            ps.setInt(1, 1);              // id
            ps.setString(2, "Ramesh");    // name
            ps.setString(3, "CSE");       // branch

            int rows = ps.executeUpdate();

            System.out.println("CREATE → Rows Inserted: " + rows);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * =============================================================================
     * R → READ OPERATION (SELECT)
     * =============================================================================
     *
     * SQL COMMAND:
     *
     * SELECT * FROM student;
     *
     * MEANING:
     * - Fetches data from database
     *
     * WORKING:
     * 1. Query is sent to DB
     * 2. DB returns rows
     * 3. Rows are stored in ResultSet
     * 4. Cursor moves using rs.next()
     *
     * JDBC METHOD USED:
     * executeQuery()
     *
     * RETURN TYPE:
     * ResultSet
     *
     * =============================================================================
     */

    public static void readOperation() {

        String selectSQL = "SELECT * FROM student";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(selectSQL);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\nREAD → Student Records");

            while (rs.next()) {

                /*
                 * rs.next():
                 * - Moves cursor to next row
                 * - Returns true if row exists
                 */

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("branch")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * =============================================================================
     * U → UPDATE OPERATION
     * =============================================================================
     *
     * SQL COMMAND:
     *
     * UPDATE student SET branch=? WHERE id=?;
     *
     * MEANING:
     * - Modifies existing data
     *
     * WORKING:
     * 1. Finds record using WHERE clause
     * 2. Updates specified column
     *
     * JDBC METHOD USED:
     * executeUpdate()
     *
     * RETURN VALUE:
     * - Number of rows updated
     *
     * =============================================================================
     */

    public static void updateOperation() {

        String updateSQL =
                "UPDATE student SET branch = ? WHERE id = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(updateSQL)) {

            ps.setString(1, "IT");  // new branch
            ps.setInt(2, 1);        // id condition

            int rows = ps.executeUpdate();

            System.out.println("\nUPDATE → Rows Updated: " + rows);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * =============================================================================
     * D → DELETE OPERATION
     * =============================================================================
     *
     * SQL COMMAND:
     *
     * DELETE FROM student WHERE id=?;
     *
     * MEANING:
     * - Removes record from database
     *
     * WORKING:
     * 1. Finds record using WHERE clause
     * 2. Deletes permanently
     *
     * JDBC METHOD USED:
     * executeUpdate()
     *
     * RETURN VALUE:
     * - Number of rows deleted
     *
     * =============================================================================
     */

    public static void deleteOperation() {

        String deleteSQL =
                "DELETE FROM student WHERE id = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(deleteSQL)) {

            ps.setInt(1, 1); // id to delete

            int rows = ps.executeUpdate();

            System.out.println("\nDELETE → Rows Deleted: " + rows);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
 * =============================================================================
 * IMPORTANT INTERVIEW THEORY (VERY IMPORTANT 🔥)
 * =============================================================================
 *
 * 1. INSERT / UPDATE / DELETE → executeUpdate()
 * 2. SELECT → executeQuery()
 * 3. ResultSet is only for SELECT
 * 4. WHERE clause prevents full-table update/delete
 * 5. PreparedStatement prevents SQL Injection
 *
 * =============================================================================
 * COMMON MISTAKES
 * =============================================================================
 *
 * ❌ Using Statement instead of PreparedStatement
 * ❌ Forgetting WHERE clause
 * ❌ Not closing ResultSet
 * ❌ Using executeQuery() for INSERT
 *
 * =============================================================================
 */
