package CONCURRENCY.III_THREAD_POOLS;

import java.util.concurrent.*;

/*
================================================================================
7. BLOCKINGQUEUE TYPES – THREADPOOL BEHAVIOR CONTROLLER
================================================================================

This file explains:
✔ What is BlockingQueue
✔ Why BlockingQueue is used in ThreadPoolExecutor
✔ Types of BlockingQueue
✔ Internal behavior differences
✔ When to use which queue
✔ Interview traps & tuning rules

================================================================================
*/

/*
================================================================================
1. WHAT IS BlockingQueue?
================================================================================

BlockingQueue is part of:
java.util.concurrent

It is a thread-safe queue which:
✔ Blocks producer when queue is FULL
✔ Blocks consumer when queue is EMPTY

ThreadPoolExecutor uses BlockingQueue to:
✔ Store waiting tasks
✔ Decide when to create new threads
✔ Control concurrency

================================================================================
*/

/*
================================================================================
2. WHY BlockingQueue IS IMPORTANT IN THREAD POOLS
================================================================================

ThreadPool behavior depends MORE on queue than on maxPoolSize.

Queue decides:
--------------
✔ Task buffering
✔ Thread creation strategy
✔ Rejection behavior
✔ Memory usage

Interview fact:
---------------
"Queue is the heart of ThreadPoolExecutor behavior"

================================================================================
*/

/*
================================================================================
3. MAIN TYPES OF BlockingQueue USED IN THREAD POOLS
================================================================================

1️⃣ LinkedBlockingQueue
2️⃣ ArrayBlockingQueue
3️⃣ SynchronousQueue
4️⃣ PriorityBlockingQueue (special case)

================================================================================
*/

/*
================================================================================
4. LinkedBlockingQueue (UNBOUNDED QUEUE)
================================================================================

Characteristics:
----------------
✔ Unbounded (by default)
✔ Backed by linked nodes
✔ Tasks wait indefinitely
✔ maxPoolSize is IGNORED

Used by:
---------
Executors.newFixedThreadPool()
Executors.newSingleThreadExecutor()

Pros:
-----
✔ Simple
✔ No task rejection

Cons:
-----
❌ Memory risk (OutOfMemoryError)
❌ maxPoolSize becomes useless

================================================================================
*/

class LinkedBlockingQueueDemo {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                4,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>()
        );

        for (int i = 1; i <= 6; i++) {
            int id = i;
            executor.execute(() -> {
                System.out.println(
                        "LinkedQueue Task " + id +
                        " executed by " +
                        Thread.currentThread().getName()
                );
                try { Thread.sleep(2000); } catch (Exception e) {}
            });
        }

        executor.shutdown();
    }
}

/*
Observation:
------------
- Only corePoolSize threads used
- Tasks queued, NOT new threads created
================================================================================
*/

/*
================================================================================
5. ArrayBlockingQueue (BOUNDED QUEUE)
================================================================================

Characteristics:
----------------
✔ Fixed capacity
✔ Backed by array
✔ Predictable memory usage

Behavior:
---------
- Queue fills up
- Then maxPoolSize used
- Then rejection

Used in:
---------
Production systems

================================================================================
*/

class ArrayBlockingQueueDemo {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                4,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2)
        );

        for (int i = 1; i <= 8; i++) {
            int id = i;
            executor.execute(() -> {
                System.out.println(
                        "ArrayQueue Task " + id +
                        " executed by " +
                        Thread.currentThread().getName()
                );
                try { Thread.sleep(2000); } catch (Exception e) {}
            });
        }

        executor.shutdown();
    }
}

/*
Execution:
----------
Tasks 1-2 → core threads
Tasks 3-4 → queue
Tasks 5-6 → maxPool threads
Tasks 7-8 → REJECTED

================================================================================
*/

/*
================================================================================
6. SynchronousQueue (NO STORAGE QUEUE)
================================================================================

Characteristics:
----------------
✔ Capacity = 0
✔ No task storage
✔ Direct handoff

Behavior:
---------
- Task must be handed directly to thread
- If no idle thread → new thread created
- If maxPoolSize reached → rejection

Used by:
---------
Executors.newCachedThreadPool()

================================================================================
*/

class SynchronousQueueDemo {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                0,
                5,
                10,
                TimeUnit.SECONDS,
                new SynchronousQueue<>()
        );

        for (int i = 1; i <= 6; i++) {
            int id = i;
            executor.execute(() -> {
                System.out.println(
                        "SyncQueue Task " + id +
                        " executed by " +
                        Thread.currentThread().getName()
                );
                try { Thread.sleep(2000); } catch (Exception e) {}
            });
        }

        executor.shutdown();
    }
}

/*
================================================================================
7. PriorityBlockingQueue (SPECIAL)
================================================================================

Characteristics:
----------------
✔ Tasks ordered by priority
✔ Unbounded
✔ Requires Comparable or Comparator

Use case:
---------
- Priority-based task execution

Caution:
--------
❌ ThreadPoolExecutor priority handling is complex
❌ Rarely used with thread pools

================================================================================
*/

/*
================================================================================
8. INTERVIEW COMPARISON TABLE
================================================================================

| Queue Type           | Bounded | maxPool Used | Risk            |
|---------------------|---------|--------------|-----------------|
| LinkedBlockingQueue | ❌ No    | ❌ No        | OOM             |
| ArrayBlockingQueue  | ✔ Yes   | ✔ Yes       | Rejection       |
| SynchronousQueue    | ✔ Zero  | ✔ Yes       | Thread explosion|
| PriorityBlockingQueue| ❌ No  | ❌ No        | Complexity      |

================================================================================
*/

/*
================================================================================
9. INTERVIEW QUESTIONS & ANSWERS
================================================================================

Q1: Why is LinkedBlockingQueue dangerous?
A:
Unbounded → memory leak → maxPool ignored.

Q2: Which queue should be used in production?
A:
ArrayBlockingQueue (bounded).

Q3: Why does CachedThreadPool use SynchronousQueue?
A:
To scale threads dynamically.

Q4: What happens when queue is full and maxPool reached?
A:
Task is rejected.

================================================================================
*/

/*
================================================================================
10. BEST PRACTICES
================================================================================

✔ Always use bounded queue in production
✔ Avoid LinkedBlockingQueue unless tasks are limited
✔ Tune queue + pool together
✔ Understand workload (CPU vs IO)

================================================================================
END OF FILE
================================================================================
*/
