/*
 * =============================================================================
 *                         JDBC STATEMENT INTERFACE
 * =============================================================================
 *
 * Statement is an interface used to execute SQL queries
 * directly against the database.
 *
 * Statement is used when:
 * - SQL query is STATIC
 * - No dynamic values are passed at runtime
 *
 * =============================================================================
 * STATEMENT HIERARCHY
 * =============================================================================
 *
 * Object
 *   |
 *   v
 * Statement (Interface)
 *
 * =============================================================================
 * HOW STATEMENT WORKS
 * =============================================================================
 *
 * Java Application
 *        |
 *        v
 * Statement.executeQuery() / executeUpdate()
 *        |
 *        v
 * Database
 *
 * =============================================================================
 * METHODS OF STATEMENT
 * =============================================================================
 *
 * 1. executeQuery(String sql)
 *    - Used for SELECT queries
 *    - Returns ResultSet
 *
 * 2. executeUpdate(String sql)
 *    - Used for:
 *        INSERT
 *        UPDATE
 *        DELETE
 *        CREATE
 *        DROP
 *    - Returns int (number of rows affected)
 *
 * =============================================================================
 * SQL INJECTION PROBLEM (IMPORTANT ❗)
 * =============================================================================
 *
 * Statement is NOT secure.
 *
 * Example:
 * User input:
 *   username = 'admin'
 *   password = ' OR 1=1 --
 *
 * Query becomes:
 * SELECT * FROM users WHERE username='admin' OR 1=1 --
 *
 * This leads to unauthorized access.
 *
 * Solution:
 * Use PreparedStatement (NEXT FILE 🔥)
 *
 * =============================================================================
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Statement {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            /*
             * STEP 1: LOAD DRIVER
             */
            Class.forName("com.mysql.cj.jdbc.Driver");

            /*
             * STEP 2: CREATE CONNECTION
             */
            connection = DriverManager.getConnection(url, username, password);

            /*
             * STEP 3: CREATE STATEMENT
             */
            statement = connection.createStatement();

            /*
             * =============================================================================
             * EXECUTE INSERT QUERY
             * =============================================================================
             */

            String insertQuery =
                    "INSERT INTO student (id, name, age) VALUES (1, 'Rahul', 21)";

            int rowsInserted = statement.executeUpdate(insertQuery);
            System.out.println("Rows Inserted: " + rowsInserted);

            /*
             * =============================================================================
             * EXECUTE SELECT QUERY
             * =============================================================================
             */

            String selectQuery = "SELECT * FROM student";

            resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                System.out.println(id + " | " + name + " | " + age);
            }

        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {

            /*
             * =============================================================================
             * CLOSE RESOURCES
             * =============================================================================
             */

            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

/*
 * =============================================================================
 * INTERVIEW IMPORTANT POINTS
 * =============================================================================
 *
 * 1. Statement is used for static SQL queries.
 * 2. executeQuery() is used for SELECT.
 * 3. executeUpdate() is used for INSERT/UPDATE/DELETE.
 * 4. Statement is NOT secure against SQL Injection.
 * 5. PreparedStatement is preferred in real projects.
 *
 * =============================================================================
 */
