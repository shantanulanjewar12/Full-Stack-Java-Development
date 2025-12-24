package CONCURRENCY.III_THREAD_POOLS;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
====================================================================
4. ExecutorService – shutdown() vs shutdownNow()
====================================================================

This file explains:
- shutdown()
- shutdownNow()
- awaitTermination()
- Correct lifecycle management of ExecutorService

--------------------------------------------------------------------
WHY THIS FILE IS IMPORTANT?
--------------------------------------------------------------------

If ExecutorService is NOT shut down properly:
❌ JVM will NOT exit
❌ Threads keep running
❌ Memory leak
❌ Application hangs in production

This is a VERY COMMON interview question.

--------------------------------------------------------------------
TERMS
--------------------------------------------------------------------

shutdown():
-----------
- Stops accepting NEW tasks
- Already submitted tasks CONTINUE execution
- Graceful shutdown

shutdownNow():
--------------
- Attempts to STOP running tasks
- Interrupts threads
- Returns list of tasks that NEVER started
- Force shutdown

awaitTermination():
-------------------
- Waits for executor to finish tasks
- Used AFTER shutdown()

--------------------------------------------------------------------
TASK IMPLEMENTATION
--------------------------------------------------------------------
*/

public class _4_ExecutorService_Shutdown_ShutdownNow {

    static class LongRunningTask implements Runnable {

        private final int taskId;

        LongRunningTask(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            System.out.println(
                "Task " + taskId +
                " started by " +
                Thread.currentThread().getName()
            );

            try {
                // Simulate long processing
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(
                    "Task " + taskId +
                    " was INTERRUPTED by " +
                    Thread.currentThread().getName()
                );
                Thread.currentThread().interrupt();
            }

            System.out.println(
                "Task " + taskId +
                " finished by " +
                Thread.currentThread().getName()
            );
        }
    }

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        /*
        ------------------------------------------------
        STEP 1: SUBMIT TASKS
        ------------------------------------------------
        */
        for (int i = 1; i <= 5; i++) {
            executor.submit(new LongRunningTask(i));
        }

        /*
        ------------------------------------------------
        STEP 2: shutdown()
        ------------------------------------------------
        - No new tasks accepted
        - Running tasks continue
        */
        executor.shutdown();
        System.out.println("shutdown() called");

        /*
        ------------------------------------------------
        STEP 3: WAIT FOR GRACEFUL TERMINATION
        ------------------------------------------------
        */
        try {
            boolean finished = executor.awaitTermination(3, TimeUnit.SECONDS);

            if (!finished) {
                System.out.println("Tasks not finished in time. Calling shutdownNow()");

                /*
                ------------------------------------------------
                STEP 4: shutdownNow()
                ------------------------------------------------
                - Interrupts running tasks
                - Returns tasks not yet started
                */
                List<Runnable> pendingTasks = executor.shutdownNow();

                System.out.println("Pending tasks count: " + pendingTasks.size());
            }

        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("Main thread finished");
    }
}

/*
====================================================================
POSSIBLE OUTPUT
====================================================================

Task 1 started by pool-1-thread-1
Task 2 started by pool-1-thread-2
shutdown() called
Tasks not finished in time. Calling shutdownNow()
Task 1 was INTERRUPTED by pool-1-thread-1
Task 2 was INTERRUPTED by pool-1-thread-2
Pending tasks count: 3
Main thread finished

--------------------------------------------------------------------
OBSERVATIONS
--------------------------------------------------------------------

- shutdown() allows running tasks to continue
- awaitTermination() waits for given time
- shutdownNow() interrupts running threads
- Tasks not started are returned

====================================================================
INTERVIEW QUESTIONS & ANSWERS
====================================================================

Q1: What happens if shutdown() is not called?
A:
- Executor threads keep running
- JVM never exits
- Memory leak

Q2: Difference between shutdown() and shutdownNow()?
A:
shutdown():
✔ Graceful
✔ No new tasks
✔ Existing tasks finish

shutdownNow():
✔ Force shutdown
✔ Interrupts threads
✔ Returns pending tasks

Q3: Does shutdownNow() guarantee thread termination?
A:
❌ NO
- It only sends interrupt signal
- Task must handle InterruptedException properly

Q4: Why awaitTermination() is important?
A:
- Gives tasks chance to finish
- Avoids abrupt shutdown
- Production safe

====================================================================
BEST PRACTICE (VERY IMPORTANT)
====================================================================

✔ Always use:
   shutdown()
   awaitTermination()
   shutdownNow() as fallback

✔ Always handle InterruptedException

✔ Never forget to shut down ExecutorService

====================================================================
NEXT FILE SUGGESTION
====================================================================

5_ExecutorService_Submit_vs_Execute.java
- submit()
- execute()
- Future
- Exception handling

====================================================================
*/
