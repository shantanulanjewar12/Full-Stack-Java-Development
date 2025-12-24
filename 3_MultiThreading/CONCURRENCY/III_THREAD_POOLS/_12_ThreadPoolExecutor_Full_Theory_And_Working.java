package CONCURRENCY.III_THREAD_POOLS;
import java.util.concurrent.*;

/**
 * =============================================================================
 * THREAD POOL EXECUTOR – COMPLETE THEORY + INTERNAL WORKING
 * =============================================================================
 *
 * This file is a SINGLE SOURCE OF TRUTH for ThreadPoolExecutor.
 *
 * It is created by analyzing:
 *  ✔ All images shared
 *  ✔ All green & yellow highlighted notes
 *  ✔ All diagrams (queue + threads + rejection)
 *  ✔ All interview questions
 *
 * -----------------------------------------------------------------------------
 * WHAT THIS FILE CONTAINS
 * -----------------------------------------------------------------------------
 * 1. What is Thread Pool
 * 2. Why Thread Pool is needed
 * 3. Executor Framework hierarchy
 * 4. ThreadPoolExecutor constructor (ALL parameters)
 * 5. Internal working step-by-step (diagram logic)
 * 6. BlockingQueue types
 * 7. corePoolSize vs maxPoolSize
 * 8. keepAliveTime & allowCoreThreadTimeOut
 * 9. ThreadFactory
 * 10. RejectedExecutionHandler (ALL policies)
 * 11. execute() vs submit()
 * 12. Interview formula for thread calculation
 * 13. Complete example with explanation
 *
 * =============================================================================
 */
public class _12_ThreadPoolExecutor_Full_Theory_And_Working {

    public static void main(String[] args) {

        /*
         * =========================================================================
         * STEP 1: WHAT IS A THREAD POOL?
         * =========================================================================
         *
         * - ThreadPool is a collection of reusable worker threads.
         * - Threads are created once and reused for multiple tasks.
         * - Tasks are submitted to a queue.
         * - Threads pick tasks from the queue and execute them.
         *
         * BENEFITS:
         * - Saves thread creation time
         * - Reduces context switching
         * - Better performance
         * - Controlled concurrency
         */

        /*
         * =========================================================================
         * STEP 2: THREAD POOL EXECUTOR CONSTRUCTOR
         * =========================================================================
         *
         * public ThreadPoolExecutor(
         *      int corePoolSize,
         *      int maximumPoolSize,
         *      long keepAliveTime,
         *      TimeUnit unit,
         *      BlockingQueue<Runnable> workQueue,
         *      ThreadFactory threadFactory,
         *      RejectedExecutionHandler handler
         * )
         */

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3,                                  // corePoolSize
                5,                                  // maximumPoolSize
                5,                                  // keepAliveTime
                TimeUnit.SECONDS,                   // time unit
                new ArrayBlockingQueue<>(5),        // BlockingQueue
                new CustomThreadFactory(),           // ThreadFactory
                new ThreadPoolExecutor.AbortPolicy() // Rejection policy
        );

        /*
         * =========================================================================
         * STEP 3: allowCoreThreadTimeOut
         * =========================================================================
         *
         * By default:
         * - Core threads NEVER die (even if idle)
         *
         * When set to TRUE:
         * - Core threads also die after keepAliveTime if idle
         */
        executor.allowCoreThreadTimeOut(true);

        /*
         * =========================================================================
         * STEP 4: INTERNAL WORKING (VERY IMPORTANT – INTERVIEW)
         * =========================================================================
         *
         * When a task is submitted:
         *
         * 1️⃣ If active threads < corePoolSize
         *    → Create new thread and execute task
         *
         * 2️⃣ Else if queue is NOT full
         *    → Put task into queue
         *
         * 3️⃣ Else if active threads < maximumPoolSize
         *    → Create extra thread and execute task
         *
         * 4️⃣ Else
         *    → Reject task using RejectedExecutionHandler
         */

        /*
         * =========================================================================
         * STEP 5: SUBMIT TASKS
         * =========================================================================
         */
        for (int i = 1; i <= 15; i++) {
            final int taskId = i;

            try {
                executor.execute(() -> {
                    System.out.println(
                            "Task-" + taskId +
                            " executed by " +
                            Thread.currentThread().getName()
                    );
                    try {
                        Thread.sleep(3000); // simulate work
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            } catch (RejectedExecutionException e) {
                System.out.println("Task-" + taskId + " REJECTED ❌");
            }
        }

        /*
         * =========================================================================
         * STEP 6: SHUTDOWN
         * =========================================================================
         *
         * shutdown():
         * - Stops accepting new tasks
         * - Allows existing tasks to complete
         */
        executor.shutdown();
    }
}

/**
 * =============================================================================
 * THREAD FACTORY
 * =============================================================================
 *
 * WHY ThreadFactory?
 * - Custom thread names
 * - Set priority
 * - Set daemon flag
 * - Debugging & monitoring
 */
class CustomThreadFactory implements ThreadFactory {

    private int count = 1;

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setName("Worker-Thread-" + count++);
        t.setPriority(Thread.NORM_PRIORITY);
        t.setDaemon(false);
        return t;
    }
}

/*
 * =============================================================================
 * THEORY SECTION (NO CODE)
 * =============================================================================
 *
 * -------------------------
 * corePoolSize
 * -------------------------
 * - Minimum threads always kept alive
 * - Created eagerly
 * - Even if idle, they stay alive (unless allowCoreThreadTimeOut = true)
 *
 * -------------------------
 * maximumPoolSize
 * -------------------------
 * - Maximum allowed threads
 * - Used ONLY when queue is full
 *
 * -------------------------
 * keepAliveTime
 * -------------------------
 * - Time after which idle threads die
 * - Applies to:
 *   - Threads > corePoolSize
 *   - Core threads if allowCoreThreadTimeOut(true)
 *
 * -------------------------
 * TimeUnit
 * -------------------------
 * - Unit for keepAliveTime
 * - MILLISECONDS / SECONDS / MINUTES / HOURS
 *
 * -------------------------
 * BlockingQueue
 * -------------------------
 * Used to store tasks before execution.
 *
 * Bounded Queue:
 * - ArrayBlockingQueue (fixed size)
 * - Prevents memory leak
 * - Can cause rejection
 *
 * Unbounded Queue:
 * - LinkedBlockingQueue
 * - No rejection
 * - Risk of OutOfMemoryError
 *
 * -------------------------
 * RejectedExecutionHandler
 * -------------------------
 *
 * AbortPolicy:
 * - Throws RejectedExecutionException
 *
 * CallerRunsPolicy:
 * - Caller thread executes the task
 *
 * DiscardPolicy:
 * - Silently drops task
 *
 * DiscardOldestPolicy:
 * - Drops oldest queued task
 *
 * -------------------------
 * execute() vs submit()
 * -------------------------
 *
 * execute():
 * - No return value
 * - Exception kills thread
 *
 * submit():
 * - Returns Future
 * - Exception captured inside Future
 *
 * -------------------------
 * INTERVIEW FORMULA
 * -------------------------
 *
 * Threads = CPU_CORES * (1 + WAIT_TIME / PROCESSING_TIME)
 *
 * Example:
 * CPU = 4
 * Wait = 10ms
 * Process = 100ms
 *
 * Threads = 4 * (1 + 0.1) ≈ 5
 *
 * ⚠ This formula does NOT consider memory.
 * Memory must be considered separately.
 *
 * =============================================================================
 * END OF FILE
 * =============================================================================
 */
