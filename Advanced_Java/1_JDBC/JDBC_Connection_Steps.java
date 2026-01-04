/*
 * =============================================================================
 *                     JDBC CONNECTION – STEP BY STEP
 * =============================================================================
 *
 * This file explains HOW a JDBC connection is created internally
 * and HOW Java connects to database using DriverManager.
 *
 * =============================================================================
 * STEP 0: REQUIRED JAR / DRIVER
 * =============================================================================
 *
 * To connect Java with database, we need a JDBC driver.
 *
 * Example:
 * MySQL → mysql-connector-j.jar
 *
 * =============================================================================
 * STEP 1: IMPORT JDBC PACKAGES
 * =============================================================================
 *
 * java.sql package provides all JDBC interfaces.
 *
 * Example:
 * Connection
 * DriverManager
 * SQLException
 *
 * =============================================================================
 * STEP 2: LOAD THE DRIVER CLASS
 * =============================================================================
 *
 * Syntax:
 * Class.forName("com.mysql.cj.jdbc.Driver");
 *
 * - Loads JDBC driver into memory
 * - Registers driver with DriverManager
 *
 * NOTE:
 * From JDBC 4.0 onwards, driver loading is AUTOMATIC.
 * Still written for understanding and interviews.
 *
 * =============================================================================
 * STEP 3: CREATE DATABASE URL
 * =============================================================================
 *
 * Format (MySQL):
 * jdbc:mysql://hostname:port/database_name
 *
 * Example:
 * jdbc:mysql://localhost:3306/testdb
 *
 * =============================================================================
 * STEP 4: ESTABLISH CONNECTION
 * =============================================================================
 *
 * Method:
 * DriverManager.getConnection(url, username, password)
 *
 * Returns:
 * Connection object
 *
 * =============================================================================
 * STEP 5: VERIFY CONNECTION
 * =============================================================================
 *
 * If connection != null → Connection successful
 *
 * =============================================================================
 * STEP 6: CLOSE CONNECTION
 * =============================================================================
 *
 * Always close connection to:
 * - Free resources
 * - Avoid memory leaks
 *
 * =============================================================================
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Connection_Steps {

    public static void main(String[] args) {

        /*
         * =============================================================================
         * DATABASE CONFIGURATION
         * =============================================================================
         */

        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";

        Connection connection = null;

        try {

            /*
             * =============================================================================
             * STEP 2: LOAD DRIVER CLASS
             * =============================================================================
             */

            Class.forName("com.mysql.cj.jdbc.Driver");

            /*
             * =============================================================================
             * STEP 4: CREATE CONNECTION
             * =============================================================================
             */

            connection = DriverManager.getConnection(url, username, password);

            /*
             * =============================================================================
             * STEP 5: CHECK CONNECTION STATUS
             * =============================================================================
             */

            if (connection != null) {
                System.out.println("✅ Database connection established successfully!");
            } else {
                System.out.println("❌ Failed to establish database connection!");
            }

        }
        catch (ClassNotFoundException e) {

            /*
             * Thrown if JDBC Driver class is not found
             */

            System.out.println("JDBC Driver class not found!");
            e.printStackTrace();

        }
        catch (SQLException e) {

            /*
             * Thrown if database connection fails
             */

            System.out.println("SQL Exception occurred!");
            e.printStackTrace();

        }
        finally {

            /*
             * =============================================================================
             * STEP 6: CLOSE CONNECTION
             * =============================================================================
             */

            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("🔒 Database connection closed.");
                }
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
 * 1. DriverManager is a class in java.sql package.
 * 2. getConnection() returns Connection object.
 * 3. Class.forName() loads and registers driver.
 * 4. Connection object represents DB session.
 * 5. Always close Connection in finally block.
 *
 * =============================================================================
 */
