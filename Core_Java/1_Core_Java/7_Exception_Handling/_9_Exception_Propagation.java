/**
 * ============================================================
 * FILE NAME  : _9_Exception_Propagation.java
 * PACKAGE    : ExceptionHandling
 * TOPIC      : Exception Propagation
 * ============================================================
 *
 * =========================
 * 1. WHAT IS EXCEPTION PROPAGATION?
 * =========================
 * Exception Propagation is the process by which an exception
 * is passed from the method where it occurs to the calling method.
 *
 * If the exception is not handled in the current method,
 * it propagates (moves) up the call stack.
 *
 * =========================
 * 2. CALL STACK FLOW
 * =========================
 *
 * main()
 *   ↓
 * method1()
 *   ↓
 * method2()
 *   ↓
 * method3()  → Exception occurs here
 *
 * =========================
 * 3. JVM BEHAVIOR
 * =========================
 * - JVM searches for matching catch block
 * - Starts from method where exception occurred
 * - Moves upward in call stack
 * - If not found → JVM terminates program
 *
 * =========================
 * 4. IMPORTANT RULE
 * =========================
 * - Unchecked exceptions propagate automatically
 * - Checked exceptions DO NOT propagate unless declared using throws
 *
 * ============================================================
 */

public class _9_Exception_Propagation {

    public static void main(String[] args) {
        System.out.println("Main started");
        method1();
        System.out.println("Main ended"); // will NOT execute
    }

    static void method1() {
        System.out.println("Method1 started");
        method2();
        System.out.println("Method1 ended"); // will NOT execute
    }

    static void method2() {
        System.out.println("Method2 started");
        method3();
        System.out.println("Method2 ended"); // will NOT execute
    }

    static void method3() {
        System.out.println("Method3 started");

        // Unchecked exception
        int result = 10 / 0;  // ArithmeticException

        System.out.println("Method3 ended"); // never executes
    }
}



/*

🧠 OUTPUT (UNHANDLED UNCHECKED EXCEPTION)
Main started
Method1 started
Method2 started
Method3 started
Exception in thread "main" java.lang.ArithmeticException: / by zero


👉 Notice:
No “ended” lines printed → propagation stops execution.



🔥 HANDLING DURING PROPAGATION (IMPORTANT)
Catching exception in calling method
static void method2() {
    try {
        method3();
    } catch (ArithmeticException e) {
        System.out.println("Exception handled in method2");
    }
}


✔ Stops propagation
✔ Program continues normally


🧠 CHECKED EXCEPTION PROPAGATION
❌ WITHOUT throws (Compile-time error)
static void method3() {
    throw new IOException(); // ❌
}

✅ WITH throws
static void method3() throws IOException {
    throw new IOException();
}


Each caller must either:
✔ handle it
✔ or declare throws


//==================================================================================

🎯 INTERVIEW QUESTIONS & ANSWERS

Q1: What is exception propagation?
A: Passing exception from one method to its caller.

Q2: Do unchecked exceptions propagate automatically?
A: ✔ Yes.

Q3: Do checked exceptions propagate automatically?
A: ❌ No, need throws.

Q4: How does JVM search for handler?
A: Bottom to top in call stack.

Q5 (TRICKY): Can propagation be stopped?
A: ✔ Yes, by handling exception.

Q6 (TRICKY): Does finally stop propagation?
A: ❌ No, finally executes but exception still propagates.

Q7: What happens if no handler found?
A: JVM terminates program.


🧪 REAL-WORLD SCENARIO

✔ DAO → Service → Controller
✔ Exception occurs in DAO
✔ Propagates to controller
✔ Handled globally

*/