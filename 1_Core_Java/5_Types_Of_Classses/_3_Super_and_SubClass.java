// ============================================================
// 🔹 _3_Super_and_SubClass.java
// ============================================================
// Topic: Superclass and Subclass in Java
// Author: Shantanu Lanjewar
// ============================================================

/*
===============================================================================
💡 WHAT IS A SUPERCLASS? (Parent Class)
===============================================================================
A *Superclass* is the class from which another class inherits its properties
and behavior.

Example:
    class A { }  // Superclass
    class B extends A { } // Subclass

Here, A is the superclass.

===============================================================================
💡 WHAT IS A SUBCLASS? (Child Class)
===============================================================================
A *Subclass* is the class that inherits from another class.

✔ Subclass = derived class = child class  
✔ Superclass = base class = parent class  

Subclass can use:
- Variables of parent class  
- Methods of parent class  
- Constructors via super()  
Unless they are private.

===============================================================================
🔹 VERY IMPORTANT: Every class in Java is a subclass of Object
===============================================================================
If you do not specify a superclass:
    class A { }
Java automatically treats it as:
    class A extends Object { }

Object class provides common methods:
✔ toString()  
✔ equals()  
✔ hashCode()  
✔ wait(), notify(), notifyAll()  
✔ clone()  
✔ getClass()  

===============================================================================
🔹 SIMPLE SUPERCLASS–SUBCLASS EXAMPLE
===============================================================================
*/

class Person {

    int empId;

    Person(int empId) {
        this.empId = empId;
    }

    void showPerson() {
        System.out.println("Employee ID: " + empId);
    }
}

// Subclass extending superclass
class Employee extends Person {

    double salary;

    Employee(int empId, double salary) {
        super(empId); // calling parent constructor
        this.salary = salary;
    }

    void showEmployee() {
        System.out.println("Salary: " + salary);
    }
}

/*
===============================================================================
🔹 REAL-WORLD EXAMPLE OF SUBCLASS
===============================================================================
*/

class Car {
    int mileage;

    Car(int mileage) {
        this.mileage = mileage;
    }

    void start() {
        System.out.println("Car is starting...");
    }
}

class Audi extends Car {
    Audi(int mileage) {
        super(mileage);
    }

    void startAudi() {
        System.out.println("Audi is starting with luxury features...");
    }
}

/*
===============================================================================
🔹 MAIN CLASS (Demonstration)
===============================================================================
*/

public class _3_Super_and_SubClass {
    public static void main(String[] args) {

        System.out.println("===== Person → Employee (Subclass Example) =====");
        Employee e = new Employee(101, 50000);
        e.showPerson();   // inherited method
        e.showEmployee(); // child method
        System.out.println("Inherited empId: " + e.empId);

        System.out.println("\n===== Car → Audi (Subclass Example) =====");
        Audi a = new Audi(15);
        a.start();       // inherited method
        a.startAudi();   // child method
        System.out.println("Mileage: " + a.mileage);

        System.out.println("\n===== Object Class Example =====");
        Object obj1 = new Person(1);  // Parent reference
        Object obj2 = new Audi(10);   // Everything is an object

        System.out.println(obj1.toString());
        System.out.println(obj2.toString());
    }
}

/*
===============================================================================
🔹 RULES FOR SUPERCLASS–SUBCLASS RELATIONSHIP
===============================================================================
1️⃣ A class can extend ONLY ONE superclass (Single inheritance).
2️⃣ Subclass inherits:
     ✔ non-private variables
     ✔ non-private methods
3️⃣ Subclass constructor ALWAYS calls superclass constructor:
     - explicitly using super()
     - or implicitly inserted by compiler
4️⃣ super() MUST be the first statement inside subclass constructor.
5️⃣ Even if you don't write "extends", your class → inherits from Object.

===============================================================================
🔹 WHAT SUBCLASS CANNOT INHERIT?
===============================================================================
❌ private variables  
❌ private methods  
❌ constructors (not inherited; only called via super())  
❌ static methods (they are hidden, not overridden)  

===============================================================================
🔹 WHEN TO USE SUPERCLASS–SUBCLASS?
===============================================================================
✔ When multiple classes share common properties  
✔ To reuse code (DRY principle)  
✔ To achieve polymorphism  
✔ To generalize behavior

Example:
    Vehicle → Car → Audi  
    Person → Employee → Manager  
    Shape → Circle → Rectangle

===============================================================================
🔹 WHEN NOT TO USE INHERITANCE?
===============================================================================
❌ If classes do NOT share an "IS-A" relationship  
❌ Just for code reuse — composition is better  
❌ When deep inheritance chain becomes confusing  
❌ When child must restrict parent behavior too much

===============================================================================
🔹 ADVANTAGES OF SUBCLASS & SUPERCLASS
===============================================================================
✔ Code reuse  
✔ Cleaner structure  
✔ Supports polymorphism  
✔ Reduces duplication  
✔ Improves maintainability  

===============================================================================
🔹 LIMITATIONS
===============================================================================
❌ Tight coupling between child and parent  
❌ Cannot inherit multiple classes (single inheritance restriction)  
❌ Increases complexity when hierarchy becomes large  

===============================================================================
🔹 INTERVIEW QUESTIONS AND ANSWERS
===============================================================================

Q1️⃣ What is a subclass?  
👉 A class that inherits another class using `extends`.

------------------------------------

Q2️⃣ What is a superclass?  
👉 The class being inherited.

------------------------------------

Q3️⃣ What is inherited by subclass?  
👉 All non-private fields and methods.

------------------------------------

Q4️⃣ Are constructors inherited?  
👉 ❌ No, but subclass can call them using super().

------------------------------------

Q5️⃣ Why must super() be the first statement in constructor?  
👉 Because Java must initialize parent class BEFORE child.

------------------------------------

Q6️⃣ Is every class a subclass of Object?  
👉 ✔ Yes, directly or indirectly.

------------------------------------

Q7️⃣ Can subclass override private methods?  
👉 ❌ No, private methods are not visible to subclass.

------------------------------------

Q8️⃣ Can we write super.super.method()?  
👉 ❌ No. Java does not support multi-level super chaining.

------------------------------------

Q9️⃣ Can a subclass reduce visibility of inherited method?  
👉 ❌ No. It can only increase visibility.

------------------------------------

Q🔟 Can static methods be overridden?  
👉 ❌ They are hidden, not overridden.

===============================================================================
🔹 TRICKY INTERVIEW QUESTIONS
===============================================================================

⭐ Q1: What happens if superclass has no default constructor?
👉 Subclass MUST explicitly call `super(args)`.

------------------------------------

⭐ Q2: Why is Object class called the root class?  
👉 Because all classes inherit from Object directly/indirectly.

------------------------------------

⭐ Q3: Can we store subclass object in superclass reference?  
👉 ✔ Yes (Upcasting).  
    Person p = new Employee(5, 5000);

------------------------------------

⭐ Q4: Can subclass access protected members of parent?  
👉 ✔ Yes, protected is accessible in child, even in different package.

------------------------------------

⭐ Q5: What is method overriding?  
👉 Subclass providing its own version of parent method.

------------------------------------

⭐ Q6: What is hierarchical inheritance?  
👉 Multiple subclasses inherit the same parent class.

===============================================================================
🔹 SUMMARY (SPOKEN VERSION FOR INTERVIEW)
===============================================================================

“A superclass is a parent class whose properties are inherited by another class.  
A subclass extends the parent class and adds extra features.  
In Java, all classes ultimately extend the Object class.  
Constructors are not inherited, and private members are not accessible.  
We use inheritance to reuse code and implement polymorphism.”

===============================================================================
*/
