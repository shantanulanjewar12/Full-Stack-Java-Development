/*
================================================================================
File Name : _2_JCF_Hierarchy.java
Topic     : Java Collections Framework – Complete Hierarchy Explanation
Author    : Notes for Learning + Interview Preparation
================================================================================

*/
public class _2_JCF_Hierarchy {

    public static void main(String[] args) {
        System.out.println("Java Collections Framework Hierarchy Explanation");   
    }
}

/*
================================================================================
1️⃣ ROOT OF COLLECTIONS FRAMEWORK
================================================================================

Iterable (interface)
    ↑
Collection (interface)

IMPORTANT:
- Iterable is the ROOT interface.
- It provides the iterator() method.
- Because of Iterable, we can use the enhanced for-loop (for-each).

Example:
for(Integer x : list) { }

Interview Question:
Q: Why Iterable is needed when Collection already exists?
A: Iterable enables traversal. Collection focuses on data storage.
*/


/*
================================================================================
2️⃣ Collection INTERFACE
================================================================================

Collection is the ROOT interface of:
- List
- Set
- Queue

(Collection DOES NOT include Map)

Why?
- Collection represents a group of individual elements.
- Map represents key-value pairs → conceptually different.

Common methods in Collection:
- add()
- remove()
- size()
- contains()
- isEmpty()
- iterator()

Interview Question:
Q: Why Map is not a child of Collection?
A: Because Map stores key-value pairs, not individual elements.
*/



/*
================================================================================
3️⃣ LIST HIERARCHY
================================================================================

Iterable
  ↓
Collection
  ↓
List (interface)
  ↓
Implementations:
- ArrayList
- LinkedList
- Vector
    ↓
    Stack

CHARACTERISTICS OF LIST:
✔ Maintains insertion order
✔ Allows duplicate elements
✔ Index-based access

------------------------------------------------
ArrayList
------------------------------------------------
- Backed by dynamic array
- Fast random access (O(1))
- Slow insertion/deletion in middle

Use when:
✔ Read operations are more than write

------------------------------------------------
LinkedList
------------------------------------------------
- Doubly linked list
- Fast insertion/deletion
- Slower random access

Also implements:
✔ List
✔ Deque
✔ Queue

------------------------------------------------
Vector (Legacy)
------------------------------------------------
- Synchronized (thread-safe)
- Slower than ArrayList
- Legacy class (not recommended)

------------------------------------------------
Stack (Legacy)
------------------------------------------------
- Extends Vector
- Follows LIFO
- push(), pop(), peek()

Interview Questions:
Q: Why Stack is legacy?
A: Because Deque provides better stack operations.

Q: Preferred stack implementation today?
A: ArrayDeque
*/



/*
================================================================================
4️⃣ SET HIERARCHY
================================================================================

Iterable
  ↓
Collection
  ↓
Set (interface)
  ↓
Sub-interfaces:
- SortedSet
- NavigableSet

Implementations:
- HashSet
- LinkedHashSet
- TreeSet

CHARACTERISTICS OF SET:
✔ No duplicate elements
✔ No index-based access

------------------------------------------------
HashSet
------------------------------------------------
- Uses Hashing
- No insertion order
- Allows ONE null

------------------------------------------------
LinkedHashSet
------------------------------------------------
- Maintains insertion order
- Slightly slower than HashSet

------------------------------------------------
TreeSet
------------------------------------------------
- Implements NavigableSet
- Sorted order (natural or comparator)
- No null allowed
- Uses Red-Black Tree

Interview Questions:
Q: Why TreeSet does not allow null?
A: Comparison with null causes NullPointerException.

Q: How duplicates are avoided in Set?
A: Using equals() and hashCode()
*/



/*
================================================================================
5️⃣ QUEUE & DEQUE HIERARCHY
================================================================================

Iterable
  ↓
Collection
  ↓
Queue (interface)
  ↓
Deque (interface)

Implementations:
- PriorityQueue
- ArrayDeque
- LinkedList

------------------------------------------------
Queue
------------------------------------------------
- FIFO order
- Used in scheduling, buffering

------------------------------------------------
PriorityQueue
------------------------------------------------
- Based on priority (not insertion order)
- Min-heap by default

------------------------------------------------
Deque (Double Ended Queue)
------------------------------------------------
- Insert/remove from both ends
- Can act as Stack or Queue

------------------------------------------------
ArrayDeque
------------------------------------------------
- Faster than Stack & LinkedList
- No capacity restriction
- No null allowed

Interview Question:
Q: Why ArrayDeque is preferred over Stack?
A: Faster + no synchronization overhead
*/


/*
================================================================================
6️⃣ MAP HIERARCHY (NOT PART OF COLLECTION)
================================================================================

Map (interface)
  ↓
Implementations:
- HashMap
- LinkedHashMap
- Hashtable
- TreeMap

Sub-interface:
- SortedMap
    ↓
    TreeMap

------------------------------------------------
HashMap
------------------------------------------------
- No order
- Allows ONE null key, multiple null values
- Not synchronized

------------------------------------------------
LinkedHashMap
------------------------------------------------
- Maintains insertion order
- Slightly slower than HashMap

------------------------------------------------
Hashtable (Legacy)
------------------------------------------------
- Synchronized
- No null key/value
- Very slow → avoid

------------------------------------------------
TreeMap
------------------------------------------------
- Sorted by key
- No null key
- Red-Black Tree

Interview Questions:
Q: Difference between HashMap and Hashtable?
A: Synchronization + null handling.

Q: Why TreeMap doesn’t allow null key?
A: Sorting comparison fails.
*/



/*
================================================================================
7️⃣ WHY JCF HIERARCHY IS DESIGNED THIS WAY?
================================================================================

✔ Interfaces provide abstraction
✔ Multiple implementations give flexibility
✔ Performance-based choices
✔ Backward compatibility (Vector, Hashtable)
✔ Thread-safe vs non-thread-safe options

This allows:
- Programming to interface
- Easy replacement of implementations


Explain what do you mean by concrete classes: A: Concrete classes are the actual implementations of interfaces that can be instantiated to create objects.

*/
