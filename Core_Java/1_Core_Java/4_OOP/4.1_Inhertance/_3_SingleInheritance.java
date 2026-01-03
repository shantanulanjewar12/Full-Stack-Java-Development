/*
===============================================================================
🧠 SINGLE INHERITANCE IN JAVA — COMPLETE EXPLANATION
===============================================================================

📌 Definition:
Single Inheritance is a type of inheritance in Java where **one child class**
inherits from **one parent class**.

It represents a simple parent–child hierarchy: 
    Child IS-A Parent

Example:
    Dog extends Animal
    Car extends Vehicle

===============================================================================
📌 WHY SINGLE INHERITANCE?
===============================================================================
✔ Reuse methods and fields from parent  
✔ Avoid duplicate code  
✔ Enable method overriding  
✔ Fundamental building block for OOP design  

===============================================================================
📌 BASIC SYNTAX
===============================================================================

class Parent {
    // fields and methods
}

class Child extends Parent {
    // extra features
}

===============================================================================
📌 EXAMPLE PROGRAM — SINGLE INHERITANCE
===============================================================================
*/

class Animal {     // Parent Class
    String name = "Animal";

    void eat() {
        System.out.println("Animal is eating...");
    }
}

class Dog extends Animal {   // Child Class (Single Inheritance)

    void bark() {
        System.out.println("Dog is barking...");
    }
}

public class _3_SingleInheritance {
    public static void main(String[] args) {

        // Creating object of child class
        Dog d = new Dog();

        // Inherited method from Animal
        d.eat();

        // Own method of Dog
        d.bark();

        // Accessing parent class variable
        System.out.println("Name: " + d.name);
    }
}

/*
===============================================================================
📌 OUTPUT:
--------------------------------
Animal is eating...
Dog is barking...
Name: Animal
===============================================================================

===============================================================================
🎯 KEY POINTS ABOUT SINGLE INHERITANCE
===============================================================================
✔ Only ONE parent class and ONE child class  
✔ Implemented using `extends` keyword  
✔ Child inherits:
    - public members
    - protected members
    - default members (only if same package)
✔ Child CANNOT inherit:
    - constructors
    - private members (but exists in object)
✔ Enables Method Overriding (runtime polymorphism)

===============================================================================
📌 WHEN TO USE SINGLE INHERITANCE?
===============================================================================
Use it when:
✔ There is a clear **IS-A relationship**
✔ Child needs to reuse parent logic
✔ You want to implement polymorphism or overriding

Avoid it when:
✖ The relationship is forced (not logically IS-A)
✖ You only want to reuse code (better use composition/HAS-A)

Example:
✔ Dog IS-A Animal (Correct)
❌ Car extends Driver (Wrong)

===============================================================================
📌 RULES & WHAT IS ALLOWED / NOT ALLOWED
===============================================================================

✔ Allowed:
    - Overriding parent methods
    - Accessing parent methods/variables
    - Using `super` to access parent features

❌ Not Allowed:
    - Extending more than one class (multiple inheritance)
    - Reducing method visibility while overriding (public → private ❌)
    - Overriding final methods

===============================================================================
📌 METHOD OVERRIDING IN SINGLE INHERITANCE (Example)
===============================================================================

class Animal {
    void sound() { System.out.println("Animal sound"); }
}

class Dog extends Animal {
    @Override
    void sound() { System.out.println("Dog barks"); }
}

===============================================================================
📌 PROPERTIES OF SINGLE INHERITANCE
===============================================================================
- Simple hierarchy
- Easy maintenance and readability
- Forms base structure for multilevel inheritance
- Supports abstraction and polymorphism

===============================================================================
📌 ADVANTAGES
===============================================================================
✔ Code reuse  
✔ Flexibility via overriding  
✔ Clear class design  
✔ Less redundancy  
✔ Helps in implementing polymorphism  

===============================================================================
📌 DISADVANTAGES
===============================================================================
✖ Tight coupling between classes  
✖ Incorrect usage creates improper hierarchy  
✖ Parent changes may affect child behavior  

===============================================================================
📌 REAL-LIFE EXAMPLE
===============================================================================

class Employee { String name; double salary; }
class Developer extends Employee { String programmingLanguage; }

Meaning:
✔ Developer IS-A Employee

===============================================================================
📌 MOST COMMON INTERVIEW QUESTIONS
===============================================================================
1️⃣ What is single inheritance?
Single inheritance is a type of inheritance in Java where one subclass inherits the properties and behavior of one superclass using the extends keyword.
In simple words, it represents a one-to-one parent–child relationship.

Example:
class Animal {}
class Dog extends Animal {} // Single Inheritance

Here, Dog inherits from Animal, so we say:
➡ Dog IS-A Animal


2️⃣ How is it achieved in Java?
Single inheritance is achieved using the extends keyword.
The child class automatically inherits all non-private attributes and methods of the parent class.

Syntax:
class Parent {}
class Child extends Parent {}


3️⃣ Why doesn’t Java allow multiple inheritance?
Java does not support multiple inheritance using classes to avoid ambiguity, also known as the diamond problem.

Example problem:

     A
   /   \
  B     C
   \   /
     D


If both B and C have a method with the same name, the compiler will not know which one D should inherit.

To solve this, Java:
✔ Allows multiple inheritance using interfaces
❌ Doesn't allow it using classes

4️⃣ What keywords are used for inheritance?
The keyword used is:
✔ extends — for class-to-class inheritance
✔ implements — for implementing one or more interfaces

Example:
class Car extends Vehicle {}        // Using extends
class Honda implements CarSpecs {}  // Using implements

5️⃣ Do constructors get inherited?
No, constructors are not inherited in Java.
Reason:
Constructors are used to initialize the specific instance of a class itself.
A child class has its own identity and needs its own constructor.

But:
✔ A parent constructor can be called using the super() keyword inside the child class

6️⃣ What is method overriding? Can we override static/final/private methods?
Method overriding is when a subclass provides its own implementation of a method inherited from a superclass, with the same name, return type, and parameters.

Example:

class Animal {
    void sound() { System.out.println("Animal sound"); }
}

class Dog extends Animal {
    @Override
    void sound() { System.out.println("Dog barks"); }
}

Which methods can NOT be overridden?
Method Type	Override Allowed?	Why?
static	❌ No	Because they belong to the class, not the object → method hiding occurs
final	❌ No	Final means: cannot modify behavior
private	❌ No	Private methods are not accessible outside class → not visible to child


7️⃣ How does the `super` keyword work?
super is used inside a child class to refer to the parent class.
It is used for:

Purpose	Example
Access parent variable	super.variableName
Call parent method	super.methodName()
Call parent constructor	super()

Example:

class A {
    A() { System.out.println("Parent constructor"); }
}

class B extends A {
    B() {
        super(); 
        System.out.println("Child constructor");
    }
}


8️⃣ Difference between IS-A and HAS-A?
| Feature | IS-A Relationship      | HAS-A Relationship                         |
| ------- | ---------------------- | ------------------------------------------ |
| Meaning | Child inherits Parent  | One object contains/uses another           |
| Keyword | `extends / implements` | object reference (composition/aggregation) |
| Example | `Dog extends Animal`   | `Car has Engine`                           |
Simple sentence:
IS-A means inheritance.
HAS-A means object association (composition or aggregation).


9️⃣ When should we avoid inheritance?
Inheritance should be avoided when:

❌ The relationship between classes is not logically "IS-A"
❌ You only want to reuse code
❌ It increases unnecessary complexity
❌ A deep hierarchy (A → B → C → D) makes maintenance harder

In such cases, composition (HAS-A relationship) is preferred because it provides loose coupling.


🔟 What access modifiers affect inheritance?
| Modifier    | Inherited?               | Visibility to Child                           |
| ----------- | ------------------------ | --------------------------------------------- |
| `public`    | ✔ Yes                    | Accessible everywhere                         |
| `protected` | ✔ Yes                    | Accessible in child even in different package |
| `default`   | ✔ Yes                    | Only within the same package                  |
| `private`   | ✔ Yes (exists in object) | ❌ Not directly accessible                     |



===============================================================================
📌 MOST IMPORTANT CONCEPT QUESTIONS
===============================================================================
✔ Why does Java not support multiple inheritance?  → To avoid ambiguity (diamond problem)
✔ Can private members be inherited? → Yes, but not directly accessed.
✔ Can we override static methods? → No, they are hidden, not overridden.
✔ Can we override final methods? → No.
✔ Can we inherit constructors? → No.

===============================================================================
📌 INTERVIEW SHORT ANSWER VERSION
===============================================================================

"Single inheritance is a type of inheritance where one subclass inherits from
one superclass using `extends`. It allows code reuse, supports method overriding, 
and forms the basis of polymorphism. However, it should only be used when there 
is a meaningful IS-A relationship."

===============================================================================
END OF NOTES
===============================================================================
*/
