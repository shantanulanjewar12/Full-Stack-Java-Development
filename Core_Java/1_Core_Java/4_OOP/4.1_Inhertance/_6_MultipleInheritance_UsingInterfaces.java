/*
===============================================================================
🧠 MULTIPLE INHERITANCE IN JAVA USING INTERFACES — COMPLETE EXPLANATION
===============================================================================

📌 Definition:
Multiple Inheritance is a concept where a class can inherit characteristics
(behaviors/properties) from **more than one parent**.

Java does NOT support multiple inheritance using classes because it causes
ambiguity (Diamond Problem).

However, Java **allows multiple inheritance using interfaces**, because interfaces
only provide method declarations (until Java 8), and the child class decides the
implementation — eliminating conflicts.

Example:

interface A
interface B
class C implements A, B  --> Multiple inheritance is allowed

===============================================================================
📌 WHY MULTIPLE INHERITANCE IS NOT ALLOWED WITH CLASSES?
===============================================================================

To avoid the "Diamond Problem":

    A
   / \
  B   C
   \ /
    D   <- Which version of a method should D inherit? From B or C?

Java solves this by:
✔ Allowing multiple inheritance only through interfaces
✔ Not allowing it using classes

===============================================================================
📌 BASIC SYNTAX OF MULTIPLE INHERITANCE USING INTERFACES
===============================================================================

interface Interface1 {
    void method1();
}

interface Interface2 {
    void method2();
}

class Child implements Interface1, Interface2 {
    public void method1() {...}
    public void method2() {...}
}

===============================================================================
📌 EXAMPLE PROGRAM — MULTIPLE INHERITANCE (INTERFACES)
===============================================================================
*/

interface Engine {
    void startEngine();
}

interface MusicSystem {
    void playMusic();
}

class Car implements Engine, MusicSystem {  // Multiple Inheritance

    @Override
    public void startEngine() {
        System.out.println("Engine started...");
    }

    @Override
    public void playMusic() {
        System.out.println("Playing music...");
    }

    void drive() {
        System.out.println("Car is driving...");
    }
}

public class _6_MultipleInheritance_UsingInterfaces {
    public static void main(String[] args) {

        Car car = new Car();
        car.startEngine();
        car.playMusic();
        car.drive();
    }
}


/*
===============================================================================
📌 OUTPUT:
--------------------------------
Engine started...
Playing music...
Car is driving...
===============================================================================


===============================================================================
Diamond Problem Explanation:
The Diamond Problem occurs when a class tries to inherit from two parent classes that both have a method with the same name and signature.
The compiler becomes confused about which version of the method to inherit.

      A
     / \
    B   C
     \ /
      D
In this case, class D inherits from both B and C, which both inherit from A. If both B and C override a method from A, D will have two conflicting versions of that method.

Java avoids this problem by not allowing multiple inheritance with classes. Instead, it allows multiple inheritance through interfaces, which only declare methods without providing implementations (until Java 8). This way, the implementing class must provide its own implementation, thus avoiding ambiguity.

Where:

B and C inherit from A

D inherits from both B and C

Now if A contains a method, and both B and C override it,
what should D inherit?

➡ Method from B?
➡ Method from C?

This confusion is the diamond problem.

🧠 Why Java Avoids It?

Java avoids multiple inheritance of classes because:

✔ It prevents ambiguity
✔ It avoids complex inheritance structure
✔ It keeps code predictable and easier to maintain

So Java's rule is:

A class can extend ONLY ONE class.

✔ How Java Solves the Diamond Problem?

Java solves it using interfaces.

A class can implement multiple interfaces because:

Interfaces originally contained only method declarations (no implementation)

So there was no conflict, since the class implementing them defines the actual method.

👍 Example in Java (Safe Version)
interface A {
    void show();
}

interface B {
    void show();
}

class D implements A, B {
    @Override
    public void show() {
        System.out.println("Solved using interfaces!");
    }
}


Here, there is no ambiguity because:

👉 D must provide its own implementation of show().


===============================================================================
🎯 KEY POINTS ABOUT MULTIPLE INHERITANCE IN JAVA
===============================================================================

✔ Achieved only using interfaces (NOT classes)
✔ A class can implement multiple interfaces
✔ Interfaces help avoid ambiguity by forcing the child to implement methods
✔ Supports polymorphism
✔ Interfaces define rules/contracts; implementation is provided in class

-------------------------------------------------------------------------------

📌 WHAT CAN BE USED:
✔ default methods (Java 8+)
✔ static methods in interfaces
✔ method overriding
✔ polymorphism
✔ multiple interface implementation

📌 NOT ALLOWED:
❌ Extending multiple classes  
❌ Inheriting constructors  
❌ Creating instances of interfaces directly  
❌ Overriding final methods  

-------------------------------------------------------------------------------

📌 WHEN SHOULD MULTIPLE INHERITANCE BE USED?
Use it when:
✔ You want a class to follow multiple capabilities (e.g., Drivable + Flyable)
✔ Functional behavior separation is needed
✔ You want abstraction and flexibility

Examples:
✔ Vehicle implements Movable, FuelType, SafetyFeatures  
✔ SmartPhone implements CameraFeatures, NetworkConnectivity, AudioDevice  

-------------------------------------------------------------------------------

📌 PROPERTIES OF MULTIPLE INHERITANCE VIA INTERFACE
✔ Provides loose coupling  
✔ Increases flexibility  
✔ Supports interface-based design  
✔ Encourages component-based programming  

-------------------------------------------------------------------------------

📌 ADVANTAGES
✔ No ambiguity because implementation is forced in subclass  
✔ Promotes abstraction  
✔ Code becomes modular and flexible  
✔ Supports polymorphism  

-------------------------------------------------------------------------------

📌 DISADVANTAGES
✖ Too many interfaces may make design complex  
✖ Difficult to manage if overused  
✖ Default methods in interfaces may still create override conflicts  

-------------------------------------------------------------------------------

📌 REAL-LIFE EXAMPLES
===============================================================================

interface Payment { void processPayment(); }
interface UPI { void scanQRCode(); }
class GPay implements Payment, UPI {}

OR

interface Fly { void fly(); }
interface Swim { void swim(); }
class Duck implements Fly, Swim {}

===============================================================================

📌 MOST COMMON INTERVIEW QUESTIONS
===============================================================================

1️⃣ What is multiple inheritance?  
2️⃣ Why doesn't Java support multiple inheritance using classes?  
3️⃣ How does Java achieve multiple inheritance?  
4️⃣ What is the diamond problem?  
5️⃣ Can a class implement multiple interfaces?  
6️⃣ Can an interface extend multiple interfaces?  
7️⃣ What is the difference between `extends` and `implements`?  
8️⃣ Can interface methods have a body?  
9️⃣ What happens when two interfaces have default methods?  
🔟 Can constructor be inherited from interfaces?

-------------------------------------------------------------------------------

📌 DETAILED INTERVIEW ANSWERS
===============================================================================

✔ Q1: How does Java achieve multiple inheritance?

➡ Answer:
"Java achieves multiple inheritance using interfaces. A class can implement
multiple interfaces and inherit behavior contracts from each."

-------------------------------------------

✔ Q2: Why doesn’t Java support multiple inheritance using classes?

➡ Answer:
"Because it leads to ambiguity known as the Diamond Problem — the compiler cannot
decide which parent's method to inherit. Interfaces solve this because they only
provide method signatures."

-------------------------------------------

✔ Q3: Can a class implement multiple interfaces?

➡ Answer:
"Yes. Java allows a class to implement multiple interfaces."

Example:
class Car implements Engine, MusicSystem {}

-------------------------------------------

✔ Q4: What is the diamond problem?

➡ Answer:
"It refers to confusion when a child inherits from two classes that have the same
method. Java avoids it by not allowing multiple inheritance of classes."

-------------------------------------------

✔ Q5: Can interfaces have default methods?

➡ Answer:
"Yes, since Java 8. If conflict occurs between two default methods,
the subclass must override them."

-------------------------------------------

✔ Q6: Can an interface extend multiple interfaces?

➡ Answer:
"Yes. Unlike classes, interfaces support multiple inheritance."

Example:
interface C extends A, B {}

-------------------------------------------

✔ Q7: Can constructors be defined in interfaces?

➡ Answer:
"No. Interfaces do not contain constructors because they cannot be instantiated."

-------------------------------------------------------------------------------

📌 SHORT INTERVIEW SUMMARY
===============================================================================
"Multiple inheritance allows a class to inherit behavior from more than one parent.
Java avoids class-based multiple inheritance due to ambiguity but achieves it safely
using interfaces. A class can implement multiple interfaces, enabling flexibility,
modularity, and polymorphism."

===============================================================================
END OF NOTES
===============================================================================
*/
