
public class _2_dowhile {
    public static void main(String[] args) {
        // Definition: A do-while loop is a control flow statement that allows code to be executed repeatedly based on a given Boolean condition. The loop guarantees that the code block is executed at least once before the condition is evaluated.
        // Syntax:
        // do {
        //     // code to be executed repeatedly
        // } while (condition);
        // Here, the code block inside the do statement is executed first, and then the condition is evaluated. If the condition is true, the loop continues to execute the code block. This process repeats until the condition evaluates to false.

        // Example of a do-while loop
        // Print numbers from 1 to 5

        int number = 1;
        do {
            System.out.println(number);
            number++; // Increment the number by 1
        } while (number <= 5);
    }
}
