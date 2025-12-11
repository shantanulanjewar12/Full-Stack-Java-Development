// ============================================================
// 🔹 _4_2_MemberInnerClass.java
// ============================================================
// Topic: Member Inner Class (Non-Static Nested Class)
// Author: Shantanu Lanjewar
// ============================================================

/*
===============================================================================
💡 WHAT IS MEMBER INNER CLASS?
===============================================================================
A **member inner class** is a NON-static class defined **inside another class**.

Syntax:
    class Outer {
         class Inner { }
    }

This inner class is treated as a *member* of the outer class, just like a field
or method.

===============================================================================
🔹 CHARACTERISTICS / RULES (VERY IMPORTANT)
===============================================================================

1️⃣ Requires an OUTER CLASS OBJECT to create the inner class object  
       Outer.Inner obj = new Outer().new Inner();

2️⃣ Can access **ALL** members of outer class:
       ✔ public  
       ✔ private  
       ✔ protected  
       ✔ default  

3️⃣ Member inner class CAN use:
       ✔ this → refers to inner class instance  
       ✔ OuterClassName.this → refers to outer instance  

4️⃣ Outer class can access inner class members via inner object.

5️⃣ Inner class CANNOT have static members  
       ❌ static int x;   // Not allowed  
   Exception: static final constants allowed  

===============================================================================
🔹 WHEN TO USE MEMBER INNER CLASS?
===============================================================================
✔ When inner class is strongly dependent on outer class  
✔ When inner class logically belongs with outer data  
✔ When we want to access outer instance variables  

Example:
- Engine inside Car  
- Node inside LinkedList  
- Entry inside TreeMap  

===============================================================================
🔹 EXAMPLE 1 — BASIC MEMBER INNER CLASS
===============================================================================
*/

class Outer {

    private int outerValue = 10;  // private member
    String name = "OuterClass";

    class Inner {  // Member Inner Class

        int innerValue = 20;

        void show() {
            System.out.println("Inside Member Inner Class");
            System.out.println("Inner Value: " + innerValue);

            // Accessing outer class members (including private)
            System.out.println("Outer Value: " + outerValue);
            System.out.println("Outer Name: " + name);

            // Referring explicitly to outer object
            System.out.println("Outer object reference: " + Outer.this);
        }
    }

    void displayInner() {
        // Outer class accessing inner class
        Inner in = new Inner();
        System.out.println("Inner value from Outer: " + in.innerValue);
    }
}

/*
===============================================================================
🔹 EXAMPLE 2 — REAL-LIFE EXAMPLE (Car → Engine)
===============================================================================
*/

class Car {

    String model;

    Car(String model) {
        this.model = model;
    }

    class Engine {
        int horsepower;

        Engine(int horsepower) {
            this.horsepower = horsepower;
        }

        void start() {
            // Accessing outer class property
            System.out.println(model + " engine started with " + horsepower + " HP.");
        }
    }
}

/*
===============================================================================
🔹 MAIN CLASS – DEMONSTRATION
===============================================================================
*/

public class _6_MemberInnerClass {
    public static void main(String[] args) {

        System.out.println("===== Member Inner Class Example =====");

        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();   // Creating inner object

        inner.show();

        System.out.println("\n===== Outer Accessing Inner Class =====");
        outer.displayInner();

        System.out.println("\n===== Real-life Example: Car → Engine =====");
        Car car = new Car("BMW");
        Car.Engine engine = car.new Engine(300);
        engine.start();
    }
}

/*
===============================================================================
🔹 ADVANTAGES OF MEMBER INNER CLASS
===============================================================================
✔ Can access ALL outer class members (including private)  
✔ Helps in grouping logically connected classes  
✔ Reduces confusion and improves encapsulation  
✔ Useful for designs where inner class MUST belong to outer class  

===============================================================================
🔹 LIMITATIONS
===============================================================================
❌ Cannot have static members (except static final constants)  
❌ Can increase complexity if used unnecessarily  
❌ Inner class depends heavily on outer class → not reusable  
❌ More memory usage than static nested class  

===============================================================================
🔹 INTERVIEW QUESTIONS (WITH ANSWERS)
===============================================================================

Q1️⃣ What is a member inner class?  
👉 A non-static nested class defined inside another class.

------------------------------------

Q2️⃣ Can inner class access private members of outer class?  
👉 ✔ Yes, Java allows this.

------------------------------------

Q3️⃣ How do we create an object of inner class?  
👉  
    Outer outer = new Outer();
    Outer.Inner inner = outer.new Inner();

------------------------------------

Q4️⃣ Can inner class have static members?  
👉 ❌ No, except static final constants.

------------------------------------

Q5️⃣ Can outer class access inner class members?  
👉 ✔ Yes, via creating inner class object inside outer.

------------------------------------

Q6️⃣ Why must inner class be created from an outer class object?  
👉 Because inner class is tied to outer instance; it holds reference to outer.

------------------------------------

Q7️⃣ Difference between static nested class and member inner class?  
👉 Static nested:
       - No outer object required  
       - Can access only static outer members  
   Member inner:
       - Needs outer object  
       - Can access ALL outer members  

===============================================================================
🔹 TRICKY QUESTIONS
===============================================================================

⭐ Q1: Can member inner class be private?  
👉 ✔ Yes. Outer class controls visibility.

⭐ Q2: Does inner class have reference of outer class?  
👉 ✔ Yes, implicitly stored (Outer.this)

⭐ Q3: Can we declare main() inside inner class?  
👉 ✔ Yes, but unusual.

⭐ Q4: Can inner class extend an outer class?  
👉 ✔ Yes, but rarely used.

⭐ Q5: What happens if inner class and outer class have same variable name?  
👉 Use:
       this.x → inner class variable  
       OuterClassName.this.x → outer class variable  

===============================================================================
🔹 INTERVIEW SUMMARY (SPOKEN VERSION)
===============================================================================

“A member inner class is a non-static class defined inside another class. It
requires an outer object for instantiation and can access all outer class
members, including private fields. It is mainly used when an inner class is
logically dependent on outer class. Static members are not allowed except
constants, and it improves encapsulation by grouping related logic.”

===============================================================================
*/
