// ===============================
// 1️⃣ Using 'this' to access instance variables
// ===============================
class ExampleThisVariable {

    int a;  // instance variable

    ExampleThisVariable(int a) {
        this.a = a; // 'this' differentiates instance variable from parameter
    }

    void show() {
        System.out.println("Value of a = " + a);
    }
}


// ===============================
// 2️⃣ Using 'this()' → Calling another constructor (Constructor Chaining)
// ===============================
class ExampleThisConstructor {

    ExampleThisConstructor() {
        System.out.println("Default Constructor");
    }

    ExampleThisConstructor(int x) {
        this();  // calling default constructor
        System.out.println("Parameterized Constructor: " + x);
    }
}


// ===============================
// 3️⃣ Using 'super' keyword to access parent variables/methods
// ===============================
class Parent {
    int n = 100;

    void msg() {
        System.out.println("Message from Parent Class");
    }
}

class Child extends Parent {

    int n = 200;

    void display() {
        System.out.println("Using this.n  → " + this.n);   // child variable
        System.out.println("Using super.n → " + super.n);  // parent variable
    }

    void callMethod() {
        super.msg();  // calling parent method
    }
}


// ===============================
// 4️⃣ Using super() to call parent constructor
// ===============================
class ParentConstructor {

    ParentConstructor() {
        System.out.println("Parent Constructor Called");
    }
}

class ChildConstructor extends ParentConstructor {

    ChildConstructor() {
        super(); // automatically called even if not written
        System.out.println("Child Constructor Called");
    }
}


// ===============================
// MAIN CLASS
// ===============================
public class _8_this_super_keyword_in_constructor_Simplified {

    public static void main(String[] args) {

        System.out.println("=== this (instance variable) Example ===");
        ExampleThisVariable obj1 = new ExampleThisVariable(25);
        obj1.show();

        System.out.println("\n=== this() constructor chaining Example ===");
        ExampleThisConstructor obj2 = new ExampleThisConstructor(10);

        System.out.println("\n=== this vs super variable Example ===");
        Child c = new Child();
        c.display();

        System.out.println("\n=== super() constructor Example ===");
        ChildConstructor cc = new ChildConstructor();

        System.out.println("\n=== Calling Parent Method using super ===");
        c.callMethod();
    }
}
