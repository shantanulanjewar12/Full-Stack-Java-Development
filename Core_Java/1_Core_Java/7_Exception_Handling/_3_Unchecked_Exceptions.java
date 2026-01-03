/**
 * ============================================================
 * FILE NAME  : _3_Unchecked_Exceptions.java
 * PACKAGE    : ExceptionHandling
 * TOPIC      : Unchecked / Runtime Exceptions
 * ============================================================
 *
 * =========================
 * 1. WHAT ARE UNCHECKED EXCEPTIONS?
 * =========================
 * - Exceptions that occur at RUNTIME
 * - Compiler does NOT check them
 * - Subclasses of RuntimeException
 *
 * =========================
 * 2. WHY THEY ARE CALLED RUNTIME EXCEPTIONS?
 * =========================
 * - They occur during program execution
 * - Mostly caused due to programming mistakes
 *
 * =========================
 * 3. DO WE NEED TO HANDLE THEM?
 * =========================
 * - NOT mandatory
 * - But GOOD PRACTICE in real applications
 *
 * =========================
 * 4. COMMON UNCHECKED EXCEPTIONS
 * =========================
 *
 * - 1. NullPointerException
Definition: This exception occurs when you try to use an object reference that is null. In simpler terms, you're trying to access or modify an object that hasn’t been created yet, or has been set to null.
Where is it used?: It's commonly encountered when working with objects, especially if you forget to initialize them or assign them null.
Example:
String str = null;
System.out.println(str.length());  // This will throw a NullPointerException
Why?: You're trying to call a method (like length()) on an object that doesn't exist (null), which causes this error.


2. ArithmeticException
Definition: This exception occurs when an illegal arithmetic operation is performed, such as dividing by zero.
Where is it used?: It happens when you do math that doesn't make sense, like division by zero or an invalid mathematical operation.
Example:
int result = 10 / 0;  // This will throw an ArithmeticException
Why?: Division by zero is mathematically undefined, so Java throws an exception to handle it.


3. ArrayIndexOutOfBoundsException
Definition: This exception happens when you try to access an array with an index that is outside the valid range (either negative or larger than the size of the array).
Where is it used?: It’s used when you’re working with arrays (collections of elements) and accidentally access an invalid index.
Example:
int[] numbers = {1, 2, 3};
System.out.println(numbers[5]);  // This will throw an ArrayIndexOutOfBoundsException
Why?: Arrays have a specific size, and you’re trying to access an index that doesn’t exist, causing this error.


4. StringIndexOutOfBoundsException
Definition: This exception occurs when you try to access an invalid position in a string (like an index that’s either negative or greater than the length of the string).
Where is it used?: It’s commonly used when manipulating strings, such as trying to get a character at an invalid index.
Example:
String text = "Hello";
System.out.println(text.charAt(10));  // This will throw a StringIndexOutOfBoundsException
Why?: You’re trying to access a character position in the string that doesn’t exist.


5. NumberFormatException
Definition: This exception happens when you try to convert a string into a number (like int or double), but the string doesn’t represent a valid number.
Where is it used?: This is common when trying to convert user input or a string into a numerical value.
Example:
String text = "abc";
int number = Integer.parseInt(text);  // This will throw a NumberFormatException
Why?: The string "abc" doesn’t represent a valid integer, so it can’t be converted into a number.


6. ClassCastException
Definition: This exception occurs when you try to cast an object to a class it isn’t compatible with.
Where is it used?: This is used when you're working with object casting (converting one object type into another), especially in the context of inheritance or interfaces.
Example:
Object obj = new String("Hello");
Integer num = (Integer) obj;  // This will throw a ClassCastException

Why?: The object obj is actually a String, not an Integer, so you can’t cast it to an Integer, leading to this exception


 *
 * =========================
 * 5. IMPORTANT RULE
 * =========================
 * - Compiler will NOT force try-catch or throws
 * - Program compiles successfully
 *
 * =========================
 * 6. WHY COMPILER DOES NOT FORCE HANDLING?
 * =========================
 * - These exceptions happen due to logical mistakes
 * - Better fixed by correcting code, not by handling
 *
 * ============================================================
 */

public class _3_Unchecked_Exceptions {

    public static void main(String[] args) {

        // -----------------------------
        // 1. ArithmeticException
        // -----------------------------
        int a = 10;
        int b = 0;

        // JVM throws ArithmeticException
        System.out.println(a / b);

        // -----------------------------
        // 2. NullPointerException
        // -----------------------------
        String name = null;

        // JVM throws NullPointerException
        System.out.println(name.length());

        // -----------------------------
        // 3. ArrayIndexOutOfBoundsException
        // -----------------------------
        int[] arr = {1, 2, 3};

        // JVM throws ArrayIndexOutOfBoundsException
        System.out.println(arr[5]);

        // -----------------------------
        // 4. NumberFormatException
        // -----------------------------
        String value = "abc";

        // JVM throws NumberFormatException
        int num = Integer.parseInt(value);
        System.out.println(num);

        System.out.println("Program executed without runtime exception");
    }
}

/*
Q1: What is unchecked exception?
A: Exception not checked by compiler, occurs at runtime.

Q2: Parent class of unchecked exception?
A: RuntimeException

Q3: Why compiler doesn’t force handling?
A: Because they are caused by programming mistakes.

Q4: Can unchecked exceptions be caught?
A: Yes, using try-catch.

Q5 (TRICKY):
Can we use throws RuntimeException?
A: Yes, but it is meaningless and bad practice.

Q6: Is NullPointerException checked?
A: No, it is unchecked.

Q7: Which exception is thrown when divide by zero?
A: ArithmeticException

🧪 REAL-WORLD EXAMPLES
✔ API validation
✔ Input validation
✔ Database null checks
✔ Defensive programming
*/