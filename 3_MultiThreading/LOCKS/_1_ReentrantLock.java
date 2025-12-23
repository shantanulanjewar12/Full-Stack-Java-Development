package LOCKS;
/*
================================================================================
                    REENTRANTLOCK – COMPLETE DETAILED NOTES
================================================================================
*/

/*
================================================================================
1. WHAT IS A LOCK?
================================================================================

In multithreading, when multiple threads access a shared resource,
we must CONTROL access to avoid:
❌ Race conditions
❌ Data inconsistency
❌ Unexpected results

Java provides TWO main ways to achieve synchronization:
1️⃣ synchronized keyword
2️⃣ Explicit Locks (Lock API)

ReentrantLock belongs to the SECOND category.

================================================================================
*/

/*
================================================================================
2. WHAT IS ReentrantLock?
================================================================================

Definition:
-----------
ReentrantLock is a class in:
java.util.concurrent.locks package

It is an ADVANCED, FLEXIBLE alternative to `synchronized`.

"Reentrant" means:
------------------
➡ The SAME thread can acquire the SAME lock MULTIPLE TIMES
➡ Lock count is maintained internally
➡ Lock is released ONLY when unlock() is called same number of times

================================================================================
*/

/*
================================================================================
3. WHY DO WE NEED ReentrantLock WHEN synchronized EXISTS?
================================================================================

Limitations of synchronized:
----------------------------
❌ No try-lock mechanism
❌ No fairness policy
❌ No interruptible lock
❌ No manual unlock control
❌ Entire method/block is locked

ReentrantLock SOLVES these problems.

================================================================================
*/

/*
================================================================================
4. IMPORTANT FEATURES OF ReentrantLock
================================================================================

✔ Reentrancy (same thread can lock multiple times)
✔ Manual lock() and unlock()
✔ tryLock() – avoid deadlock
✔ Fairness policy
✔ Interruptible lock
✔ Condition support (wait/notify alternative)

================================================================================
*/

/*
================================================================================
5. BASIC SYNTAX
================================================================================

ReentrantLock lock = new ReentrantLock();

lock.lock();       // acquire lock
try {
    // critical section
} finally {
    lock.unlock(); // MUST be called
}

================================================================================
*/

/*
================================================================================
6. INTERNAL WORKING (HOW IT WORKS)
================================================================================

1️⃣ Thread calls lock()
2️⃣ JVM checks if lock is FREE
   - If YES → thread acquires lock
   - If NO → thread goes to BLOCKED state
3️⃣ If SAME thread calls lock() again → allowed (reentrant)
4️⃣ unlock() decreases lock count
5️⃣ Lock is released ONLY when count becomes ZERO

================================================================================
*/

/*
================================================================================
7. SIMPLE EXAMPLE – BASIC LOCKING
================================================================================
*/

import java.util.concurrent.locks.ReentrantLock;

class SimpleReentrantLockExample {

    private final ReentrantLock lock = new ReentrantLock();

    public void task() {
        lock.lock(); // acquire lock
        try {
            System.out.println("Lock acquired by: " + Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // release lock
            System.out.println("Lock released by: " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        SimpleReentrantLockExample obj = new SimpleReentrantLockExample();

        Thread t1 = new Thread(obj::task, "Thread-1");
        Thread t2 = new Thread(obj::task, "Thread-2");

        t1.start();
        t2.start();
    }
}

/*
 * =============================================================================
 * ===
 * 8. REENTRANCY DEMONSTRATION
 * =============================================================================
 * ===
 */

class ReentrancyDemo {

    private final ReentrantLock lock = new ReentrantLock();

    public void outerMethod() {
        lock.lock();
        try {
            System.out.println("Outer method lock by: " + Thread.currentThread().getName());
            innerMethod();
        } finally {
            lock.unlock();
        }
    }

    public void innerMethod() {
        lock.lock(); // SAME THREAD re-acquires lock
        try {
            System.out.println("Inner method lock by: " + Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        new ReentrancyDemo().outerMethod();
    }
}

/*
 * =============================================================================
 * ===
 * 9. FAIR vs NON-FAIR LOCK
 * =============================================================================
 * ===
 * 
 * By default:
 * -----------
 * ReentrantLock is NON-FAIR
 * 
 * Non-fair:
 * ---------
 * ✔ Faster
 * ❌ Thread starvation possible
 * 
 * Fair:
 * -----
 * ✔ Threads acquire lock in FIFO order
 * ❌ Slower
 * 
 * Syntax:
 * -------
 * ReentrantLock fairLock = new ReentrantLock(true);
 * 
 * =============================================================================
 * ===
 */

/*
 * =============================================================================
 * ===
 * 10. tryLock() – DEADLOCK PREVENTION
 * =============================================================================
 * ===
 * 
 * tryLock():
 * ----------
 * ✔ Tries to acquire lock
 * ✔ Returns immediately
 * ✔ Returns true/false
 * 
 * Useful to AVOID deadlock.
 * 
 * =============================================================================
 * ===
 */

class TryLockExample {

    private final ReentrantLock lock = new ReentrantLock();

    public void task() {
        if (lock.tryLock()) {
            try {
                System.out.println("Lock acquired by: " + Thread.currentThread().getName());
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Could not acquire lock: " + Thread.currentThread().getName());
        }
    }
}

/*
 * =============================================================================
 * ===
 * 11. lockInterruptibly()
 * =============================================================================
 * ===
 * 
 * lockInterruptibly():
 * --------------------
 * ✔ Thread can be INTERRUPTED while waiting for lock
 * ✔ synchronized does NOT support this
 * 
 * =============================================================================
 * ===
 */

class InterruptibleLockExample {

    private final ReentrantLock lock = new ReentrantLock();

    public void task() {
        try {
            lock.lockInterruptibly();
            System.out.println("Lock acquired by: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted while waiting for lock");
        } finally {
            if (lock.isHeldByCurrentThread())
                lock.unlock();
        }
    }
}

/*
 * =============================================================================
 * ===
 * 12. ReentrantLock vs synchronized
 * =============================================================================
 * ===
 * 
 * Feature synchronized ReentrantLock
 * ----------------------------------------------------------------
 * Reentrant ✔ Yes ✔ Yes
 * Fairness ❌ No ✔ Yes
 * tryLock() ❌ No ✔ Yes
 * Interruptible lock ❌ No ✔ Yes
 * Manual unlock ❌ No ✔ Yes
 * Condition support ❌ No ✔ Yes
 * 
 * =============================================================================
 * ===
 */

/*
 * =============================================================================
 * ===
 * 13. COMMON INTERVIEW QUESTIONS
 * =============================================================================
 * ===
 * 
 * Q1: What does reentrant mean?
 * A: Same thread can acquire the same lock multiple times.
 * 
 * Q2: What happens if unlock() is not called?
 * A: Deadlock.
 * 
 * Q3: Is ReentrantLock better than synchronized?
 * A: More flexible, not always better.
 * 
 * Q4: Can ReentrantLock cause deadlock?
 * A: Yes, if misused.
 * 
 * Q5: Which is faster?
 * A: synchronized is optimized in JVM; ReentrantLock gives more control.
 * 
 * =============================================================================
 * ===
 */

/*
 * =============================================================================
 * ===
 * 14. COMMON MISTAKES
 * =============================================================================
 * ===
 * 
 * ❌ Forgetting unlock() in finally block
 * ❌ Unlocking without acquiring lock
 * ❌ Using ReentrantLock without need
 * ❌ Overusing fair locks (performance hit)
 * 
 * =============================================================================
 * ===
 */

/*
 * =============================================================================
 * ===
 * 15. WHEN TO USE ReentrantLock
 * =============================================================================
 * ===
 * 
 * ✔ Need tryLock()
 * ✔ Need fairness
 * ✔ Need interruptible locking
 * ✔ Need multiple condition variables
 * ✔ Advanced concurrency control
 * 
 * =============================================================================
 * ===
 */

/*
 * =============================================================================
 * ===
 * 16. WHEN NOT TO USE ReentrantLock
 * =============================================================================
 * ===
 * 
 * ❌ Simple synchronization
 * ❌ Small critical sections
 * ❌ Beginner-level code
 * 
 * Use synchronized instead.
 * 
 * =============================================================================
 * ===
 */

/*
 * =============================================================================
 * ===
 * 17. ONE-LINE INTERVIEW SUMMARY
 * =============================================================================
 * ===
 * 
 * "ReentrantLock is an advanced locking mechanism that provides
 * greater flexibility than synchronized by supporting reentrancy,
 * fairness, tryLock, and interruptible locking."
 * 
 * =============================================================================
 * ===
 * END OF FILE
 * =============================================================================
 * ===
 */
