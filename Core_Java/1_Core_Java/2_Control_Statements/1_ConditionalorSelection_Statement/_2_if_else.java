
public class _2_if_else {
    public static void main(String[] args) {
        // Definition: An if-else statement is a control flow statement that allows you to execute one block of code if a specified condition evaluates to true, and another block of code if the condition evaluates to false.
        // Syntax:
        // if (condition) {
        //     // code to be executed if condition is true
        // } else {
        //     // code to be executed if condition is false
        // }
        // Here, the condition is evaluated. If it is true, the code block inside the if statement is executed. If it is false, the code block inside the else statement is executed.

        // Example of an if-else statement
        // Check if a number is even or odd

        int number = 7;
        if (number % 2 == 0) {
            System.out.println(number + " is an even number.");
        } else {
            System.out.println(number + " is an odd number.");
        }
    }
}
