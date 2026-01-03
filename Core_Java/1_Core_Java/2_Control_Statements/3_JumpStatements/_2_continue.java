
public class _2_continue {
    public static void main(String[] args) {
        // Definition: The continue statement in Java is a control flow statement that is used to skip the current iteration of a loop and proceed to the next iteration. When the continue statement is encountered, the remaining code inside the loop for that iteration is skipped, and the loop proceeds with the next iteration.
        // Syntax:
        // continue;
        
        // Example of continue in a for loop
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue; // Skip even numbers
            }
            System.out.println(i); // This will print only odd numbers
        }

        System.out.println("Loop completed.");
    }
}
