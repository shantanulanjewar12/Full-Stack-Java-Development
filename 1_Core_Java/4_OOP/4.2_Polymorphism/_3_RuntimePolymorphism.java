/*

📌 Definition:
Runtime polymorphism occurs when a method call is resolved **at runtime** instead
of compile time. It happens when a **child class overrides a method of its
parent class**, and the method execution depends on the **actual object type**
—not the reference type.

➡ Also Known As:
✔ Method Overriding  
✔ Dynamic Binding  
✔ Late Binding  
✔ Dynamic Method Dispatch  

===============================================================================
📌 WHY RUNTIME POLYMORPHISM?
===============================================================================

✔ Supports dynamic behavior in applications  
✔ Enables flexible design (future child classes can extend behavior)  
✔ Implements loose coupling in OOP  
✔ Used in frameworks: Spring, Hibernate, JDBC, Servlets, Polymorphic collections

===============================================================================
📌 RULES OF METHOD OVERRIDING
===============================================================================

✔ Method name must be the SAME  
✔ Parameter list must be the SAME  
✔ Return type must be the SAME or **covariant** (child type allowed)

✔ Access level:
   - Can be same or more relaxed (public > protected > default > private)
   - ❌ Cannot reduce access level

✔ Only instance methods can be overridden  
✔ Parent method must NOT be:
   ❌ static  
   ❌ private  
   ❌ final  

✔ `@Override` annotation is recommended (not required, but good practice)

===============================================================================
📌 HOW RUNTIME POLYMORPHISM WORKS?
===============================================================================

👉 Parent reference holding child object:

Animal a = new Dog();
a.sound(); // Calls Dog's sound(), NOT Animal's

Method chosen at runtime based on object type → Dog.

===============================================================================
📌 EXAMPLE — RUNTIME POLYMORPHISM
===============================================================================
*/

class Vehicle {

    void start() { // Parent method
        System.out.println("Vehicle is starting...");
    }
}

class Car extends Vehicle {

    @Override
    void start() { // Overriding method
        System.out.println("Car is starting with push button...");
    }
}

class Bike extends Vehicle {

    @Override
    void start() {
        System.out.println("Bike is starting with kick...");
    }
}

public class _3_RuntimePolymorphism {
    public static void main(String[] args) {

        Vehicle v;  // Parent reference

        v = new Car();
        v.start();  // Car implementation

        v = new Bike();
        v.start();  // Bike implementation
    }
}


/*
===============================================================================
📌 OUTPUT:
--------------------------------
Car is starting with push button...
Bike is starting with kick...
===============================================================================

===============================================================================
🎯 KEY POINTS SUMMARY
===============================================================================

✔ Achieved through Method Overriding  
✔ Decision made at runtime (dynamic binding)  
✔ Parent reference → Child object  
✔ Child method overrides parent behavior  
✔ Supports abstraction and interface-driven development  

===============================================================================
📌 WHAT CAN BE USED?
✔ Inheritance  
✔ `super` keyword (to access parent implementation)  
✔ Covariant return type  
✔ Dynamic dispatch  

===============================================================================
📌 WHAT CANNOT BE USED?
❌ static methods (static binding → method hiding)  
❌ private methods (not visible in child)  
❌ final methods (cannot override)  
❌ constructors (not inherited → cannot override)  

===============================================================================
📌 METHOD HIDING (IMPORTANT DIFFERENCE)
-------------------------------------------------------------------------------

class A { static void show() {} }
class B extends A { static void show() {} }

➡ This is NOT overriding → it is method hiding.

===============================================================================
📌 REAL-WORLD EXAMPLES
===============================================================================

✔ Payment Process:
    Payment p = new UPI();  p.pay();
    Payment p = new Card(); p.pay();

✔ Notification:
    Notification n = new Email();
    Notification n = new SMS();

✔ Serialization / JDBC:
    Connection con = DriverManager.getConnection(...);
    con.prepareStatement();

===============================================================================
📌 ADVANTAGES
===============================================================================

✔ Extensible and maintainable code  
✔ Enables runtime decision making  
✔ Supports polymorphic behavior  
✔ Improves loose coupling  

===============================================================================
📌 DISADVANTAGES
===============================================================================

✖ Slight performance overhead (dynamic lookup)  
✖ Requires inheritance (tight coupling if misused)  
✖ Debugging may be harder  

===============================================================================
📌 MOST COMMON INTERVIEW QUESTIONS
===============================================================================

1️⃣ What is runtime polymorphism?  
2️⃣ How is runtime polymorphism achieved in Java?  
3️⃣ Difference between overloading and overriding?  
4️⃣ Why static methods cannot be overridden?  
5️⃣ What is method hiding?  
6️⃣ Can we override private, final, or constructor methods?  
7️⃣ What is dynamic binding / dynamic method dispatch?  
8️⃣ What is covariant return type?  
9️⃣ Can we override static polymorphism to runtime?  
🔟 Why use @Override annotation?

-------------------------------------------------------------------------------

📌 SHORT INTERVIEW ANSWERS (SPEAKABLE)

✔ "Runtime polymorphism happens when the method to execute is decided at runtime
based on the actual object type, achieved using method overriding."

✔ "Static methods cannot be overridden because overriding works on objects, but
static methods belong to the class."

✔ "Method overriding ensures dynamic dispatch and allows subclasses to implement
their own behavior of a parent method."

===============================================================================
📌 MEMORY TRICK

🔹 Overloading → Compile Time → Static Binding → Same Name, Different Parameters  
🔹 Overriding → Runtime → Dynamic Binding → Same Signature, Different Behavior  

===============================================================================
END OF NOTES
===============================================================================
*/
