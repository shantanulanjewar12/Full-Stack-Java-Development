/*
================================================================================
1. WHY JAVA HAS 2 WAYS TO CREATE THREADS?
================================================================================

Java provides TWO ways to create threads:
1️⃣ Implementing Runnable interface
2️⃣ Extending Thread class

This is NOT random — it is due to Java’s OOPS design rules.

--------------------------------------------------------------------------------
CORE JAVA RULES:
--------------------------------------------------------------------------------
✔ A class can IMPLEMENT multiple interfaces
✔ A class can EXTEND only ONE class

--------------------------------------------------------------------------------
WHY THIS MATTERS:
--------------------------------------------------------------------------------
If Java allowed ONLY:
- "extends Thread"

Then:
❌ You could not extend any other class
❌ Your design would be restricted

Runnable solves this limitation.

--------------------------------------------------------------------------------
INTERVIEW ONE-LINER:
--------------------------------------------------------------------------------
Java provides Runnable to support multiple inheritance and better design.

================================================================================
*/

/*
================================================================================
2. THREAD LIFECYCLE – INTRODUCTION
================================================================================

A thread in Java does NOT execute randomly.
It goes through a WELL-DEFINED set of STATES.

These states together form the THREAD LIFECYCLE.

Officially defined in java.lang.Thread.State enum.

--------------------------------------------------------------------------------
THREAD LIFECYCLE STATES:
--------------------------------------------------------------------------------
1️⃣ NEW
2️⃣ RUNNABLE
3️⃣ RUNNING   (conceptual, inside RUNNABLE)
4️⃣ BLOCKED
5️⃣ WAITING
6️⃣ TIMED_WAITING
7️⃣ TERMINATED

================================================================================
*/

/*
================================================================================
3. STATE 1: NEW
================================================================================

Definition:
-----------
- Thread object is CREATED
- Thread is NOT started yet

Key Points:
-----------
✔ Thread exists only as an OBJECT in HEAP
✔ No OS-level thread created
✔ No stack allocated

Example:
--------
Thread t = new Thread();

State:
------
NEW

================================================================================
*/

/*
================================================================================
4. TRANSITION: NEW → RUNNABLE
================================================================================

How does this happen?
---------------------
By calling start()

start():
--------
✔ Requests JVM to create native thread
✔ Allocates stack, PC, registers
✔ Moves thread to RUNNABLE state

IMPORTANT:
----------
Calling run() DOES NOT change state.

================================================================================
*/

/*
================================================================================
5. STATE 2: RUNNABLE
================================================================================

Definition:
-----------
- Thread is READY to run
- Waiting for CPU time

Key Points:
-----------
✔ Thread may or may NOT be running
✔ Controlled by Thread Scheduler
✔ Multiple threads can be runnable

Interview Trick:
----------------
Java DOES NOT have a separate "Running" state officially.
Running is part of RUNNABLE.

================================================================================
*/

/*
================================================================================
6. STATE 3: RUNNING (CONCEPTUAL)
================================================================================

Definition:
-----------
- Thread is actually EXECUTING instructions
- CPU is allocated to the thread

Key Points:
-----------
✔ Depends on OS scheduler
✔ Time-sliced execution
✔ Can be pre-empted anytime

Transition back to RUNNABLE:
----------------------------
✔ yield()
✔ Time slice expired

================================================================================
*/

/*
================================================================================
7. STATE 4: BLOCKED
================================================================================

Definition:
-----------
Thread enters BLOCKED state when:
✔ Waiting for I/O
✔ Waiting to acquire a MONITOR LOCK

Examples:
---------
- Reading file
- Waiting for synchronized resource

IMPORTANT PROPERTY:
-------------------
✔ Releases ALL monitor locks
✔ Cannot proceed until resource available

Transition:
-----------
BLOCKED → RUNNABLE
(after I/O done or lock acquired)

================================================================================
*/

/*
================================================================================
8. STATE 5: WAITING
================================================================================

Definition:
-----------
Thread goes into WAITING state when:
✔ wait() is called
✔ join() without timeout is called

Key Points:
-----------
✔ Thread becomes NON-RUNNABLE
✔ Releases ALL monitor locks
✔ Waits indefinitely

Return to RUNNABLE:
-------------------
✔ notify()
✔ notifyAll()
✔ join() completes

================================================================================
*/

/*
================================================================================
9. STATE 6: TIMED_WAITING
================================================================================

Definition:
-----------
Thread waits for FIXED time period

Common Methods:
---------------
✔ sleep(time)
✔ wait(time)
✔ join(time)

Key Points:
-----------
✔ Automatically returns to RUNNABLE after time expires
✔ DOES NOT release monitor lock for sleep()
✔ Releases lock for wait(time)

================================================================================
*/

/*
================================================================================
10. STATE 7: TERMINATED
================================================================================

Definition:
-----------
Thread execution is COMPLETE

How thread terminates:
----------------------
✔ run() method finishes
✔ Uncaught exception occurs
✔ stop() called (DEPRECATED & UNSAFE)

Important:
----------
❌ A terminated thread CANNOT be restarted

================================================================================
*/

/*
================================================================================
11. stop() METHOD (IMPORTANT WARNING)
================================================================================

stop() is:
----------
❌ Deprecated
❌ Unsafe
❌ Abruptly kills thread

Why dangerous?
--------------
✔ Releases locks without cleanup
✔ Causes data inconsistency
✔ Can corrupt shared data

Modern Java:
------------
✔ Use interrupt()
✔ Use flags for graceful shutdown

================================================================================
*/

/*
================================================================================
12. COMPLETE LIFECYCLE FLOW (TEXT DIAGRAM)
================================================================================

NEW
 ↓ start()
RUNNABLE ⇄ RUNNING
 ↓ (I/O or lock)
BLOCKED → RUNNABLE
 ↓ wait()
WAITING → notify() → RUNNABLE
 ↓ sleep(time)
TIMED_WAITING → RUNNABLE
 ↓ run() ends
TERMINATED

================================================================================
*/

/*
================================================================================
13. PRACTICAL CODE DEMONSTRATION
================================================================================
*/

class LifecycleDemo extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Thread running: " + getName());
            Thread.sleep(1000); // TIMED_WAITING
            System.out.println("Thread woke up: " + getName());
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }

    public static void main(String[] args) throws Exception {

        LifecycleDemo t = new LifecycleDemo();

        System.out.println("State after creation: " + t.getState()); // NEW

        t.start();
        System.out.println("State after start(): " + t.getState()); // RUNNABLE

        Thread.sleep(200);
        System.out.println("State during sleep(): " + t.getState()); // TIMED_WAITING

        t.join();
        System.out.println("State after completion: " + t.getState()); // TERMINATED
    }
}

/*
================================================================================
14. MONITOR LOCK BEHAVIOR (VERY IMPORTANT)
================================================================================

State              Releases Lock?
---------------------------------
BLOCKED            ❌ No (waiting to acquire)
WAITING            ✅ Yes
TIMED_WAITING
 - sleep()         ❌ No
 - wait(time)      ✅ Yes

Interviewers LOVE this question.

================================================================================
*/

/*
================================================================================
15. INTERVIEW QUESTIONS & ANSWERS
================================================================================

Q1: Why Java has Runnable and Thread?
A: To support multiple inheritance and better design.

Q2: Is Running a state in Java?
A: No, it is part of RUNNABLE.

Q3: Does sleep() release lock?
A: No.

Q4: Does wait() release lock?
A: Yes.

Q5: Can a thread restart after termination?
A: No.

Q6: Why stop() is deprecated?
A: Unsafe, causes data inconsistency.

================================================================================
*/

/*
================================================================================
16. KEY INTERVIEW ONE-LINERS
================================================================================

✔ Runnable defines TASK, Thread manages EXECUTION
✔ start() creates new thread, run() does not
✔ RUNNABLE includes running state
✔ wait() releases lock, sleep() does not
✔ stop() is deprecated and unsafe
✔ Thread lifecycle is controlled by JVM + OS

================================================================================
END OF FILE
================================================================================
*/
