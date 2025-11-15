/*
===============================================================================
💡 WHY THIS TOPIC EXISTS?
===============================================================================
Before Java 5, primitive values could NOT be stored in collections like ArrayList,
because collections only store Objects, not primitive types.

So Java introduced:
✔ Boxing (manual conversion from primitive → wrapper)
✔ Unboxing (manual conversion from wrapper → primitive)

Later in Java 5, compiler improvement introduced:
✔ Autoboxing (automatic primitive → wrapper)
✔ Auto-unboxing (automatic wrapper → primitive)

===============================================================================
💡 WHAT ARE WRAPPER CLASSES?
===============================================================================
Wrapper classes are object representations of primitive types.

| Primitive | Wrapper Class |
|-----------|---------------|
| int       | Integer       |
| byte      | Byte          |
| short     | Short         |
| long      | Long          |
| float     | Float         |
| double    | Double        |
| char      | Character     |
| boolean   | Boolean       |

These wrapper classes allow primitives to be used where objects are required.

===============================================================================
💡 MEMORY UNDERSTANDING
===============================================================================
✔ Primitive values → Stored in **Stack**
✔ Wrapper objects → Stored in **Heap**

Autoboxing = Stack → Heap  
Auto-unboxing = Heap → Stack

===============================================================================
*/

// ============================
// 1️⃣ BOXING (Manual Conversion: Primitive → Wrapper)
// ============================

class BoxingDemo {

    void boxingExample() {
        int num = 10;

        Integer obj1 = new Integer(num);        // Old manual method (pre-Java 5)
        Integer obj2 = Integer.valueOf(num);    // Recommended manual method

        System.out.println("Boxing:");
        System.out.println("Primitive: " + num);
        System.out.println("Wrapper Objects: " + obj1 + ", " + obj2);
    }
}


// ============================
// 2️⃣ UNBOXING (Manual Conversion: Wrapper → Primitive)
// ============================

class UnboxingDemo {

    void unboxingExample() {
        Integer value = new Integer(20);

        int num = value.intValue(); // Manual unboxing

        System.out.println("\nUnboxing:");
        System.out.println("Wrapper: " + value);
        System.out.println("Primitive: " + num);
    }
}


// ============================
// 3️⃣ AUTOBOXING (Automatic Primitive → Wrapper)
// ============================

class AutoBoxingDemo {

    void autoBoxingExample() {
        int num = 30;

        Integer obj = num; // Compiler automatically converts

        System.out.println("\nAutoboxing:");
        System.out.println("Primitive: " + num);
        System.out.println("Wrapper: " + obj);
    }
}


// ============================
// 4️⃣ AUTO-UNBOXING (Automatic Wrapper → Primitive)
// ============================

class AutoUnboxingDemo {

    void autoUnboxingExample() {
        Integer value = 40; // Autoboxing already done here

        int num = value; // Auto-unboxing happens

        System.out.println("\nAuto-unboxing:");
        System.out.println("Wrapper: " + value);
        System.out.println("Primitive: " + num);
    }
}


// ============================
// REAL-WORLD USE CASE (Collections)
// ============================

class CollectionDemo {

    void usingCollections() {
        System.out.println("\nAutoboxing & Auto-unboxing in Collections:");

        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();

        list.add(50); // Autoboxing -> int becomes Integer
        int retrieved = list.get(0); // Auto-unboxing -> Integer becomes int

        System.out.println("Stored (Wrapper): " + list.get(0));
        System.out.println("Retrieved (Primitive): " + retrieved);
    }
}


// ============================
// MAIN CLASS
// ============================

public class _9_Boxing_Unboxing {
    public static void main(String[] args) {

        new BoxingDemo().boxingExample();
        new UnboxingDemo().unboxingExample();
        new AutoBoxingDemo().autoBoxingExample();
        new AutoUnboxingDemo().autoUnboxingExample();
        new CollectionDemo().usingCollections();
    }
}


/*
===============================================================================
🔹 OUTPUT (For Reference)
===============================================================================
Boxing:
Primitive: 10
Wrapper Objects: 10, 10

Unboxing:
Wrapper: 20
Primitive: 20

Autoboxing:
Primitive: 30
Wrapper: 30

Auto-unboxing:
Wrapper: 40
Primitive: 40

Autoboxing & Auto-unboxing in Collections:
Stored (Wrapper): 50
Retrieved (Primitive): 50

===============================================================================
🔹 IMPORTANT RULES
===============================================================================
✔ Wrapper classes are immutable.
✔ Autoboxing happens when assigning primitive to Wrapper.
✔ Auto-unboxing happens when using Wrapper where primitive is expected.
✔ Null Wrapper value during auto-unboxing → NullPointerException.

Example:
Integer x = null;
int y = x;  // ❌ Runtime Error: NullPointerException

===============================================================================
🔹 INTERVIEW QUESTIONS & ANSWERS
===============================================================================

Q1: What is the difference between boxing and autoboxing?
👉 Boxing is manual conversion, autoboxing is automatic conversion.

Q2: Why were wrapper classes introduced?
👉 To allow primitives to be used where Objects are required (Collections, Generics).

Q3: Can autoboxing cause performance impact?
👉 Yes, wrapper creation is slower and consumes more memory than primitives.

Q4: What is the biggest risk of auto-unboxing?
👉 NullPointerException when wrapper object is null.

Q5: Are wrapper classes immutable?
👉 Yes, values cannot be changed once created.

Q6: Can we compare primitive and wrapper using "=="?
👉 Yes, but only after auto-unboxing happens. Better use `.equals()`.
ex: Integer a = 1000; Integer b = 1000; a == b // false, use a.equals(b)
explanation in detail of above example:
When you create two Integer objects with the value 1000 using autoboxing, like this:
Integer a = 1000;
Integer b = 1000;
Each of these lines creates a new Integer object in memory because 1000 is outside the range of -128 to 127, which is the range that Java caches for Integer objects. Therefore, 'a' and 'b' refer to two different objects in memory.
When you use the '==' operator to compare 'a' and 'b', it checks for reference equality, meaning it checks whether both references point to the same object in memory. Since 'a' and 'b' are two distinct objects, the comparison returns false.
However, if you use the .equals() method, it checks for value equality, meaning it compares the actual integer values contained within the Integer objects. Since both 'a' and 'b' contain the same value (1000), a.equals(b) returns true.


===============================================================================
🔹 INTERVIEW SUMMARY (Speak Like This)
===============================================================================

“Boxing and Unboxing are manual conversions between primitive types and their 
wrapper classes. From Java 5 onward, the compiler automatically performs this 
conversion, known as Autoboxing and Auto-unboxing. Wrapper classes allow 
primitives to be stored inside collections and used like objects. This improves 
code readability but may cause performance impact and NullPointerException in 
case of auto-unboxing of null values.”

===============================================================================
*/
