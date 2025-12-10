/*
===============================================================================
📌 FINAL KEYWORD IN JAVA – COMPLETE CODE + EXPLANATION
===============================================================================
final is a NON-ACCESS modifier used to RESTRICT modification.

✅ It can be used with:
    1. Variables  → value (or reference) cannot be changed
    2. Methods    → cannot be overridden
    3. Classes    → cannot be inherited

❌ It CANNOT be used with:
    - Constructors
    - abstract + final together (meaningless)
===============================================================================
*/

class FinalKeywordHelper {
    int value;

    FinalKeywordHelper(int value) {
        this.value = value;
    }
}

// ---------------------------- FINAL CLASS EXAMPLE ----------------------------

/*
 * A final class CANNOT be extended (no inheritance).
 * Real example: java.lang.String is final.
 */
final class FinalClassExample {
    void show() {
        System.out.println("Inside FinalClassExample.show()");
    }
}

/*
// ❌ This would cause a COMPILE-TIME ERROR:
// "Cannot inherit from final 'FinalClassExample'"
class ChildOfFinalClass extends FinalClassExample {
}
*/

// ---------------------------- FINAL METHOD EXAMPLE ---------------------------

class ParentClass {

    /*
     * FINAL METHOD:
     * - Cannot be OVERRIDDEN in child class.
     * - Used when you want to LOCK the implementation.
     */
    final void finalMethod() {
        System.out.println("ParentClass.finalMethod() - This method is final and cannot be overridden.");
    }

    /*
     * NORMAL (NON-FINAL) METHOD:
     * - Can be overridden in subclass.
     */
    void normalMethod() {
        System.out.println("ParentClass.normalMethod() - This CAN be overridden.");
    }
}

class ChildClass extends ParentClass {

    // ❌ Not allowed:
    /*
    @Override
    void finalMethod() {
        System.out.println("Trying to override final method");
    }
    */

    // ✔ Allowed: overriding non-final method
    @Override
    void normalMethod() {
        System.out.println("ChildClass.normalMethod() - Overridden version.");
    }

    // ✔ Also allowed: OVERLOADING final method (same name, different parameters)
    void finalMethod(String msg) {
        System.out.println("Overloaded finalMethod(String): " + msg);
    }
}

// ---------------------------- MAIN DEMO CLASS -------------------------------

public class _12_FinalKeyword_Demo {

    /*
     * FINAL INSTANCE VARIABLE (BLANK FINAL):
     * - Must be initialized in EVERY constructor.
     */
    final int finalInstanceVar;

    /*
     * FINAL STATIC VARIABLE:
     * - Usually used as CONSTANT.
     * - Must be initialized at declaration OR in static block.
     */
    static final double PI;  // static blank final

    static {
        // Initializing static final in STATIC BLOCK
        PI = 3.14159;
    }

    // Constructor – must initialize blank final instance variable
    public _23_FinalKeyword(int value) {
        this.finalInstanceVar = value;
    }

    public static void main(String[] args) {

        System.out.println("========= 1. FINAL WITH LOCAL VARIABLES =========");
        demoFinalLocalVariables();

        System.out.println("\n========= 2. FINAL INSTANCE & STATIC VARIABLES =========");
        demoFinalInstanceAndStaticVariables();

        System.out.println("\n========= 3. FINAL REFERENCE VARIABLES (OBJECTS) =========");
        demoFinalReferenceVariables();

        System.out.println("\n========= 4. FINAL METHODS =========");
        demoFinalMethods();

        System.out.println("\n========= 5. FINAL CLASSES =========");
        demoFinalClassUsage();

        System.out.println("\n========= 6. INVALID USES OF FINAL (IN COMMENTS) =========");
        explainInvalidUses();
    }

    // -------------------------------------------------------------------------
    // 1. FINAL WITH LOCAL VARIABLES
    // -------------------------------------------------------------------------
    static void demoFinalLocalVariables() {
        /*
         * A final LOCAL variable:
         * - Must be assigned exactly ONCE.
         * - After assignment, its VALUE CANNOT be changed.
         */

        final int x = 10;
        System.out.println("final local variable x = " + x);

        // ❌ Not allowed: x = 20;  // Compile-time error

        /*
         * BLANK FINAL LOCAL VARIABLE:
         * - Declared final, but initialized later (only once).
         */
        final int y;
        y = 100; // ✔ allowed (FIRST and ONLY assignment)

        System.out.println("blank final local variable y = " + y);

        // ❌ Not allowed: y = 200; // Compile-time error
    }

    // -------------------------------------------------------------------------
    // 2. FINAL INSTANCE & STATIC VARIABLES
    // -------------------------------------------------------------------------
    static void demoFinalInstanceAndStaticVariables() {

        /*
         * finalInstanceVar is a FINAL INSTANCE VARIABLE.
         * - It is initialized in the constructor.
         * - Different objects can have different values.
         * - But for each object, once set, it cannot be changed.
         */

        _12_FinalKeyword_Demo obj1 = new _12_FinalKeyword_Demo(10);
        _12_FinalKeyword_Demo obj2 = new _12_FinalKeyword_Demo(20);

        System.out.println("obj1.finalInstanceVar = " + obj1.finalInstanceVar);
        System.out.println("obj2.finalInstanceVar = " + obj2.finalInstanceVar);

        // ❌ Not allowed:
        // obj1.finalInstanceVar = 30; // Compile-time error

        /*
         * PI is a FINAL STATIC VARIABLE (constant):
         * - Shared by all objects of the class.
         * - Value is same everywhere and CANNOT BE CHANGED.
         */
        System.out.println("Static final PI = " + PI);

        // ❌ Not allowed:
        // PI = 3.14; // Compile-time error
    }

    // -------------------------------------------------------------------------
    // 3. FINAL REFERENCE VARIABLES (OBJECTS & ARRAYS)
    // -------------------------------------------------------------------------
    static void demoFinalReferenceVariables() {
        /*
         * IMPORTANT INTERVIEW POINT:
         * - final with REFERENCE VARIABLES:
         *   → The REFERENCE (address) CANNOT be changed.
         *   → But the OBJECT's INTERNAL STATE CAN be changed.
         */

        final FinalKeywordHelper helper = new FinalKeywordHelper(50);
        System.out.println("Initial helper.value = " + helper.value);

        // ✔ Allowed: modifying internal state (object is NOT final, only reference is final)
        helper.value = 100;
        System.out.println("After modification helper.value = " + helper.value);

        // ❌ Not allowed: changing the reference itself
        // helper = new FinalKeywordHelper(200); // Compile-time error

        // Another example with arrays:
        final int[] arr = {1, 2, 3};
        System.out.print("arr before: ");
        for (int n : arr) System.out.print(n + " ");

        // ✔ Allowed: modify elements
        arr[0] = 10;
        arr[1] = 20;

        System.out.print("\narr after modification: ");
        for (int n : arr) System.out.print(n + " ");

        // ❌ Not allowed: reassigning the array reference
        // arr = new int[]{4, 5, 6}; // Compile-time error
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 4. FINAL METHODS
    // -------------------------------------------------------------------------
    static void demoFinalMethods() {
        ParentClass parent = new ParentClass();
        ChildClass child = new ChildClass();

        System.out.println("Calling finalMethod() on ParentClass:");
        parent.finalMethod();

        System.out.println("Calling finalMethod() on ChildClass (inherited same method):");
        child.finalMethod(); // Same implementation as ParentClass

        System.out.println("Calling normalMethod() on ParentClass:");
        parent.normalMethod();

        System.out.println("Calling normalMethod() on ChildClass (overridden):");
        child.normalMethod();

        System.out.println("Calling overloaded finalMethod(String) on ChildClass:");
        child.finalMethod("This is an OVERLOADED final method (different parameter list).");

        /*
         * NOTE:
         * - finalMethod() (no args) CANNOT be overridden.
         * - But we CAN overload it by changing parameter list.
         */
    }

    // -------------------------------------------------------------------------
    // 5. FINAL CLASSES
    // -------------------------------------------------------------------------
    static void demoFinalClassUsage() {
        /*
         * FinalClassExample is declared FINAL.
         * - We can CREATE OBJECTS of it.
         * - But we CANNOT extend (inherit) it.
         */

        FinalClassExample obj = new FinalClassExample();
        obj.show();

        /*
         * Why use final class?
         * - To prevent inheritance / extension.
         * - To protect implementation from being modified.
         * - For security or design reasons.
         * Example: java.lang.String is final.
         */
    }

    // -------------------------------------------------------------------------
    // 6. INVALID USES OF FINAL (ONLY COMMENTS)
    // -------------------------------------------------------------------------
    static void explainInvalidUses() {

        System.out.println("Check comments in explainInvalidUses() for invalid examples.");

        /*
        // ❌ 1. FINAL CONSTRUCTOR – NOT ALLOWED

        class Sample {
            final Sample() {  // Compile-time error
            }
        }

        Reason:
        - Constructors are NEVER inherited, so 'final' makes no sense.


        // ❌ 2. abstract + final CLASS – NOT ALLOWED

        abstract final class TestClass {  // Compile-time error
        }

        Reason:
        - abstract class is meant to be EXTENDED.
        - final class CANNOT be extended.
        - Both together contradict each other.


        // ❌ 3. abstract + final METHOD – NOT ALLOWED

        abstract class Test2 {
            final abstract void show(); // Compile-time error
        }

        Reason:
        - abstract method MUST be overridden.
        - final method CANNOT be overridden.
        - So this combination is illegal.


        // ❌ 4. Reassigning a final variable – NOT ALLOWED

        void method() {
            final int a = 10;
            a = 20; // Compile-time error
        }
        */
    }
}
