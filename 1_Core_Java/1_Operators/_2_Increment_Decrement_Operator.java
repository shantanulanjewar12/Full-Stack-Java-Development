public class _2_Increment_Decrement_Operator {
    public static void main(String[] args) {
        int x = 5;

        // Post-increment
        System.out.println("Post-increment: " + (x++)); // Output: 5
        System.out.println("Value after post-increment: " + x); // Output: 6

        // Pre-increment
        System.out.println("Pre-increment: " + (++x)); // Output: 7

        // Post-decrement
        System.out.println("Post-decrement: " + (x--)); // Output: 7
        System.out.println("Value after post-decrement: " + x); // Output: 6

        // Pre-decrement
        System.out.println("Pre-decrement: " + (--x)); // Output: 5
        
    }
}
