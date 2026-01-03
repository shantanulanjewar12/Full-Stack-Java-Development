package CONCURRENCY;


import java.util.concurrent.*;

/**
 * ==============================================================
 * ExecutorAndCompletableFutureNotes.java
 * ==============================================================
 *
 * This file is a COMPLETE STEP-BY-STEP guide for:
 *
 * 1. ExecutorService
 * 2. ThreadPoolExecutor (ALL parameters explained)
 * 3. Fixed, Cached, SingleThread Executors
 * 4. ThreadPoolExecutor Lifecycle
 * 5. Future & Callable
 * 6. CompletableFuture (ALL major methods)
 * 7. Work-Stealing Pool (ForkJoinPool)
 *
 * This file is suitable for:
 *  - Notes
 *  - Concept clarity
 *  - Interview preparation
 *  - Practical execution
 *
 * ==============================================================
 */
public class _IV_ExecutorAndCompletableFutureNotes {

    /* ==========================================================
     * 1. WHY EXECUTOR FRAMEWORK?
     * ==========================================================
     *
     * Problems with old Thread creation:
     *  - Thread creation is expensive
     *  - No reuse
     *  - No control on max threads
     *  - Hard to manage lifecycle
     *
     * Executor framework solves:
     *  - Thread reuse
     *  - Task queueing
     *  - Lifecycle management
     *  - Better performance
     */

    public static void main(String[] args) throws Exception {

        /* ==========================================================
         * 2. THREADPOOLEXECUTOR (CORE CONCEPT)
         * ==========================================================
         *
         * Constructor:
         *
         * ThreadPoolExecutor(
         *   int corePoolSize,
         *   int maximumPoolSize,
         *   long keepAliveTime,
         *   TimeUnit unit,
         *   BlockingQueue<Runnable> workQueue,
         *   ThreadFactory threadFactory,
         *   RejectedExecutionHandler handler
         * )
         */

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,                          // corePoolSize
                4,                          // maximumPoolSize
                1,                          // keepAliveTime
                TimeUnit.MINUTES,           // unit
                new ArrayBlockingQueue<>(2),// workQueue
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        executor.close();

        /*
         * corePoolSize:
         *  - Minimum number of threads
         *  - Created eagerly
         *  - Stay alive even if idle
         *
         * maximumPoolSize:
         *  - Max threads allowed
         *  - New threads created ONLY when:
         *      core threads busy + queue full
         *
         * keepAliveTime:
         *  - Time extra threads (beyond core) stay alive
         *
         * BlockingQueue:
         *  - Holds tasks before execution
         *
         * RejectedExecutionHandler:
         *  - What happens when pool + queue is full
         */

        executor.allowCoreThreadTimeOut(true);

        for (int i = 1; i <= 6; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Executing task " + taskId +
                        " by " + Thread.currentThread().getName());
                sleep(2000);
            });
        }

        executor.shutdown();

        /* ==========================================================
         * 3. THREADPOOLEXECUTOR LIFECYCLE
         * ==========================================================
         *
         * RUNNING  -> accepts new tasks
         * SHUTDOWN -> no new tasks, completes existing
         * STOP     -> interrupts running tasks
         * TERMINATED -> all tasks finished
         */

        /* ==========================================================
         * 4. EXECUTOR TYPES
         * ==========================================================
         */

        // FIXED THREAD POOL
        ExecutorService fixedPool = Executors.newFixedThreadPool(3);
        fixedPool.submit(() -> System.out.println("Fixed pool task"));
        fixedPool.shutdown();

        /*
         * FixedThreadPool:
         *  - core = max
         *  - Unbounded queue
         *  - Threads never die
         *  - Use when number of tasks is known
         */

        // CACHED THREAD POOL
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        cachedPool.submit(() -> System.out.println("Cached pool task"));
        cachedPool.shutdown();

        /*
         * CachedThreadPool:
         *  - core = 0
         *  - max = Integer.MAX_VALUE
         *  - Threads die after 60 sec idle
         *  - Good for bursty short tasks
         */

        // SINGLE THREAD EXECUTOR
        ExecutorService singlePool = Executors.newSingleThreadExecutor();
        singlePool.submit(() -> System.out.println("Single thread task"));
        singlePool.shutdown();

        /*
         * SingleThreadExecutor:
         *  - One worker thread
         *  - Tasks executed sequentially
         *  - No concurrency
         */

        /* ==========================================================
         * 5. FUTURE & CALLABLE
         * ==========================================================
         */

        ExecutorService futurePool = Executors.newSingleThreadExecutor();

        Callable<String> callableTask = () -> {
            sleep(3000);
            return "Callable Result";
        };

        Future<String> future = futurePool.submit(callableTask);

        System.out.println("Is Done? " + future.isDone());
        System.out.println("Result: " + future.get());
        System.out.println("Is Done? " + future.isDone());

        futurePool.shutdown();

        /*
         * Future methods:
         *  - get()
         *  - get(timeout)
         *  - isDone()
         *  - isCancelled()
         *  - cancel()
         */

        /* ==========================================================
         * 6. COMPLETABLEFUTURE
         * ==========================================================
         *
         * Advanced Future introduced in Java 8
         * Supports:
         *  - Chaining
         *  - Async pipelines
         *  - Non-blocking execution
         */

        ExecutorService cfExecutor = Executors.newFixedThreadPool(2);

        CompletableFuture<String> cf =
                CompletableFuture
                        .supplyAsync(() -> {
                            System.out.println("supplyAsync thread: " +
                                    Thread.currentThread().getName());
                            return "Concept and ";
                        }, cfExecutor)

                        .thenApply(val -> {
                            System.out.println("thenApply thread: " +
                                    Thread.currentThread().getName());
                            return val + "Coding";
                        });

        System.out.println("CompletableFuture result: " + cf.get());

        /*
         * thenApply:
         *  - Synchronous
         *  - Runs in same thread
         */

        CompletableFuture<String> cfAsync =
                CompletableFuture
                        .supplyAsync(() -> "Hello ", cfExecutor)
                        .thenApplyAsync(val -> val + "World");

        System.out.println(cfAsync.get());

        /*
         * thenApplyAsync:
         *  - Asynchronous
         *  - Uses ForkJoinPool or given executor
         */

        /* ==========================================================
         * 7. thenCompose vs thenCombine
         * ==========================================================
         */

        CompletableFuture<String> compose =
                CompletableFuture
                        .supplyAsync(() -> "Java ")
                        .thenCompose(val ->
                                CompletableFuture.supplyAsync(() -> val + "Concurrency")
                        );

        System.out.println(compose.get());

        /*
         * thenCompose:
         *  - Dependent async tasks
         *  - Flattening
         */

        CompletableFuture<Integer> f1 =
                CompletableFuture.supplyAsync(() -> 10);

        CompletableFuture<String> f2 =
                CompletableFuture.supplyAsync(() -> "K");

        CompletableFuture<String> combined =
                f1.thenCombine(f2, (a, b) -> a + b);

        System.out.println(combined.get());

        /*
         * thenCombine:
         *  - Combine independent futures
         */

        /* ==========================================================
         * 8. thenAccept (Terminal operation)
         * ==========================================================
         */

        CompletableFuture
                .supplyAsync(() -> "All Done")
                .thenAccept(val -> System.out.println(val));

        /*
         * thenAccept:
         *  - Terminal stage
         *  - No return value
         */

        /* ==========================================================
         * 9. WORK STEALING POOL (FORK JOIN)
         * ==========================================================
         */

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        Future<Integer> sumResult =
                forkJoinPool.submit(new SumTask(1, 100));

        System.out.println("ForkJoin Result: " + sumResult.get());
    }

    /* ==========================================================
     * ForkJoin RecursiveTask Example
     * ==========================================================
     */

    static class SumTask extends RecursiveTask<Integer> {
        int start, end;

        SumTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if (end - start <= 10) {
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

    static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }
}

