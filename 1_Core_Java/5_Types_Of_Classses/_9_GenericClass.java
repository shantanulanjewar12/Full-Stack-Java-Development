// ============================================================
// 🔹 _9_GenericClass.java
// ============================================================
// Topic: Generic Class in Java
// Author: Shantanu Lanjewar
// ============================================================

/*
===============================================================================
💡 WHAT ARE GENERICS IN JAVA?
===============================================================================
Generics allow classes, interfaces, and methods to work with **different data
types** while ensuring **compile-time type safety**.

Example:
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();

We can write one class/method that works for ALL data types.

===============================================================================
💡 WHY DO WE NEED GENERICS?
===============================================================================
✔ Compile-time type safety  
✔ Avoids ClassCastException  
✔ Code reusability  
✔ Cleaner, readable code  
✔ No need for multiple overloaded classes  

Example without generics:
    List list = new ArrayList();
    list.add("Hello");
    list.add(10);   // ❌ runtime error risk

With generics:
    List<String> list = new ArrayList<>();
    list.add(10);   // ❌ compile-time error → safer

===============================================================================
🔹 GENERIC CLASS SYNTAX
===============================================================================

class ClassName<T> {
    T variable;
    T method(T value) { }
}

T = Type Parameter (can be any object type)

Common names:
T → Type  
E → Element  
K → Key  
V → Value  
N → Number  

===============================================================================
🔹 EXAMPLE 1 — SIMPLE GENERIC CLASS
===============================================================================
*/

class Box<T> {   // Generic class

    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

/*
===============================================================================
🔹 EXAMPLE 2 — GENERIC CLASS WITH TWO TYPE PARAMETERS
===============================================================================
*/

class Pair<K, V> {

    private K key;
    private V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    void show() {
        System.out.println("Key = " + key + ", Value = " + value);
    }
}

/*
===============================================================================
🔹 GENERIC METHODS
===============================================================================
*/

class GenericMethodDemo {

    // General generic method
    public <T> void print(T data) {
        System.out.println("Data: " + data);
    }

    // Generic method returning type
    public <T> T get(T data) {
        return data;
    }
}

/*
===============================================================================
🔹 BOUNDED GENERICS (Upper Bound)
    <? extends Number> → Only Number or its subclasses allowed
===============================================================================
*/

class UpperBoundDemo<T extends Number> {

    T value;

    UpperBoundDemo(T value) {
        this.value = value;
    }

    void showValue() {
        System.out.println("Number Value = " + value);
    }
}

/*
===============================================================================
🔹 LOWER BOUND GENERICS
    <? super Integer> → Integer or ANY of its superclasses allowed
===============================================================================
*/

class LowerBoundDemo {

    public void printList(java.util.List<? super Integer> list) {
        list.add(10);  // allowed
        System.out.println(list);
    }
}

/*
===============================================================================
🔹 WILDCARDS
===============================================================================
? → unknown type  
? extends X → upper bounded  
? super X → lower bounded  

Used mostly in collections.

===============================================================================
🔹 RAW TYPE (Not recommended)
===============================================================================
*/

class RawTypeDemo<T> {

    T value;
}

/*
===============================================================================
🔹 MAIN CLASS – DEMONSTRATION
===============================================================================
*/

public class _9_GenericClass {
    public static void main(String[] args) {

        System.out.println("===== Simple Generic Class =====");
        Box<String> box1 = new Box<>("Hello");
        Box<Integer> box2 = new Box<>(123);

        System.out.println(box1.getValue());
        System.out.println(box2.getValue());

        System.out.println("\n===== Generic Class with Two Types =====");
        Pair<String, Integer> pair = new Pair<>("Age", 25);
        pair.show();

        System.out.println("\n===== Generic Method =====");
        GenericMethodDemo gm = new GenericMethodDemo();
        gm.print("Test");
        gm.print(100);

        System.out.println("\n===== Upper Bounded Generic =====");
        UpperBoundDemo<Double> ub = new UpperBoundDemo<>(3.14);
        ub.showValue();

        System.out.println("\n===== Lower Bounded Generic =====");
        java.util.List<Object> list = new java.util.ArrayList<>();
        LowerBoundDemo lbd = new LowerBoundDemo();
        lbd.printList(list);

        System.out.println("\n===== Raw Type Example =====");
        RawTypeDemo raw = new RawTypeDemo(); // Allowed but NOT recommended
        raw.value = "String";                 // Unsafe
        raw.value = 10;                       // More unsafe
        System.out.println("Raw type value: " + raw.value);
    }
}

/*
===============================================================================
🔹 ADVANTAGES OF GENERICS
===============================================================================
✔ Type safety → compile-time checking  
✔ Eliminates ClassCastException  
✔ Code becomes reusable  
✔ Compatible with Collections Framework  
✔ Improves readability  

===============================================================================
🔹 LIMITATIONS OF GENERICS
===============================================================================
❌ Cannot use primitive types → must use wrapper classes  
❌ Cannot create generic arrays (new T[])  
❌ No runtime type information (type erasure)  
❌ Cannot instantiate type parameter (new T())  
❌ Cannot use instanceof with generic types  

===============================================================================
🔹 REAL WORLD USE CASES
===============================================================================
✔ Collection Framework (List<T>, Map<K,V>, Set<T>)  
✔ DAO layers in projects  
✔ Returning API responses (Response<T>)  
✔ Utility classes  
✔ Comparing, sorting (Comparator<T>)  

===============================================================================
🔹 IMPORTANT INTERVIEW QUESTIONS
===============================================================================

Q1️⃣ What are generics?  
👉 A feature allowing classes/methods to work with different data types safely.

------------------------------------

Q2️⃣ Why can't we use primitives with generics?  
👉 Because generics work with objects and due to type erasure.

------------------------------------

Q3️⃣ What is type erasure?  
👉 JVM removes generic type info at runtime → replaced with Object.

------------------------------------

Q4️⃣ What is a bounded type?  
👉 Restricting type parameter using extends/super.

------------------------------------

Q5️⃣ Difference: <? extends T> vs <? super T>?  
👉 extends → Upper bound (T and subclasses)  
👉 super → Lower bound (T and superclasses)  

------------------------------------

Q6️⃣ Can a generic class be final or abstract?  
👉 ✔ Yes.

------------------------------------

Q7️⃣ Can constructors be generic?  
👉 ✔ Yes:
       <T> MyClass(T value) { ... }

------------------------------------

Q8️⃣ Can static methods use generic type parameter T of class?  
👉 ❌ No, they must have their own <T>.

------------------------------------

Q9️⃣ What is a raw type?  
👉 Using generics class without specifying type:
       Box box = new Box();

------------------------------------

Q🔟 Can we overload generic methods?  
👉 ✔ Yes.

===============================================================================
🔹 TRICKY QUESTIONS
===============================================================================

⭐ Q1: Why can't we do new T()?  
👉 Because Java erases generic type at runtime.

⭐ Q2: Why can't we create arrays of generics?  
👉 Because arrays enforce type at runtime, generics at compile time.

⭐ Q3: Can generic methods have more than one type?  
👉 ✔ Yes:
       <K,V> void print(K k, V v)

⭐ Q4: Can two generic classes with different T be considered same at runtime?  
👉 ✔ Yes, due to type erasure:
       Box<String> and Box<Integer> → both become Box<Object>

⭐ Q5: What is diamond operator <> ?  
👉 Helps infer type from left side:
       List<String> list = new ArrayList<>();

===============================================================================
🔹 SPOKEN SUMMARY (FOR INTERVIEW)
===============================================================================

“Generics allow us to write type-safe and reusable code. A generic class or
method works with any data type while ensuring compile-time safety. Java removes
generic information at runtime using type erasure. We can use bounded generics,
wildcards (*extends* and *super*), and multiple type parameters. Generics are
mainly used in collections, frameworks, and reusable utility classes.”

===============================================================================
*/
