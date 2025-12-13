// ============================================================
// 🔹 _12_SingletonClass.java
// ============================================================
// Topic: Singleton Design Pattern in Java
// Author: Shantanu Lanjewar
// ============================================================

/*
===============================================================================
💡 WHAT IS A SINGLETON CLASS?
===============================================================================
A Singleton class allows **only ONE and ONLY ONE object** to be created
throughout the application.

Use Cases:
✔ Database connection  
✔ Logger  
✔ Cache  
✔ Thread pool  
✔ Configuration manager  
✔ Driver manager  

Goal:  
👉 Ensure only ONE instance exists globally, and provide a global access point.

===============================================================================
🔹 RULES TO MAKE A SINGLETON CLASS
===============================================================================
1️⃣ Private constructor (no one can create object outside)  
2️⃣ Private static instance of the class  
3️⃣ Public static method to return the same instance  
4️⃣ Thread-safe implementation (optional but recommended)

===============================================================================
🔹 DIFFERENT WAYS TO CREATE SINGLETON CLASS
===============================================================================
1. Eager Initialization  
2. Lazy Initialization  
3. Synchronized Method  
4. Synchronized Block  
5. Double-Checked Locking (volatile needed)  
6. Bill Pugh Solution  
7. Enum Singleton (Best recommended)  
===============================================================================
*/


// ============================================================================
// 1️⃣ **EAGER INITIALIZATION SINGLETON**
// ============================================================================

class EagerSingleton {

    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() { }

    public static EagerSingleton getInstance() {
        return instance;
    }
}

/*
Pros:
✔ Simple & thread-safe  
✔ No synchronization cost  

Cons:
❌ Instance created even if not used (memory waste)
*/




// ============================================================================
// 2️⃣ **LAZY INITIALIZATION SINGLETON** (Not thread-safe)
// ============================================================================

class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() { }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton(); // created only when needed
        }
        return instance;
    }
}

/*
Pros:
✔ Object created ONLY when needed

Cons:
❌ Not thread-safe → may create multiple objects
*/





// ============================================================================
// 3️⃣ **SYNCHRONIZED METHOD SINGLETON** (Thread-safe but slow)
// ============================================================================

class SyncMethodSingleton {

    private static SyncMethodSingleton instance;

    private SyncMethodSingleton() { }

    public static synchronized SyncMethodSingleton getInstance() {
        if (instance == null) {
            instance = new SyncMethodSingleton();
        }
        return instance;
    }
}

/*
Pros:
✔ Thread-safe

Cons:
❌ Slow because entire method is synchronized
*/





// ============================================================================
// 4️⃣ **SYNCHRONIZED BLOCK SINGLETON** (Better performance)
// ============================================================================

class SyncBlockSingleton {

    private static SyncBlockSingleton instance;

    private SyncBlockSingleton() { }

    public static SyncBlockSingleton getInstance() {

        if (instance == null) {          // First check (not synchronized)
            synchronized (SyncBlockSingleton.class) {
                instance = new SyncBlockSingleton();
            }
        }
        return instance;
    }
}

/*
Cons:
❌ Still not fully safe → possible double initialization under heavy threads.
*/





// ============================================================================
// 5️⃣ **DOUBLE-CHECK LOCKING SINGLETON WITH VOLATILE** (Best thread-safe version)
// ============================================================================

class DoubleCheckSingleton {

    // volatile → solves memory consistency issues
    private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton() { }

    public static DoubleCheckSingleton getInstance() {

        if (instance == null) {                    // First check
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {            // Second check
                    instance = new DoubleCheckSingleton();
                }
            }
        }

        return instance;
    }
}

/*
Pros:
✔ Fast  
✔ Thread-safe  
✔ Prevents memory inconsistency (volatile)

Cons:
❌ Slightly complex
*/





// ============================================================================
// 6️⃣ **BILL PUGH SINGLETON (Best Practice in Java)** 
// ============================================================================

class BillPughSingleton {

    private BillPughSingleton() { }

    // static inner class → loaded only when required
    private static class Helper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return Helper.INSTANCE;
    }
}

/*
Pros:
✔ Most efficient
✔ Thread-safe
✔ No synchronization required
✔ Lazy initialization
*/





// ============================================================================
// 7️⃣ **ENUM SINGLETON (MOST RECOMMENDED WAY)**
// ============================================================================

enum EnumSingleton {

    INSTANCE;

    public void show() {
        System.out.println("Enum Singleton Method Called");
    }
}

/*
Pros:
✔ Easiest  
✔ Thread-safe  
✔ Serialization-safe  
✔ Reflection-safe  

Cons:
❌ Cannot lazy load  
❌ Enum cannot extend other classes  
*/





// ============================================================================
// 🔸 MAIN — DEMONSTRATION
// ============================================================================

public class _12_SingletonClass {
    public static void main(String[] args) {

        System.out.println("===== Eager Singleton =====");
        System.out.println(EagerSingleton.getInstance());

        System.out.println("===== Lazy Singleton =====");
        System.out.println(LazySingleton.getInstance());

        System.out.println("===== Sync Method Singleton =====");
        System.out.println(SyncMethodSingleton.getInstance());

        System.out.println("===== Sync Block Singleton =====");
        System.out.println(SyncBlockSingleton.getInstance());

        System.out.println("===== Double Check Lock Singleton =====");
        System.out.println(DoubleCheckSingleton.getInstance());

        System.out.println("===== Bill Pugh Singleton =====");
        System.out.println(BillPughSingleton.getInstance());

        System.out.println("===== Enum Singleton =====");
        EnumSingleton.INSTANCE.show();
    }
}

/*
===============================================================================
🔹 ADVANTAGES OF SINGLETON
===============================================================================
✔ Saves memory  
✔ Global access point  
✔ Prevents multiple object creation  
✔ Used in frameworks, DB, config handling  

===============================================================================
🔹 LIMITATIONS OF SINGLETON
===============================================================================
❌ Difficult to unit test  
❌ Leads to tight coupling  
❌ Cannot be extended easily  
❌ Memory retained until JVM dies  

===============================================================================
🔹 IMPORTANT INTERVIEW QUESTIONS
===============================================================================

Q1️⃣ What is a Singleton class?
👉 A class that allows only one object.

------------------------------------

Q2️⃣ Why use private constructor?
👉 To prevent external instantiation.

------------------------------------

Q3️⃣ What is volatile keyword used for?
👉 Prevents memory inconsistency in double-check locking.

------------------------------------

Q4️⃣ Which Singleton method is best?
👉 Bill Pugh / Enum Singleton.

------------------------------------

Q5️⃣ Why Enum Singleton is best?
👉 Provides:
✔ Thread safety  
✔ Reflection safety  
✔ Serialization safety  
✔ Single instance guaranteed  

------------------------------------

Q6️⃣ Can Singleton be broken?
👉 ✔ Yes by Reflection or Serialization  
✔ Except ENUM → Cannot be broken  

------------------------------------

Q7️⃣ What is the problem in lazy initialization?
👉 Not thread-safe.

------------------------------------

Q8️⃣ Why double-check locking is needed?
👉 To avoid expensive synchronization after first creation.

===============================================================================
🔹 TRICKY QUESTIONS
===============================================================================

⭐ Q1: Can Singleton class be cloned?  
👉 ❌ No, override clone() and throw exception.

⭐ Q2: Can Singleton be mutable?  
👉 ✔ Yes, but not recommended.

⭐ Q3: How to break Singleton?  
👉 Reflection, Serialization, Cloning.

⭐ Q4: How to prevent breaking?  
👉 Use Enum Singleton or defensive code.

================================================================================
🔹 SPOKEN SUMMARY (INTERVIEW ANSWER)
================================================================================
“A Singleton class ensures that only one object exists in the JVM. It uses a
private constructor, static instance, and a public static getter. There are 
various ways: eager, lazy, synchronized, double-check locking, Bill Pugh, and 
enum. Enum Singleton is the best because it is thread-safe, reflection-safe, 
and serialization-safe.”

===============================================================================
*/
