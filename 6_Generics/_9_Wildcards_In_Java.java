import java.util.ArrayList;
import java.util.List;

public class _9_Wildcards_In_Java {

    /*
     ===========================================================================
      WHAT ARE WILDCARDS IN JAVA GENERICS?
     ===========================================================================
     • A wildcard is represented by a question mark (?) and is used to refer
       to an **unknown type**.
     • Wildcards enable *flexibility* when working with generic classes
       and methods — especially with inheritance and collection operations.

     3 Types of Wildcards:
       1) Unbounded wildcard              →   ?
       2) Upper bounded wildcard          →   ? extends T
       3) Lower bounded wildcard          →   ? super T
    */

    public static void main(String[] args) {

        /*
         ===========================================================================
          1️⃣ UNBOUNDED WILDCARD ( ? )
         ===========================================================================
         • Accepts ANY type
         • Useful when working with code that does not depend on specific type
         • READ-ONLY (can't safely add, only read)
        */

        System.out.println("=== Unbounded Wildcard ===");
        List<String> strList = List.of("A", "B", "C");
        printList(strList);

        List<Integer> intList = List.of(10, 20, 30);
        printList(intList);


        /*
         ===========================================================================
          2️⃣ UPPER BOUNDED WILDCARD ( ? extends Type )
         ===========================================================================
         • Accepts Type or its subclasses
         • Used when reading values (safe)
         • You can READ but CANNOT WRITE (except null)
         • PECS Rule → Producer Extends
        */

        System.out.println("\n=== Upper Bounded Wildcard ===");
        List<Integer> nums = List.of(1, 2, 3);
        System.out.println("Sum = " + sumNumbers(nums)); // OK: Integer extends Number


        /*
         ===========================================================================
          3️⃣ LOWER BOUNDED WILDCARD ( ? super Type )
         ===========================================================================
         • Accepts Type or its **superclasses**
         • Used when writing values safely
         • PECS Rule → Consumer Super
        */

        System.out.println("\n=== Lower Bounded Wildcard ===");
        List<Object> objects = new ArrayList<>();
        addIntegers(objects);
        System.out.println("Objects with integers: " + objects);
    }

    // --- Unbounded Wildcard Method ---
    public static void printList(List<?> list) {
        for (Object element : list) {
            System.out.println("Item: " + element);
        }
    }

    // --- Upper Bound Wildcard Method Example ---
    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    // --- Lower Bound Wildcard Method Example ---
    public static void addIntegers(List<? super Integer> list) {
        list.add(100);
        list.add(200);
        list.add(300);
    }
}

/*
===============================================================================
  PECS PRINCIPLE  (VERY IMPORTANT)
===============================================================================

🔑 **PECS = Producer Extends, Consumer Super**

Use →         When?
? extends T   When the object PRODUCES data to be read (safe to read)
? super T     When the object CONSUMES data we want to write (safe to write)

Example:
• List<? extends Number> → good for reading numbers, NOT adding
• List<? super Integer>  → safe for adding Integers

===============================================================================
  SUMMARY TABLE FOR QUICK REVISION
===============================================================================

Wildcard       | Meaning                             | Read      | Write
---------------|--------------------------------------|-----------|-----------
?              | Unknown type                         | ✔️ Yes    | ❌ No
? extends T    | T or subclass of T                   | ✔️ Yes    | ❌ No
? super T      | T or superclass of T                 | ✔️ Yes    | ✔️ Yes (only T or subclass)

===============================================================================
  REAL USE CASES
===============================================================================

✔ Reading numeric lists safely                       → List<? extends Number>
✔ Adding specific types to a collection               → List<? super Integer>
✔ Generic utilities where type isn’t important        → print(List<?> list)
✔ Flexible APIs and library design

===============================================================================
  INTERVIEW QUESTIONS & ANSWERS
===============================================================================

Q1. What is a wildcard in Java Generics?
→ A special type (?) that represents an unknown type, mainly used to 
  increase API flexibility.

Q2. Difference between <? extends T> and <? super T>?
→ ? extends T → upper bound (read only, producer)
→ ? super T → lower bound (write allowed, consumer)

Q3. What is the PECS rule?
→ Producer Extends, Consumer Super — mnemonic to choose wildcard type.

Q4. Can we add elements to List<? extends Number>?
→ ❌ No (except null) — because actual subtype is unknown.

Q5. Why use wildcards?
→ To write more flexible, reusable, and type-safe generic APIs.

===============================================================================
  COMMON ERRORS & FIXES
===============================================================================

❌ Error: "capture of ?"
→ Happens when trying to add invalid type with wildcards  
✔ Fix: Decide between extends or super based on PECS rule

❌ Error: incompatible bounds
→ Means mixing extends & super incorrectly or violating inheritance rules

===============================================================================
 END OF FILE
===============================================================================
*/
