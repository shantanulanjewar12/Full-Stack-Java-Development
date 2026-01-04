/*
 * =============================================================================
 *                      JDBC CRUD OPERATIONS
 * =============================================================================
 *
 * CRUD stands for:
 *
 * C → CREATE  (INSERT)
 * R → READ    (SELECT)
 * U → UPDATE
 * D → DELETE
 *
 * CRUD operations are the CORE of database programming.
 *
 * In real-world applications:
 * - Every backend works on CRUD
 * - JDBC CRUD = foundation for Spring / Hibernate
 *
 * =============================================================================
 * DATABASE TABLE USED
 * =============================================================================
 *
 * Table Name: student
 *
 * CREATE TABLE student (
 *     id INT PRIMARY KEY,
 *     name VARCHAR(50),
 *     age INT
 * );
 *
 * =============================================================================
 * NOTE
 * =============================================================================
 *
 * We use PreparedStatement because:
 * ✔ Secure
 * ✔ Faster
 * ✔ Prevents SQL Injection
 *
 * =============================================================================
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class _3_JDBC_CRUD_Operations {

    // Database details
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {

        // Perform CRUD operations
        insertStudent(101, "Rahul", 21);
        readStudents();
        updateStudentAge(101, 22);
        deleteStudent(101);
    }

    /*
     * =============================================================================
     * CREATE OPERATION (INSERT)
     * =============================================================================
     */

    public static void insertStudent(int id, String name, int age) {

        String insertQuery =
                "INSERT INTO student (id, name, age) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(insertQuery)) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);

            int rows = ps.executeUpdate();
            System.out.println("CREATE → Rows Inserted: " + rows);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     * =============================================================================
     * READ OPERATION (SELECT)
     * =============================================================================
     */

    public static void readStudents() {

        String selectQuery = "SELECT * FROM student";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(selectQuery);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\nREAD → Student Records");

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println(id + " | " + name + " | " + age);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     * =============================================================================
     * UPDATE OPERATION
     * =============================================================================
     */

    public static void updateStudentAge(int id, int newAge) {

        String updateQuery =
                "UPDATE student SET age = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(updateQuery)) {

            ps.setInt(1, newAge);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();
            System.out.println("\nUPDATE → Rows Updated: " + rows);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     * =============================================================================
     * DELETE OPERATION
     * =============================================================================
     */

    public static void deleteStudent(int id) {

        String deleteQuery =
                "DELETE FROM student WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(deleteQuery)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            System.out.println("\nDELETE → Rows Deleted: " + rows);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

/*
 * =============================================================================
 * IMPORTANT INTERVIEW POINTS
 * =============================================================================
 *
 * 1. CRUD operations are core of backend development.
 * 2. executeUpdate() is used for INSERT, UPDATE, DELETE.
 * 3. executeQuery() is used for SELECT.
 * 4. PreparedStatement is preferred for CRUD.
 * 5. try-with-resources automatically closes resources.
 *
 * =============================================================================
 */
