import java.util.*;
import java.util.stream.*;

/*
================================================================================
                        JAVA STREAM API – COMPLETE GUIDE
================================================================================

This single Java file is designed as:
1) 📘 Complete Study Notes
2) 🧠 Conceptual Deep-Dive
3) 💼 Interview Preparation Guide
4) 🧪 Practical Code Reference

Topic Focus:
- Java Stream API (java.util.stream)

================================================================================
*/

/*
================================================================================
1. WHAT IS STREAM IN JAVA?
================================================================================

✔ Definition:
- Stream is a sequence of elements supporting functional-style operations.
- Introduced in Java 8.
- Used to process collections in a declarative, clean, and readable way.

✔ Important:
- Stream is NOT a data structure.
- It does NOT store data.
- It processes data from a source (Collection, Array, I/O).

✔ Package:
- java.util.stream

================================================================================
*/

/*
================================================================================
2. WHY STREAM API IS NEEDED?
================================================================================

Before Java 8:
❌ Verbose loops
❌ Boilerplate code
❌ Hard to read and maintain
❌ Error-prone iteration

Stream API provides:
✔ Clean & readable code
✔ Functional programming style
✔ Easy filtering, mapping, sorting
✔ Parallel processing support

================================================================================
*/

/*
================================================================================
3. REAL-WORLD ANALOGY
================================================================================

Imagine:
- A factory assembly line
- Raw material enters
- Multiple operations are applied step-by-step
- Final product comes out

➡ Stream works exactly like an assembly line.

================================================================================
*/

/*
================================================================================
4. KEY CHARACTERISTICS OF STREAM
================================================================================

✔ No storage – works on data source
✔ Does not modify original data
✔ Lazy evaluation
✔ Can be traversed only once
✔ Supports sequential and parallel execution

================================================================================
*/

/*
================================================================================
5. STREAM PIPELINE (VERY IMPORTANT)
================================================================================

A Stream pipeline has THREE parts:

1️⃣ Source
2️⃣ Intermediate Operations
3️⃣ Terminal Operation

Example:
collection.stream()
          .filter()
          .map()
          .collect();

✔ Without terminal operation → NOTHING executes

================================================================================
*/

/*
================================================================================
6. STREAM SOURCE
================================================================================

Common Sources:
✔ Collection.stream()
✔ Arrays.stream()
✔ Stream.of()
✔ IntStream, LongStream, DoubleStream

================================================================================
*/

/*
================================================================================
7. INTERMEDIATE OPERATIONS (LAZY)
================================================================================

✔ filter()
✔ map()
✔ flatMap()
✔ distinct()
✔ sorted()
✔ limit()
✔ skip()
✔ peek()

They return a Stream again.

================================================================================
*/

/*
================================================================================
8. TERMINAL OPERATIONS (EAGER)
================================================================================

✔ forEach()
✔ collect()
✔ reduce()
✔ count()
✔ findFirst()
✔ anyMatch(), allMatch(), noneMatch()
✔ min(), max()

Terminal operation triggers execution.

================================================================================
*/

public class _3_StreamIntroduction {

    public static void main(String[] args) {

        /*
        ================================================================================
        BASIC STREAM EXAMPLE
        ================================================================================
        */

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        numbers.stream()
               .filter(n -> n % 2 == 0)      // keep even numbers
               .map(n -> n * 10)             // multiply by 10
               .forEach(System.out::println);

        /*
        Execution Flow:
        - stream() creates stream
        - filter() selects elements
        - map() transforms elements
        - forEach() prints result
        */

        /*
        ================================================================================
        STREAM DOES NOT MODIFY ORIGINAL DATA
        ================================================================================
        */

        System.out.println("Original List: " + numbers);

        /*
        ================================================================================
        COLLECTORS EXAMPLE
        ================================================================================
        */

        List<Integer> squared =
                numbers.stream()
                       .map(n -> n * n)
                       .collect(Collectors.toList());

        System.out.println("Squared List: " + squared);

        /*
        ================================================================================
        DISTINCT & SORTED
        ================================================================================
        */

        List<Integer> duplicates = Arrays.asList(5, 3, 1, 3, 5, 7);

        List<Integer> uniqueSorted =
                duplicates.stream()
                          .distinct()
                          .sorted()
                          .collect(Collectors.toList());

        System.out.println("Unique & Sorted: " + uniqueSorted);

        /*
        ================================================================================
        STREAM WITH CUSTOM OBJECTS
        ================================================================================
        */

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", 50000),
                new Employee(2, "Bob", 70000),
                new Employee(3, "Charlie", 60000)
        );

        List<String> highPaidEmployees =
                employees.stream()
                         .filter(e -> e.salary > 55000)
                         .map(e -> e.name)
                         .collect(Collectors.toList());

        System.out.println("High Paid Employees: " + highPaidEmployees);

        /*
        ================================================================================
        REDUCE OPERATION
        ================================================================================
        */

        int sum =
                numbers.stream()
                       .reduce(0, Integer::sum);

        System.out.println("Sum using reduce: " + sum);

        /*
        ================================================================================
        MATCH OPERATIONS
        ================================================================================
        */

        boolean anyEven =
                numbers.stream().anyMatch(n -> n % 2 == 0);

        boolean allPositive =
                numbers.stream().allMatch(n -> n > 0);

        System.out.println("Any Even? " + anyEven);
        System.out.println("All Positive? " + allPositive);

        /*
        ================================================================================
        PARALLEL STREAM
        ================================================================================
        */

        numbers.parallelStream()
               .map(n -> n * 2)
               .forEach(System.out::println);

        /*
        Note:
        - Order is NOT guaranteed
        - Uses ForkJoinPool
        */
    }
}

/*
================================================================================
9. FUNCTIONAL INTERFACES USED IN STREAM
================================================================================

Predicate<T>  → boolean test(T)
Function<T,R> → R apply(T)
Consumer<T>   → void accept(T)
Supplier<T>   → T get()

================================================================================
*/

/*
================================================================================
10. LAZY EVALUATION
================================================================================

Intermediate operations are executed ONLY when terminal operation is called.

This improves performance.

================================================================================
*/

/*
================================================================================
11. STREAM vs COLLECTION
================================================================================

Feature             Collection             Stream
----------------------------------------------------
Storage             Yes                    No
Iteration           External               Internal
Reuse               Yes                    No
Evaluation          Eager                  Lazy

================================================================================
*/

/*
================================================================================
12. COMMON MISTAKES
================================================================================

❌ Forgetting terminal operation
❌ Reusing a stream
❌ Modifying data inside forEach
❌ Using parallel stream blindly

================================================================================
*/

/*
================================================================================
13. INTERVIEW QUESTIONS – STREAM API
================================================================================

BEGINNER:
Q1: What is Stream?
A: A sequence of elements supporting functional operations.

Q2: Does Stream store data?
A: No.

INTERMEDIATE:
Q3: Difference between map() and filter()?
A: map transforms, filter selects.

Q4: What is lazy evaluation?
A: Operations execute only at terminal step.

ADVANCED:
Q5: Difference between stream() and parallelStream()?
A: parallelStream executes operations in parallel.

Q6: Can we reuse a Stream?
A: No, stream can be consumed only once.

================================================================================
*/

/*
================================================================================
14. CODING INTERVIEW PROBLEMS USING STREAM
================================================================================

1. Find duplicate elements
2. Sum of even numbers
3. Group employees by department
4. Find second highest number
5. Frequency of characters in string

================================================================================
*/

/*
================================================================================
15. BEST PRACTICES
================================================================================

✔ Prefer Streams for readable transformations
✔ Use method references where possible
✔ Avoid heavy logic in lambda
✔ Use parallel streams carefully
✔ Use Collectors effectively

WHEN NOT TO USE STREAM:
- Very simple loops
- Performance-critical low-level code
- Complex debugging scenarios

================================================================================
END OF STREAM API FILE
================================================================================
*/

/*
================================================================================
SUPPORTING CLASS
================================================================================
*/

class Employee {

    int id;
    String name;
    int salary;

    Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}
