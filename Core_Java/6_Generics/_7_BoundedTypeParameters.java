public class _7_BoundedTypeParameters {

  /*
   * ===========================================================================
   * WHAT IS A BOUNDED TYPE PARAMETER?
   * ===========================================================================
   * 
   * • A *bounded type parameter* restricts the kinds of types that are
   * allowed to be used as arguments for a type parameter in generics.
   * 
   * • Instead of allowing *any* type (like <T>), you can constrain it to
   * accept only a certain class or interface and its subtypes.
   * 
   * • This helps ensure that the type used supports particular methods or
   * behaviors — improving type safety and code correctness.
   * 
   * • Bounded types commonly use the `extends` keyword in Java
   * (even for interfaces). 
   */

  public static void main(String[] args) {

    /*
     * ===========================================================================
     * 1. UPPER BOUND EXAMPLE
     * ===========================================================================
     * 
     * Here we constrain T so that it must be Number or a subclass of Number,
     * such as Integer or Double. This allows operations like `.doubleValue()`
     * that are defined in the Number class. 
     */
    System.out.println("=== Upper Bound Example ===");

    NumericBox<Integer> intBox = new NumericBox<>(50);
    System.out.println("Integer value: " + intBox.getData());

    NumericBox<Double> doubleBox = new NumericBox<>(75.5);
    System.out.println("Double value: " + doubleBox.getData());

    // The following line would cause a compile-time error:
    // NumericBox<String> stringBox = new NumericBox<>("Text"); // ❌ Not allowed

    /*
     * ===========================================================================
     * 2. GENERIC METHOD WITH BOUNDED TYPE PARAMETER
     * ===========================================================================
     * You can also use bounded type parameters in generic methods.
     * :contentReference[oaicite:6]{index=6}
     */
    System.out.println("\n=== Generic Method with Upper Bound ===");
    Integer[] numbers = { 1, 2, 3, 4, 5 };
    System.out.println("Average: " + GenericUtils.calculateAverage(numbers));
  }
}

/*
 * =============================================================================
 * ==
 * GENERIC CLASS WITH UPPER BOUND
 * =============================================================================
 * ==
 */
class NumericBox<T extends Number> {
  private T data;

  public NumericBox(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

  @Override
  public String toString() {
    return data.toString();
  }
}

/*
 * =============================================================================
 * ==
 * GENERIC METHODS WITH BOUNDED TYPE PARAMETER
 * =============================================================================
 * ==
 */
class GenericUtils {

  /*
   * ===========================================================================
   * CALCULATE AVERAGE OF NUMBERS (ONLY FOR SUBTYPES OF Number)
   * ===========================================================================
   * This method works with Integer, Double, Float, etc., but not with Strings
   * or unrelated reference types. :contentReference[oaicite:7]{index=7}
   */
  public static <T extends Number> double calculateAverage(T[] values) {
    double sum = 0;
    for (T value : values) {
      sum += value.doubleValue(); // Available because T extends Number
    }
    return sum / values.length;
  }
}

/*
 * =============================================================================
 * ==
 * MULTIPLE BOUNDS EXAMPLE
 * =============================================================================
 * ==
 */
class MultiBoundExample {

  /*
   * ===========================================================================
   * UPPER BOUND WITH INTERFACE
   * ===========================================================================
   * You can specify that a type parameter must be a subclass *and* implement
   * an interface. For example, T must extend Number and implement Comparable<T>.
   * :contentReference[oaicite:8]{index=8}
   */
  public static class AdvancedRepository<T extends Number & Comparable<T>> {
    private T data;

    public AdvancedRepository(T data) {
      this.data = data;
    }

    public void compare(T other) {
      int result = data.compareTo(other);
      System.out.println("Comparison result: " + result);
    }
  }
}

/*
 * =============================================================================
 * ==
 * WHY USE BOUNDED TYPE PARAMETERS?
 * =============================================================================
 * ==
 * 
 * ✔ **Type Safety at Compile Time**
 * → Bounded parameters restrict usage to safe types and avoid runtime errors.
 * :contentReference[oaicite:9]{index=9}
 * 
 * ✔ **Access to Specific Methods**
 * → If you know T extends Number, methods like `doubleValue()` are guaranteed.
 * :contentReference[oaicite:10]{index=10}
 * 
 * ✔ **Cleaner and More Predictable APIs**
 * → The API communicates constraints directly in the signature.
 * :contentReference[oaicite:11]{index=11}
 * 
 * ✔ **Enables Polymorphism with Generic Code**
 * → Generic classes/methods work with a family of related types.
 * :contentReference[oaicite:12]{index=12}
 * 
 * =============================================================================
 * ==
 * INTERVIEW QUESTIONS & ANSWERS
 * =============================================================================
 * ==
 * 
 * Q1. What is a bounded type parameter?
 * → A type parameter that’s constrained to a specific type or its subtypes
 * using `extends`. :contentReference[oaicite:13]{index=13}
 * 
 * Q2. How do you declare an upper bound?
 * → Use `<T extends SomeClass>`. For interfaces or multiple bounds, combine
 * with `&`. :contentReference[oaicite:14]{index=14}
 * 
 * Q3. Why can’t you instantiate a generic type with a type that doesn’t meet
 * the bound?
 * → Because the compiler enforces the bound and rejects incompatible types.
 * :contentReference[oaicite:15]{index=15}
 * 
 * Q4. Can you use interfaces in bounds?
 * → Yes — e.g., `<T extends Number & Comparable<T>>`.
 * :contentReference[oaicite:16]{index=16}
 * 
 * Q5. Do bounded type parameters improve runtime performance?
 * → The constraint doesn’t affect performance; it improves correctness at
 * compile time. :contentReference[oaicite:17]{index=17}
 * 
 * =============================================================================
 * ==
 * BEST PRACTICES
 * =============================================================================
 * ==
 * 
 * ✔ Always specify bounds where possible to prevent invalid usage.
 * :contentReference[oaicite:18]{index=18}
 * ✔ Prefer meaningful type names (like `<N extends Number>` for numeric
 * constraints). :contentReference[oaicite:19]{index=19}
 * ✔ For complex APIs, document bounds clearly to make constraints
 * understandable. :contentReference[oaicite:20]{index=20}
 * 
 * =============================================================================
 * ==
 * NOTES
 * =============================================================================
 * ==
 * 
 * 📌 In Java generics, the `extends` keyword is used for both class and
 * interface bounds. :contentReference[oaicite:21]{index=21}
 * 📌 Lower bounds (`super`) are supported via wildcards (e.g., `<? super T>`)
 * when declaring usage sites, not on declaration sites.
 * :contentReference[oaicite:22]{index=22}
 * 📌 Bounded generics help you leverage behaviors of the bound type safely in
 * your generic code. :contentReference[oaicite:23]{index=23}
 * 
 * =============================================================================
 * ==
 * END OF FILE
 * =============================================================================
 * ==
 */
