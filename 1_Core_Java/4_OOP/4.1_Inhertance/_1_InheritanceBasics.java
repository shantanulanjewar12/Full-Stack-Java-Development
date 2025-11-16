/*
👉 Definition:
Inheritance is a mechanism in Java where one class (child/derived/subclass)
can acquire the properties (fields/variables) and behaviors (methods) of 
another class (parent/super/base class).

It represents **IS-A relationship.**
Example: Dog IS-A Animal, Car IS-A Vehicle.

===============================================================================
💡 WHY INHERITANCE?
===============================================================================
- To achieve **code reusability**
- To provide **method overriding** (Runtime Polymorphism)
- To improve **maintainability**
- To avoid redundancy
- To support **OOP hierarchy**

================================================================================
❌ Disadvantages of Inheritance
================================================================================
Tight Coupling
Child depends heavily on parent. Any change in parent may affect all subclasses.
Misuse creates bad hierarchy
If IS-A relationship is weak (like Car extends Employee 😅), design becomes confusing.
Hard to change base class later
Because many subclasses might break.

===============================================================================
💡 IS-A Relationship
===============================================================================
“IS-A relationship in Java represents inheritance. If one class extends another, we say the subclass IS-A superclass. For example, Dog IS-A Animal. The child inherits variables and methods from the parent, leading to code reuse and polymorphism. IS-A should only be used when the relationship makes logical real-world sense. Otherwise, composition (HAS-A) is preferred.”



===============================================================================
💡 BASIC SYNTAX:
===============================================================================

class Parent {
    // fields and methods
}

class Child extends Parent {
    // child-specific fields and methods
}

===============================================================================
💡 SIMPLE EXAMPLE
===============================================================================
*/

class Vehicle {      // Parent Class
    int speed = 60;

    void run() {
        System.out.println("Vehicle is running...");
    }
}

class Car extends Vehicle {  // Child Class
    void display() {
        System.out.println("Car Speed: " + speed);
    }
}

public class _1_InheritanceBasics {
    public static void main(String[] args) {

        Car obj = new Car();
        obj.run();         // inherited method
        obj.display();
    }
}

/*
===============================================================================
💡 OUTPUT:
--------------------------------
Vehicle is running...
Car Speed: 60
===============================================================================

===============================================================================
💡 KEY POINTS ABOUT INHERITANCE
===============================================================================
✔ Inheritance supports "IS-A" relationship.
✔ Child class can access:
    - public members
    - protected members
    - default members (only if in same package)
✔ Child CANNOT access:
    - private members of parent class directly
✔ "super" keyword is used to access parent class variables/methods/constructors.
✔ Constructor is NOT inherited, but can be called using super().
✔ Java supports **Single**, **Multilevel**, and **Hierarchical** inheritance.
✔ Java does NOT support **Multiple inheritance** using classes (because of ambiguity).

===============================================================================
💡 WHAT IS ACCESSIBLE & WHAT IS NOT?
===============================================================================
| Modifier      | Same Class | Same Package | Subclass | Other Package |
|--------------|------------|--------------|----------|---------------|
| private      | YES        | NO           | NO       | NO            |
| default      | YES        | YES          | YES (*)  | NO            |
| protected    | YES        | YES          | YES      | YES (*)       |
| public       | YES        | YES          | YES      | YES           |

(*) = Only through inheritance

===============================================================================
💡 SUPER KEYWORD USES
===============================================================================
1️⃣ To access parent class variable  
2️⃣ To call parent class method  
3️⃣ To call parent class constructor (must be first line)

Example:
super.methodName();
super(variable);
super();

===============================================================================
💡 METHOD OVERRIDING (Supports Polymorphism)
===============================================================================
- Child class provides its own implementation of a parent method.
- Achieved through inheritance.

Example:

class Animal {
    void sound() { System.out.println("Animal sound"); }
}

class Dog extends Animal {
    @Override
    void sound() { System.out.println("Dog barks"); }
}

===============================================================================
💡 ADVANTAGES OF INHERITANCE
===============================================================================
✔ Code reusability
✔ Less redundancy
✔ Faster development
✔ Supports overriding → Polymorphism
✔ Better organization & maintainability

===============================================================================
💡 DISADVANTAGES
===============================================================================
✖ Increased dependency between classes  
✖ Improper use may lead to complex hierarchy  
✖ Changes in parent may affect multiple child classes

===============================================================================
💡 REAL-LIFE EXAMPLE
===============================================================================

class Employee {
    String name;
    double salary;
}

class Developer extends Employee {
    String programmingLanguage;
}

class Manager extends Employee {
    int teamSize;
}

👉 Developer and Manager share common behavior but add their own specialties.

===============================================================================
💡 MOST COMMON INTERVIEW QUESTIONS
===============================================================================
1️⃣ What is inheritance?  
2️⃣ Why do we use inheritance?  
3️⃣ What are the types of inheritance in Java?  
4️⃣ Does Java support multiple inheritance? Why not? (Diamond problem)  
5️⃣ What is IS-A and HAS-A relationship?  
6️⃣ Difference between inheritance and composition?  
7️⃣ What are the access rules in inheritance?  
8️⃣ Are constructors inherited?  
9️⃣ What is the role of `super` keyword?  
🔟 Can we override private, static, or final methods?

===============================================================================
💡 MOST ASKED CONCEPT QUESTIONS
===============================================================================
✔ Why multiple inheritance is not supported?  
✔ Can final class be inherited? (NO)  
✔ Can static methods be overridden? (NO → method hiding)  
✔ Can private members be inherited? (YES but not accessible directly)  
✔ Can constructors be inherited? (NO)

===============================================================================
💡 RESTRICTIONS IN INHERITANCE
===============================================================================
🚫 Cannot extend multiple classes: `class A extends B, C` ❌  
🚫 Cannot inherit final class  
🚫 Cannot override final method  
🚫 Cannot inherit constructor  
🚫 Cannot reduce method visibility while overriding

===============================================================================
💡 BEST PRACTICES
===============================================================================
✔ Use inheritance only if IS-A relationship exists  
✔ Prefer composition (HAS-A) if relationship is not strong  
✔ Keep base class generic and reusable  
✔ Avoid deep inheritance chain (not more than 3–4 levels)

===============================================================================
END OF NOTES
===============================================================================
*/
