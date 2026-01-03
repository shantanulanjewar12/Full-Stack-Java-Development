import java.util.ArrayList;
import java.util.List;

public class _8_BoundedTypeParameters_Continued {

    /*
     ===========================================================================
      1. INTRODUCTION — WHY CONTINUE WITH BOUNDED TYPE PARAMETERS?
     ===========================================================================
     
     Bounded type parameters enhance generics by allowing you to restrict
     what types can be passed as type arguments — enforcing type safety
     and enabling access to specific class/interface methods. :contentReference[oaicite:1]{index=1}
    */

    public static void main(String[] args) {

        /*
         ===========================================================================
          2. EXAMPLE — UPPER BOUNDED TYPE PARAMETER (EXTENDS)
         ===========================================================================
         Restricts types to a specific class *and its subclasses*.
         This lets us use methods defined on the bound class directly. :contentReference[oaicite:2]{index=2}
        */
        System.out.println("=== Upper Bounded Type Example ===");

        DataBox<Integer> intBox = new DataBox<>(1);
        System.out.println(intBox);

        DataBox<Double> dblBox = new DataBox<>(2.34);
        System.out.println(dblBox);

        /*
         Explanation:
         The generic parameter <T extends Number> ensures that the DataBox
         class only accepts numeric types. If you try DataBox<String>,
         compilation will fail. :contentReference[oaicite:3]{index=3}
        */

        // This will error at compile time:
        // DataBox<String> stringBox = new DataBox<>("test");

        /*
         ===========================================================================
          3. LOWER BOUNDED WILDCARDS (SUPER)
         ===========================================================================
         Lower bounds control what can be *safely added* to a collection.
         For example, List<? super Integer> accepts Integer and its supertypes. :contentReference[oaicite:4]{index=4}
        */
        System.out.println("\n=== Lower Bounded Wildcard Example ===");

        List<Object> objectList = new ArrayList<>();
        addNumbers(objectList); // OK
        // addNumbers(new ArrayList<String>()); // ❌ Not allowed

        System.out.println("Lower bound list size: " + objectList.size());
    }

    /*
     ===========================================================================
      METHOD DEMONSTRATING LOWER BOUNDED WILDCARD
     ===========================================================================
     Allows adding Integer values into a collection of supertype objects.
    */
    public static void addNumbers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
        list.add(30);
    }
}

/*
===============================================================================
  GENERIC CLASS FOR UPPER BOUND DEMO
===============================================================================
*/
class DataBox<T extends Number> {
    private T data;

    public DataBox(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataBox [value=" + data + "]";
    }
}

/*
===============================================================================
 WHY USE BOUNDED TYPE PARAMETERS?
===============================================================================

✔ **Stronger Type Safety**
   → Restrict type arguments to only types that make sense for your logic. :contentReference[oaicite:5]{index=5}

✔ **Access to Specific Methods**
   → If type extends Number, methods like doubleValue() are available. :contentReference[oaicite:6]{index=6}

✔ **Greater Code Clarity**
   → Bound constraints clearly communicate requirements. :contentReference[oaicite:7]{index=7}

===============================================================================
 BOUNDED VS UNBOUNDED TYPES
===============================================================================

Feature                          | Bounded Types                      | Unbounded Types
---------------------------------|------------------------------------|--------------------------
Syntax                           | <T extends Class>                  | <T>
Compile-time checks             | Enforced at compile time           | Loose typing
Allowed Methods                  | Can use bound’s methods            | Only Object methods
Examples                        | List<? extends Number>, DataBox<T extends Number> | List<?> or List<Object>

Explanation:
Bounded types limit the kinds of types that can be passed, allowing
methods of that type or interface to be safely used without casting. :contentReference[oaicite:8]{index=8}

===============================================================================
 INTERVIEW QUESTIONS & ANSWERS
===============================================================================

Q1. What is an upper bounded type parameter?
→ It restricts type to a specific class and its subclasses using the 'extends' keyword. :contentReference[oaicite:9]{index=9}

Q2. What is a lower bounded wildcard?
→ It restricts a generic type to accept only the specified type or its supertypes, often used for writing to a collection. :contentReference[oaicite:10]{index=10}

Q3. Can upper bounds and wildcards appear together?
→ Yes — upper bounded wildcards use syntax <? extends Type>, while lower bounded wildcards use <? super Type>. :contentReference[oaicite:11]{index=11}

Q4. Why use bounded type parameters instead of unbounded?
→ To enforce constraints, allow access to specific methods, and reduce runtime errors. :contentReference[oaicite:12]{index=12}

===============================================================================
 BEST PRACTICES
===============================================================================

✔ Prefer upper bounds when reading from a generic collection.  
✔ Prefer lower bounds when writing into a generic collection.  
✔ Always make constraints explicit for better readability.  
✔ Use wildcards when exact generic types are not required. :contentReference[oaicite:13]{index=13}

===============================================================================
 NOTES
===============================================================================

📌 In Java generics, `extends` works for both classes and interfaces in bounds. :contentReference[oaicite:14]{index=14}  
📌 Lower bounds are used with wildcards and are particularly useful for modifying collections safely. :contentReference[oaicite:15]{index=15}  

===============================================================================
 END OF FILE
===============================================================================
*/
