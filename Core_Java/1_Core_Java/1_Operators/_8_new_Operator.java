// The 'new' operator in Java
// --------------------------
// ✅ Definition: 
// "new" is a keyword in Java used to create new objects.
// It allocates memory for the object and returns a reference to that memory location.
// We can create objects of both built-in classes and user-defined classes using the 'new' operator.

// The 'new' operator is used to create (instantiate) new objects in Java.
// It allocates memory for the object in the heap memrory and returns a reference to it.

public class _8_new_Operator {
    public static void main(String[] args) {

        // Example 1: Creating a new String object using 'new'
        // Here, a new String object is created and stored in memory.
        String str = new String("Hello, World!");

        // Example 2: Creating a new object of a user-defined class
        // 'new' allocates memory for MyClass and calls its constructor.
        MyClass myObject = new MyClass();

        // Printing the String
        System.out.println(str);

        // Calling a method using the new object
        myObject.displayMessage();
    }
}

// A simple class to demonstrate object creation
class MyClass {
    // Method to display a message
    void displayMessage() {
        System.out.println("This message is from MyClass object created using 'new' keyword!");
    }
}

/*
📝 Summary:
1️⃣ 'new' keyword creates an object in memory (heap area).
2️⃣ It returns a reference (address) of that object.
3️⃣ Used for both built-in classes (like String, Scanner, etc.) and user-defined classes.
*/
