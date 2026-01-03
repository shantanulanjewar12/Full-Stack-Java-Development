package CONCURRENCY.III_THREAD_POOLS;

/*
===============================================================================
 FILE NAME  : 11_ThreadPoolExecutor_Lifecycle_States.java
 TOPIC      : ThreadPoolExecutor Lifecycle (Running → Shutdown / Stop → Terminated)
 PACKAGE    : java.util.concurrent
===============================================================================

This file is PURE THEORY + PRACTICAL DEMO.

It explains:
✔ ThreadPoolExecutor lifecycle states
✔ shutdown() vs shutdownNow()
✔ What happens to running tasks
✔ What happens to queued tasks
✔ State transitions
✔ Interview-level explanations
✔ Example + expected output

This file directly maps to the lifecycle diagram shown in your notes.

===============================================================================
*/

import java.util.List;
import java.util.concurrent.*;

/*
===============================================================================
 1️⃣ WHAT IS THREADPOOLEXECUTOR LIFECYCLE?
===============================================================================

ThreadPoolExecutor has an INTERNAL LIFECYCLE.

It moves through different STATES based on how it is used and terminated.

LIFECYCLE STATES (Conceptual):

    ┌──────────┐
    │ RUNNING  │  <-- default state after creation
    └────┬─────┘
         │ shutdown()
         ▼
    ┌──────────┐
    │ SHUTDOWN │  <-- no new tasks accepted
    └────┬─────┘
         │ all tasks completed
         ▼
    ┌────────────┐
    │ TERMINATED │
    └────────────┘

    OR

    ┌──────────┐
    │ RUNNING  │
    └────┬─────┘
         │ shutdownNow()
         ▼
    ┌──────────┐
    │  STOP    │  <-- running threads interrupted
    └────┬─────┘
         ▼
    ┌────────────┐
    │ TERMINATED │
    └────────────┘

===============================================================================
*/


public class _13_ThreadPoolExecutor_Lifecycle_States {

    public static void main(String[] args) throws InterruptedException {

        /*
        ===========================================================================
         2️⃣ CREATING THREAD POOL (INITIAL STATE = RUNNING)
        ===========================================================================
        */

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,                      // corePoolSize
                4,                      // maximumPoolSize
                5,                      // keepAliveTime
                TimeUnit.SECONDS,       // unit
                new LinkedBlockingQueue<>(3) // workQueue
        );

        /*
        At this point:
        - ThreadPoolExecutor state = RUNNING
        - It can accept new tasks
        - Threads are created on demand
        */

        System.out.println("State after creation:");
        printState(executor);

        /*
        ===========================================================================
         3️⃣ SUBMIT TASKS (RUNNING STATE)
        ===========================================================================
        */

        for (int i = 1; i <= 6; i++) {
            int taskNumber = i;

            executor.submit(() -> {
                try {
                    System.out.println(
                            "Task " + taskNumber + " started by " +
                            Thread.currentThread().getName()
                    );
                    Thread.sleep(3000);
                    System.out.println(
                            "Task " + taskNumber + " completed by " +
                            Thread.currentThread().getName()
                    );
                } catch (InterruptedException e) {
                    System.out.println(
                            "Task " + taskNumber + " interrupted!"
                    );
                }
            });
        }

        /*
        Tasks distribution:
        - core threads handle first tasks
        - queue stores extra tasks
        - max threads created if queue is full
        */

        Thread.sleep(2000);

        /*
        ===========================================================================
         4️⃣ SHUTDOWN() → RUNNING → SHUTDOWN
        ===========================================================================
        */

        System.out.println("\nCalling shutdown()");
        executor.shutdown();

        /*
        shutdown():
        ✔ Does NOT accept new tasks
        ✔ Already submitted tasks continue running
        ✔ Queued tasks WILL be executed
        ✔ Threads are NOT interrupted
        */

        System.out.println("State after shutdown():");
        printState(executor);

        /*
        Submitting a new task after shutdown → RejectedExecutionException
        Uncomment to test:
        executor.submit(() -> System.out.println("New Task"));
        */

        /*
        ===========================================================================
         5️⃣ WAIT FOR TERMINATION
        ===========================================================================
        */

        executor.awaitTermination(1, TimeUnit.MINUTES);

        /*
        When:
        - All running tasks finish
        - Queue becomes empty
        - Threads exit

        State becomes TERMINATED
        */

        System.out.println("\nState after all tasks finished:");
        printState(executor);

        /*
        ===========================================================================
         6️⃣ shutdownNow() DEMO (SEPARATE EXECUTOR)
        ===========================================================================
        */

        System.out.println("\n--- shutdownNow() DEMO ---");

        ThreadPoolExecutor executor2 = new ThreadPoolExecutor(
                2,
                4,
                5,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3)
        );

        for (int i = 1; i <= 6; i++) {
            int taskNumber = i;

            executor2.submit(() -> {
                try {
                    System.out.println(
                            "[shutdownNow] Task " + taskNumber +
                            " started by " + Thread.currentThread().getName()
                    );
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println(
                            "[shutdownNow] Task " + taskNumber + " interrupted!"
                    );
                }
            });
        }

        Thread.sleep(2000);

        /*
        ===========================================================================
         7️⃣ shutdownNow() → RUNNING → STOP
        ===========================================================================
        */

        System.out.println("\nCalling shutdownNow()");
        List<Runnable> pendingTasks = executor2.shutdownNow();

        /*
        shutdownNow():
        ❌ Does NOT accept new tasks
        ❌ Interrupts RUNNING threads
        ❌ Removes tasks from QUEUE
        ✔ Returns list of NOT EXECUTED tasks
        */

        System.out.println("Pending (not executed) tasks count: " + pendingTasks.size());

        executor2.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("\nFinal state after shutdownNow():");
        printState(executor2);
    }

    /*
    ===========================================================================
     8️⃣ HELPER METHOD TO PRINT EXECUTOR STATE
    ===========================================================================
    */

    private static void printState(ThreadPoolExecutor executor) {
        System.out.println("isShutdown()    = " + executor.isShutdown());
        System.out.println("isTerminated()  = " + executor.isTerminated());
        System.out.println("isTerminating()= " + executor.isTerminating());
        System.out.println("Active Threads = " + executor.getActiveCount());
        System.out.println("Queued Tasks   = " + executor.getQueue().size());
        System.out.println("--------------------------------------------------");
    }
}

/*
===============================================================================
 9️⃣ INTERVIEW QUESTIONS & ANSWERS
===============================================================================

Q1: What is the default state of ThreadPoolExecutor?
→ RUNNING

Q2: Difference between shutdown() and shutdownNow()?
→ shutdown(): graceful, completes tasks
→ shutdownNow(): forceful, interrupts threads

Q3: Will shutdown() stop running threads?
→ NO

Q4: Will shutdownNow() stop running threads?
→ YES (interrupts them)

Q5: When does TERMINATED state occur?
→ When all threads stop AND queue is empty

Q6: Can we submit tasks after shutdown()?
→ NO (RejectedExecutionException)

Q7: Which method should be used in production?
→ shutdown() (graceful)

===============================================================================
 END OF FILE
===============================================================================
*/
