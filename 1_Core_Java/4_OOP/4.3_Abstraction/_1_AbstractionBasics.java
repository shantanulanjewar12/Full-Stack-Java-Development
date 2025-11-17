/*


📌 Definition:
Abstraction is an Object-Oriented Programming concept that focuses on 
**showing only essential details while hiding internal complexity.**

👉 "Show WHAT the object does, not HOW it does it."

Examples in real life:
✔ A car driver uses the steering, accelerator, brakes (WHAT)
✔ But does not know how the engine internally works (HOW → hidden)

===============================================================================
📌 WHY ABSTRACTION?
===============================================================================

✔ Improves security by hiding implementation  
✔ Reduces complexity  
✔ Provides cleaner code and reusable design  
✔ Makes application flexible for future changes  
✔ Helps in defining blueprint behavior using contracts (interfaces/abstract classes)

===============================================================================
📌 HOW ABSTRACTION IS ACHIEVED IN JAVA?
===============================================================================

Java supports abstraction using:

1️⃣ **Abstract Class** (0–100% abstraction possible)  
2️⃣ **Interface** (100% abstraction before Java 8, now includes default/static methods)

===============================================================================
📌 ABSTRACT CLASS — Key Points
===============================================================================

✔ Declared using keyword `abstract`  
✔ Can have:
    - abstract methods (no body)
    - non-abstract methods (with body)
    - constructors, variables, static methods
✔ Cannot be instantiated (object cannot be created)
✔ Must be inherited using subclasses
✔ Child class must override ALL abstract methods (unless child is also abstract)

-------------------------------------------------------------------------------
📌 Syntax Example
-------------------------------------------------------------------------------
*/

abstract class Animal {

    abstract void sound();  // abstract method (no body)

    void sleep() {          // concrete method
        System.out.println("Animal is sleeping...");
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
📌 INTERFACE — Key Points
===============================================================================

✔ Achieves 100% abstraction (before Java 8)  
✔ Only contains:
    - abstract methods (implicitly public abstract)
    - constants (public static final)
✔ From Java 8 onward → can also have:
    - default methods
    - static methods
✔ From Java 9 → private methods (for internal interface usage)
✔ A class implements an interface (NOT extends)

-------------------------------------------------------------------------------
📌 Syntax Example
-------------------------------------------------------------------------------
*/

interface Vehicle {
    void start(); // implicitly abstract & public

    default void brandInfo() {
        System.out.println("Brand info displayed...");
    }
}

class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Car starts with key or push button...");
    }
}


/*
===============================================================================
📌 MAIN CLASS — DEMONSTRATION
===============================================================================
*/

public class _1_AbstractionBasics {
    public static void main(String[] args) {

        Animal a = new Dog(); // Runtime polymorphism with abstraction
        a.sound();
        a.sleep();

        Vehicle v = new Car(); // abstraction through interface
        v.start();
        v.brandInfo();
    }
}


/*
===============================================================================
📌 OUTPUT:
--------------------------------
Dog barks...
Animal is sleeping...
Car starts with key or push button...
Brand info displayed...
===============================================================================

===============================================================================
📌 RULES OF ABSTRACTION IN JAVA
===============================================================================

🔹 Abstract Class Rules:
✔ Can declare abstract and non-abstract methods  
✔ Can have constructors (called when subclass object created)
✔ Can have final, static, or normal methods  
✔ Cannot be instantiated  
✔ May contain instance variables  

🔹 Interface Rules:
✔ Supports multiple inheritance
✔ Variables are ALWAYS public static final (constants)
✔ Methods are public abstract by default  
✔ Can contain default, static, and private (Java 9+) methods  
✔ A class must provide full implementation unless declared abstract  

===============================================================================
📌 ACCESS MODIFIER BEHAVIOR
-------------------------------------------------------------------------------

| Feature       | Abstract Class | Interface |
|---------------|----------------|-----------|
| Variables     | Any modifier   | Always public static final |
| Methods       | Any modifier   | public abstract (default) |
| Constructor   | Allowed        | ❌ Not allowed |
| Instantiation | ❌ Not allowed | ❌ Not allowed |

===============================================================================
📌 WHERE IS ABSTRACTION USED?
===============================================================================

✔ Frameworks (Spring, Hibernate, JDBC)  
✔ API design  
✔ Payment systems (UPI, Card, NetBanking implementation differences)  
✔ Game engines (Player -> Attack(), Jump(), Move())  
✔ Hardware drivers  

===============================================================================
📌 ADVANTAGES
===============================================================================

✔ Hides unnecessary complexity  
✔ Improves security  
✔ Makes the system flexible and scalable  
✔ Encourages loose coupling and modularity  

===============================================================================
📌 DISADVANTAGES
===============================================================================

✖ Cannot be used directly (needs inheritance)  
✖ Sometimes over-design may complicate simple logic  
✖ Requires solid architecture planning  

===============================================================================
📌 1-LINE MEMORY TRICK

👉 "Abstraction hides implementation — only exposes behavior."

===============================================================================
END OF NOTES
===============================================================================
*/
