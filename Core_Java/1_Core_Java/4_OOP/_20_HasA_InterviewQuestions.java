/*
===============================================================================
📌 _20_HasA_InterviewQuestions.java
===============================================================================
This file contains the MOST commonly asked interview questions on:

✔ HAS-A Relationship  
✔ Aggregation  
✔ Composition  

Each question is answered in:
- Simple format
- Interview explanation
- Code example (when required)
- Short notebook summary

===============================================================================
1️⃣ What is a HAS-A Relationship?
---------------------------------

✔ Simple Answer:
A HAS-A relationship means one class contains or uses another class.

✔ Interview Answer:
A HAS-A relationship is an association in OOP where one class has a reference of
another class to achieve code reuse, modularity, and real-world representation.

Example:
---------
Car HAS-A Engine
Student HAS-A Address

Notebook Point:
✔ HAS-A = contains-a relationship implemented using object reference.

===============================================================================
2️⃣ Why do we use HAS-A instead of inheritance?
----------------------------------------------

✔ Simple Reason:
Because not every relationship is "is-a". Some are "uses-a" or "owns-a".

✔ Interview Answer:
HAS-A promotes loose coupling, better flexibility, and avoids unnecessary
inheritance where behavior reuse is required instead of type inheritance.

Example:
---------
class Car { Engine engine; } // correct  
class Car extends Engine {} // incorrect (not IS-A)

Notebook:
✔ Use HAS-A when relation is NOT "is-a" but "has-a" or "uses-a".

===============================================================================
3️⃣ What are the types of HAS-A Relationship?
----------------------------------------------

✔ Two types:
1. Aggregation → Weak HAS-A  
2. Composition → Strong HAS-A  

Notebook:
✔ Aggregation = independent lifecycle  
✔ Composition = dependent lifecycle

===============================================================================
4️⃣ Explain Aggregation with an example.
----------------------------------------

✔ Definition:
Aggregation is a weak HAS-A relationship where objects can exist independently.

✔ Example:
*/

class Department {
    String name;
    Department(String name) { this.name = name; }
}

class Student {
    Department department; // Aggregation
    Student(Department dep) { this.department = dep; }
}

/*
✔ Explanation:
Even if Student object is destroyed, Department object still exists.

Notebook:
✔ Aggregation → reusable, independent objects.

===============================================================================
5️⃣ Explain Composition with an example.
----------------------------------------

✔ Definition:
Composition is a strong HAS-A relationship where the contained object’s lifecycle
depends entirely on the container.

✔ Example:
*/

class Heart {
    void pump(){ System.out.println("Heart pumping..."); }
}

class Person {
    private Heart heart = new Heart(); // created inside
}

/*
✔ Explanation:
If a Person object dies, the Heart becomes meaningless.

Notebook:
✔ Composition = strong dependency, tightly coupled.

===============================================================================
6️⃣ How do you identify Composition vs Aggregation in design?
-------------------------------------------------------------

✔ Rule of thumb:

Ask: "Can the part exist without the whole?"

- If YES → Aggregation  
- If NO  → Composition  

Example:
---------
Student → Department → aggregation  
Human → Heart → composition

Notebook:
✔ Dependency of lifecycle decides type.

===============================================================================
7️⃣ Which is stronger — Aggregation or Composition?
---------------------------------------------------

✔ Answer:
Composition is stronger because the child object cannot exist without the parent.

Notebook:
✔ Composition > Aggregation (in strength).

===============================================================================
8️⃣ Is HAS-A relationship implemented through inheritance?
----------------------------------------------------------

✔ Answer:
No — HAS-A is implemented using object references, not inheritance.

Notebook:
✔ HAS-A → object reference, NOT extends.

===============================================================================
9️⃣ What is the UML notation for Aggregation & Composition?
-----------------------------------------------------------

✔ Aggregation → Open diamond (○)
✔ Composition → Filled diamond (◆)

Notebook:
✔ ○ = Aggregation  
✔ ◆ = Composition

===============================================================================
🔟 Where is HAS-A relationship used in real-world applications?
----------------------------------------------------------------

✔ Examples:
- Banking: Account HAS-A TransactionHistory  
- Games: Player HAS-A Weapon  
- E-Commerce: Order HAS-A ProductList  
- OOP Design: Singleton, Builder pattern use composition

Notebook:
✔ Used in modeling real-world object relationships.

===============================================================================
🔟 BONUS: When should Composition be preferred over Inheritance?
----------------------------------------------------------------

✔ Answer:
Composition should be preferred when behavior needs reuse, flexibility is required,
or inheritance does not logically represent "is-a".

Short example:
---------
Car HAS-A Engine ✔  
Car IS-A Engine ❌

Notebook:
✔ Prefer composition over inheritance for flexibility.

===============================================================================
🧪 TEST CLASS
===============================================================================
*/

public class _20_HasA_InterviewQuestions {
    public static void main(String[] args) {
        System.out.println("✔ This file contains interview theory, not runtime demo.");
    }
}

/*
===============================================================================
📌 FINAL QUICK SUMMARY (FOR NOTEBOOK)
-------------------------------------

✔ HAS-A → class contains or uses another class (object reference)
✔ Two types:
     → Aggregation (weak, independent objects)
     → Composition (strong, dependent objects)
✔ Use when modelling real-world relationships & for code reuse.
✔ Prefer composition over inheritance when "is-a" relation is false.
✔ UML: Aggregation ○ , Composition ◆

===============================================================================
*/
