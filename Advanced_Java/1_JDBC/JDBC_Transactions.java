/*
 * =============================================================================
 *                         JDBC TRANSACTIONS
 * =============================================================================
 *
 * A Transaction is a group of SQL operations that must be
 * executed as a SINGLE unit.
 *
 * Either:
 *  ✔ All operations succeed (COMMIT)
 * OR
 *  ❌ All operations fail (ROLLBACK)
 *
 * =============================================================================
 * REAL-WORLD EXAMPLE
 * =============================================================================
 *
 * Bank Money Transfer:
 * 1. Debit amount from Account A
 * 2. Credit amount to Account B
 *
 * If ANY step fails → transaction must be rolled back
 *
 * =============================================================================
 * AUTO-COMMIT
 * =============================================================================
 *
 * By default:
 *  - Auto-commit is ENABLED
 *  - Every SQL statement is committed automatically
 *
 * To manage transactions manually:
 *  connection.setAutoCommit(false);
 *
 * =============================================================================
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_Transactions {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {

        Connection connection = null;

        try {

            /*
             * STEP 1: CREATE CONNECTION
             */
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            /*
             * STEP 2: DISABLE AUTO-COMMIT
             */
            connection.setAutoCommit(false);

            /*
             * STEP 3: PREPARED STATEMENTS
             */

            String debitQuery =
                    "UPDATE bank_account SET balance = balance - ? WHERE account_no = ?";

            String creditQuery =
                    "UPDATE bank_account SET balance = balance + ? WHERE account_no = ?";

            PreparedStatement debitPS =
                    connection.prepareStatement(debitQuery);

            PreparedStatement creditPS =
                    connection.prepareStatement(creditQuery);

            /*
             * STEP 4: DEBIT FROM ACCOUNT A
             */

            debitPS.setInt(1, 1000);
            debitPS.setInt(2, 101);

            int debitResult = debitPS.executeUpdate();

            /*
             * STEP 5: CREDIT TO ACCOUNT B
             */

            creditPS.setInt(1, 1000);
            creditPS.setInt(2, 102);

            int creditResult = creditPS.executeUpdate();

            /*
             * STEP 6: CHECK BOTH OPERATIONS
             */

            if (debitResult == 1 && creditResult == 1) {

                connection.commit();
                System.out.println("✅ Transaction COMMITTED successfully!");

            } else {

                connection.rollback();
                System.out.println("❌ Transaction ROLLED BACK!");
            }

        }
        catch (Exception e) {

            /*
             * IF ANY EXCEPTION OCCURS → ROLLBACK
             */

            try {
                if (connection != null) {
                    connection.rollback();
                    System.out.println("❌ Transaction ROLLED BACK due to error!");
                }
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();

        }
        finally {

            /*
             * CLOSE CONNECTION
             */

            try {
                if (connection != null) {
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
 * INTERVIEW IMPORTANT POINTS
 * =============================================================================
 *
 * 1. Auto-commit is enabled by default.
 * 2. setAutoCommit(false) starts transaction.
 * 3. commit() saves changes permanently.
 * 4. rollback() undoes changes.
 * 5. Transactions maintain data consistency.
 *
 * =============================================================================
 */
