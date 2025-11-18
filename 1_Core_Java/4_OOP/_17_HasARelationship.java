/*
================================================================================
📌 _17_HasARelationship.java
================================================================================

A **HAS-A relationship** in Java represents association between two classes where
one class contains or uses another class as its field/member.

It is also known as:
✔ Association
✔ Object Composition Model
✔ "contains-a" relationship

================================================================================
1️⃣ DEFINITIONS
================================================================================

✔ Simple Definition:
--------------------
"A HAS-A relationship means one object contains another object."

Example: Car HAS-A Engine.

✔ Detailed Definition:
-----------------------
"A HAS-A relationship is a form of association where one class holds a reference
to another class as a member, representing ownership, usage, or part-of behavior."

✔ Interview-Ready Definition:
------------------------------
"A HAS-A relationship in Java represents object association through composition 
or aggregation where a class contains another object as its member to achieve 
code reuse, modularity, and real-world modeling."

================================================================================
2️⃣ WHY HAS-A RELATIONSHIP?
================================================================================

✔ Promotes code reusability  
✔ Achieves modular and maintainable design  
✔ Represents real-world relationships  
✔ Enables flexible system design  
✔ Supports composition and aggregation patterns  

================================================================================
3️⃣ KEY POINTS ABOUT HAS-A
================================================================================

✔ Implemented using object references  
✔ Used for modeling real-world entity relationships  
✔ Can be weak (Aggregation) or strong (Composition)  
✔ Improves loose coupling between objects  
✔ Reduces inheritance misuse  
✔ Supports object collaboration  

================================================================================
4️⃣ RULES OF HAS-A RELATIONSHIP
================================================================================

✔ One class must have a reference of another class  
✔ Object may be created inside class (Composition) or passed via constructor (Aggregation)  
✔ Child behavior depends on type:
      → Independent (Aggregation)
      → Dependent (Composition)

✔ Avoid unnecessary inheritance; prefer HAS-A when:
      "Class wants to use functionality of another class."

================================================================================
5️⃣ EXAMPLE OF BASIC HAS-A RELATIONSHIP
================================================================================
*/

class Engine {
    void start() {
        System.out.println("Engine started...");
    }
}

class Car { // Car HAS-A Engine
    Engine engine = new Engine(); // creating object inside class

    void drive() {
        engine.start();
        System.out.println("Car is driving...");
    }
}


/*
================================================================================
6️⃣ TYPES OF HAS-A RELATIONSHIP
================================================================================

HAS-A is categorized into 2 types:

-------------------------------------------------------------
| TYPE             | DEPENDENCY         | RELATION          |
|------------------|--------------------|-------------------|
| Aggregation      | Weak               | Independent       |
| Composition      | Strong             | Dependent         |
-------------------------------------------------------------

================================================================================
🅰️ Aggregation (WEAK HAS-A)
================================================================================

✔ Meaning:
   - Child object CAN exist without the parent object.
   - "Whole-part but lifecycles are independent."

✔ Real-Life Examples:
   - Student HAS-A Department
   - Book HAS-A Author

✔ UML Notation:
   ----○---- (Open Diamond Arrow)

-------------------------------- EXAMPLE --------------------------------------
*/

class Department {
    String name;
    Department(String name) { this.name = name; }
}

class Student {
    Department dept;  // Student HAS-A Department

    Student(Department dept) {
        this.dept = dept;
    }
}

/*
Explanation:
------------
Even if Student object is deleted, Department object still exists.

Notebook Summary:
✔ Aggregation = Independent lifecycle.
✔ Used when ownership is weaker.
-------------------------------------------------------------------------------

================================================================================
🅱️ Composition (STRONG HAS-A)
================================================================================

✔ Meaning:
   - Child object CANNOT exist WITHOUT the parent.
   - Parent controls object's lifecycle.

✔ Real-Life Examples:
   - Human HAS-A Heart
   - Car HAS-A Engine (depending on context)
   - House HAS-A Room

✔ UML Notation:
   ----◆---- (Filled Diamond Arrow)

-------------------------------- EXAMPLE --------------------------------------
*/

class Heart {
    void pump() {
        System.out.println("Heart is pumping...");
    }
}

class Person {
    private Heart heart = new Heart(); // created inside → lifecycle dependent

    void live() {
        heart.pump();
        System.out.println("Person is alive.");
    }
}

/*
Explanation:
------------
When Person object is destroyed, heart object also becomes useless.

Notebook Summary:
✔ Composition = Dependent lifecycle.
✔ Strong ownership: "part-of" relation.

================================================================================
7️⃣ USE CASES OF HAS-A RELATIONSHIP
================================================================================

✔ Database systems (User HAS-A Address, Account HAS-A TransactionHistory)  
✔ Game development (Player HAS-A Weapon, Vehicle HAS-A Armor)  
✔ GUI Programming (Window HAS-A Button, Frame HAS-A Panel)  
✔ Real-world modeling (Bank HAS-A Branch, Airline HAS-A Pilot)  

================================================================================
8️⃣ WHEN TO USE HAS-A INSTEAD OF INHERITANCE?
================================================================================

Use HAS-A when:
✔ The relationship is "uses-a" or "contains-a" NOT "is-a".
✔ You want composition over inheritance for flexibility.
✔ You want to reuse functionality without exposing implementation.

Interview Tip:
--------------
"Has-A is preferred over Is-A when behavior reuse is needed instead of type inheritance."

================================================================================
9️⃣ TEST CLASS FOR DEMO
================================================================================
*/

public class _17_HasARelationship {

    public static void main(String[] args) {

        System.out.println("===== Basic HAS-A Example =====");
        Car car = new Car();
        car.drive();

        System.out.println("\n===== Aggregation Example =====");
        Department d = new Department("Computer Science");
        Student s = new Student(d);
        System.out.println("Student belongs to: " + s.dept.name);

        System.out.println("\n===== Composition Example =====");
        Person p = new Person();
        p.live();
    }
}

/*
================================================================================
📝 FINAL NOTE SUMMARY (Write in Notebook)
-----------------------------------------

✔ HAS-A relationship means "one class contains or uses another".
✔ Implemented using object references.
✔ Two types:
    → Aggregation (weak, independent objects)
    → Composition (strong dependency, object dies with parent)
✔ Used to model real-world relations and support reusable, modular design.
✔ Prefer HAS-A over inheritance when the relation is NOT "is-a".

================================================================================
*/
