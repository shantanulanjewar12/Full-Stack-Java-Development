/*
 * =============================================================================
 *                            JDBC ARCHITECTURE
 * =============================================================================
 *
 * JDBC Architecture explains HOW a Java application communicates
 * with a database internally.
 *
 * It defines the FLOW of execution from Java code to Database.
 *
 * =============================================================================
 * BASIC IDEA
 * =============================================================================
 *
 * Java Application DOES NOT directly talk to the Database.
 *
 * Communication happens through:
 *   Java Application
 *        |
 *        v
 *     JDBC API
 *        |
 *        v
 *   JDBC Driver
 *        |
 *        v
 *     Database
 *
 * =============================================================================
 * JDBC ARCHITECTURE DIAGRAM (TEXT FORMAT)
 * =============================================================================
 *
 *  +-------------------+
 *  | Java Application  |
 *  +-------------------+
 *            |
 *            v
 *  +-------------------+
 *  |     JDBC API      |  ← java.sql, javax.sql
 *  +-------------------+
 *            |
 *            v
 *  +-------------------+
 *  |   JDBC Driver     |  ← MySQL / Oracle Driver
 *  +-------------------+
 *            |
 *            v
 *  +-------------------+
 *  |     Database      |
 *  +-------------------+
 *
 * =============================================================================
 * MAIN COMPONENTS OF JDBC ARCHITECTURE
 * =============================================================================
 *
 * 1️⃣ Java Application
 * -------------------
 * - Written by developer
 * - Contains business logic
 * - Uses JDBC API to communicate with DB
 *
 * Example:
 *   DriverManager.getConnection()
 *
 * =============================================================================
 *
 * 2️⃣ JDBC API
 * -----------
 * - Part of JDK
 * - Present in:
 *     → java.sql package
 *     → javax.sql package
 *
 * - Provides interfaces and classes:
 *     Connection
 *     Statement
 *     PreparedStatement
 *     ResultSet
 *
 * - Acts as a MEDIATOR between Java and Driver
 *
 * =============================================================================
 *
 * 3️⃣ JDBC Driver
 * ---------------
 * - Vendor specific implementation
 * - Converts JDBC calls into DB-specific calls
 *
 * Example:
 *   MySQL Driver → com.mysql.cj.jdbc.Driver
 *
 * - Without driver → JDBC cannot work
 *
 * =============================================================================
 *
 * 4️⃣ Database
 * ------------
 * - Stores data permanently
 * - Examples:
 *     MySQL
 *     Oracle
 *     PostgreSQL
 *
 * =============================================================================
 * FLOW OF JDBC EXECUTION (STEP BY STEP)
 * =============================================================================
 *
 * STEP 1:
 * Java application calls JDBC API methods
 *
 * STEP 2:
 * JDBC API forwards request to JDBC Driver
 *
 * STEP 3:
 * JDBC Driver converts request into DB specific format
 *
 * STEP 4:
 * Database executes SQL query
 *
 * STEP 5:
 * Result is sent back to Driver
 *
 * STEP 6:
 * Driver sends result to JDBC API
 *
 * STEP 7:
 * JDBC API returns ResultSet to Java application
 *
 * =============================================================================
 * JDBC ARCHITECTURE WITH MULTIPLE DRIVERS
 * =============================================================================
 *
 * JDBC supports MULTIPLE databases using different drivers.
 *
 * Example:
 *
 * Java Application
 *        |
 *        v
 *     JDBC API
 *      /   \
 *     v     v
 * MySQL   Oracle
 * Driver  Driver
 *     \     /
 *      v   v
 *     Database
 *
 * This makes JDBC DATABASE INDEPENDENT.
 *
 * =============================================================================
 * REAL WORLD EXAMPLE
 * =============================================================================
 *
 * Same Java code can work with:
 *  - MySQL
 *  - Oracle
 *  - PostgreSQL
 *
 * Only DRIVER & URL changes.
 *
 * =============================================================================
 * ADVANTAGES OF JDBC ARCHITECTURE
 * =============================================================================
 *
 * ✔ Database independent
 * ✔ Platform independent
 * ✔ Secure
 * ✔ Scalable
 * ✔ Easy to maintain
 *
 * =============================================================================
 * INTERVIEW IMPORTANT POINTS
 * =============================================================================
 *
 * 1. JDBC API is database independent.
 * 2. JDBC Driver is database specific.
 * 3. JDBC follows layered architecture.
 * 4. JDBC uses DriverManager or DataSource.
 * 5. JDBC allows same code to work with multiple databases.
 *
 * =============================================================================
 */

public class _2_JDBC_Architecture {

    public static void main(String[] args) {

        System.out.println("JDBC Architecture explained successfully!");
    }
}
