/*
===============================================================================
🧠 HIERARCHICAL INHERITANCE IN JAVA — COMPLETE EXPLANATION
===============================================================================

📌 Definition:
Hierarchical Inheritance is a type of inheritance where **multiple child classes**
inherit from the **same single parent class**.

Example:
        Animal
       /   |    \
    Dog   Cat   Cow

All child classes share the same parent and can inherit common properties,
but each child can add its own unique behavior.

This represents **one parent → many children**.


===============================================================================
📌 BASIC SYNTAX OF HIERARCHICAL INHERITANCE
===============================================================================

class Parent {
    // common fields and methods
}

class Child1 extends Parent {
    // specific behavior of Child1
}

class Child2 extends Parent {
    // specific behavior of Child2
}

===============================================================================
📌 EXAMPLE PROGRAM — HIERARCHICAL INHERITANCE
===============================================================================
*/

class Animal {    // Parent Class
    void eat() {
        System.out.println("Animal is eating...");
    }
}

// Child Class 1
class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking...");
    }
}

// Child Class 2
class Cat extends Animal {
    void meow() {
        System.out.println("Cat is meowing...");
    }
}

// Child Class 3
class Cow extends Animal {
    void moo() {
        System.out.println("Cow is mooing...");
    }
}

public class _5_HierarchicalInheritance {
    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.eat();   // Inherited method
        dog.bark();

        Cat cat = new Cat();
        cat.eat();   // Inherited method
        cat.meow();

        Cow cow = new Cow();
        cow.eat();   // Inherited method
        cow.moo();
    }
}


/*
===============================================================================
📌 OUTPUT:
--------------------------------
Animal is eating...
Dog is barking...
Animal is eating...
Cat is meowing...
Animal is eating...
Cow is mooing...
===============================================================================

===============================================================================
🎯 KEY POINTS ABOUT HIERARCHICAL INHERITANCE
===============================================================================
✔ Single Parent Class with multiple child classes  
✔ Promotes code reuse (common logic stored in parent class)  
✔ Each subclass can add or override functionality  
✔ Supports runtime polymorphism using parent reference  

Example:

Animal a = new Dog();
Animal a2 = new Cat();

-------------------------------------------------------------------------------

📌 WHAT CAN BE USED:
✔ Method overriding
✔ `super` keyword
✔ Polymorphism
✔ Accessing parent class fields and methods
✔ Upcasting (Parent reference → Child object)

📌 NOT ALLOWED:
❌ Multiple inheritance of classes  
❌ Reducing method visibility while overriding  
❌ Inheriting constructors  
❌ Overriding static, private, or final methods  

-------------------------------------------------------------------------------

📌 WHEN SHOULD HIERARCHICAL INHERITANCE BE USED?
Use it when:
✔ Multiple classes share common functionality  
✔ There is a natural "category → types" structure  
✔ You want code reuse and method overriding

Examples:
✔ Vehicle → Car, Bike, Truck  
✔ Shape → Circle, Square, Triangle  
✔ Employee → Manager, Developer, Intern  

Avoid when:
✖ Subclasses do NOT logically share parent behavior  
✖ Parent class design may change frequently  
✖ Too much shared logic creates rigid structure  

-------------------------------------------------------------------------------

📌 PROPERTIES OF HIERARCHICAL INHERITANCE
✔ Parent class acts as a blueprint  
✔ Common features exist in parent  
✔ Child class adds specialization  
✔ Supports polymorphism (same method, different implementation)  

-------------------------------------------------------------------------------

📌 ADVANTAGES
✔ Better organization of related subclasses  
✔ Maximum code reusability  
✔ Reduces duplicate code  
✔ Supports abstraction and polymorphism  

-------------------------------------------------------------------------------

📌 DISADVANTAGES
✖ Parent modification may break multiple subclasses  
✖ Complex hierarchy if misused  
✖ Tight coupling between parent and children  

-------------------------------------------------------------------------------

📌 REAL-LIFE EXAMPLES
✔ BankAccount → SavingsAccount, CurrentAccount, FixedDeposit  
✔ Shape → Rectangle, Square, AreaCalculator  
✔ User → Admin, Customer, Guest  

-------------------------------------------------------------------------------

📌 MOST COMMON INTERVIEW QUESTIONS
===============================================================================
1️⃣ What is hierarchical inheritance?
2️⃣ Give a real-life example of hierarchical inheritance.
3️⃣ Why is hierarchical inheritance useful?
4️⃣ Can child classes communicate with each other?  
5️⃣ Can a subclass inherit another subclass?
6️⃣ Does Java support hierarchical inheritance with interfaces?
7️⃣ Can hierarchical inheritance be combined with multilevel inheritance?
8️⃣ How does polymorphism work in hierarchical inheritance?
9️⃣ Which access modifiers affect inheritance?
🔟 Why constructors are not inherited?

-------------------------------------------------------------------------------

📌 DETAILED INTERVIEW ANSWERS
===============================================================================

✔ Q1: What is hierarchical inheritance?

➡ Answer:
"Hierarchical inheritance is a type of inheritance where a single parent class 
is inherited by multiple child classes. Each child class shares common behavior 
from the parent but can add its own features."

-------------------------------------------

✔ Q2: Give a real-life example.

➡ Answer:
"Vehicle is the parent class and Car, Bike, and Truck are child classes. 
All share common characteristics like start(), speed, and stop(), while 
child classes have unique behaviors."

-------------------------------------------

✔ Q3: Why is hierarchical inheritance useful?

➡ Answer:
"It avoids code duplication and ensures common functionality remains in one 
place—the parent class. It also supports polymorphism and method overriding."

-------------------------------------------

✔ Q4: Do child classes inherit from each other?

➡ Answer:
"No. They only inherit from the parent class, not from sibling classes."

-------------------------------------------

✔ Q5: How does polymorphism work in hierarchical inheritance?

➡ Answer:
"Using the parent class reference, we can point to multiple child objects 
and override behavior at runtime."

Example:
Animal a = new Dog();
a.eat();

-------------------------------------------

✔ Q6: Are private fields inherited?

➡ Answer:
"Private members are inherited but cannot be accessed directly. They can be 
accessed using protected or public methods."

-------------------------------------------

✔ Q7: Can hierarchical and multilevel inheritance be combined?

➡ Answer:
"Yes. Example: Vehicle → Car → ElectricCar AND Vehicle → Bike."

-------------------------------------------

✔ Q8: Do child classes override methods from the parent?

➡ Answer:
"They can override if needed, especially for runtime polymorphism."

-------------------------------------------------------------------------------

📌 SHORT INTERVIEW SUMMARY
===============================================================================
"Hierarchical inheritance occurs when multiple subclasses inherit from a single 
parent class. It allows code reuse, reduces duplication, and supports overriding 
and polymorphism. However, it can create tight coupling, so it should only be 
used when subclasses share true common behavior."

===============================================================================
END OF NOTES
===============================================================================
*/
