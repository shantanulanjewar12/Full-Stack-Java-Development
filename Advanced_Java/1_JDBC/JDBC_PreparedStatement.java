/*
 * =============================================================================
 *                      JDBC PREPAREDSTATEMENT
 * =============================================================================
 *
 * PreparedStatement is an interface used to execute
 * PRE-COMPILED SQL queries.
 *
 * PreparedStatement is preferred over Statement because:
 *  ✔ More secure
 *  ✔ Faster
 *  ✔ Prevents SQL Injection
 *  ✔ Used in real-world applications
 *
 * =============================================================================
 * STATEMENT vs PREPAREDSTATEMENT
 * =============================================================================
 *
 * Statement:
 *  - SQL compiled every time
 *  - Vulnerable to SQL Injection
 *  - Not secure
 *
 * PreparedStatement:
 *  - SQL compiled once
 *  - Uses placeholders ( ? )
 *  - Secure
 *
 * =============================================================================
 * SQL QUERY WITH PLACEHOLDERS
 * =============================================================================
 *
 * INSERT INTO student (id, name, age) VALUES (?, ?, ?)
 *
 * ? → Placeholder
 *
 * =============================================================================
 * HOW PREPAREDSTATEMENT WORKS
 * =============================================================================
 *
 * Step 1: SQL query is pre-compiled
 * Step 2: Values are set later
 * Step 3: Query is executed
 *
 * =============================================================================
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_PreparedStatement {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            /*
             * =============================================================================
             * STEP 1: LOAD DRIVER
             * =============================================================================
             */

            Class.forName("com.mysql.cj.jdbc.Driver");

            /*
             * =============================================================================
             * STEP 2: CREATE CONNECTION
             * =============================================================================
             */

            connection = DriverManager.getConnection(url, username, password);

            /*
             * =============================================================================
             * STEP 3: CREATE PREPAREDSTATEMENT
             * =============================================================================
             */

            String insertQuery =
                    "INSERT INTO student (id, name, age) VALUES (?, ?, ?)";

            preparedStatement = connection.prepareStatement(insertQuery);

            /*
             * =============================================================================
             * STEP 4: SET VALUES TO PLACEHOLDERS
             * =============================================================================
             */

            preparedStatement.setInt(1, 2);           // id
            preparedStatement.setString(2, "Amit");   // name
            preparedStatement.setInt(3, 22);           // age

            /*
             * =============================================================================
             * STEP 5: EXECUTE QUERY
             * =============================================================================
             */

            int rowsInserted = preparedStatement.executeUpdate();
            System.out.println("Rows Inserted: " + rowsInserted);

            /*
             * =============================================================================
             * SELECT USING PREPAREDSTATEMENT
             * =============================================================================
             */

            String selectQuery = "SELECT * FROM student WHERE age > ?";

            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, 20);

            resultSet = preparedStatement.executeQuery();

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
                if (preparedStatement != null) preparedStatement.close();
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
 * 1. PreparedStatement is pre-compiled.
 * 2. It prevents SQL Injection.
 * 3. Uses placeholders (?).
 * 4. Faster than Statement.
 * 5. Preferred in real-time applications.
 *
 * =============================================================================
 */
