import java.util.*;

/*
 ============================================================================
 COMPARATOR vs COMPARABLE
 ============================================================================
 Both Comparator and Comparable are used to SORT collections / arrays of objects.

 ---------------------------------------------------------------------------
 1) WHY DO WE NEED THEM?
 ---------------------------------------------------------------------------
 - Java knows how to sort primitive types (int, double, char, etc.)
 - Java does NOT know how to sort custom objects (Car, Student, Employee)
 - We must TELL Java:
     • HOW to compare objects
     • WHICH field to compare
     • IN WHICH order (asc / desc)

 ---------------------------------------------------------------------------
 2) KEY DIFFERENCE (INTERVIEW GOLD)
 ---------------------------------------------------------------------------
 Comparable                        | Comparator
 ----------------------------------|----------------------------------------
 java.lang                          | java.util
 compareTo() method                 | compare() method
 Sorts based on SINGLE logic        | Can have MULTIPLE logics
 Modifies the class                 | External to the class
 Natural ordering                   | Custom ordering
 Used by default                    | Used when passed explicitly
 Implements Comparable<T>           | Implements Comparator<T>

 ============================================================================
 */

public class _3_ComparatorVsComparable {

    // =======================
    // MAIN METHOD
    // =======================
    public static void main(String[] args) {

        primitiveSorting();

        objectSortingFailure();

        objectSortingUsingComparable();

        comparatorWithLambda();

        comparatorWithSeparateClass();

        comparatorWithAnonymousClass();
    }

    // ============================================================
    // 1. PRIMITIVE SORTING (NO COMPARATOR / COMPARABLE NEEDED)
    // ============================================================
    static void primitiveSorting() {
        System.out.println("\n--- Primitive Sorting ---");

        int[] arr = {4, 1, 9, 2};
        Arrays.sort(arr); // ascending by default

        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();

        /*
         OUTPUT:
         1 2 4 9

         WHY?
         - Java internally knows how to compare primitive values
         - Uses DualPivotQuickSort (for primitives)
        */
    }



    // ============================================================
    // 2. OBJECT SORTING FAILURE (NO COMPARABLE / COMPARATOR)
    // ============================================================
    static void objectSortingFailure() {
        System.out.println("\n--- Object Sorting Failure ---");

        Car[] cars = {
                new Car("SUV", "petrol"),
                new Car("Sedan", "diesel"),
                new Car("HatchBack", "cng")
        };

        try {
            Arrays.sort(cars); // ❌ Runtime Exception
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        /*
         OUTPUT:
         ClassCastException: Car cannot be cast to Comparable

         WHY?
         - Arrays.sort() expects objects to implement Comparable
         - Car does NOT implement Comparable yet
        */
    }



    // ============================================================
    // 3. OBJECT SORTING USING COMPARABLE (NATURAL ORDER)
    // ============================================================
    static void objectSortingUsingComparable() {
        System.out.println("\n--- Comparable Sorting (Natural Order) ---");

        CarComparable[] cars = {
                new CarComparable("SUV", "petrol"),
                new CarComparable("sedan", "diesel"),
                new CarComparable("hatchback", "cng")
        };

        Arrays.sort(cars); // uses compareTo()

        for (CarComparable c : cars) {
            System.out.println(c.carName + " : " + c.carType);
        }

        /*
         OUTPUT (sorted by carName ASC):
         SUV
         hatchback
         sedan

         WHY?
         - compareTo() is defined INSIDE the class
         - This is NATURAL ORDER
        */
    }



    // ============================================================
    // 4. COMPARATOR USING LAMBDA
    // ============================================================
    static void comparatorWithLambda() {
        System.out.println("\n--- Comparator with Lambda ---");

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("SUV", "petrol"));
        cars.add(new Car("sedan", "diesel"));
        cars.add(new Car("hatchback", "cng"));

        // Sort by carType DESCENDING
        Collections.sort(cars,
                (c1, c2) -> c2.carType.compareTo(c1.carType));

        cars.forEach(c ->
                System.out.println(c.carName + " : " + c.carType));

        /*
         OUTPUT:
         SUV : petrol
         sedan : diesel
         hatchback : cng

         WHY?
         - Comparator logic passed at runtime
         - No modification to Car class
        */
    }



    // ============================================================
    // 5. COMPARATOR USING SEPARATE CLASS
    // ============================================================
    static void comparatorWithSeparateClass() {
        System.out.println("\n--- Comparator using Separate Class ---");

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("SUV", "petrol"));
        cars.add(new Car("sedan", "diesel"));
        cars.add(new Car("hatchback", "cng"));

        Collections.sort(cars, new CarNameComparator());

        cars.forEach(c ->
                System.out.println(c.carName + " : " + c.carType));

        /*
         WHY USE THIS?
         - Clean
         - Reusable
         - Interview preferred
        */
    }

    

    // ============================================================
    // 6. COMPARATOR USING ANONYMOUS CLASS
    // ============================================================
    static void comparatorWithAnonymousClass() {
        System.out.println("\n--- Comparator using Anonymous Class ---");

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("SUV", "petrol"));
        cars.add(new Car("sedan", "diesel"));
        cars.add(new Car("hatchback", "cng"));

        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.carName.compareTo(o2.carName);
            }
        });

        cars.forEach(c ->
                System.out.println(c.carName + " : " + c.carType));
    }
}

/*
 ============================================================================
 SUPPORTING CLASSES
 ============================================================================
 */

// Simple POJO (NO sorting logic)
class Car {
    String carName;
    String carType;

    Car(String name, String type) {
        this.carName = name;
        this.carType = type;
    }
}

// Comparable implementation (ONE natural order)
class CarComparable implements Comparable<CarComparable> {

    String carName;
    String carType;

    CarComparable(String name, String type) {
        this.carName = name;
        this.carType = type;
    }

    @Override
    public int compareTo(CarComparable o) {
        return this.carName.compareTo(o.carName); // ASC order
    }
}

// Separate Comparator class
class CarNameComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return o1.carName.compareTo(o2.carName);
    }
}

/*
 ============================================================================
 INTERVIEW QUESTIONS (VERY IMPORTANT)
 ============================================================================
 Q1. Can a class have multiple Comparators?
     YES

 Q2. Can a class implement multiple Comparable?
     NO

 Q3. Which is preferred in real projects?
     Comparator (more flexible)

 Q4. What happens if compareTo returns 0?
     Objects are considered EQUAL in sorting

 Q5. What if compareTo logic is inconsistent?
     TreeSet / TreeMap may lose elements

 Q6. Can Comparator be used without modifying class?
     YES (big advantage)

 Q7. Which sorting algorithm Java uses?
     - Objects: TimSort
     - Primitives: DualPivotQuickSort

 ============================================================================
 COMMON MISTAKES
 ============================================================================
 ❌ Using subtraction for large integers (overflow risk)
 ❌ Forgetting to implement Comparable
 ❌ Mixing inconsistent comparison logic

 ============================================================================
 END OF FILE
 ============================================================================
 */
