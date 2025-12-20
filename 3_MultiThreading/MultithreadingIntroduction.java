/*
================================================================================
1. WHAT IS MULTITHREADING?
================================================================================

✔ Definition:
- Multithreading is a programming concept where multiple threads execute
  concurrently within a single process.
- Threads share the same memory but execute independently.

✔ In simple words:
- Doing multiple tasks at the same time within one program.

✔ Example:
- Playing music 🎵 while downloading a file 📥
- Web server handling multiple client requests simultaneously

================================================================================
*/

/*
================================================================================
2. WHY MULTITHREADING IS NEEDED?
================================================================================

Without multithreading:
❌ CPU remains idle during I/O
❌ Poor performance
❌ Slow response time
❌ Wasted system resources

With multithreading:
✔ Better CPU utilization
✔ Faster execution
✔ Improved responsiveness
✔ Parallel task execution

================================================================================
*/

/*
================================================================================
3. BENEFITS OF MULTITHREADING
================================================================================

✔ Improved performance
✔ Reduced response time
✔ Efficient CPU utilization
✔ Parallel execution
✔ Better user experience (UI applications)

================================================================================
*/

/*
================================================================================
4. CHALLENGES / PROBLEMS OF MULTITHREADING
================================================================================

❌ Race conditions
❌ Deadlock
❌ Thread starvation
❌ Synchronization complexity
❌ Difficult debugging

👉 Multithreading improves performance BUT increases complexity.

================================================================================
*/

/*
================================================================================
5. PROCESS vs THREAD (VERY IMPORTANT FOR INTERVIEWS)
================================================================================

PROCESS:
- Independent program in execution
- Has its own memory space
- Heavyweight
- Communication is costly (IPC)

THREAD:
- Smallest unit of execution
- Runs inside a process
- Shares memory with other threads
- Lightweight
- Faster communication

--------------------------------------------------------------------------------
COMPARISON TABLE
--------------------------------------------------------------------------------
Feature          Process                 Thread
------------------------------------------------
Memory           Separate                Shared
Creation Cost    High                    Low
Communication    Slow                    Fast
Isolation        Strong                  Weak
Crash Impact     One process only        Whole process

================================================================================
*/

/*
================================================================================
6. MULTITHREADING IN JAVA
================================================================================

Java provides built-in support for multithreading via:
✔ java.lang.Thread class
✔ java.lang.Runnable interface
✔ java.util.concurrent package

Java is MULTITHREADED by design:
- Garbage Collector
- Finalizer
- Signal Dispatcher
- Main thread

================================================================================
*/

/*
================================================================================
7. THREAD LIFE CYCLE
================================================================================

Thread States:
1. NEW
2. RUNNABLE
3. BLOCKED
4. WAITING
5. TIMED_WAITING
6. TERMINATED

State Flow:
NEW → RUNNABLE → RUNNING → TERMINATED

================================================================================
*/

/*
================================================================================
8. CREATING THREADS IN JAVA (OVERVIEW)
================================================================================

Two primary ways:
1️⃣ Extending Thread class
2️⃣ Implementing Runnable interface

(Executor Framework comes later)

================================================================================
*/

public class MultithreadingIntroduction {

    public static void main(String[] args) {

        /*
        ================================================================================
        SINGLE-THREADED EXECUTION
        ================================================================================
        */

        System.out.println("Main thread started");

        task1();
        task2();

        System.out.println("Main thread ended");

        /*
        Output:
        - Tasks run sequentially
        - No concurrency
        */

        /*
        ================================================================================
        MULTI-THREADED EXECUTION
        ================================================================================
        */

        Thread t1 = new MyThread();
        Thread t2 = new Thread(new MyRunnable());

        t1.start(); // creates new thread
        t2.start(); // creates new thread

        /*
        Execution Flow:
        - main thread runs independently
        - t1 and t2 run concurrently
        - Order is NOT guaranteed
        */
    }

    static void task1() {
        System.out.println("Task 1 executed by " + Thread.currentThread().getName());
    }

    static void task2() {
        System.out.println("Task 2 executed by " + Thread.currentThread().getName());
    }
}

/*
================================================================================
9. THREAD CREATION – EXTENDING THREAD CLASS
================================================================================

✔ Direct approach
✔ Thread class contains run() method
✔ Less flexible (cannot extend another class)

================================================================================
*/

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread created using Thread class: "
                + Thread.currentThread().getName());
    }
}

/*
================================================================================
10. THREAD CREATION – IMPLEMENTING RUNNABLE
================================================================================

✔ Preferred approach
✔ Supports multiple inheritance
✔ Better design

================================================================================
*/

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread created using Runnable: "
                + Thread.currentThread().getName());
    }
}

/*
================================================================================
11. HOW MULTITHREADING WORKS INTERNALLY
================================================================================

✔ JVM uses OS-level threads
✔ Thread Scheduler decides execution
✔ Context switching happens
✔ Time-slicing on single-core CPU
✔ True parallelism on multi-core CPU

================================================================================
*/

/*
================================================================================
12. EXECUTION FLOW & MEMORY
================================================================================

Process Memory:
- Heap (shared among threads)
- Method Area (shared)
- Stack (separate for each thread)

✔ Each thread has:
- Its own stack
- Own program counter

✔ Shared:
- Objects in heap
- Static variables

================================================================================
*/

/*
================================================================================
13. COMMON MISTAKES BY BEGINNERS
================================================================================

❌ Calling run() instead of start()
❌ Assuming execution order
❌ Ignoring synchronization
❌ Sharing mutable data without locks
❌ Creating too many threads

================================================================================
*/

/*
================================================================================
14. INTERVIEW QUESTIONS – INTRODUCTION LEVEL
================================================================================

BEGINNER:
Q1: What is multithreading?
A: Executing multiple threads concurrently within a process.

Q2: Difference between process and thread?
A: Process has separate memory, threads share memory.

Q3: How many threads does a Java program have?
A: At least one (main thread).

INTERMEDIATE:
Q4: Why Runnable is preferred over Thread?
A: Better design, supports multiple inheritance.

Q5: What happens if start() is called twice?
A: IllegalThreadStateException.

================================================================================
*/

/*
================================================================================
15. WHEN TO USE MULTITHREADING?
================================================================================

✔ CPU-intensive tasks
✔ I/O-bound operations
✔ Web servers
✔ Background tasks
✔ Parallel processing

WHEN NOT TO USE:
❌ Simple programs
❌ Heavy synchronization required
❌ Limited system resources

================================================================================
*/

/*
================================================================================
16. WHAT COMES NEXT IN THIS FOLDER?
================================================================================

📁 MULTITHREADING Folder Roadmap:

1️⃣ Introduction of Multithreading  ✅ (THIS FILE)
2️⃣ Java Memory Model (Process & Thread)
3️⃣ Thread Life Cycle in Detail
4️⃣ Synchronization & Locks
5️⃣ Inter-thread Communication
6️⃣ Deadlock, Starvation, Livelock
7️⃣ Executor Framework
8️⃣ Callable, Future, CompletableFuture
9️⃣ Concurrency Utilities
🔟 Real Interview Problems

================================================================================
END OF FILE
================================================================================
*/
