// ===============================================
// 🔹 _5_ObjectCreationAndInstantiation.java
// ===============================================
// A complete guide to Object Creation and Instantiation in Java
// Author: Shantanu Lanjewar
// ===============================================

/*
===============================================================================
💡 WHAT IS AN OBJECT IN JAVA?
===============================================================================
👉 Definition:
An **object** is a real-world entity or an instance of a class that has:
   - State (data → variables)
   - Behavior (functions → methods)

Example:
   class Car { String color; void drive() { } }
   Car c1 = new Car();   // c1 is an object (instance) of class Car

===============================================================================
🔹 WHAT IS INSTANTIATION?
===============================================================================
👉 Definition:
**Instantiation** means creating a specific instance (object) of a class in memory.

- “Object creation” = process of allocating memory.
- “Instantiation” = actual realization of that object in memory (via constructor).

✅ Example:
   Car c1 = new Car();

🔹 Breakdown:
   1️⃣ `Car` → class (blueprint)
   2️⃣ `new` → allocates memory on Heap
   3️⃣ `Car()` → calls constructor (instantiation step)
   4️⃣ `c1` → reference variable stored in Stack

===============================================================================
🔹 OBJECT CREATION FLOW
===============================================================================
When you write:
    Car c1 = new Car();

Step by Step:
1️⃣ Class is loaded into Method Area (if not already).
2️⃣ JVM allocates memory for new object on Heap.
3️⃣ JVM initializes default values for instance variables.
4️⃣ Constructor `Car()` is called to initialize custom values.
5️⃣ Reference (memory address) is assigned to variable `c1` in Stack.

===============================================================================
🔹 DIAGRAM
===============================================================================

   Stack Memory                     Heap Memory
   ------------                     ------------
   c1  ───────────────►  [ Car Object ]
                           color = "Red"
                           speed = 100
                           fuel  = 50

===============================================================================
🔹 HOW TO CREATE OBJECTS IN JAVA (5 WAYS)
===============================================================================
*/

class Car implements Cloneable, java.io.Serializable {
    String color;
    int speed;

    Car() {
        color = "Red";
        speed = 100;
        System.out.println("Constructor: Car object created!");
    }

    void drive() {
        System.out.println("Driving " + color + " car at speed " + speed + " km/h");
    }
}

public class _5_ObjectCreationAndInstantiation {
    public static void main(String[] args) throws Exception {

        System.out.println("====== OBJECT CREATION IN JAVA ======");

        // 1️⃣ Using new keyword (most common)
        Car car1 = new Car();
        car1.drive();

        // 2️⃣ Using Class.forName() (Dynamic class loading)
        Car car2 = (Car) Class.forName("Car").getDeclaredConstructor().newInstance();
        car2.drive();

        // 3️⃣ Using newInstance() method of Class (older reflection API - deprecated in modern Java)
        Car car3 = Car.class.getDeclaredConstructor().newInstance();
        car3.drive();

        // 4️⃣ Using clone() method (creates copy of existing object)
        // // Car car4 = (Car) car1.clone();
        // car4.color = "Blue";
        // car4.speed = 120;
        // car4.drive();

        // 5️⃣ Using deserialization (reading from saved object file)
        // ⚠️ Just showing conceptually — would normally involve file I/O
        // ObjectInputStream in = new ObjectInputStream(new FileInputStream("car.ser"));
        // Car car5 = (Car) in.readObject();
        // in.close();

        System.out.println("\nObject Creation Demonstrated Successfully!");
    }
}

/*
===============================================================================
🔹 SUMMARY OF OBJECT CREATION METHODS
===============================================================================
| Method | Description | When to Use |
|---------|-------------|-------------|
| new | Most common method | Regular object creation |
| Class.forName() | Loads class dynamically | Reflection / Frameworks |
| newInstance() | Deprecated reflection-based | Legacy code |
| clone() | Creates exact copy | When copying object state |
| Deserialization | Restores from file/network | Persistent data recovery |

===============================================================================
🔹 MEMORY ALLOCATION FLOW (with new keyword)
===============================================================================

1️⃣ Memory allocated on Heap.
2️⃣ Default values assigned (0, null, false).
3️⃣ Constructor runs → assigns real values.
4️⃣ Stack stores reference variable.

Example:
    Car c = new Car();

Heap → [Car object data]
Stack → reference variable `c`

===============================================================================
🔹 DIFFERENCE BETWEEN OBJECT CREATION & INSTANTIATION
===============================================================================
| Aspect | Object Creation | Instantiation |
|---------|------------------|----------------|
| Meaning | Allocating memory for an object | Initializing that object (via constructor) |
| Performed By | `new` keyword | Constructor call |
| Example | `new Car()` allocates memory | `Car()` instantiates |
| Level | Memory level | Logical initialization level |

===============================================================================
🔹 IMPORTANT NOTES
===============================================================================
✅ Every object in Java is created on Heap.
✅ Local references (like c1, c2) are stored in Stack.
✅ Constructors are responsible for initializing objects.
✅ Objects are accessed via references, never directly.
✅ Garbage Collector removes objects with no references.

===============================================================================
🔹 INTERVIEW SUMMARY (SPEAKING POINTS)
===============================================================================
👉 1. Object = instance of a class containing data and behavior.
👉 2. Instantiation = process of creating a real object from class blueprint.
👉 3. Objects are created in Heap; references are stored in Stack.
👉 4. `new` keyword both allocates memory and calls constructor.
👉 5. 5 ways to create objects: new, Class.forName(), newInstance(), clone(), deserialization.
👉 6. Garbage Collector frees objects when no references exist.
👉 7. Difference: Creation → memory allocation, Instantiation → initialization.

===============================================================================
🔹 BONUS INTERVIEW QUESTIONS
===============================================================================
Q1️⃣: What is the difference between `new` and `newInstance()`?
A: `new` calls constructor directly; `newInstance()` uses reflection and can throw exceptions.

Q2️⃣: Can we create an object without using new?
A: Yes — via clone(), deserialization, or reflection.

Q3️⃣: Where is an object stored in memory?
A: In the Heap area.

Q4️⃣: What happens if constructor throws an exception?
A: Object creation fails and reference variable remains null.

===============================================================================
*/
