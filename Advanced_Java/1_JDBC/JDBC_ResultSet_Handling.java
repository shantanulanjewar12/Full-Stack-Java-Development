/*
 * =============================================================================
 *                      JDBC RESULTSET HANDLING (IN DETAIL)
 * =============================================================================
 *
 * ResultSet is an interface that represents the data
 * returned by a SELECT query.
 *
 * Think of ResultSet as:
 * → A virtual table stored in Java memory.
 *
 * =============================================================================
 * IMPORTANT CONCEPT: CURSOR
 * =============================================================================
 *
 * ResultSet uses a CURSOR to point to rows.
 *
 * 👉 When ResultSet is created:
 *     Cursor is positioned BEFORE the first row.
 *
 * That is why we MUST call rs.next()
 *
 * =============================================================================
 * RESULTSET CREATION FLOW
 * =============================================================================
 *
 * Connection → PreparedStatement → executeQuery() → ResultSet
 *
 * =============================================================================
 * TYPES OF RESULTSET
 * =============================================================================
 *
 * 1️⃣ TYPE_FORWARD_ONLY (DEFAULT)
 *    - Cursor moves only forward
 *
 * 2️⃣ TYPE_SCROLL_INSENSITIVE
 *    - Cursor can move forward & backward
 *    - Does NOT reflect DB changes
 *
 * 3️⃣ TYPE_SCROLL_SENSITIVE
 *    - Reflects DB changes
 *
 * =============================================================================
 * RESULTSET CONCURRENCY MODES
 * =============================================================================
 *
 * 1️⃣ CONCUR_READ_ONLY (Default)
 * 2️⃣ CONCUR_UPDATABLE
 *
 * =============================================================================
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBC_ResultSet_Handling {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static void main(String[] args) {

        String query = "SELECT * FROM student";

        /*
         * =============================================================================
         * 1️⃣ DEFAULT RESULTSET (FORWARD ONLY)
         * =============================================================================
         */

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("=== FORWARD ONLY RESULTSET ===");

            while (rs.next()) {

                /*
                 * rs.next()
                 * → Moves cursor to next row
                 * → Returns true if row exists
                 */

                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println(id + " | " + name + " | " + age);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
         * =============================================================================
         * 2️⃣ SCROLLABLE RESULTSET
         * =============================================================================
         */

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(
                     query,
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n=== SCROLLABLE RESULTSET ===");

            // Move cursor to last row
            rs.last();
            System.out.println("Last Row ID: " + rs.getInt("id"));

            // Move cursor to first row
            rs.first();
            System.out.println("First Row Name: " + rs.getString("name"));

            // Move cursor to 2nd row
            rs.absolute(2);
            System.out.println("Second Row Age: " + rs.getInt("age"));

            // Move cursor backward
            rs.previous();
            System.out.println("Previous Row Name: " + rs.getString("name"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
 * =============================================================================
 * IMPORTANT RESULTSET METHODS
 * =============================================================================
 *
 * next()        → Move forward
 * previous()    → Move backward
 * first()       → First row
 * last()        → Last row
 * absolute(n)   → Move to nth row
 * getInt()
 * getString()
 * getDouble()
 *
 * =============================================================================
 * INTERVIEW QUESTIONS
 * =============================================================================
 *
 * Q1. Where does ResultSet cursor start?
 * → Before the first row
 *
 * Q2. Which ResultSet is default?
 * → TYPE_FORWARD_ONLY
 *
 * Q3. Can ResultSet move backward by default?
 * → No
 *
 * =============================================================================
 */
