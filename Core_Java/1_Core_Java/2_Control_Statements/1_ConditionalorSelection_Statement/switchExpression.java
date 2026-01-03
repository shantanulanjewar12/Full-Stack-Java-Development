// switch Expression: Java 12 introduced switch expressions, which allow you to use the switch statement as an expression that returns a value. This feature enhances the readability and conciseness of the code.
// Key Features:
// 1. Arrow Syntax: The new arrow syntax (->) is used to separate case labels from their corresponding expressions.
// 2. Yield Statement: The yield statement can be used to return a value from a case block.
// 3. Multiple Labels: You can group multiple case labels together to execute the same block of code.

// Syntax: 
// switch (variable) {
//     case value1 -> expression1;
//     case value2 -> expression2;
//     ...
//     default -> defaultExpression;
// }



public class switchExpression {
    public static void main(String[] args) {
        
        int day = 3;
        String dayName = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid day";
        };
        System.out.println("Day " + day + " is " + dayName);

        // Case N label :- Grouping multiple labels
        // defination: You can group multiple case labels together to execute the same block of code.
        int month = 5;
        String monthName = switch (month) { 
            case 1, 2, 3 -> "First Quarter";
            case 4, 5, 6 -> "Second Quarter";
            case 7, 8, 9 -> "Third Quarter";
            case 10, 11, 12 -> "Fourth Quarter";
            default -> "Invalid month";
        };
        System.out.println("Month " + month + " is in " + monthName);


        // Use of Yeild:
        // defination: The yield statement can be used to return a value from a case block.
        // This is particularly useful when the case block contains multiple statements.
        // how to use: You can use the yield statement within a case block to return a value.
        int score = 85;
        String grade = switch (score / 10) {
            case 10, 9 -> {
                System.out.println("Excellent score!");
                yield "A";
            }
            case 8 -> {
                System.out.println("Good score!");
                yield "B";
            }
            case 7 -> {
                System.out.println("Average score!");
                yield "C";
            }
            case 6 -> {
                System.out.println("Below average score!");
                yield "D";
            }
            default -> {
                System.out.println("Failing score!");
                yield "F";
            }
        };
        System.out.println("Grade: " + grade);
        // Output:
        // Day 3 is Wednesday
        // Month 5 is in Second Quarter
        // Excellent score!
        // Grade: A

        // What does yield do in Java switch?
        // In Java switch expressions, the yield statement is used to return a value from a case block. When a case block contains multiple statements, you can use yield to specify the value that should be returned when that case is matched. This allows for more complex logic within a case while still providing a clear return value for the switch expression.

        // In summary, switch expressions in Java 12 provide a more concise and readable way to handle multiple conditions compared to traditional switch statements. The arrow syntax, yield statement, and ability to group multiple labels enhance the expressiveness of the switch construct.


    }


}
