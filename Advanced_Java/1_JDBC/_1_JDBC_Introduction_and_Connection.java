/*
 * =============================================================================
 *                         JDBC – JAVA DATABASE CONNECTIVITY
 * =============================================================================
 *
 * WHAT IS JDBC?
 * -----------------------------------------------------------------------------
 * JDBC stands for Java Database Connectivity.
 *
 * JDBC is an API (Application Programming Interface) that allows
 * Java applications to interact with databases.
 *
 * Using JDBC, we can:
 *  - Insert data into database
 *  - Read data from database
 *  - Update existing data
 *  - Delete data from database
 *
 * In short → JDBC allows Java + Database communication.
 *
 * =============================================================================
 * WHY JDBC IS REQUIRED?
 * =============================================================================
 *
 * Java programs run independently, but databases store data permanently.
 * JDBC acts as a bridge between Java application and database.
 *
 * Without JDBC:
 *  - Java cannot directly talk to databases like MySQL, Oracle, PostgreSQL.
 *
 * =============================================================================
 * JDBC ARCHITECTURE
 * =============================================================================
 *
 * Java Application
 *        |
 *        v
 *   JDBC API (java.sql, javax.sql)
 *        |
 *        v
 * JDBC Driver (Vendor specific)
 *        |
 *        v
 * Database (MySQL / Oracle / PostgreSQL)
 *
 * =============================================================================
 * JDBC COMPONENTS
 * =============================================================================
 *
 * 1. DriverManager
 *    - Manages JDBC drivers
 *    - Establishes connection with database
 *
 * 2. Connection
 *    - Represents a connection to database
 *
 * 3. Statement / PreparedStatement
 *    - Used to execute SQL queries
 *
 * 4. ResultSet
 *    - Stores result returned by SELECT query
 *
 * =============================================================================
 * JDBC DRIVERS
 * =============================================================================
 *
 * Types of JDBC Drivers:
 *
 * 1. Type 1 – JDBC-ODBC Bridge Driver (Deprecated ❌)
 * 2. Type 2 – Native API Driver
 * 3. Type 3 – Network Protocol Driver
 * 4. Type 4 – Thin Driver (MOST USED ✅)
 *
 * We mostly use TYPE 4 driver.
 *
 * Example:
 * MySQL Driver → com.mysql.cj.jdbc.Driver
 *
 * =============================================================================
 * STEPS TO CONNECT JAVA WITH DATABASE
 * =============================================================================
 *
 * Step 1: Load the Driver (Optional in modern JDBC)
 * Step 2: Create Connection
 * Step 3: Create Statement
 * Step 4: Execute SQL Query
 * Step 5: Process Result
 * Step 6: Close Resources
 *
 * =============================================================================
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class _1_JDBC_Introduction_and_Connection {

    public static void main(String[] args) {

        /*
         * =============================================================================
         * DATABASE DETAILS
         * =============================================================================
         *
         * url      → Database location
         * username → Database username
         * password → Database password
         *
         * Format of MySQL URL:
         * jdbc:mysql://localhost:3306/database_name
         *
         */

        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";

        Connection connection = null;

        try {

            /*
             * =============================================================================
             * STEP 1: LOAD JDBC DRIVER (OPTIONAL)
             * =============================================================================
             *
             * From JDBC 4 onwards, driver loading is automatic.
             * Still written for understanding.
             */

            Class.forName("com.mysql.cj.jdbc.Driver");

            /*
             * =============================================================================
             * STEP 2: ESTABLISH CONNECTION
             * =============================================================================
             *
             * DriverManager.getConnection() creates a connection
             * between Java application and database.
             */

            connection = DriverManager.getConnection(url, username, password);

            /*
             * =============================================================================
             * CONNECTION STATUS CHECK
             * =============================================================================
             */

            if (connection != null) {
                System.out.println("✅ Database connected successfully!");
            } else {
                System.out.println("❌ Failed to connect to database!");
            }

        }
        catch (ClassNotFoundException e) {

            /*
             * Thrown when JDBC Driver class is not found
             */
            System.out.println("JDBC Driver not found!");
            e.printStackTrace();

        }
        catch (SQLException e) {

            /*
             * Thrown when database connection fails
             */
            System.out.println("Database connection failed!");
            e.printStackTrace();

        }
        finally {

            /*
             * =============================================================================
             * STEP 6: CLOSE CONNECTION
             * =============================================================================
             *
             * Always close database resources to avoid memory leaks.
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
 * IMPORTANT INTERVIEW POINTS
 * =============================================================================
 *
 * 1. JDBC is an API, not a framework.
 * 2. JDBC is present in java.sql package.
 * 3. Type 4 driver is most commonly used.
 * 4. Connection object represents a session with database.
 * 5. Always close Connection, Statement, ResultSet.
 *
 * =============================================================================
 */
