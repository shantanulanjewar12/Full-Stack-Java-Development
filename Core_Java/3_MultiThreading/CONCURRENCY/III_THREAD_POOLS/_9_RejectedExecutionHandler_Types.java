package CONCURRENCY.III_THREAD_POOLS;

import java.util.concurrent.*;

/*
================================================================================
9. REJECTEDEXECUTIONHANDLER – TYPES & BEHAVIOR
================================================================================

This file explains:
✔ What is RejectedExecutionHandler
✔ Why task rejection happens
✔ All built-in rejection policies
✔ Custom rejection handler
✔ Real-world use cases
✔ Interview questions & best practices

================================================================================
*/

/*
================================================================================
1. WHAT IS TASK REJECTION?
================================================================================

Task rejection happens when:
----------------------------
1️⃣ ThreadPoolExecutor is SHUT DOWN
OR
2️⃣ All threads are BUSY
AND
3️⃣ Work queue is FULL

At this point:
--------------
ThreadPoolExecutor CANNOT accept new tasks.

So it delegates decision to:
➡ RejectedExecutionHandler

================================================================================
*/

/*
================================================================================
2. WHAT IS RejectedExecutionHandler?
================================================================================

RejectedExecutionHandler is an INTERFACE in:
java.util.concurrent

Method:
-------
void rejectedExecution(Runnable r, ThreadPoolExecutor executor);

This method is invoked when a task is REJECTED.

================================================================================
*/

/*
================================================================================
3. BUILT-IN REJECTION POLICIES (VERY IMPORTANT)
================================================================================

Java provides 4 built-in policies:

1️⃣ AbortPolicy (DEFAULT)
2️⃣ CallerRunsPolicy
3️⃣ DiscardPolicy
4️⃣ DiscardOldestPolicy

================================================================================
*/

/*
================================================================================
4. AbortPolicy (DEFAULT)
================================================================================

Behavior:
---------
✔ Throws RejectedExecutionException
✔ Task is NOT executed
✔ Application may fail if not handled

Use case:
---------
✔ When task rejection should FAIL FAST

================================================================================
*/

class AbortPolicyDemo {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                2,
                0,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                new ThreadPoolExecutor.AbortPolicy()
        );

        submitTasks(executor, "AbortPolicy");
    }

    static void submitTasks(ThreadPoolExecutor executor, String label) {
        try {
            for (int i = 1; i <= 6; i++) {
                int id = i;
                executor.execute(() -> {
                    System.out.println(label + " - Task " + id +
                            " executed by " +
                            Thread.currentThread().getName());
                    try { Thread.sleep(2000); } catch (Exception e) {}
                });
            }
        } catch (RejectedExecutionException e) {
            System.out.println("Task rejected (AbortPolicy)");
        } finally {
            executor.shutdown();
        }
    }
}

/*
================================================================================
5. CallerRunsPolicy
================================================================================

Behavior:
---------
✔ Task executed by CALLER thread
✔ Slows down producer
✔ Provides back-pressure

Use case:
---------
✔ When you want to slow down task submission

================================================================================
*/

class CallerRunsPolicyDemo {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                2,
                0,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for (int i = 1; i <= 6; i++) {
            int id = i;
            executor.execute(() -> {
                System.out.println("CallerRuns - Task " + id +
                        " executed by " +
                        Thread.currentThread().getName());
                try { Thread.sleep(1000); } catch (Exception e) {}
            });
        }

        executor.shutdown();
    }
}

/*
================================================================================
6. DiscardPolicy
================================================================================

Behavior:
---------
✔ Task is silently DISCARDED
✔ No exception
✔ No execution

Use case:
---------
✔ Best-effort tasks (logging, metrics)

DANGER:
-------
❌ Silent data loss

================================================================================
*/

class DiscardPolicyDemo {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                2,
                0,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                new ThreadPoolExecutor.DiscardPolicy()
        );

        for (int i = 1; i <= 6; i++) {
            int id = i;
            executor.execute(() -> {
                System.out.println("DiscardPolicy - Task " + id);
            });
        }

        executor.shutdown();
    }
}

/*
================================================================================
7. DiscardOldestPolicy
================================================================================

Behavior:
---------
✔ Oldest task in queue is removed
✔ New task is accepted

Use case:
---------
✔ Latest data is more important
✔ Streaming / real-time systems

================================================================================
*/

class DiscardOldestPolicyDemo {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                2,
                0,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        for (int i = 1; i <= 6; i++) {
            int id = i;
            executor.execute(() -> {
                System.out.println("DiscardOldest - Task " + id);
            });
        }

        executor.shutdown();
    }
}

/*
================================================================================
8. CUSTOM RejectedExecutionHandler
================================================================================

Why custom handler?
-------------------
✔ Logging
✔ Alerting
✔ Retry logic
✔ Persist task for later execution

================================================================================
*/

class CustomRejectedHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r,
                                  ThreadPoolExecutor executor) {

        System.out.println("Custom Handler: Task rejected. Saving to DB or retrying...");
        // Custom logic here
    }
}

class CustomRejectedHandlerDemo {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                2,
                0,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                new CustomRejectedHandler()
        );

        for (int i = 1; i <= 6; i++) {
            executor.execute(() -> {
                try { Thread.sleep(2000); } catch (Exception e) {}
                System.out.println("Executing task");
            });
        }

        executor.shutdown();
    }
}

/*
================================================================================
9. INTERVIEW COMPARISON TABLE
================================================================================

| Policy              | Executes Task | Throws Exception | Use Case |
|--------------------|---------------|------------------|----------|
| AbortPolicy        | ❌ No          | ✔ Yes            | Fail fast |
| CallerRunsPolicy   | ✔ Yes (caller)| ❌ No             | Backpressure |
| DiscardPolicy      | ❌ No          | ❌ No             | Best effort |
| DiscardOldestPolicy| ✔ Yes (new)   | ❌ No             | Latest data |
| Custom             | Depends        | Depends           | Business logic |

================================================================================
*/

/*
================================================================================
10. INTERVIEW QUESTIONS & ANSWERS
================================================================================

Q1: When does task rejection happen?
A:
When thread pool is full and queue is full.

Q2: Default rejection policy?
A:
AbortPolicy.

Q3: Best policy for rate limiting?
A:
CallerRunsPolicy.

Q4: Dangerous policy?
A:
DiscardPolicy (silent loss).

Q5: Can we create custom rejection logic?
A:
✔ Yes, by implementing RejectedExecutionHandler.

================================================================================
*/

/*
================================================================================
11. BEST PRACTICES
================================================================================

✔ Always choose rejection policy consciously
✔ Use CallerRunsPolicy for backpressure
✔ Log rejected tasks
✔ Avoid silent discard in critical systems

================================================================================
END OF FILE
================================================================================
*/
