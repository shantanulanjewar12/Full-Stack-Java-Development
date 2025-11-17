// ================= Parent Interface =================
interface Animal {
    void eat();
}

// ================= Another Interface =================
interface Pet {
    void friendly();
}

// ================= Class implementing one interface =================
class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog is eating...");
    }

    void bark() {
        System.out.println("Dog is barking...");
    }
}

// ================= Another Class extending Dog + implementing another interface =================
class Labrador extends Dog implements Pet {

    @Override
    public void friendly() {
        System.out.println("Labrador is friendly...");
    }

    void fetch() {
        System.out.println("Labrador fetches the ball...");
    }
}

// ================= Main Class =================
public class _7_HybridInheritance {
    public static void main(String[] args) {

        Labrador lab = new Labrador();

        // Inherited from Animal interface
        lab.eat();

        // Inherited from Dog class
        lab.bark();

        // Implemented from Pet interface
        lab.friendly();

        // Own method
        lab.fetch();
    }
}




/*
===============================================================================
🧠 HYBRID INHERITANCE IN JAVA — EXPLANATION & WHY JAVA AVOIDS IT
===============================================================================

📌 Definition:
Hybrid Inheritance is a **combination of two or more types of inheritance**
patterns (such as single, multilevel, hierarchical, and multiple inheritance).

It may look like:

                A
              /   \
             B     C
              \   /
                D

This combines:
✔ Hierarchical Inheritance (A → B and A → C)
✔ Multiple Inheritance (B & C → D)

Because multiple inheritance is part of hybrid inheritance, it can introduce
ambiguity — particularly the **Diamond Problem**.

Therefore:  

👉 Java **does NOT support hybrid inheritance using classes**.

However:  
👉 Java **supports hybrid inheritance using interfaces**, as interfaces avoid ambiguity.

===============================================================================
📌 WHY JAVA AVOIDS HYBRID INHERITANCE WITH CLASSES?
===============================================================================

❌ Because hybrid inheritance can create confusion and ambiguity when:

- Different parent classes provide the **same method**
- The compiler cannot decide **which method version the subclass should inherit**

This leads to the **Diamond Problem**, which Java avoids by design.

===============================================================================
📌 HYBRID INHERITANCE EXAMPLE (NOT ALLOWED USING CLASSES)
===============================================================================

class A { void show(){ System.out.println("From A"); } }
class B extends A { void show(){ System.out.println("From B"); } }
class C extends A { void show(){ System.out.println("From C"); } }
class D extends B, C { } // ❌ NOT allowed in Java (error)

Java prevents this to avoid method conflict:
- Should D use B's show() or C's show()? → Ambiguity.

===============================================================================
📌 HYBRID INHERITANCE USING INTERFACES (ALLOWED)
===============================================================================

interface A {
    void display();
}

interface B extends A {
    void print();
}

class C implements B {
    @Override
    public void display() {
        System.out.println("Display from interface A");
    }

    @Override
    public void print() {
        System.out.println("Print from interface B");
    }
}

public class _7_HybridInheritance_WhyJavaAvoidsIt {
    public static void main(String[] args) {
        C obj = new C();
        obj.display();
        obj.print();
    }
}

/*
===============================================================================
📌 OUTPUT:
--------------------------------
Display from interface A
Print from interface B
===============================================================================

===============================================================================
🎯 KEY POINTS ABOUT HYBRID INHERITANCE
===============================================================================
✔ Hybrid inheritance mixes multiple inheritance types
✔ Java prevents it with classes to avoid ambiguity
✔ Interfaces make hybrid inheritance possible safely
✔ Interfaces allow a class to implement multiple behaviors

-------------------------------------------------------------------------------

📌 WHAT IS ALLOWED:
✔ Hybrid inheritance using interfaces
✔ Default and static methods (with override rules)
✔ Multi-interface implementation

📌 WHAT IS NOT ALLOWED:
❌ Hybrid inheritance using multiple parent classes  
❌ Multiple inheritance with classes  
❌ Implicit resolution of conflicting methods  

-------------------------------------------------------------------------------

📌 WHEN SHOULD HYBRID INHERITANCE BE USED?
Use it when:
✔ System design requires multiple inherited behaviors
✔ You need to follow multiple roles or capabilities (Flyable, Runnable)
✔ You want flexibility and loose coupling via interfaces

Avoid it when:
✖ Implementation hierarchy becomes complex  
✖ Parent class logic conflicts may occur  

-------------------------------------------------------------------------------

📌 ADVANTAGES OF HYBRID INHERITANCE
✔ More flexible design  
✔ Multiple behaviors can be combined  
✔ Code reuse from different sources  
✔ Helps in large system architecture  

-------------------------------------------------------------------------------

📌 DISADVANTAGES OF HYBRID INHERITANCE
✖ Can lead to ambiguity (Diamond Problem)  
✖ Increases complexity and confusion  
✖ Harder debugging and maintenance  
✖ Tight coupling if implemented incorrectly  

-------------------------------------------------------------------------------

📌 REAL-LIFE EXAMPLES
✔ A modern device may support multiple roles:
   Smartphone → Phone + Camera + MusicPlayer  
✔ Vehicle → Car → ElectricCar (multilevel) + MusicSystem, GPS (interfaces)

-------------------------------------------------------------------------------

📌 COMMON INTERVIEW QUESTIONS
===============================================================================
1️⃣ What is hybrid inheritance?  
2️⃣ Does Java support hybrid inheritance? Why or why not?  
3️⃣ How does Java solve hybrid inheritance conflicts?  
4️⃣ Can hybrid inheritance be achieved using interfaces?  
5️⃣ What is the diamond problem, and how is it related?  
6️⃣ What happens if two interfaces have the same default method?  
7️⃣ How does Java handle ambiguity in interfaces?

-------------------------------------------------------------------------------

📌 DETAILED INTERVIEW ANSWERS
===============================================================================

✔ Q1: Does Java support hybrid inheritance?

➡ Answer:
"Java does not support hybrid inheritance using classes due to ambiguity and 
complex method resolution, but hybrid inheritance is possible using interfaces."

-------------------------------------------

✔ Q2: Why doesn't Java allow hybrid inheritance through classes?

➡ Answer:
"Because it includes multiple inheritance, which leads to the Diamond Problem — 
the compiler cannot decide which parent method should be inherited."

-------------------------------------------

✔ Q3: Can hybrid inheritance be implemented?

➡ Answer:
"Yes, using interfaces. A class can implement multiple interfaces and participate 
in hierarchical and multilevel structures safely."

-------------------------------------------

✔ Q4: How does Java avoid ambiguity?

➡ Answer:
"Java forces the child class to override conflicting methods and explicitly 
choose which version should be used."

-------------------------------------------

✔ Q5: What if two interfaces have the same default method?

➡ Answer:
"The class must override the method and resolve the conflict manually."

Example:
public void defaultMethod() { A.super.defaultMethod(); }

-------------------------------------------------------------------------------

📌 SHORT INTERVIEW SUMMARY
===============================================================================
"Hybrid inheritance combines multiple inheritance types like hierarchical and 
multilevel. Java avoids class-based hybrid inheritance to prevent ambiguity and 
the Diamond Problem. However, hybrid inheritance is supported using interfaces 
because they allow multiple inheritance safely and explicitly."

===============================================================================
END OF NOTES
===============================================================================
*/
