package CONCURRENCY.III_THREAD_POOLS;

/*
====================================================================
2. OLD WAY OF THREAD CREATION – PROBLEMS
====================================================================

OLD WAY:
--------
new Thread().start();

This approach looks simple but creates MANY problems in real systems.

--------------------------------------------------------------------
WHAT HAPPENS INTERNALLY WHEN A THREAD IS CREATED?
--------------------------------------------------------------------
For every new Thread:
1. Memory is allocated
   - Stack memory
   - Program Counter
   - Native OS thread resources
2. Thread lifecycle is managed by JVM + OS
3. Context switching overhead increases
4. Thread termination cleanup happens

All these steps are EXPENSIVE.

--------------------------------------------------------------------
PROBLEMS WITH OLD WAY (new Thread for every task)
--------------------------------------------------------------------

1️⃣ THREAD CREATION COST
-----------------------
- Creating a thread is NOT free.
- Each thread consumes:
  - Memory
  - CPU cycles
- Repeating this for thousands of tasks wastes resources.

2️⃣ NO THREAD REUSE
------------------
- Once a task is completed, the thread is destroyed.
- Next task → new thread again.
- No reuse → poor performance.

3️⃣ POOR SCALABILITY
-------------------
- If 1000 requests arrive → 1000 threads created.
- System may:
  - Run out of memory
  - Crash JVM
  - Become unresponsive

4️⃣ NO CONTROL OVER CONCURRENCY
------------------------------
- Cannot limit how many threads run simultaneously.
- All tasks try to execute at once.
- Leads to CPU thrashing.

5️⃣ EXCESSIVE CONTEXT SWITCHING
------------------------------
- Too many threads → CPU switches between them.
- More switching, less actual work.

6️⃣ MANUAL THREAD MANAGEMENT
----------------------------
- Developer must:
  - Create threads
  - Start threads
  - Join threads
  - Handle exceptions
- Very error-prone.

7️⃣ NO CENTRALIZED TASK MANAGEMENT
---------------------------------
- No task queue
- No scheduling control
- No monitoring

--------------------------------------------------------------------
REAL-WORLD SCENARIO
--------------------------------------------------------------------
Imagine a web server:
- 1 request = 1 thread
- 10,000 concurrent users
- JVM tries to create 10,000 threads ❌
→ System crash

--------------------------------------------------------------------
CODE EXAMPLE (OLD STYLE)
--------------------------------------------------------------------
*/

public class _2_Old_Way_Thread_Creation_Problem {

    // Task definition
    static class MyTask extends Thread {

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
                // Simulate work
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        /*
        --------------------------------------------
        Creating a NEW THREAD for EACH task
        --------------------------------------------
        */

        for (int i = 1; i <= 20; i++) {
            new MyTask(i).start();
        }

        /*
        OUTPUT:
        -------
        Many threads created:
        Thread-0
        Thread-1
        Thread-2
        ...
        Thread-19

        PROBLEM:
        --------
        - Each task creates a new thread
        - No reuse
        - No limit
        - Not scalable
        */
    }
}
