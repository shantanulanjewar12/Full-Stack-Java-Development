public class _5_TypeOfParameters {

    /*
     ===========================================================================
      WHAT ARE TYPE PARAMETERS?
     ===========================================================================
     
     • In Java Generics, **type parameters** are placeholders used in
       class, interface, or method definitions to represent types that
       are supplied when the generic type is used. :contentReference[oaicite:1]{index=1}
     
     • They allow a single class/method to work with many data types
       while maintaining compile-time **type safety** and eliminating
       unnecessary casting. :contentReference[oaicite:2]{index=2}
     
     • Java uses **single-letter notations** as standard placeholders
       for type parameters (though descriptive names are also okay). :contentReference[oaicite:3]{index=3}
    */

    public static void main(String[] args) {

        /*
         ===========================================================================
          COMMON TYPE PARAMETER NAMES
         ===========================================================================
         • T → Type (general purpose)
         • E → Element (used with collections)
         • K → Key (used with maps or pairs)
         • V → Value (used with maps or pairs)
         • N → Number (commonly used when restricting numeric types) :contentReference[oaicite:4]{index=4}
        */

        System.out.println("Java Generics use type parameters like T, E, K, V, N for flexibility.");
    }
}

/*
===============================================================================
 EXAMPLE: GENERIC PAIR CLASS
===============================================================================
*/
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Pair {key=" + key + ", value=" + value + "}";
    }

    /*
     ===========================================================================
      HOW THIS WORKS
     ===========================================================================
     • 'K' and 'V' are **type parameters**.
     • When creating an object, you substitute real types:
           Pair<Integer, String> p = new Pair<>(10, "Hello");
       → K becomes Integer and V becomes String. :contentReference[oaicite:5]{index=5}
     • This ensures compile-time type checking and eliminates explicit casts.
     */
}

class DemoTypeOfParameters {
    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(10, "Data");
        System.out.println(pair);
    }
}

/*
===============================================================================
 WHY USE TYPE PARAMETERS?
===============================================================================

✔ **STRONG TYPE SAFETY:**  
   • Only the specified types can be used when the generic is instantiated.  
   • Errors are caught at compile time, not runtime. :contentReference[oaicite:6]{index=6}

✔ **NO CASTING REQUIRED:**  
   • The compiler knows the exact type being used, so explicit casting is not needed. :contentReference[oaicite:7]{index=7}

✔ **CODE REUSABILITY:**  
   • One generic class or method can work for many different types. :contentReference[oaicite:8]{index=8}

✔ **BETTER READABILITY:**  
   • Type parameters make your intent clearer (e.g., List<String> holds Strings). :contentReference[oaicite:9]{index=9}
*/

/*
===============================================================================
 INTERVIEW QUESTIONS & ANSWERS
===============================================================================

Q1. What is a type parameter in Java Generics?  
→ A type parameter is a placeholder in a generic class, interface, or method
   that gets replaced with a real type when the generic is used. :contentReference[oaicite:10]{index=10}

Q2. What do letters like T, E, K, V, and N represent?  
→ They are conventional names for type parameters:
   • T → any type  
   • E → element type in collections  
   • K → key type  
   • V → value type  
   • N → number type :contentReference[oaicite:11]{index=11}

Q3. Why use type parameters instead of Object?  
→ Type parameters provide compile-time type safety and avoid casting. :contentReference[oaicite:12]{index=12}

Q4. Can I use descriptive names instead of T?  
→ Yes — descriptive names improve readability, but single letters are standard. :contentReference[oaicite:13]{index=13}

Q5. Are type parameters enforced at runtime?  
→ No — generics use **type erasure**, so the type info is only at compile time. :contentReference[oaicite:14]{index=14}

===============================================================================
 BEST PRACTICES
===============================================================================

✔ Use meaningful type parameter names when appropriate. :contentReference[oaicite:15]{index=15}  
✔ Prefer bounded parameters when restricting types (e.g., `<T extends Number>`). :contentReference[oaicite:16]{index=16}  
✔ Avoid raw types (generic types without `<...>`). :contentReference[oaicite:17]{index=17}  
✔ Document type expectations clearly for maintainability. :contentReference[oaicite:18]{index=18}

===============================================================================
 NOTES
===============================================================================

📌 Java’s type parameters improve safety and flexibility by letting the compiler
   enforce correct types without requiring casts. :contentReference[oaicite:19]{index=19}  
📌 Type information is removed at runtime (type erasure), so generics don’t
   affect runtime performance. :contentReference[oaicite:20]{index=20}

===============================================================================
 END OF FILE
===============================================================================
*/
