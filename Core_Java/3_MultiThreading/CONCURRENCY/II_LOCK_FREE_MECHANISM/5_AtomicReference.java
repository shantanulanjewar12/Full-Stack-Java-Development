package CONCURRENCY.II_LOCK_FREE_MECHANISM;

import java.util.concurrent.atomic.AtomicReference;

/*
================================================================================
FILE NAME  : 5_AtomicReference.java
PACKAGE    : concurrency.lock_free_mechanism
TOPIC      : AtomicReference – Lock-Free Object Reference Updates using CAS
LEVEL      : Beginner → Advanced → Interview Ready
================================================================================

PURPOSE OF THIS FILE
-------------------
This file explains AtomicReference in COMPLETE depth:

✔ Why AtomicReference is needed
✔ Problems with normal object references in multithreading
✔ Why synchronized is costly for reference updates
✔ How AtomicReference works internally (CAS)
✔ AtomicReference methods explained
✔ Real-world use cases
✔ ABA problem & solution
✔ Interview questions & best practices

================================================================================
*/

/*
================================================================================
1. WHAT IS AtomicReference?
================================================================================

AtomicReference is a class from:
    java.util.concurrent.atomic

It provides:
✔ Thread-safe updates to object references
✔ Lock-free (non-blocking) behavior
✔ Atomic compare-and-set (CAS) on references

Key Point:
----------
AtomicReference works on OBJECT REFERENCES,
not primitive values.

================================================================================
*/

/*
================================================================================
2. WHY DO WE NEED AtomicReference?
================================================================================

Problem:
--------
In multithreaded environments, updating object references
can lead to race conditions.

Example:
--------
✔ Shared configuration object
✔ Cache replacement
✔ Immutable object swapping
✔ State transitions

Without AtomicReference:
------------------------
❌ Lost updates
❌ Inconsistent object state
❌ Race conditions

================================================================================
*/

/*
================================================================================
3. PROBLEM WITH NORMAL OBJECT REFERENCE
================================================================================
*/

class SharedConfig {

    String value;

    SharedConfig(String value) {
        this.value = value;
    }
}

class NormalReferenceExample {

    SharedConfig config = new SharedConfig("V1");

    public void update() {
        config = new SharedConfig("V2"); // NOT thread-safe
    }

    public SharedConfig get() {
        return config;
    }
}

/*
================================================================================
4. PROBLEM DEMO (RACE CONDITION)
================================================================================
*/

class NormalReferenceDemo {

    public static void main(String[] args) throws Exception {

        NormalReferenceExample example = new NormalReferenceExample();

        Thread t1 = new Thread(example::update);
        Thread t2 = new Thread(example::update);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(example.get().value);
        // ❌ Order & visibility not guaranteed
    }
}

/*
================================================================================
5. SOLUTION USING synchronized (BLOCKING)
================================================================================
*/

class SynchronizedReference {

    private SharedConfig config = new SharedConfig("V1");

    public synchronized void update() {
        config = new SharedConfig("V2");
    }

    public synchronized SharedConfig get() {
        return config;
    }
}

/*
================================================================================
6. SOLUTION USING AtomicReference (LOCK-FREE)
================================================================================
*/

class AtomicReferenceExample {

    AtomicReference<SharedConfig> config =
            new AtomicReference<>(new SharedConfig("V1"));

    public void update() {
        config.set(new SharedConfig("V2"));
    }

    public SharedConfig get() {
        return config.get();
    }
}

/*
================================================================================
7. AtomicReference DEMO
================================================================================
*/

class AtomicReferenceDemo {

    public static void main(String[] args) throws Exception {

        AtomicReferenceExample example = new AtomicReferenceExample();

        Thread t1 = new Thread(example::update);
        Thread t2 = new Thread(example::update);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(example.get().value); // ✅ Thread-safe
    }
}

/*
================================================================================
8. IMPORTANT AtomicReference METHODS
================================================================================

✔ get()                      → returns current reference
✔ set(T value)               → sets new reference
✔ lazySet(T value)           → weaker set (performance optimized)
✔ compareAndSet(exp, new)    → CAS operation
✔ getAndSet(newValue)

================================================================================
*/

/*
================================================================================
9. compareAndSet() EXAMPLE
================================================================================
*/

class AtomicReferenceCASDemo {

    public static void main(String[] args) {

        AtomicReference<String> ref =
                new AtomicReference<>("A");

        boolean success = ref.compareAndSet("A", "B");

        System.out.println("CAS Success : " + success);
        System.out.println("Value       : " + ref.get());

        // Output:
        // CAS Success : true
        // Value       : B
    }
}

/*
================================================================================
10. HOW AtomicReference WORKS INTERNALLY (CAS)
================================================================================

CAS Parameters:
---------------
✔ Memory location
✔ Expected reference
✔ New reference

Pseudo logic:
-------------
if (memory == expected) {
    memory = newValue;
    return true;
}
return false;

✔ Lock-free
✔ CPU-level atomic instruction
✔ Retry-based update

================================================================================
*/

/*
================================================================================
11. ABA PROBLEM (IMPORTANT INTERVIEW TOPIC)
================================================================================

Scenario:
---------
A → B → A

Thread T1:
----------
Reads value A

Thread T2:
----------
Changes A → B → A

Thread T1:
----------
CAS succeeds BUT data changed in between ❌

This is called:
--------------
ABA Problem

================================================================================
*/

/*
================================================================================
12. SOLUTION TO ABA PROBLEM
================================================================================

✔ Use versioning
✔ Use AtomicStampedReference
✔ Use AtomicMarkableReference

================================================================================
*/

/*
================================================================================
13. REAL-WORLD USE CASES
================================================================================

✔ Immutable object swapping
✔ Configuration reload
✔ State machines
✔ Cache replacement
✔ Lock-free linked structures

================================================================================
*/

/*
================================================================================
14. AtomicReference vs synchronized
================================================================================

AtomicReference:
----------------
✔ Lock-free
✔ High performance
✔ No blocking

synchronized:
-------------
❌ Blocking
❌ Context switching
✔ Easier for complex logic

================================================================================
*/

/*
================================================================================
15. WHEN TO USE AtomicReference?
================================================================================

✔ Object reference replacement
✔ Immutable objects
✔ Lock-free requirement
✔ High performance systems

================================================================================
*/

/*
================================================================================
16. WHEN NOT TO USE AtomicReference?
================================================================================

❌ Multiple related fields update together
❌ Complex transactional logic
❌ Need compound atomicity

================================================================================
*/

/*
================================================================================
17. INTERVIEW QUESTIONS
================================================================================

Q1. Is AtomicReference thread-safe?
Answer:
Yes, it uses CAS internally.

Q2. What problem does AtomicReference solve?
Answer:
Atomic updates of object references.

Q3. What is ABA problem?
Answer:
Reference changes A → B → A undetected by CAS.

Q4. How to solve ABA problem?
Answer:
AtomicStampedReference or versioning.

Q5. AtomicReference vs volatile?
Answer:
volatile ensures visibility, AtomicReference ensures atomicity.

================================================================================
*/

/*
================================================================================
18. KEY TAKEAWAYS
================================================================================

✔ AtomicReference enables lock-free object reference updates
✔ Uses CAS internally
✔ Faster than synchronized
✔ Beware of ABA problem
✔ Best for immutable object replacement

================================================================================
END OF FILE
================================================================================
*/
