public class _7_InstanceOf_Operator {
    public static void main(String[] args) {
        // Definition of instanceof Operator
        // The instanceof operator is used to test whether an object is an instance of a specific class or implements a specific interface.
        // It returns a boolean value: true if the object is an instance of the specified type, and false otherwise.
        // The syntax is: object instanceof Type;

        // Example usage of instanceof operator

        // Example 1: Checking if an object is an instance of a specific class
        String str = "Hello, World!";
        boolean isString = str instanceof String;
        System.out.println("Is str an instance of String? " + isString); // Output: true

        // Example 2: Checking with inheritance
        class Animal {}
        class Dog extends Animal {}

        Animal myDog = new Dog();  // Upcasting
        boolean isDog = myDog instanceof Dog; // true
        boolean isAnimal = myDog instanceof Animal; // true
        System.out.println("Is myDog an instance of Dog? " + isDog); // Output: true
        System.out.println("Is myDog an instance of Animal? " + isAnimal);  // Output: true

        // Example 3: Checking with interfaces
        interface Vehicle {}
        class Car implements Vehicle {}

        Vehicle myCar = new Car();  // Upcasting
        boolean isVehicle = myCar instanceof Vehicle;   // true
        boolean isCar = myCar instanceof Car;          // true
        System.out.println("Is myCar an instance of Vehicle? " + isVehicle);    // Output: true 
        System.out.println("Is myCar an instance of Car? " + isCar);      // Output: true

        // Example 4: Checking with null
        String nullStr = null;
        boolean isNullString = nullStr instanceof String; // false
        System.out.println("Is nullStr an instance of String? " + isNullString); // Output: false
        // Note: instanceof returns false if the left-hand side is null
        // This prevents NullPointerException when checking types
        
        
        


    }
}
