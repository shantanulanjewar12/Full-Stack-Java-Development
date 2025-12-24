package CONCURRENCY.II_LOCK_FREE_MECHANISM;

import java.util.concurrent.atomic.AtomicBoolean;

/*
================================================================================
FILE NAME  : 3_AtomicBoolean.java
PACKAGE    : concurrency.lock_free_mechanism
TOPIC      : AtomicBoolean – Lock-Free Boolean Flag using CAS
LEVEL      : Beginner → Advanced → Interview Ready
================================================================================

PURPOSE OF THIS FILE
-------------------
This file explains AtomicBoolean in COMPLETE detail:

✔ Why AtomicBoolean exists
✔ Problems with normal boolean in multithreading
✔ Internal working using CAS
✔ Difference between volatile, synchronized, and AtomicBoolean
✔ Practical examples (flags, state control)
✔ compareAndSet usage
✔ Interview questions & common mistakes

================================================================================
*/

/*
================================================================================
1. WHY DO WE NEED AtomicBoolean?
================================================================================

Problem:
--------
A normal boolean variable is NOT thread-safe in multithreading.

Example use-cases:
✔ Stop a thread
✔ Start/stop service
✔ State flag (running, completed, cancelled)

Issues with normal boolean:
---------------------------
❌ Race conditions
❌ Visibility issues
❌ Multiple threads may update incorrectly

Solutions:
----------
1️⃣ volatile boolean   → visibility only (NOT atomic)
2️⃣ synchronized       → thread-safe but BLOCKING
3️⃣ AtomicBoolean      → thread-safe & LOCK-FREE ✅

================================================================================
*/

/*
================================================================================
2. WHAT IS AtomicBoolean?
================================================================================

AtomicBoolean is a class from:
    java.util.concurrent.atomic

It provides:
✔ Atomic operations on a boolean value
✔ Lock-free thread safety
✔ CAS-based updates

Internally uses:
✔ Compare-And-Swap (CAS)

================================================================================
*/

/*
================================================================================
3. ATOMIC vs VOLATILE (VERY IMPORTANT)
================================================================================

volatile boolean:
-----------------
✔ Guarantees visibility
❌ Does NOT guarantee atomicity

AtomicBoolean:
--------------
✔ Guarantees visibility
✔ Guarantees atomicity
✔ Supports CAS operations

Conclusion:
-----------
volatile ≠ atomic

================================================================================
*/

/*
================================================================================
4. PROBLEM WITH NORMAL BOOLEAN
================================================================================
*/

class NormalFlag {

    boolean running = true;

    public void stop() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }
}

/*
================================================================================
5. PROBLEM DEMO (RACE + VISIBILITY ISSUE)
================================================================================
*/

class NormalFlagDemo {

    public static void main(String[] args) {

        NormalFlag flag = new NormalFlag();

        new Thread(() -> {
            while (flag.isRunning()) {
                // busy work
            }
            System.out.println("Thread stopped");
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
            flag.stop(); // may NOT be visible immediately
        }).start();
    }
}

/*
================================================================================
6. SOLUTION USING volatile
================================================================================

volatile solves VISIBILITY but NOT atomic update scenarios.
================================================================================
*/

class VolatileFlag {

    volatile boolean running = true;

    public void stop() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }
}

/*
================================================================================
7. SOLUTION USING AtomicBoolean
================================================================================
*/

class AtomicFlag {

    AtomicBoolean running = new AtomicBoolean(true);

    public void stop() {
        running.set(false); // Atomic update
    }

    public boolean isRunning() {
        return running.get();
    }
}

/*
================================================================================
8. ATOMICBOOLEAN DEMO
================================================================================
*/

class AtomicBooleanDemo {

    public static void main(String[] args) {

        AtomicFlag flag = new AtomicFlag();

        new Thread(() -> {
            while (flag.isRunning()) {
                // working
            }
            System.out.println("Thread stopped safely");
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
            flag.stop();
        }).start();
    }
}

/*
================================================================================
9. IMPORTANT AtomicBoolean METHODS
================================================================================

✔ get()                  → returns current value
✔ set(boolean value)     → sets value
✔ compareAndSet(exp, new)
✔ getAndSet(newValue)

================================================================================
*/

/*
================================================================================
10. compareAndSet() EXAMPLE
================================================================================
*/

class AtomicBooleanCASDemo {

    public static void main(String[] args) {

        AtomicBoolean flag = new AtomicBoolean(false);

        boolean success = flag.compareAndSet(false, true);

        System.out.println("Updated: " + success);
        System.out.println("Value  : " + flag.get());

        // Output:
        // Updated: true
        // Value  : true
    }
}

/*
================================================================================
11. REAL-WORLD USE CASES
================================================================================

✔ Thread stop flag
✔ One-time initialization
✔ Feature toggle
✔ Circuit breaker state
✔ Service lifecycle management

================================================================================
*/

/*
================================================================================
12. WHEN TO USE AtomicBoolean?
================================================================================

✔ Simple ON/OFF state
✔ Multiple threads controlling a flag
✔ Lock-free performance required

================================================================================
*/

/*
================================================================================
13. WHEN NOT TO USE AtomicBoolean?
================================================================================

❌ Multiple states (use enum + AtomicReference)
❌ Complex state transitions
❌ Business logic decisions

================================================================================
*/

/*
================================================================================
14. INTERVIEW QUESTIONS
================================================================================

Q1. Is AtomicBoolean better than volatile?
Answer:
Yes, it provides atomic operations along with visibility.

Q2. Does AtomicBoolean use synchronized?
Answer:
No, it uses CAS internally.

Q3. Can AtomicBoolean guarantee thread safety?
Answer:
Yes, for single boolean state updates.

Q4. What is a real use case of AtomicBoolean?
Answer:
Stopping a running thread safely.

Q5. What happens if compareAndSet fails?
Answer:
The update is not applied; caller can retry.

================================================================================
*/

/*
================================================================================
15. KEY TAKEAWAYS
================================================================================

✔ AtomicBoolean is lock-free and thread-safe
✔ Uses CAS internally
✔ Better than volatile for atomic updates
✔ Ideal for flags and state control
✔ Not suitable for complex logic

================================================================================
END OF FILE
================================================================================
*/

