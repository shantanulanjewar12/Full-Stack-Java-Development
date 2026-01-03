// /*
// ===============================================================================
// 📌 _12_JavaMemoryModel_Heap_Stack_GC.java
// ===============================================================================
// This file explains how Java manages memory at runtime using the JVM Memory Model.

// Understanding memory model is CRUCIAL for:
// ✔ Object lifecycle
// ✔ Garbage Collection (GC)
// ✔ Performance and optimization
// ✔ Interview Deep Concepts

// ===============================================================================
// 📌 JVM MEMORY STRUCTURE
// --------------------------------
// JVM memory is divided into the following major parts:

// 1️⃣ Stack Memory
// 2️⃣ Heap Memory
// 3️⃣ Method Area (a.k.a. MetaSpace in newer JVM)
// 4️⃣ Program Counter Register
// 5️⃣ Native Method Stack

// ===============================================================================
// 1️⃣ STACK MEMORY (Fast memory - LIFO)
// -------------------------------------
// ✔ Stores:
//    - Local variables
//    - Method call frames
//    - Primitive values
//    - References to objects stored in heap

// ✔ Managed per-thread → every thread has its own stack.

// ✔ Memory is freed when method exits (automatic cleanup).

// Example:
// ---------
// */

// class StackDemo {

//     void methodA() {
//         int x = 10;   // stored in stack
//         methodB();
//     }

//     void methodB() {
//         int y = 20;   // stored in stack
//     }
// }

// /*
// Notebook Summary:
// ✔ Stack stores method calls & local variables.
// ✔ Each thread has its own stack.
// ✔ Memory freed when method exits.

// ===============================================================================
// 2️⃣ HEAP MEMORY (Shared Memory)
// --------------------------------
// ✔ Stores:
//    - Objects
//    - Instance variables
//    - Arrays

// ✔ Shared across all threads.

// ✔ Managed by Garbage Collector (GC).

// Example:
// ---------
// */

// class HeapDemo {
//     String name = "Shantanu"; // stored in heap
// }

// /*
// Notebook Summary:
// ✔ Heap stores objects, arrays, instance members.
// ✔ Shared across threads.
// ✔ Garbage Collector manages it.

// ===============================================================================
// 3️⃣ METHOD AREA (MetaSpace)
// --------------------------------
// ✔ Stores:
//    - Class metadata
//    - Static variables
//    - Constant pool
//    - Method bytecode

// ✔ Loaded once per class.

// Notebook Summary:
// ✔ Method Area stores class-level info (static data, bytecode, constant pool).

// ===============================================================================
// 4️⃣ Program Counter (PC Register)
// --------------------------------
// ✔ Holds address of currently executing JVM instruction.

// Notebook Summary:
// ✔ PC register keeps track of instruction execution.

// ===============================================================================
// 5️⃣ Native Method Stack
// --------------------------------
// ✔ Used when Java interacts with native languages (C/C++ via JNI).

// Notebook Summary:
// ✔ Used for native method execution (JNI support).

// ===============================================================================
// 📌 Memory Diagram (Interview Style)
// -----------------------------------

//                       ┌───────────────────────────┐
//                       │         Method Area       │
//                       │ (Static, Class Info, CP)  │
//                       └───────────────────────────┘
//                                    │
//                                    ▼
//                       ┌───────────────────────────┐
//                       │          Heap             │
//                       │  (Objects, Arrays, etc.)  │
//                       └───────────────────────────┘
//                        ▲                        ▲
//                        │                        │
//                ┌───────────────┐      ┌───────────────────┐
//                │  Stack Thread1 │      │ Stack Thread2     │
//                │ (Local Vars)   │      │ (Local Vars)      │
//                └───────────────┘      └───────────────────┘

// ===============================================================================
// 📌 GARBAGE COLLECTION (GC)
// ===============================================================================
// Garbage Collector removes objects from heap memory that are NO LONGER REFERENCED.

// Example:
// ---------
// */

// class GarbageExample {
//     public static void main(String[] args) {
//         String s = new String("Hello");
//         s = new String("World"); // "Hello" becomes eligible for GC
//     }
// }

// /*
// Notebook Summary:
// ✔ Unreachable (unreferenced) objects are garbage collected automatically.

// ===============================================================================
// Types of Object References (Important for GC)
// ---------------------------------------------

// | Reference Type     | Eligible for GC? | Example Use |
// |-------------------|------------------|-------------|
// | Strong            | ❌ No            | Normal object reference |
// | Weak              | ✔ Yes            | WeakHashMap cache |
// | Soft              | ✔ Maybe          | Memory-sensitive caching |
// | Phantom           | ✔ Yes (after finalize) | Used in cleaner mechanisms |

// Example (WeakReference):
// ------------------------
// */

// import java.lang.ref.WeakReference;

// class ReferenceDemo {
//     public static void main(String[] args) {
//         WeakReference<String> ref = new WeakReference<>(new String("Temp"));
//         System.gc();
//         System.out.println(ref.get()); // may return null after GC
//     }
// }

// /*
// Notebook Summary:
// ✔ WeakReference objects can be collected anytime GC runs.

// ===============================================================================
// GC Algorithms (Interview-Level)
// --------------------------------

// ✔ Mark and Sweep
// ✔ Stop the World (STW) pause
// ✔ Generational GC (Young Gen, Old Gen)
// ✔ G1 Garbage Collector (modern JVM default)

// ===============================================================================
// finalize() and GC (Deprecated but asked)
// ----------------------------------------
// ✔ finalize() was called before object removal.
// ✔ Unreliable, deprecated since Java 9.

// Cleaner API and try-with-resources replaced finalize().

// Example (for understanding only):
// ---------------------------------
// */

// class FinalizeDemo {

//     @Override
//     protected void finalize() {
//         System.out.println("finalize() called before GC.");
//     }
// }

// class RunFinalize {
//     public static void main(String[] args) {
//         FinalizeDemo f = new FinalizeDemo();
//         f = null;
//         System.gc();
//     }
// }

// /*
// Notebook Summary:
// ✔ finalize() deprecated and unreliable.
// ✔ Use try-with-resources or Closeable interface.

// ===============================================================================
// Memory Leak in Java (Trick Question)
// ------------------------------------
// Even with GC, memory leaks can occur if objects remain referenced.

// Example:
// ---------
// */

// import java.util.ArrayList;
// class MemoryLeakDemo {
//     static ArrayList<Object> list = new ArrayList<>();
//     void addObject() {
//         list.add(new byte[1024 * 1024]); // object stored permanently
//     }
// }

// /*
// Notebook Summary:
// ✔ Memory leak occurs when objects stay referenced unintentionally.

// ===============================================================================
// Full Practical Flow Demo
// --------------------------------
// */

// class Person {
//     String name; // stored in heap
//     public Person(String name) { this.name = name; }
// }

// class MemoryDemo {
//     public static void main(String[] args) {

//         System.out.println("Creating objects");
//         Person p1 = new Person("Shantanu");
//         Person p2 = p1;

//         p1 = null; // object still reachable via p2 → NOT GC'ed

//         System.gc();
//         System.out.println("Garbage Collection requested");
//     }
// }

// /*
// ===============================================================================
// 📌 FINAL EXAM & INTERVIEW QUICK SUMMARY
// ---------------------------------------

// ✔ JVM Memory has Stack, Heap, Method Area, PC, Native Stack.
// ✔ Stack = method calls + local variables (thread-specific).
// ✔ Heap = objects and arrays (shared & GC-managed).
// ✔ Method Area stores static data & class info.
// ✔ Garbage Collector removes unreachable objects.
// ✔ finalize() deprecated → use try-with-resources or Cleaner.
// ✔ WeakReference objects are eligible for GC sooner.
// ✔ Memory leaks occur if objects remain referenced unnecessarily.

// ===============================================================================
// */
