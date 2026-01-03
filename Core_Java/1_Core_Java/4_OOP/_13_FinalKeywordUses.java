/*
===============================================================================
📌 _8_FinalKeywordUses.java
===============================================================================
The `final` keyword in Java is used to restrict modification.

It can be applied to:
    1️⃣ final variable  → value cannot be changed
    2️⃣ final method    → method cannot be overridden
    3️⃣ final class     → class cannot be inherited

Very commonly asked in interviews along with:
    ➤ Why is String final in Java?
    ➤ When to use final?
    ➤ Difference between final, finally, finalize

===============================================================================
1️⃣ FINAL VARIABLE (Constant)
===============================================================================
💡 Meaning:
   A variable declared with `final` cannot be reassigned once initialized.

Types of final variables:
    ✔ Local final variable
    ✔ Instance final variable
    ✔ Static final variable (acts like constant → ALL CAPS naming convention)

Rules:
------
✔ Must be assigned ONLY ONCE.
✔ If not initialized at declaration, MUST be initialized in:
   - Constructor (for instance final variables)
   - Static block (for static final variables)

Examples:
----------
*/

class Vehicle {

    final int wheels = 4;               // initialized immediately
    final String brand;                 // initialized in constructor
    static final double PI;             // initialized in static block

    Vehicle() {
        brand = "TATA";                 // allowed since it's first assignment
    }

    static {
        PI = 3.14159;                   // allowed once
    }
}

/*
📝 Important:
wheels = 5; ❌ Compile error
brand = "Tesla"; ❌ (after constructor assignment)

Use Case:
---------
Final variables are used for constants, configuration, IDs, security values.

Notebook Summary:
✔ final variable → value cannot change (constant).
✔ Must be initialized exactly ONCE.
✔ Useful for constants like PI, MAX_SPEED, CONFIG values.

===============================================================================
2️⃣ FINAL METHOD
===============================================================================
💡 Meaning:
   A final method cannot be overridden by subclasses.

Why?
----
To prevent modification of important functionality or business rules.

Example:
---------
*/

class Parent {

    public final void show() {
        System.out.println("Final method → cannot be overridden.");
    }
}

class Child extends Parent {
    // ❌ ERROR: Cannot override final method
    // public void show() { }
}

/*
Use Case:
---------
✔ Used in security-sensitive APIs.
✔ Prevents misuse or tampering in subclasses.

Notebook Summary:
✔ final method → cannot be overridden.
✔ Used to lock behavior in inheritance.

===============================================================================
3️⃣ FINAL CLASS
===============================================================================
💡 Meaning:
   A final class cannot be inherited.

Example:
---------
*/

final class Shape {
    public void draw() {
        System.out.println("Drawing shape...");
    }
}

// ❌ ERROR: Cannot extend final class
// class Square extends Shape { }

/*
Use Case:
---------
✔ To prevent extension where further subclassing makes no sense.
✔ Frequently used in immutable classes like String, Wrapper Classes.

Notebook Summary:
✔ final class → cannot be inherited.
✔ Used to prevent modification or subclassing.

===============================================================================
4️⃣ Why is String Final in Java? (VERY IMPORTANT INTERVIEW QUESTION)
===============================================================================

✔ String is final because:
   1. **Immutability**:
      - Once created, value cannot change.
      - Prevents accidental modification.
      - Supports caching in String Pool.

   2. **Security**
      - Strings are used in sensitive data like:
        - usernames, passwords, file paths, DB URLs
      - Being final prevents malicious subclass overriding methods.

   3. **Performance**
      - Since immutable, JVM can reuse and share String objects (String Pool).
      - Reduces memory usage.

   4. **Thread-safety**
      - Since immutable, Strings are automatically safe to use across threads.

Example:
---------
*/

class TestStringFinal {
    public static void main(String[] args) {

        String s1 = "Hello";
        String s2 = "Hello";

        // both refer to SAME memory due to String immutability
        System.out.println(s1 == s2); // true
    }
}

/*
Notebook Summary (Interview Answer):
✔ String is final to ensure immutability, security, performance optimization,
  and prevent subclassing that could break JVM internals.

===============================================================================
5️⃣ Difference: final vs finally vs finalize  (COMMON INTERVIEW QUESTION)
===============================================================================

| Keyword      | Meaning | Use Case |
|-------------|---------|----------|
| final       | Restricts modification of variable, method, or class | OOP |
| finally     | Block that executes whether exception occurs or not | Exception Handling |
| finalize()  | Method called by GC before object removal (deprecated) | Garbage Collection |

Notebook Summary:
✔ final = restriction  
✔ finally = exception handling block  
✔ finalize = cleanup before GC (deprecated)

===============================================================================
Practical Code Demo
===============================================================================
*/

public class _13_FinalKeywordUses {

    public static void main(String[] args) {

        System.out.println("\n===== Final Variable Demo =====");
        Vehicle v = new Vehicle();
        System.out.println("Wheels: " + v.wheels);
        System.out.println("Brand: " + v.brand);
        System.out.println("PI: " + Vehicle.PI);

        // v.wheels = 6; // ❌ Not allowed

        System.out.println("\n===== Final Method Demo =====");
        Parent p = new Parent();
        p.show();

        System.out.println("\n===== Final Class Demo =====");
        Shape shape = new Shape();
        shape.draw();

        System.out.println("\n===== String Final Concept =====");
        TestStringFinal.main(null);
    }
}

/*
===============================================================================
📌 Final Quick Revision Notes (for notebook)
===============================================================================
✔ final variable → value cannot change (constant) → must be initialized once.
✔ final method   → cannot be overridden → protects logic in inheritance.
✔ final class    → cannot be extended → used for immutable & secure classes.
✔ String is final because of immutability, security, performance, and thread safety.
✔ final ≠ finally ≠ finalize (very common interview confusion).

===============================================================================
*/
