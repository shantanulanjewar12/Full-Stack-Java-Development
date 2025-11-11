public class _6_Ternary_Operator {
    public static void main(String[] args) {

        //Defination of Ternary Operator 
        // The ternary operator is a shorthand way of expressing an if-else statement.
        // It takes three operands: a condition, a value if the condition is true, and a value if the condition is false.
        // The syntax is: condition ? value_if_true : value_if_false;
        // Advantages of Ternary Operator
        // Conciseness: It allows you to write conditional statements in a more compact form.
        // Readability: For simple conditions, it can enhance readability by reducing the number of lines of code.
        
        // Example usage of the ternary operator
        
        int a = 10;
        int b = 20;
        
        // Example 1: Finding the maximum of two numbers
        int max = (a > b) ? a : b;
        System.out.println("The maximum value is: " + max);

        // Example 2: Using ternary operator to check if a number is even or odd
        int number = 15;
        String result = (number % 2 == 0) ? "Even" : "Odd";
        System.out.println("The number " + number + " is: " + result);

        // Example 3:  Using ternary operator for nested conditions
        int age = 25;
        String category = (age < 13) ? "Child" : (age < 20) ? "Teenager" : "Adult";
        System.out.println("The age category is: " + category);

    }
}
