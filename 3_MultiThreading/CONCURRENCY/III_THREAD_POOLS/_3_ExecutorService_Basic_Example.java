package CONCURRENCY.III_THREAD_POOLS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
====================================================================
3. EXECUTOR SERVICE – BASIC EXAMPLE
====================================================================

ExecutorService is part of java.util.concurrent package.

It SOLVES all problems of old thread creation:
- No manual thread creation
- Thread reuse
- Controlled concurrency
- Better performance
- Cleaner code

--------------------------------------------------------------------
WHY EXECUTOR SERVICE?
--------------------------------------------------------------------

OLD WAY:
--------
new Thread(task).start();

Problems:
- New thread for every task
- No reuse
- No limit on threads
- Poor scalability

NEW WAY:
--------
ExecutorService executor = Executors.newFixedThreadPool(n);
executor.submit(task);

Benefits:
- Thread reuse
- Thread pool management handled by JVM
- Easy shutdown
- Better performance

--------------------------------------------------------------------
KEY CONCEPTS
--------------------------------------------------------------------

1️⃣ TASK
--------
- Unit of work
- Implemented using:
  - Runnable (no return value)
  - Callable (returns value)

2️⃣ EXECUTOR
-----------
- Responsible for executing submitted tasks

3️⃣ EXECUTOR SERVICE
-------------------
- Advanced Executor
- Lifecycle management
- Shutdown support

--------------------------------------------------------------------
BASIC EXECUTOR TYPES
--------------------------------------------------------------------

Executors.newFixedThreadPool(n)
- Fixed number of threads
- Reuses threads

Executors.newCachedThreadPool()
- Creates threads as needed
- Reuses idle threads

Executors.newSingleThreadExecutor()
- Only one thread
- Tasks executed sequentially

--------------------------------------------------------------------
CODE EXAMPLE
--------------------------------------------------------------------
*/

public class _3_ExecutorService_Basic_Example {

    // TASK IMPLEMENTATION
    static class MyTask implements Runnable {

        private final int taskId;

        MyTask(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            System.out.println(
                "Task " + taskId +
                " executed by " +
                Thread.currentThread().getName()
            );

            try {
                // Simulate some processing
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Task interrupted");
            }
        }
    }

    public static void main(String[] args) {

        /*
        ------------------------------------------------
        STEP 1: CREATE EXECUTOR SERVICE
        ------------------------------------------------
        Fixed thread pool with 3 threads.
        Only 3 threads will run concurrently.
        Other tasks will wait in queue.
        */

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        /*
        ------------------------------------------------
        STEP 2: SUBMIT TASKS
        ------------------------------------------------
        Submit 10 tasks.
        Only 3 threads execute at a time.
        Remaining tasks go into queue.
        */

        for (int i = 1; i <= 10; i++) {
            executorService.submit(new MyTask(i));
        }

        /*
        ------------------------------------------------
        STEP 3: SHUTDOWN EXECUTOR
        ------------------------------------------------
        Very IMPORTANT:
        - shutdown() does NOT stop running tasks
        - It stops accepting new tasks
        */

        executorService.shutdown();

        /*
        ------------------------------------------------
        STEP 4: WAIT FOR TERMINATION (OPTIONAL BUT GOOD)
        ------------------------------------------------
        */

        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Forcing shutdown...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("All tasks completed. Executor shut down.");
    }
}

/*
====================================================================
OUTPUT (Sample)
====================================================================

Task 1 executed by pool-1-thread-1
Task 2 executed by pool-1-thread-2
Task 3 executed by pool-1-thread-3
Task 4 executed by pool-1-thread-1
Task 5 executed by pool-1-thread-2
...

OBSERVATION:
------------
- Only 3 threads are created
- Threads are REUSED
- Tasks are queued and executed gradually

====================================================================
IMPORTANT INTERVIEW POINTS
====================================================================

Q: What happens if we don't call shutdown()?
A:
- JVM will NOT exit
- Executor threads keep running
- Memory leak risk

Q: Difference between shutdown() and shutdownNow()?
A:
shutdown():
- Stops accepting new tasks
- Allows running tasks to complete

shutdownNow():
- Attempts to stop running tasks
- Returns list of pending tasks

Q: Why ExecutorService is better than Thread?
A:
- Thread reuse
- Performance
- Scalability
- Clean code
- Production ready

====================================================================
REAL WORLD USE CASE
====================================================================
- Web servers
- Microservices
- Background jobs
- Async processing
- Batch processing

====================================================================
NEXT FILE SUGGESTION
====================================================================

4_ExecutorService_Shutdown_ShutdownNow.java
- shutdown()
- shutdownNow()
- awaitTermination()
- Proper lifecycle management
====================================================================
*/
