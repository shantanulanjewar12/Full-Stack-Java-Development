
public class _4_if_else_if {
    public static void main(String[] args) {
        // Definition: An if-else-if statement is a control flow statement that allows you to test multiple conditions sequentially. It executes the code block corresponding to the first true condition it encounters.
        // Syntax:
        // if (condition1) {
        //     // code to be executed if condition1 is true
        // } else if (condition2) {
        //     // code to be executed if condition2 is true
        // } else {
        //     // code to be executed if both condition1 and condition2 are false
        // }
        // Here, the conditions are evaluated in order. The code block inside the first true condition is executed, and the rest are skipped. If none of the conditions are true, the code block inside the else statement is executed.

        // Example of an if-else-if statement
        // Determine the grade based on the score

        int score = 85;

        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else if (score >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
    }
}
