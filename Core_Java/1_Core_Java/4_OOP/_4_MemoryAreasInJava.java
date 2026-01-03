/*
===============================================================================
💡 WHAT IS JAVA MEMORY?
===============================================================================
When a Java program runs, the JVM (Java Virtual Machine) divides the memory 
into several different areas to manage data efficiently.

👉 Java memory is mainly divided into:
   1️⃣ Stack Area
   2️⃣ Heap Area
   3️⃣ Method Area (also known as Metaspace in Java 8+)
   4️⃣ PC Register
   5️⃣ Native Method Stack

===============================================================================
🔹 WHY DOES JAVA DIVIDE MEMORY INTO AREAS?
===============================================================================
✅ To optimize memory usage.
✅ To separate object storage (Heap) from method execution (Stack).
✅ To make Garbage Collection easier.
✅ To improve performance and debugging.

===============================================================================
🔹 DIAGRAM (Simplified View)
===============================================================================
                  +----------------------------------+
                  |          Method Area             |
                  |  → Class info, static vars       |
                  |  → method bytecode, constants    |
                  +----------------------------------+
                  |              Heap                |
                  |  → Objects & Instance variables   |
                  |  → Managed by Garbage Collector   |
                  +----------------------------------+
                  |              Stack               |
                  |  → Method calls (frames)          |
                  |  → Local variables, references    |
                  +----------------------------------+
                  |           PC Register            |
                  |  → Current executing instruction  |
                  +----------------------------------+
                  |       Native Method Stack        |
                  |  → Code written in C/C++ (JNI)    |
                  +----------------------------------+

===============================================================================
🔹 1️⃣ STACK AREA
===============================================================================
🧠 Definition:
Stack memory stores method call information and local variables.

👉 Key Points:
- One stack per thread.
- Stores:
  - Local variables
  - Method call information (frames)
  - References to objects in the Heap
- Memory is allocated and freed automatically (LIFO).
- When a method finishes, its stack frame is removed.

👉 Example:
*/

class MemoryExample {
    int instanceVar = 10; // Stored in Heap (object variable)
    static int staticVar = 20; // Stored in Method Area

    void show() {
        int localVar = 30; // Stored in Stack
        System.out.println("Local Var: " + localVar);
        System.out.println("Instance Var: " + instanceVar);
        System.out.println("Static Var: " + staticVar);
    }
}

/*
===============================================================================
🔹 2️⃣ HEAP AREA
===============================================================================
🧠 Definition:
Heap is used for storing objects and instance variables.

👉 Key Points:
- Shared among all threads.
- Objects are created using `new`.
- Garbage Collector (GC) automatically removes unused objects.
- Large and slower compared to Stack.

👉 Example:
MemoryExample obj = new MemoryExample();
Here:
  - obj reference → stored in Stack
  - actual object → stored in Heap

===============================================================================
🔹 3️⃣ METHOD AREA (or METASPACE in Java 8+)
===============================================================================
🧠 Definition:
Stores class-level information and static data.

👉 Key Points:
- Contains:
  - Class metadata (name, methods, fields)
  - Static variables
  - Constant pool
  - Method bytecode
- Shared by all threads.

👉 Example:
static int staticVar = 100; // Stored in Method Area

===============================================================================
🔹 4️⃣ PC REGISTER
===============================================================================
🧠 Definition:
Each thread has its own Program Counter (PC) register that stores
the address of the current instruction being executed.

👉 Purpose:
- Keeps track of which line/bytecode instruction the JVM is executing.
- Updated automatically as program runs.

===============================================================================
🔹 5️⃣ NATIVE METHOD STACK
===============================================================================
🧠 Definition:
Used for executing native (non-Java) code — typically written in C/C++ using JNI.

👉 Example:
When Java interacts with system libraries (like C code for file handling).

===============================================================================
🔹 EXAMPLE CODE SHOWING STACK & HEAP WORKING
===============================================================================
*/

public class _4_MemoryAreasInJava {
    public static void main(String[] args) {

        System.out.println("====== MEMORY AREAS DEMONSTRATION ======");

        MemoryExample obj1 = new MemoryExample(); // object in Heap
        MemoryExample obj2 = new MemoryExample(); // another object in Heap

        obj1.instanceVar = 99;  // modifies only obj1's heap memory
        obj2.instanceVar = 55;  // modifies obj2's separate memory in heap

        obj1.show();
        obj2.show();

        // 🔹 Local reference variables (obj1, obj2) stored in Stack
        // 🔹 Objects created using new → stored in Heap
        // 🔹 Static variable → stored in Method Area
    }
}

/*
===============================================================================
🔹 MEMORY USAGE FLOW (EXPLANATION)
===============================================================================

Step 1️⃣: Class is loaded → JVM loads class info into Method Area.
Step 2️⃣: Main() method starts → Stack frame for main() created.
Step 3️⃣: Objects created using `new` → stored in Heap.
Step 4️⃣: Local references → stored in Stack.
Step 5️⃣: When main() ends → stack memory cleared.
Step 6️⃣: GC deletes unreferenced heap objects automatically.

===============================================================================
🔹 STACK vs HEAP (Comparison Table)
===============================================================================
| Feature             | Stack Memory                   | Heap Memory                        |
|---------------------|----------------------------------|------------------------------------|
| Usage               | Method execution & local vars    | Object & instance variables        |
| Lifetime            | Until method ends                | Until GC removes it                |
| Access Speed        | Fast                             | Slower                             |
| Managed By          | JVM (automatically)              | Garbage Collector                  |
| Thread Sharing      | Private (per thread)             | Shared among all threads           |
| Allocation Order    | LIFO (Last In First Out)         | Random                             |
| Contains            | Method calls, local variables    | Objects, instance variables        |

===============================================================================
🔹 GARBAGE COLLECTION (Short Note)
===============================================================================
💡 Garbage Collection (GC):
Automatic process of removing unused objects from Heap memory.

👉 Triggered automatically by JVM.
👉 You can suggest GC using:
    System.gc();

But JVM decides when to actually run it.

===============================================================================
🔹 INTERVIEW SUMMARY (SPEAKING POINTS)
===============================================================================

👉 1. JVM divides memory mainly into 5 parts: Stack, Heap, Method Area, PC Register, and Native Method Stack.
👉 2. Stack → local variables, method calls (per thread).
👉 3. Heap → objects and instance variables (shared).
👉 4. Method Area → class info, static vars, constant pool.
👉 5. PC Register → tracks instruction execution.
👉 6. Native Method Stack → for native (C/C++) code.
👉 7. Garbage Collector handles memory cleanup automatically.
👉 8. Static → Method Area, Instance → Heap, Local → Stack.

===============================================================================
🔹 BONUS INTERVIEW QUESTIONS
===============================================================================

Q1️⃣: What happens if Heap memory is full?
A: JVM throws java.lang.OutOfMemoryError.

Q2️⃣: Can two threads access same object in Heap?
A: Yes, because Heap is shared among all threads.

Q3️⃣: Is Stack memory thread-safe?
A: Yes, because each thread has its own Stack.

Q4️⃣: What is stored in Method Area?
A: Class structure, static variables, and method bytecode.

Q5️⃣: When does Garbage Collector run?
A: Automatically when JVM determines memory is low or object is unreachable.

===============================================================================
*/
