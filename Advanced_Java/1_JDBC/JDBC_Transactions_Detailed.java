/*
 * =============================================================================
 *                    JDBC TRANSACTIONS (COMMIT & ROLLBACK)
 * =============================================================================
 *
 * A TRANSACTION is a group of SQL operations that must be
 * executed as a SINGLE UNIT.
 *
 * RULE:
 *  ✔ Either ALL operations succeed  → COMMIT
 *  ❌ If ANY operation fails        → ROLLBACK
 *
 * =============================================================================
 * WHY TRANSACTIONS ARE IMPORTANT?
 * =============================================================================
 *
 * Used in REAL-WORLD systems:
 * - Banking systems
 * - Online payments
 * - Ticket booking
 * - E-commerce orders
 *
 * Example:
 * Money Transfer
 * 1. Debit money from Account A
 * 2. Credit money to Account B
 *
 * If credit fails → debit must be undone
 *
 * =============================================================================
 * AUTO-COMMIT CONCEPT
 * =============================================================================
 *
 * By DEFAULT:
 *   connection.setAutoCommit(true);
 *
 * That means:
 * - Every SQL statement is saved immediately
 *
 * To control transaction manually:
 *   connection.setAutoCommit(false);
 *
 * =============================================================================
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_Transactions_Detailed {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static void main(String[] args) {

        Connection connection = null;

        try {

            /*
             * =============================================================================
             * STEP 1: CREATE DATABASE CONNECTION
             * =============================================================================
             */

            connection = DriverManager.getConnection(URL, USER, PASS);

            /*
             * =============================================================================
             * STEP 2: DISABLE AUTO-COMMIT
             * =============================================================================
             */

            connection.setAutoCommit(false);

            System.out.println("Auto-commit disabled. Transaction started.");

            /*
             * =============================================================================
             * STEP 3: SQL QUERIES
             * =============================================================================
             *
             * Table: bank_account
             *
             * CREATE TABLE bank_account (
             *   account_no INT PRIMARY KEY,
             *   balance INT
             * );
             */

            String debitQuery =
                    "UPDATE bank_account SET balance = balance - ? WHERE account_no = ?";

            String creditQuery =
                    "UPDATE bank_account SET balance = balance + ? WHERE account_no = ?";

            PreparedStatement debitPS = connection.prepareStatement(debitQuery);
            PreparedStatement creditPS = connection.prepareStatement(creditQuery);

            /*
             * =============================================================================
             * STEP 4: DEBIT FROM ACCOUNT A
             * =============================================================================
             */

            debitPS.setInt(1, 500);   // amount
            debitPS.setInt(2, 101);   // account A

            int debitResult = debitPS.executeUpdate();
            System.out.println("Debit executed.");

            /*
             * =============================================================================
             * STEP 5: CREDIT TO ACCOUNT B
             * =============================================================================
             */

            creditPS.setInt(1, 500);  // amount
            creditPS.setInt(2, 102);  // account B

            int creditResult = creditPS.executeUpdate();
            System.out.println("Credit executed.");

            /*
             * =============================================================================
             * STEP 6: COMMIT OR ROLLBACK DECISION
             * =============================================================================
             */

            if (debitResult == 1 && creditResult == 1) {

                connection.commit();
                System.out.println("✅ Transaction COMMITTED successfully.");

            } else {

                connection.rollback();
                System.out.println("❌ Transaction ROLLED BACK.");
            }

        }
        catch (Exception e) {

            /*
             * =============================================================================
             * IF ANY ERROR OCCURS → ROLLBACK
             * =============================================================================
             */

            try {
                if (connection != null) {
                    connection.rollback();
                    System.out.println("❌ Transaction ROLLED BACK due to exception.");
                }
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();

        }
        finally {

            /*
             * =============================================================================
             * STEP 7: CLOSE CONNECTION
             * =============================================================================
             */

            try {
                if (connection != null) {
                    connection.setAutoCommit(true); // restore default
                    connection.close();
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
 * 1. Auto-commit is ON by default.
 * 2. setAutoCommit(false) starts transaction.
 * 3. commit() saves changes permanently.
 * 4. rollback() undoes all changes in transaction.
 * 5. Transactions maintain DATA CONSISTENCY.
 *
 * =============================================================================
 */
