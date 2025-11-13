/*
===============================================================================
💡 WHAT IS A CONSTRUCTOR?
===============================================================================

👉 Definition:
A Constructor in Java is a special method that is automatically called 
when an object of a class is created. It initializes the object.

👉 Syntax:
class ClassName {
    ClassName() {
        // constructor body
    }
}

👉 Example:
Student s1 = new Student();   // Constructor is called here

===============================================================================
🔹 KEY FEATURES OF CONSTRUCTOR
===============================================================================
1️⃣ Same name as the class name.
2️⃣ No return type (not even void).
3️⃣ Automatically invoked when an object is created.
4️⃣ Used for initializing variables or allocating resources.
5️⃣ Can be **overloaded** (multiple constructors in the same class).
6️⃣ Cannot be **inherited**, but can call parent’s constructor using `super()`.
7️⃣ Can be **default**, **parameterized**, or **copy** constructor.

===============================================================================
🔹 WHY USE CONSTRUCTOR?
===============================================================================
✅ To initialize object state automatically.
✅ To enforce object creation rules.
✅ To reduce redundant setter calls after object creation.

===============================================================================
🔹 TYPES OF CONSTRUCTORS IN JAVA
===============================================================================

1️⃣ **Default Constructor** (No-Argument Constructor)
   - Automatically provided by Java if no constructor is defined.
   - Initializes default values (0, null, false).
    - Created automatically by Java **if no constructor is written** in the class.
   - Initializes all instance variables to their default values:
     → int → 0  
     → boolean → false  
     → Object/String → null
   - Example:
        class Demo { }
        // Compiler automatically provides:
        // Demo() { }

    2️⃣ **User-Defined No-Argument Constructor**
   - A constructor you explicitly write with no parameters.
   - Used to set custom default values or print initialization messages.
   - Example:
        Demo() {
            System.out.println("No-Argument Constructor Called");
        }

3 **Parameterized Constructor**
   - Takes arguments to initialize specific values.


4 **Copy Constructor** (User-defined)
   - Creates a new object by copying another object's data manually.

===============================================================================
🔹 CONSTRUCTOR OVERLOADING
===============================================================================
👉 Having multiple constructors with different parameter lists.
👉 Helps create objects in different ways (flexibility).
Example:
    Student() {}
    Student(String name) {}
    Student(String name, int age) {}

===============================================================================
🔹 DIFFERENCE BETWEEN CONSTRUCTOR AND METHOD
===============================================================================
| Feature            | Constructor                        | Method                          |
|--------------------|-------------------------------------|----------------------------------|
| Name               | Same as class name                  | Any valid name                   |
| Return Type        | No return type                      | Must have a return type          |
| Invocation         | Called automatically                | Called explicitly                |
| Purpose            | Initialize object                   | Perform operations on objects    |

===============================================================================
*/

class Student {
    String name;
    int age;

    // 1️⃣ user-defined no-argument constructor.
    Student() {
        System.out.println("Default Constructor Called");
        name = "Unknown";
        age = 18;
    }

    // 2️⃣ Parameterized Constructor
    Student(String n, int a) {
        System.out.println("Parameterized Constructor Called");
        name = n;
        age = a;
    }

    // 3️⃣ Copy Constructor (user-defined)
    Student(Student other) {
        System.out.println("Copy Constructor Called");
        name = other.name;
        age = other.age;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class _3_Constructor {
    public static void main(String[] args) {

        System.out.println("====== Constructor Demonstration ======");

        // 🔹 1. Default Constructor
        Student s1 = new Student(); // calls Student()
        s1.display();

        // 🔹 2. Parameterized Constructor
        Student s2 = new Student("Shantanu", 22); // calls Student(String, int)
        s2.display();

        // 🔹 3. Copy Constructor
        Student s3 = new Student(s2); // calls Student(Student)
        s3.display();

        System.out.println("====== Constructor Overloading Example ======");
        // Overloading shown by multiple constructors with different arguments
        Student s4 = new Student("Ravi", 20);
        s4.display();
    }
}

/*
 * =============================================================================
 * ==
 * 🔹 INTERVIEW SUMMARY (SPEAKING POINTS)
 * =============================================================================
 * ==
 * 
 * 👉 1. A constructor is a special method used to initialize an object.
 * 👉 2. It has the same name as the class and no return type.
 * 👉 3. It is called automatically when an object is created.
 * 👉 4. If we don’t define one, Java provides a default constructor.
 * 👉 5. Constructors can be overloaded but not overridden.
 * 👉 6. `this()` is used to call another constructor in the same class.
 * 👉 7. `super()` is used to call the parent class constructor.
 * 👉 8. Types: Default, Parameterized, Copy Constructor.
 * 👉 9. Constructor Overloading provides flexibility in object initialization.
 * 
 * =============================================================================
 * ==
 * 🔹 QUICK CODE SUMMARY:
 * =============================================================================
 * ==
 * Student() → Default
 * Student(String, int) → Parameterized
 * Student(Student) → Copy
 * Overloading → Multiple constructors with different parameters.
 * 
 * 
 * Q: What happens if I define a parameterized constructor but not a default one?
A: Then Java will NOT provide a default constructor automatically.
   You must define a no-arg constructor manually if you need it.

 * 
 * 
 * =============================================================================
 * ==
 */


