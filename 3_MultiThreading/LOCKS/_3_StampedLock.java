package LOCKS;

/*
================================================================================
                 STAMPEDLOCK – COMPLETE DETAILED NOTES
================================================================================
*/

/*
================================================================================
1. WHY StampedLock WAS INTRODUCED?
================================================================================

Before Java 8, we had:
---------------------
✔ synchronized
✔ ReentrantLock
✔ ReadWriteLock

Problem:
--------
Even ReadWriteLock has overhead:
❌ Lock acquisition is costly
❌ Context switching is expensive
❌ Not optimal for VERY READ-HEAVY systems

Java 8 introduced:
------------------
➡ StampedLock

Goal:
-----
✔ Higher performance
✔ Lower contention
✔ Optimized read-heavy workloads

================================================================================
*/

/*
================================================================================
2. WHAT IS StampedLock?
================================================================================

Definition:
-----------
StampedLock is a lock mechanism introduced in Java 8 that supports:

1️⃣ Write Lock (exclusive)
2️⃣ Read Lock (shared)
3️⃣ Optimistic Read (lock-free read)

Package:
--------
java.util.concurrent.locks

================================================================================
*/

/*
================================================================================
3. MOST IMPORTANT DIFFERENCE
================================================================================

ReentrantReadWriteLock:
----------------------
✔ Blocking read lock

StampedLock:
------------
✔ Optimistic Read (NO blocking initially)
✔ Validation mechanism
✔ Higher throughput

================================================================================
*/

/*
================================================================================
4. KEY CONCEPT – "STAMP"
================================================================================

A STAMP is:
-----------
✔ long value
✔ Represents lock state/version
✔ Returned when lock is acquired
✔ Used to validate or release lock

You MUST:
---------
✔ Store the stamp
✔ Use same stamp to unlock

================================================================================
*/

/*
================================================================================
5. TYPES OF LOCKS IN StampedLock
================================================================================

1️⃣ Write Lock
--------------
- Exclusive
- Blocks all readers & writers

2️⃣ Read Lock
-------------
- Shared
- Multiple readers allowed

3️⃣ Optimistic Read
-------------------
- NO blocking
- Lock-free read
- Requires validation

================================================================================
*/

import java.util.concurrent.locks.StampedLock;

/*
================================================================================
6. BASIC SYNTAX
================================================================================

StampedLock lock = new StampedLock();

// Write Lock
long stamp = lock.writeLock();
lock.unlockWrite(stamp);

// Read Lock
long stamp = lock.readLock();
lock.unlockRead(stamp);

// Optimistic Read
long stamp = lock.tryOptimisticRead();
if(lock.validate(stamp)) {
    // safe read
}

================================================================================
*/

/*
================================================================================
7. SIMPLE READ/WRITE EXAMPLE
================================================================================
*/

class SharedResource {

    private int data = 10;
    private final StampedLock lock = new StampedLock();

    // WRITE METHOD
    public void write(int value) {
        long stamp = lock.writeLock();
        try {
            System.out.println(Thread.currentThread().getName()
                    + " acquired WRITE lock");
            data = value;
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlockWrite(stamp);
            System.out.println(Thread.currentThread().getName()
                    + " released WRITE lock");
        }
    }

    // READ METHOD
    public void read() {
        long stamp = lock.readLock();
        try {
            System.out.println(Thread.currentThread().getName()
                    + " reading value: " + data);
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlockRead(stamp);
        }
    }
}

/*
================================================================================
8. OPTIMISTIC READ – MOST IMPORTANT FEATURE
================================================================================

What is Optimistic Read?
-----------------------
✔ No actual lock is acquired
✔ Very fast
✔ No blocking
✔ Must validate before using data

Use when:
---------
✔ Reads >> Writes
✔ Temporary inconsistency acceptable

================================================================================
*/

class OptimisticReadExample {

    private int value = 100;
    private final StampedLock lock = new StampedLock();

    public void optimisticRead() {

        long stamp = lock.tryOptimisticRead();
        int temp = value;

        // simulate delay
        try { Thread.sleep(2000); } catch (Exception e) {}

        if (lock.validate(stamp)) {
            System.out.println("Optimistic read successful: " + temp);
        } else {
            System.out.println("Optimistic read failed, switching to READ lock");
            long readStamp = lock.readLock();
            try {
                System.out.println("Safe read: " + value);
            } finally {
                lock.unlockRead(readStamp);
            }
        }
    }

    public void write(int newValue) {
        long stamp = lock.writeLock();
        try {
            value = newValue;
        } finally {
            lock.unlockWrite(stamp);
        }
    }
}

/*
================================================================================
9. EXECUTION FLOW OF OPTIMISTIC READ
================================================================================

1️⃣ tryOptimisticRead() → returns stamp
2️⃣ Read data WITHOUT lock
3️⃣ validate(stamp)
   ✔ true  → data safe
   ❌ false → writer modified data → retry with read lock

================================================================================
*/

/*
================================================================================
10. VERY IMPORTANT LIMITATIONS
================================================================================

❌ NOT Reentrant
----------------
Same thread cannot re-acquire lock

❌ No Condition Support
----------------------
Unlike ReentrantLock

❌ Must carefully handle stamps

================================================================================
*/

/*
================================================================================
11. StampedLock vs ReadWriteLock
================================================================================

Feature                     ReadWriteLock      StampedLock
------------------------------------------------------------
Optimistic Read             ❌ No               ✔ Yes
Reentrant                   ✔ Yes               ❌ No
Performance (read heavy)    ✔ Good              ✔ Excellent
Complexity                  ✔ Moderate          ❌ Higher
Deadlock risk               ✔ Lower             ❌ Higher (if misused)

================================================================================
*/

/*
================================================================================
12. WHEN TO USE StampedLock
================================================================================

✔ Very high read-heavy systems
✔ Performance-critical code
✔ In-memory data structures
✔ Caches
✔ Analytics systems

================================================================================
*/

/*
================================================================================
13. WHEN NOT TO USE
================================================================================

❌ Simple synchronization
❌ Recursive locking needed
❌ Condition variables required
❌ Beginner-level concurrency

================================================================================
*/

/*
================================================================================
14. COMMON INTERVIEW QUESTIONS
================================================================================

Q1: Is StampedLock reentrant?
A: No.

Q2: What is optimistic locking?
A: Lock-free read validated later.

Q3: Can StampedLock replace synchronized?
A: No, use case dependent.

Q4: Why is it faster?
A: Reduced blocking & context switching.

================================================================================
*/

/*
================================================================================
15. ONE-LINE INTERVIEW SUMMARY
================================================================================

"StampedLock provides high-performance locking with optimistic reads,
making it ideal for read-heavy concurrent systems."

================================================================================
END OF FILE
================================================================================
*/

