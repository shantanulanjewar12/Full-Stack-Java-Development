/*
================================================================================
 COMPLETE JAVA CONCURRENCY GUIDE (SINGLE FILE)
================================================================================
Author  : Generated for deep learning & revision
Purpose : This file explains, STEP-BY-STEP, the complete theory + working of:
          1. ThreadPoolExecutor (ALL parameters)
          2. ThreadPoolExecutor Lifecycle States
          3. Future interface
          4. Callable vs Runnable
          5. CompletableFuture (Java 8)
             - supplyAsync
             - thenApply / thenApplyAsync
             - thenCompose / thenComposeAsync
             - thenAccept / thenAcceptAsync
             - thenCombine / thenCombineAsync

This file is intentionally LONG and COMMENT-HEAVY.
You can read it like NOTES + CODE + OUTPUT explanation.
================================================================================
*/

import java.util.concurrent.*;

public class ThreadPool_Future_CompletableFuture {

    /*
    ============================================================================
    SECTION 1: THREAD POOL EXECUTOR – WHAT & WHY
    ============================================================================

    PROBLEM WITH CREATING THREAD MANUALLY:
    -------------------------------------
    - Creating threads is EXPENSIVE
    - Too many threads => CPU context switching
    - No control over number of active threads

    SOLUTION:
    ---------
    ThreadPoolExecutor manages a POOL of reusable threads.
    You SUBMIT tasks, executor DECIDES:
    - When to create thread
    - When to reuse thread
    - When to reject task

    ============================================================================
    */

    /*
    ============================================================================
    SECTION 2: ThreadPoolExecutor CONSTRUCTOR PARAMETERS (VERY IMPORTANT)
    ============================================================================

    ThreadPoolExecutor(
        int corePoolSize,
        int maximumPoolSize,
        long keepAliveTime,
        TimeUnit unit,
        BlockingQueue<Runnable> workQueue,
        ThreadFactory threadFactory,
        RejectedExecutionHandler handler
    )

    ---------------------------------------------------------------------------
    1) corePoolSize:
       - Minimum number of threads kept alive in pool
       - Even if threads are IDLE

    2) maximumPoolSize:
       - Maximum number of threads allowed

    3) keepAliveTime:
       - Time after which EXTRA threads are destroyed
       - Applies to threads > corePoolSize

    4) TimeUnit:
       - Unit for keepAliveTime (SECONDS, MINUTES, HOURS)

    5) BlockingQueue:
       - Holds tasks BEFORE execution
       - ArrayBlockingQueue  -> FIXED size
       - LinkedBlockingQueue -> UNBOUNDED

    6) ThreadFactory:
       - Used to create new threads
       - Can set:
         * Thread name
         * Priority
         * Daemon flag

    7) RejectedExecutionHandler:
       - What to do when:
         * Queue is FULL
         * Max threads reached

       Policies:
       - AbortPolicy        -> throws exception
       - CallerRunsPolicy  -> caller thread runs task
       - DiscardPolicy     -> silently discard
       - DiscardOldestPolicy -> remove oldest task

    ============================================================================
    */

    static ThreadPoolExecutor createThreadPool() {
        return new ThreadPoolExecutor(
                2,                      // corePoolSize
                4,                      // maximumPoolSize
                10,                     // keepAliveTime
                TimeUnit.SECONDS,       // unit
                new ArrayBlockingQueue<>(5), // workQueue
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
    }

    /*
    ============================================================================
    SECTION 3: THREAD POOL LIFECYCLE STATES
    ============================================================================

    STATES:
    -------
    1) RUNNING
       - Accepts new tasks
       - Executes queued tasks

    2) SHUTDOWN
       - shutdown()
       - No new tasks accepted
       - Existing tasks CONTINUE

    3) STOP
       - shutdownNow()
       - Interrupts running tasks
       - Clears queue

    4) TERMINATED
       - All tasks completed
       - All threads destroyed

    FLOW:
    RUNNING -> SHUTDOWN -> TERMINATED
    RUNNING -> STOP     -> TERMINATED

    ============================================================================
    */

    /*
    ============================================================================
    SECTION 4: FUTURE INTERFACE
    ============================================================================

    WHY FUTURE?
    -----------
    When task runs ASYNC, caller wants to:
    - Check completion
    - Get result
    - Handle exception
    - Cancel task

    METHODS:
    --------
    cancel(boolean mayInterrupt)
    isCancelled()
    isDone()
    get()
    get(timeout, unit)

    ============================================================================
    */

    static void futureExample() throws Exception {
        ThreadPoolExecutor executor = createThreadPool();

        Future<?> future = executor.submit(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Task executed by: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                System.out.println("Task interrupted");
            }
        });

        System.out.println("Is Done (initial): " + future.isDone());
        future.get(); // waits
        System.out.println("Is Done (after get): " + future.isDone());

        executor.shutdown();
    }

    /*
    ============================================================================
    SECTION 5: CALLABLE vs RUNNABLE
    ============================================================================

    Runnable:
    ---------
    void run();
    - No return value
    - Cannot throw checked exception

    Callable<V>:
    ------------
    V call() throws Exception;
    - Returns value
    - Can throw exception

    ============================================================================
    */

    static void callableExample() throws Exception {
        ThreadPoolExecutor executor = createThreadPool();

        Callable<Integer> task = () -> {
            Thread.sleep(1000);
            return 100;
        };

        Future<Integer> future = executor.submit(task);
        System.out.println("Callable Result: " + future.get());

        executor.shutdown();
    }

    /*
    ============================================================================
    SECTION 6: COMPLETABLE FUTURE (JAVA 8)
    ============================================================================

    WHAT IS CompletableFuture?
    --------------------------
    - Advanced version of Future
    - Supports chaining
    - Supports async pipelines
    - Non-blocking programming

    DEFAULT EXECUTOR:
    -----------------
    ForkJoinPool.commonPool()

    ============================================================================
    */

    /*
    ============================================================================
    6.1 supplyAsync()
    ============================================================================
    - Starts async computation
    - Returns CompletableFuture<T>
    */

    static void supplyAsyncExample() throws Exception {
        ThreadPoolExecutor executor = createThreadPool();

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync thread: " + Thread.currentThread().getName());
            return "Hello";
        }, executor);

        System.out.println(cf.get());
        executor.shutdown();
    }

    /*
    ============================================================================
    6.2 thenApply vs thenApplyAsync
    ============================================================================

    thenApply:
    - SAME thread
    - Synchronous

    thenApplyAsync:
    - DIFFERENT thread
    - Asynchronous
    */

    static void thenApplyExample() throws Exception {
        ThreadPoolExecutor executor = createThreadPool();

        CompletableFuture<String> cf = CompletableFuture
                .supplyAsync(() -> "Concept ", executor)
                .thenApply(val -> val + "and Coding");

        System.out.println(cf.get());
        executor.shutdown();
    }

    /*
    ============================================================================
    6.3 thenCompose vs thenComposeAsync
    ============================================================================

    USE CASE:
    ---------
    When NEXT async task depends on PREVIOUS result

    thenCompose FLATTENS nested futures
    */

    static void thenComposeExample() throws Exception {
        ThreadPoolExecutor executor = createThreadPool();

        CompletableFuture<String> cf = CompletableFuture
                .supplyAsync(() -> "Concept ", executor)
                .thenCompose(val -> CompletableFuture.supplyAsync(() -> val + "and Coding"));

        System.out.println(cf.get());
        executor.shutdown();
    }

    /*
    ============================================================================
    6.4 thenAccept vs thenAcceptAsync
    ============================================================================

    - TERMINAL operation
    - DOES NOT return anything
    */

    static void thenAcceptExample() throws Exception {
        ThreadPoolExecutor executor = createThreadPool();

        CompletableFuture<Void> cf = CompletableFuture
                .supplyAsync(() -> "All stages", executor)
                .thenAccept(result -> System.out.println(result + " completed"));

        cf.get();
        executor.shutdown();
    }

    /*
    ============================================================================
    6.5 thenCombine vs thenCombineAsync
    ============================================================================

    USE CASE:
    ---------
    Combine TWO independent futures
    */

    static void thenCombineExample() throws Exception {
        ThreadPoolExecutor executor = createThreadPool();

        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> 10, executor);
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "K", executor);

        CompletableFuture<String> combined = f1.thenCombine(f2, (a, b) -> a + b);

        System.out.println(combined.get());
        executor.shutdown();
    }

    /*
    ============================================================================
    MAIN METHOD – EXECUTE ALL EXAMPLES
    ============================================================================
    */

    public static void main(String[] args) throws Exception {
        futureExample();
        callableExample();
        supplyAsyncExample();
        thenApplyExample();
        thenComposeExample();
        thenAcceptExample();
        thenCombineExample();
    }
}
