
public class _3_nested_if {
    public static void main(String[] args) {
        // Definition: A nested if statement is an if statement that is contained within another if statement. It allows you to test multiple conditions in a hierarchical manner.
        // Syntax:
        // if (condition1) {
        //     // code to be executed if condition1 is true
        //     if (condition2) {
        //         // code to be executed if condition2 is true
        //     }
        // }
        // Here, the outer if statement checks condition1. If it is true, the inner if statement checks condition2. If both conditions are true, the code block inside the inner if statement is executed.

        // Example of a nested if statement
        // Check if a person is eligible for a senior citizen discount
        // Assuming the age for senior citizen discount is 60 and the person must also be a member of the loyalty program

        int age = 65;
        boolean isLoyaltyMember = true;

        if (age >= 60) {
            if (isLoyaltyMember) {
                System.out.println("You are eligible for a senior citizen discount.");
            } else {
                System.out.println("You need to be a loyalty program member to get the senior citizen discount.");
            }
        } else {
            System.out.println("You are not eligible for a senior citizen discount.");
        }
    }
}
