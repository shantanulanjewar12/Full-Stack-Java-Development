
public class _1_while {
    public static void main(String[] args) {
        // Definition: A while loop is a control flow statement that allows code to be executed repeatedly based on a given Boolean condition. The loop continues to execute as long as the condition evaluates to true.
        // Syntax:
        // while (condition) {
        //     // code to be executed repeatedly as long as condition is true
        // }
        // Here, the condition is evaluated before each iteration of the loop. If it is true, the code block inside the while loop is executed. This process repeats until the condition evaluates to false.

        // Example of a while loop
        // Print numbers from 1 to 5

        int number = 1;
        while (number <= 5) {
            System.out.println(number);
            number++; // Increment the number by 1
        }
    }
}
