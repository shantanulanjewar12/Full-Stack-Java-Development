
public class _1_break {
    public static void main(String[] args) {
        // Definition: The break statement in Java is a control flow statement that is used to terminate the execution of a loop or switch statement prematurely. When the break statement is encountered, the control is transferred to the statement immediately following the loop or switch.
        // Syntax:
        // break;
        
        // Example of break in a for loop
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break; // Exit the loop when i equals 5
            }
            System.out.println(i);
        }

        System.out.println("Loop terminated.");

        // Example of break in a switch statement
        int day = 3;
        String dayName;
        switch (day) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            default:
                dayName = "Weekend";
        }
        System.out.println("Day: " + dayName);
    }
}
