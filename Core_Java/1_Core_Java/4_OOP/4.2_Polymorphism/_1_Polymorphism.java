/*

📌 Definition:
Polymorphism means **"many forms"**.  
In Java, polymorphism allows a single action/method name to behave differently
based on the object that is calling it.

👉 Same method name → different behavior  
👉 Achieved using Method Overloading & Method Overriding

===============================================================================
📌 WHY POLYMORPHISM IS IMPORTANT?
===============================================================================
✔ Improves flexibility and scalability  
✔ Makes code reusable and maintainable  
✔ Enables dynamic behavior at runtime  
✔ Supports abstraction and inheritance  

===============================================================================
📌 TYPES OF POLYMORPHISM IN JAVA
===============================================================================

1️⃣ Compile-Time Polymorphism (Static Binding) → Method Overloading  
2️⃣ Runtime Polymorphism (Dynamic Binding) → Method Overriding

===============================================================================
📌 1️⃣ COMPILE-TIME POLYMORPHISM — METHOD OVERLOADING
===============================================================================

📌 Definition:
Method Overloading occurs when multiple methods in the same class share the same
method name but have **different parameters (type, count, or order).**

✔ Decided at compile time  
✔ Supported by:
   - Different number of parameters
   - Different type of parameters
   - Different order of parameters

❌ Return type alone CANNOT distinguish overloaded methods.

-------------------------------------------------------------------------------
📌 Overloading Example
-------------------------------------------------------------------------------
*/

class Calculator {

    int add(int a, int b) {  // Method 1
        return a + b;
    }

    double add(double a, double b) { // Method 2
        return a + b;
    }

    int add(int a, int b, int c) { // Method 3
        return a + b + c;
    }
}


/*
===============================================================================
📌 2️⃣ RUNTIME POLYMORPHISM — METHOD OVERRIDING
===============================================================================

📌 Definition:
Method Overriding occurs when a **child class redefines** a method with the same:
✔ method name  
✔ return type  
✔ parameters  

It allows the same method call to behave differently based on runtime object type.

✔ Decided at runtime  
✔ Requires inheritance  

-------------------------------------------------------------------------------
📌 Overriding Example
-------------------------------------------------------------------------------
*/

class Animal {
    void sound() {
        System.out.println("Animal makes a sound...");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks...");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows...");
    }
}


/*
===============================================================================
📌 MAIN CLASS — DEMONSTRATING BOTH POLYMORPHISMS
===============================================================================
*/

public class _1_Polymorphism {
    public static void main(String[] args) {

        // Compile-Time Polymorphism (Overloading)
        Calculator calc = new Calculator();
        System.out.println("Add(2,3): " + calc.add(2,3));
        System.out.println("Add(2.5,3.5): " + calc.add(2.5,3.5));
        System.out.println("Add(1,2,3): " + calc.add(1,2,3));


        // Runtime Polymorphism (Overriding)
        Animal a;

        a = new Dog();
        a.sound(); // Dog barks...

        a = new Cat();
        a.sound(); // Cat meows...
    }
}


/*
===============================================================================
📌 OUTPUT:
--------------------------------
Add(2,3): 5
Add(2.5,3.5): 6.0
Add(1,2,3): 6

Dog barks...
Cat meows...
===============================================================================

===============================================================================
🎯 KEY RULES FOR POLYMORPHISM
===============================================================================

✔ Overriding must have SAME method signature  
✔ Overloading must have DIFFERENT parameter list  
✔ Overriding supports runtime polymorphism via inheritance  
✔ Parent reference can refer to child object (Upcasting)

    Animal a = new Dog();  // Allowed
    Dog d = new Animal();  // ❌ Not allowed (downcasting needs explicit cast)

===============================================================================
📌 WHAT IS ALLOWED & NOT ALLOWED?
===============================================================================

✔ Allowed:
- Overloading constructors and methods  
- Overriding inherited methods  
- Increasing method visibility in overriding (protected → public)  

❌ Not Allowed:
- Overriding:
   ⛔ static methods → (method hiding)
   ⛔ private methods → not visible to child
   ⛔ final methods → cannot override

- Using return type alone to overload
- Reducing visibility in overriding

===============================================================================
📌 ADVANTAGES OF POLYMORPHISM
===============================================================================

✔ Enhances flexibility  
✔ Reduces duplicate code  
✔ Enables dynamic method dispatch  
✔ Makes systems extensible (add new subclasses easily)

===============================================================================
📌 DISADVANTAGES
===============================================================================

✖ May be harder to debug  
✖ Slightly slower due to runtime binding  
✖ Incorrect overriding can break behavior  

===============================================================================
📌 REAL-LIFE SCENARIOS
===============================================================================

✔ Payment system → PayPal, UPI, DebitCard
✔ Shape drawing → draw(circle), draw(square)
✔ Notification → SMS, Email, Push Notification

===============================================================================
📌 MOST COMMON INTERVIEW QUESTIONS (WITH SHORT ANSWERS)
===============================================================================

1️⃣ What is polymorphism?
➡ Ability of one name but different behavior.

2️⃣ Types?
➡ Compile-time (overloading), Runtime (overriding).

3️⃣ Difference between Overloading and Overriding?
➡ Overloading = compile time, same method name different params.  
➡ Overriding = runtime, same signature, child changes parent behavior.

4️⃣ Can we override static methods?
➡ ❌ No → method hiding occurs.

5️⃣ Can constructors be overloaded?
➡ ✔ Yes, constructor overloading is allowed.

6️⃣ Can constructors be overridden?
➡ ❌ No, because they are not inherited.

7️⃣ What is dynamic method dispatch?
➡ Runtime decision of which overridden method to execute.

8️⃣ Can private methods be overridden?
➡ ❌ No, private methods are not visible in subclasses.

9️⃣ Can final methods be overridden?
➡ ❌ No, they are locked from modification.

🔟 Why is polymorphism important?
➡ Enables flexible, scalable, and extensible object behavior.

===============================================================================
📌 SHORT INTERVIEW SUMMARY (20 sec)
===============================================================================
"Polymorphism allows the same method name to behave differently. Java supports 
two types: compile-time polymorphism via method overloading, and runtime 
polymorphism via method overriding. Method overriding uses inheritance and 
dynamic method dispatch, while overloading changes parameters within the same class."

===============================================================================
END OF NOTES
===============================================================================
*/
