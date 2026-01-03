import java.util.Arrays;
import java.util.List;

/*
 * =================================================================================
 * TOPIC: Iteration with forEach loop and Lambda Expressions
 * =================================================================================
 *
 * THEORY:
 * 1. External vs. Internal Iteration:
 * - Traditional loops (for-loop, for-each loop) are "External Iteration". You, the programmer,
 * control the flow and the iterator.
 * - The 'forEach' method introduced in Java 8 is "Internal Iteration". The collection itself
 * handles the traversal of elements, often allowing for optimizations (like parallel processing).
 *
 * 2. The Consumer Interface:
 * - The 'forEach' method accepts a functional interface called 'Consumer<T>'.
 * - 'Consumer' has one abstract method: 'void accept(T t)'.
 * - It represents an operation that accepts a single input argument and returns no result (void).
 */

class Data {
    private String name;

    public Data(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}

public class _6_terationWithForEachLoopAndLambdaExpressions {
    public static void main(String[] args) {
        // STEP 1: Create a List of Data objects
        // Arrays.asList creates a fixed-size list backed by the specified array.
        List<Data> list = Arrays.asList(new Data("Chaand"), new Data("John"), new Data("Raj"));

        /*
         * STEP 2: Iterate using forEach and Lambda
         *
         * Syntax: list.forEach(Consumer action)
         *
         * Lambda Syntax Breakdown:
         * temp -> { ... }
         *
         * 1. 'temp':
         * - Represents the current element in the iteration (of type 'Data').
         * - Equivalent to 'Data temp' in a traditional enhanced for-loop.
         *
         * 2. '->':
         * - The arrow token.
         *
         * 3. '{ ... }':
         * - The Block Body. We use curly braces because we have multiple statements inside
         * (an if-statement and a print statement).
         */
        list.forEach(temp -> {
            // Logic: Check if the current object's name is "Chaand"
            if (temp.getName().equals("Chaand")) {
                // If true, print a prefix (Side effect)
                System.out.print("Founder StudyEasy: ");
            }
            // Always print the name
            System.out.println(temp.getName());
        });

        /*
         * COMPARISON WITH TRADITIONAL LOOP:
         *
         * for(Data temp : list) {
         * if(temp.getName().equals("Chaand")){
         * System.out.print("Founder StudyEasy: ");
         * }
         * System.out.println(temp.getName());
         * }
         *
         * The Lambda version is more concise and shifts the responsibility of iteration logic
         * to the Collection implementation.
         */
    }
}