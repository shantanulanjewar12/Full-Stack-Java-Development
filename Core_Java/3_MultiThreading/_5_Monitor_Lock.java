/*
================================================================================
1. BEFORE MULTITHREADING EXAMPLES – WHAT IS A MONITOR LOCK?
================================================================================

MONITOR LOCK (also called INTRINSIC LOCK):
-----------------------------------------
✔ A monitor lock is a mechanism used by Java to ensure that
  ONLY ONE THREAD can execute a particular critical section
  of code at a time.

✔ It is automatically used when we apply:
  - synchronized method
  - synchronized block

✔ Every OBJECT in Java has EXACTLY ONE monitor lock.

================================================================================
*/

/*
================================================================================
2. WHY DO WE NEED MONITOR LOCK?
================================================================================

Problem without synchronization:
--------------------------------
✔ Multiple threads access shared data
✔ Data inconsistency
✔ Race conditions

Monitor lock SOLVES:
--------------------
✔ Mutual exclusion
✔ Thread safety
✔ Data consistency

================================================================================
*/

/*
================================================================================
3. IMPORTANT RULES OF MONITOR LOCK (INTERVIEW GOLD)
================================================================================

✔ Monitor lock is associated with an OBJECT, not with code
✔ Only ONE thread can hold a monitor lock at a time
✔ Threads must acquire lock BEFORE entering synchronized code
✔ Lock is released automatically when synchronized block exits
✔ Lock is released if thread enters WAITING state using wait()

================================================================================
*/

/*
================================================================================
4. HOW SYNCHRONIZED WORKS INTERNALLY
================================================================================

When a thread reaches synchronized code:

1️⃣ JVM checks if lock is available
2️⃣ If available → thread acquires lock
3️⃣ Thread enters critical section
4️⃣ Other threads go into BLOCKED state
5️⃣ Lock released when thread exits synchronized code

================================================================================
*/

/*
================================================================================
5. TYPES OF SYNCHRONIZATION
================================================================================

1️⃣ Synchronized METHOD
2️⃣ Synchronized BLOCK

--------------------------------------------------------------------------------
1. SYNCHRONIZED METHOD
--------------------------------------------------------------------------------
- Lock is applied on CURRENT OBJECT (this)
- Entire method becomes critical section

--------------------------------------------------------------------------------
2. SYNCHRONIZED BLOCK
--------------------------------------------------------------------------------
- Lock applied on specific object
- More fine-grained control
- Better performance

================================================================================
*/

/*
================================================================================
6. EXAMPLE: MONITOR LOCK DEMONSTRATION
================================================================================
*/

class MonitorLockExample {

    /*
     * ================================
     * SYNCHRONIZED METHOD
     * ================================
     * Lock used: THIS object
     * Only one thread can execute this method at a time
     */
    public synchronized void task1() {
        try {
            System.out.println("task1 entered by: " +
                    Thread.currentThread().getName());
            Thread.sleep(3000); // thread holds lock during sleep
            System.out.println("task1 exiting by: " +
                    Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
     * ================================
     * SYNCHRONIZED BLOCK
     * ================================
     * Lock used: THIS object
     * Only block is synchronized, not entire method
     */
    public void task2() {
        System.out.println("task2 before synchronized: " +
                Thread.currentThread().getName());

        synchronized (this) {
            System.out.println("task2 inside synchronized: " +
                    Thread.currentThread().getName());
        }

        System.out.println("task2 after synchronized: " +
                Thread.currentThread().getName());
    }

    /*
     * ================================
     * NON-SYNCHRONIZED METHOD
     * ================================
     * No lock required
     * Multiple threads can execute simultaneously
     */
    public void task3() {
        System.out.println("task3 executed by: " +
                Thread.currentThread().getName());
    }
}

/*
 * =============================================================================
 * ===
 * 7. MAIN CLASS – THREAD EXECUTION FLOW
 * =============================================================================
 * ===
 */

class MonitorLockDemo {

    public static void main(String[] args) {

        MonitorLockExample obj = new MonitorLockExample();

        Thread t1 = new Thread(() -> obj.task1(), "Thread-1");
        Thread t2 = new Thread(() -> obj.task2(), "Thread-2");
        Thread t3 = new Thread(() -> obj.task3(), "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}

/*
 * =============================================================================
 * ===
 * 8. STEP-BY-STEP EXECUTION EXPLANATION
 * =============================================================================
 * ===
 * 
 * STEP 1:
 * -------
 * Thread-1 enters task1()
 * ✔ Acquires monitor lock of obj
 * ✔ Sleeps but DOES NOT release lock
 * 
 * STEP 2:
 * -------
 * Thread-2 tries to enter synchronized block in task2()
 * ❌ BLOCKED (waiting for lock)
 * 
 * STEP 3:
 * -------
 * Thread-3 executes task3()
 * ✔ No synchronization
 * ✔ Executes immediately
 * 
 * STEP 4:
 * -------
 * Thread-1 exits task1()
 * ✔ Lock released
 * 
 * STEP 5:
 * -------
 * Thread-2 acquires lock and enters synchronized block
 * 
 * =============================================================================
 * ===
 */

/*
 * =============================================================================
 * ===
 * 9. IMPORTANT BEHAVIOR: sleep() vs wait()
 * =============================================================================
 * ===
 * 
 * sleep():
 * --------
 * ✔ DOES NOT release monitor lock
 * ✔ Thread goes to TIMED_WAITING
 * 
 * wait():
 * -------
 * ✔ RELEASES monitor lock
 * ✔ Thread goes to WAITING
 * ✔ Requires notify()/notifyAll()
 * 
 * =============================================================================
 * ===
 */

/*
 * =============================================================================
 * ===
 * 10. BLOCKED vs WAITING (INTERVIEW FAVORITE)
 * =============================================================================
 * ===
 * 
 * BLOCKED:
 * --------
 * ✔ Waiting to acquire monitor lock
 * ✔ Lock NOT released
 * 
 * WAITING:
 * --------
 * ✔ wait() is called
 * ✔ Lock IS released
 * 
 * =============================================================================
 * ===
 */

/*
 * =============================================================================
 * ===
 * 11. WHAT HAPPENS IF MULTIPLE OBJECTS ARE USED?
 * =============================================================================
 * ===
 * 
 * ✔ Each object has its OWN monitor lock
 * ✔ Threads synchronized on DIFFERENT objects do NOT block each other
 * 
 * Example:
 * ---------
 * synchronized(obj1) → lock on obj1
 * synchronized(obj2) → lock on obj2
 * 
 * =============================================================================
 * ===
 */

/*
 * =============================================================================
 * ===
 * 12. COMMON BEGINNER MISTAKES
 * =============================================================================
 * ===
 * 
 * ❌ Thinking synchronized blocks threads globally
 * ❌ Using different objects for locking accidentally
 * ❌ Over-synchronization (performance issues)
 * ❌ Calling wait() without synchronized block
 * ❌ Using sleep() expecting lock release
 * 
 * =============================================================================
 * ===
 */

/*
 * =============================================================================
 * ===
 * 13. INTERVIEW QUESTIONS & ANSWERS
 * =============================================================================
 * ===
 * 
 * Q1: What is a monitor lock?
 * A: A lock associated with every Java object used for synchronization.
 * 
 * Q2: Which object’s lock is used by synchronized method?
 * A: Current object (this).
 * 
 * Q3: Does sleep() release lock?
 * A: No.
 * 
 * Q4: Does wait() release lock?
 * A: Yes.
 * 
 * Q5: Can two threads execute synchronized code simultaneously?
 * A: No, if they use same lock object.
 * 
 * =============================================================================
 * ===
 */

/*
 * =============================================================================
 * ===
 * 14. KEY INTERVIEW ONE-LINERS
 * =============================================================================
 * ===
 * 
 * ✔ Every object in Java has one monitor lock
 * ✔ synchronized ensures mutual exclusion
 * ✔ sleep() does NOT release lock
 * ✔ wait() releases lock
 * ✔ BLOCKED waits for lock, WAITING waits for signal
 * ✔ Synchronization is object-level, not code-level
 * 
 * =============================================================================
 * ===
 * END OF FILE
 * =============================================================================
 * ===
 */
