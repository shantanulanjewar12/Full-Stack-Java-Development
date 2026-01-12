package Types_Of_Statement;

/*
 * =============================================================================
 *                 JDBC CALLABLESTATEMENT (IN DETAIL)
 * =============================================================================
 *
 * CallableStatement is used to CALL STORED PROCEDURES
 * from Java application.
 *
 * Package:
 *   java.sql
 *
 * CallableStatement is a CHILD of PreparedStatement.
 *
 * =============================================================================
 * JDBC HIERARCHY POSITION
 * =============================================================================
 *
 * java.sql.Statement
 *        |
 *        v
 * java.sql.PreparedStatement
 *        |
 *        v
 * java.sql.CallableStatement
 *
 * =============================================================================
 * WHAT IS A STORED PROCEDURE?
 * =============================================================================
 *
 * A Stored Procedure is:
 * - A set of SQL statements
 * - Stored inside the DATABASE
 * - Executed using a single call
 *
 * =============================================================================
 * WHY STORED PROCEDURES?
 * =============================================================================
 *
 * ✔ Faster execution
 * ✔ Business logic at DB level
 * ✔ Secure
 * ✔ Reusable
 *
 * =============================================================================
 * CALLABLESTATEMENT SYNTAX
 * =============================================================================
 *
 * { call procedure_name(?, ?, ?) }
 *
 * =============================================================================
 */

import java.sql.*;

public class CallableStatement_Detailed {

    private static final String URL  = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static void main(String[] args) {

        callProcedureWithIN();
        callProcedureWithOUT();
    }

    /*
     * =============================================================================
     * STORED PROCEDURE USED (MYSQL)
     * =============================================================================
     *
     * CREATE PROCEDURE insertStudent(
     *   IN sid INT,
     *   IN sname VARCHAR(50),
     *   IN sbranch VARCHAR(50)
     * )
     * BEGIN
     *   INSERT INTO student VALUES (sid, sname, sbranch);
     * END;
     *
     * =============================================================================
     */

    public static void callProcedureWithIN() {

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             CallableStatement cs =
                     con.prepareCall("{ call insertStudent(?, ?, ?) }")) {

            cs.setInt(1, 301);
            cs.setString(2, "Suresh");
            cs.setString(3, "ECE");

            cs.execute();

            System.out.println("Stored Procedure executed (IN parameters)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * =============================================================================
     * STORED PROCEDURE WITH OUT PARAMETER
     * =============================================================================
     *
     * CREATE PROCEDURE getStudentCount(OUT total INT)
     * BEGIN
     *   SELECT COUNT(*) INTO total FROM student;
     * END;
     *
     * =============================================================================
     */

    public static void callProcedureWithOUT() {

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             CallableStatement cs =
                     con.prepareCall("{ call getStudentCount(?) }")) {

            /*
             * Register OUT parameter
             */

            cs.registerOutParameter(1, Types.INTEGER);

            cs.execute();

            int total = cs.getInt(1);

            System.out.println("Total Students: " + total);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
 * =============================================================================
 * COMPARISON (VERY IMPORTANT 🔥)
 * =============================================================================
 *
 * | Feature            | Statement | PreparedStatement | CallableStatement |
 * |--------------------|----------|------------------|------------------|
 * | Query Type         | Static   | Dynamic          | Stored Procedure |
 * | SQL Injection Safe | ❌ No    | ✅ Yes           | ✅ Yes           |
 * | Performance        | Slow     | Fast             | Fastest          |
 * | Used in Projects   | ❌ No    | ✅ Yes           | ✅ Yes (DB logic)|
 *
 * =============================================================================
 * WHEN TO USE CALLABLESTATEMENT?
 * =============================================================================
 *
 * ✔ When logic exists in DB
 * ✔ When using stored procedures
 * ✔ Banking / Enterprise systems
 *
 * =============================================================================
 * INTERVIEW QUESTIONS
 * =============================================================================
 *
 * Q1. CallableStatement is child of which interface?
 * → PreparedStatement
 *
 * Q2. Why stored procedures are faster?
 * → Precompiled at DB level
 *
 * Q3. How do you get OUT parameter?
 * → registerOutParameter()
 *
 * =============================================================================
 */
