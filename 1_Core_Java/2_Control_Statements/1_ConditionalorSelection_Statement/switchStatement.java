// ✅ Definition:
// The 'switch' statement in Java is used to execute one block of code among multiple options

public class switchStatement {
    public static void main(String[] args) {
        int day = 3;
        String dayName;

        // Using switch statement to determine the day name
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
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid day";
        }

        System.out.println("Day " + day + " is " + dayName);
    }
}
