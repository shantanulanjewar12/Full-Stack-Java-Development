// =====================================================================
// 🔹 _11_static_keyword.java
// =====================================================================
// Complete Guide to static Keyword in Java
// Author: Shantanu Lanjewar
// =====================================================================

/*
===============================================================================
💡 WHAT IS `static` KEYWORD IN JAVA?
===============================================================================
`static` is a keyword in Java used to create members (variables, methods, blocks,
and nested classes) that belong to the **class itself**, not to objects.

Meaning:
✔ No need to create an object to use static members.
✔ Memory allocated only ONCE per class (in Method Area / Class Area).

Example:
ClassName.staticMember;

===============================================================================
💡 WHY DO WE NEED static?
===============================================================================
✔ To share a common value across all objects (Example: collegeName, PI, tax rate)
✔ To call methods/variables without creating an object
✔ Used in utility/helper methods like Math class
✔ Required for `main()` method execution by JVM

===============================================================================
🔹 WHERE static CAN BE USED?
===============================================================================
| Feature | Allowed |
|---------|---------|
| static variable | ✔ Yes |
| static method | ✔ Yes |
| static block | ✔ Yes |
| static nested class | ✔ Yes |
| static constructor | ❌ No |
| static local variable inside methods | ❌ No |

===============================================================================
*/


// ===============================
// 1️⃣ STATIC VARIABLE (Class-level variable)
// Shared by all objects
// ===============================
class Student {

    int rollNo;                    // instance variable
    static String schoolName = "ABC School"; // static variable (shared)

    Student(int rollNo) {
        this.rollNo = rollNo;
    }

    void show() {
        System.out.println("Roll No: " + rollNo + " | School: " + schoolName);
    }
}


// ===============================
// 2️⃣ STATIC METHOD
// Can be called without creating object
// ===============================
class MathHelper {

    static int square(int num) {
        return num * num;
    }

    // ❌ static method CANNOT access non-static variables directly
    // because non-static belongs to object memory
}


// ===============================
// 3️⃣ STATIC BLOCK
// Executes only once when class is loaded into memory
// ===============================
class Config {

    static {
        System.out.println("Static Block Executed (Configuration Loaded)");
    }

    Config() {
        System.out.println("Constructor Executed");
    }
}


// ===============================
// 4️⃣ STATIC NESTED CLASS
// Can be created without creating outer class object
// ===============================
class Outer {

    static class Inner {
        void display() {
            System.out.println("Inside Static Nested Class");
        }
    }
}


// ===============================
// MAIN CLASS
// ===============================
public class _11_static_keyword {
    static int count = 0;   // static variable

    static void increment() {
        count++;
    }

    public static void main(String[] args) {

        System.out.println("===== Static Variable Example =====");
        Student s1 = new Student(101);
        Student s2 = new Student(102);

        s1.show();
        s2.show();

        System.out.println("\n===== Static Method Example =====");
        System.out.println("Square of 5 = " + MathHelper.square(5));

        System.out.println("\n===== Static Block Example =====");
        new Config();
        new Config(); // static block runs only once!

        System.out.println("\n===== Static Nested Class Example =====");
        Outer.Inner obj = new Outer.Inner();
        obj.display();

        System.out.println("\n===== Static Counter Demo =====");
        increment();
        increment();
        System.out.println("Counter Value = " + count);
    }
}


/*
===============================================================================
🔹 MEMORY FLOW (VERY IMPORTANT)
===============================================================================

STATIC MEMBERS → Stored inside "Method Area / Class Area" of JVM
INSTANCE MEMBERS → Stored inside Heap (per object)

Example:
Student.schoolName → only one memory location
Student.rollNo     → separate for each object

===============================================================================
🔹 IMPORTANT RULES OF static
===============================================================================

✔ static methods can access only:
      ➤ static variables
      ➤ static methods

✔ static methods CANNOT access:
      ❌ instance variables directly
      ❌ this or super keyword

✔ static block executes BEFORE constructor and ONLY once when class loads.

✔ main() method must be static → JVM calls it without object.

===============================================================================
🔹 ADVANTAGES OF static
===============================================================================

✔ Saves memory because only one copy exists  
✔ Faster access (no object creation needed)  
✔ Best for utility/helper, constants, counters  

Examples:
👉 Math.pow(), Math.random()
👉 Collections.sort()

===============================================================================
🔹 DISADVANTAGES OF static
===============================================================================

❌ Cannot use polymorphism completely  
❌ Not flexible (state shared across all objects)  
❌ Difficult to test in large applications  

===============================================================================
🔹 REAL-TIME USE CASES
===============================================================================

✔ Database configuration
✔ Logger class (singleton pattern)
✔ Constants using `final static`
✔ Utility classes: `Arrays`, `Math`, `Collections`

Example:
static final double PI = 3.14159;

===============================================================================
🔹 MOST ASKED INTERVIEW QUESTIONS
===============================================================================

Q1: Why is the main() method static?
👉 Because JVM must call it WITHOUT creating object.

------------------------------------

Q2: Can we override static methods?
👉 No. Because static belongs to class, not instance.

------------------------------------

Q3: Can static methods use `this` or `super`?
👉 No. Because static methods don't belong to objects.

------------------------------------

Q4: When does static block run?
👉 At class loading time → only once.

------------------------------------

Q5: Can static class exist in Java?
👉 Yes, but only nested inside another class (Static Nested Class).

------------------------------------

Q6: Is static method memory shared?
👉 Yes — only one memory copy per class.

------------------------------------

Q7: Can constructor be static?
👉 ❌ No — constructors belong to objects.

------------------------------------

Q8: Can we have multiple static blocks?
👉 ✔ Yes — they run top to bottom order.

===============================================================================
🔹 TRICKY INTERVIEW QUESTIONS
===============================================================================

⭐ Q1: What if we access static variable using object?
Student s = new Student(1);
s.schoolName = "XYZ";
👉 Still modifies class-level value for ALL objects.

------------------------------------

⭐ Q2: If two objects change static variable, what happens?
👉 Last update overwrites previous one (global update).

------------------------------------

⭐ Q3: Does static block execute even without main()?
👉 Yes → when class is loaded (but JVM may throw error afterward).

------------------------------------

⭐ Q4: Can abstract class have static methods?
👉 ✔ Yes. Static methods do not depend on object.

===============================================================================
🔹 INTERVIEW SUMMARY (Speaking Answer)
===============================================================================

“The `static` keyword makes variables and methods belong to the class instead of
an object. Static members are shared across all objects and stored in Method
Area. It helps in memory efficiency and allows access without creating objects.
Static is used in utility methods, constants, and supporting class-level logic.”

===============================================================================
*/
