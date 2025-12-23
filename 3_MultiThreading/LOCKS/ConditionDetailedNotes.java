package LOCKS;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
================================================================================
              CONDITION INTERFACE – COMPLETE DETAILED NOTES
================================================================================
*/

/*
================================================================================
1. WHY CONDITION INTERFACE WAS INTRODUCED?
================================================================================

Before Java 5, inter-thread communication was done using:
--------------------------------------------------------
✔ wait()
✔ notify()
✔ notifyAll()

These methods:
----------------
❌ Belong to Object class
❌ Work only with synchronized blocks
❌ Allow only ONE waiting queue per object
❌ Hard to manage complex conditions

Java 5 introduced:
------------------
➡ Lock & Condition interfaces

They provide:
--------------
✔ Multiple waiting conditions
✔ Better readability
✔ Fine-grained thread control
✔ More flexible than wait/notify

================================================================================
*/

/*
================================================================================
2. WHAT IS CONDITION INTERFACE?
================================================================================

Definition:
-----------
Condition is an INTERFACE present in:
java.util.concurrent.locks package

It works with:
---------------
✔ Lock (usually ReentrantLock)

Purpose:
--------
✔ Allows threads to wait
✔ Allows threads to signal other threads
✔ Replacement for wait/notify

IMPORTANT:
----------
✔ Condition objects are created from Lock
✔ Each Condition has its OWN waiting queue

================================================================================
*/

/*
================================================================================
3. REAL-WORLD ANALOGY
================================================================================

Imagine a RESTAURANT KITCHEN:

Customers:
----------
✔ Wait for FOOD
✔ Wait for TABLE
✔ Wait for BILL

Different waiting conditions = different queues

Condition allows:
-----------------
✔ Separate queues for each condition
✔ Efficient signaling

================================================================================
*/

/*
================================================================================
4. KEY TERMINOLOGY
================================================================================

await():
--------
✔ Causes current thread to WAIT
✔ Releases the associated lock
✔ Thread goes to WAITING state

signal():
---------
✔ Wakes ONE waiting thread

signalAll():
------------
✔ Wakes ALL waiting threads

================================================================================
*/

/*
================================================================================
5. BASIC SYNTAX
================================================================================

Lock lock = new ReentrantLock();
Condition condition = lock.newCondition();

lock.lock();
try {
    condition.await();
    condition.signal();
} finally {
    lock.unlock();
}

================================================================================
*/

/*
================================================================================
6. IMPORTANT RULES (INTERVIEW FAVORITES)
================================================================================

✔ await(), signal(), signalAll() MUST be called inside lock
✔ await() releases lock (unlike sleep)
✔ signal() does NOT release lock immediately
✔ Lock must be released manually

================================================================================
*/

/*
================================================================================
7. SIMPLE PRODUCER–CONSUMER USING CONDITION
================================================================================
*/

class Buffer {

    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    private int data;
    private boolean hasData = false;

    // PRODUCER
    public void produce(int value) throws InterruptedException {
        lock.lock();
        try {
            while (hasData) {
                System.out.println("Buffer full, producer waiting...");
                notFull.await();   // wait until buffer is empty
            }

            data = value;
            hasData = true;
            System.out.println("Produced: " + value);

            notEmpty.signal(); // notify consumer
        } finally {
            lock.unlock();
        }
    }

    // CONSUMER
    public int consume() throws InterruptedException {
        lock.lock();
        try {
            while (!hasData) {
                System.out.println("Buffer empty, consumer waiting...");
                notEmpty.await(); // wait until buffer has data
            }

            hasData = false;
            System.out.println("Consumed: " + data);

            notFull.signal(); // notify producer
            return data;
        } finally {
            lock.unlock();
        }
    }
}

/*
================================================================================
8. MAIN CLASS – EXECUTION FLOW
================================================================================
*/

public class ConditionDetailedNotes {

    public static void main(String[] args) {

        Buffer buffer = new Buffer();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 3; i++) {
                    buffer.produce(i);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "PRODUCER");

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 3; i++) {
                    buffer.consume();
                    Thread.sleep(1500);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "CONSUMER");

        producer.start();
        consumer.start();
    }
}

/*
================================================================================
9. EXECUTION FLOW (STEP BY STEP)
================================================================================

1️⃣ Producer acquires lock
2️⃣ If buffer full → await() → releases lock
3️⃣ Consumer acquires lock
4️⃣ Consumes data
5️⃣ Consumer calls signal() on notFull
6️⃣ Producer wakes up and continues

KEY POINT:
----------
✔ Producer and Consumer wait on DIFFERENT conditions

================================================================================
*/

/*
================================================================================
10. CONDITION vs wait/notify
================================================================================

Feature                 Condition               wait/notify
--------------------------------------------------------------
Lock type               Lock                    synchronized
Multiple wait queues    ✔ Yes                  ❌ No
Readability             ✔ High                 ❌ Low
Flexibility             ✔ High                 ❌ Low
Modern usage            ✔ Preferred            ❌ Legacy

================================================================================
*/

/*
================================================================================
11. CONDITION vs SEMAPHORE
================================================================================

Semaphore:
----------
✔ Controls number of threads
✔ Permit-based

Condition:
----------
✔ Controls thread WAIT/SIGNAL
✔ Used with explicit locking

================================================================================
*/

/*
================================================================================
12. COMMON INTERVIEW QUESTIONS
================================================================================

Q1: Why Condition instead of wait/notify?
A: Multiple waiting queues & better control.

Q2: Does await() release lock?
A: Yes.

Q3: Does signal() release lock?
A: No, lock is released when unlock() is called.

Q4: Can we call await() without lock?
A: No, IllegalMonitorStateException.

Q5: Why while loop instead of if?
A: To handle spurious wakeups.

================================================================================
*/

/*
================================================================================
13. COMMON MISTAKES
================================================================================

❌ Calling await() without acquiring lock
❌ Forgetting unlock()
❌ Using if instead of while
❌ Using single Condition for multiple purposes

================================================================================
*/

/*
================================================================================
14. BEST PRACTICES
================================================================================

✔ Always use await() inside while loop
✔ Always unlock in finally block
✔ Use multiple Conditions when needed
✔ Prefer Condition over wait/notify in new code

================================================================================
*/

/*
================================================================================
15. ONE-LINE INTERVIEW SUMMARY
================================================================================

"Condition provides a flexible and powerful mechanism for inter-thread
communication by allowing multiple waiting conditions with explicit locks."

================================================================================
END OF FILE
================================================================================
*/
