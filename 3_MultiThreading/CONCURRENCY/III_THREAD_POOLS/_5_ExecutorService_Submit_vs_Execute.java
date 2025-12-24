package CONCURRENCY.III_THREAD_POOLS;

import java.util.concurrent.*;

/*
====================================================================
5. ExecutorService – submit() vs execute()
====================================================================

This file explains:
✔ execute()
✔ submit()
✔ Future
✔ Exception handling differences
✔ Return values
✔ Best practices

--------------------------------------------------------------------
WHY THIS TOPIC IS IMPORTANT?
--------------------------------------------------------------------

This question is asked in:
✔ Java interviews
✔ Backend interviews
✔ Spring Boot interviews
✔ Production debugging

Most developers KNOW submit() and execute(),
but DO NOT know the REAL differences.

--------------------------------------------------------------------
BASIC DIFFERENCE
--------------------------------------------------------------------

execute(Runnable):
------------------
- Fire-and-forget
- No return value
- Exception is thrown to UncaughtExceptionHandler

submit(Runnable / Callable):
----------------------------
- Returns Future
- Exception is CAPTURED inside Future
- Caller must explicitly check Future

====================================================================
*/

public class _5_ExecutorService_Submit_vs_Execute {

    /*
    ------------------------------------------------
    TASK WITH EXCEPTION
    ------------------------------------------------
    */
    static class FailingTask implements Runnable {

        private final String taskName;

        FailingTask(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public void run() {
            System.out.println(
                taskName + " started by " +
                Thread.currentThread().getName()
            );

            // Simulating exception
            throw new RuntimeException("Exception in " + taskName);
        }
    }

    /*
    ------------------------------------------------
    CALLABLE TASK (RETURNS VALUE)
    ------------------------------------------------
    */
    static class CallableTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            return "Result from " + Thread.currentThread().getName();
        }
    }

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        /*
        ============================================================
        1. execute()
        ============================================================
        */
        System.out.println("\n--- execute() example ---");

        executor.execute(new FailingTask("Execute-Task"));

        /*
        ------------------------------------------------------------
        What happens?
        ------------------------------------------------------------
        - Task runs
        - Exception is NOT returned to caller
        - JVM prints stack trace
        - Caller CANNOT catch exception
        */

        /*
        ============================================================
        2. submit(Runnable)
        ============================================================
        */
        System.out.println("\n--- submit(Runnable) example ---");

        Future<?> future1 = executor.submit(new FailingTask("Submit-Runnable-Task"));

        try {
            /*
            IMPORTANT:
            ---------
            - get() blocks
            - Exception is wrapped inside ExecutionException
            */
            future1.get();
        } catch (ExecutionException e) {
            System.out.println("Exception caught from submit(Runnable): "
                    + e.getCause());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        /*
        ============================================================
        3. submit(Callable)
        ============================================================
        */
        System.out.println("\n--- submit(Callable) example ---");

        Future<String> future2 = executor.submit(new CallableTask());

        try {
            String result = future2.get();
            System.out.println("Callable result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        /*
        ============================================================
        SHUTDOWN
        ============================================================
        */
        executor.shutdown();

        System.out.println("\nMain thread finished");
    }
}

/*
====================================================================
OUTPUT (POSSIBLE)
====================================================================

--- execute() example ---
Execute-Task started by pool-1-thread-1
Exception in thread "pool-1-thread-1" java.lang.RuntimeException:
Exception in Execute-Task

--- submit(Runnable) example ---
Submit-Runnable-Task started by pool-1-thread-2
Exception caught from submit(Runnable):
java.lang.RuntimeException: Exception in Submit-Runnable-Task

--- submit(Callable) example ---
Callable result: Result from pool-1-thread-1

Main thread finished

====================================================================
KEY DIFFERENCES (VERY IMPORTANT)
====================================================================

| Feature               | execute()        | submit()          |
|----------------------|------------------|-------------------|
| Return value         | ❌ No             | ✔ Future          |
| Exception handling   | JVM prints       | Captured in Future|
| Caller can catch ex? | ❌ No             | ✔ Yes             |
| Supports Callable?   | ❌ No             | ✔ Yes             |
| Fire-and-forget      | ✔ Yes            | ❌ No              |

====================================================================
INTERVIEW QUESTIONS & ANSWERS
====================================================================

Q1: Which one should you use in production?
A:
✔ submit() – because:
- You can track completion
- You can handle exceptions
- You can get result

Q2: Why execute() exists if submit() is better?
A:
- execute() is lightweight
- Used when result & error tracking is NOT needed

Q3: What happens if you don’t call Future.get()?
A:
- Exception is SILENTLY swallowed
- VERY dangerous bug

Q4: Can submit() accept Runnable?
A:
✔ Yes
- But return type is Future<?>

Q5: Which one is preferred in frameworks like Spring?
A:
✔ submit()

====================================================================
REAL-WORLD BEST PRACTICE
====================================================================

✔ Use submit() in:
- Backend services
- Async APIs
- Microservices
- Critical systems

✔ Use execute() only when:
- Logging tasks
- Monitoring tasks
- Fire-and-forget operations

====================================================================
NEXT FILE
====================================================================

6_ThreadPoolExecutor_Core_Parameters.java
- corePoolSize
- maxPoolSize
- keepAliveTime
- Queue behavior
- Interview formulas

====================================================================
*/
