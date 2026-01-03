/**
 * ============================================================
 * FILE NAME  : _1_Exception_Introduction.java
 * PACKAGE    : ExceptionHandling
 * TOPIC      : Introduction to Exception Handling
 * ============================================================
 *
 * =========================
 * 1. WHAT IS EXCEPTION?
 * =========================
 *
 * Definition:
 * An Exception is an unwanted or unexpected event
 * that occurs during the execution of a program
 * and disrupts the normal flow of the program.
 *
 * 👉 In Java, Exception is an OBJECT.
 *
 * =========================
 * 2. IMPORTANT POINTS
 * =========================
 * ✔ Exception occurs at RUNTIME
 * ✔ Exception is created by JVM
 * ✔ Exception is an object of a class
 * ✔ All exception classes inherit from Throwable
 *
 * =========================
 * 3. WHY EXCEPTION OCCURS?
 * =========================
 * - Dividing by zero
 * - Accessing invalid array index
 * - Accessing null object
 * - File not found
 * - Database connection failure
 *
 * =========================
 * 4. JVM RESPONSIBILITY
 * =========================
 * When exception occurs:
 * 1. JVM creates an exception object
 * 2. JVM stops normal execution
 * 3. JVM searches for exception handler (catch block)
 * 4. If handler found → handled
 * 5. If NOT found → program terminates abnormally
 *
 * =========================
 * 5. WITHOUT EXCEPTION HANDLING
 * =========================
 * - Program crashes
 * - Remaining code never executes
 *
 * =========================
 * 6. REAL WORLD ANALOGY
 * =========================
 * Exception = Accident
 * Handling Exception = Ambulance + Doctor
 *
 * =========================
 * 7. INTERVIEW QUESTIONS
 * =========================
 *
 * Q1: Is Exception an object?
 * A : Yes, every exception is an object created by JVM.
 *
 * Q2: When does exception occur?
 * A : At runtime.
 *
 * Q3: Who creates exception object?
 * A : JVM.
 *
 * Q4: What happens if exception is not handled?
 * A : Program terminates abnormally.
 *
 * Q5 (Tricky):
 * Can a program compile successfully even if it throws exception?
 * A : Yes, compilation and execution are different phases.
 *
 * =========================
 * 8. VERY IMPORTANT NOTE
 * =========================
 * Exception Handling does NOT prevent exception,
 * it only prevents program from abnormal termination.
 *
 * ============================================================
 */

public class _1_Exception_Introduction {

    public static void main(String[] args) {

        System.out.println("Program Started");

        // Example 1: ArithmeticException (Divide by zero)
        int a = 10;
        int b = 0;

        // JVM will create ArithmeticException object here
        int result = a / b;

        // This line will NEVER execute
        System.out.println("Result is: " + result);

        System.out.println("Program Ended");
    }
}
