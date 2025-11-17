/*
===============================================================================
🎯 ABSTRACT CLASS & ABSTRACTION — INTERVIEW QUESTIONS WITH DETAILED ANSWERS
===============================================================================

This file includes high-value interview questions with deep explanations,
examples, and expected speaking format for real interviews.

===============================================================================
❓ Q1: What is abstraction in Java?

📝 Answer:
Abstraction is the process of hiding implementation details and showing only the
necessary functionality to the user. It focuses on "WHAT the object does" rather
than "HOW it does it."

Example Explanation:
A user can use a smartphone (call, click photo) without knowing the internal
processing, like circuits or camera sensors.

✔ Abstraction improves readability, reduces complexity, and supports OOP design.

Example:
*/

abstract class Phone {
    abstract void camera();  // user knows this exists, not how it works
}

class iPhone extends Phone {
    void camera() {
        System.out.println("iPhone captures HD image...");
    }
}

/*
===============================================================================
❓ Q2: What is an abstract class?

📝 Answer:
An abstract class is a class declared with the `abstract` keyword that may
contain abstract methods (without implementation) as well as concrete methods
(with implementation). It cannot be instantiated.

It serves as a **blueprint** for subclasses to follow.

Example:
*/

abstract class Animal {
    abstract void sound(); // must be implemented by subclass

    void sleep() { // concrete method
        System.out.println("Animal is sleeping...");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks...");
    }
}

/*
===============================================================================
❓ Q3: Why do we need abstract classes?

📝 Answer:
We use abstract classes when multiple subclasses share common behavior but still
require some behavior to be implemented differently.

✔ Shared logic goes in the abstract class.
✔ Unique behavior is enforced via abstract methods.

Example:
Cars have wheels and engines (shared logic), but start mechanisms vary
(button start vs. key start).

===============================================================================
❓ Q4: Can an abstract class have a constructor?

📝 Answer:
Yes. Abstract classes can have constructors, and they are executed when a child
class object is created.

Example:
*/

abstract class Vehicle {
    Vehicle() {
        System.out.println("Vehicle Created");
    }
}

class Bike extends Vehicle {
    Bike(){
        System.out.println("Bike Created");
    }
}

/*
Explanation:
Even though abstract class objects cannot be created, their constructor executes
when subclass objects are created — useful for setting default properties.

===============================================================================
❓ Q5: Can abstract methods be private or final?

📝 Answer:
❌ No.

✔ An abstract method must be overridden — meaning a subclass needs access.
Private or final methods prevent overriding, so they cannot be abstract.

-------------------------------------------------------------------------------

❌ Invalid Example:
abstract class Test {
    private abstract void show(); // ❌ Compile-time error
}

===============================================================================
❓ Q6: Can an abstract class have static methods?

📝 Answer:
✔ Yes, static methods are allowed — but they cannot be abstract.

Reason:
Static methods belong to the class, not the object, so overriding (required for
abstract methods) does not apply.

Example:
*/

abstract class Shape {
    static void info() {
        System.out.println("This is Shape class.");
    }
}

/*
===============================================================================
❓ Q7: Can a class be abstract without abstract methods?

📝 Answer:
✔ Yes.

A class can be declared abstract even if it has no abstract methods. This is used
when you do not want the class to be instantiated but still want to provide
common functionality to subclasses.

Example:
*/

abstract class Database {
    void connect() {
        System.out.println("Connected to database.");
    }
}

/*
===============================================================================
❓ Q8: Abstract Class vs Interface — short difference?

📝 Answer:
✔ Abstract class supports partial abstraction (0–100%). Can have constructors,
instance variables, and implemented methods.

✔ Interface supports full abstraction (before Java 8). Supports multiple
inheritance and contains only public static final variables.

-------------------------------------------------------------------------------

Example to speak:

"If you need shared code and restricted inheritance, use abstract class. If you
need a contract with multiple inheritance support, use interface."

===============================================================================
❓ Q9: What happens if subclass does not implement abstract methods?

📝 Answer:
If a subclass does not implement all abstract methods, the subclass **must also
be declared abstract**, or a compile-time error occurs.

-------------------------------------------------------------------------------

Example:
*/

abstract class Parent {
    abstract void msg();
}

abstract class Child extends Parent {} // ✔ allowed
// class Child extends Parent {} // ❌ error: must implement msg()

/*
===============================================================================
❓ Q10: When should abstraction be used in real-world applications?

📝 Answer:
Use abstraction when:

✔ Different objects share a common structure  
✔ You want to enforce code standards  
✔ You expect future subclasses  
✔ Implementation may change but behavior must remain consistent  

Example Scenarios:
- Banking system payment methods (UPI, Card, Cash)
- File system (open(), close(), read())
- Vehicles with different fuel engines

===============================================================================
📌 CODING INTERVIEW MINI-PROBLEM

🔧 Problem: Design a messaging system with abstraction.

Requirements:
✔ All message types must implement sendMessage()
✔ Email and SMS behave differently

Solution:
*/

abstract class Message {
    abstract void sendMessage(String text);
}

class Email extends Message {
    void sendMessage(String text) {
        System.out.println("Email sent: " + text);
    }
}

class SMS extends Message {
    void sendMessage(String text) {
        System.out.println("SMS sent: " + text);
    }
}


/*
===============================================================================
📌 OUTPUT EXAMPLE (from main())

Dog barks...
Animal is sleeping...
Vehicle Created
Bike Created
Email sent: Hello
SMS sent: Hi

===============================================================================

📌 FINAL INTERVIEW SUMMARY (SPEAKABLE IN 20 SECONDS)

"Abstraction focuses on hiding implementation details and exposing only meaningful functionality. It is achieved using abstract classes and interfaces. Abstract classes provide partial abstraction and allow shared behavior and constructors. We use abstraction when subclasses share common structure but need different implementations."

===============================================================================
END OF NOTES
===============================================================================
*/
