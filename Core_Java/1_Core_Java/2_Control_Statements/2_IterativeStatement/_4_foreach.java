
public class _4_foreach {
    public static void main(String[] args) {
        // Definition: A foreach loop (also known as enhanced for loop) is a control flow statement that allows you to iterate over elements in an array or a collection without needing to manage an index variable. It simplifies the syntax and improves code readability.
        // Syntax:
        // for (dataType element : collection) {
        //     // code to be executed for each element
        // }
        // Here, 'element' represents the current item in the 'collection' during each iteration of the loop. The loop automatically iterates through all elements in the collection.

        // Example of a foreach loop
        // Print each element in an array of integers

        int[] numbers = {1, 2, 3, 4, 5};
        for (int number : numbers) {
            System.out.println(number);
        }

        // Example of a foreach loop with a collection
        String[] fruits = {"Apple", "Banana", "Cherry", "Date"};
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        
    }
}
