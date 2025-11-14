/*
===============================================================================
💡 WHAT IS A CONSTRUCTOR?
===============================================================================
A constructor is a special method that initializes an object when it is created.

Example:
ClassName obj = new ClassName();

Here, the constructor is automatically executed.

===============================================================================
💡 WHAT IS 'this' IN JAVA?
===============================================================================
👉 'this' is a reference variable that always refers to the **current object**.

===============================================================================
🔹 USES OF 'this' KEYWORD
===============================================================================
1️⃣ Referring to current class instance variables  
2️⃣ Calling current class methods  
3️⃣ Calling another constructor of same class → `this()`  
4️⃣ Returning current object  
5️⃣ Passing current object as argument

===============================================================================
💡 WHAT IS 'super' IN JAVA?
===============================================================================
👉 'super' refers to the **parent (superclass) object**.

===============================================================================
🔹 USES OF 'super' KEYWORD
===============================================================================
1️⃣ Access parent class variable  
2️⃣ Access parent class method  
3️⃣ Call parent class constructor → `super()`

===============================================================================
💡 WHY USE this() AND super() IN CONSTRUCTORS?
===============================================================================
✔ To avoid duplicate code  
✔ To maintain initialization consistency  
✔ To enable constructor chaining  
✔ To support inheritance properly

===============================================================================
🔹 RULES FOR this() AND super()
===============================================================================
✔ Must be the FIRST line inside a constructor  
✔ Only ONE of them can be used at a time  
✔ JVM automatically calls super() if not explicitly written  
✔ Used only in constructors (not normal methods)

===============================================================================
*/

// ===============================
// EXAMPLE: this() Constructor Chaining
// ===============================
class Student {

    String name;
    int age;
    String course;

    Student() {
        this("Unknown", 18); // calling another constructor
        System.out.println("No-Argument Constructor Executed");
    }

    Student(String name, int age) {
        this(name, age, "Java"); // calling 3-argument constructor
        System.out.println("Two-Argument Constructor Executed");
    }

    Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
        System.out.println("Three-Argument Constructor Executed");
    }

    void display() {
        System.out.println("Name: " + name + " | Age: " + age + " | Course: " + course);
    }
}


// ===============================
// EXAMPLE: super() Constructor Chaining (Inheritance Based)
// ===============================

class Person {

    Person() {
        System.out.println("Parent Constructor (Person) Called");
    }

    Person(String msg) {
        System.out.println("Parent Parameterized Constructor: " + msg);
    }
}

class Employee extends Person {

    Employee() {
        super("From Child Constructor"); // calling parent parameterized constructor
        System.out.println("Child Constructor (Employee) Called");
    }
}


// ===============================
// this vs super variable reference example
// ===============================
class Parent {
    int x = 100;
}

class Child extends Parent {
    int x = 200;

    void show() {
        System.out.println("Using this → " + this.x);   // child's x
        System.out.println("Using super → " + super.x); // parent's x
    }
}



// ===============================
// MAIN CLASS
// ===============================
public class _8_this_super_keyword_in_constructor {
    public static void main(String[] args) {
        
        System.out.println("===== this() Constructor Chaining Demo =====");
        Student s = new Student();
        s.display();

        System.out.println("\n===== super() Constructor Chaining Demo =====");
        Employee e = new Employee();

        System.out.println("\n===== this vs super Variable Access =====");
        Child c = new Child();
        c.show();
    }
}



/*
===============================================================================
🔹 MEMORY FLOW OF CONSTRUCTOR CALLING
===============================================================================

Case 1: Using this()
Student() 
   ➤ calls → Student(String,int)
       ➤ calls → Student(String,int,String)
           ➤ executes body

Execution Order:
Three-Argument → Two-Argument → No-Argument

------------------------------------

Case 2: Using super()
Employee()
   ➤ calls → Parent constructor
       ➤ then child constructor runs

Execution Order:
Parent → Child

===============================================================================
🔹 ADVANTAGES OF this() AND super()
===============================================================================

✔ Improves code readability  
✔ Avoids duplication  
✔ Supports Inheritance  
✔ Ensures proper initialization order  
✔ Helps constructor chaining  

===============================================================================
🔹 INTERVIEW QUESTIONS (WITH SHORT ANSWERS)
===============================================================================

Q1: What is difference between this and super?
👉 this → refers to current object  
👉 super → refers to parent object  

------------------------------------

Q2: What is difference between this() and this?
👉 this → object reference  
👉 this() → calls constructor of same class  

------------------------------------

Q3: Why must this() or super() be first line in constructor?
👉 Because JVM must decide constructor execution order before other statements.

------------------------------------

Q4: Can we use both super() and this() in same constructor?
❌ No, because both must be the FIRST line.

------------------------------------

Q5: Does Java automatically call super()?
✔ Yes, if not explicitly written.

------------------------------------

Q6: Can we call a constructor from normal method?
❌ No, only constructors can call other constructors.

------------------------------------

Q7: Can super() call grandparent constructor?
❌ No, only immediate parent.

------------------------------------

Q8: Can we use this in static methods?
❌ No, static belongs to class, not object.

------------------------------------

Q9: Can a private constructor be called using super()?
❌ No, private constructor cannot be accessed by child class.

===============================================================================
🔹 TRICKY INTERVIEW QUESTIONS
===============================================================================

⭐ Q1: Will this() cause recursion?
👉 Yes, if constructor calls itself → infinite recursion → runtime error.

------------------------------------

⭐ Q2: What executes first: instance block or super() constructor?
👉 Instance block executes **after** super() but before current constructor body.

------------------------------------

⭐ Q3: If parent has only parameterized constructor, what must child do?
👉 Child **must explicitly call** super(arguments) → or compilation fails.

===============================================================================
🔹 INTERVIEW SUMMARY (Speak Like This)
===============================================================================

“`this` refers to the current object, and `super` refers to the parent object.  
`this()` is used for constructor chaining within the same class, while `super()` 
is used to call the parent class constructor. Both must be the first statement 
in a constructor. They help avoid duplicate code and maintain proper 
initialization order in inheritance.”

===============================================================================
*/
