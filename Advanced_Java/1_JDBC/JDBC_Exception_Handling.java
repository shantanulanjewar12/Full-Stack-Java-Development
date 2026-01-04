/*
 * =============================================================================
 *                 JDBC EXCEPTION HANDLING – SQLException
 * =============================================================================
 *
 * JDBC operations deal with:
 * - Network
 * - Database
 * - SQL queries
 *
 * So errors are VERY COMMON.
 *
 * Java handles these errors using EXCEPTIONS.
 *
 * =============================================================================
 * WHAT IS SQLException?
 * =============================================================================
 *
 * SQLException is a CHECKED exception.
 *
 * That means:
 * ❗ Compiler forces us to handle it
 * using try–catch or throws keyword.
 *
 * SQLException occurs when:
 * - Database connection fails
 * - Wrong database name
 * - Wrong table or column name
 * - SQL syntax error
 * - Constraint violation (PK, FK)
 *
 * =============================================================================
 * SQLException HIERARCHY
 * =============================================================================
 *
 * Object
 *   |
 *   v
 * Throwable
 *   |
 *   v
 * Exception
 *   |
 *   v
 * SQLException
 *
 * =============================================================================
 * IMPORTANT METHODS OF SQLException
 * =============================================================================
 *
 * 1️⃣ getMessage()
 *    → Human-readable error message
 *
 * 2️⃣ getErrorCode()
 *    → Vendor-specific error code (MySQL, Oracle, etc.)
 *
 * 3️⃣ getSQLState()
 *    → Standard SQL state code
 *
 * =============================================================================
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Exception_Handling {

    public static void main(String[] args) {

        /*
         * =============================================================================
         * EXAMPLE 1: WRONG DATABASE NAME
         * =============================================================================
         */

        String url = "jdbc:mysql://localhost:3306/wrongdb"; // ❌ wrong DB
        String user = "root";
        String pass = "root";

        try {

            // Attempt to create DB connection
            Connection con = DriverManager.getConnection(url, user, pass);

            System.out.println("Database Connected Successfully!");

        }
        catch (SQLException e) {

            /*
             * SQLException caught here
             */

            System.out.println("❌ SQLException Occurred!");

            System.out.println("Error Message  : " + e.getMessage());
            System.out.println("Error Code     : " + e.getErrorCode());
            System.out.println("SQL State      : " + e.getSQLState());

        }

        /*
         * =============================================================================
         * EXAMPLE 2: MULTIPLE CATCH BLOCKS (BEST PRACTICE)
         * =============================================================================
         */

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/testdb",
                            "root",
                            "wrongpassword"   // ❌ wrong password
                    );

        }
        catch (ClassNotFoundException e) {

            System.out.println("JDBC Driver class not found!");

        }
        catch (SQLException e) {

            System.out.println("Database authentication failed!");
            System.out.println("Message: " + e.getMessage());

        }
    }
}

/*
 * =============================================================================
 * BEST PRACTICES FOR JDBC EXCEPTION HANDLING
 * =============================================================================
 *
 * ✔ Always catch SQLException
 * ✔ Print meaningful error message
 * ✔ Never expose DB details to users
 * ✔ Log exceptions in real applications
 * ✔ Handle ClassNotFoundException separately
 *
 * =============================================================================
 * INTERVIEW QUESTIONS
 * =============================================================================
 *
 * Q1. Is SQLException checked or unchecked?
 * → Checked
 *
 * Q2. Name 3 methods of SQLException.
 * → getMessage(), getErrorCode(), getSQLState()
 *
 * Q3. Why SQLException is common in JDBC?
 * → DB + Network + SQL errors
 *
 * =============================================================================
 */
