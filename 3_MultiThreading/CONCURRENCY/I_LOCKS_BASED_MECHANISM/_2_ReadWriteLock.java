package CONCURRENCY.I_LOCKS_BASED_MECHANISM;

/*
================================================================================
              READWRITELOCK (ReentrantReadWriteLock) 
================================================================================
*/

/*
================================================================================
1. PROBLEM STATEMENT – WHY ReadWriteLock?
================================================================================

Consider a shared resource (data / variable / object):

- Many threads need to READ data
- Very few threads UPDATE (WRITE) data

Using synchronized / ReentrantLock:
-----------------------------------
❌ Only ONE thread can access at a time
❌ Even READ operations block each other
❌ Poor performance in read-heavy systems

We need:
--------
✔ Multiple threads to READ simultaneously
✔ ONLY one thread to WRITE exclusively

➡ This is exactly what ReadWriteLock provides.

================================================================================
*/

/*
================================================================================
2. WHAT IS ReadWriteLock?
================================================================================

Definition:
-----------
ReadWriteLock is an INTERFACE in:
java.util.concurrent.locks package

It provides TWO DIFFERENT LOCKS:
--------------------------------
1️⃣ Read Lock  – shared lock
2️⃣ Write Lock – exclusive lock

Implementation:
---------------
ReentrantReadWriteLock (most commonly used)

================================================================================
*/

/*
================================================================================
3. BASIC RULES (VERY IMPORTANT)
================================================================================

✔ Multiple threads CAN hold READ lock at same time
✔ ONLY ONE thread can hold WRITE lock
✔ READ lock is BLOCKED when WRITE lock is held
✔ WRITE lock is BLOCKED when ANY READ lock is held

================================================================================
*/

/*
================================================================================
4. REAL-WORLD ANALOGY
================================================================================

Think of a LIBRARY:

READERS:
--------
✔ Many people can read books simultaneously

WRITER:
-------
✔ Only ONE librarian can update / replace books
✔ No readers allowed while updating

Readers = ReadLock
Writer  = WriteLock

================================================================================
*/

/*
================================================================================
5. SYNTAX
================================================================================

ReadWriteLock lock = new ReentrantReadWriteLock();

lock.readLock().lock();
lock.readLock().unlock();

lock.writeLock().lock();
lock.writeLock().unlock();

================================================================================
*/

/*
================================================================================
6. INTERNAL WORKING (HOW IT WORKS)
================================================================================

Read Lock:
----------
- Shared lock
- Count maintained internally
- Allows concurrent access

Write Lock:
-----------
- Exclusive lock
- Blocks all readers & writers
- Only one thread allowed

Underlying mechanism:
---------------------
Built on top of AbstractQueuedSynchronizer (AQS)

================================================================================
*/

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
================================================================================
7. BASIC EXAMPLE – READ & WRITE
================================================================================
*/

class SharedData {

    private int value = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    // READ operation
    public void read() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()
                    + " reading value: " + value);
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    // WRITE operation
    public void write(int newValue) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()
                    + " writing value: " + newValue);
            value = newValue;
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}

/*
================================================================================
8. MAIN CLASS – EXECUTION FLOW
================================================================================
*/

class ReadWriteLockDemo {

    public static void main(String[] args) {

        SharedData data = new SharedData();

        // Multiple reader threads
        Thread r1 = new Thread(data::read, "Reader-1");
        Thread r2 = new Thread(data::read, "Reader-2");

        // Writer thread
        Thread w1 = new Thread(() -> data.write(10), "Writer-1");

        r1.start();
        r2.start();
        w1.start();
    }
}

/*
================================================================================
EXECUTION EXPLANATION
================================================================================

1️⃣ Reader-1 acquires READ lock
2️⃣ Reader-2 ALSO acquires READ lock (allowed)
3️⃣ Writer waits (blocked)
4️⃣ Readers finish & release read locks
5️⃣ Writer acquires WRITE lock
6️⃣ Writer updates value

================================================================================
*/

/*
================================================================================
9. REENTRANTReadWriteLock FEATURES
================================================================================

✔ Reentrant (same thread can re-acquire)
✔ Fair & non-fair modes
✔ Downgrading allowed (write → read)
❌ Upgrading NOT allowed (read → write)

================================================================================
*/

/*
================================================================================
10. FAIR vs NON-FAIR ReadWriteLock
================================================================================

Default:
--------
Non-fair (better performance)

Fair Lock:
----------
ReadWriteLock fairLock =
        new ReentrantReadWriteLock(true);

Fair:
-----
✔ Threads get lock in FIFO order
❌ Slower

================================================================================
*/

/*
================================================================================
11. LOCK DOWNGRADING (IMPORTANT INTERVIEW POINT)
================================================================================

Lock Downgrading:
----------------
✔ Write lock → Read lock
✔ Allowed

Example:
--------
Acquire WRITE lock
Acquire READ lock
Release WRITE lock
Continue with READ lock

Lock Upgrading:
---------------
❌ Read → Write NOT allowed
❌ Can cause deadlock

================================================================================
*/

/*
================================================================================
12. ReadWriteLock vs ReentrantLock
================================================================================

Feature                 ReentrantLock      ReadWriteLock
---------------------------------------------------------
Concurrent reads        ❌ No              ✔ Yes
Exclusive write         ✔ Yes              ✔ Yes
Performance (read-heavy)❌ Poor             ✔ Excellent
Complexity              ✔ Simple           ❌ Slightly complex

================================================================================
*/

/*
================================================================================
13. ReadWriteLock vs synchronized
================================================================================

synchronized:
-------------
❌ Only one thread at a time
✔ Simple

ReadWriteLock:
--------------
✔ High concurrency
✔ Better scalability
❌ More complex

================================================================================
*/

/*
================================================================================
14. COMMON INTERVIEW QUESTIONS
================================================================================

Q1: Can multiple threads read simultaneously?
A: Yes.

Q2: Can a writer acquire lock when readers exist?
A: No.

Q3: Is lock upgrading allowed?
A: No.

Q4: Is lock downgrading allowed?
A: Yes.

Q5: When should we use ReadWriteLock?
A: Read-heavy systems.

================================================================================
*/

/*
================================================================================
15. COMMON MISTAKES
================================================================================

❌ Forgetting to unlock read/write lock
❌ Trying to upgrade read → write
❌ Using it for write-heavy scenarios
❌ Not using finally block

================================================================================
*/

/*
================================================================================
16. WHEN TO USE ReadWriteLock
================================================================================

✔ Caching systems
✔ Configuration objects
✔ In-memory databases
✔ Read-heavy applications

================================================================================
*/

/*
================================================================================
17. WHEN NOT TO USE
================================================================================

❌ Write-heavy systems
❌ Very small critical sections
❌ Simple concurrency needs

================================================================================
*/

/*
================================================================================
18. ONE-LINE INTERVIEW SUMMARY
================================================================================

"ReadWriteLock allows multiple threads to read shared data concurrently
while ensuring exclusive access for write operations, improving performance
in read-heavy concurrent systems."

================================================================================
END OF FILE
================================================================================
*/
