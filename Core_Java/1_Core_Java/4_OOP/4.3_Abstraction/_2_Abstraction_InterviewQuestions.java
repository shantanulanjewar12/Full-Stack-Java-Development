/*

This file includes commonly asked interview questions with detailed answers,
examples, MCQs, and coding-based abstraction problems.

===============================================================================
SECTION 1️⃣ — THEORY INTERVIEW QUESTIONS WITH ANSWERS
===============================================================================

1️⃣ Q: What is abstraction in Java?

A: 
Abstraction is an OOP concept used to hide implementation details and show only
essential functionality. It focuses on *what a system does*, not *how* it does it.

Example:
A car has a steering and accelerator (what the user uses) but hides the engine mechanism.

-------------------------------------------------------------------------------

2️⃣ Q: How is abstraction achieved in Java?

A:
Abstraction can be achieved using:

✔ Abstract classes (0–100% abstraction)  
✔ Interfaces (100% abstraction before Java 8, modern interfaces allow default, static, and private methods)

-------------------------------------------------------------------------------

3️⃣ Q: What is the difference between abstraction and encapsulation?

A:
| Feature | Abstraction | Encapsulation |
|--------|------------|---------------|
| Purpose | Hide implementation | Protect data |
| Usage | Implemented using abstract classes/interfaces | Implemented using private variables + getters/setters |
| Focus | *What* object does | *How* data is stored and accessed |

-------------------------------------------------------------------------------

4️⃣ Q: Can we create an object of an abstract class?

A:
❌ No, abstract classes cannot be instantiated.
✔ But we can create reference variables of abstract type.

Example:
Animal a = new Dog();

-------------------------------------------------------------------------------

5️⃣ Q: Can an abstract class have a constructor?

A:
✔ Yes, abstract classes can have constructors.  
They are executed when a child object is created.

-------------------------------------------------------------------------------

6️⃣ Q: Can we declare an abstract method in a normal class?

A:
❌ No. If a class contains even one abstract method, the class must be declared abstract.

-------------------------------------------------------------------------------

7️⃣ Q: Can abstract methods be private or final?

A:
❌ No. Because abstract methods must be overridden, and private/final prevents overriding.

-------------------------------------------------------------------------------

8️⃣ Q: Difference between Abstract Class and Interface?

A:
| Feature | Abstract Class | Interface |
|---------|----------------|-----------|
| Variables | normal, static, final allowed | implicit public static final |
| Methods | abstract + concrete | abstract + default + static (+ private from Java 9) |
| Multiple Inheritance | Not supported | Supported |
| Constructor | Allowed | Not allowed |

-------------------------------------------------------------------------------

9️⃣ Q: When should we use abstraction?

A:
Use abstraction when:

✔ You need a blueprint for subclasses  
✔ You want to enforce certain methods  
✔ You need partial implementation (abstract class)  
✔ You want loose coupling or plugin-like architecture (interfaces)

-------------------------------------------------------------------------------

🔟 Q: Why does Java encourage abstraction?

A:
Because it improves flexibility, reduces dependency, hides complexity, and makes the system scalable.

===============================================================================
SECTION 2️⃣ — MCQs WITH ANSWERS & EXPLANATIONS
===============================================================================

1️⃣ Which of the following supports 100% abstraction?

A) Abstract Class  
B) Interface  
C) Constructor  
D) Final Class  

Answer: **B — Interface**  
Explanation: Before Java 8, interfaces offered 100% abstraction.

-------------------------------------------------------------------------------

2️⃣ Can an interface contain a constructor?

A) Yes  
B) No  

Answer: **B — No**  
Explanation: Interfaces cannot be instantiated, so constructors are meaningless.

-------------------------------------------------------------------------------

3️⃣ What happens if a class does not implement all abstract methods?

A) Compiler error  
B) It becomes abstract  
C) JVM handles it  
D) Nothing happens  

Answer: **B — It becomes abstract**

-------------------------------------------------------------------------------

4️⃣ Can abstract methods be static?

Answer: ❌ No.  
Because static methods belong to class, while abstract methods require overriding.

-------------------------------------------------------------------------------

5️⃣ Default methods in interface were introduced in:

A) Java 5  
B) Java 7  
C) **Java 8**  
D) Java 11  

Correct: **C — Java 8**

===============================================================================
SECTION 3️⃣ — CODING INTERVIEW QUESTIONS
===============================================================================

✔ Question 1: Create an abstract class Shape and implement Circle and Square.

Solution:
*/

abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    double radius;

    Circle(double radius) { this.radius = radius; }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

class Square extends Shape {
    double side;

    Square(double side) { this.side = side; }

    @Override
    double area() {
        return side * side;
    }
}


/*
-----------------------------------------------------------------------------
✔ Question 2: Show how abstract constructors work.
-----------------------------------------------------------------------------
*/

abstract class Vehicle {
    
    Vehicle() {
        System.out.println("Vehicle constructor called.");
    }

    abstract void start();
}

class Scooter extends Vehicle {
    @Override
    void start() { System.out.println("Scooter started with kick."); }
}


/*
-----------------------------------------------------------------------------
✔ Question 3: Can interfaces provide implementation?
Yes, using default & static methods.
-----------------------------------------------------------------------------
*/

interface Camera {
    void click();

    default void filter() {
        System.out.println("Applying default filter...");
    }
}

class MobileCamera implements Camera {
    public void click() {
        System.out.println("Picture clicked!");
    }
}


public class _2_Abstraction_InterviewQuestions {
    public static void main(String[] args) {

        Shape s1 = new Circle(5);
        Shape s2 = new Square(4);

        System.out.println("Circle Area: " + s1.area());
        System.out.println("Square Area: " + s2.area());

        Scooter sc = new Scooter();
        sc.start();

        MobileCamera mc = new MobileCamera();
        mc.click();
        mc.filter();
    }
}


/*
===============================================================================
📌 OUTPUT (Sample)
--------------------------------
Circle Area: 78.53981633974483
Square Area: 16.0
Vehicle constructor called.
Scooter started with kick.
Picture clicked!
Applying default filter...
===============================================================================

===============================================================================
SECTION 4️⃣ — REAL-WORLD SCENARIO QUESTIONS
===============================================================================

✔ Q: How would abstraction apply in a banking system?

A:
We create an abstract BankAccount class with abstract deposit() and withdraw(),
and subclasses like SavingsAccount or LoanAccount implement details.

✔ Q: Where do we use interfaces in real life?

A:
UPI, JDBC, Drivers, API contracts — implementation may vary but behavior is fixed.

===============================================================================
💡 FINAL TAKEAWAY (INTERVIEW SUMMARY)

👉 "Abstraction hides unnecessary implementation details and exposes only 
essential behavior using abstract classes and interfaces. It improves security, 
maintainability, and scalability of the system."

===============================================================================
END OF NOTES
===============================================================================
*/
