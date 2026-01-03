import java.util.ArrayList;
import java.util.List;

public class _6_GenericMethods {

    /*
     ===========================================================================
      WHAT ARE GENERIC METHODS?
     ===========================================================================
     
     • A **generic method** is a method that has its own type parameter(s),
       independent of any generic class it might be in.  
     • It allows you to write a single method that can work with different
       data types while maintaining **compile-time type safety**.  
     • Type parameters are declared before the return type in the method
       signature using angle brackets (e.g., <T>). :contentReference[oaicite:1]{index=1}

     • Generic methods are more flexible than non-generic methods because
       they work with multiple object types without method overloading. :contentReference[oaicite:2]{index=2}
    */

    public static void main(String[] args) {

        /*
         ===========================================================================
          EXAMPLE 1 — GENERIC METHOD TO PRINT LIST ELEMENTS
         ===========================================================================
        */
        System.out.println("=== Example 1: Generic Method with List ===");

        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);
        intList.add(30);

        List<String> strList = new ArrayList<>();
        strList.add("Hello");
        strList.add("Generics");
        strList.add("Java");

        // We can use the same method to print both lists, thanks to generics
        printListData(intList);
        System.out.println("----------");
        printListData(strList);

        /*
         ===========================================================================
          EXAMPLE 2 — GENERIC METHOD TO PRINT ARRAY ELEMENTS
         ===========================================================================
        */
        System.out.println("\n=== Example 2: Generic Method with Array ===");
        
        Integer[] arrInt = {1, 2, 3, 4};
        String[] arrStr = {"One", "Two", "Three"};

        // Using the same method to print different typed arrays
        printArrayData(arrInt);
        System.out.println("----------");
        printArrayData(arrStr);

        /*
         ===========================================================================
          IMPORTANT NOTE — GENERICS DO NOT SUPPORT PRIMITIVE TYPES DIRECTLY
         ===========================================================================
         • Java generics work only with **reference types**, not primitive types.  
         • For primitives, use wrapper classes (Integer, Double, Character, etc.).  
           Example: int[] cannot be passed to a generic method accepting <T>[].
         */
    }

    /*
     ===========================================================================
      GENERIC METHOD TO PRINT LIST CONTENT
     ===========================================================================
     
     • <T> declares the type parameter for this method.  
     • The method works for List of any reference type (Integer, String, etc.).
     */
    public static <T> void printListData(List<T> list) {
        for (T element : list) {
            System.out.println(element);
        }
    }

    /*
     ===========================================================================
      GENERIC METHOD TO PRINT ARRAY CONTENT
     ===========================================================================
     
     • <T> is the type parameter used by the method.
     */
    public static <T> void printArrayData(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}

/*
===============================================================================
 INTERVIEW QUESTIONS & ANSWERS
===============================================================================

Q1. What is a generic method in Java?
→ It is a method that defines its own type parameter(s) (e.g., <T>) before
   the return type, allowing it to operate on different types safely. :contentReference[oaicite:3]{index=3}

Q2. How do you declare a generic method?
→ Place the type parameter declaration before the return type:
       public static <T> void methodName(T param) { … } :contentReference[oaicite:4]{index=4}

Q3. Can generic methods work with both lists and arrays?
→ Yes — the same generic method syntax can be used for both collections
   and arrays. :contentReference[oaicite:5]{index=5}

Q4. Why can’t we use primitive types with generic methods?
→ Because Java generics work only with reference types; primitive types
   must be wrapped (e.g., use Integer instead of int). :contentReference[oaicite:6]{index=6}

Q5. What are the advantages of using generic methods?
→ • Type safety at compile-time  
   • Code reusability  
   • No need for explicit type casting  
   • Works with different data structures (List, array, etc.) :contentReference[oaicite:7]{index=7}

===============================================================================
 ADVANTAGES & LIMITATIONS
===============================================================================

✔ **Advantages of Generic Methods:**
   • Reuse code for multiple types without duplication. :contentReference[oaicite:8]{index=8}  
   • Type safety – compiler checks types at compile time. :contentReference[oaicite:9]{index=9}  
   • Works seamlessly with different data structures like lists and arrays. :contentReference[oaicite:10]{index=10}

⚠ **Limitations:**
   • Cannot use primitive types (use wrapper classes instead). :contentReference[oaicite:11]{index=11}  
   • Generic type information is erased at runtime (type erasure). :contentReference[oaicite:12]{index=12}  
   • Multiple type parameters add complexity if used extensively. :contentReference[oaicite:13]{index=13}

===============================================================================
 NOTES
===============================================================================

📌 Generic methods are often used in utility classes and libraries
   where operations are similar across many types (e.g., printing,
   sorting, comparing). :contentReference[oaicite:14]{index=14}

📌 The `<T>` (or any type letter) is called a **type parameter** — a
   placeholder that will be replaced with a real type (Integer, String,
   etc.) at compile time. :contentReference[oaicite:15]{index=15}

===============================================================================
 END OF FILE
===============================================================================
*/
