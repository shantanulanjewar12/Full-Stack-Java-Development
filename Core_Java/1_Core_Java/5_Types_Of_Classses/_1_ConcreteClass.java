// ============================================================
// 🔹 _12_ConcreteClass.java
// ============================================================
// Topic: Concrete Class in Java
// Author: Shantanu Lanjewar
// ============================================================

/*
===============================================================================
💡 WHAT IS A CONCRETE CLASS?
===============================================================================
A **concrete class** is a normal, complete class in Java:

✔ We can create an object using **new** keyword  
✔ All its methods have **implementation** (no unimplemented abstract methods)  
✔ It can:
   - implement one or more interfaces  
   - extend an abstract class  
   - extend another concrete class  

Example:
   class Person {   // concrete class
       void walk() { ... }   // has full implementation
   }
   Person p = new Person();  // ✅ allowed

Opposite concept → **Abstract Class** (cannot be instantiated directly)

===============================================================================
🔹 KEY CHARACTERISTICS / RULES OF CONCRETE CLASS
===============================================================================
1️⃣ Can be instantiated using `new` keyword.  
2️⃣ Cannot have abstract methods (otherwise it becomes abstract class).  
3️⃣ Can implement interface(s) and MUST provide implementation for all abstract methods.  
4️⃣ Can extend an abstract class and MUST implement all its abstract methods,  
   otherwise it also has to be declared `abstract`.  
5️⃣ Access modifier for top-level concrete class can be:
   - `public`
   - *default* (package-private → no modifier)  
6️⃣ Concrete class is the **actual working implementation** used in the project.

===============================================================================
🔹 WHERE TO USE A CONCRETE CLASS?
===============================================================================
✔ When you want a **fully usable** class that can be instantiated.  
✔ For **real-world entities**: Person, Employee, Account, Student, Order, etc.  
✔ As final step of abstraction → implementing interfaces / abstract classes.  
✔ In service / business logic layers where behavior is fixed.

===============================================================================
🔹 WHERE NOT TO USE (OR BE CAREFUL)?
===============================================================================
❌ When you want to force **incomplete design** to be completed by subclasses → use abstract class/interface.  
❌ When behavior may vary a lot across many types → start with interface/abstract.  
❌ When you are designing a **framework** or **API contracts** → those are usually interfaces/abstract.

===============================================================================
🔹 SIMPLE CONCRETE CLASS EXAMPLE
===============================================================================
*/

class Person {
    int empId;

    Person(int empId) {
        this.empId = empId;
    }

    public int getEmpId() {
        return empId;
    }

    public void work() {
        System.out.println("Person with empId " + empId + " is working.");
    }
}

/*
===============================================================================
🔹 CONCRETE CLASS IMPLEMENTING AN INTERFACE
===============================================================================
*/

interface Shape {
    void computeArea();  // abstract method (no implementation)
}

class Rectangle implements Shape {   // Concrete class

    private double length;
    private double breadth;

    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    // Must implement interface method
    @Override
    public void computeArea() {
        double area = length * breadth;
        System.out.println("Rectangle Area = " + area);
    }
}

/*
===============================================================================
🔹 CONCRETE CLASS EXTENDING ABSTRACT CLASS
===============================================================================
*/

abstract class Animal {

    String name;

    Animal(String name) {
        this.name = name;
    }

    // abstract method (no body)
    abstract void makeSound();

    // concrete method (has body)
    void sleep() {
        System.out.println(name + " is sleeping...");
    }
}

// Concrete class: must implement all abstract methods
class Dog extends Animal {

    Dog(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Woof! Woof!");
    }
}

/*
===============================================================================
🔹 FINAL CONCRETE CLASS (CANNOT BE EXTENDED)
===============================================================================
*/

final class Constants {
    public static final double PI = 3.14159;

    public static void showInfo() {
        System.out.println("I am a final concrete utility class.");
    }
}

/*
===============================================================================
🔹 LIMITATIONS OF CONCRETE CLASS
===============================================================================
❌ Concrete class is tightly bound to its implementation.
❌ Not suitable for defining high-level contracts (use interfaces instead).
❌ If heavily used directly, it can reduce flexibility and testability.
❌ Harder to change behavior without affecting all usages.

Better Design:
- Use interface/abstract type for reference,
  but provide **concrete implementation** class.

Example:
   Shape s = new Rectangle(10, 20);  // reference = interface, object = concrete
===============================================================================
🔹 MAIN CLASS – DEMO
===============================================================================
*/

public class _1_ConcreteClass {
    public static void main(String[] args) {

        System.out.println("===== Simple Concrete Class (Person) =====");
        Person p = new Person(101);
        p.work();
        System.out.println("EmpId: " + p.getEmpId());

        System.out.println("\n===== Concrete Class implementing Interface (Rectangle) =====");
        Shape s = new Rectangle(5, 4); // interface reference, concrete object
        s.computeArea();

        System.out.println("\n===== Concrete Class extending Abstract Class (Dog) =====");
        Animal a = new Dog("Rocky");   // abstract reference, concrete object
        a.makeSound();
        a.sleep();

        System.out.println("\n===== Final Concrete Class (Constants) =====");
        Constants.showInfo();
        System.out.println("PI = " + Constants.PI);
    }
}

/*
===============================================================================
🔹 CONCRETE CLASS vs ABSTRACT CLASS vs INTERFACE (INTERVIEW VIEW)
===============================================================================

1️⃣ Concrete Class:
   - Fully implemented
   - Can be instantiated
   - Example: new Person()

2️⃣ Abstract Class:
   - May contain abstract + concrete methods
   - Cannot be instantiated directly
   - Example: abstract class Animal

3️⃣ Interface:
   - 100% abstract (before Java 8), now can have default & static methods
   - No instance variables (only public static final constants)
   - Implemented by classes

===============================================================================
🔹 COMMON INTERVIEW QUESTIONS (WITH SHORT ANSWERS)
===============================================================================

Q1️⃣: What is a concrete class in Java?
👉 A class that has complete implementation and can be instantiated using `new`.

------------------------------------

Q2️⃣: Can a concrete class implement an interface?
👉 Yes, and it **must implement all abstract methods** of the interface.

------------------------------------

Q3️⃣: Can a concrete class extend an abstract class?
👉 Yes, but it must implement all abstract methods,
   otherwise it must also be declared abstract.

------------------------------------

Q4️⃣: Is every non-abstract class a concrete class?
👉 Yes. Any class that is not abstract and has full implementation is called concrete.

------------------------------------

Q5️⃣: Can a concrete class be final?
👉 Yes. A final concrete class cannot be extended (e.g., `final class String` in Java).

------------------------------------

Q6️⃣: Why do we use interfaces/abstract classes along with concrete classes?
👉 Interface/abstract define the **contract**, concrete classes give the **implementation**.

------------------------------------

Q7️⃣: Can a concrete class have abstract methods?
👉 ❌ No. If it has even one abstract method, it *must* be declared abstract.

------------------------------------

Q8️⃣: What access modifiers are allowed for top-level concrete class?
👉 `public` or default (package-private, i.e., no modifier).

===============================================================================
🔹 TRICKY INTERVIEW QUESTIONS
===============================================================================

⭐ Q1: If a class implements an interface but does NOT implement all methods,
       and is not declared abstract. What happens?
👉 Compile-time error. It must either:
   - implement all methods, OR
   - be declared abstract.

------------------------------------

⭐ Q2: Can we store a concrete object in an interface reference?
👉 Yes. Example:
      Shape s = new Rectangle(10, 20);
   This enables **polymorphism**.

------------------------------------

⭐ Q3: Is String a concrete class?
👉 Yes, `java.lang.String` is a `final` concrete class.

------------------------------------

⭐ Q4: Which classes in Java are typically concrete?
👉 Most real-world classes like String, ArrayList, HashMap, File, etc.

------------------------------------

⭐ Q5: When designing a library, should you expose concrete classes directly?
👉 Usually expose **interfaces/abstract types** and hide concrete implementations
   to keep flexibility.

===============================================================================
🔹 INTERVIEW SUMMARY (SPOKEN VERSION)
===============================================================================

“A **concrete class** is a fully implemented class that can be instantiated using
the `new` keyword. It can implement interfaces or extend abstract classes but
must provide implementation for all abstract methods. Concrete classes are the
actual working classes used at runtime, whereas interfaces and abstract classes
mainly define contracts and partial implementations. Most real-world classes in
Java, like String or ArrayList, are concrete classes.”

===============================================================================
*/
