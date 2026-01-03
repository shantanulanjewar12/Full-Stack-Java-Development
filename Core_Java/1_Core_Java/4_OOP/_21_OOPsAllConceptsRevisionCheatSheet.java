/*
================================================================================
📌 _23_OOPsAllConceptsRevisionCheatSheet.java
================================================================================
This file is a COMPLETE revision of the major OOP concepts:

✔ Class & Object  
✔ Constructor  
✔ this & super keyword  
✔ Memory Areas (Stack, Heap, Method Area)  
✔ Object Creation  
✔ Naming Conventions  
✔ Access Modifiers  
✔ Boxing & Unboxing  
✔ Wrapper Classes  
✔ static keyword  
✔ Object class methods  
✔ final keyword  
✔ Immutable classes  
✔ Inheritance  
✔ Polymorphism  
✔ Abstraction  
✔ Encapsulation  
✔ HAS-A Relationship (Aggregation & Composition)

================================================================================
1️⃣ CLASS & OBJECT
--------------------------------------------------------------------------------
✔ Class → Blueprint/template.
✔ Object → Real instance of class.

Example:
*/
class Car {
    String model;
    void drive() { System.out.println("Car is driving"); }
}

/*
================================================================================
2️⃣ CONSTRUCTOR
--------------------------------------------------------------------------------
✔ Special method called automatically during object creation.
✔ No return type, same name as class.

Types:
✔ Default
✔ Parameterized
✔ Copy Constructor (custom in Java)

*/
class ExampleConstructor {
    ExampleConstructor() { System.out.println("Default constructor"); }
}

 /*
================================================================================
3️⃣ this & super Keyword
--------------------------------------------------------------------------------
✔ this → refers to current object.
✔ super → refers to parent class members.

*/
class Parent {
    int marks = 90;
}
class Child extends Parent {
    int marks = 80;
    void show() {
        System.out.println(this.marks); // Child
        System.out.println(super.marks); // Parent
    }
}

/*
================================================================================
4️⃣ MEMORY AREAS IN JAVA
--------------------------------------------------------------------------------
✔ Stack → method execution + local variables (per thread).
✔ Heap → objects & arrays.
✔ Method Area (MetaSpace) → class info + static data.
✔ PC Register → JVM instruction address.
✔ Native Stack → for JNI.

================================================================================
5️⃣ OBJECT CREATION FLOW
--------------------------------------------------------------------------------
new → memory allocation → constructor → reference assigned.

================================================================================
6️⃣ NAMING CONVENTIONS
--------------------------------------------------------------------------------
✔ Class → PascalCase
✔ variable/method → camelCase
✔ CONSTANTS → UPPER_SNAKE_CASE

================================================================================
7️⃣ ACCESS MODIFIERS
--------------------------------------------------------------------------------
| Modifier   | Class | Package | Subclass | World |
|------------|--------|---------|----------|--------|
| private    | ✔     | ❌      | ❌       | ❌     |
| default    | ✔     | ✔       | ❌       | ❌     |
| protected  | ✔     | ✔       | ✔        | ❌     |
| public     | ✔     | ✔       | ✔        | ✔      |

================================================================================
8️⃣ BOXING & UNBOXING
--------------------------------------------------------------------------------
✔ Boxing → primitive → Wrapper object
✔ Unboxing → Wrapper → primitive

================================================================================
9️⃣ WRAPPER CLASSES
--------------------------------------------------------------------------------
✔ Used for primitive data handling in collections & generics.

================================================================================
🔟 static keyword
--------------------------------------------------------------------------------
✔ static variable → class level (shared)
✔ static method → no object needed
✔ static block → runs during class loading
✔ cannot use this/super inside static methods

================================================================================
1️⃣1️⃣ Object Class Methods
--------------------------------------------------------------------------------
✔ equals() → logical comparison
✔ hashCode() → used in hashing
✔ toString() → string representation
✔ clone() → shallow copy
✔ finalize() → deprecated cleanup method

================================================================================
1️⃣2️⃣ final Keyword
--------------------------------------------------------------------------------
✔ final variable → constant
✔ final method → cannot be overridden
✔ final class → cannot be inherited
✔ String is final → security + performance + immutability

================================================================================
1️⃣3️⃣ Immutable Classes
--------------------------------------------------------------------------------
✔ Object state cannot change once created.
✔ Rules:
   ✔ class final
   ✔ private final fields
   ✔ no setters
   ✔ deep copy in getters if needed

================================================================================
1️⃣4️⃣ OOPs Pillars
================================================================================

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
⚫ INHERITANCE
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
✔ Acquiring parent class properties using `extends`.

Types:
✔ Single
✔ Multilevel
✔ Hierarchical

Rules:
✔ Constructors are not inherited but can be accessed via super().

*/

class Animal {
    void eat() { System.out.println("Eating..."); }
}
class Dog extends Animal {
    void bark() { System.out.println("Barking..."); }
}

/*
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
⚫ POLYMORPHISM
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
✔ Many forms → same method, different behaviors.

Types:
✔ Compile-time → Method Overloading
✔ Runtime → Method Overriding

*/

class PolyDemo {
    void show(int a) {}
    void show(String b) {} // Overloading
}

class ParentPoly {
    void msg() { System.out.println("Parent"); }
}
class ChildPoly extends ParentPoly {
    void msg() { System.out.println("Child"); } // Overriding
}

/*
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
⚫ ABSTRACTION
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
✔ Hiding implementation, showing functionality.

Ways:
✔ abstract classes
✔ interfaces

*/

abstract class VehicleAbstract {
    abstract void start();
}

/*
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
⚫ ENCAPSULATION
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
✔ Binding data + methods and restricting access using private + getters/setters.

*/

class BankAccount {
    private double balance;

    public void deposit(double amt) { balance += amt; }

    public double getBalance() { return balance; }
}

/*
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
⚫ HAS-A RELATIONSHIP
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
✔ Class contains another class.

Types:
1️⃣ Aggregation → weak relationship (independent lifecycle)
2️⃣ Composition → strong relationship (dependent lifecycle)

Aggregation:
*/
class Library {
    Department dept; // can exist independently
}

 // Composition:
class Human {
    private Heart heart = new Heart(); // cannot exist separately
}

/*
================================================================================
💡 FINAL 3-LINE MASTER SUMMARY (WRITE IN NOTEBOOK)
--------------------------------------------------------------------------------
✔ OOP follows real-world modeling using classes and objects.
✔ Major pillars: Inheritance, Polymorphism, Abstraction, Encapsulation.
✔ HAS-A relationships (Aggregation & Composition) allow flexible object structure.

================================================================================
*/

public class _21_OOPsAllConceptsRevisionCheatSheet {
    public static void main(String[] args) {
        System.out.println("✔ This file is a theory-based revision cheat sheet.");
    }
}

