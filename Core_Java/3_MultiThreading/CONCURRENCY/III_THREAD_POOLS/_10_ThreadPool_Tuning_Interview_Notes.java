package CONCURRENCY.III_THREAD_POOLS;

/*
================================================================================
10. THREAD POOL TUNING – INTERVIEW NOTES & REAL-WORLD RULES
================================================================================

This file is a:
✔ Consolidation of ALL ThreadPool concepts
✔ Interview cheat-sheet
✔ Real-world tuning guide
✔ Decision-making reference

NO heavy code here.
This file focuses on:
- HOW to choose thread pool size
- WHY thread pools behave differently
- WHAT interviewers expect you to say

================================================================================
*/

/*
================================================================================
1. WHY THREAD POOL TUNING IS IMPORTANT
================================================================================

Incorrect thread pool configuration can cause:
❌ High latency
❌ Low throughput
❌ CPU thrashing
❌ OutOfMemoryError
❌ Task rejection
❌ Production outages

Correct tuning gives:
✔ Maximum throughput
✔ Stable system
✔ Predictable behavior
✔ Efficient CPU usage

================================================================================
*/

/*
================================================================================
2. GOLDEN INTERVIEW QUESTION
================================================================================

Q: How do you decide thread pool size?

This is NOT a fixed number.
It depends on:
✔ Nature of tasks
✔ CPU cores
✔ IO waiting time

================================================================================
*/

/*
================================================================================
3. TASK CLASSIFICATION (VERY IMPORTANT)
================================================================================

All tasks fall into ONE of these categories:

1️⃣ CPU-BOUND TASKS
-------------------
- Heavy computation
- Minimal waiting
- Example:
  - Image processing
  - Encryption
  - Data transformation

2️⃣ IO-BOUND TASKS
------------------
- Spend time waiting
- Example:
  - Database calls
  - REST API calls
  - File I/O

================================================================================
*/

/*
================================================================================
4. THREAD POOL SIZE FORMULAS (INTERVIEW GOLD)
================================================================================

Let:
-----
Ncpu = number of CPU cores
W = wait time
C = compute time

------------------------------------------------
CPU-BOUND TASKS
------------------------------------------------
Optimal threads ≈ Ncpu or Ncpu + 1

Reason:
-------
More threads do NOT help
They only increase context switching

------------------------------------------------
IO-BOUND TASKS
------------------------------------------------
Optimal threads ≈ Ncpu * (1 + W / C)

Reason:
-------
Threads wait on IO, so more threads are needed
to keep CPU busy

------------------------------------------------
INTERVIEW-SAFE ANSWER:
------------------------------------------------
"CPU-bound → threads ≈ CPU cores
 IO-bound  → threads > CPU cores"

================================================================================
*/

/*
================================================================================
5. CORE POOL SIZE vs MAX POOL SIZE
================================================================================

corePoolSize:
-------------
✔ Minimum number of threads
✔ Always kept alive
✔ Handles normal load

maximumPoolSize:
----------------
✔ Emergency expansion
✔ Used ONLY when:
   - core threads busy
   - queue full

Interview trap:
---------------
maxPoolSize is NOT always used ❌
Queue decides everything ✔

================================================================================
*/

/*
================================================================================
6. QUEUE SELECTION STRATEGY
================================================================================

LinkedBlockingQueue (unbounded):
--------------------------------
✔ No rejection
❌ Memory risk
❌ maxPoolSize ignored

ArrayBlockingQueue (bounded):
-----------------------------
✔ Predictable memory
✔ maxPoolSize effective
✔ Best for production

SynchronousQueue:
-----------------
✔ No queue
✔ Fast handoff
✔ Used in CachedThreadPool
❌ Risk of thread explosion

================================================================================
*/

/*
================================================================================
7. REAL-WORLD PRODUCTION RECOMMENDATION
================================================================================

DEFAULT SAFE CONFIGURATION:
---------------------------
✔ corePoolSize = CPU cores
✔ maxPoolSize = 2 * CPU cores
✔ Queue = bounded (ArrayBlockingQueue)
✔ Rejection = CallerRunsPolicy

WHY?
----
✔ Prevents overload
✔ Applies backpressure
✔ Stable under traffic spikes

================================================================================
*/

/*
================================================================================
8. REJECTION POLICY SELECTION
================================================================================

AbortPolicy:
------------
✔ Fail fast
✔ Good for critical systems

CallerRunsPolicy:
-----------------
✔ Slows producer
✔ Natural backpressure
✔ BEST default choice

DiscardPolicy:
--------------
❌ Silent loss
❌ Avoid for business logic

DiscardOldestPolicy:
--------------------
✔ Latest data wins
✔ Streaming systems

================================================================================
*/

/*
================================================================================
9. THREAD FACTORY BEST PRACTICES
================================================================================

✔ Always name threads
✔ Set UncaughtExceptionHandler
✔ Avoid daemon threads for business tasks
✔ Helps debugging & monitoring

================================================================================
*/

/*
================================================================================
10. SHUTDOWN BEST PRACTICES
================================================================================

ALWAYS follow this pattern:

executor.shutdown();

if (!executor.awaitTermination(timeout)) {
    executor.shutdownNow();
}

Why?
----
✔ Graceful shutdown
✔ Prevents JVM hang
✔ Production-safe

================================================================================
*/

/*
================================================================================
11. COMMON INTERVIEW TRAPS
================================================================================

❌ maxPoolSize always applies
❌ LinkedBlockingQueue is safe
❌ shutdownNow() kills threads
❌ More threads = better performance
❌ submit() throws exception immediately

Correct understanding avoids these traps.

================================================================================
*/

/*
================================================================================
12. FREQUENT INTERVIEW QUESTIONS & SHORT ANSWERS
================================================================================

Q1: Why is LinkedBlockingQueue dangerous?
A:
Unbounded → memory risk → maxPoolSize ignored.

Q2: Best rejection policy?
A:
CallerRunsPolicy (backpressure).

Q3: Difference between core and max pool size?
A:
Core = minimum threads
Max = emergency expansion.

Q4: CachedThreadPool good or bad?
A:
Good for short-lived tasks
Dangerous under heavy load.

Q5: Thread pool size for REST APIs?
A:
IO-bound → threads > CPU cores.

================================================================================
*/

/*
================================================================================
13. ONE-LINE INTERVIEW SUMMARY
================================================================================

"A thread pool must be tuned based on task nature, queue behavior,
and rejection policy to achieve stable and scalable concurrency."

================================================================================
*/

/*
================================================================================
14. FINAL TAKEAWAYS
================================================================================

✔ ThreadPoolExecutor is powerful but dangerous if misused
✔ Queue choice controls behavior
✔ Tuning depends on CPU vs IO
✔ Backpressure is essential
✔ Interviews test DECISION-MAKING, not syntax

================================================================================
END OF FILE
================================================================================
*/
