package Types_Of_Statement;

/*
 * =============================================================================
 *                STATEMENT INTERFACE IN JDBC (IN DETAIL)
 * =============================================================================
 *
 * Statement is an INTERFACE present in:
 *
 *   package java.sql;
 *
 * It is used to SEND SQL commands from Java
 * to the Database.
 *
 * =============================================================================
 * HOW STATEMENT OBJECT IS CREATED
 * =============================================================================
 *
 * Statement st = con.createStatement();
 *
 * Here:
 * - con is Connection object
 * - createStatement() returns Statement reference
 *
 * =============================================================================
 * TYPES OF SQL COMMANDS
 * =============================================================================
 *
 * 1️⃣ DDL – Data Definition Language
 *    - CREATE
 *    - ALTER
 *    - DROP
 *    - TRUNCATE
 *
 * 2️⃣ DML – Data Manipulation Language
 *    - INSERT
 *    - UPDATE
 *    - DELETE
 *
 * 3️⃣ DQL – Data Query Language
 *    - SELECT
 *
 * =============================================================================
 * STATEMENT INTERFACE IMPORTANT METHODS
 * =============================================================================
 *
 * 1️⃣ executeUpdate()
 * 2️⃣ executeQuery()
 *
 * =============================================================================
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Statement_Interface_Methods_Detailed {

    private static final String URL  = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static void main(String[] args) {

        createTableDDL();
        insertUpdateDeleteDML();
        selectDQL();
    }

    /*
     * =============================================================================
     * 1️⃣ executeUpdate() METHOD
     * =============================================================================
     *
     * USED FOR:
     * ✔ DDL commands (CREATE, DROP, ALTER)
     * ✔ DML commands (INSERT, UPDATE, DELETE)
     *
     * RETURN TYPE:
     * - int (number of rows affected)
     *
     * IMPORTANT:
     * - For DDL → return value is usually 0
     *
     * =============================================================================
     */

    public static void createTableDDL() {

        String createTableSQL =
                "CREATE TABLE IF NOT EXISTS employee (" +
                "id INT PRIMARY KEY, " +
                "name VARCHAR(50), " +
                "salary INT" +
                ")";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement st = con.createStatement()) {

            int result = st.executeUpdate(createTableSQL);

            System.out.println("DDL executed using executeUpdate()");
            System.out.println("Return value: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * =============================================================================
     * DML USING executeUpdate()
     * =============================================================================
     */

    public static void insertUpdateDeleteDML() {

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement st = con.createStatement()) {

            /*
             * INSERT
             */
            String insertSQL =
                    "INSERT INTO employee VALUES (1, 'Ravi', 30000)";

            int insertCount = st.executeUpdate(insertSQL);
            System.out.println("\nINSERT → Rows Affected: " + insertCount);

            /*
             * UPDATE
             */
            String updateSQL =
                    "UPDATE employee SET salary = 35000 WHERE id = 1";

            int updateCount = st.executeUpdate(updateSQL);
            System.out.println("UPDATE → Rows Affected: " + updateCount);

            /*
             * DELETE
             */
            String deleteSQL =
                    "DELETE FROM employee WHERE id = 1";

            int deleteCount = st.executeUpdate(deleteSQL);
            System.out.println("DELETE → Rows Affected: " + deleteCount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * =============================================================================
     * 2️⃣ executeQuery() METHOD
     * =============================================================================
     *
     * USED FOR:
     * ✔ SELECT (DQL)
     *
     * RETURN TYPE:
     * - ResultSet
     *
     * IMPORTANT:
     * - executeQuery() is ONLY for SELECT
     *
     * =============================================================================
     */

    public static void selectDQL() {

        String selectSQL = "SELECT * FROM employee";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(selectSQL)) {

            System.out.println("\nSELECT → Data using executeQuery()");

            while (rs.next()) {

                /*
                 * ResultSet cursor moves row by row
                 */

                int id = rs.getInt("id");
                String name = rs.getString("name");
                int salary = rs.getInt("salary");

                System.out.println(id + " | " + name + " | " + salary);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
 * =============================================================================
 * SUMMARY (BOARD REVISION STYLE)
 * =============================================================================
 *
 * Statement st = con.createStatement();
 *
 * executeUpdate()
 * → DDL + DML
 * → Returns int
 *
 * executeQuery()
 * → SELECT only
 * → Returns ResultSet
 *
 * =============================================================================
 * INTERVIEW QUESTIONS (VERY IMPORTANT 🔥)
 * =============================================================================
 *
 * Q1. Which method is used for CREATE table?
 * → executeUpdate()
 *
 * Q2. Which method is used for SELECT?
 * → executeQuery()
 *
 * Q3. Can executeQuery() be used for INSERT?
 * → ❌ No
 *
 * Q4. Return type of executeUpdate()?
 * → int
 *
 * Q5. Return type of executeQuery()?
 * → ResultSet
 *
 * =============================================================================
 */

