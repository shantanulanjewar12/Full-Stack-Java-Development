/*
===============================================================================
📌 _18_AggregationVsCompositionComparison.java
===============================================================================
This file explains the difference between Aggregation and Composition, which are
TWO types of HAS-A relationships in Object-Oriented Programming.

✔ Both represent association between classes.
✔ Both use object references.
✔ But differ in LIFE DEPENDENCY and OWNERSHIP.

===============================================================================
1️⃣ HAS-A Relationship (Quick Recap)
------------------------------------
A HAS-A relationship means one class contains or uses another class.

Example:
Car HAS-A Engine  
Student HAS-A Address

Used for: Code reuse, modularity, real-world modeling.

===============================================================================
2️⃣ AGGREGATION — (Weak HAS-A Relationship)
-------------------------------------------
✔ Meaning:
   - Two objects are associated but independent.
   - Lifecycle does NOT depend on parent.

✔ Simple Definition:
   "Whole-part relationship where part can exist without the whole."

✔ Interview Definition:
   "Aggregation is a weak form of association where the contained object can exist independently of the container class."

✔ UML Notation:
      ○────────→ (Open diamond arrow)

✔ Real-World Examples:
   - Student HAS-A Department
   - Library HAS-A Books
   - Country HAS-A Prime Minister (prime minister can change)

-------------------------------- EXAMPLE --------------------------------------
*/

class Department {
    String name;
    Department(String name) { this.name = name; }
}

class Student {
    Department dept;  // Student HAS-A Department (Aggregation)

    Student(Department dept) {
        this.dept = dept;
    }
}

/*
Explanation:
------------
Even if the Student object is deleted, Department still exists.

Short Note:
✔ Aggregation = Independent object existence + weak ownership.

===============================================================================
3️⃣ COMPOSITION — (Strong HAS-A Relationship)
---------------------------------------------
✔ Meaning:
   - Parent fully owns the contained object.
   - Lifecycle is dependent → child cannot exist without parent.

✔ Simple Definition:
   "Whole-part relationship where part cannot exist outside the whole."

✔ Interview Definition:
   "Composition is a strong form of HAS-A where the contained object’s lifetime
    depends entirely on the parent class."

✔ UML Notation:
      ◆────────→ (Filled diamond arrow)

✔ Real-World Examples:
   - Human HAS-A Heart
   - House HAS-A Rooms
   - Car HAS-A Engine (usually composition)

-------------------------------- EXAMPLE --------------------------------------
*/

class Heart {
    void pump() {
        System.out.println("Heart pumping...");
    }
}

class Person {
    private Heart heart = new Heart(); // Composition

    void live() {
        heart.pump();
    }
}

/*
Explanation:
------------
If Person object is destroyed → Heart becomes meaningless.

Short Note:
✔ Composition = Dependent lifecycle + strong ownership.

===============================================================================
4️⃣ KEY DIFFERENCE TABLE
-----------------------------------------------

| Feature                        | Aggregation                    | Composition                        |
|--------------------------------|--------------------------------|-------------------------------------|
| Type of HAS-A                 | Weak                           | Strong                              |
| Object lifecycle              | Independent                    | Dependent                           |
| Ownership                     | Partial                        | Full                                |
| Object creation               | Often passed externally        | Created inside the class            |
| UML representation            | ○ (open diamond)               | ◆ (filled diamond)                  |
| Example                       | Student–Department            | Human–Heart                         |
| Coupling level                | Loose                          | Tight                               |
| Reusability                   | High                           | Limited                             |
| Responsibility                | Shared                         | Parent fully responsible            |

===============================================================================
5️⃣ MEMORY & CREATION DIFFERENCE
--------------------------------
✔ In Aggregation: Object may be created outside and injected.

✔ In Composition: Object is created inside constructor or field.

Example difference:
--------------------

Aggregation:
    Student s = new Student(new Department("CS"));

Composition:
    Person p = new Person(); // Person creates Heart internally

===============================================================================
6️⃣ WHEN TO USE WHICH?
--------------------------------

Use **Aggregation** when:
✔ Part can exist without the whole.
✔ Object can be reused by multiple owners.
✔ Example: Multiple students share same department.

Use **Composition** when:
✔ Part is essential and cannot exist alone.
✔ Replacement/destruction removes child object.
✔ Example: Without Human, Heart makes no sense.

===============================================================================
7️⃣ Full Demonstration
===============================================================================
*/

public class _18_AggregationVsCompositionComparison {

    public static void main(String[] args) {

        System.out.println("===== Aggregation Example =====");
        Department dept = new Department("Computer Science");
        Student s = new Student(dept);
        System.out.println("Student department: " + s.dept.name);

        System.out.println("\n===== Composition Example =====");
        Person p = new Person();
        p.live();
    }
}

/*
===============================================================================
📌 INTERVIEW SHORT ANSWERS
--------------------------------

✔ Q1: What is aggregation?
→ A weak HAS-A relationship where objects are independent.

✔ Q2: What is composition?
→ A strong HAS-A where child cannot exist without parent.

✔ Q3: Which relationship is stronger?
→ Composition.

✔ Q4: When to use aggregation over composition?
→ When object needs to be shared or reused.

✔ Q5: Does composition create tight coupling?
→ Yes.

===============================================================================
📌 FINAL SUMMARY FOR NOTEBOOK
--------------------------------

✔ Both Aggregation and Composition are HAS-A relationships.
✔ Aggregation → Independent lifecycle (weak relationship).
✔ Composition → Dependent lifecycle (strong relationship).
✔ Used for modeling real-world systems and improving modularity.

===============================================================================
*/
