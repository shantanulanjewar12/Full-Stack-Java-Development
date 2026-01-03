
// ✅ Definition:
// The 'return' statement in Java is used to exit from a method and optionally return a value.
// It sends control back to the point where the method was called.

public class _3_return {

    public static void main(String[] args) {

        // Example 1: return with a value
        // The add() method returns the sum of two numbers.
        int result = add(5, 10);
        System.out.println("Sum: " + result);

        // Example 2: return without a value (void method)
        // The printMessage() method just prints a message and returns control to main().
        printMessage("Hello, World!");
    }

    // Method that returns an int value
    static int add(int a, int b) {
        int sum = a + b;
        // 'return sum;' sends the value back to the caller (main method)
        return sum;
    }

    // Method that has no return value (void)
    static void printMessage(String msg) {
        System.out.println("Message: " + msg);
        // 'return;' is optional in void methods — it just exits the method
        return;
    }
}

/*
📝 Summary:
1️⃣ 'return' is used to exit from a method.
2️⃣ In methods that return a value → use 'return value;'
3️⃣ In void methods → 'return;' is optional, used only to exit early.
4️⃣ Once 'return' is executed, the remaining code in that method does not run.
*/
