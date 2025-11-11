public class _1_Arithmetic_Operator {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;

        // Addition
        int sum = a + b;
        System.out.println("Addition: " + sum); // Output: 13

        // Subtraction
        int difference = a - b;
        System.out.println("Subtraction: " + difference); // Output: 7

        // Multiplication
        int product = a * b;
        System.out.println("Multiplication: " + product); // Output: 30

        // Division
        int quotient = a / b;
        System.out.println("Division: " + quotient); // Output: 3

        // Modulus
        int remainder = a % b;
        System.out.println("Modulus: " + remainder); // Output: 1

        System.out.println("Addition: " + a + b);  // Output: Addition: 103 COncatenation of strings as String came first 
        // Without parentheses, + works left to right as string concatenation; with parentheses, (a + b) is added before concatenation.

        System.out.println("Addition: " + (a + b)); // Output: Addition: 13
        // Parentheses () change the order of evaluation, forcing the addition to happen before concatenation.
    }
}
