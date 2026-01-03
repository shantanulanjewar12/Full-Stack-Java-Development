import java.util.ArrayList;
import java.util.List;

public class _10_SectionWrapUp_Wildcards_In_Generics{

    /*
     ===========================================================================
      WHAT THIS WRAP-UP COVERS
     ===========================================================================
     
     This section reinforces how **wildcards** enhance Java generic usage
     by enabling flexible, type-safe methods, especially when working
     with collections. Wildcards help bridge the gap between rigid
     parameterized types and flexible generic APIs. :contentReference[oaicite:1]{index=1}
     
     Key wildcard forms:
       ✔ Unbounded wildcard    → List<?>
       ✔ Upper bounded wildcard → List<? extends SomeType>
       ✔ Lower bounded wildcard → List<? super SomeType>
    */

    public static void main(String[] args) {

        /*
         ===========================================================================
          1. UNBOUNDED WILDCARD (?):
         ===========================================================================
         • The simplest wildcard represents an **unknown type**.
         • Accepts any List type.
         • Useful for generic utilities that only look at items. 
        */
        List<String> names = List.of("Alice", "Bob");
        printAnyList(names);

        /*
         ===========================================================================
          2. UPPER BOUNDED WILDCARD (? extends Type):
         ===========================================================================
         • Allows the unknown type to be **Type or its subtypes**.
         • Good for **reading** values safely (producer).
         • You *cannot add* arbitrary items because type might be narrower. 
        List<Integer> ints = List.of(1, 2, 3);
        System.out.println("Sum: " + sumNumbers(ints));

        /*
         ===========================================================================
          3. LOWER BOUNDED WILDCARD (? super Type):
         ===========================================================================
         • Allows the unknown type to be **Type or its supertypes**.
         • Good for **writing/adding** items safely (consumer).
         // Example: you can add Integers to a List<? super Integer>. :contentReference[oaicite:4]{index=4}
        */
        List<Object> objs = new ArrayList<>();
        addIntegers(objs);
        System.out.println("Objects size: " + objs.size());
    }


    // Method using unbounded wildcard (read-only generic utility)
    public static void printAnyList(List<?> list) {
        for (Object item : list) {
            System.out.println("Item: " + item);
        }
    }

    // Method using upper bound – sums numbers in list
    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    // Method using lower bound – adds integers to list
    public static void addIntegers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
        list.add(30);
    }
}

/*
===============================================================================
  WILDCARD REVIEW: RULES & WHEN TO USE
===============================================================================

Wildcard Type         | Accepts Types             | Use For            | Can Add? 
----------------------|---------------------------|--------------------|---------
List<?>               | Any                       | Read only utilities | ❌
List<? extends T>     | T & subtypes              | Reading (producer) | ❌ except null
List<? super T>       | T & supertypes            | Writing (consumer) | ✔ adding T/subtypes

* This summary shows what type of List wildcard can accept and how
  methods can work with them. :contentReference[oaicite:5]{index=5}

**PECS Rule**  
• **P**roducer → **extends** (use when method *produces/reads* values)  
• **C**onsumer → **super** (use when method *consumes/adds* values) :contentReference[oaicite:6]{index=6}

===============================================================================
  PRACTICAL GUIDELINES
===============================================================================

✔ Prefer wildcards over raw types to get type-safe flexible APIs.  
✔ Use upper bounds when a method needs *read-only access* to elements.  
✔ Use lower bounds when a method needs to *add elements*.  
✔ Use unbounded when the method doesn’t depend on the actual type.

**Example motivations:**  
• Avoid writing separate methods for List<Integer>, List<Double>, etc.  
• Let one method accept compatible hierarchies like Vehicle and its subtypes. :contentReference[oaicite:7]{index=7}

===============================================================================
  INTERVIEW QUESTIONS & ANSWERS
===============================================================================

Q1. What does `<?>` mean in Java generics?  
→ An *unbounded wildcard* representing an unknown type; useful for generic utilities. :contentReference[oaicite:8]{index=8}

Q2. What’s the difference between `? extends T` and `? super T`?  
→ `? extends T` → upper bound (you can read values safely).  
→ `? super T` → lower bound (you can add values safely). :contentReference[oaicite:9]{index=9}

Q3. Why can’t you add elements to a `List<? extends T>`?  
→ Because we don’t know the exact specific subtype – compile cannot guarantee type safety. :contentReference[oaicite:10]{index=10}

Q4. When should you use wildcards?  
→ When a method works with multiple related generic types (collections) and you want flexible, yet safe, type checks. :contentReference[oaicite:11]{index=11}

Q5. What is the *PECS rule*?  
→ *Producer Extends, Consumer Super* — mnemonic for deciding wildcard use. :contentReference[oaicite:12]{index=12}

===============================================================================
  BEST PRACTICES
===============================================================================

✔ Replace raw types (`List list`) with wildcard types (`List<?>`).  
✔ Specify the narrowest bounds that satisfy your logic for safety.  
✔ Don’t over-restrict when unnecessary — use unbounded if type doesn’t matter.  
✔ When methods require relationships between types (like copy), use generic methods instead of wildcards. :contentReference[oaicite:13]{index=13}

===============================================================================
  NOTES
===============================================================================

📌 Wildcards don’t appear when **defining** a generic class — only when **using** it.  
📌 You *cannot* instantiate a generic type with a wildcard — e.g., `new Generic<?>();` is forbidden. :contentReference[oaicite:14]{index=14}  
📌 Wildcards help the compiler enforce type safety while allowing flexibility. :contentReference[oaicite:15]{index=15}

===============================================================================
 END OF FILE
===============================================================================
*/
