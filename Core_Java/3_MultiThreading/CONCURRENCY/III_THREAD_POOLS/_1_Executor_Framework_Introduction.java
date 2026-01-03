package CONCURRENCY.III_THREAD_POOLS;

/*
================================================================================
FILE NAME  : 1_Executor_Framework_Introduction.java
PACKAGE    : CONCURRENCY.III_THREAD_POOLS
TOPIC      : Executor Framework & Thread Pools – Introduction
AUTHOR     : Study Notes (Multithreading & Concurrency)
LEVEL      : Beginner → Advanced → Interview Ready
================================================================================

This file is designed as:
1. Complete study notes
2. Conceptual deep dive
3. Interview preparation guide
4. Practical reference for backend / full-stack Java developers

================================================================================
*/

/*
================================================================================
1. INTRODUCTION
================================================================================

Before Java 5:
-------------
Threads were created and managed manually using:
- new Thread()
- start()
- run()

Problems with manual thread management:
--------------------------------------
1. Thread creation is expensive (CPU + memory)
2. No reuse of threads
3. No control over number of threads
4. Hard to manage lifecycle
5. Risk of creating too many threads → OutOfMemoryError
6. Difficult error handling and monitoring

Solution:
---------
Java introduced the EXECUTOR FRAMEWORK in Java 5
(java.util.concurrent package)

================================================================================
*/

/*
================================================================================
2. WHAT IS EXECUTOR FRAMEWORK?
================================================================================

Definition:
-----------
Executor Framework is a high-level API that:
- Separates TASK SUBMISSION from TASK EXECUTION
- Manages a pool of reusable threads
- Handles thread lifecycle automatically

Key idea:
---------
"Don't create threads yourself. Let the framework manage them."

You submit TASKS → Executor decides:
- Which thread executes
- When it executes
- How many threads exist

================================================================================
*/

/*
================================================================================
3. CORE COMPONENTS OF EXECUTOR FRAMEWORK
================================================================================

1. Runnable / Callable
   - Represents a TASK (unit of work)

2. Executor (Interface)
   - Executes submitted tasks

3. ExecutorService (Interface)
   - Manages lifecycle of executor
   - submit(), shutdown(), invokeAll(), etc.

4. ThreadPoolExecutor (Class)
   - Core implementation of thread pool
   - Used internally by most executors

5. Executors (Utility Class)
   - Factory methods to create thread pools

================================================================================
*/

/*
================================================================================
4. TASK vs THREAD (VERY IMPORTANT INTERVIEW CONCEPT)
================================================================================

TASK:
-----
- WHAT to do
- Business logic
- Runnable or Callable

THREAD:
-------
- HOW it runs
- Low-level execution unit
- Managed by JVM + OS

Executor Framework:
-------------------
You focus on TASK
Framework handles THREAD

================================================================================
*/

/*
================================================================================
5. BASIC EXAMPLE WITHOUT EXECUTOR (OLD STYLE)
================================================================================
*/


/*
================================================================================
1. BASIC EXAMPLE WITHOUT EXECUTOR (OLD STYLE)
================================================================================
*/

// public class OldWayThreadExample {

//     // Inner static class (ALLOWED)
//     static class MyTask extends Thread {

//         @Override
//         public void run() {
//             System.out.println(
//                 "Task executed by: " + Thread.currentThread().getName()
//             );
//         }
//     }

//     // main method MUST be inside a class
//     public static void main(String[] args) {

//         // Creating threads manually
//         for (int i = 1; i <= 5; i++) {
//             new MyTask().start();
//         }
//     }
// }

/*
Problems:
---------
- New thread for every task
- No reuse
- Poor scalability
================================================================================
*/


/*
Problems:
---------
- New thread for every task
- No reuse
- Poor scalability
================================================================================
*/

/*
================================================================================
6. BASIC EXAMPLE WITH EXECUTOR FRAMEWORK (MODERN WAY)
================================================================================
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExecutorIntroductionExample {

    static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println("Task executed by: " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {

        // Create a fixed thread pool of size 2
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit multiple tasks
        for (int i = 1; i <= 5; i++) {
            executor.execute(new MyTask());
        }

        // Gracefully shutdown executor
        executor.shutdown();
    }
}

/*
Execution Flow:
---------------
1. ExecutorService created with 2 threads
2. 5 tasks submitted
3. Only 2 threads execute tasks concurrently
4. Remaining tasks wait in queue
5. Threads are reused
6. shutdown() stops accepting new tasks

================================================================================
*/

/*
================================================================================
7. WHY THREAD POOLS ARE IMPORTANT
================================================================================

Advantages:
-----------
1. Thread reuse → better performance
2. Controlled number of threads
3. Reduced memory usage
4. Better CPU utilization
5. Improved application stability
6. Built-in lifecycle management
7. Easier error handling

Real-World Usage:
-----------------
- Web servers (Tomcat, Jetty)
- Spring Boot REST APIs
- Microservices
- Asynchronous processing
- Background jobs

================================================================================
*/

/*
================================================================================
8. EXECUTOR vs EXECUTORS (CONFUSION ALERT)
================================================================================

Executor:
---------
- Interface
- Defines execute(Runnable)

ExecutorService:
----------------
- Sub-interface of Executor
- Adds lifecycle management

Executors:
----------
- Utility class
- Factory methods
- Creates ExecutorService instances

Example:
--------
Executors.newFixedThreadPool(5)

================================================================================
*/

/*
================================================================================
9. COMMON TYPES OF THREAD POOLS (OVERVIEW ONLY)
================================================================================

1. FixedThreadPool
2. CachedThreadPool
3. SingleThreadExecutor
4. ScheduledThreadPool
5. Custom ThreadPoolExecutor

(Each will be covered in separate files)

================================================================================
*/

/*
================================================================================
10. COMMON MISTAKES
================================================================================

❌ Creating executor and never calling shutdown()
❌ Using too many threads
❌ Using cached thread pool blindly
❌ Blocking tasks inside executor threads
❌ Confusing Runnable with Thread

================================================================================
*/

/*
================================================================================
11. INTERVIEW QUESTIONS
================================================================================

Q1. Why Executor Framework is better than creating threads manually?
Answer:
-------
- Thread reuse
- Better performance
- Controlled concurrency
- Cleaner design

Q2. Difference between Runnable and Callable?
Answer:
-------
Runnable:
- No return value
- Cannot throw checked exception

Callable:
- Returns value
- Can throw checked exception

Q3. What happens if we don’t call shutdown()?
Answer:
-------
- JVM may not exit
- Threads remain alive
- Resource leak

Q4. Is ExecutorService thread-safe?
Answer:
-------
Yes. It is designed for concurrent usage.

================================================================================
*/

/*
================================================================================
12. KEY TAKEAWAYS
================================================================================

✔ Executor Framework manages threads efficiently
✔ Focus on TASK, not THREAD
✔ Thread pools improve performance and stability
✔ Must be used in real-world Java backend applications
✔ Core foundation for ThreadPoolExecutor

================================================================================
END OF FILE
================================================================================
*/
