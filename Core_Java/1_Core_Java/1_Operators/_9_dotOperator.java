public class _9_dotOperator {
    public static void main(String[] args) {

        // This operator is used to access members of a class or an object using refernce variable.
        // Defination: The dot operator (.) in Java is used to access members (fields and methods) of a class or an object.
        // It is placed between the object (or class name) and the member name.
        // Example:
        // object.member or ClassName.member 
        // Here, 'object' is an instance of a class, 'ClassName' is the name of the class, and 'member' is either a field or a method of that class.
        
        // Example usage of dot operator:
        String name = "Hello, World!";
        int length = name.length(); // Using dot operator to call length() method
        System.out.println("Length of the string: " + length);

    }
}
