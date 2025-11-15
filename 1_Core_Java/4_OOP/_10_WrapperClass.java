// =====================================================================
// 🔹 _10_WrapperClass.java
// =====================================================================
// Full Guide to Wrapper Classes in Java
// Author: Shantanu Lanjewar
// =====================================================================

/*
===============================================================================
💡 WHAT ARE WRAPPER CLASSES?
===============================================================================
Wrapper classes in Java are object representations of primitive data types.
They wrap primitive values into objects so they can be used where objects are required.

Example:
int x = 5;           // primitive
Integer obj = 5;     // wrapper object

===============================================================================
💡 WHY DO WE NEED WRAPPER CLASSES? (IMPORTANT)
===============================================================================
✔ Collections and Generics (ArrayList, HashMap) do NOT support primitive types.
✔ Useful for converting String → number (parsing)
✔ Provide utility methods (compare, parse, valueOf, toString)
✔ Support autoboxing and unboxing (automatic conversion)
✔ Needed in frameworks, serialization, reflection, multithreading

===============================================================================
🔹 LIST OF PRIMITIVE TYPES & WRAPPER CLASSES
===============================================================================

| Primitive Type | Wrapper Class |
|----------------|---------------|
| byte           | Byte          |
| short          | Short         |
| int            | Integer       |
| long           | Long          |
| float          | Float         |
| double         | Double        |
| char           | Character     |
| boolean        | Boolean       |

Note: All wrapper classes are **immutable** like String (value cannot change).

===============================================================================
*/

// ==========================
// BASIC WRAPPER EXAMPLES
// ==========================
class BasicWrapperExample {
    void demonstrate() {
        int a = 10; // primitive

        // Boxing (manual)
        Integer obj1 = Integer.valueOf(a);

        // Autoboxing (automatic)
        Integer obj2 = a;

        // Unboxing (manual)
        int b = obj1.intValue();

        // Auto-unboxing (automatic)
        int c = obj2;

        System.out.println("Primitive = " + a);
        System.out.println("Wrapper (Boxing) = " + obj1);
        System.out.println("Wrapper (Autoboxing) = " + obj2);
        System.out.println("Unboxed Value = " + b + ", Auto-Unboxed Value = " + c);
    }
}


// ==========================
// REAL-LIFE USE CASE: COLLECTIONS
// ==========================
class CollectionExample {
    void demonstrate() {
        System.out.println("\n--- Using Wrapper Classes in Collections ---");
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        list.add(100); // Autoboxing → int → Integer
        int val = list.get(0); // Auto-unboxing → Integer → int
        System.out.println("Stored: " + list.get(0) + " | Retrieved: " + val);
    }
}


// ==========================
// PARSING STRINGS USING WRAPPER METHODS
// ==========================
class ParsingExample {
    void demonstrate() {
        System.out.println("\n--- Parsing Example ---");
        String str = "123";
        int number = Integer.parseInt(str);
        double decimal = Double.parseDouble("45.67");

        System.out.println("String to Integer = " + number);
        System.out.println("String to Double = " + decimal);
    }
}


// ==========================
// COMPARISON USING WRAPPER METHODS
// ==========================
class CompareExample {
    void demonstrate() {
        System.out.println("\n--- Comparison Example ---");
        Integer x = 100;
        Integer y = 100;

        System.out.println("Using == : " + (x == y));        // may compare memory
        System.out.println("Using equals() : " + x.equals(y)); // compares values
    }
}


// ==========================
// MAIN CLASS
// ==========================
public class _10_WrapperClass {
    public static void main(String[] args) {
        System.out.println("========== WRAPPER CLASS DEMO ==========\n");

        new BasicWrapperExample().demonstrate();
        new CollectionExample().demonstrate();
        new ParsingExample().demonstrate();
        new CompareExample().demonstrate();
    }
}


/*
===============================================================================
🔹 MEMORY DIFFERENCE (IMPORTANT)
===============================================================================

STACK MEMORY:
-------------
Stores primitives and references.

HEAP MEMORY:
------------
Stores wrapper objects and objects created using 'new' keyword.

Example:
Integer x = 10;   // stored in Heap
int y = 10;       // stored in Stack

===============================================================================
🔹 WRAPPER CLASS METHODS (Important for Interviews)
===============================================================================

| Method | Purpose | Example |
|--------|---------|---------|
| valueOf() | Converts primitive/String to wrapper object | Integer.valueOf(10) |
| intValue() | Converts wrapper to primitive | obj.intValue() |
| parseInt(), parseDouble() | Converts String to primitive | Integer.parseInt("10") |
| toString() | Returns String representation | obj.toString() |

===============================================================================
🔹 ADVANTAGES OF WRAPPER CLASSES
===============================================================================

✔ Used with Collections & Generics  
✔ Provide utility functions  
✔ Support autoboxing & unboxing  
✔ Useful in frameworks like Spring, Hibernate  
✔ Enables null usage (primitives cannot be null)

===============================================================================
🔹 DISADVANTAGES
===============================================================================

❌ Slower than primitives  
❌ More memory usage (heap allocation)  
❌ Can cause NullPointerException during unboxing

Example:
Integer x = null;
int y = x; // ❌ Runtime error

===============================================================================
🔹 MOST ASKED INTERVIEW QUESTIONS
===============================================================================

Q1️⃣: Why do we need wrapper classes?
👉 Because collections and frameworks require objects, not primitives.

------------------------------------

Q2️⃣: Are wrapper classes immutable?
👉 Yes, once created their value cannot change.

------------------------------------

Q3️⃣: Difference between int and Integer?
👉 int → primitive, stored in stack, faster  
👉 Integer → object, stored in heap, slower  

------------------------------------

Q4️⃣: What is autoboxing?
👉 Automatic conversion primitive → wrapper.

------------------------------------

Q5️⃣: What is auto-unboxing?
👉 Automatic conversion wrapper → primitive.

------------------------------------

Q6️⃣: Can autoboxing cause errors?
👉 Yes, auto-unboxing null → NullPointerException.

------------------------------------

Q7️⃣: Which comparison should be used?
👉 Use `.equals()` for comparing wrapper values, not `==`.

------------------------------------

Q8️⃣: Can wrapper classes store null values?
👉 Yes, unlike primitives → useful in database mapping.

===============================================================================
🔹 TRICKY INTERVIEW QUESTIONS
===============================================================================

⭐ Q1: What is Integer Caching?
Java caches values from **-128 to 127** for performance.

Example:
Integer x = 100;
Integer y = 100;
(x == y) → true  ✔

Integer a = 200;
Integer b = 200;
(a == b) → false ❌   (Different objects)

------------------------------------

⭐ Q2: Why caching works only between -128 to 127?
👉 Most-used integer range → memory optimization reason.

------------------------------------

⭐ Q3: Why is parseInt() faster than valueOf()?
👉 parseInt() returns primitive, valueOf() creates an object.

===============================================================================
🔹 SHORT SPEAKING SUMMARY (For Interview)
===============================================================================

“Wrapper classes convert primitive data types to object form. They are needed 
because Collections and Generics do not work with primitives. With autoboxing 
and auto-unboxing introduced in Java 5, conversions happen automatically. 
Wrapper classes also provide utility methods such as parsing, comparing, and 
converting data. However, they consume more memory and may throw 
NullPointerException during unboxing.”

===============================================================================
*/
