/* 
===============================================================================
📌 _9_StaticKeywordFullConcepts.java
===============================================================================
The `static` keyword in Java belongs to the CLASS, not to the object.

Meaning:
--------
✔ A static variable, method, or block is shared among ALL objects.
✔ No need to create an object to access static members.

Used For:
---------
🔹 Memory optimization  
🔹 Utility methods  
🔹 Shared data  
🔹 Singleton pattern  
🔹 Counter tracking  

===============================================================================
1️⃣ STATIC VARIABLE (Class-Level Variable)
===============================================================================
💡 Meaning:
    - A variable declared with static is common to ALL objects.
    - Created in the Method Area (Class Area) when class loads.

Rules:
-------
✔ Only ONE copy exists in memory.
✔ Shared across all instances.
✔ Can be accessed using:
      ClassName.variableName  (recommended)
      or obj.variableName     (allowed but not preferred)

Example:
---------
*/

class Student {
    
    String name;               // Instance variable (per object)
    static String schoolName;  // Static variable (shared)

    Student(String name) {
        this.name = name;
    }

    void display() {
        System.out.println(name + " studies in " + schoolName);
    }
}

/*
Notebook Summary:
✔ static variable → one copy shared for all objects.
✔ Best for shared data like schoolName, collegeName, companyName.

===============================================================================
2️⃣ STATIC METHOD
===============================================================================
💡 Meaning:
    - Method belongs to class, not object.
    - Can be called WITHOUT creating object.

Rules:
-------
✔ Cannot use `this` or `super`
✔ Can access only:
      - static data
      - static methods
✔ Cannot access instance variables directly

Example:
---------
*/

class MathUtils {

    static int square(int x) {
        return x * x;
    }
}

/*
Notebook Summary:
✔ static method → no object required.
✔ Cannot access instance members directly.

===============================================================================
3️⃣ STATIC BLOCK
===============================================================================
💡 Meaning:
    - Runs automatically when the class loads into JVM.
    - Used for static initialization (e.g., DB config, constants).

Rules:
-------
✔ Executes BEFORE main() and before any object creation.
✔ Can access only static members.

Example:
---------
*/

class AppConfig {

    static String DB_URL;

    // Static block executes during class loading
    static {
        DB_URL = "jdbc:mysql://localhost:3306/testdb";
        System.out.println("Static Block → DB URL initialized.");
    }
}

/*
Notebook Summary:
✔ static block → runs once when class loads.
✔ Used for initializing static data.

===============================================================================
4️⃣ STATIC CLASS (Nested Static Class)
===============================================================================
💡 Static class exists only inside another class.
✔ Cannot access outer class non-static members.

Example:
---------
*/

class Outer {

    int instanceVar = 10;      // normal variable

    static class Inner {
        void show() {
            System.out.println("Inside static inner class");
        }
    }
}

/*
Notebook Summary:
✔ static inner class → behaves like independent class inside another class.

===============================================================================
5️⃣ STATIC IMPORT (Advanced Interview Point)
===============================================================================
💡 Allows importing static members so they can be used without class name.

Example:
---------
import static java.lang.Math.*;

System.out.println(pow(2, 3));  // No need: Math.pow()

Notebook Summary:
✔ static import → shorter code using static members.

===============================================================================
INTERVIEW QUESTIONS & ANSWERS
===============================================================================

❓ Q1: Can static methods be overridden?
--------------------------------------
✔ Answer: No → they are resolved at compile time (method hiding).

Example:
---------
*/

class A {
    static void test() {
        System.out.println("A static method");
    }
}
class B extends A {
    static void test() {  // method hiding (NOT overriding)
        System.out.println("B static method");
    }
}

/*
Short Answer:
✔ Static members belong to class → not object → so cannot participate in Runtime Polymorphism.

----------------------------------------------

❓ Q2: Why can't static methods use 'this' or 'super'?
-----------------------------------------------------
✔ Because `this` & `super` refer to object context.
✔ Static executes without creating object → no object reference exists.

----------------------------------------------

❓ Q3: Where are static members stored? 
-----------------------------------------------------
✔ In Method Area (Class Area / MetaSpace in modern JVM).

----------------------------------------------

❓ Q4: When does static block run?
----------------------------------
✔ During class loading, before main().

----------------------------------------------

❓ Q5: What happens if multiple static blocks exist?
----------------------------------------------------
✔ JVM executes them in order of appearance.

===============================================================================
Practical Demonstration
===============================================================================
*/

public class _14_StaticKeywordFullConcepts {

    static {
        System.out.println("👉 Static block of MAIN class executed FIRST.");
    }

    public static void main(String[] args) {

        System.out.println("\n===== Static Variable Demo =====");
        Student.schoolName = "Sunshine International School";
        Student s1 = new Student("Shantanu");
        Student s2 = new Student("Riya");
        s1.display();
        s2.display();

        System.out.println("\n===== Static Method Demo =====");
        System.out.println("Square of 5: " + MathUtils.square(5));

        System.out.println("\n===== Static Block Demo =====");
        System.out.println("DB URL: " + AppConfig.DB_URL);

        System.out.println("\n===== Static Inner Class Demo =====");
        Outer.Inner inner = new Outer.Inner();
        inner.show();

        System.out.println("\n===== Static Method Hiding Demo =====");
        A.test();
        B.test();
    }
}

/*
===============================================================================
📌 Final Quick Notebook Revision Notes
===============================================================================
✔ static keyword belongs to class, not object.
✔ static variable → one shared copy.
✔ static method → no object needed; cannot use this/super.
✔ static block → runs once during class loading.
✔ static inner class → can exist without outer class object.
✔ static methods cannot be overridden (only hidden).
✔ Used for memory optimization, utility functions, shared constants.

===============================================================================
*/
