
/*
================================================================================
1. INTRODUCTION: THREAD CREATION IN JAVA
================================================================================

In Java, MULTITHREADING means executing multiple threads concurrently
within a single process.

Before Java executes a thread:
✔ JVM must create a Thread object
✔ OS must create a native thread
✔ JVM must map Java thread → OS thread

Java provides TWO PRIMARY ways to create threads:

1️⃣ Implementing Runnable interface
2️⃣ Extending Thread class

Both ultimately use the SAME Thread class internally.

================================================================================
*/

/*
================================================================================
2. THREAD CREATION WAYS (OVERVIEW)
================================================================================

Thread Creation Ways:
---------------------
1️⃣ Implement Runnable interface   (RECOMMENDED)
2️⃣ Extend Thread class             (LESS FLEXIBLE)

Diagram Logic:
--------------
Runnable (interface)
        ↑
      Thread (class implements Runnable)
        ↑
     MyThread (extends Thread)

================================================================================
*/

/*
================================================================================
3. WHAT IS RUNNABLE INTERFACE?
================================================================================

✔ Runnable is a FUNCTIONAL INTERFACE
✔ Present in java.lang package
✔ Contains ONLY ONE METHOD:

    void run();

✔ Purpose:
- Represents a TASK to be executed by a thread
- Separates TASK from THREAD

Runnable DOES NOT create a thread.
Thread class DOES.

================================================================================
*/

/*
================================================================================
4. WAY 1: IMPLEMENTING RUNNABLE INTERFACE (BEST PRACTICE)
================================================================================

WHY Runnable is preferred:
--------------------------
✔ Supports multiple inheritance
✔ Better design (separation of concern)
✔ Task logic separated from thread management
✔ Used by Executor Framework, Thread Pools

================================================================================
*/

/*
================================================================================
STEP 1: CREATE A CLASS THAT IMPLEMENTS RUNNABLE
================================================================================
*/

class RunnableTask implements Runnable {

    /*
    run() method defines the TASK
    This code will be executed by a THREAD
    */
    @Override
    public void run() {
        System.out.println(
            "Runnable task executed by: " +
            Thread.currentThread().getName()
        );
    }
}

/*
================================================================================
STEP 2: CREATE THREAD OBJECT AND START IT
================================================================================
*/

class RunnableExample {

    public static void main(String[] args) {

        System.out.println(
            "Main method executed by: " +
            Thread.currentThread().getName()
        );

        /*
        Create Runnable object (TASK)
        */
        RunnableTask task = new RunnableTask();

        /*
        Pass Runnable to Thread constructor
        */
        Thread thread = new Thread(task);

        /*
        Start thread
        */
        thread.start();

        System.out.println("Main method ends");
    }
}

/*
================================================================================
EXECUTION EXPLANATION (RUNNABLE)
================================================================================

1️⃣ main thread starts
2️⃣ Runnable object created (NO new thread yet)
3️⃣ Thread object created
4️⃣ start() is called
5️⃣ JVM creates a new OS-level thread
6️⃣ JVM internally calls run()
7️⃣ run() executes concurrently

IMPORTANT:
----------
Calling run() directly will NOT create a new thread.

================================================================================
*/

/*
================================================================================
5. WAY 2: EXTENDING THREAD CLASS
================================================================================

✔ Thread class already implements Runnable
✔ We override run() method
✔ Thread object itself represents both TASK + THREAD

LIMITATION:
-----------
❌ Java allows extending only ONE class
❌ Less flexible than Runnable

================================================================================
*/

/*
================================================================================
STEP 1: CREATE A CLASS THAT EXTENDS THREAD
================================================================================
*/

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(
            "Thread subclass executed by: " +
            Thread.currentThread().getName()
        );
    }
}

/*
================================================================================
STEP 2: CREATE OBJECT AND START THREAD
================================================================================
*/

class ThreadSubclassExample {

    public static void main(String[] args) {

        System.out.println(
            "Main method executed by: " +
            Thread.currentThread().getName()
        );

        MyThread thread = new MyThread();

        /*
        Start the thread
        */
        thread.start();

        System.out.println("Main method ends");
    }
}

/*
================================================================================
EXECUTION EXPLANATION (THREAD CLASS)
================================================================================

1️⃣ main thread starts
2️⃣ Thread subclass object created
3️⃣ start() is called
4️⃣ JVM creates new native thread
5️⃣ JVM calls overridden run()
6️⃣ run() executes concurrently

================================================================================
*/

/*
================================================================================
6. start() vs run() (VERY IMPORTANT INTERVIEW QUESTION)
================================================================================

start():
--------
✔ Creates new thread
✔ Allocates stack, PC, registers
✔ Executes run() asynchronously

run():
------
❌ Does NOT create new thread
❌ Executes like normal method
❌ Runs on SAME thread

================================================================================
*/

/*
================================================================================
7. WHY JAVA HAS TWO WAYS TO CREATE THREADS?
================================================================================

Reason:
-------
✔ Java supports MULTIPLE INTERFACE inheritance
✔ Java supports ONLY SINGLE CLASS inheritance

Explanation:
------------
- If Thread creation was ONLY via extending Thread:
  ❌ You cannot extend any other class

Runnable solves this problem.

Example:
--------
class MyClass extends SomeOtherClass implements Runnable { }

This is NOT possible with Thread inheritance.

================================================================================
*/

/*
================================================================================
8. COMPARISON: RUNNABLE vs THREAD
================================================================================

Feature                     Runnable              Thread
----------------------------------------------------------
Inheritance                 Multiple allowed      Single only
Design                       Better                Poorer
Task & Thread separation     YES                   NO
Flexibility                  High                  Low
Thread pool usage            YES                   NO
Recommended                  ✅ YES                ❌ NO

================================================================================
*/

/*
================================================================================
9. MEMORY & EXECUTION VIEW
================================================================================

Runnable:
---------
- Runnable object → stored in HEAP
- Thread object → stored in HEAP
- New Stack created ONLY after start()

Thread subclass:
----------------
- Thread object itself holds task
- New Stack created after start()

================================================================================
*/

/*
================================================================================
10. COMMON BEGINNER MISTAKES
================================================================================

❌ Calling run() instead of start()
❌ Expecting execution order
❌ Creating too many threads
❌ Sharing mutable data without synchronization
❌ Assuming thread names/order

================================================================================
*/

/*
================================================================================
11. INTERVIEW QUESTIONS (MUST KNOW)
================================================================================

Q1: Which is better Runnable or Thread?
A: Runnable (better design and flexibility)

Q2: Can a class extend Thread and implement Runnable?
A: Yes, but not recommended.

Q3: Does Runnable create a thread?
A: No, Thread creates the thread.

Q4: Why Thread class implements Runnable?
A: To allow execution logic abstraction.

Q5: What happens internally when start() is called?
A: JVM creates native thread and invokes run().

================================================================================
*/

/*
================================================================================
12. KEY INTERVIEW ONE-LINERS
================================================================================

✔ Runnable defines WHAT to do
✔ Thread defines HOW to run it
✔ start() creates new thread
✔ run() contains thread logic
✔ Prefer Runnable over Thread
✔ Java supports multiple interfaces but single class inheritance

================================================================================
END OF FILE
================================================================================
*/
