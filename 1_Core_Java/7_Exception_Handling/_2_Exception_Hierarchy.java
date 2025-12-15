/**
 * ============================================================
 * FILE NAME  : _2_Exception_Hierarchy.java
 * PACKAGE    : ExceptionHandling
 * TOPIC      : Exception Hierarchy in Java
 * ============================================================
 *
 * =========================
 * 1. ROOT CLASS
 * =========================
 *
 * java.lang.Object
 *        |
 *    java.lang.Throwable
 *        |
 *  -----------------------
 *  |                     |
 * Error               Exception
 *
 * =========================
 * 2. Throwable
 * =========================
 * Parent class for ALL errors and exceptions.
 *
 * Methods available:
 * - getMessage()
 * - printStackTrace()
 * - toString()
 *
 * =========================
 * 3. ERROR
 * =========================
 * - Serious problems
 * - Cannot be handled or recovered
 * - Caused by JVM
 *
 * Examples:
 * - OutOfMemoryError
 * - StackOverflowError
 * - VirtualMachineError
 *
 * ❌ We should NOT handle Errors.
 *
 * =========================
 * 4. EXCEPTION
 * =========================
 * - Conditions that program can handle
 * - Caused by application logic
 *
 * Two types:
 * 1. Checked Exception
 * 2. Unchecked Exception
 *
 * =========================
 * 5. CHECKED EXCEPTION
 * =========================
 * - Checked at COMPILE TIME
 * - Must be handled or declared using throws
 *
 * Examples:
 * - IOException
 * - SQLException
 * - FileNotFoundException
 * - ClassNotFoundException
 *
 * =========================
 * 6. UNCHECKED EXCEPTION
 * =========================
 * - Occur at RUNTIME
 * - NOT checked by compiler
 * - Subclasses of RuntimeException
 *
 * Examples:
 * - NullPointerException
 * - ArithmeticException
 * - ArrayIndexOutOfBoundsException
 *
 * =========================
 * 7. RuntimeException
 * =========================
 * Parent class for all unchecked exceptions.
 *
 * =========================
 * 8. KEY DIFFERENCE
 * =========================
 *
 * Checked  → Compile Time
 * Unchecked → Runtime
 *
 * =========================
 * 9. INTERVIEW QUESTIONS
 * =========================
 *
 * Q1: What is the root class of exception hierarchy?
 * A : Throwable
 *
 * Q2: Difference between Error and Exception?
 * A :
 * Error → JVM related, cannot recover
 * Exception → Application related, can handle
 *
 * Q3: Why RuntimeException is unchecked?
 * A : Because they occur due to programming mistakes.
 *
 * Q4 (Tricky):
 * Should we handle OutOfMemoryError?
 * A : NO
 *
 * Q5:
 * Is NullPointerException checked or unchecked?
 * A : Unchecked
 *
 * Q6:
 * Is FileNotFoundException checked?
 * A : Yes
 * 
 * Q: Why Errors are not handled?
A: Because they indicate JVM-level failure.

Q: Can we catch Throwable?
A: Yes, but NOT recommended.
// why? Because it includes Errors.
// Catching Errors can lead to unstable program state.

Q: Can RuntimeException be caught?
A: Yes (but compiler doesn’t force it).
 *
 * ============================================================
 */

public class _2_Exception_Hierarchy {

    public static void main(String[] args) {

        // Unchecked Exception Example
        int[] arr = {1, 2, 3};

        // JVM creates ArrayIndexOutOfBoundsException
        System.out.println(arr[5]);

        System.out.println("This line will not execute");
    }
}
