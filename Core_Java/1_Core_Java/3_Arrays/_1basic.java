public class _1basic {
    public static void main(String[] args) {
        // Note: Arrays in Java have a fixed size once initialized.
        // You cannot change the size of the array after creation.
        // To work with dynamic sizes, consider using ArrayList or other collections.
        // Java arrays are zero-indexed, meaning the first element is at index 0.
        // Arrays can store both primitive data types and objects.
        // Note: Java does not support negative indexing like some other languages (e.g., Python).
        // Attempting to access a negative index will result in an ArrayIndexOutOfBoundsException.
        
        

        // Declare and initialize an array
        int[] numbers = {10, 20, 30, 40, 50};

        // Access and print elements of the array
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Element at index " + i + ": " + numbers[i]);
        }

        // Modify an element in the array
        numbers[2] = 99;

        // Print the modified array
        System.out.println("Modified array:");
        for (int num : numbers) {
            System.out.println(num);
        }
        // For Each loop is used above to iterate through the array elements.

        
    }
}