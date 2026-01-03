import java.util.ArrayList;
import java.util.List;

public class _1_JavaGenerics_Overview {

    /*
     ===========================================================================
      WHAT ARE GENERICS?
     ===========================================================================
     
     • Java Generics allow you to define classes, interfaces, and methods
       with **type parameters** so that a single definition can work with
       many different data types in a type-safe way. 

     • Introduced in Java 5.0 to improve type safety and code reusability. :contentReference[oaicite:2]{index=2}

     • Before generics, collections and other structures held Objects
       which required explicit casting — this could lead to runtime errors. :contentReference[oaicite:3]{index=3}
    */

    public static void main(String[] args) {

        /*
         ===========================================================================
          EXAMPLE: GENERIC LIST
         ===========================================================================
         
         Without generics:
         → You must manually cast elements when retrieving them,
           which is error-prone.

         With generics:
         → You specify the type parameter and get compile-time
           type safety (errors detected before running the program). :contentReference[oaicite:4]{index=4}
        */

        System.out.println("=== Generic List Example ===");

        // Using generics – List of Strings
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");   // OK
        stringList.add("Java");    // OK

        // stringList.add(100);     // ❌ Compile-time error (type mismatch)

        for (String s : stringList) {
            System.out.println("Value: " + s);
        }

        /*
         ===========================================================================
          WHY GENERICS ARE BETTER
         ===========================================================================
         
         1) **Stronger Type Checking at Compile Time**
            – Generics enforce type constraints at compile time.
            – Prevents inserting wrong types into collections. :contentReference[oaicite:5]{index=5}

         2) **Elimination of Explicit Type Casting**
            – No need to cast when retrieving elements:
                String s = stringList.get(0); // no cast needed
            – Without generics you would need to cast: 
                String s = (String) list.get(0);

         3) **Reusability**
            – One generic class/method works for multiple types,
               reducing code duplication. :contentReference[oaicite:6]{index=6}
        */

        System.out.println("\n=== Benefits of Generics in Action ===");
        System.out.println("List with generics protects against invalid types and avoids casts.");
    }
}

/*
===============================================================================
 GENERICS vs. RAW (OBJECT) TYPES
===============================================================================

Feature                      | Using Object (Raw)      | Using Generics
----------------------------|-------------------------|----------------------------
Type Safety                 | ❌ No compile-time check| ✅ Compile-time type check
Casting Needed              | ✔ Yes                  | ❌ No casting required
Readability                 | ❌ Less readable       | ✅ Cleaner code
Errors Detected            | ❌ at runtime           | ✅ at compile time
Performance Impact         | ✔ Overhead due to cast| ❌ Less overhead

Explanation:
• Raw (Object) collections store Object references, so retrieving an element
  requires casting and can lead to ClassCastException at runtime.
• Generics enforce the correct type at compile time, reducing bugs. :contentReference[oaicite:7]{index=7}

===============================================================================
 GENRIC CLASS – DEFINITION EXAMPLE
===============================================================================
Example of a simple generic class:

    public class Box<T> {
        private T value;

        public void set(T value) {
            this.value = value;
        }

        public T get() {
            return value;
        }
    }

Usage:

    Box<String> strBox = new Box<>();
    strBox.set("Generics!");
    System.out.println(strBox.get());

Explanation:
• `<T>` is a **type parameter** — a placeholder for a real type.
• When creating an instance, `T` is replaced by the actual type (`String`). :contentReference[oaicite:8]{index=8}

===============================================================================
 ADVANTAGES OF GENERICS
===============================================================================

1. **Type Safety**
   → Errors like trying to insert an Integer into a List<String> are
     caught at compile time. :contentReference[oaicite:9]{index=9}

2. **Reusable Code**
   → One class/method works with multiple types without rewriting it. :contentReference[oaicite:10]{index=10}

3. **No Casting Overhead**
   → Cleaner code without explicit type casts. :contentReference[oaicite:11]{index=11}

4. **Improved Readability"
   → Code using generics clearly shows what data types collections hold.

===============================================================================
 INTERVIEW QUESTIONS & ANSWERS
===============================================================================

Q1. What are generics in Java?
→ Generics allow classes, interfaces, and methods to operate on types
   specified when the code is used — improving type safety and reusability. :contentReference[oaicite:12]{index=12}

Q2. Why were generics introduced?
→ To add stronger compile-time type checks and eliminate many types
   of runtime errors related to type casting. :contentReference[oaicite:13]{index=13}

Q3. How do generics improve code safety?
→ By enforcing type constraints at compile time instead of runtime. :contentReference[oaicite:14]{index=14}

Q4. What does `List<String>` mean?
→ It defines a List that can only store Strings. :contentReference[oaicite:15]{index=15}

================================================================================
 NOTES
================================================================================

• Generics do NOT work with primitive types directly — you must use
  wrapper classes (e.g., Integer instead of int). :contentReference[oaicite:16]{index=16}
• Java implements generics using **type erasure**, meaning type info is
  checked at compile time and removed at runtime. :contentReference[oaicite:17]{index=17}

===============================================================================
 END OF FILE
===============================================================================
*/
