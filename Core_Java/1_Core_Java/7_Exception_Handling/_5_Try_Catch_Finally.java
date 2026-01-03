/**
 * ============================================================
 * FILE NAME  : _5_Try_Catch_Finally.java
 * PACKAGE    : ExceptionHandling
 * TOPIC      : try-catch-finally Block
 * ============================================================
 *
 * =========================
 * 1. WHAT IS TRY BLOCK?
 * =========================
 * - Contains risky code
 * - Code that may throw exception
 * - JVM monitors try block
 *
 * Syntax:
 * try {
 *     risky code
 * }
 *
 * =========================
 * 2. WHAT IS CATCH BLOCK?
 * =========================
 * - Handles exception
 * - Executed only if exception occurs
 * - Must match exception type
 *
 * Syntax:
 * catch(ExceptionType e) {
 *     handling code
 * }
 *
 * =========================
 * 3. WHAT IS FINALLY BLOCK?
 * =========================
 * - Always executes
 * - Used for cleanup code
 * - Executes whether exception occurs or not
 *
 * Examples:
 * - Closing files
 * - Closing DB connections
 * - Releasing resources
 *
 * =========================
 * 4. IMPORTANT RULES
 * =========================
 * ✔ try must have catch OR finally
 * ✔ Multiple catch allowed
 * ✔ finally is optional
 * ✔ Only ONE finally allowed
 * ✔ Order: try → catch → finally
 *
 * ============================================================
 */

public class _5_Try_Catch_Finally {

    public static void main(String[] args) {

        System.out.println("Program Started");

        // -------------------------------------
        // CASE 1: Exception occurs and handled
        // -------------------------------------
        try {
            int a = 10;
            int b = 0; // risky line
            int result = a / b;
            System.out.println("Result: " + result);
        }
        catch (ArithmeticException e) {
            System.out.println("ArithmeticException handled");
        }
        finally {
            System.out.println("Finally block executed (Case 1)");
        }

        System.out.println("----------------------------------");

        // -------------------------------------
        // CASE 2: No exception occurs
        // -------------------------------------
        try {
            int x = 10;
            int y = 2;
            int res = x / y;
            System.out.println("Result: " + res);
        }
        catch (ArithmeticException e) {
            System.out.println("This will not execute");
        }
        finally {
            System.out.println("Finally block executed (Case 2)");
        }

        System.out.println("----------------------------------");

        // -------------------------------------
        // CASE 3: Exception occurs but NOT handled
        // -------------------------------------
        try {
            String s = null;
            System.out.println(s.length());
        }
        finally {
            System.out.println("Finally block executed (Case 3)");
        }

        // Program will terminate after this
        // because exception is not handled
    }
}

//======================================================================

/*
🧠 EXECUTION FLOW (VERY IMPORTANT)
✔ Case 1: Exception occurs & handled
try → exception → catch → finally → normal flow

✔ Case 2: No exception
try → finally → normal flow

❌ Case 3: Exception occurs & NOT handled
try → exception → finally → program terminates


//======================================================================
🔥 MOST IMPORTANT INTERVIEW TOPIC — finally

❓ Does finally always execute?
✔ YES — EXCEPT in ONE case:
System.exit(0);


⚠️ FINALLY vs RETURN (TRICKY)
// Explaination: finally block executes even after return
static int test() {
    try {
        return 10;
    }
    finally {
        return 20;
    }
}
✅ Output:
20
👉 finally overrides return



⚠️ FINALLY vs System.exit()
try {
    System.exit(0);
}
finally {
    System.out.println("Will this execute?");
}
❌ Output:
(nothing)
👉 JVM shuts down immediately.



🎯 INTERVIEW QUESTIONS & ANSWERS
Q1: What is try block?
A: Block containing risky code.

Q2: Can try exist without catch?
A: Yes, if finally is present.

Q3: Can catch exist without try?
A: ❌ No.

Q4: Is finally mandatory?
A: ❌ No.

Q5: How many finally blocks allowed?
A: Only ONE.

Q6 (TRICKY): Does finally execute after return?
A: ✔ Yes.

Q7 (TRICKY): Does finally execute after exception?
A: ✔ Yes.

Q8 (VERY TRICKY): When finally will NOT execute?
A: When System.exit() is called or JVM crashes.

Q9: Why finally is used?
A: To release resources.


//======================================================================
🧪 REAL-WORLD USE CASES

✔ Closing files
✔ Closing DB connections
✔ Unlocking resources
✔ Logging
*/