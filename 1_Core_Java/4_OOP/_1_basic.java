//Defination and Usage of Classes and Objects in Java
//A class is a blueprint for creating objects. It defines the properties (attributes) and behaviors (methods) that the objects created from the class will have.
//An object is an instance of a class. It represents a specific realization of the class with its own unique state and behavior.
//In this example, we will define a simple class called Dog with attributes like name and age, and methods like bark() and fetch().
//We will then create an object of the Dog class and demonstrate how to use its attributes and methods.

public class _1_basic {
    // Define a Dog class
    static class Dog {
        // Attributes
        String name;
        int age;

        // Method to make the dog bark
        void bark() {
            System.out.println(name + " says: Woof Woof!");
        }

        // Method to simulate fetching a ball
        void fetch() {
            System.out.println(name + " is fetching the ball!");
        }
    }

    public static void main(String[] args) {
        // Create an object of the Dog class
        Dog myDog = new Dog();

        // Set attributes
        myDog.name = "Buddy";
        myDog.age = 3;

        // Call methods
        myDog.bark();
        myDog.fetch();

        // Display dog information
        System.out.println("Dog's Name: " + myDog.name);
        System.out.println("Dog's Age: " + myDog.age + " years");
        
        // Modify attributes
        myDog.age = 4;
        System.out.println("Dog's New Age: " + myDog.age + " years");

        
    }
}
