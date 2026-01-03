package CONCURRENCY.III_THREAD_POOLS;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/*
================================================================================
8. THREADFACTORY CUSTOMIZATION
================================================================================

This file explains:
✔ What is ThreadFactory
✔ Why default thread creation is not enough
✔ How to create custom ThreadFactory
✔ Thread naming, priority, daemon threads
✔ Real-world use cases
✔ Interview questions & best practices

================================================================================
*/

/*
================================================================================
1. WHAT IS ThreadFactory?
================================================================================

ThreadFactory is an INTERFACE present in:
java.util.concurrent

Definition:
-----------
ThreadFactory is responsible for:
✔ Creating new threads
✔ Customizing thread properties

ThreadFactory method:
---------------------
Thread newThread(Runnable r);

ThreadPoolExecutor uses ThreadFactory whenever it needs
to create a new thread.

================================================================================
*/

/*
================================================================================
2. WHY DO WE NEED CUSTOM ThreadFactory?
================================================================================

Default ThreadFactory problems:
-------------------------------
✔ Threads have generic names:
  pool-1-thread-1
  pool-1-thread-2

❌ Hard to debug
❌ Hard to monitor logs
❌ No control over:
   - Thread name
   - Priority
   - Daemon flag
   - UncaughtExceptionHandler

In REAL projects:
-----------------
✔ Thread naming is critical
✔ Monitoring & debugging require clarity

================================================================================
*/

/*
================================================================================
3. DEFAULT THREAD FACTORY (INTERNAL)
================================================================================

Executors.defaultThreadFactory():
--------------------------------
- Creates non-daemon threads
- Normal priority
- Generic names

Thread name pattern:
--------------------
pool-X-thread-Y

================================================================================
*/

/*
================================================================================
4. CUSTOM ThreadFactory IMPLEMENTATION
================================================================================
*/

class CustomThreadFactory implements ThreadFactory {

    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;

    CustomThreadFactory(String poolName) {
        namePrefix = poolName + "-thread-";
    }

    @Override
    public Thread newThread(Runnable r) {

        Thread thread = new Thread(r);

        // Custom thread name
        thread.setName(namePrefix + threadNumber.getAndIncrement());

        // Thread priority (1–10)
        thread.setPriority(Thread.NORM_PRIORITY);

        // Daemon thread or user thread
        thread.setDaemon(false);

        // Uncaught exception handler
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println(
                    "Exception in thread " +
                    t.getName() +
                    " : " + e.getMessage()
            );
        });

        return thread;
    }
}

/*
================================================================================
5. USING CUSTOM ThreadFactory WITH ThreadPoolExecutor
================================================================================
*/

public class _8_ThreadFactory_Customization {

    public static void main(String[] args) {

        ThreadFactory customFactory = new CustomThreadFactory("Order-Service");

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                4,
                10,
                TimeUnit.SECONDS,
                new java.util.concurrent.ArrayBlockingQueue<>(2),
                customFactory
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

                // Simulate exception for demo
                if (taskId == 3) {
                    throw new RuntimeException("Demo exception");
                }

                try {
                    Thread.sleep(2000);
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
6. SAMPLE OUTPUT
================================================================================

Task 1 executed by Order-Service-thread-1
Task 2 executed by Order-Service-thread-2
Exception in thread Order-Service-thread-2 : Demo exception
Task 3 executed by Order-Service-thread-3
Task 4 executed by Order-Service-thread-4

================================================================================
*/

/*
================================================================================
7. REAL-WORLD USE CASES
================================================================================

✔ Naming threads by service (Auth-Service, Payment-Service)
✔ Setting daemon threads for background jobs
✔ Centralized exception logging
✔ Monitoring thread behavior
✔ Debugging production issues

================================================================================
*/

/*
================================================================================
8. INTERVIEW QUESTIONS & ANSWERS
================================================================================

Q1: What is ThreadFactory?
A:
An interface used to create threads with custom properties.

Q2: Why customize ThreadFactory?
A:
For better debugging, monitoring, naming, and error handling.

Q3: Does ThreadFactory create tasks?
A:
❌ No. It only creates threads.

Q4: Can we set thread priority using ThreadFactory?
A:
✔ Yes.

Q5: Where is ThreadFactory used internally?
A:
Inside ThreadPoolExecutor.

================================================================================
*/

/*
================================================================================
9. BEST PRACTICES
================================================================================

✔ Always name threads meaningfully
✔ Use UncaughtExceptionHandler
✔ Avoid daemon threads for critical work
✔ Keep thread creation lightweight

================================================================================
10. KEY TAKEAWAYS
================================================================================

✔ ThreadFactory controls thread creation
✔ Default factory is not enough for production
✔ Custom factory improves observability
✔ Interviewers love this topic

================================================================================
END OF FILE
================================================================================
*/
