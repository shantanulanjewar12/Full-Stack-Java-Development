// ============================================================
// 🔹 _4_4_AnonymousInnerClass.java
// ============================================================
// Topic: Anonymous Inner Class in Java
// Author: Shantanu Lanjewar
// ============================================================

/*
===============================================================================
💡 WHAT IS AN ANONYMOUS INNER CLASS?
===============================================================================
An **Anonymous Inner Class** is a class:
✔ Without a name  
✔ Declared and instantiated at the SAME time  
✔ Used for *one-time use*, short-lived implementations  

It is most commonly used to:
✔ Override methods of a class  
✔ Provide implementation for an interface  
✔ Implement event-handlers / callbacks  

Syntax:
    ParentType obj = new ParentType() {
          // override methods here
    };

===============================================================================
💡 WHEN TO USE ANONYMOUS INNER CLASS?
===============================================================================
✔ When you need a class **only once**  
✔ When writing full class separately is unnecessary  
✔ For event handling, listeners, button clicks  
✔ For passing behavior as an object  
✔ For Thread creation without creating a separate class  

Examples:
- Runnable thread logic  
- Comparator for sorting  
- Swing button listeners  
- Android onClickListeners  

===============================================================================
🔹 RULES OF ANONYMOUS INNER CLASS
===============================================================================

1️⃣ Must extend a class **or** implement an interface  
2️⃣ Cannot have explicit constructors  
3️⃣ Can access only **effectively final** local variables  
4️⃣ Cannot have static members  
5️⃣ Only one object can be created (class has no name)  
6️⃣ Mostly used inside methods  

===============================================================================
🔹 TYPES OF ANONYMOUS INNER CLASS
===============================================================================
1️⃣ Anonymous class implementing an interface  
2️⃣ Anonymous class extending a class  
3️⃣ Anonymous class inside method / argument  

===============================================================================
🔹 EXAMPLE 1 — Anonymous Class Implementing Interface
===============================================================================
*/

interface Greeting {
    void sayHello();
}

class AnonymousExample1 {

    void greet() {

        Greeting obj = new Greeting() { // Anonymous inner class

            @Override
            public void sayHello() {
                System.out.println("Hello from Anonymous Inner Class!");
            }
        };

        obj.sayHello();
    }
}

/*
===============================================================================
🔹 EXAMPLE 2 — Anonymous Class Extending a Class
===============================================================================
*/

class Animal {

    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class AnonymousExample2 {

    void createAnimal() {

        Animal dog = new Animal() {   // Anonymous subclass

            @Override
            void makeSound() {
                System.out.println("Dog (Anonymous Class): Woof Woof!");
            }
        };

        dog.makeSound();
    }
}

/*
===============================================================================
🔹 EXAMPLE 3 — Anonymous Class for Thread (Real-World Use Case)
===============================================================================
*/

class AnonymousThreadExample {

    void createThread() {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread running using Anonymous Inner Class...");
            }
        });

        t.start();
    }
}

/*
===============================================================================
🔹 EXAMPLE 4 — Anonymous Class in Method Argument (Most Common)
===============================================================================
*/

class Button {

    void setOnClickListener(ClickListener listener) {
        listener.onClick();
    }
}

interface ClickListener {
    void onClick();
}

class AnonymousExample4 {

    void simulateButtonClick() {

        Button btn = new Button();

        btn.setOnClickListener(new ClickListener() {

            @Override
            public void onClick() {
                System.out.println("Button clicked! (Anonymous Listener)");
            }
        });
    }
}

/*
===============================================================================
🔹 MAIN CLASS – DEMONSTRATION
===============================================================================
*/

public class _8_AnonymousInnerClass {
    public static void main(String[] args) {

        System.out.println("===== Anonymous Class Implementing Interface =====");
        new AnonymousExample1().greet();

        System.out.println("\n===== Anonymous Class Extending a Class =====");
        new AnonymousExample2().createAnimal();

        System.out.println("\n===== Anonymous Class for Thread =====");
        new AnonymousThreadExample().createThread();

        System.out.println("\n===== Anonymous Class in Method Argument =====");
        new AnonymousExample4().simulateButtonClick();
    }
}

/*
===============================================================================
🔹 ADVANTAGES OF ANONYMOUS INNER CLASS
===============================================================================
✔ Reduces boilerplate code  
✔ Provides quick implementation  
✔ Ideal for event-handlers and callbacks  
✔ Useful for multi-threading  
✔ Improves code readability when used properly  

===============================================================================
🔹 LIMITATIONS
===============================================================================
❌ Cannot reuse the class (no name)  
❌ Cannot define constructors  
❌ Cannot have static members  
❌ Harder to debug if overused  
❌ Can decrease readability for complex logic  

===============================================================================
🔹 INTERVIEW QUESTIONS (WITH ANSWERS)
===============================================================================

Q1️⃣ What is an anonymous inner class?  
👉 A nameless class created for one-time use, typically to override a method.

------------------------------------

Q2️⃣ Can anonymous inner class have constructors?  
👉 ❌ No. But initialization blocks can be used.

------------------------------------

Q3️⃣ Can anonymous inner class extend a class?  
👉 ✔ Yes.

------------------------------------

Q4️⃣ Can it implement an interface?  
👉 ✔ Yes.

------------------------------------

Q5️⃣ Can anonymous inner class declare static members?  
👉 ❌ No, except static final constants.

------------------------------------

Q6️⃣ Can we create multiple objects of anonymous inner class?  
👉 ✔ Yes, but each object will create a new anonymous class instance.

------------------------------------

Q7️⃣ Why must local variables be effectively final?  
👉 Because Java copies the variable value into anonymous class instance.

------------------------------------

Q8️⃣ Can anonymous inner class be used outside method?  
👉 ✔ Yes, but typically used inside methods.

===============================================================================
🔹 TRICKY QUESTIONS
===============================================================================

⭐ Q1: How to initialize fields in anonymous inner class?  
👉 Using instance initializer block:

    Object obj = new Object() {
        {
            System.out.println("Init block runs like constructor");
        }
    };

------------------------------------

⭐ Q2: Can anonymous inner class implement multiple interfaces?  
👉 ❌ No, same rule as class inheritance applies (single inheritance).

------------------------------------

⭐ Q3: What is generated class name for anonymous inner class?  
👉 Something like:
       OuterClass$1.class  
       OuterClass$2.class  
   (Compiler-generated numbers)

------------------------------------

⭐ Q4: Is anonymous inner class same as lambda expression?  
👉 ❌ No.  
   Lambdas work only with **functional interfaces**, anonymous class works with ANY class/interface.

------------------------------------

⭐ Q5: Can anonymous inner class override final methods of parent?  
👉 ❌ No.

===============================================================================
🔹 INTERVIEW SUMMARY (SPOKEN VERSION)
===============================================================================

“An anonymous inner class is a nameless class created to override methods on
the spot. It is used when a class is needed only once—especially for event
handling, callbacks, or thread logic. It cannot have a constructor, static
members, or access non-final local variables. Anonymous classes allow quick,
clean inline implementations.”

===============================================================================
*/
