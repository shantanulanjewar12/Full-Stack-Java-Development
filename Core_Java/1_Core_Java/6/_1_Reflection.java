/*
================================================================================
TOPIC : REFLECTION IN JAVA
FILE  : _14_Reflection.java
================================================================================

DEFINITION:
-----------
Reflection is an API in Java that allows a program to:
- Inspect classes, interfaces, methods, fields, constructors at RUNTIME
- Modify behavior of classes at runtime (even private members)

PACKAGE:
--------
java.lang.reflect

MAIN CLASSES:
-------------
Class
Method
Field
Constructor
Modifier

================================================================================
WHY REFLECTION?
================================================================================
✔ Used when class name is NOT known at compile time
✔ Used heavily in frameworks like:
   - Spring
   - Hibernate
   - JUnit
   - Jackson
✔ Used for:
   - Dependency Injection
   - ORM mapping
   - Serialization / Deserialization
   - Plugin systems

================================================================================
WHERE NOT TO USE REFLECTION?
================================================================================
✘ Performance critical code
✘ Simple applications
✘ When compile-time safety is required
✘ When normal method calls are sufficient

================================================================================
ADVANTAGES:
================================================================================
✔ Powerful
✔ Dynamic
✔ Framework-friendly

================================================================================
LIMITATIONS:
================================================================================
✘ Slow performance
✘ Breaks encapsulation
✘ No compile-time checking
✘ Security risk if misused

================================================================================
*/

import java.lang.reflect.*;

class Eagle {

    public String breed;
    private boolean canSwim;

    public Eagle() {
        this.breed = "Golden Eagle";
        this.canSwim = false;
    }

    public void fly() {
        System.out.println("Eagle is flying");
    }

    private void eat() {
        System.out.println("Eagle is eating");
    }
}

public class _1_Reflection {

    public static void main(String[] args) throws Exception {

        /*
        ============================================================================
        1️⃣ GETTING CLASS OBJECT (MOST IMPORTANT)
        ============================================================================
        There are 3 ways to get Class object
        */

        // 1. Using .class
        Class<?> class1 = Eagle.class;

        // 2. Using getClass()
        Eagle eagleObj = new Eagle();
        Class<?> class2 = eagleObj.getClass();

        // 3. Using Class.forName()
        Class<?> class3 = Class.forName("Eagle");

        System.out.println("Class Name: " + class1.getName());

        /*
        ============================================================================
        2️⃣ REFLECTION OF CLASS INFORMATION
        ============================================================================
        */

        System.out.println("\n--- CLASS INFO ---");
        System.out.println("Simple Name: " + class1.getSimpleName());
        System.out.println("Modifiers  : " + Modifier.toString(class1.getModifiers()));
        System.out.println("Package    : " + class1.getPackage());

        /*
        ============================================================================
        3️⃣ REFLECTION OF METHODS
        ============================================================================
        */

        System.out.println("\n--- getMethods() ---");
        // Returns ALL PUBLIC methods (including Object class methods)
        Method[] methods1 = class1.getMethods();
        for (Method m : methods1) {
            System.out.println(m.getName());
        }

        System.out.println("\n--- getDeclaredMethods() ---");
        // Returns ALL methods of this class only (public + private)
        Method[] methods2 = class1.getDeclaredMethods();
        for (Method m : methods2) {
            System.out.println(
                    "Method: " + m.getName() +
                    ", ReturnType: " + m.getReturnType() +
                    ", Modifier: " + Modifier.toString(m.getModifiers())
            );
        }

        /*
        ============================================================================
        4️⃣ INVOKING METHOD USING REFLECTION
        ============================================================================
        */

        System.out.println("\n--- INVOKING PUBLIC METHOD ---");
        Method flyMethod = class1.getMethod("fly");
        flyMethod.invoke(eagleObj);

        System.out.println("\n--- INVOKING PRIVATE METHOD ---");
        Method eatMethod = class1.getDeclaredMethod("eat");
        eatMethod.setAccessible(true); // IMPORTANT
        eatMethod.invoke(eagleObj);

        /*
        ============================================================================
        5️⃣ REFLECTION OF FIELDS
        ============================================================================
        */

        System.out.println("\n--- getFields() ---");
        // Returns ONLY public fields
        Field[] fields1 = class1.getFields();
        for (Field f : fields1) {
            System.out.println(
                    "Field: " + f.getName() +
                    ", Type: " + f.getType()
            );
        }

        System.out.println("\n--- getDeclaredFields() ---");
        // Returns ALL fields (public + private)
        Field[] fields2 = class1.getDeclaredFields();
        for (Field f : fields2) {
            System.out.println(
                    "Field: " + f.getName() +
                    ", Type: " + f.getType() +
                    ", Modifier: " + Modifier.toString(f.getModifiers())
            );
        }

        /*
        ============================================================================
        6️⃣ ACCESS & MODIFY PRIVATE FIELD
        ============================================================================
        */

        System.out.println("\n--- MODIFY PRIVATE FIELD ---");
        Field swimField = class1.getDeclaredField("canSwim");
        swimField.setAccessible(true);
        swimField.set(eagleObj, true);

        System.out.println("Private field 'canSwim' modified using Reflection");

        /*
        ============================================================================
        7️⃣ REFLECTION OF CONSTRUCTORS
        ============================================================================
        */

        System.out.println("\n--- CONSTRUCTORS ---");
        Constructor<?>[] constructors = class1.getDeclaredConstructors();
        for (Constructor<?> c : constructors) {
            System.out.println(
                    "Constructor: " + c.getName() +
                    ", Modifier: " + Modifier.toString(c.getModifiers())
            );
        }

        /*
        ============================================================================
        INTERVIEW QUESTIONS (VERY IMPORTANT)
        ============================================================================
        */

        /*
        Q1. What is Reflection in Java?
        → Runtime inspection & modification of class structure.

        Q2. Which package is used for Reflection?
        → java.lang.reflect

        Q3. Difference between getMethods() & getDeclaredMethods()?
        → getMethods(): public + inherited
        → getDeclaredMethods(): all methods of class only

        Q4. Can we access private members using Reflection?
        → Yes, using setAccessible(true)

        Q5. Is Reflection slow?
        → Yes, slower than normal calls

        Q6. Is Reflection secure?
        → No, it can break encapsulation

        Q7. Where is Reflection used?
        → Frameworks (Spring, Hibernate)

        Q8. How many Class objects JVM creates?
        → One Class object per loaded class

        Q9. Can Reflection change method behavior?
        → Yes (advanced usage)

        Q10. Why all methods in Class are GET methods?
        → Because Class holds metadata, not behavior changes
        */

        System.out.println("\n--- END OF REFLECTION DEMO ---");
    }
}
