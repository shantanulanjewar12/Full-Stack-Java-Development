import java.util.LinkedList;
import java.util.List;

public class _2_JavaGenerics_UsingObjectWrapper {

  /*
   * ===========================================================================
   * 1. PROBLEM: USING OBJECT AS A GENERIC WRAPPER
   * ===========================================================================
   * 
   * Before Java Generics were introduced (in Java 5), many developers used
   * Object to store different types in the same container. For example:
   * 
   * class Data {
   * private Object object;
   * public Data(Object object) {
   * this.object = object;
   * }
   * public Object getObject() {
   * return object;
   * }
   * }
   * 
   * → This seems flexible, but it has many drawbacks:
   * 1) No compile-time type checking
   * 2) Explicit type casting required
   * 3) Risk of ClassCastException at runtime
   * 
   * Example – Problematic Code:
   */

  static class OldData {
    private Object object;

    public OldData(Object object) {
      this.object = object;
    }

    public Object getObject() {
      return object;
    }
  }

  public static void main(String[] args) {

    System.out.println("=== Using Object Wrapper (Old Approach) ===");

    List<OldData> elements = new LinkedList<>();
    elements.add(new OldData("Hello World"));
    elements.add(new OldData('A'));
    elements.add(new OldData(25)); // Integer
    elements.add(new OldData(52.65)); // Double

    // Trying to get a String
    OldData data0 = elements.get(0); // output="Hello World"
    String str0 = (String) data0.getObject(); // Needs cast
    // This line retrieves the object from data0 and casts it to a String.
    System.out.println("Value: " + str0);

    // WRONG CAST – Causes ClassCastException at runtime
    try {
      OldData data1 = elements.get(1); // holds Character
      String wrong = (String) data1.getObject(); // ❌ Runtime error
      System.out.println(wrong); // Not reached
    } catch (ClassCastException e) {
      System.out.println("⚠ Runtime cast error: " + e.getMessage());
    }

    /*
     * ===========================================================================
     * WHY THIS APPROACH IS BAD
     * ===========================================================================
     * 1) No compile-time safety: the compiler allows any type.
     * 2) Casting is required when retrieving values.
     * 3) Casting failures lead to ClassCastException at runtime — hard to debug.
     * 
     * This clearly shows the need for **type safety** at compile time, not
     * just at runtime. :contentReference[oaicite:1]{index=1}
     */

    /*
     * ===========================================================================
     * 2. INTRODUCING GENERICS – SAFE AND CLEAN
     * ===========================================================================
     * 
     * Java Generics lets us specify a type parameter when defining a class,
     * eliminating the need for casts and catching type errors at compile time.
     * 
     * Advantages of using generics:
     * - Compile-time type safety
     * - No explicit casting
     * - Cleaner, more readable code
     * - Improved performance (no casting overhead)
     * :contentReference[oaicite:2]{index=2}
     */

    System.out.println("\n=== Using Generic Class (Better Approach) ===");

    List<Data<String>> safeList = new LinkedList<>();
    // here, we specify that this list will only hold Data<String> objects
    // This ensures type safety at compile time
    // Data is a generic class defined below
    safeList.add(new Data<>("Hello World"));
    safeList.add(new Data<>("Generics in Java"));

    // No need to cast
    for (Data<String> d : safeList) {
      System.out.println("Value: " + d.getObject());
    }

    // The following line would be a **compile-time error**
    // safeList.add(new Data<>(25)); // ❌ Compiler rejects this
  }
}

/*
 * =============================================================================
 * ==
 * GENERIC CLASS DEFINITION
 * =============================================================================
 * ==
 */
class Data<T> {
  private T object;

  public Data(T object) {
    this.object = object;
  }

  public T getObject() {
    return object;
  }

  @Override
  public String toString() {
    return object.toString();
  }
}

/*
 * =============================================================================
 * ==
 * KEY POINTS SUMMARY
 * =============================================================================
 * ==
 * 
 * ✔ Before generics, developers often wrapped any type using Object, which
 * means storing and retrieving required explicit cast — unsafe.
 * :contentReference[oaicite:3]{index=3}
 * 
 * ✔ Using Object as a wrapper allows any type but sacrifices type safety at
 * compile time — errors show up only at runtime.
 * :contentReference[oaicite:4]{index=4}
 * 
 * ✔ Generics allow classes to work with **any specified type**, eliminating
 * the need for casts and preventing wrong types from being added.
 * :contentReference[oaicite:5]{index=5}
 * 
 * ✔ Benefits of generics:
 * • Compile-time type checking
 * • No explicit casting
 * • Cleaner and more maintainable code
 * • Better performance by removing casting overhead.
 * :contentReference[oaicite:6]{index=6}
 * 
 * =============================================================================
 * ==
 * INTERVIEW QUESTIONS & ANSWERS
 * =============================================================================
 * ==
 * 
 * Q1. Why was using Object as a container type problematic?
 * → Because retrieving values required casting, which could fail at runtime
 * with ClassCastException. :contentReference[oaicite:7]{index=7}
 * 
 * Q2. How do generics improve type safety?
 * → By allowing you to specify the exact type at compile time; wrong types
 * cause compile errors. :contentReference[oaicite:8]{index=8}
 * 
 * Q3. Do generics remove casting completely?
 * → Yes — when using parameterized types, you don’t need explicit casts
 * when getting objects. :contentReference[oaicite:9]{index=9}
 * 
 * Q4. Can you use primitives like int with generics?
 * → No — generics only work with objects; use wrapper types like Integer.
 * :contentReference[oaicite:10]{index=10}
 * 
 * =============================================================================
 * ==
 * NOTES
 * =============================================================================
 * ==
 * 
 * • Generics are implemented using **type erasure**, meaning type
 * parameters are removed at runtime but checked at compile time.
 * :contentReference[oaicite:11]{index=11}
 * 
 * • Java Collections Framework extensively uses generics (List<T>, Map<K,V>,
 * etc.) to enhance safety. :contentReference[oaicite:12]{index=12}
 * 
 * =============================================================================
 * ==
 * END OF FILE
 * =============================================================================
 * ==
 */
