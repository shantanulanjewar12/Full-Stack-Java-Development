/*

📌 PURPOSE OF THIS FILE:
To clearly understand the differences, similarities, when to use abstract class
or interface, rules, restrictions, advantages, and interview examples.

===============================================================================
📌 INTRODUCTION

Both abstract classes and interfaces are used in Java to achieve **abstraction**,
but they serve different design purposes.

👉 Abstract Class: Partial abstraction (0–100%)
👉 Interface: Full abstraction (100% before Java 8, now supports implementations)

===============================================================================
📌 DEFINITION

✔ Abstract Class:
A class declared with the `abstract` keyword that may contain both abstract
methods (without body) and concrete methods (with body).

✔ Interface:
A reference type that contains abstract methods (by default) and constants.
From Java 8+, interfaces can contain default, static, and private methods.

===============================================================================
📌 SYNTAX DIFFERENCE
*/

abstract class Animal {
    abstract void sound();

    void sleep() {
        System.out.println("Animal is sleeping...");
    }
}

interface Vehicle {
    void start();  // implicitly public abstract

    default void stop() {
        System.out.println("Vehicle stopped.");
    }
}

/*
===============================================================================
📌 IMPLEMENTATION RULES
===============================================================================

🔹 Abstract Class:
✔ Can extend another class
✔ A class extends only ONE abstract class (single inheritance)

🔹 Interface:
✔ A class can implement MULTIPLE interfaces
✔ Supports multiple inheritance (through interfaces)

===============================================================================
📌 FEATURE-WISE COMPARISON TABLE
===============================================================================

| Feature | Abstract Class | Interface |
|--------|----------------|-----------|
| Abstraction Level | 0–100% | (Before Java 8) 100% (After Java 8)  default + static methods allowed |
| Methods | Abstract + Concrete | Abstract + default + static (+ private since Java 9) |
| Variables | Can be non-final, non-static | Always: public static final |
| Constructor | ✔ Allowed | ❌ Not allowed |
| Multiple Inheritance | ❌ No | ✔ Yes |
| Access Modifiers | All allowed | Methods implicitly public |
| Instantiation | ❌ No | ❌ No |
| Keyword Used | extends | implements |

===============================================================================
📌 WHEN TO USE WHAT? (MOST IMPORTANT INTERVIEW POINT)
===============================================================================

✔ Use ABSTRACT CLASS when:
--------------------------------
- You want to provide **some shared/common behavior**
- Object belongs to the **same inheritance family**
- You want constructors, protected members, or non-final variables

Example Use Cases:
✔ Animals hierarchy  
✔ Bank Account base class  
✔ OS-level base class

✔ Use INTERFACE when:
--------------------------------
- You need **multiple inheritance**
- You want a common standard or contract
- You want loose coupling (plug-and-play behavior)

Example Use Cases:
✔ JDBC (Connection interface)
✔ Comparable, Runnable, Serializable
✔ Payment gateway types (UPI, Card, Wallet implement Payment interface)

===============================================================================
📌 EXAMPLE SHOWING BOTH TOGETHER
===============================================================================
*/

abstract class Employee {

    abstract void work();

    void attendance() {
        System.out.println("Employee attendance marked.");
    }
}

interface Payable {
    void processSalary();

    default void leavePolicy() {
        System.out.println("Standard leave policy applied.");
    }
}

class Developer extends Employee implements Payable {

    @Override
    void work() {
        System.out.println("Developer writes and tests code.");
    }

    @Override
    public void processSalary() {
        System.out.println("Salary processed via IT payroll.");
    }
}

public class _4_AbstractClass_vs_Interface_Detailed {
    public static void main(String[] args) {

        Developer d = new Developer();
        d.work();
        d.attendance();
        d.processSalary();
        d.leavePolicy();
    }
}


/*
===============================================================================
📌 OUTPUT:
--------------------------------
Developer writes and tests code.
Employee attendance marked.
Salary processed via IT payroll.
Standard leave policy applied.
===============================================================================

===============================================================================
📌 KEY RULES & BEHAVIOR
===============================================================================

✔ Abstract classes can mix abstraction + implementation  
✔ Interfaces define behavior contract (what must be implemented)  
✔ Private abstract methods are NOT allowed  
✔ Interface supports static & default methods (from Java 8)  
✔ Interface supports private helper methods (from Java 9)

===============================================================================
📌 ADVANTAGES & DISADVANTAGES

✔ ABSTRACT CLASS ADVANTAGES:
- Can contain shared implementation
- Faster runtime (compared to interface default dispatch)
- Can have state (instance variables)

✖ ABSTRACT CLASS LIMITATIONS:
- Does NOT support multiple inheritance

✔ INTERFACE ADVANTAGES:
- Multiple inheritance possible
- Helps in loose coupling
- Best for building plugin-based and multi-behavior systems

✖ INTERFACE LIMITATIONS:
- Variables must be public static final
- Before Java 8, no method implementation support

===============================================================================
📌 MCQs (INTERVIEW FAVORITES)

1️⃣ Can an abstract class have a constructor?
✔ Yes.

2️⃣ Can an interface have a constructor?
❌ No.

3️⃣ Can an interface method be protected?
❌ No — it is implicitly public.

4️⃣ Can an interface have a private method?
✔ Yes (Java 9+), but only to support default/static method reuse.

5️⃣ Can a class extend abstract class AND implement interface?
✔ Yes.

Example:
class Test extends AbstractClass implements Interface {}

===============================================================================
📌 REAL-WORLD ANALOGY

Abstract Class = "Template"
➡ A partially built house where structure exists but details vary

Interface = "Contract"
➡ A rulebook where everyone must follow the same method signatures

===============================================================================
📌 INTERVIEW ANSWER SUMMARY (20 seconds)

"Abstract class is used when we need partial abstraction and shared implementation across related subclasses. It can contain both abstract and concrete methods and can have constructors and state.

Interfaces provide full abstraction and allow multiple inheritance. They define a contract that implementing classes must follow. Modern Java interfaces also support default, static, and private methods."

===============================================================================
END OF NOTES
===============================================================================
*/
