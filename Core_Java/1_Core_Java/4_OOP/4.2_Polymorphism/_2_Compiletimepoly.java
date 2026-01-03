/*
================================================================

📌 Definition:
Compile-time polymorphism in Java occurs when a method call is resolved during
the compilation phase. It is also known as:

✔ Method Overloading  
✔ Static Binding  
✔ Early Binding  

In this type, multiple methods share the **same method name but differ in:**
- Number of parameters
- Type of parameters
- Order of parameters

(NOTE: Return type alone CANNOT overload a method.)

===============================================================================
📌 WHY COMPILE-TIME POLYMORPHISM?
===============================================================================
✔ Improves readability (same name for similar operations)  
✔ Code reusability  
✔ Cleaner and modular design  
✔ Makes API design faster and intuitive  
✔ Used heavily in real-world frameworks (Spring, JDBC, Collections, etc.)

===============================================================================
📌 RULES OF METHOD OVERLOADING
===============================================================================

✔ Method name must be the SAME  
✔ Parameter list must be DIFFERENT:  
   - Number of parameters  
   - Type of parameters  
   - Order of parameters  

📌 Return type can be same OR different — but return type alone is NOT enough.

✔ Overloading can occur in:
   - Same class  
   - Child and parent class  

✔ Method overloading supports:
   - Access modifiers change
   - Return type change (if signature differs)
   - Static method overloading (allowed)

===============================================================================
📌 STATIC BINDING EXPLANATION
===============================================================================

👉 It is called **static binding** because the compiler decides which method 
to execute at **compile time**, not during runtime.

Example:
    obj.show(10);  -> Calls show(int)
    obj.show(10.5); -> Calls show(double)

No runtime decision is needed — the compiler already knows the method signature.


===============================================================================
📌 EXAMPLE — METHOD OVERLOADING
===============================================================================
*/

class MathOperations {

    // 1. Same method name, different parameters
    int add(int a, int b) {
        return a + b;
    }

    // 2. Different parameter type
    double add(double a, double b) {
        return a + b;
    }

    // 3. Different number of parameters
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // 4. Parameter order change (also valid overloading)
    double add(int a, double b) {
        return a + b;
    }

    // 5. Static method overloading (ALLOWED)
    static void display(int x) {
        System.out.println("Displaying int: " + x);
    }

    static void display(String s) {
        System.out.println("Displaying String: " + s);
    }
}

public class _2_Compiletimepoly {
    public static void main(String[] args) {

        MathOperations obj = new MathOperations();

        System.out.println(obj.add(2, 3));
        System.out.println(obj.add(2.5, 3.1));
        System.out.println(obj.add(1, 2, 3));
        System.out.println(obj.add(5, 2.75));

        MathOperations.display(10);
        MathOperations.display("Hello");
    }
}

/*
===============================================================================
📌 OUTPUT:
--------------------------------
5
5.6
6
7.75
Displaying int: 10
Displaying String: Hello
===============================================================================

===============================================================================
📌 KEY POINTS SUMMARY
===============================================================================

✔ Overloading → Compile-time polymorphism  
✔ Compiler decides method call based on signature  
✔ Return type alone cannot overload  
✔ Static methods CAN be overloaded  
✔ Private, final, and strictfp methods can be overloaded  
✔ Overloading can occur within same class or across inheritance

===============================================================================
📌 REAL-WORLD EXAMPLES
===============================================================================

✔ System.out.println() → overloaded for int, double, char, String, object  
✔ Constructors are overloaded in most frameworks  
✔ Collections API: `sort(List)`, `sort(List, Comparator)`  

===============================================================================
📌 ADVANTAGES
===============================================================================
✔ Readable and organized code  
✔ Reduces redundant names  
✔ Improves maintainability  
✔ Enables function flexibility  

===============================================================================
📌 DISADVANTAGES
===============================================================================
✖ Too many overloads may confuse beginners  
✖ Incorrect usage may lead to ambiguity with type promotion  

Example:
    add(5, 5.0f) → which version to call?

===============================================================================
📌 IMPORTANT INTERVIEW QUESTIONS
===============================================================================

1️⃣ What is compile-time polymorphism?
2️⃣ How is compile-time polymorphism achieved in Java?
3️⃣ What is method overloading?
4️⃣ Can method overloading happen by changing only return type?
5️⃣ Can static methods be overloaded?
6️⃣ Can constructors be overloaded?
7️⃣ What is type promotion in method overloading?
8️⃣ Difference between method overloading and overriding?
9️⃣ Why is method overloading called compile-time polymorphism?
🔟 Can private or final methods be overloaded?

-------------------------------------------------------------------------------

📌 BEST INTERVIEW ANSWERS (SHORT)

✔ "Compile-time polymorphism occurs when multiple methods with the same name exist but differ in parameters. The compiler determines which method to call, so it is also known as static binding."

✔ "Return type alone cannot overload a method; the signature must change."

✔ "Static, private, and final methods CAN be overloaded because overloading is resolved at compile time."

===============================================================================
📌 10-SECOND MEMORY TRICK
===============================================================================
"Same method name + different parameter list + decided by compiler = COMPILE-TIME POLYMORPHISM."

===============================================================================
END OF NOTES
===============================================================================
*/
