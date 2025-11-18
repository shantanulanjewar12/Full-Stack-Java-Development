/*
===============================================================================
📌 _24_UpcastingDowncasting.java
===============================================================================
This file explains two important OOP casting concepts in Java:

    1️⃣ Upcasting   → Parent reference holding Child object
    2️⃣ Downcasting → Child reference retrieved from Parent reference

Casting applies ONLY when classes are connected by INHERITANCE.

===============================================================================
1️⃣ What is Upcasting?
===============================================================================

✔ Simple Definition:
Upcasting means storing a Child class object in a Parent class reference.

✔ Interview Definition:
Upcasting is the process of treating a subclass object as a reference of its 
superclass. It is implicit and used to enable runtime polymorphism.

✔ Technical Definition:
In upcasting, Java performs WIDENING conversion where the reference type moves 
UP the inheritance hierarchy. Only the methods available in the parent class 
(or overridden ones) are accessible.

-------------------------------------------------------------------------------
✔ Syntax:
-------------------------------------------------------------------------------
Parent ref = new Child();     // Implicit (no casting needed)

-------------------------------------------------------------------------------
✔ Example:
-------------------------------------------------------------------------------
*/

class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }

    void wagTail() {
        System.out.println("Dog wags tail");
    }
}

class UpcastingExample {
    void demo() {
        Animal a = new Dog(); // Upcasting
        a.sound();            // Calls Dog's overridden method (runtime polymorphism)
        // a.wagTail();       // ❌ Not allowed (Parent type can't see child-specific methods)

        /*
        WHY sound() calls Dog's method?
        👉 Because method resolution occurs at runtime based on OBJECT type, 
           NOT reference type.
        */
    }
}

/*
-------------------------------------------------------------------------------
🧠 Behavior of Methods in Upcasting
-------------------------------------------------------------------------------
| Feature                          | Allowed? | Reason |
|----------------------------------|----------|--------|
| Parent methods                  | ✔ Yes    | Reference type decides accessibility |
| Overridden child methods        | ✔ Yes    | Runtime polymorphism |
| Child-specific methods          | ❌ No     | Not visible via parent reference |

-------------------------------------------------------------------------------
📌 Key Points About Upcasting
-------------------------------------------------------------------------------
✔ Happens automatically (implicit)
✔ Safe because child IS-A parent
✔ Used heavily in polymorphism and abstraction
✔ Only parent-visible behaviors are accessible

-------------------------------------------------------------------------------
📝 2–3 Line Notebook Summary:
Upcasting treats a child object as a parent reference. It is implicit, safe, and 
mainly used for runtime polymorphism. Only parent class members are accessible.
-------------------------------------------------------------------------------
*/

/*
===============================================================================
2️⃣ What is Downcasting?
===============================================================================

✔ Simple Definition:
Downcasting converts a Parent reference back into a Child reference.

✔ Interview Definition:
Downcasting is explicit narrowing conversion where a superclass reference 
holding a subclass object is cast back to subclass type to access subclass-specific 
features.

✔ Technical Definition:
Downcasting moves DOWN the inheritance chain and requires explicit cast. If 
invalid, it throws ClassCastException at runtime.

-------------------------------------------------------------------------------
✔ Syntax:
-------------------------------------------------------------------------------
Child ref = (Child) parentReference;  // Explicit cast required

-------------------------------------------------------------------------------
✔ Example:
-------------------------------------------------------------------------------
*/

class DowncastingExample {
    void demo() {
        Animal a = new Dog();   // Upcasting done first
        Dog d = (Dog) a;        // Downcasting

        d.sound();    // Allowed - overridden method
        d.wagTail();  // ✔ Now accessible
    }
}

/*
-------------------------------------------------------------------------------
⚠ IMPORTANT: Invalid Downcasting
-------------------------------------------------------------------------------

Animal a = new Animal();
Dog d = (Dog) a;  // ❌ Runtime Error: ClassCastException

Why?
👉 Because object was NEVER a Dog originally.

-------------------------------------------------------------------------------
✔ Safe Downcasting Using instanceof
-------------------------------------------------------------------------------
*/

class SafeDowncasting {
    void demo() {
        Animal a = new Dog();

        if (a instanceof Dog) {  // Safe check
            Dog d = (Dog) a;
            d.wagTail();
        } else {
            System.out.println("Invalid downcast!");
        }
    }
}

/*
-------------------------------------------------------------------------------
🧠 Behavior of Methods in Downcasting
-------------------------------------------------------------------------------
| Feature                          | Allowed? |
|----------------------------------|----------|
| Parent methods                  | ✔ Yes    |
| Overridden child methods        | ✔ Yes    |
| Child-specific methods          | ✔ Yes (after downcast) |

-------------------------------------------------------------------------------
📌 Key Points About Downcasting
-------------------------------------------------------------------------------
✔ Must be explicit (requires cast)
✔ Only valid if the original object is a child
✔ Use instanceof to avoid ClassCastException
✔ Enables access to subclass-specific behaviors

-------------------------------------------------------------------------------
📝 2–3 Line Notebook Summary:
Downcasting converts a parent reference back to child type. It must be explicit 
and valid only if the object was originally created as child. Use instanceof to 
avoid ClassCastException.
-------------------------------------------------------------------------------
*/

/*
===============================================================================
3️⃣ Real-World Analogy
===============================================================================
🎯 Upcasting:
"A dog IS-A animal."  
So referring to a Dog as an Animal makes sense.

🎯 Downcasting:
"But you cannot assume any animal is a dog, unless checked."

===============================================================================
4️⃣ Full Practical Test
===============================================================================
*/

public class _22_UpcastingDowncasting {

    public static void main(String[] args) {

        System.out.println("===== Upcasting Demo =====");
        Animal a = new Dog();  // Upcasting
        a.sound();

        System.out.println("\n===== Unsafe Downcasting Demo =====");
        try {
            Animal a2 = new Animal();
            Dog d2 = (Dog) a2; // ❌ Runtime error
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e);
        }

        System.out.println("\n===== Safe Downcasting Demo =====");
        Animal a3 = new Dog();
        if (a3 instanceof Dog) {
            Dog d3 = (Dog) a3;
            d3.wagTail();
        }
    }
}

/*
===============================================================================
📌 FINAL INTERVIEW SUMMARY
-----------------------------------------
✔ Upcasting:
   → Child object, parent reference
   → Implicit, safe
   → Enables runtime polymorphism
   → Only parent-visible features accessible

✔ Downcasting:
   → Parent reference to child reference
   → Explicit, risky → may cause ClassCastException
   → Use instanceof for safety
   → Unlocks child-specific methods

===============================================================================
*/
