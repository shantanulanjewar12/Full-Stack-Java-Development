import java.util.ArrayList;
import java.util.List;

public class _4_ListOfGenericClassObjects {

    /*
     * ===========================================================================
     * 1. WHAT THIS LESSON COVERS
     * ===========================================================================
     * 
     * • How to create and manage collections (like List) that store generic
     * class objects.
     * • Why using generics with collections provides type safety, removes
     * casting, and prevents runtime errors. :contentReference[oaicite:1]{index=1}
     * • Using parameterized types together in generic containers.
     */

    public static void main(String[] args) {

        System.out.println("=== Creating a List of Generic Class Objects ===");

        /*
         * ===========================================================================
         * 2. CREATE A SIMPLE GENERIC CLASS
         * ===========================================================================
         * A generic class can be defined to hold an object of type T.
         * A List of such classes lets you store many typed objects.
         * :contentReference[oaicite:2]{index=2}
         */
        class Box<T> {
            private T value;

            public Box(T value) {
                this.value = value;
            }

            public T getValue() {
                return value;
            }

            @Override
            public String toString() {
                return "Box(" + value + ")";
            }
        }

        /*
         * ===========================================================================
         * 3. LIST OF GENERIC CLASS INSTANCES
         * ===========================================================================
         * We now create a List that holds Box<String> objects.
         * Using List<Box<String>> enforces type safety at compile time.
         */
        List<Box<String>> boxesOfString = new ArrayList<>();

        boxesOfString.add(new Box<>("Hello"));
        boxesOfString.add(new Box<>("Generics"));
        boxesOfString.add(new Box<>("Java"));

        for (Box<String> box : boxesOfString) {
            System.out.println("Value from list: " + box.getValue());
        }

        /*
         * ===========================================================================
         * 4. MULTIPLE TYPE PARAMETERS IN A GENERIC CLASS
         * ===========================================================================
         * A generic class can also have more than one type parameter,
         * such as Pair<KeyType, ValueType>. :contentReference[oaicite:4]{index=4}
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
                return "(" + key + ", " + value + ")";
            }
            
        }

        List<Pair<String, Integer>> listOfPairs = new ArrayList<>();
        listOfPairs.add(new Pair<>("Alice", 30));
        listOfPairs.add(new Pair<>("Bob", 40));
        listOfPairs.add(new Pair<>("Charlie", 25));

        System.out.println("\n=== List of Pair<String, Integer> ===");
        for (Pair<String, Integer> p : listOfPairs) {
            System.out.println(p);
        }

        /*
         * ===========================================================================
         * 5. MIXED GENERIC OBJECTS ARE NOT ALLOWED WITHOUT RAW TYPES
         * ===========================================================================
         * You cannot mix parameterized types like Box<String> and Box<Integer>
         * in the same List<Box<T>> — this is a compile-time safety feature.
         * :contentReference[oaicite:5]{index=5}
         */

        List<Box<Integer>> boxesOfInteger = new ArrayList<>();
        boxesOfInteger.add(new Box<>(100));
        boxesOfInteger.add(new Box<>(200));
        System.out.println("\n=== Boxes of Integer ===");
        for (Box<Integer> box : boxesOfInteger) {
            System.out.println("Value: " + box.getValue());
        }
    }
}

/*
 * =============================================================================
 * ==
 * INTERVIEW QUESTIONS & ANSWERS
 * =============================================================================
 * ==
 * 
 * Q1. How do you create a List of generic class objects?
 * → Use generics with collections like List<GenericClass<Type>> to specify
 * the exact type stored in the list. :contentReference[oaicite:6]{index=6}
 * 
 * Q2. Why don’t we need type casting when using List<Box<String>>?
 * → Because the type parameter ensures compile-time type checking.
 * :contentReference[oaicite:7]{index=7}
 * 
 * Q3. Can you mix objects of different type parameters in one generic list?
 * → No — mixing Box<String> and Box<Integer> in a List<Box<T>> is not allowed
 * without unsafe raw types. :contentReference[oaicite:8]{index=8}
 * 
 * =============================================================================
 * ==
 * BEST PRACTICES
 * =============================================================================
 * ==
 * 
 * ✔ Always use specific parameterized types with collections to enforce
 * compile-time safety. :contentReference[oaicite:9]{index=9}
 * ✔ Avoid raw types (like List without <>), which defeat the purpose of
 * generics. :contentReference[oaicite:10]{index=10}
 * ✔ Prefer meaningful type parameter names like K and V for clarity.
 * :contentReference[oaicite:11]{index=11}
 * 
 * =============================================================================
 * ==
 * NOTES
 * =============================================================================
 * ==
 * 
 * • Java generics work only with reference types (Integer instead of int).
 * :contentReference[oaicite:12]{index=12}
 * • Generics enable stronger type safety and eliminate many runtime errors.
 * :contentReference[oaicite:13]{index=13}
 * 
 * =============================================================================
 * ==
 * END OF FILE
 * =============================================================================
 * ==
 */
