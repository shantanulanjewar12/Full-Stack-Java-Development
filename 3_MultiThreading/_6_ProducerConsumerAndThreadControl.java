import java.util.LinkedList;
import java.util.Queue;

/*
================================================================================
SECTION 1: WHAT IS PRODUCER–CONSUMER PROBLEM?
================================================================================

DEFINITION:
-----------
The Producer–Consumer problem is a classic MULTITHREADING problem where:

✔ One or more PRODUCER threads generate data
✔ One or more CONSUMER threads consume data
✔ Both share a COMMON BUFFER (fixed size)

RULES:
------
1) Producer MUST NOT produce if buffer is FULL
2) Consumer MUST NOT consume if buffer is EMPTY
3) Access to buffer must be THREAD-SAFE

WHY THIS PROBLEM IS IMPORTANT:
------------------------------
✔ Demonstrates synchronization
✔ Demonstrates wait() / notify()
✔ Demonstrates inter-thread communication
================================================================================
*/

/*
================================================================================
SECTION 2: SHARED RESOURCE (BUFFER)
================================================================================

We use:
- Queue<Integer> as shared buffer
- Fixed buffer size
- synchronized methods
- wait() and notify()

IMPORTANT:
----------
✔ wait() and notify() MUST be called inside synchronized context
✔ They work on MONITOR LOCK of the object

================================================================================
*/

class SharedResource {

    /*
    Shared buffer (Queue)
    */
    private final Queue<Integer> sharedBuffer;

    /*
    Maximum buffer size
    */
    private final int bufferSize;

    public SharedResource(int bufferSize) {
        this.sharedBuffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    /*
    =============================================================================
    PRODUCER METHOD
    =============================================================================
    */
    public synchronized void produce(int item) throws InterruptedException {

        /*
        If buffer is FULL, producer must WAIT
        while() is used instead of if() to avoid spurious wakeup
        */
        while (sharedBuffer.size() == bufferSize) {
            System.out.println("Buffer is FULL. Producer is waiting...");
            wait(); // releases monitor lock and goes to WAITING
        }

        /*
        Produce item
        */
        sharedBuffer.add(item);
        System.out.println("Produced: " + item);

        /*
        Notify consumer that item is available
        */
        notify();
    }

    /*
    =============================================================================
    CONSUMER METHOD
    =============================================================================
    */
    public synchronized int consume() throws InterruptedException {

        /*
        If buffer is EMPTY, consumer must WAIT
        */
        while (sharedBuffer.isEmpty()) {
            System.out.println("Buffer is EMPTY. Consumer is waiting...");
            wait(); // releases lock
        }

        /*
        Consume item
        */
        int item = sharedBuffer.poll();
        System.out.println("Consumed: " + item);

        /*
        Notify producer that space is available
        */
        notify();

        return item;
    }
}

/*
================================================================================
SECTION 3: MAIN CLASS – STARTING PRODUCER & CONSUMER THREADS
================================================================================
*/

public class _6_ProducerConsumerAndThreadControl {

    public static void main(String[] args) {

        SharedResource buffer = new SharedResource(3);

        /*
        PRODUCER THREAD
        */
        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    buffer.produce(i);
                    Thread.sleep(500);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "PRODUCER");

        /*
        CONSUMER THREAD
        */
        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    buffer.consume();
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "CONSUMER");

        producerThread.start();
        consumerThread.start();
    }
}

/*
================================================================================
SECTION 4: EXECUTION FLOW (STEP BY STEP)
================================================================================

1) Producer starts producing items
2) When buffer becomes FULL → producer calls wait()
3) Consumer consumes items
4) When buffer becomes EMPTY → consumer calls wait()
5) notify() wakes up waiting thread
6) Both threads coordinate WITHOUT data corruption

================================================================================
*/

/*
================================================================================
SECTION 5: WHY wait() / notify() ARE USED?
================================================================================

wait():
-------
✔ Releases monitor lock
✔ Puts thread into WAITING state

notify():
---------
✔ Wakes up ONE waiting thread

notifyAll():
------------
✔ Wakes up ALL waiting threads

IMPORTANT:
----------
✔ Must be called inside synchronized block/method
✔ Works on SAME monitor lock

================================================================================
*/

/*
================================================================================
SECTION 6: WHY stop(), suspend(), resume() ARE DEPRECATED?
================================================================================

STOP():
-------
❌ Terminates thread abruptly
❌ Does NOT release locks properly
❌ No cleanup → DATA CORRUPTION

SUSPEND():
----------
❌ Suspends thread without releasing lock
❌ Other threads may wait forever → DEADLOCK

RESUME():
---------
❌ Can resume wrong thread order
❌ Unpredictable behavior

CONCLUSION:
-----------
These methods are UNSAFE → hence deprecated.

================================================================================
*/

/*
================================================================================
SECTION 7: SAFE ALTERNATIVES TO stop/suspend
================================================================================

✔ Use interrupt()
✔ Use boolean flags
✔ Use wait()/notify()
✔ Use Executor framework

================================================================================
*/

/*
================================================================================
SECTION 8: JOIN() METHOD
================================================================================

join():
-------
✔ Makes CURRENT thread wait until target thread finishes
✔ Used for thread coordination

Example:
--------
t1.join(); // main waits for t1

================================================================================
*/

/*
================================================================================
SECTION 9: THREAD PRIORITY
================================================================================

Priority Range:
---------------
1  → MIN_PRIORITY
5  → NORM_PRIORITY (default)
10 → MAX_PRIORITY

Important Notes:
----------------
✔ Priority is just a HINT to scheduler
✔ Execution order is NOT guaranteed
✔ Child thread inherits parent priority

Setting priority:
-----------------
thread.setPriority(8);

================================================================================
*/

/*
================================================================================
SECTION 10: DAEMON THREAD
================================================================================

Daemon Thread:
--------------
Demon threads are BACKGROUND threads that provide services to user threads.
✔ Runs in background
✔ JVM exits when ONLY daemon threads are left

Examples:
---------
✔ Garbage Collector
✔ Background cleanup tasks

Setting daemon:
---------------
thread.setDaemon(true);

IMPORTANT:
----------
Must be set BEFORE start()

================================================================================
*/

/*
================================================================================
SECTION 11: INTERVIEW QUESTIONS (VERY IMPORTANT)
================================================================================

Q1: Why while() instead of if() in wait?
A: To handle spurious wakeups.

Q2: Does wait() release lock?
A: Yes.

Q3: Does sleep() release lock?
A: No.

Q4: Why stop() is deprecated?
A: Unsafe, causes data inconsistency.

Q5: What happens if notify() is called without wait()?
A: Nothing happens.

Q6: Difference between notify() and notifyAll()?
A: notify wakes one, notifyAll wakes all.

================================================================================
*/

/*
================================================================================
SECTION 12: KEY INTERVIEW ONE-LINERS
================================================================================

✔ Producer–Consumer uses wait/notify for coordination
✔ wait() releases lock, sleep() does not
✔ stop/suspend are deprecated due to deadlock risk
✔ Thread priority is not a guarantee
✔ Daemon threads die when JVM exits
✔ join() is used for thread synchronization

================================================================================
END OF FILE
================================================================================
*/
