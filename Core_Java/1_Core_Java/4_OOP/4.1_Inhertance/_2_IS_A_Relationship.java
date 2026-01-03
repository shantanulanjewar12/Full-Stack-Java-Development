//===============================================================================
// IS-A RELATIONSHIP IN INHERITANCE
//===============================================================================
/*
💡 DEFINITION:
In Java, inheritance establishes an "IS-A" relationship between classes.
When a class inherits from another class, it signifies that the child class
is a specialized version of the parent class.
 For example, if we have a class Animal and a subclass Dog that extends Animal, we can
    say that Dog IS-A Animal. This means that Dog inherits the properties and behaviors of Animal,
    while also adding its own specific features.
💡 EXAMPLE:

===============================================================================

Key POINTS:
✔ The "IS-A" relationship is fundamental to inheritance in Java.
✔ It promotes code reuse by allowing subclasses to inherit common functionality from superclasses.
✔ The relationship should reflect real-world hierarchies to maintain logical consistency.
✔ Misusing the "IS-A" relationship can lead to poor design and maintenance issues.
===============================================================================
*/

// ==================== Parent Class =====================
class Vehicle {
    int speed = 60;

    void run() {
        System.out.println("Vehicle is running...");
    }
}

// ==================== Child Class ======================
class Car extends Vehicle {  // IS-A relationship (Car IS-A Vehicle)
    void display() {
        System.out.println("Car Speed: " + speed);
    }
}


// ==================== Main Class =======================
public class _2_IS_A_Relationship {
    public static void main(String[] args) {

        // Creating objects to demonstrate IS-A relationship
        Car myCar = new Car();
        myCar.run();         // inherited method
        myCar.display();

        Vehicle myVehicle = new Vehicle();
        myVehicle.run();
    }
}



// ===============================================================================
// OUTPUT:
// --------------------------------
// Vehicle is running...
// Car Speed: 60
// Vehicle is running...
// ===============================================================================

// ===============================================================================
/*
 * Explanation Of IS-A Relationship in this Example:
 * In this example, we have a parent class Vehicle and a child class Car that extends Vehicle.
 * The relationship between Car and Vehicle is an "IS-A" relationship because a Car is a
 * specialized type of Vehicle. This means that Car inherits the properties and methods
 * of Vehicle, allowing it to use the run() method defined in Vehicle.
 * When we create an instance of Car, it can access the speed variable and run() method
 * from Vehicle, demonstrating the IS-A relationship.
 * This relationship is logical and reflects real-world hierarchies, as a car is indeed a type of vehicle.
 * Using inheritance in this way promotes code reuse and establishes a clear hierarchy between classes.
 * ===============================================================================
 
 */