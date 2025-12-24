package CONCURRENCY.III_THREAD_POOLS;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
================================================================================
6. THREADPOOLEXECUTOR – CORE PARAMETERS (VERY IMPORTANT)
================================================================================

This file explains:
✔ ThreadPoolExecutor
✔ corePoolSize
✔ maximumPoolSize
✔ keepAliveTime
✔ workQueue
✔ Internal thread creation algorithm
✔ Common interview traps
✔ Real-world tuning logic

This is the HEART of Thread Pool understanding.

================================================================================
*/

/*
================================================================================
1. WHAT IS ThreadPoolExecutor?
================================================================================

ThreadPoolExecutor is the CORE implementation class behind:
- Executors.newFixedThreadPool()
- Executors.newCachedThreadPool()
- Executors.newSingleThreadExecutor()

All factory methods INTERNALLY create ThreadPoolExecutor.

Definition:
-----------
ThreadPoolExecutor manages:
✔ Thread creation
✔ Thread reuse
✔ Task queueing
✔ Thread termination

================================================================================
*/

/*
================================================================================
2. THREADPOOLEXECUTOR CONSTRUCTOR (IMPORTANT)
================================================================================

ThreadPoolExecutor(
    int corePoolSize,
    int maximumPoolSize,
    long keepAliveTime,
    TimeUnit unit,
    BlockingQueue<Runnable> workQueue
)

Each parameter has a STRONG impact on performance.

================================================================================
*/

/*
================================================================================
3. CORE PARAMETERS – ONE BY ONE
================================================================================
*/

/*
------------------------------------------------
1️⃣ corePoolSize
------------------------------------------------

Meaning:
--------
- Minimum number of threads kept alive in pool
- Threads are CREATED immediately when tasks arrive
- Even if threads are IDLE, they are NOT destroyed

Example:
--------
corePoolSize = 2

→ At least 2 threads will always exist

Interview Tip:
--------------
corePoolSize ≠ starting size
corePoolSize = minimum active threads

------------------------------------------------
*/

/*
------------------------------------------------
2️⃣ maximumPoolSize
------------------------------------------------

Meaning:
--------
- Maximum number of threads allowed in pool
- Used ONLY when:
  - core threads are busy
  - AND queue is full

If tasks > maxPoolSize + queue capacity:
→ Rejection happens

------------------------------------------------
*/

/*
------------------------------------------------
3️⃣ keepAliveTime
------------------------------------------------

Meaning:
--------
- Time extra threads (above corePoolSize) stay alive
- After this time, idle threads are destroyed

Important:
----------
Applies ONLY to:
threads > corePoolSize

------------------------------------------------
*/

/*
------------------------------------------------
4️⃣ workQueue (BlockingQueue)
------------------------------------------------

Meaning:
--------
- Holds tasks waiting for execution
- Decides whether new thread is created or not

Common queues:
--------------
LinkedBlockingQueue  → unbounded
ArrayBlockingQueue   → bounded
SynchronousQueue     → no storage

Queue choice changes behavior COMPLETELY.

------------------------------------------------
*/

/*
================================================================================
4. INTERNAL WORKING ALGORITHM (MOST IMPORTANT)
================================================================================

When a task is submitted:

STEP 1:
--------
If current threads < corePoolSize
→ Create new thread

STEP 2:
--------
Else if queue NOT full
→ Add task to queue

STEP 3:
--------
Else if current threads < maximumPoolSize
→ Create new thread

STEP 4:
--------
Else
→ Reject task (RejectedExecutionHandler)

THIS FLOW IS ASKED DIRECTLY IN INTERVIEWS.

================================================================================
*/

/*
================================================================================
5. PRACTICAL CODE DEMO
================================================================================
*/

public class _6_ThreadPoolExecutor_Core_Parameters {

    public static void main(String[] args) {

        /*
        ------------------------------------------------
        ThreadPool Configuration
        ------------------------------------------------
        corePoolSize    = 2
        maxPoolSize     = 4
        keepAliveTime   = 5 seconds
        queue capacity  = unlimited (LinkedBlockingQueue)
        ------------------------------------------------
        */

        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                4,
                5,
                TimeUnit.SECONDS,
                queue
        );

        /*
        ------------------------------------------------
        SUBMIT TASKS
        ------------------------------------------------
        */

        for (int i = 1; i <= 6; i++) {
            int taskId = i;
            executor.execute(() -> {
                System.out.println(
                        "Task " + taskId +
                        " executed by " +
                        Thread.currentThread().getName()
                );

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
    }
}

/*
================================================================================
6. WHAT WILL HAPPEN HERE?
================================================================================

corePoolSize = 2

Tasks submitted = 6

Step-by-step:
-------------
Task 1 → new thread (1)
Task 2 → new thread (2)
Task 3 → goes to queue
Task 4 → goes to queue
Task 5 → goes to queue
Task 6 → goes to queue

Because:
---------
LinkedBlockingQueue is UNBOUNDED
→ maxPoolSize is NEVER used

Interview Trap:
---------------
Many people think maxPoolSize always applies ❌
It applies ONLY when queue is FULL.

================================================================================
*/

/*
================================================================================
7. COMMON MISCONFIGURATIONS
================================================================================

❌ Using unbounded queue + large maxPoolSize
→ maxPoolSize becomes useless

❌ Very high corePoolSize
→ Too many idle threads

❌ Small queue + small maxPoolSize
→ Frequent task rejection

================================================================================
*/

/*
================================================================================
8. INTERVIEW QUESTIONS & ANSWERS
================================================================================

Q1: When is maxPoolSize used?
A:
Only when core threads are busy AND queue is full.

Q2: Does keepAliveTime apply to core threads?
A:
No (unless allowCoreThreadTimeOut(true) is enabled).

Q3: Why LinkedBlockingQueue is dangerous?
A:
- Unlimited memory usage
- maxPoolSize ignored
- Can cause OutOfMemoryError

Q4: Which queue is used in newFixedThreadPool?
A:
LinkedBlockingQueue (unbounded)

================================================================================
*/

/*
================================================================================
9. REAL-WORLD TUNING RULE (INTERVIEW GOLD)
================================================================================

CPU-bound tasks:
---------------
corePoolSize ≈ number of CPU cores

IO-bound tasks:
---------------
corePoolSize > CPU cores

Use bounded queues in production.

================================================================================
*/

/*
================================================================================
10. KEY TAKEAWAYS
================================================================================

✔ corePoolSize = minimum threads
✔ maxPoolSize = emergency expansion
✔ Queue decides behavior
✔ keepAliveTime removes extra threads
✔ ThreadPoolExecutor = brain of thread pools

================================================================================
END OF FILE
================================================================================
*/
