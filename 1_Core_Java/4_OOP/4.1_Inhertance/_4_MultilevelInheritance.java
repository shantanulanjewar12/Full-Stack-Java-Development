/*
===============================================================================
🧠 MULTILEVEL INHERITANCE IN JAVA — COMPLETE EXPLANATION
===============================================================================

📌 Definition:
Multilevel Inheritance is a type of inheritance in Java where a class inherits 
another class, which itself is a child of another parent class.

It forms a chain like:

    Grandparent → Parent → Child

Example:
    Animal → Mammal → Dog

Here:
✔ Mammal inherits from Animal  
✔ Dog inherits from Mammal  
✔ Therefore, Dog indirectly inherits Animal


===============================================================================
📌 BASIC SYNTAX OF MULTILEVEL INHERITANCE
===============================================================================

class A {
    // Class A members
}

class B extends A {
    // Class B inherits Class A
}

class C extends B {
    // Class C inherits Class B and indirectly Class A
}

===============================================================================
📌 EXAMPLE PROGRAM — MULTILEVEL INHERITANCE
===============================================================================
*/

class Animal {     // Level 1 (Grandparent)
    void eat() {
        System.out.println("Animal is eating...");
    }
}

class Mammal extends Animal {   // Level 2 (Parent)
    void walk() {
        System.out.println("Mammal is walking...");
    }
}

class Dog extends Mammal {      // Level 3 (Child)
    void bark() {
        System.out.println("Dog is barking...");
    }
}

public class _4_MultilevelInheritance {
    public static void main(String[] args) {

        Dog dog = new Dog();

        // Inherited from Animal
        dog.eat();

        // Inherited from Mammal
        dog.walk();

        // Own method
        dog.bark();
    }
}


/*
===============================================================================
📌 OUTPUT:
--------------------------------
Animal is eating...
Mammal is walking...
Dog is barking...
===============================================================================

===============================================================================
🎯 KEY POINTS ABOUT MULTILEVEL INHERITANCE
===============================================================================
✔ One class inherits another class which inherits another class  
✔ Creates an inheritance hierarchy  
✔ Child gets features of all ancestor classes  
✔ Method overriding is possible at multiple levels  
✔ Constructor call order always goes from top to bottom (super → parent → child)

===============================================================================
📌 WHEN SHOULD MULTILEVEL INHERITANCE BE USED?
===============================================================================
Use it when:
✔ You want hierarchical modelling  
✔ You want to extend functionality step-by-step  
✔ Real-life classification can be represented in layers

Example:
LivingBeing → Animal → Mammal → Dog → Labrador

Avoid when:
✖ There is no proper hierarchy  
✖ Parent class structure changes frequently (may break chain)

===============================================================================
📌 RULES & WHAT IS ALLOWED / NOT ALLOWED
===============================================================================
✔ Allowed:
    - Overriding methods in multiple levels
    - Using `super` to access parent level methods/variables
    - Casting using parent references

❌ Not Allowed:
    - Multiple inheritance of classes
    - Reducing access modifier visibility in overridden methods
    - Inheriting constructors directly

===============================================================================
📌 METHOD OVERRIDING IN MULTILEVEL INHERITANCE (Example)
===============================================================================

class A {
    void display() { System.out.println("Display from A"); }
}

class B extends A {
    @Override
    void display() { System.out.println("Display from B"); }
}

class C extends B {
    @Override
    void display() { System.out.println("Display from C"); }
}

===============================================================================
📌 PROPERTIES OF MULTILEVEL INHERITANCE
===============================================================================
✔ Increases extensibility  
✔ Supports polymorphism  
✔ Builds class hierarchy  
✔ Code reuse across multiple levels  

===============================================================================
📌 ADVANTAGES
===============================================================================
✔ Maximum code reuse (grandparent → parent → child)
✔ Logical categorization of classes
✔ Supports polymorphism and overriding
✔ Clean layer-by-layer extension of features

===============================================================================
📌 DISADVANTAGES
===============================================================================
✖ Tight coupling increases with depth  
✖ Difficult debugging if too many layers  
✖ A change in higher-level class may break multiple subclasses  
✖ Risk of fragile/inflexible design if misused  

===============================================================================
📌 REAL-LIFE EXAMPLES
===============================================================================
Cars:
    Vehicle → Car → ElectricCar

Education:
    Person → Student → GraduateStudent

Software UI:
    Component → Container → Frame

===============================================================================
📌 MOST COMMON INTERVIEW QUESTIONS
===============================================================================
1️⃣ What is multilevel inheritance? Give an example.  
2️⃣ How does multilevel inheritance differ from single inheritance?  
3️⃣ Why does Java avoid multiple inheritance but allow multilevel?  
4️⃣ Explain constructor execution order in multilevel inheritance.  
5️⃣ Can private members be inherited?  
6️⃣ Can we override a method in all levels?  
7️⃣ What happens if two parent classes have the same method?  
8️⃣ How does the super keyword behave in multilevel inheritance?  
9️⃣ What is the difference between multilevel inheritance and hierarchical inheritance?
🔟 Can we create an object of a parent class? Why?

===============================================================================
📌 DETAILED ANSWERS FOR INTERVIEW
===============================================================================

✔ Q1: What is multilevel inheritance?

➡ Answer: 
"Multilevel inheritance is a type of inheritance where a child class inherits 
from a parent class, and that parent class may itself inherit from another class, 
forming a chain. Example: Animal → Mammal → Dog.”

-------------------------------------------

✔ Q2: How is multilevel different from single inheritance?

➡ Answer:
"Single inheritance has one parent-child level, whereas multilevel inheritance 
has multiple inheritance levels where each subclass can become the parent of 
another subclass."

-------------------------------------------

✔ Q3: Why does Java support multilevel but not multiple inheritance?

➡ Answer:
"Multiple inheritance creates ambiguity known as the Diamond Problem, while 
multilevel inheritance has a clear hierarchical order without ambiguity, 
so Java supports it."

-------------------------------------------

✔ Q4: What is the constructor calling order in multilevel inheritance?

➡ Answer:
"Constructor execution always goes from the top ancestor class to the lowest class. 
The parent constructor executes before the child constructor."

-------------------------------------------

✔ Q5: Can private members be inherited?

➡ Answer:
"Private members are inherited but cannot be accessed directly in child classes. 
They can only be accessed via public or protected getters/setters."

-------------------------------------------

✔ Q6: Can a method be overridden at multiple levels?

➡ Answer:
"Yes. A method from the top-level parent can be overridden at every level of the 
inheritance chain."

-------------------------------------------

✔ Q7: What is the role of super() in multilevel inheritance?

➡ Answer:
"It is used to call the immediate parent class constructor or its methods."

-------------------------------------------

✔ Q8: Is multilevel inheritance good design?

➡ Answer:
"It is good when hierarchy is natural, but too many levels may create tight coupling."

===============================================================================
📌 SHORT INTERVIEW SUMMARY
===============================================================================
"Multilevel inheritance allows a class to inherit from another derived class, 
forming a chain such as A → B → C. It enables code reuse and polymorphism, but 
must be used carefully to avoid deep dependency chains."

===============================================================================
END OF NOTES
===============================================================================
*/
