/**
 * ============================================================
 * FILE NAME  : _10_Why_Exception_Handling.java
 * PACKAGE    : ExceptionHandling
 * TOPIC      : Why Exception Handling is Required
 * ============================================================
 *
 * =========================
 * 1. WHY DO WE NEED EXCEPTION HANDLING?
 * =========================
 *
 * Without Exception Handling:
 * ❌ Program crashes abruptly
 * ❌ Remaining code never executes
 * ❌ Poor user experience
 * ❌ Difficult debugging
 *
 * With Exception Handling:
 * ✔ Program does not crash
 * ✔ Graceful termination
 * ✔ Proper error message
 * ✔ Clean separation of error handling logic
 *
 * =========================
 * 2. WITHOUT EXCEPTION HANDLING (BAD PRACTICE)
 * =========================
 */

public class _10_Why_Exception_Handling {

    public static void main(String[] args) {

        System.out.println("Program Started");

        // ❌ BAD PRACTICE: No exception handling
        int a = 10;
        int b = 0;

        // JVM crashes here
        // int result = a / b;

        // This line never executes
        // System.out.println("Result: " + result);

        System.out.println("--------------------------------");

        // ✅ GOOD PRACTICE: With exception handling
        try {
            int result = a / b;
            System.out.println("Result: " + result);
        }
        catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        }

        System.out.println("Program Ended Normally");
    }
}




/*

🧠 OUTPUT
Program Started
--------------------------------
Cannot divide by zero
Program Ended Normally


👉 Program continues gracefully




🔥 EXCEPTION HANDLING vs IF-ELSE (INTERVIEW FAVORITE)
❌ WRONG USE (EXCEPTION AS LOGIC)
try {
    int x = Integer.parseInt("abc");
}
catch (Exception e) {
}

✅ CORRECT USE
if (value.matches("\\d+")) {
    int x = Integer.parseInt(value);
}


👉 Rule:
Exception handling is for abnormal conditions, not normal logic.

🔑 BEST PRACTICES (VERY IMPORTANT)

✔ Catch specific exceptions, not generic
✔ Do NOT swallow exceptions (empty catch block ❌)
✔ Log exceptions properly
✔ Use finally or try-with-resources
✔ Create custom exceptions for business rules
✔ Do NOT use exceptions for flow control

❌ COMMON BAD PRACTICES (INTERVIEW TRAPS)
catch (Exception e) {
    // empty
}


❌ Swallows exception → debugging nightmare

catch (Throwable t) {
}


❌ Dangerous → catches JVM errors

🌍 REAL-WORLD ARCHITECTURE (VERY IMPORTANT)
Controller
   ↓
Service
   ↓
DAO
   ↓
Database


✔ Exception occurs in DAO
✔ Propagates upward
✔ Handled globally (Controller / Global Handler)

🎯 INTERVIEW QUESTIONS & ANSWERS
Q1: Why exception handling is required?

A: To prevent abnormal termination and handle runtime issues gracefully.

Q2: Can we avoid exception handling?

A: ❌ No, especially for checked exceptions.

Q3: Is exception handling mandatory?

A: ✔ For checked exceptions only.

Q4: Should we catch Exception or specific exception?

A: Specific exception (best practice).

Q5 (TRICKY):

Is exception handling used for normal flow control?
A: ❌ No.

Q6 (TRICKY):

Does exception handling fix errors?
A: ❌ No, it only handles them gracefully.

Q7: What happens if exception is handled?

A: Program continues execution.

Q8: What happens if exception is not handled?

A: Program terminates abnormally.

🧠 ONE-LINE INTERVIEW SUMMARY (VERY POWERFUL)

“Exception handling allows a Java program to handle runtime errors
gracefully, prevent abnormal termination, and separate error-handling
logic from business logic.”


*/