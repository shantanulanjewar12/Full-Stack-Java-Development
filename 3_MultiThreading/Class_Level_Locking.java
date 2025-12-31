/*
================================================================================
 FILE NAME       : 06_Class_Level_Locking.java
 TOPIC           : Class Level Locking in Java
 DESCRIPTION     : Complete explanation of locking a class (not objects),
                   using static synchronized methods & synchronized(ClassName.class).
================================================================================

🧠 WHAT IS CLASS LEVEL LOCKING?

Class Level Locking is used to prevent **multiple threads** from accessing
**static synchronized methods / shared class resources** at the same time.

📌 It locks the *Class object in Method Area*, not individual objects.

✔ Protects STATIC data.
✔ Ensures synchronization across all objects of that class.

================================================================================
 WHY DO WE NEED CLASS LEVEL LOCKING?

When multiple threads operate on:
   - static variables
   - static resources
   - shared class-level configurations

… we need to ensure only **ONE thread** accesses them at a time,
even if 100 objects are created.

✔ Class Lock = 1 per class in memory (Method Area)
✔ Object Lock = 1 per object

================================================================================
 CLASS LEVEL LOCK USING static synchronized METHOD
================================================================================
*/

class SharedResource {

    static int counter = 0;

    // 🔥 CLASS LEVEL LOCK (locks SharedResource.class)
    public static synchronized void increment() {
        counter++;
        System.out.println(Thread.currentThread().getName() +
                           " → counter: " + counter);
    }
}

public class Class_Level_Locking {
    public static void main(String[] args) {

        // 🔥 Creating multiple objects
        SharedResource r1 = new SharedResource();
        SharedResource r2 = new SharedResource();
        SharedResource r3 = new SharedResource();

        Runnable task = () -> {
            for(int i = 1; i <= 5; i++){
                SharedResource.increment(); // ALL threads must wait
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}

/*
================================================================================
 OUTPUT (Conceptual)

Thread-1 → counter: 1
Thread-1 → counter: 2
Thread-2 → counter: 3
Thread-3 → counter: 4
...
(no overlap / race condition)

✔ Even though r1, r2, r3 are 3 objects, they share the same LOCK.
✔ One thread at a time → class locked.

================================================================================
 CLASS LEVEL LOCK MEMORY DIAGRAM
================================================================================

             METHOD AREA (JVM)
        +------------------------------+
        |  SharedResource.class 🏛      |
        |  Monitor (Class Lock) 🔒      |
        +------------------------------+
                    ▲
   -------------------------------------------------
   |                     |                       |
   v                     v                       v
r1 object             r2 object               r3 object
(Heap)                (Heap)                  (Heap)
🧠 DIFFERENCE:
- Even if MANY objects exist, ONLY ONE LOCK controls access.

================================================================================
 CLASS LEVEL LOCK USING synchronized(ClassName.class)
================================================================================

class Bank {
    private static int balance = 1000;

    public void withdraw(int amount) {

        // CLASS LEVEL LOCK on Bank.class
        synchronized(Bank.class) {
            balance = balance - amount;
            System.out.println(Thread.currentThread().getName() +
                " withdrew " + amount + " → Remaining: " + balance);
        }
    }
}

⚡ Use this when:
✔ only part of method needs locking
✔ other parts should run without blocking

================================================================================
 CLASS LOCK vs OBJECT LOCK (SUPER IMPORTANT)
================================================================================

Feature                  | Object Lock 🔒            | Class Lock 🔐
--------------------------|----------------------------|---------------------------
Lock Applied On           | Individual Object          | .class file (all objects)
Used For                  | Instance data              | Static data
Keyword                   | synchronized               | static synchronized
Memory Location           | Heap                       | Method Area
No. of Locks              | Many (1 per object)        | ONE (per class)
Threads wait for?         | Same object only           | Any call to class-level sync

================================================================================
 EXAM + INTERVIEW SUMMARY (WRITE THIS)
================================================================================

📌 static synchronized method → CLASS LOCK  
📌 synchronized(ClassName.class) → CLASS LOCK  
📌 Class Lock protects static data across multiple objects  
📌 Only **one thread** can access class-level synchronized code at a time  
📌 Even 100 objects = only 1 class lock

================================================================================
 TOP INTERVIEW QUESTIONS (MASTER THESE)
================================================================================

❓ Q1: Difference between object level & class level lock?
✔ Object lock → per object (instance methods)
✔ Class lock → one lock for entire class (static methods)

❓ Q2: What happens if one thread holds class lock and other holds object lock?
✔ They do NOT block each other → separate lock mechanisms.

❓ Q3: Does synchronized static block lock object or class?
✔ Class → locks ClassName.class

❓ Q4: Why static method cannot use `this` for lock?
✔ Because `this` refers to object; static = no object reference

❓ Q5: Can thread holding class lock access synchronized instance method?
✔ YES (different lock) → they won't block each other

================================================================================
 END OF FILE
================================================================================
*/
