// ============================================================
// 🔹 _4_3_LocalInnerClass.java
// ============================================================
// Topic: Local Inner Class in Java
// Author: Shantanu Lanjewar
// ============================================================

/*
===============================================================================
💡 WHAT IS A LOCAL INNER CLASS?
===============================================================================
A **Local Inner Class** is a class defined **inside a method**, constructor, or
initializer block of an outer class.

Syntax:
    void test() {
        class LocalInner {
            ...
        }
    }

🔹 It is a *local* class → EXACTLY like a local variable of a method.

===============================================================================
💡 WHEN TO USE LOCAL INNER CLASS?
===============================================================================
✔ When a small class is needed only for a short operation  
✔ When class logic is closely tied to one specific method  
✔ Helps to keep code **modular and readable**  
✔ Useful in event handling, validations, comparators, callbacks  

Real-life example:
- Temporary validator class inside a method  
- Algorithms that need helper classes only during execution  

===============================================================================
🔹 RULES OF LOCAL INNER CLASS (VERY IMPORTANT)
===============================================================================

1️⃣ Defined INSIDE a method → only method can use it  
2️⃣ Cannot have access modifiers (public, private, protected)  
3️⃣ Can access:
     ✔ all members of outer class  
     ✔ local variables of method **ONLY if they are effectively final**

4️⃣ Cannot declare static members  
     ❌ static int x; (Not allowed)  
     ✔ static final constants allowed  

5️⃣ Object of local class must be created inside the same method.  
6️⃣ Scope is limited to the method ONLY.

===============================================================================
🔹 WHY MUST LOCAL VARIABLES BE "EFFECTIVELY FINAL"?
===============================================================================
Because inner class object may live longer than method execution.
Java copies the value into inner class object → must not change after creation.

Example:
    int x = 10;
    class Inner { 
        void show() { System.out.println(x); }
    }
    x = 20; ❌ Error → x is no longer effectively final

===============================================================================
🔹 EXAMPLE 1 — BASIC LOCAL INNER CLASS
===============================================================================
*/

class OuterLocalExample {

    private String message = "Hello from Outer Class";

    void display() {

        int number = 10;  // effectively final (not modified)

        // Local Inner Class
        class LocalInner {
            void show() {
                System.out.println("Inside Local Inner Class");
                System.out.println("Outer Message = " + message);
                System.out.println("Local Variable = " + number);
            }
        }

        LocalInner obj = new LocalInner();
        obj.show();
    }
}

/*
===============================================================================
🔹 EXAMPLE 2 — REAL-WORLD APPLICATION
    Using Local Inner Class for temporary validation logic
===============================================================================
*/

class UserValidator {

    void validateUser(String username, String password) {

        class Validator { // Local class for validation logic

            boolean isValid() {
                return username != null &&
                       password != null &&
                       username.length() >= 4 &&
                       password.length() >= 6;
            }
        }

        Validator v = new Validator();

        if (v.isValid()) {
            System.out.println("User is valid.");
        } else {
            System.out.println("Invalid user!");
        }
    }
}

/*
===============================================================================
🔹 MAIN CLASS – DEMONSTRATION
===============================================================================
*/

public class _7_LocalInnerClass {
    public static void main(String[] args) {

        System.out.println("===== Basic Local Inner Class Example =====");
        OuterLocalExample outer = new OuterLocalExample();
        outer.display();

        System.out.println("\n===== Real-world Example: User Validator =====");
        UserValidator validator = new UserValidator();
        validator.validateUser("john123", "secret123");
        validator.validateUser("abc", "123");
    }
}

/*
===============================================================================
🔹 ADVANTAGES OF LOCAL INNER CLASS
===============================================================================
✔ Good for method-specific, short-lived logic  
✔ Helps encapsulate helper functionality  
✔ Reduces clutter in outer class  
✔ Improves readability when class is not reused  

===============================================================================
🔹 LIMITATIONS
===============================================================================
❌ Cannot use access modifiers  
❌ Cannot have static members  
❌ Scope limited → cannot be used outside method  
❌ Overuse may reduce clarity  
❌ Local variables must be effectively final  

===============================================================================
🔹 INTERVIEW QUESTIONS (WITH ANSWERS)
===============================================================================

Q1️⃣ What is a local inner class?  
👉 A class defined inside a method of an outer class.

------------------------------------

Q2️⃣ Can local inner class access private outer members?  
👉 ✔ Yes, it can access ALL outer members.

------------------------------------

Q3️⃣ Can it access method variables?  
👉 ✔ Yes, but only if they are effectively final.

------------------------------------

Q4️⃣ Why must local variables be effectively final?  
👉 Because Java copies their value into inner object.

------------------------------------

Q5️⃣ Can local inner class have static members?  
👉 ❌ No, only static final constants allowed.

------------------------------------

Q6️⃣ Can we create object of local class outside method?  
👉 ❌ No, scope is limited to that method.

------------------------------------

Q7️⃣ What are valid modifiers for local inner class?  
👉 ❌ None (no public/private/protected)  

------------------------------------

Q8️⃣ Can local inner class be abstract?  
👉 ✔ Yes, abstract is allowed.

------------------------------------

Q9️⃣ Can local inner class implement interfaces?  
👉 ✔ Yes, it behaves like normal class otherwise.

===============================================================================
🔹 TRICKY QUESTIONS
===============================================================================

⭐ Q1: Can local inner class override a method?  
👉 ✔ Yes, it can extend a class or implement interface.

⭐ Q2: Can we return local inner class object from method?  
👉 ✔ Yes, but class type cannot be referenced outside.

⭐ Q3: Can a local inner class access both static & non-static outer members?  
👉 ✔ Yes.

⭐ Q4: What if local variable is modified after inner class creation?  
👉 ❌ Compile-time error.

⭐ Q5: Can local inner class be declared final?  
👉 ✔ Yes.

===============================================================================
🔹 SPOKEN SUMMARY (FOR INTERVIEW)
===============================================================================

“A local inner class is a class declared inside a method. It can access outer
class members and method local variables, provided they are effectively final.
It cannot have static members and cannot be used outside the method. Local
inner classes are useful for short-lived logic, validations, and helper
operations inside methods.”

===============================================================================
*/
