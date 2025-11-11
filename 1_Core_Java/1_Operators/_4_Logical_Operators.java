public class _4_Logical_Operators {
    public static void main(String[] args) {
        boolean x = true;
        boolean y = false;

        // Logical AND- Returns true only if both conditions are true. (Both True)
        // Returns false if at least one condition is false.
        System.out.println("x && y: " + (x && y)); // false


        // Logical OR- Returns true if at least one condition is true. (One Should True)
        //Returns false only if both conditions are false.
        System.out.println("x || y: " + (x || y)); // true

        // Logical NOT
        // Reverses the value of the boolean expression. (True to False and False to True)
        System.out.println("!x: " + (!x)); // false
        System.out.println("!y: " + (!y)); // true
    }
}
