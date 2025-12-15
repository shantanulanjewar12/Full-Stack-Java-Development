/**
 * ============================================================
 * FILE NAME  : _7_Throw_vs_Throws.java
 * PACKAGE    : ExceptionHandling
 * TOPIC      : throw vs throws
 * ============================================================
 *
 * =========================
 * 1. WHAT IS throw?
 * =========================
 * - Used to EXPLICITLY throw an exception
 * - Used inside method or block
 * - Creates exception object manually
 *
 * Syntax:
 * throw new ExceptionType("message");
 *
 * 
 * =========================
 * 2. WHAT IS throws?
 * =========================
 * - Used to DECLARE exception
 * - Used in method signature
 * - Tells caller to handle exception
 *
 * Syntax:
 * method() throws ExceptionType
 * 
 *
 * =========================
 * 3. KEY DIFFERENCE
 * =========================
 *
 * throw  → creates exception
 * throws → declares exception
 *
 * =========================
 * 4. IMPORTANT RULES
 * =========================
 * ✔ throw can throw ONLY ONE exception at a time
 * ✔ throws can declare MULTIPLE exceptions
 * ✔ throw is followed by exception object
 * ✔ throws is followed by exception class names
 *
 * ============================================================
 */

public class _7_Throw_vs_Throws {

    public static void main(String[] args) {

        try {
            validateAge(15);
        }
        catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    // -----------------------------
    // Example using throw
    // -----------------------------
    static void validateAge(int age) {

        if (age < 18) {
            // Explicitly throwing exception
            throw new ArithmeticException("Age must be 18 or above");
        }

        System.out.println("Valid age");
    }
}


// ========================================================================
// 🧠 USING throws (Checked Exception Example)
class Test {

    static void readFile() throws ClassNotFoundException {
        Class.forName("com.fake.Driver");
    }

    public static void main(String[] args) {
        try {
            readFile();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Handled checked exception");
        }
    }
}


// ========================================================================
/*
| Feature            | throw           | throws            |
| ------------------ | --------------- | ----------------- |
| Used to            | Throw exception | Declare exception |
| Used inside        | Method / block  | Method signature  |
| Can throw multiple | ❌ No            | ✅ Yes             |
| Object required    | ✅ Yes           | ❌ No              |
| Checked exception  | Needs handling  | Forces handling   |
| Unchecked exception| Optional handling| Optional handling |


=======================================================================

⚠️ CHECKED vs UNCHECKED WITH throw
❌ WRONG (Checked exception without throws)
throw new Exception(); // Compile-time error

✅ CORRECT
throw new Exception();

void test() throws Exception { }

🔥 OVERRIDING RULES (VERY IMPORTANT)
Rule:

Overriding method CANNOT throw broader checked exception.

class Parent {
    void show() throws IOException {}
}

class Child extends Parent {
    void show() throws FileNotFoundException {} // ✔ narrower
}


❌ Invalid:

void show() throws Exception {} // ❌ broader


//=======================================================================
🎯 INTERVIEW QUESTIONS & ANSWERS

Q1: Difference between throw and throws?
A:
throw → throws exception
throws → declares exception

Q2: Can we throw multiple exceptions using throw?
A: ❌ No.

Q3: Can we declare multiple exceptions using throws?
A: ✔ Yes.

Q4: Can we throw unchecked exception without throws?
A: ✔ Yes.

Q5 (TRICKY): Can main method throw exception?
A: ✔ Yes.

Q6 (TRICKY): Can we throw Error?
A: ✔ Yes, but not recommended.

Q7: What happens if exception is thrown but not handled?
A: Program terminates abnormally.

=======================================================================
🧪 REAL-WORLD USE CASES

✔ Business rule validation
✔ API validation
✔ Authentication failure
✔ Authorization checks


*/