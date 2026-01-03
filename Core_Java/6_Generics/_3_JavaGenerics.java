import java.util.ArrayList;
import java.util.List;

public class _3_JavaGenerics {

    /*
     * ===========================================================================
     * SECTION 1 — GENERIC CLASS CREATION (RECAP & CODE)
     * ===========================================================================
     * 
     * A **generic class** uses a type parameter (like <T>) so that
     * instances can work with different data types safely.
     */
    static class GenericData<T> {
        private T data;

        public GenericData(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        /*
         * ===========================================================================
         * CREATE AND USE GENERIC CLASS
         * ===========================================================================
         * Without generics, we would need casts and could get runtime errors.
         * With generics, type safety is enforced at compile time.
         */

        System.out.println("=== Generic Class Example ===");
        GenericData<String> gdString = new GenericData<>("Hello Generics!");
        System.out.println("Data: " + gdString.getData());

        GenericData<Integer> gdInt = new GenericData<>(123);
        System.out.println("Number: " + gdInt.getData());

        // The following line would be a compile-time error:
        // GenericData<String> wrong = new GenericData<>(100);

        /*
         * ===========================================================================
         * SECTION 2 — USING THE DIAMOND OPERATOR
         * ===========================================================================
         * Since Java 7, the **diamond operator <>** helps infer types so you
         * don't have to repeat the type parameter.
         */
        List<GenericData<String>> list = new ArrayList<>();
        list.add(new GenericData<>("One"));
        list.add(new GenericData<>("Two"));
        System.out.println("List size: " + list.size());

        /*
         * ===========================================================================
         * SECTION 3 — GENERIC METHODS (DEFINING TYPE PARAMETERS IN METHODS)
         * ===========================================================================
         * A generic method declares its own type parameter before the return type.
         * :contentReference[oaicite:4]{index=4}
         */
        printGeneric(gdString);
        printGeneric(gdInt);

        /*
         * ===========================================================================
         * SECTION 4 — GENERICS ADVANTAGES
         * ===========================================================================
         * ✔ **Type safety** – prevents invalid insertions
         * ✔ **Reusability** – one class works with many types
         * ✔ **No casts needed** – cleaner code
         * ✔ **Elimination of ClassCastException at runtime**
         * :contentReference[oaicite:5]{index=5}
         * 
         */

        /*
         * ===========================================================================
         * SECTION 5 — HANDLING COMMON WARNINGS
         * ===========================================================================
         * Java warns about “raw use of parameterized class”. To avoid:
         * • Always specify type arguments
         * • Use the diamond operator
         * Example:
         * GenericData raw = new GenericData("test"); // warning
         * GenericData<String> safe = new GenericData<>("test"); // ok
         * :contentReference[oaicite:6]{index=6}
         */

        /*
         * ===========================================================================
         * SECTION 6 — ADVANCED TOPICS: BOUNDED TYPES & WILDCARDS
         * ===========================================================================
         * You can **restrict types** that can be used with generics using bounds.
         * Example: Only Number or its subclasses allowed:
         */
        NumericBox<Integer> intBox = new NumericBox<>(10);
        NumericBox<Double> dblBox = new NumericBox<>(20.5);
        System.out.println("NumericBox values: " + intBox.getNumber() + ", " + dblBox.getNumber());

        // The following line will cause compile-time error:
        // NumericBox<String> strBox = new NumericBox<>("test");

        /*
         * Wildcards (`?`) can allow flexible method parameters:
         * - `?` — unknown type
         * - `? extends T` — upper bounded (read-only)
         * - `? super T` — lower bounded (write-only)
         * :contentReference[oaicite:7]{index=7}
         */

        List<GenericData<? extends Number>> nums = new ArrayList<>();
        nums.add(new GenericData<Integer>(100));
        nums.add(new GenericData<Double>(99.99));
        // You can read Number but cannot safely add arbitrary types
    }

    /*
     * ===========================================================================
     * GENERIC METHOD (DEMONSTRATION)
     * ===========================================================================
     * Generic methods allow you to write a method that works with any type
     * parameter that is passed in. :contentReference[oaicite:8]{index=8}
     */
    public static <U> void printGeneric(GenericData<U> obj) {
        System.out.println("Generic method output: " + obj.getData());
    }
}

/*
 * =============================================================================
 * ==
 * BOUNDED GENERIC CLASS EXAMPLE
 * =============================================================================
 * ==
 */
class NumericBox<T extends Number> {
    private T number;

    public NumericBox(T number) {
        this.number = number;
    }

    public T getNumber() {
        return number;
    }
}

/*
 * =============================================================================
 * ==
 * INTERVIEW QUESTIONS & ANSWERS
 * =============================================================================
 * ==
 * 
 * Q1. How do you define a generic class in Java?
 * → A generic class declares a type parameter using angle brackets (e.g., <T>)
 * after the class name. :contentReference[oaicite:9]{index=9}
 * 
 * Q2. What is the diamond operator (`<>`)?
 * → A syntax introduced in Java 7 that allows the compiler to infer generic
 * types and reduce verbosity. :contentReference[oaicite:10]{index=10}
 * 
 * Q3. What are bounded type parameters?
 * → A way to restrict generics to classes that extend a specific type (e.g., `T
 * extends Number`). :contentReference[oaicite:11]{index=11}
 * 
 * Q4. What is a wildcard (`?`) in Java generics?
 * → It represents an unknown type and is often used for flexible method
 * parameters. :contentReference[oaicite:12]{index=12}
 * 
 * =============================================================================
 * ==
 * NOTES
 * =============================================================================
 * ==
 * 
 * • Always specify type parameters instead of using raw types to avoid
 * warnings. :contentReference[oaicite:13]{index=13}
 * • Use wildcards when flexibility is needed and exact type is not required.
 * :contentReference[oaicite:14]{index=14}
 * • Generic methods declare their own type parameter before the return type.
 * :contentReference[oaicite:15]{index=15}
 * 
 * =============================================================================
 * ==
 * END OF FILE
 * =============================================================================
 * ==
 */
