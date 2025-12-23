/*
================================================================================
        METHODS TO PREVENT / CONTROL THREAD EXECUTION (FILE 7)
================================================================================
Topic Focus:
------------
✔ yield()
✔ join()
✔ sleep()

================================================================================
*/

/*
================================================================================
1. WHAT DOES "PREVENT A THREAD FROM EXECUTION" MEAN?
================================================================================

It DOES NOT mean killing the thread.

It means:
✔ Temporarily stopping a thread
✔ Giving CPU to another thread
✔ Making a thread wait for some condition or time

Java provides THREE IMPORTANT methods for this:

1️⃣ yield()
2️⃣ join()
3️⃣ sleep()

These methods HELP THE THREAD SCHEDULER manage execution.

================================================================================
*/

/*
================================================================================
2. yield() METHOD
================================================================================

Definition:
-----------
yield() is a STATIC method of Thread class.

Syntax:
-------
Thread.yield();

Purpose:
--------
✔ Gives a HINT to Thread Scheduler
✔ Says: "I am willing to pause my execution and let other threads run"

IMPORTANT:
----------
✔ It is ONLY a hint, NOT a command
✔ Scheduler may ignore it
✔ Works mainly with threads of SAME priority

================================================================================
*/

/*
================================================================================
HOW yield() WORKS INTERNALLY
================================================================================

1️⃣ Current thread is RUNNING
2️⃣ Calls yield()
3️⃣ Moves back to RUNNABLE state
4️⃣ Scheduler may give CPU to another thread
5️⃣ Current thread may run again immediately

yield() DOES NOT:
-----------------
❌ Block the thread
❌ Release any monitor lock
❌ Guarantee execution order

================================================================================
*/

/*
================================================================================
EXAMPLE: yield()
================================================================================
*/

class YieldExample extends Thread {

    public YieldExample(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " executing iteration " + i);
            Thread.yield(); // hint to scheduler
        }
    }
}

/*
================================================================================
3. join() METHOD
================================================================================

Definition:
-----------
join() makes the CURRENT thread wait until
the specified thread completes its execution.

Syntax:
-------
t.join();
t.join(time);

Purpose:
--------
✔ Thread coordination
✔ Ensuring execution order

================================================================================
*/

/*
================================================================================
HOW join() WORKS INTERNALLY
================================================================================

Suppose:
--------
Main thread calls: t1.join();

Then:
-----
✔ Main thread goes to WAITING (or TIMED_WAITING)
✔ t1 continues execution
✔ After t1 finishes → main thread resumes

IMPORTANT:
----------
✔ join() releases CPU
✔ join() DOES NOT release any monitor lock held by the waiting thread

================================================================================
*/

/*
================================================================================
EXAMPLE: join()
================================================================================
*/

class JoinWorker extends Thread {

    public JoinWorker(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            System.out.println(getName() + " started");
            Thread.sleep(1000);
            System.out.println(getName() + " finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class JoinExample {

    public static void main(String[] args) throws Exception {

        JoinWorker t1 = new JoinWorker("Thread-1");
        JoinWorker t2 = new JoinWorker("Thread-2");

        t1.start();
        t1.join(); // main waits for t1 to finish

        t2.start();
        t2.join(); // main waits for t2 to finish

        System.out.println("Main thread finished after t1 and t2");
    }
}

/*
================================================================================
4. sleep() METHOD
================================================================================

Definition:
-----------
sleep() makes the CURRENT thread sleep for
a specified amount of time.

Syntax:
-------
Thread.sleep(milliseconds);
Thread.sleep(milliseconds, nanoseconds);

Purpose:
--------
✔ Pause execution for fixed time
✔ Simulate delay
✔ Useful in polling, retries, simulations

================================================================================
*/

/*
================================================================================
HOW sleep() WORKS INTERNALLY
================================================================================

1️⃣ Thread calls sleep()
2️⃣ Thread goes to TIMED_WAITING
3️⃣ CPU is released
4️⃣ After time expires → thread becomes RUNNABLE

IMPORTANT:
----------
✔ sleep() DOES NOT release monitor lock
✔ InterruptedException must be handled

================================================================================
*/

/*
================================================================================
EXAMPLE: sleep()
================================================================================
*/

class SleepExample extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Thread sleeping...");
            Thread.sleep(2000);
            System.out.println("Thread woke up");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SleepExample().start();
    }
}

/*
================================================================================
5. COMPARISON: yield() vs join() vs sleep()
================================================================================

Feature              yield()           join()             sleep()
-------------------------------------------------------------------
Releases CPU         ✔ Yes              ✔ Yes              ✔ Yes
Releases lock        ❌ No               ❌ No               ❌ No
Blocking             ❌ No               ✔ Yes              ✔ Yes
Time-based           ❌ No               ✔ Optional          ✔ Yes
Guarantee order      ❌ No               ✔ Yes              ❌ No
Scheduler control    Hint only          Strong             Strong

================================================================================
*/

/*
================================================================================
6. THREAD STATES INVOLVED
================================================================================

yield():
--------
RUNNING → RUNNABLE

join():
-------
RUNNING → WAITING / TIMED_WAITING

sleep():
--------
RUNNING → TIMED_WAITING

================================================================================
*/

/*
================================================================================
7. COMMON INTERVIEW QUESTIONS
================================================================================

Q1: Does yield() guarantee other thread execution?
A: No, it is only a hint.

Q2: Does sleep() release lock?
A: No.

Q3: Does join() release lock?
A: No.

Q4: Can join() cause deadlock?
A: Yes, if threads join on each other.

Q5: Which method is static?
A: yield() and sleep().

================================================================================
*/

/*
================================================================================
8. COMMON BEGINNER MISTAKES
================================================================================

❌ Expecting yield() to force scheduling
❌ Using sleep() for synchronization
❌ Forgetting InterruptedException
❌ Misusing join() inside synchronized blocks

================================================================================
*/

/*
================================================================================
9. KEY INTERVIEW ONE-LINERS
================================================================================

✔ yield() is just a hint to scheduler
✔ join() is used for thread coordination
✔ sleep() pauses thread for fixed time
✔ sleep() and join() throw InterruptedException
✔ None of these methods release monitor lock
✔ yield() does not block the thread

================================================================================
END OF FILE
================================================================================
*/
