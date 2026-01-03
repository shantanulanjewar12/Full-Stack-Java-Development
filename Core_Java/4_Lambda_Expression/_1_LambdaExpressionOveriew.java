
/*
 * =================================================================================
 * TOPIC: Introduction to Lambda Expressions in Java
 * =================================================================================
 *
 * THEORY:
 * 1. What is a Lambda Expression?
 * - A Lambda expression is essentially an anonymous method (a function without a name).
 * - It introduces functional programming concepts to Java.
 * - It provides a clear and concise way to represent one method interface using an expression.
 *
 * 2. Functional Interface:
 * - To use a Lambda expression, you first need a "Functional Interface".
 * - A Functional Interface is an interface that contains exactly ONE abstract method.
 * - The Lambda expression provides the implementation for that single abstract method.
 */

// This is our Functional Interface.
// It is "functional" because it has only one abstract method: 'demo()'.
interface Lambda {
    public void demo();
}

public class _1_LambdaExpressionOveriew {
    public static void main(String[] args) {
        /*
         * SYNTAX OF LAMBDA EXPRESSION:
         * (argument-list) -> { body }
         *
         * 1. (argument-list): The parameters required by the interface method.
         * 2. ->: The arrow token (lambda operator) linking arguments to the body.
         * 3. { body }: The code to be executed. If it's a single statement, curly braces {}
         * are optional.
         */

        // TRADITIONAL WAY (without Lambda):
        // You would typically create an anonymous inner class like this:
        // Lambda lambda = new Lambda() {
        //     @Override
        //     public void demo() {
        //         System.out.println("Statement 01");
        //     }
        // };

        // WITH LAMBDA EXPRESSION:
        // We implement the 'Lambda' interface in a single line.
        Lambda lambda = (() -> System.out.println("Statement 01"));

        /*
         * BREAKDOWN OF THE CODE ABOVE:
         *
         * 'Lambda lambda'
         * - The type of the variable is the interface 'Lambda'.
         *
         * '()'
         * - These empty parentheses correspond to the arguments of the 'demo()' method.
         * - Since 'public void demo()' takes NO arguments, we write ().
         *
         * '->'
         * - Points to the implementation.
         *
         * 'System.out.println("Statement 01")'
         * - This is the body of the method.
         * - It provides the implementation for 'demo()'.
         */

        // EXECUTING THE LAMBDA:
        // We call the method defined in the interface.
        // This triggers the code inside the lambda expression we defined above.
        lambda.demo();

        // Output: Statement 01
    }
}