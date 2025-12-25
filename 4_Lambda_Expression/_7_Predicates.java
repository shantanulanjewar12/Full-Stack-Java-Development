import java.util.function.IntPredicate;

/*
 * =================================================================================
 * TOPIC: The java.util.function Package and Predicates
 * =================================================================================
 *
 * THEORY:
 * 1. The 'java.util.function' Package:
 * - Java 8 introduced this package containing many built-in functional interfaces
 * so you don't have to create your own (like 'Data' or 'Lambda' in previous examples)
 * for common tasks.
 *
 * 2. Predicates:
 * - A 'Predicate<T>' is a functional interface that accepts an argument and returns a boolean.
 * - It is commonly used for filtering data or testing conditions.
 *
 * 3. Primitive Specializations (IntPredicate):
 * - Generic interfaces like Predicate<Integer> work with objects (wrapper classes).
 * - To improve performance and avoid "autoboxing" (converting int to Integer), Java provides
 * specialized interfaces like 'IntPredicate', 'LongPredicate', 'DoublePredicate'.
 * - 'IntPredicate' has one abstract method: 'boolean test(int value)'.
 */

public class _7_Predicates {
    public static void main(String[] args) {

        /*
         * STEP 1: Define Predicates using Lambda Expressions
         *
         * Syntax: value -> condition
         * - 'value': The input integer (inferred type 'int').
         * - 'condition': The boolean expression returning true/false.
         */

        // Predicate 1: Returns true if value is less than 18
        IntPredicate lessThan18 = value -> value < 18;

        // Predicate 2: Returns true if value is greater than 18
        IntPredicate moreThan18 = value -> value > 18;

        /*
         * STEP 2: Logical Composition (Chaining Predicates)
         *
         * Predicates have "Default Methods" that allow you to combine them:
         * - .and(other): Logical AND
         * - .or(other):  Logical OR
         * - .negate():   Logical NOT (!)
         *
         * LOGIC TRACE for input '10':
         *
         * 1. (lessThan18).test(10):
         * Is 10 < 18? -> TRUE.
         *
         * 2. .or(moreThan18):
         * Since the first part is TRUE, the OR condition (True || Anything) results in TRUE.
         * (Note: 'moreThan18' might not even be evaluated due to short-circuiting,
         * but mathematically: True || False = True).
         *
         * 3. .negate():
         * Inverts the result.
         * !TRUE -> FALSE.
         *
         * 4. .test(10):
         * Trigger the execution of this entire chain with the value 10.
         */
        System.out.println((lessThan18).or(moreThan18).negate().test(10));

        // Expected Output: false
    }
}