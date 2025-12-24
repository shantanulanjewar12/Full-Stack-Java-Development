package CONCURRENCY;

import java.util.concurrent.*;

/*
 ============================================================================
 THREAD POOLS, EXECUTORS, COMPLETABLE FUTURE – MASTER NOTES FILE
 ============================================================================
 This file is written as:
 1. Step-by-step theory
 2. Internal working explanation
 3. Code examples
 4. Interview-ready notes

 You DO NOT need to run everything.
 Read section by section like a BOOK.
 ============================================================================
*/

public class _V_ThreadPoolAndAsync {

    /*
     ============================================================================
     1. WHAT IS A THREAD POOL?
     ============================================================================
     - A Thread Pool is a collection of reusable worker threads.
     - Instead of creating a new thread for every task, we reuse threads.
     - Improves performance
     - Avoids memory overhead
     */

    /*
     ============================================================================
     2. THREADPOOLEXECUTOR (CORE CLASS)
     ============================================================================
     Constructor:

     ThreadPoolExecutor(
        int corePoolSize,
        int maximumPoolSize,
        long keepAliveTime,
        TimeUnit unit,
        BlockingQueue<Runnable> workQueue,
        ThreadFactory threadFactory,
        RejectedExecutionHandler handler
     )
     */

    /*
     ----------------------------
     corePoolSize
     ----------------------------
     - Minimum number of threads kept alive in the pool
     - Threads remain alive even if idle
     - Created eagerly when tasks arrive

     Example:
     corePoolSize = 2
     → At least 2 threads will always exist
     */

    /*
     ----------------------------
     maximumPoolSize
     ----------------------------
     - Maximum allowed threads in the pool
     - Used when:
       1) core threads are busy
       2) queue is FULL

     If queue is unbounded → maxPoolSize is IGNORED
     */

    /*
     ----------------------------
     keepAliveTime
     ----------------------------
     - Time after which EXTRA threads (above corePoolSize) die
     - Works only when:
       allowCoreThreadTimeOut = true (for core threads)

     Example:
     keepAliveTime = 60 seconds
     */

    /*
     ----------------------------
     TimeUnit
     ----------------------------
     - Unit for keepAliveTime
     - Examples:
       TimeUnit.SECONDS
       TimeUnit.MILLISECONDS
     */

    /*
     ----------------------------
     BlockingQueue
     ----------------------------
     Holds tasks before execution

     Types:
     1) ArrayBlockingQueue (bounded)
     2) LinkedBlockingQueue (unbounded)
     3) SynchronousQueue (size = 0)
     */

    /*
     ----------------------------
     ThreadFactory
     ----------------------------
     - Used to customize threads
     - Set:
       - Thread name
       - Priority
       - Daemon flag
     */

    /*
     ----------------------------
     RejectedExecutionHandler
     ----------------------------
     Called when:
     - Pool is full
     - Queue is full
     - maxPoolSize reached

     Types:
     1) AbortPolicy (default) → throws exception
     2) CallerRunsPolicy → caller thread runs task
     3) DiscardPolicy → silently discard
     4) DiscardOldestPolicy → discard oldest queued task
     */

    /*
     ============================================================================
     3. THREADPOOLEXECUTOR LIFECYCLE
     ============================================================================
     RUNNING → SHUTDOWN → TERMINATED
             → STOP     → TERMINATED
     */

    /*
     shutdown():
     - No new tasks accepted
     - Already submitted tasks continue
     */

    /*
     shutdownNow():
     - Interrupt running tasks
     - Returns list of waiting tasks
     */

    /*
     awaitTermination():
     - Blocks calling thread
     - Waits for shutdown completion
     */

    static void shutdownExample() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> System.out.println("Task running"));

        executor.shutdown();

        executor.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Executor terminated");
    }

    /*
     ============================================================================
     4. EXECUTOR TYPES
     ============================================================================
     */

    /*
     ----------------------------
     FixedThreadPool
     ----------------------------
     - corePoolSize == maxPoolSize
     - Unbounded queue
     - Threads never die

     Use when:
     - Fixed number of tasks
     */

    /*
     ----------------------------
     CachedThreadPool
     ----------------------------
     - core = 0
     - max = Integer.MAX_VALUE
     - Threads die after 60 seconds

     Use when:
     - Short-lived bursty tasks

     Danger:
     - Can create TOO MANY threads
     */

    /*
     ----------------------------
     SingleThreadExecutor
     ----------------------------
     - Only ONE worker thread
     - Tasks executed sequentially

     Use when:
     - Order matters
     */

    /*
     ----------------------------
     WorkStealingPool (ForkJoinPool)
     ----------------------------
     - Uses ForkJoin framework
     - Each thread has its own deque
     - Idle threads steal tasks

     Used for:
     - Divide & conquer problems
     */

    /*
     ============================================================================
     5. FORK JOIN EXAMPLE
     ============================================================================
     */

    static class SumTask extends RecursiveTask<Integer> {
        int start, end;

        SumTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if (end - start <= 4) {
                int sum = 0;
                for (int i = start; i <= end; i++) sum += i;
                return sum;
            }
            int mid = (start + end) / 2;
            SumTask left = new SumTask(start, mid);
            SumTask right = new SumTask(mid + 1, end);
            left.fork();
            return right.compute() + left.join();
        }
    }

    /*
     ============================================================================
     6. FUTURE vs CALLABLE
     ============================================================================
     Runnable → no return
     Callable → returns value + throws exception
     */

    /*
     ============================================================================
     7. COMPLETABLE FUTURE
     ============================================================================
     */

    /*
     supplyAsync() → returns value
     runAsync() → no return
     */

    /*
     thenCompose():
     - Used for DEPENDENT async tasks
     - Flattens nested futures
     */

    /*
     thenCombine():
     - Combine results of TWO independent futures
     */

    /*
     thenAccept():
     - Terminal stage
     - Consumes result
     */

    static void completableFutureExamples() {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        CompletableFuture<String> cf =
                CompletableFuture.supplyAsync(() -> "Concept ", executor)
                        .thenCompose(val ->
                                CompletableFuture.supplyAsync(() -> val + "Coding", executor))
                        .thenApply(String::toUpperCase);

        System.out.println(cf.join());
        executor.shutdown();
    }

    /*
     ============================================================================
     8. SCHEDULED THREAD POOL
     ============================================================================
     */

    static void scheduledExecutorExample() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.schedule(() -> System.out.println("Runs once"), 3, TimeUnit.SECONDS);

        scheduler.scheduleAtFixedRate(
                () -> System.out.println("Fixed Rate"),
                1, 2, TimeUnit.SECONDS
        );

        scheduler.scheduleWithFixedDelay(
                () -> System.out.println("Fixed Delay"),
                1, 2, TimeUnit.SECONDS
        );
    }

    /*
     ============================================================================
     9. THREADLOCAL
     ============================================================================
     - Each thread gets its own copy of variable
     - Used in:
       - Transaction IDs
       - User session
     */

    static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    /*
     ============================================================================
     10. VIRTUAL THREAD vs PLATFORM THREAD
     ============================================================================
     Platform Thread:
     - OS thread
     - Heavy

     Virtual Thread (Java 21):
     - Lightweight
     - Millions possible
     - Best for I/O tasks
     */

    /*
     ============================================================================
     11. INTERVIEW GOLD QUESTIONS
     ============================================================================
     Q1: Difference between shutdown & shutdownNow?
     Q2: Why LinkedBlockingQueue ignores maxPoolSize?
     Q3: When to use thenCompose vs thenCombine?
     Q4: Why ForkJoinPool is fast?
     Q5: Why CachedThreadPool is dangerous?
     */

    public static void main(String[] args) throws Exception {
        shutdownExample();
        completableFutureExamples();
    }
}

