// ============================================================================
// _9_Memory_Management.java
// ============================================================================
// 💡 Topic: Java Memory Management (Exam + Interview Friendly)
// ----------------------------------------------------------------------------
// This single file contains EVERYTHING for your learning:
// 1. Detailed comments explaining:
//      - Stack vs Heap
//      - Primitive vs Reference types
//      - String Pool
//      - Types of References: Strong, Weak, Soft
//      - Garbage Collection (Mark & Sweep, Minor/ Major GC)
//      - Heap structure: Young Gen (Eden, S0, S1), Old Gen, Metaspace
//      - Types of Garbage Collectors (Serial, Parallel, CMS, G1)
// 2. Java code examples demonstrating:
//      - How variables are stored in Stack / Heap
//      - How references work
//      - WeakReference & SoftReference
//      - Suggesting garbage collection
// 3. At the END of the file: a big Interview Q&A block
//      - 15+ important questions with simple answers
//
// You can:
//  - Read comments for theory
//  - Run main() for practical understanding
//  - Revise interview Q&A from the bottom section
// ============================================================================

import java.lang.ref.WeakReference;
import java.lang.ref.SoftReference;

public class _24_Memory_Management {

    // =========================================================================
    // 🔹 Helper Class: Person (simple POJO used for heap objects)
    // =========================================================================
    // This class is just used to create objects that will live in HEAP memory.
    static class Person {
        String name;

        Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "'}";
        }
    }

    // =========================================================================
    // 🔹 MAIN METHOD
    // =========================================================================
    public static void main(String[] args) {

        System.out.println("=== 1. Stack vs Heap Example ===");
        stackAndHeapExample();

        System.out.println("\n=== 2. Strong Reference Example ===");
        strongReferenceExample();

        System.out.println("\n=== 3. Weak Reference Example ===");
        weakReferenceExample();

        System.out.println("\n=== 4. Soft Reference Example ===");
        softReferenceExample();

        System.out.println("\n=== 5. Suggesting Garbage Collection ===");
        suggestGarbageCollection();

        System.out.println("\nPROGRAM END");
    }

    // =========================================================================
    // 1️⃣ STACK vs HEAP EXAMPLE
    // =========================================================================
    /*
        THEORY (Short & Exam Friendly):

        🔹 STACK MEMORY:
        - Stores: local variables, method call frames, and references to objects.
        - One stack per thread.
        - Follows LIFO (Last In First Out).
        - When a method finishes, its local variables are removed from the stack.
        - If stack is full → java.lang.StackOverflowError.

        🔹 HEAP MEMORY:
        - Stores: all objects and arrays.
        - Shared by all threads.
        - Managed by Garbage Collector (GC).
        - If heap is full → java.lang.OutOfMemoryError.

        🔹 Primitive vs Reference:
        - Primitive variables (int, double, boolean, etc.) are stored directly
          on stack (inside current method frame).
        - Reference variables are stored on stack, but they point to objects
          which live on heap.

        🔹 String Pool:
        - A special area inside heap where String LITERALS are stored.
        - "24" literal is stored once. Multiple variables can point to same
          literal to save memory.

        In this method, we create:
          - A primitive int
          - A Person object
          - String literals and a new String object
          - Call another method to see separate stack frame
     */
    private static void stackAndHeapExample() {
        // primitive -> stored directly on STACK (inside this method's stack frame)
        int primitiveVariable = 10;

        // reference variable ON STACK -> pointing to Person object ON HEAP
        Person personObj = new Person("Stack-Heap Demo");

        // String literal -> stored in STRING POOL (inside heap)
        String stringLiteral1 = "24";
        String stringLiteral2 = "24"; // points to SAME string object as stringLiteral1

        // Explicitly creating a new String object -> new HEAP object (not pooled)
        String normalString = new String("24");

        System.out.println("primitiveVariable (STACK): " + primitiveVariable);
        System.out.println("personObj (STACK ref -> HEAP obj): " + personObj);
        System.out.println("stringLiteral1 (String Pool): " + stringLiteral1);
        System.out.println("stringLiteral2 (same pooled literal): " + stringLiteral2);
        System.out.println("normalString (separate HEAP object): " + normalString);

        // Call another method – this will create a NEW STACK FRAME
        memoryManagementTest(personObj, stringLiteral1);
        // After this method returns, its local variables are removed from stack.
    }

    /*
        This method has its own stack frame.
        New local variables created inside it exist only until this method finishes.
     */
    private static void memoryManagementTest(Person personParam, String literalParam) {
        // New local primitive (on THIS method's stack frame)
        int localPrimitive = 20;

        // Another String literal (goes to String Pool, reused if already present)
        String localLiteral = "Memory";

        System.out.println("\n[Inside memoryManagementTest()]");
        System.out.println("personParam: " + personParam);
        System.out.println("literalParam: " + literalParam);
        System.out.println("localPrimitive: " + localPrimitive);
        System.out.println("localLiteral: " + localLiteral);

        // When this method ends:
        // - localPrimitive, localLiteral, personParam, literalParam
        //   are removed from stack.
        // - But personParam was referring to Person object in heap, and
        //   that object may still be referenced by main(), so it is NOT collected.
    }

    // =========================================================================
    // 2️⃣ STRONG REFERENCE EXAMPLE
    // =========================================================================
    /*
        THEORY:

        🔹 Strong Reference:
        - Normal reference that we use every day.
        - Example: Person p = new Person("A");
        - As long as a strong reference is pointing to an object,
          Garbage Collector will NOT remove that object.

        🔹 When object becomes eligible for GC?
        - When no strong reference points to it.
        - Example:
              Person p = new Person("A");
              p = new Person("B");
          Now object "A" has no reference -> eligible for GC.
     */
    private static void strongReferenceExample() {
        // Strong reference
        Person pobj = new Person("Strong-Ref Person");

        System.out.println("Strong reference created: " + pobj);

        // Reassign reference to a new object
        pobj = new Person("Another Person");
        System.out.println("Strong reference now points to: " + pobj);

        // The first "Strong-Ref Person" object is now unreferenced -> eligible for GC.
        // GC will remove it at some later time when it runs.
    }

    // =========================================================================
    // 3️⃣ WEAK REFERENCE EXAMPLE
    // =========================================================================
    /*
        THEORY:

        🔹 WeakReference (java.lang.ref.WeakReference):
        - Does NOT prevent object from being garbage collected.
        - If only weak references refer to an object, GC can collect that object
          on the next garbage collection cycle.
        - weakRef.get() returns:
            - object, if it is still not collected
            - null, if object has been collected

        🔹 Use Case:
        - For caches where you don't want objects to stay in memory forever.
        - If memory is needed, GC can clear weakly-referenced objects easily.
     */
    private static void weakReferenceExample() {
        Person person = new Person("Weak-Ref Person");

        // Create a WeakReference to 'person'
        WeakReference<Person> weakPersonRef = new WeakReference<>(person);

        System.out.println("Original strong ref: " + person);
        System.out.println("Weak reference get(): " + weakPersonRef.get());

        // Remove strong reference
        person = null;

        // Suggest JVM to run GC (NOT guaranteed to run immediately)
        System.gc();

        // After GC, object may be cleared even though weakPersonRef exists
        Person fromWeakRef = weakPersonRef.get();

        if (fromWeakRef == null) {
            System.out.println("After GC: Weak reference object has been CLEARED (null)");
        } else {
            System.out.println("After GC: Weak reference still holds: " + fromWeakRef);
        }
    }

    // =========================================================================
    // 4️⃣ SOFT REFERENCE EXAMPLE
    // =========================================================================
    /*
        THEORY:

        🔹 SoftReference (java.lang.ref.SoftReference):
        - Like WeakReference but "stronger".
        - Object is kept in memory as long as JVM has enough memory.
        - When memory is LOW, GC can clear soft references.

        🔹 Use Case:
        - Good for implementing memory-sensitive caches.
        - Useful when we want to keep objects in cache but also allow GC to clear
          them if RAM is needed for more important work.
     */
    private static void softReferenceExample() {
        Person person = new Person("Soft-Ref Person");

        // Create a SoftReference
        SoftReference<Person> softPersonRef = new SoftReference<>(person);

        System.out.println("Original strong ref: " + person);
        System.out.println("Soft reference get(): " + softPersonRef.get());

        // Remove strong reference
        person = null;

        // Suggest GC
        System.gc();

        // Soft reference is cleared ONLY when JVM really needs memory.
        Person fromSoftRef = softPersonRef.get();

        if (fromSoftRef == null) {
            System.out.println("After GC: Soft reference object has been CLEARED (null)");
            System.out.println("=> This usually happens when memory is LOW.");
        } else {
            System.out.println("After GC: Soft reference still holds: " + fromSoftRef);
            System.out.println("=> JVM kept it because memory is still sufficient.");
        }
    }

    // =========================================================================
    // 5️⃣ SUGGESTING GARBAGE COLLECTION
    // =========================================================================
    /*
        THEORY:

        🔹 Garbage Collection:
        - Automatic process that removes unused (unreachable) objects from heap.
        - Uses algorithms like Mark & Sweep.

        🔹 Mark & Sweep (simple view):
        1. MARK: Start from root references (stack variables, static refs, etc.)
                 and mark all reachable objects.
        2. SWEEP: Delete all unmarked objects from heap.
        3. Optional: COMPACTION - move remaining objects together
           to avoid fragmentation and create continuous free memory blocks.

        🔹 System.gc():
        - Only a REQUEST for GC.
        - JVM decides whether to run GC or not.
        - No guarantee of immediate collection.
     */
    private static void suggestGarbageCollection() {
        // Create many temporary Person objects to fill some heap space
        for (int i = 0; i < 10_000; i++) {
            new Person("Temp Person " + i);  // no variable holds reference
        }

        System.out.println("Created many temporary Person objects.");

        // Request JVM to run GC (NO GUARANTEE that it will run immediately)
        System.out.println("Requesting garbage collection using System.gc() ...");
        System.gc();
        System.out.println("If JVM decides, it will run GC and free unreferenced objects.");
    }
}

/* =============================================================================
   🧠 THEORY: HEAP STRUCTURE (YOUNG GEN, OLD GEN, METASPACE)
   =============================================================================

   1️⃣ YOUNG GENERATION:
   ---------------------
   - Contains newly created objects.
   - Divided into:
       - Eden
       - Survivor 0 (S0)
       - Survivor 1 (S1)
   - Flow:
       - New objects created -> go into Eden.
       - When Eden fills, Minor GC is triggered:
            - Unreachable objects in Eden are deleted.
            - Reachable objects move to S0 or S1 and their age increases.
       - If an object's age crosses some threshold, it is promoted to Old Gen.

   2️⃣ OLD GENERATION:
   -------------------
   - Holds long-lived objects which survived multiple Minor GCs.
   - Garbage collection here is called Major GC.
   - Major GC is slower and less frequent.

   3️⃣ METASPACE (NON-HEAP):
   -------------------------
   - Stores class metadata, static variables, method info, constants, etc.
   - Before Java 8, this was called PermGen (Permanent Generation) and had
     fixed size -> could cause OutOfMemoryError: PermGen space.
   - From Java 8, Metaspace replaces PermGen and is usually expandable.

   =============================================================================
   🧠 THEORY: TYPES OF GARBAGE COLLECTORS
   =============================================================================

   1️⃣ Serial GC:
      - Uses a single thread for GC.
      - Simple but can cause long pause times.
      - Good for small applications with single CPU.

   2️⃣ Parallel GC:
      - Uses multiple threads for GC.
      - Faster than Serial GC, better throughput.
      - Still pauses application during GC, but for less time.

   3️⃣ Concurrent Mark-Sweep (CMS) GC:
      - Works mostly concurrently with the application.
      - Reduces pause time.
      - Performs marking and sweeping concurrently.
      - Doesn't compact memory, can cause fragmentation.

   4️⃣ G1 (Garbage-First) GC:
      - Modern collector.
      - Divides heap into small regions.
      - Collects regions with most garbage first.
      - Supports concurrent marking and compaction.
      - Designed to give predictable, short pause times.

   =============================================================================
   ✅ INTERVIEW QUESTIONS & ANSWERS (KEEP THIS FOR REVISION)
   =============================================================================

   Q1. Difference between Stack and Heap memory in Java?
   ------------------------------------------------------
   Answer:
   - Stack:
     - Stores: local variables, method call frames, and references.
     - One stack per thread.
     - Very fast, LIFO.
     - If full -> StackOverflowError.
   - Heap:
     - Stores: all objects and arrays.
     - Shared by all threads.
     - Managed by Garbage Collector.
     - If full -> OutOfMemoryError.

   Q2. Where are primitive and reference variables stored?
   -------------------------------------------------------
   Answer:
   - Primitive variables (int, double, boolean etc.) are stored directly on the stack.
   - Reference variables are stored on the stack, and they point to objects that live
     on the heap.

   Q3. What is the String Pool?
   ----------------------------
   Answer:
   - A special area in heap memory where String literals are stored.
   - If you write "hello" multiple times, Java stores only one literal and all
     variables can refer to the same object to save memory.

   Q4. What is Garbage Collection in Java?
   ---------------------------------------
   Answer:
   - Automatic memory management process.
   - It removes objects from heap that are no longer reachable (no live reference).
   - Helps prevent memory leaks and removes the need for manual free/delete.

   Q5. Can we force Garbage Collection in Java?
   -------------------------------------------
   Answer:
   - We cannot FORCE, we can only REQUEST using System.gc() or
     Runtime.getRuntime().gc().
   - JVM decides whether to run GC and when to run it.

   Q6. What is a Strong Reference?
   -------------------------------
   Answer:
   - Normal reference, like: Person p = new Person();
   - As long as p refers to the object, GC will not collect that object.
   - Only when p is set to null or points to another object, the old object becomes
     eligible for GC.

   Q7. What is a Weak Reference?
   -----------------------------
   Answer:
   - A reference that does not prevent object from being garbage collected.
   - Created using WeakReference<T>.
   - If only weak references exist, GC can delete the object on next cycle.
   - Used in caches where we don't want objects to stay permanently.

   Q8. What is a Soft Reference?
   -----------------------------
   Answer:
   - A reference that is cleared only when JVM really needs memory.
   - Created using SoftReference<T>.
   - Good for memory-sensitive caches: JVM keeps object in memory if possible,
     but clears it when heap is low.

   Q9. What is Young Generation and Old Generation?
   ------------------------------------------------
   Answer:
   - Young Generation:
     - Where new objects are created (Eden + S0 + S1).
     - GC here is called Minor GC.
     - Frequent and fast.
   - Old Generation:
     - Contains long-living objects which survived multiple Minor GCs.
     - GC here is Major GC.
     - Less frequent but heavier.

   Q10. What is Minor GC and Major GC?
   -----------------------------------
   Answer:
   - Minor GC:
     - Runs in Young Generation (Eden + Survivor spaces).
     - Fast and happens frequently.
   - Major GC:
     - Runs in Old Generation.
     - Slower and can cause longer pause times.

   Q11. What is Metaspace in Java?
   --------------------------------
   Answer:
   - A memory area outside the regular heap.
   - Stores class metadata, method info, constants, static variables, etc.
   - Replaced PermGen from Java 8.
   - Metaspace can grow dynamically, reducing OutOfMemoryError issues related
     to class metadata.

   Q12. Explain Mark & Sweep in simple words.
   -----------------------------------------
   Answer:
   - Mark:
     - GC starts from root references (like stack, static variables)
       and marks all reachable objects.
   - Sweep:
     - GC removes all unmarked (unreachable) objects from heap.
   - Optional: Compaction:
     - Move remaining objects together to remove gaps and improve memory usage.

   Q13. Difference between Serial GC and Parallel GC?
   --------------------------------------------------
   Answer:
   - Serial GC:
     - Single-threaded.
     - Simple but can cause long pause times.
   - Parallel GC:
     - Multi-threaded.
     - Faster garbage collection.
     - Better for multi-core systems and high throughput apps.

   Q14. What is CMS (Concurrent Mark-Sweep) GC?
   --------------------------------------------
   Answer:
   - A collector that tries to do most of its work concurrently with the application.
   - Reduces pause times.
   - Mark and sweep phases are partially concurrent.
   - Does not compact memory, so it can lead to fragmentation.

   Q15. What is G1 (Garbage First) GC?
   -----------------------------------
   Answer:
   - A modern garbage collector designed for large heaps.
   - Divides heap into small regions.
   - Collects regions with maximum garbage first (hence "Garbage First").
   - Supports concurrent marking, compaction, and aims for predictable,
     short pause times.

   =============================================================================
   END OF FILE: _9_Memory_Management.java
   =============================================================================
*/
