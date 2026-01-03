// ============================================================
// 🔹 _4_NestedClass.java
// ============================================================
// Topic: Nested Classes in Java
// Author: Shantanu Lanjewar
// ============================================================

/*
===============================================================================
💡 WHAT IS A NESTED CLASS?
===============================================================================
A **Nested Class** is a class defined **inside another class**.

Syntax:
    class Outer {
        class Inner { }
    }

===============================================================================
💡 WHY USE NESTED CLASSES?
===============================================================================
✔ To logically group related classes into ONE place  
✔ Improves encapsulation  
✔ Helps when an inner class is ONLY used by the outer class  
✔ Reduces number of .java files  
✔ Used heavily in GUI frameworks, event handling, and concise code writing  

Example:
If class A is expected to be used ONLY inside class B,
→ Instead of creating separate A.java  
→ Define A **inside** class B (Nested Class)

===============================================================================
💡 SCOPE OF NESTED CLASS
===============================================================================
✔ The scope of a nested class is same as the outer class  
✔ Outer class controls access to nested class through access modifiers  
✔ Nested class can access all members of outer class, even private ones  

===============================================================================
🔹 TYPES OF NESTED CLASSES (VERY IMPORTANT)
===============================================================================

Nested classes are of 2 main types:

1️⃣ **Static Nested Class**  
2️⃣ **Non-static Nested Class (Inner Classes)**  
     - Member Inner Class  
     - Local Inner Class  
     - Anonymous Inner Class  

===============================================================================
🔹 1️⃣ STATIC NESTED CLASS
===============================================================================
✔ Declared using `static` keyword  
✔ Does NOT require outer class object to be created  
✔ Behaves like a separate top-level class but namespaced inside outer class  

Syntax:
    class Outer {
         static class Inner { }
    }

*/

class OuterStatic {

    static int staticValue = 10;

    static class Inner {  // Static nested class
        void show() {
            System.out.println("Inside Static Nested Class");
            System.out.println("Accessing outer static value: " + staticValue);
        }
    }
}

/*
===============================================================================
🔹 2️⃣ MEMBER INNER CLASS (Non-static)
===============================================================================
✔ Defined inside outer class WITHOUT static keyword  
✔ Requires outer class object to be created  
✔ Can access outer class variables (including private)  
*/

class OuterMember {

    private String message = "Hello from Outer Member Class";

    class Inner {   // Non-static inner class
        void display() {
            System.out.println("Inside Member Inner Class");
            System.out.println(message); // Accessing private outer member
        }
    }
}

/*
===============================================================================
🔹 3️⃣ LOCAL INNER CLASS
===============================================================================
✔ Defined inside a method  
✔ Scope only inside the method  
✔ Cannot be accessed outside the method  
*/

class OuterLocal {

    void showMessage() {

        class LocalInner { // Local inner class
            void print() {
                System.out.println("Inside Local Inner Class");
            }
        }

        LocalInner obj = new LocalInner();
        obj.print();
    }
}

/*
===============================================================================
🔹 4️⃣ ANONYMOUS INNER CLASS
===============================================================================
✔ A class with NO NAME  
✔ Used to override methods on the spot  
✔ Commonly used in event handling, threading, callback functions  

Syntax:
    new Interface/Class() {
        // overridden methods
    };

*/

interface Greet {
    void sayHello();
}

class AnonymousDemo {

    void createGreeting() {
        Greet obj = new Greet() {  // Anonymous inner class
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
🔹 MAIN CLASS – DEMONSTRATION
===============================================================================
*/

public class _4_NestedClass {
    public static void main(String[] args) {

        System.out.println("===== Static Nested Class Demo =====");
        OuterStatic.Inner inner1 = new OuterStatic.Inner();
        inner1.show();

        System.out.println("\n===== Member Inner Class Demo =====");
        OuterMember outer = new OuterMember();
        OuterMember.Inner inner2 = outer.new Inner();
        inner2.display();

        System.out.println("\n===== Local Inner Class Demo =====");
        OuterLocal obj = new OuterLocal();
        obj.showMessage();

        System.out.println("\n===== Anonymous Inner Class Demo =====");
        new AnonymousDemo().createGreeting();
    }
}

/*
===============================================================================
🔹 ADVANTAGES OF NESTED CLASSES
===============================================================================
✔ Better encapsulation  
✔ Logical grouping of related classes  
✔ Reduced .java files  
✔ Helps hide helper classes from outside world  
✔ Useful in event-driven programming  

===============================================================================
🔹 LIMITATIONS OF NESTED CLASSES
===============================================================================
❌ Increased complexity  
❌ Too many nested levels reduce readability  
❌ Harder to test and debug  
❌ Cannot be accessed freely like top-level classes  
❌ Local & Anonymous Inner Classes cannot have static members  

===============================================================================
🔹 WHEN TO USE NESTED CLASSES?
===============================================================================
✔ When inner class is used only by outer class  
✔ When helper/utility class is not needed anywhere else  
✔ To encapsulate small logic blocks inside method  
✔ To implement callbacks, event handlers (anonymous inner class)  

===============================================================================
🔹 WHEN NOT TO USE?
===============================================================================
❌ When classes grow large or need reuse  
❌ When inner class needs broad accessibility  
❌ When too many nested layers harm readability  

===============================================================================
🔹 INTERVIEW QUESTIONS (with answers)
===============================================================================

Q1️⃣ What is a nested class?  
👉 A class defined inside another class.

------------------------------------

Q2️⃣ Why are nested classes used?  
👉 To group related code, improve encapsulation, and limit class visibility.

------------------------------------

Q3️⃣ Difference between static nested and member inner class?  
👉 Static nested class:
       - Does NOT need outer object  
       - Can access only static members  
   Member inner class:
       - NEEDS outer object  
       - Can access all outer members  

------------------------------------

Q4️⃣ Can static nested class access non-static outer variables?  
👉 ❌ No. It can access only static outer members.

------------------------------------

Q5️⃣ What is an anonymous inner class?  
👉 A nameless class created to override methods quickly.

------------------------------------

Q6️⃣ Can local inner class have access modifiers (public/private)?  
👉 ❌ No. Only 'final' or 'abstract' allowed.

------------------------------------

Q7️⃣ Why are local inner class variables effectively final?  
👉 Because inner class object may outlive method execution.

------------------------------------

Q8️⃣ Can inner class have static members?  
👉 ❌ Only static final constants allowed.

------------------------------------

Q9️⃣ How is nested class loaded in memory?  
👉 After outer class is loaded, nested class loads only when used.

===============================================================================
🔹 TRICKY INTERVIEW QUESTIONS
===============================================================================

⭐ Q1: Can we create an object of inner class without outer class?  
👉 ❌ No (except static nested class)

⭐ Q2: Can an outer class be private?  
👉 ❌ No (but nested classes CAN be private)

⭐ Q3: Why use anonymous inner classes instead of lambda?  
👉 Before Java 8, anonymous class was only option  
👉 Lambda used only for functional interfaces

⭐ Q4: Which nested class is used in android event handling?  
👉 Anonymous inner class

===============================================================================
🔹 INTERVIEW SUMMARY (SPOKEN VERSION)
===============================================================================

“A nested class is a class defined inside another class. It helps in logically
grouping related classes, increasing encapsulation, and reducing the number of
files. Java has four types of nested classes: static nested class, member inner
class, local inner class, and anonymous inner class. Each has different usage
and behavior. Static nested class does not need outer object, while inner classes
can access all the outer class members. Anonymous classes are mainly used in
callbacks and event handling.”

===============================================================================
*/
