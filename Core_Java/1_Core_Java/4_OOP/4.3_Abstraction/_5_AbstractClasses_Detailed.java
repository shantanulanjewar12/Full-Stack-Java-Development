/*
===============================================================================
🧠 ABSTRACT CLASSES IN JAVA — COMPLETE DETAILED NOTES
===============================================================================

📌 What is an Abstract Class?

An abstract class is a class declared with the `abstract` keyword that may contain:

✔ Abstract methods (without implementation)
✔ Concrete methods (with implementation)
✔ Variables, constructors, and static methods

It cannot be instantiated but can be used as a **base (parent) class** for other classes.

👉 It defines a **blueprint** for other classes.

Example:
    abstract class Animal
        ↓
    Dog, Cat extend and provide implementation

===============================================================================
📌 WHY ABSTRACT CLASS?

Abstract classes help when:

✔ We know the common functionality among different subclasses  
✔ But some methods depend on the specific implementation of child classes

For example, all animals eat & sleep (common),  
but sound behavior varies (overridden).

===============================================================================
📌 ABSTRACT CLASS EXAMPLE
===============================================================================
*/

abstract class Animal {

    // Abstract method (must be overridden)
    abstract void sound();

    // Concrete method (optional override)
    void sleep() {
        System.out.println("Animal is sleeping...");
    }

    // Constructor (allowed in abstract class)
    Animal() {
        System.out.println("Animal constructor called...");
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
📌 KEY RULES OF ABSTRACT CLASSES
===============================================================================

✔ Must be declared using `abstract` keyword  
✔ May or may not contain abstract methods  
✔ Cannot be instantiated  
✔ Can contain:
   - constructors
   - static methods
   - instance variables
   - final or non-final methods

✔ If a subclass does NOT override ALL abstract methods → it must also be abstract

===============================================================================
📌 ABSTRACT METHODS — DETAILED

Abstract methods are declared but not implemented in parent class.

Syntax:
    abstract returnType methodName();

✔ Must be implemented in subclass  
✔ Cannot be:
   ❌ private
   ❌ static
   ❌ final
✔ Must exist inside an abstract class or interface

Example:
    abstract void start();

===============================================================================
📌 WHY ABSTRACT METHODS?

They enforce behavior — meaning all child classes MUST provide their own version.

Example:
Every vehicle must use start(), but a car, bike, and train start differently.

===============================================================================
📌 REAL-WORLD EXAMPLE
===============================================================================
*/

abstract class Payment {

    abstract void pay(); // must be implemented by child classes

    void welcome() {
        System.out.println("Welcome to the Payment System.");
    }
}

class UPI extends Payment {
    @Override
    void pay() {
        System.out.println("Payment done via UPI.");
    }
}

class CardPayment extends Payment {
    @Override
    void pay() {
        System.out.println("Payment done via Credit/Debit Card.");
    }
}

public class _5_AbstractClasses_Detailed {
    public static void main(String[] args) {
        Payment p;

        p = new UPI();
        p.welcome();
        p.pay();

        p = new CardPayment();
        p.welcome();
        p.pay();

        Animal a = new Dog();
        a.sound();
        a.sleep();
    }
}


/*
===============================================================================
📌 OUTPUT:
--------------------------------
Animal constructor called...
Dog barks...
Animal is sleeping...
Welcome to the Payment System.
Payment done via UPI.
Welcome to the Payment System.
Payment done via Credit/Debit Card.
===============================================================================

===============================================================================
📌 WHEN TO USE ABSTRACTION?

Use abstraction when:

✔ You want to define a **general template or blueprint**  
✔ Subclasses share common structure but behavior differs  
✔ You need **partial abstraction** (some methods implemented, some not)  
✔ You want to enforce rules without revealing implementation  
✔ You expect more subclasses to be added later (future-proof design)

Examples:
✔ Vehicles → Car, Bike, Truck  
✔ Payment → UPI, Card, NetBanking  
✔ Employees → Developer, Manager, Intern  

===============================================================================
📌 ADVANTAGES OF ABSTRACT CLASSES

✔ Reduces code duplication (common logic in parent class)  
✔ Enforces rules using abstract methods  
✔ Improves maintainability and flexibility  
✔ Supports constructor usage for shared initialization  

===============================================================================
📌 LIMITATIONS

❌ Cannot create objects directly  
❌ Does NOT support multiple inheritance (only one parent class)  
❌ May lead to tight coupling if not designed properly  

===============================================================================
📌 KEY DIFFERENCES: ABSTRACT METHOD vs CONCRETE METHOD

| Feature | Abstract Method | Concrete Method |
|--------|-----------------|----------------|
| Body | No | Yes |
| Override required? | YES | Optional |
| Purpose | Enforce behavior | Provide implementation |

===============================================================================
📌 MOST ASKED INTERVIEW QUESTIONS (Short Answers)

1️⃣ Can abstract class have concrete methods?
✔ Yes.

2️⃣ Can abstract method be private?
❌ No — cannot be overridden.

3️⃣ Can we create an object of an abstract class?
❌ No.

4️⃣ Can abstract class have constructors?
✔ Yes, used for initialization.

5️⃣ Do abstract methods need access modifiers?
✔ Yes; default: public/protected is allowed.

6️⃣ If subclass doesn’t override abstract methods?
➡ Subclass must also be abstract OR compilation error.

7️⃣ Can abstract class have static methods?
✔ Yes, but cannot be abstract static.

===============================================================================
📌 10-SECOND INTERVIEW SUMMARY

"An abstract class is a partially implemented blueprint that contains abstract 
and non-abstract methods. It cannot be instantiated and is used when multiple 
subclasses share common behavior but differ in specific implementations."

===============================================================================
END OF NOTES
===============================================================================
*/
