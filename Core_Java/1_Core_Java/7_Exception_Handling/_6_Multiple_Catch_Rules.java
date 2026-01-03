/**
 * ============================================================
 * FILE NAME  : _6_Multiple_Catch_Rules.java
 * PACKAGE    : ExceptionHandling
 * TOPIC      : Multiple Catch Blocks & Rules
 * ============================================================
 *
 * =========================
 * 1. WHAT IS MULTIPLE CATCH?
 * =========================
 * - More than one catch block after a try block
 * - Used to handle DIFFERENT exceptions separately
 *
 * Syntax:
 * try {
 *     risky code
 * }
 * catch(Exception1 e) {
 * }
 * catch(Exception2 e) {
 * }
 *
 * =========================
 * 2. WHY MULTIPLE CATCH?
 * =========================
 * - Different exceptions need different handling
 * - Better error messages
 * - Better debugging
 *
 * =========================
 * 3. JVM CATCH MATCHING RULE
 * =========================
 * - JVM checks catch blocks TOP to BOTTOM
 * - First matching catch block is executed
 * - Remaining catch blocks are ignored
 *
 * =========================
 * 4. MOST IMPORTANT RULE (INTERVIEW)
 * =========================
 * - CHILD exception must be caught BEFORE parent exception
 *
 * Reason:
 * - Parent can catch child exception
 * - Child cannot catch parent exception
 *
 * =========================
 * 5. WRONG ORDER → COMPILE-TIME ERROR
 * =========================
 *
 * catch(Exception e)   ❌
 * catch(ArithmeticException e) ❌
 *
 * =========================
 * 6. CORRECT ORDER
 * =========================
 *
 * catch(ArithmeticException e) ✔
 * catch(Exception e) ✔
 *
 * ============================================================
 */

public class _6_Multiple_Catch_Rules {

    public static void main(String[] args) {

        System.out.println("Program Started");

        // ------------------------------------------------
        // CASE 1: Correct multiple catch order
        // ------------------------------------------------
        try {
            int[] arr = {10, 20, 30};
            System.out.println(arr[5]); // throws ArrayIndexOutOfBoundsException
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index problem handled");
        }
        catch (ArithmeticException e) {
            System.out.println("Arithmetic problem handled");
        }
        catch (Exception e) {
            System.out.println("Generic exception handled");
        }

        System.out.println("--------------------------------");

        // ------------------------------------------------
        // CASE 2: Only parent catch
        // ------------------------------------------------
        try {
            int x = 10 / 0;
            System.out.println(x);
        }
        catch (Exception e) {
            System.out.println("Handled by parent Exception catch");
        }

        System.out.println("--------------------------------");

        // ------------------------------------------------
        // CASE 3: Java 7 Multi-catch (| operator)
        // ------------------------------------------------
        try {
            String s = null;
            System.out.println(s.length());
        }
        catch (NullPointerException | ArithmeticException e) {
            System.out.println("Handled using multi-catch");
        }

        System.out.println("Program Ended Normally");
    }
}


//==========================================================================
/*

🧠 HOW JVM SELECTS CATCH BLOCK (VERY IMPORTANT)

1️⃣ Exception occurs
2️⃣ JVM checks first catch
3️⃣ If match → executes it
4️⃣ If not → checks next
5️⃣ Stops at first matching catch

❌ COMPILE-TIME ERROR EXAMPLES (INTERVIEW FAVORITE)
❌ WRONG ORDER
try {
    int x = 10 / 0;
}
catch (Exception e) {
}
catch (ArithmeticException e) {
}
❌ ERROR:
Unreachable catch block



✅ CORRECT ORDER
catch (ArithmeticException e) {
}
catch (Exception e) {
}



🔥 JAVA 7 MULTI-CATCH (IMPORTANT)
Syntax:
catch (Exception1 | Exception2 e) {
}


Rules:
✔ Exceptions must NOT have parent–child relation
meaning: they should be siblings in hierarchy
ex: IOException | SQLException ✔
✔ Variable e is implicitly final
✔ Cannot reassign e


❌ INVALID MULTI-CATCH
catch (Exception | ArithmeticException e) // ❌
👉 Because Exception is parent of ArithmeticException.



//==========================================================================
🎯 INTERVIEW QUESTIONS & ANSWERS

Q1: Why child exception must be caught first?
A: Parent catch can already handle child exception.

Q2: What happens if parent is caught first?
A: Compile-time error (unreachable catch).

Q3: How JVM chooses catch block?
A: Top-to-bottom, first matching catch.

Q4: Can we have try without catch?
A: Yes, if finally is present.

Q5: Can we have catch without try?
A: ❌ No.

Q6 (TRICKY): Can we catch Throwable?
A: Yes, but NOT recommended.

Q7 (TRICKY): Can we catch Error?
A: Yes, but should NOT.

Q8: When to use multi-catch?
A: When same handling logic is required.


//==========================================================================
🧪 REAL-WORLD USE CASES

✔ API error handling
✔ File + DB exceptions together
✔ Network + IO exceptions
✔ Centralized logging

🔑 KEY TAKEAWAYS (REMEMBER THIS)

✔ Multiple catch improves clarity
✔ Order matters → CHILD FIRST
✔ JVM checks top to bottom
✔ Java 7 introduced multi-catch
✔ Wrong order = compile-time error

*/
