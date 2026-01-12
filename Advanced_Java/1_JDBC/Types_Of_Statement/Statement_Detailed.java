package Types_Of_Statement;
/*
 * =============================================================================
 *                     JDBC STATEMENT (IN DETAIL)
 * =============================================================================
 *
 * Statement is the MOST BASIC way to execute SQL queries in JDBC.
 *
 * Package:
 *   java.sql
 *
 * Statement is an INTERFACE.
 *
 * =============================================================================
 * POSITION IN JDBC HIERARCHY
 * =============================================================================
 *
 * java.lang.Object
 *        |
 *        v
 * java.sql.Statement   ← SUPER / PARENT INTERFACE
 *        |
 *        +---------------------------+
 *        |                           |
 * PreparedStatement          CallableStatement
 *
 * =============================================================================
 * WHAT IS STATEMENT?
 * =============================================================================
 *
 * Statement is used to execute:
 * ✔ STATIC SQL QUERIES
 *
 * STATIC QUERY means:
 * - Query is FIXED
 * - Values are hard-coded
 * - No user input at runtime
 *
 * Example:
 *   SELECT * FROM student;
 *
 * =============================================================================
 * HOW STATEMENT WORKS (INTERNAL FLOW)
 * =============================================================================
 *
 * Java Application
 *        |
 *        v
 * Statement object
 *        |
 *        v
 * Database
 *
 * 1. SQL query is sent to DB
 * 2. DB compiles query EVERY TIME
 * 3. DB executes query
 * 4. Result is returned
 *
 * =============================================================================
 * DISADVANTAGES (VERY IMPORTANT ❌)
 * =============================================================================
 *
 * 1. SQL Injection possible
 * 2. Slow performance
 * 3. Not secure
 * 4. NOT used in real-time projects
 *
 * =============================================================================
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Statement_Detailed {

    private static final String URL  = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static void main(String[] args) {

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {

            /*
             * =============================================================================
             * STEP 1: CREATE CONNECTION
             * =============================================================================
             */

            con = DriverManager.getConnection(URL, USER, PASS);

            /*
             * =============================================================================
             * STEP 2: CREATE STATEMENT OBJECT
             * =============================================================================
             *
             * createStatement() is used to create Statement object
             */

            st = con.createStatement();

            /*
             * =============================================================================
             * STEP 3: EXECUTE SELECT QUERY
             * =============================================================================
             *
             * executeQuery():
             * - Used ONLY for SELECT
             * - Returns ResultSet
             */

            String selectQuery = "SELECT * FROM student";

            rs = st.executeQuery(selectQuery);

            System.out.println("---- DATA USING STATEMENT ----");

            while (rs.next()) {

                /*
                 * rs.next():
                 * - Moves cursor to next row
                 * - Returns true if row exists
                 */

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String branch = rs.getString("branch");

                System.out.println(id + " | " + name + " | " + branch);
            }

            /*
             * =============================================================================
             * STEP 4: EXECUTE INSERT QUERY
             * =============================================================================
             *
             * executeUpdate():
             * - Used for INSERT, UPDATE, DELETE
             * - Returns number of rows affected
             */

            String insertQuery =
                    "INSERT INTO student VALUES (101, 'Ramesh', 'CSE')";

            int rowsInserted = st.executeUpdate(insertQuery);

            System.out.println("Rows Inserted: " + rowsInserted);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {

            /*
             * =============================================================================
             * STEP 5: CLOSE RESOURCES (VERY IMPORTANT)
             * =============================================================================
             */

            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

/*
 * =============================================================================
 * SQL INJECTION PROBLEM (INTERVIEW FAVORITE ❗)
 * =============================================================================
 *
 * If user input is concatenated:
 *
 * String query =
 * "SELECT * FROM users WHERE name='" + userInput + "'";
 *
 * Attacker input:
 *   ' OR 1=1 --
 *
 * Final Query:
 * SELECT * FROM users WHERE name='' OR 1=1 --
 *
 * RESULT:
 * → ALL RECORDS RETURNED (SECURITY BREACH)
 *
 * =============================================================================
 * WHEN SHOULD STATEMENT BE USED?
 * =============================================================================
 *
 * ✔ Only for learning
 * ✔ Only for static queries
 *
 * ❌ NOT used in real projects
 *
 * =============================================================================
 * INTERVIEW QUESTIONS
 * =============================================================================
 *
 * Q1. Is Statement an interface or class?
 * → Interface
 *
 * Q2. Which method is used for SELECT?
 * → executeQuery()
 *
 * Q3. Which method is used for INSERT/UPDATE/DELETE?
 * → executeUpdate()
 *
 * Q4. Why Statement is not preferred?
 * → SQL Injection + Poor performance
 *
 * =============================================================================
 */
