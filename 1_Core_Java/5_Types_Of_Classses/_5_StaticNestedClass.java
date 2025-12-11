// ============================================================
// 🔹 _4_1_StaticNestedClass.java
// ============================================================
// Topic: Static Nested Class in Java
// Author: Shantanu Lanjewar
// ============================================================

/*
===============================================================================
💡 WHAT IS A STATIC NESTED CLASS?
===============================================================================
A **static nested class** is a class defined inside another class using 'static'.

Syntax:
    class Outer {
        static class Inner { }
    }

===============================================================================
🔹 KEY PROPERTIES OF STATIC NESTED CLASS
===============================================================================

1️⃣ Does NOT require outer class object  
    Inner inner = new Outer.Inner();   // ✔ Allowed

2️⃣ CANNOT access non-static members of outer class  
    (Because static nested class does NOT have an implicit reference of outer)

3️⃣ CAN access:  
    ✔ static variables  
    ✔ static methods of outer class  

4️⃣ Can have any access modifier →  
    ✔ public  
    ✔ private  
    ✔ protected  
    ✔ default (package-private)

5️⃣ Used when the nested class is related to the outer class but  
    DOES NOT need outer class instance.

===============================================================================
🔹 WHY STATIC NESTED CLASS CANNOT ACCESS INSTANCE VARIABLES?
===============================================================================
Because instance variables belong to an OBJECT,
and static nested class has **no object reference** of the outer class.

Example:
    outerObj.instanceVariable → needs outer object
    static nested class → has NO outerObj reference

===============================================================================
🔹 EXAMPLE 1 — CORRECT Static Nested Class
===============================================================================
*/

class OuterClass {

    int instanceVariable = 10;          // non-static field
    static int classVariable = 20;      // static field

    static class NestedClass {
        public void print() {

            System.out.println("Inside Static Nested Class");

            // Accessing static variable → Allowed
            System.out.println("Static Value: " + classVariable);

            // Accessing instance variable → NOT allowed directly
            // System.out.println(instanceVariable); ❌ Compilation Error

            // Correct way:
            OuterClass obj = new OuterClass();
            System.out.println("Instance Value (via object): " + obj.instanceVariable);
        }
    }
}

/*
===============================================================================
🔹 EXAMPLE 2 — Static Nested Class in Use (Best Practice)
===============================================================================
*/

class MathOperations {

    static int value = 100;

    // Static nested class acts like a helper utility
    static class Adder {
        static int add(int a, int b) {
            return a + b + value; // accessing static field
        }
    }
}

/*
===============================================================================
🔹 MAIN CLASS – DEMONSTRATION
===============================================================================
*/

public class _5_StaticNestedClass {
    public static void main(String[] args) {

        System.out.println("===== Static Nested Class Example =====");
        OuterClass.NestedClass obj = new OuterClass.NestedClass();
        obj.print();

        System.out.println("\n===== Utility-style Static Nested Class =====");
        int result = MathOperations.Adder.add(5, 10);
        System.out.println("Result = " + result);
    }
}

/*
===============================================================================
🔹 ADVANTAGES OF STATIC NESTED CLASS
===============================================================================
✔ No need to create outer class object → saves memory  
✔ Good for grouping helper classes  
✔ Good for encapsulation: keep helper logic inside main class  
✔ More readable structure for large classes  

===============================================================================
🔹 LIMITATIONS
===============================================================================
❌ Cannot access instance variables of outer directly  
❌ Cannot use 'this' or outer.this  
❌ If misused, increases complexity  
❌ Should not be overused for large logic hierarchy  

===============================================================================
🔹 WHEN TO USE STATIC NESTED CLASS?
===============================================================================
✔ When inner class does NOT depend on outer class object  
✔ When inner class is a helper/utility to outer class  
✔ When you want to hide implementation details  

Real Examples:
- Map.Entry inside HashMap  
- ThreadPoolExecutor.Worker inside Executor Framework  

===============================================================================
🔹 WHEN NOT TO USE?
===============================================================================
❌ When inner class needs to modify outer instance variables  
❌ When logic heavily depends on outer object  
❌ When class must be reused separately → use top-level class instead  

===============================================================================
🔹 INTERVIEW QUESTIONS (WITH ANSWERS)
===============================================================================

Q1️⃣ What is static nested class?  
👉 A class inside another class, declared static, that does not depend on outer object.

------------------------------------

Q2️⃣ Can static nested class access outer instance members?  
👉 ❌ No. It can only access static members.

------------------------------------

Q3️⃣ Can we create static nested class object without outer class?  
👉 ✔ Yes:  
       Outer.Inner obj = new Outer.Inner();

------------------------------------

Q4️⃣ Why static nested class cannot directly access instance variables?  
👉 Because it does not have an implicit reference of outer class object.

------------------------------------

Q5️⃣ Can static nested class have static members?  
👉 ✔ Yes, static nested class behaves like a top-level class.

------------------------------------

Q6️⃣ What is difference between static nested class and inner class?  
👉 Static nested class:
     - No outer object needed  
     - Access only static members  
   Inner class:
     - Requires outer object  
     - Can access ALL members of outer  

------------------------------------

Q7️⃣ What are access modifiers allowed for static nested class?  
👉 public, private, protected, default.

------------------------------------

Q8️⃣ Can static nested class be abstract or final?  
👉 ✔ Yes, same as any normal class.

===============================================================================
🔹 TRICKY QUESTIONS
===============================================================================

⭐ Q1: Can static nested class extend outer class?  
👉 ✔ Yes, but rarely useful.

⭐ Q2: Can static nested class implement interface?  
👉 ✔ Yes, like normal classes.

⭐ Q3: Can we write outer.new Inner() for static nested class?  
👉 ❌ No, that is only for non-static inner classes.

⭐ Q4: What happens if static nested class tries to use 'this'?  
👉 Refers to its own instance, **NOT** outer class instance.

===============================================================================
🔹 INTERVIEW SUMMARY (SPOKEN VERSION)
===============================================================================

“A static nested class is a class inside a class that does not need the outer
class object. It can only access static members of the outer class. It is used
for grouping helper classes logically and improving encapsulation. It behaves
similar to a top-level class but is scoped inside the outer class.”

===============================================================================
*/
