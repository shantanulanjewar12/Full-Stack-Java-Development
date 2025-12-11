// ============================================================
// 🔹 _2_AbstractClass.java
// ============================================================
// Topic: Abstract Class in Java
// Author: Shantanu Lanjewar
// ============================================================

/*
===============================================================================
💡 WHAT IS AN ABSTRACT CLASS?
===============================================================================
An **abstract class** in Java is a class that:

✔ Can have **abstract methods** (methods without body)  
✔ Can also have **concrete (normal) methods**  
✔ **Cannot be instantiated** directly (no new AbstractClass())  
✔ Is meant to be **inherited** and **implemented by child classes**

Syntax:
    abstract class ClassName {
        abstract void methodName();     // no body
        void normalMethod() { ... }     // with body
    }

===============================================================================
🔹 WHY DO WE NEED ABSTRACT CLASSES?
===============================================================================
✔ To provide a **base template** or **partial implementation**  
✔ To enforce some **common behavior** across related subclasses  
✔ To define **"what must be done"** (abstract methods) and  
   **"how commonly it is done"** (concrete methods)  

Example Use Cases:
- Vehicle, Shape, Animal, Employee hierarchy
- Frameworks & APIs that define contracts

===============================================================================
🔹 KEY RULES / CHARACTERISTICS OF ABSTRACT CLASS
===============================================================================
1️⃣ Declared using `abstract` keyword.
2️⃣ Can contain:
    - abstract methods
    - concrete methods
    - constructors
    - static methods
    - final methods
    - instance & static variables
3️⃣ Cannot be instantiated directly:
       ❌ AbstractClass obj = new AbstractClass();  // Not allowed
4️⃣ A class with at least **one abstract method** MUST be declared abstract.
5️⃣ An abstract class **may have zero abstract methods** (used to prevent object creation).
6️⃣ Child class must:
    - implement all abstract methods, OR
    - be declared abstract again.
7️⃣ Abstract class can have **any access modifier** (public, protected, default) 
   except `private` at top level.

===============================================================================
🔹 SIMPLE ABSTRACT CLASS EXAMPLE
===============================================================================
*/

abstract class Shape {

    String name;

    Shape(String name) {
        this.name = name;
    }

    // Abstract method → no body
    abstract void computeArea();

    // Concrete method
    void displayName() {
        System.out.println("Shape Name: " + name);
    }
}

/*
===============================================================================
🔹 CONCRETE CLASS EXTENDING ABSTRACT CLASS
===============================================================================
*/

class Circle extends Shape {

    double radius;

    Circle(double radius) {
        super("Circle"); // calling abstract class constructor
        this.radius = radius;
    }

    // Implementing abstract method
    @Override
    void computeArea() {
        double area = Math.PI * radius * radius;
        System.out.println("Circle Area = " + area);
    }
}

class RectangleShape extends Shape {

    double length;
    double breadth;

    RectangleShape(double length, double breadth) {
        super("Rectangle");
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    void computeArea() {
        double area = length * breadth;
        System.out.println("Rectangle Area = " + area);
    }
}

/*
===============================================================================
🔹 ABSTRACT CLASS WITH BOTH ABSTRACT & CONCRETE METHODS
===============================================================================
*/

abstract class Animal {

    String name;

    Animal(String name) {
        this.name = name;
    }

    // Abstract method (must be implemented by subclasses)
    abstract void makeSound();

    // Concrete method (common for all animals)
    void sleep() {
        System.out.println(name + " is sleeping...");
    }
}

class Dog extends Animal {

    Dog(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Woof Woof!");
    }
}

class Cat extends Animal {

    Cat(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Meow Meow!");
    }
}

/*
===============================================================================
🔹 ABSTRACT CLASS USED AS TEMPLATE (Template Method Pattern idea)
===============================================================================
*/

abstract class DataProcessor {

    // Template method (final so child can't override overall process)
    public final void process() {
        readData();
        processData();
        saveData();
    }

    abstract void readData();
    abstract void processData();

    void saveData() {
        System.out.println("Saving processed data to database...");
    }
}

class ExcelDataProcessor extends DataProcessor {

    @Override
    void readData() {
        System.out.println("Reading data from Excel file...");
    }

    @Override
    void processData() {
        System.out.println("Processing Excel data...");
    }
}

/*
===============================================================================
🔹 LIMITATIONS / DISADVANTAGES OF ABSTRACT CLASS
===============================================================================
❌ Cannot be instantiated directly.  
❌ A child class can extend **only one** abstract class (single inheritance).  
❌ Less flexible than interfaces if multiple types are needed.  
❌ Overuse may lead to complex inheritance hierarchies.  

When to prefer INTERFACE over abstract class:
- When you need multiple inheritance of type.
- When you are mainly defining "capabilities" (e.g., Runnable, Serializable).

===============================================================================
🔹 WHERE TO USE ABSTRACT CLASS (BEST SCENARIOS)
===============================================================================
✔ When you have a **base class** with:
    - Common state (fields)
    - Common behavior (methods)
    - Some methods that MUST be implemented by child classes.

✔ When child classes share:
    - Common code
    - Common structure
    but have **different implementations** for certain parts.

Examples:
- Shape (Circle, Rectangle, Triangle)
- Animal (Dog, Cat, Lion)
- Employee (FullTimeEmployee, PartTimeEmployee)

===============================================================================
🔹 WHERE NOT TO USE ABSTRACT CLASS
===============================================================================
❌ When there is NO common state/behavior to share → better use interface.  
❌ When you expect classes to implement **multiple roles/types**.  
❌ For pure contracts / capabilities → interfaces are better.  

===============================================================================
🔹 MAIN CLASS – DEMONSTRATION
===============================================================================
*/

public class _2_AbstractClass {
    public static void main(String[] args) {

        System.out.println("===== Abstract Shape Example =====");
        Shape s1 = new Circle(5);
        s1.displayName();
        s1.computeArea();

        Shape s2 = new RectangleShape(4, 6);
        s2.displayName();
        s2.computeArea();

        System.out.println("\n===== Abstract Animal Example =====");
        Animal dog = new Dog("Bruno");
        dog.makeSound();
        dog.sleep();

        Animal cat = new Cat("Kitty");
        cat.makeSound();
        cat.sleep();

        System.out.println("\n===== Abstract Class as Template (DataProcessor) =====");
        DataProcessor processor = new ExcelDataProcessor();
        processor.process();
    }
}

/*
===============================================================================
🔹 ABSTRACT CLASS vs INTERFACE vs CONCRETE CLASS (QUICK VIEW)
===============================================================================

1️⃣ Abstract Class:
   - Can have abstract + concrete methods
   - Can have state (instance variables)
   - Can have constructors
   - Single inheritance (one parent)
   - Cannot be instantiated

2️⃣ Interface:
   - Before Java 8: only abstract methods
   - After Java 8: abstract + default + static methods
   - Variables are public static final (constants)
   - Supports multiple inheritance of type
   - Cannot be instantiated

3️⃣ Concrete Class:
   - All methods implemented
   - Can be instantiated
   - Actual working class

===============================================================================
🔹 MOST COMMON INTERVIEW QUESTIONS (WITH ANSWERS)
===============================================================================

Q1️⃣: What is an abstract class?
👉 A class that cannot be instantiated and can contain abstract and concrete methods.

------------------------------------

Q2️⃣: Can an abstract class have a constructor?
👉 ✔ Yes. Used to initialize common fields for subclasses.

------------------------------------

Q3️⃣: Can an abstract class have no abstract methods?
👉 ✔ Yes. It can be abstract just to prevent instantiation.

------------------------------------

Q4️⃣: Can we declare an abstract method as final or static?
👉 ❌ final abstract → meaningless (cannot be overridden but must be).  
👉 ❌ static abstract → cannot be overridden polymorphically.  

------------------------------------

Q5️⃣: Can we create a reference of abstract class?
👉 ✔ Yes, but it must refer to concrete subclass object.

Example:
    Shape s = new Circle(5);

------------------------------------

Q6️⃣: If a child does not implement all abstract methods, what happens?
👉 It must be declared `abstract` or else compilation error.

------------------------------------

Q7️⃣: Difference between abstract class and interface (short)?
👉 Abstract class: partial implementation + state.  
   Interface: pure contract / capabilities, supports multiple inheritance.

------------------------------------

Q8️⃣: Why use abstract class instead of interface?
👉 When you want to share common code and state among related subclasses.

===============================================================================
🔹 TRICKY INTERVIEW QUESTIONS
===============================================================================

⭐ Q1: Can abstract classes have static methods?
👉 ✔ Yes. Static methods belong to class, not objects.

------------------------------------

⭐ Q2: Can abstract class implement an interface?
👉 ✔ Yes, but it may choose to **not** implement all methods,
   leaving them abstract for subclasses.

------------------------------------

⭐ Q3: Can we mark an abstract class as final?
👉 ❌ No. Final means cannot be extended; abstract needs to be extended.

------------------------------------

⭐ Q4: What happens if we try to instantiate abstract class using reflection?
👉 Still not allowed – results in InstantiationException.

------------------------------------

⭐ Q5: Can we have main() inside abstract class?
👉 ✔ Yes. Abstract class can have static main() and be executed.

------------------------------------

⭐ Q6: Can abstract method be private?
👉 ❌ No. Private methods are not visible to child classes, 
   so they cannot be overridden.

===============================================================================
🔹 INTERVIEW SUMMARY (SPOKEN VERSION)
===============================================================================

“An abstract class is a partially implemented class that cannot be instantiated
directly. It is used to define a common base for related classes, combining both
abstract methods (which must be implemented by subclasses) and concrete methods
(shared behavior). It’s ideal when multiple subclasses share common state and
behavior but also need to provide their own implementation for specific methods.”

===============================================================================
*/
