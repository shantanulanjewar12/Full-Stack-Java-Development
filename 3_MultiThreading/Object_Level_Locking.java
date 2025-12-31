/*
================================================================================
 FILE NAME       : 01_Object_Level_Locking.java
 TOPIC           : Object Level Locking in Java
 DESCRIPTION     : Complete guide to understanding object level locking using
                    synchronized instance methods & synchronized blocks.
================================================================================

🧠 WHAT IS OBJECT LEVEL LOCKING?

Object Level Locking is a mechanism where each object in Java has a **unique lock**
(also called a **monitor lock**). When a thread enters a synchronized instance
method/block of that object, it acquires that object's lock. 

👉 While a thread holds the lock on that object:
   - No other thread can access any synchronized instance method of that object.
   - But other objects of the same class are not blocked.

So synchronization occurs **per object**, not per class.

================================================================================
 WHY IS LOCKING REQUIRED IN MULTITHREADING?

Because when multiple threads try to access **shared resources** at the same time,
race conditions, inconsistent data and corruption can occur.

✔ Object Lock → Protects instance (object specific) resources
✔ Class Lock → Protects static (class level) resources

================================================================================
 OBJECT LEVEL LOCKING USING synchronized METHOD
================================================================================
*/

class Counter {
    int count = 0;

    // synchronized instance method → Object Level Lock
    public synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " → Count: " + count);
    }
}

public class Object_Level_Locking {
    public static void main(String[] args) {

        Counter obj = new Counter(); // shared object

        Runnable task = () -> {
            for(int i = 1; i <= 5; i++) {
                obj.increment(); // threads will lock the SAME object
            }
        };

        Thread t1 = new Thread(task, "Person-1");
        Thread t2 = new Thread(task, "Person-2");

        t1.start();
        t2.start();
    }
}

/*
================================================================================
 RESULT EXPLANATION

Person-1 → Count: 1
Person-1 → Count: 2
Person-1 → Count: 3
Person-2 → Count: 4
Person-2 → Count: 5
Person-1 → Count: 6
Person-2 → Count: 7
... (NO MIXED / BROKEN OUTPUT)

✔ Only one thread accesses increment() at a time.
✔ One object → One lock → Threads wait on each other properly.

================================================================================
 OBJECT LEVEL LOCK MEMORY DIAGRAM
================================================================================

           HEAP MEMORY

        +---------------------+
 obj -> | Counter Object      |
        | count = 7           |
        | monitor(lock) 🎯    |
        +---------+-----------+
                  |
                  |
      +-----------+------------+
      |                        |
 Person-1                  Person-2
 (Thread)                  (Thread)
 Waiting if lock           Runs if lock free


→ If Person-1 holds the lock:
   Person-2 is BLOCKED until lock is released.

================================================================================
 MULTIPLE OBJECTS → MULTIPLE LOCKS (VERY IMPORTANT)
================================================================================

If each thread uses a DIFFERENT object, then no synchronization between them
(since locks are object-specific).

*/

class DemoMultipleObjects {
    public static void main(String[] args) {

        Counter obj1 = new Counter(); // Lock-1
        Counter obj2 = new Counter(); // Lock-2

        // No thread blocking, as different objects = different locks
        new Thread(() -> obj1.increment(), "T1").start();
        new Thread(() -> obj2.increment(), "T2").start();
    }
}

/*
================================================================================
 OBJECT LEVEL LOCK VS CLASS LEVEL LOCK
================================================================================

Type                    | Lock Applied On          | Keyword Used
------------------------|---------------------------|----------------------------------
Object Level Lock       | Single Object             | synchronized instance method/block
Class Level Lock        | Class (all objects)       | synchronized static method/block

================================================================================
 synchronized BLOCK (Object Level Lock)
================================================================================

We can synchronize only critical area instead of whole method.

*/

class BankAccount {
    private int balance = 1000;

    public void withdraw(int amount) {
        // Only this part is synchronized, not full method
        synchronized(this) { // 🔥 'this' = object lock
            balance -= amount;
            System.out.println(Thread.currentThread().getName() +
                " withdrew " + amount + " → Remaining: " + balance);
        }
    }
}

/*
================================================================================
 WHEN TO USE OBJECT LEVEL LOCKING?

Use it when:
✔ Data is **instance specific** (per object)
✔ Protecting **bank accounts**, **counters**, **local user sessions**
✔ You need thread safety only for one object, not entire class

Avoid when:
❌ Using static shared data (then use class level lock)
❌ Huge method body (use synchronized block instead)

================================================================================
 INTERVIEW QUESTIONS & ANSWERS
================================================================================

❓ What is Object Level Locking?
👉 A lock applied on a specific object instance to prevent multiple threads
   from accessing synchronized instance methods/blocks of that object at once.

❓ How is it implemented?
👉 Using synchronized keyword on instance methods or synchronized(this) blocks.

❓ How is it different from Class Level Locking?
👉 Object lock → One object at a time
   Class lock  → Entire class locked, affecting all objects

❓ Does Thread.sleep() release the lock?
👉 NO. The thread sleeps but holds the lock. Others must wait.

❓ Does wait() release the lock?
👉 YES. wait() releases lock and sends thread to waiting state.

================================================================================
 SHORT SUMMARY (MEMORY MAP RULE)
================================================================================

🧠 RULE FOR INTERVIEW:

1 Object  → 1 Lock → 1 Thread at a time
2 Objects → 2 Locks → Threads can run Parallel
static synchronized → Class Lock (1 per class)

================================================================================
 END OF FILE
================================================================================
*/
