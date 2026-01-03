/*
===============================================================================
🔥 COMPLETE ABSTRACTION MODULE — ONE FILE (Theory + Examples + Q/A + MCQs + Tasks)
===============================================================================

📌 WHAT IS ABSTRACTION?

Abstraction is an OOP concept that hides internal implementation details
and shows only essential features.

👉 Focuses on **WHAT** the object does, not **HOW** it does it.

Real life example:
A car driver uses steering, accelerator, and brakes without understanding
how the engine or transmission works.

===============================================================================
📌 HOW ABSTRACTION IS ACHIEVED IN JAVA?

Java provides abstraction using:

1️⃣ Abstract Classes (0–100% abstraction)
2️⃣ Interfaces (100% abstraction before Java 8, now supports concrete methods too)

===============================================================================
📌 ABSTRACT CLASS — KEY CONCEPTS

An abstract class is a class declared with the `abstract` keyword.
It may contain:

✔ Abstract methods (no implementation)
✔ Concrete methods (with implementation)
✔ Variables (instance + static)
✔ Constructor
✔ Static methods

❌ Cannot be instantiated.

-------------------------------------------------------------------------------
Example:
*/

abstract class Animal {
    abstract void sound(); // abstract method

    void sleep() { // concrete method
        System.out.println("Animal is sleeping...");
    }

    Animal() {
        System.out.println("Animal object created.");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks...");
    }
}

/*
===============================================================================
📌 ABSTRACT METHOD — KEY RULES

An abstract method:

✔ Must be declared in an abstract class or interface
✔ Has no body
✔ Must be overridden in subclass
✔ Cannot be:
   ❌ private
   ❌ static
   ❌ final

Syntax:
abstract void methodName();

-------------------------------------------------------------------------------
Example:
*/

abstract class Appliance {
    abstract void operate();
}

class WashingMachine extends Appliance {
    void operate() { System.out.println("Washing clothes..."); }
}

/*
===============================================================================
📌 INTERFACE + ABSTRACTION

Interfaces achieve full abstraction (before Java 8).
After Java 8, interfaces can contain:

✔ abstract methods  
✔ default methods  
✔ static methods  
✔ private helper methods (Java 9+)

-------------------------------------------------------------------------------
Example:
*/

interface Vehicle {
    void start(); // abstract by default

    default void stop() { System.out.println("Vehicle stopped."); }
}

class Car implements Vehicle {
    public void start() { System.out.println("Car starting..."); }
}

/*
===============================================================================
📌 WHEN TO USE ABSTRACTION?

Use abstraction when:

✔ Multiple subclasses share a common structure but vary in implementation
✔ You want to enforce a contract or rule
✔ You expect future extension of classes (scalability)
✔ Implementation should remain hidden from the user

Examples:
- Payment system (UPI / Card / Wallet)
- Game characters (Attack / Move / Special ability)
- Devices (Laptop / Smartphone / Tablet)

===============================================================================
📌 ABSTRACT CLASS vs INTERFACE (Quick Table)

| Feature | Abstract Class | Interface |
|---------|---------------|-----------|
| Abstraction Level | 0–100% | 100% (before Java 8) |
| Constructor | ✔ Yes | ❌ No |
| Variables | Can be any type | Always public static final |
| Method Types | Abstract + concrete | Abstract + default + static |
| Multiple Inheritance | ❌ No | ✔ Yes |

===============================================================================
📌 ADVANTAGES & LIMITATIONS

✔ Advantages:
- Reduces complexity
- Enforces method implementation
- Reusable design pattern
- Supports polymorphism

✖ Limitations:
- Cannot be instantiated
- Might introduce unnecessary class hierarchy

===============================================================================
📌 OUTPUT FROM MAIN EXAMPLES:
--------------------------------
Animal object created.
Dog barks...
Animal is sleeping...
---------------------------------------------------
Car starting...
Vehicle stopped.
---------------------------------------------------
Washing clothes...

===============================================================================
📌 INTERVIEW QUESTIONS WITH ANSWERS (DETAILED)
===============================================================================

1️⃣ What is abstraction?

Answer:
"Abstraction hides implementation and exposes necessary functionality. It helps
reduce complexity and promotes modularity."

-------------------------------------------------------------------------------

2️⃣ Why do we need abstract classes?

Answer:
"We use abstract classes when multiple subclasses share common structure but
must provide their own implementation for certain behaviors."

-------------------------------------------------------------------------------

3️⃣ Can an abstract class have a constructor?

✔ Yes.
Reason: Used for initializing common fields in subclasses.

-------------------------------------------------------------------------------

4️⃣ Can abstract methods be private or final?

❌ No.

Reason: Abstract methods require overriding, and private/final prevents that.

-------------------------------------------------------------------------------

5️⃣ Can we overload and override abstract methods?

✔ Overloading: YES  
✔ Overriding: YES (mandatory)

-------------------------------------------------------------------------------

6️⃣ Can abstract class have static methods?

✔ Yes, but they cannot be abstract.

-------------------------------------------------------------------------------

7️⃣ Can a class be abstract without abstract methods?

✔ Yes.
Purpose: Prevent instantiation and allow partial implementation.

-------------------------------------------------------------------------------

8️⃣ Abstract class vs Interface — short answer?

"Use abstract class for shared logic and structure; use interface when multiple
inheritance and loose coupling are needed."

===============================================================================
📌 MCQs (WITH ANSWERS)

1️⃣ Which is valid?
A) abstract void test() {}
B) abstract void test();
C) private abstract void test();
D) final abstract void test();

✔ Correct: B

----------------------------------------

2️⃣ Abstract methods can exist in:
A) Class only
B) Interface only
C) Both
D) None

✔ Correct: C

----------------------------------------

3️⃣ Abstract class can contain:
A) Constructor
B) Main method
C) Variables and methods
D) All of the above

✔ Correct: D

===============================================================================
📌 CODING CHALLENGE

Problem:
Create an abstract class Payment with abstract method process(). Implement UPI
and Cash payment classes.

*/

abstract class Payment {
    abstract void process();
}

class UPI extends Payment {
    void process() {
        System.out.println("UPI payment processed.");
    }
}

class Cash extends Payment {
    void process() {
        System.out.println("Cash payment done.");
    }
}

/*
===============================================================================
📌 FINAL INTERVIEW SUMMARY (30 SECONDS)

"Abstraction focuses on exposing essential functionality while hiding implementation.
It is implemented using abstract classes and interfaces. Abstract classes support
shared behavior and partial implementation, while interfaces define a contract
and support multiple inheritance. Abstract methods enforce overriding and enable
runtime polymorphism."

===============================================================================
END OF FILE
===============================================================================
*/
