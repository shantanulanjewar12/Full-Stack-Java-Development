/*
 * =============================================================================
 *                      JDBC BEST PRACTICES (IN DETAIL)
 * =============================================================================
 *
 * These are REAL-WORLD rules followed in:
 * - Production applications
 * - Spring Boot / Hibernate projects
 * - Enterprise systems
 *
 * Interviewers EXPECT you to know these.
 *
 * =============================================================================
 * 1️⃣ ALWAYS USE PREPAREDSTATEMENT
 * =============================================================================
 *
 * ✔ Prevents SQL Injection
 * ✔ Improves performance
 * ✔ Allows dynamic parameters
 *
 * NEVER use Statement in real projects.
 *
 * =============================================================================
 * 2️⃣ USE TRY-WITH-RESOURCES
 * =============================================================================
 *
 * try-with-resources automatically closes:
 * - Connection
 * - Statement
 * - ResultSet
 *
 * Prevents:
 * - Memory leaks
 * - Connection leaks
 *
 * =============================================================================
 * 3️⃣ CLOSE JDBC RESOURCES PROPERLY
 * =============================================================================
 *
 * Correct closing order:
 * ResultSet → Statement → Connection
 *
 * =============================================================================
 * 4️⃣ USE TRANSACTIONS FOR CRITICAL OPERATIONS
 * =============================================================================
 *
 * Use commit & rollback for:
 * - Banking
 * - Payments
 * - Order processing
 *
 * =============================================================================
 * 5️⃣ DO NOT HARD-CODE DATABASE CREDENTIALS
 * =============================================================================
 *
 * ❌ BAD PRACTICE:
 * String password = "root";
 *
 * ✔ GOOD PRACTICE:
 * - properties file
 * - environment variables
 *
 * =============================================================================
 * 6️⃣ USE DAO PATTERN
 * =============================================================================
 *
 * DAO = Data Access Object
 *
 * Purpose:
 * - Separate DB logic from business logic
 *
 * Example:
 * Controller → Service → DAO → Database
 *
 * =============================================================================
 * 7️⃣ HANDLE EXCEPTIONS PROPERLY
 * =============================================================================
 *
 * ✔ Catch SQLException
 * ✔ Log error messages
 * ❌ Do NOT show DB errors to users
 *
 * =============================================================================
 * 8️⃣ USE CONNECTION POOLING
 * =============================================================================
 *
 * Creating DB connections is expensive.
 *
 * Use:
 * - HikariCP
 * - Apache DBCP
 *
 * (Used automatically in Spring Boot)
 *
 * =============================================================================
 * 9️⃣ WRITE CLEAN & READABLE SQL
 * =============================================================================
 *
 * ✔ Use meaningful table/column names
 * ✔ Avoid SELECT *
 *
 * =============================================================================
 * 10️⃣ VALIDATE USER INPUT
 * =============================================================================
 *
 * Prevent:
 * - SQL Injection
 * - Invalid data
 *
 * =============================================================================
 */

public class JDBC_Best_Practices_Detailed {

    public static void main(String[] args) {

        System.out.println("Follow JDBC Best Practices for clean, secure code!");
    }
}

/*
 * =============================================================================
 * INTERVIEW QUESTIONS (VERY IMPORTANT)
 * =============================================================================
 *
 * Q1. Why PreparedStatement is preferred over Statement?
 * Q2. What is try-with-resources?
 * Q3. Why transactions are important?
 * Q4. What is DAO pattern?
 * Q5. What is connection pooling?
 *
 * =============================================================================
 */
