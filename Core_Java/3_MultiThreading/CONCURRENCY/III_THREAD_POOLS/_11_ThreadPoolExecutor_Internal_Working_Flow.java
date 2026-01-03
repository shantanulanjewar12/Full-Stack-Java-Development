package CONCURRENCY.III_THREAD_POOLS;
import java.util.concurrent.*;

/**
 * Demonstrates INTERNAL WORKING of ThreadPoolExecutor
 *
 * Flow (IMPORTANT – Interview logic):
 *
 * 1️⃣ If running threads < corePoolSize
 *     → Create NEW thread and assign task
 *
 * 2️⃣ Else if queue NOT full
 *     → Put task into queue
 *
 * 3️⃣ Else if running threads < maximumPoolSize
 *     → Create EXTRA thread and assign task
 *
 * 4️⃣ Else
 *     → Reject task (RejectedExecutionHandler)
 */
public class _11_ThreadPoolExecutor_Internal_Working_Flow {

    public static void main(String[] args) {

        int corePoolSize = 3;      // Minimum threads
        int maxPoolSize = 5;       // Maximum threads
        int queueCapacity = 5;     // Queue size
        long keepAliveTime = 5;    // seconds

        BlockingQueue<Runnable> workQueue =
                new ArrayBlockingQueue<>(queueCapacity);

        ThreadFactory threadFactory = new CustomThreadFactory();

        RejectedExecutionHandler rejectedHandler =
                new CustomRejectedExecutionHandler();

        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(
                        corePoolSize,
                        maxPoolSize,
                        keepAliveTime,
                        TimeUnit.SECONDS,
                        workQueue,
                        threadFactory,
                        rejectedHandler
                );

        // Allow core threads to die if idle
        executor.allowCoreThreadTimeOut(true);

        System.out.println("=== Submitting Tasks ===");

        // Submit more tasks than pool + queue can handle
        for (int i = 1; i <= 15; i++) {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println(
                        "Task " + taskId +
                        " executed by " +
                        Thread.currentThread().getName()
                );
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
    }

    // ---------------- THREAD FACTORY ----------------
    static class CustomThreadFactory implements ThreadFactory {
        private int count = 1;

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName("Worker-Thread-" + count++);
            System.out.println("🆕 Creating " + t.getName());
            return t;
        }
    }

    // ---------------- REJECTED HANDLER ----------------
    static class CustomRejectedExecutionHandler
            implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r,
                                      ThreadPoolExecutor executor) {

            System.out.println(
                    "❌ Task REJECTED | ActiveThreads="
                    + executor.getActiveCount()
                    + " | QueueSize="
                    + executor.getQueue().size()
            );
        }
    }
}


// Output
/*
🆕 Creating Worker-Thread-1
🆕 Creating Worker-Thread-2
🆕 Creating Worker-Thread-3
(Task 1–3 running)

(Task 4–8 queued)

🆕 Creating Worker-Thread-4
🆕 Creating Worker-Thread-5
(Task 9–10 running)

❌ Task REJECTED
❌ Task REJECTED
...

*/