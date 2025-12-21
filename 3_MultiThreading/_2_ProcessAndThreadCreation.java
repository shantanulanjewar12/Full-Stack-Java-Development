/*
================================================================================
1. BEFORE MULTITHREADING – UNDERSTAND PROCESS & THREAD
================================================================================

Before learning multithreading, we MUST understand:
✔ What is a PROCESS?
✔ What is a THREAD?
✔ How JVM creates and manages them

Interviewers expect this mental model.

================================================================================
*/

/*
================================================================================
2. WHAT IS A PROCESS?
================================================================================

✔ Definition:
- A Process is an instance of a program that is currently executing.

✔ Key Points:
- Created by the Operating System
- Has its OWN memory space
- Is isolated from other processes
- Heavyweight

✔ Example:
- Running `java Test` creates ONE Java process
- Running it again creates ANOTHER process

================================================================================
*/

/*
================================================================================
3. JAVA PROGRAM → PROCESS CREATION (STEP BY STEP)
================================================================================

STEP 1: Write Java code
--------------------------------
class Test {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}

STEP 2: Compile
--------------------------------
javac Test.java
→ Generates Test.class (BYTECODE)

✔ Bytecode is platform-independent
✔ Still NO process, NO thread

STEP 3: Execute
--------------------------------
java Test

➡ THIS is where everything starts

================================================================================
*/

/*
================================================================================
4. WHAT HAPPENS WHEN WE RUN `java Test`?
================================================================================

1️⃣ OS creates a NEW PROCESS
2️⃣ JVM instance is created inside that process
3️⃣ Memory is allocated to JVM
4️⃣ JVM creates MAIN THREAD
5️⃣ main() method starts execution

📌 One `java` command = One process = One JVM

================================================================================
*/

/*
================================================================================
5. JVM MEMORY ALLOCATION (VERY IMPORTANT)
================================================================================

Each Java process (JVM) gets its own memory:

JVM Memory Areas:
--------------------------------
✔ Code Segment
✔ Data Segment
✔ Heap
✔ Threads (Stack, PC, Registers)

Heap Size can be controlled using:
--------------------------------
java -Xms256m -Xmx2g MainClass

-Xms → Initial heap size
-Xmx → Maximum heap size

If memory exceeds Xmx → OutOfMemoryError

================================================================================
*/

/*
================================================================================
6. MEMORY SEGMENTS EXPLAINED
================================================================================
*/

/*
--------------------------------
CODE SEGMENT
--------------------------------
- Contains compiled BYTECODE
- Read-only
- Shared among all threads in SAME process
*/

/*
--------------------------------
DATA SEGMENT
--------------------------------
- Contains static and global variables
- Shared among all threads
- Synchronization is required
*/

/*
--------------------------------
HEAP
--------------------------------
- Objects created using `new`
- Shared among all threads of SAME process
- NOT shared across processes
- Needs synchronization
*/

/*
--------------------------------
STACK
--------------------------------
- Each thread has its OWN stack
- Stores:
  ✔ Method calls
  ✔ Local variables
- Thread-safe by nature
*/

/*
--------------------------------
REGISTER
--------------------------------
- Used by CPU
- Helps in execution & context switching
- Each thread has its own registers
*/

/*
--------------------------------
PROGRAM COUNTER (PC)
--------------------------------
- Points to current instruction
- Increments after execution
- Each thread has its own PC
*/

/*
================================================================================
7. THREAD IN JAVA
================================================================================

✔ Definition:
- A thread is the smallest unit of execution.
- Runs inside a process.
- Multiple threads can exist inside one process.

✔ Key Property:
- Threads SHARE memory (heap, data)
- Threads have their OWN execution context

================================================================================
*/

/*
================================================================================
8. MAIN THREAD (AUTOMATIC THREAD)
================================================================================

When JVM starts:
✔ JVM automatically creates a thread called "main"
✔ main thread executes:
    public static void main(String[] args)

📌 So every Java program is MULTITHREADED by default.

Other JVM threads:
- Garbage Collector
- JIT Compiler
- Signal Dispatcher

================================================================================
*/

public class _2_ProcessAndThreadCreation {

    public static void main(String[] args) {

        /*
        ================================================================================
        THIS CODE IS EXECUTED BY MAIN THREAD
        ================================================================================
        */

        System.out.println("Program started by: " +
                Thread.currentThread().getName());

        /*
        ================================================================================
        STEP 1: THREAD OBJECT CREATION
        ================================================================================
        */

        Thread t1 = new Thread(new WorkerTask());

        /*
        At this point:
        ❌ No new thread is created
        ✔ Only Thread object exists in HEAP
        */

        /*
        ================================================================================
        STEP 2: THREAD START
        ================================================================================
        */

        t1.start();

        /*
        What happens internally?
        -------------------------
        1️⃣ JVM requests OS to create native thread
        2️⃣ OS allocates:
            - New Stack
            - New Program Counter
            - New Registers
        3️⃣ Thread state becomes RUNNABLE
        4️⃣ Thread Scheduler decides execution
        */

        /*
        ================================================================================
        STEP 3: CONCURRENT EXECUTION
        ================================================================================
        */

        System.out.println("Main thread continues execution");

        /*
        Output order is NOT guaranteed
        */
    }
}

/*
================================================================================
9. RUNNABLE TASK (THREAD LOGIC)
================================================================================
*/

class WorkerTask implements Runnable {

    @Override
    public void run() {

        /*
        This method is executed by CHILD THREAD
        */

        System.out.println("Worker thread running: " +
                Thread.currentThread().getName());

        /*
        Execution Flow:
        - PC points to instruction
        - Instruction executes
        - PC increments
        - Context switching may occur
        */
    }
}

/*
================================================================================
10. IMPORTANT DIFFERENCE: start() vs run()
================================================================================

✔ start():
- Creates new thread
- Allocates resources
- Calls run() internally

❌ run():
- Normal method call
- Executes on SAME thread
- No new thread created

================================================================================
*/

/*
================================================================================
11. THREAD SCHEDULING & CONTEXT SWITCHING
================================================================================

✔ Thread Scheduler:
- Decides which thread runs
- Based on:
  ✔ Time slicing
  ✔ CPU cores
  ✔ Priority

✔ Context Switching:
- CPU saves current thread state
- Loads next thread state
- Expensive operation

================================================================================
*/

/*
================================================================================
12. THREAD TERMINATION
================================================================================

A thread dies when:
✔ run() method finishes
✔ Unhandled exception occurs

Thread state → TERMINATED

Resources are released.

================================================================================
*/

/*
================================================================================
13. COMPLETE EXECUTION FLOW (ONE LOOK)
================================================================================

.java file
   ↓
javac (compile)
   ↓
.class (bytecode)
   ↓
java MainClass
   ↓
OS creates PROCESS
   ↓
JVM instance created
   ↓
Memory allocated
   ↓
Main thread created
   ↓
main() executes
   ↓
New threads via start()
   ↓
Scheduler executes threads
   ↓
Threads terminate
   ↓
Process ends

================================================================================
*/

/*
================================================================================
14. INTERVIEW QUESTIONS (VERY IMPORTANT)
================================================================================

Q1: Does JVM create a process or OS?
A: OS creates process, JVM runs inside it.

Q2: Is main thread created by programmer?
A: No, JVM creates it automatically.

Q3: Do threads share heap?
A: Yes, within the same process.

Q4: Why synchronization is needed?
A: Because heap and data segment are shared.

Q5: What happens if start() is called twice?
A: IllegalThreadStateException.

================================================================================
*/

/*
================================================================================
15. KEY INTERVIEW ONE-LINERS
================================================================================

✔ One Java execution = One process = One JVM
✔ Every Java program starts with main thread
✔ Threads share heap but not stack
✔ start() creates thread, run() does not
✔ Each thread has its own PC & registers

================================================================================
END OF FILE
================================================================================
*/
