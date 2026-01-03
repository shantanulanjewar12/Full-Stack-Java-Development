/*
 * =================================================================================
 * TOPIC: Lambda Refresher - Parameters and Return Types
 * =================================================================================
 *
 * THEORY:
 * 1. Multiple Parameters:
 * - Lambdas can handle multiple arguments.
 * - When there is more than one argument, parentheses (x, y) are MANDATORY.
 * - You generally do not need to declare the types of the arguments (e.g., int x, float y)
 * because the compiler infers them from the interface definition.
 *
 * 2. Mixed Logic (Side Effects + Return Value):
 * - A functional interface method can return a value (like 'int' here).
 * - The lambda body can perform other operations (like printing to the console)
 * before returning that value. This is useful for logging or debugging.
 */

// Custom Functional Interface
interface Data {
    // This abstract method takes two arguments (int, float) and returns an int.
    // The lambda expression must strictly follow this signature.
    public int demo(int x, float y);
}

public class _5_Lambda_Refresher {
    public static void main(String[] args) {

        /*
         * IMPLEMENTING THE INTERFACE WITH LAMBDA
         *
         * Syntax Breakdown:
         * (x, y) -> { ... }
         *
         * 1. (x, y):
         * - These map to 'int x' and 'float y' from the 'demo' method.
         * - Type Inference: Java knows 'x' is int and 'y' is float.
         *
         * 2. ->:
         * - The Lambda operator.
         *
         * 3. { ... }:
         * - Block syntax is used because we have multiple lines of code.
         */
        Data data = (x, y) -> {
            // Statement 1: Side effect (Printing)
            System.out.println("Value of y is " + y);

            // Statement 2: Another side effect
            System.out.println("The value of x will be returned by the method");

            // Statement 3: Return Value
            // Since the interface method 'demo' returns an 'int', we MUST return an int here.
            return x;
        };

        /*
         * EXECUTING THE LAMBDA
         *
         * - We call data.demo(10, 25.00F).
         * - '10' is passed to 'x'.
         * - '25.00F' is passed to 'y'.
         *
         * Execution Flow:
         * 1. Prints "Value of y is 25.0"
         * 2. Prints "The value of x will be returned..."
         * 3. Returns '10'.
         *
         * Finally, the System.out.println wrapping the call prints the returned value (10).
         */
        System.out.println(data.demo(10, 25.00F));
    }
}