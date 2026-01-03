
/*
 * =================================================================================
 * TOPIC: Multithreading with Lambda Expressions
 * =================================================================================
 *
 * THEORY:
 * 1. The Runnable Interface:
 * - In Java, to run a task on a separate thread, you typically use the 'Runnable' interface.
 * - 'Runnable' is a Functional Interface because it contains exactly one abstract method: 'public void run()'.
 * - Because it is a functional interface, we can use a Lambda expression to implement it instead of
 * creating an anonymous inner class or a separate class implementing Runnable.
 *
 * 2. Block Lambda Syntax:
 * - In the previous example, the lambda had only one statement, so we didn't need curly braces {}.
 * - If your lambda body contains MULTIPLE statements, you MUST use curly braces { ... }.
 * - This is often called a "Block Lambda".
 */

public class _2_MultithreadingWithLambdaExpressions {
    public static void main(String[] args) {

        /*
         * STEP 1: Define the Thread and its Task
         *
         * construct: new Thread(Runnable target)
         *
         * We are passing a Lambda expression as the 'Runnable' argument to the Thread constructor.
         *
         * Syntax Breakdown:
         * () -> { ... }
         *
         * 1. '()'
         * - Corresponds to the arguments of the 'run()' method in the Runnable interface.
         * - 'run()' takes NO arguments, so the parentheses are empty.
         *
         * 2. '->'
         * - The arrow token separating arguments from the body.
         *
         * 3. '{ ... }'
         * - The Block Body. Since we have two print statements, we wrap them in curly braces.
         * - This entire block is essentially the implementation of the 'run()' method.
         */
        Thread thread = new Thread(() -> {
            // This code will be executed by the new thread when it starts.
            System.out.println("Statement 01");
            System.out.println("Statement 02");
        });

        /*
         * STEP 2: Start the Thread
         *
         * - 'thread.start()' instructs the Java Virtual Machine (JVM) to create a new call stack.
         * - The JVM then calls the 'run()' method (our lambda body) on that new thread.
         * - The main thread continues its own execution (if there were more code below),
         * while the new thread executes the print statements concurrently.
         */
        thread.start();

        // Expected Output:
        // Statement 01
        // Statement 02
    }
}