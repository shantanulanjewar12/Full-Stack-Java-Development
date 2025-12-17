/*
================================================================================
FILE NAME  : LISTS_LinkedList_Full_Notes.java
FOLDER     : LISTS
TOPIC      : Java LinkedList – COMPLETE THEORY + NOTES + EXAMPLES
LEVEL      : Beginner → Advanced (Interview Ready)
================================================================================

⚠️ This file is a COMPLETE NOTE + CODE + EXPLANATION document.
⚠️ Read comments carefully – they explain WHAT, WHY, HOW.

================================================================================
1. WHAT IS LINKEDLIST?
================================================================================
- LinkedList is a DOUBLY LINKED LIST implementation of:
  ✔ List
  ✔ Deque
  ✔ Queue

- Elements are NOT stored in continuous memory.
- Each element is stored inside a NODE.

Node structure:
[data | prev | next]

================================================================================
2. HIERARCHY
================================================================================
Iterable
  ↓
Collection
  ↓
List        Deque
   \        /
    \      /
     LinkedList

Package:
java.util.LinkedList

================================================================================
3. WHY LINKEDLIST?
================================================================================
Problems with ArrayList:
- Insertion/deletion in middle is costly (shifting required)

LinkedList Advantages:
✔ Fast insertion/deletion
✔ No resizing
✔ Implements List + Queue + Deque

================================================================================
4. FEATURES OF LINKEDLIST
================================================================================
✔ Maintains insertion order
✔ Allows duplicates
✔ Allows multiple nulls
✔ Not thread-safe
✔ No random access
✔ Bidirectional traversal

================================================================================
5. INTERNAL WORKING
================================================================================
- Uses DOUBLY LINKED LIST
- Each node has:
  data
  previous node reference
  next node reference

Traversal:
- get(index) → O(n)
- add/remove at ends → O(1)

================================================================================
6. TIME & SPACE COMPLEXITY
================================================================================
Access by index        O(n)
Insert at beginning   O(1)
Insert at middle      O(n)
Delete at beginning   O(1)
Delete at middle      O(n)
Search                 O(n)

Space Complexity: O(n) (extra memory for pointers)

================================================================================
7. LINKEDLIST CREATION
================================================================================
*/

import java.util.*;

public class LISTS_LinkedList_Full_Notes {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        /*
        =================================================================================
        8. BASIC COLLECTION METHODS
        =================================================================================
        */

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(null);

        list.size();        // number of elements
        list.isEmpty();     // true / false
        list.contains(20);  // search element

        /*
        =================================================================================
        9. LIST-SPECIFIC METHODS
        =================================================================================
        */

        // add(int index, E element)
        list.add(1, 15);   // shifts references

        // get(int index)
        int val = list.get(2);  // traversal required

        // set(int index, E element)
        list.set(2, 99);

        // remove(int index)
        list.remove(1);

        // indexOf(Object o)
        list.indexOf(30);

        // lastIndexOf(Object o)
        list.lastIndexOf(30);

        /*
        =================================================================================
        10. QUEUE METHODS (FIFO)
        =================================================================================
        */

        list.offer(100);      // addLast
        list.poll();          // removeFirst
        list.peek();          // getFirst

        /*
        =================================================================================
        11. DEQUE METHODS (DOUBLE ENDED)
        =================================================================================
        */

        list.addFirst(1);
        list.addLast(200);

        list.removeFirst();
        list.removeLast();

        list.getFirst();
        list.getLast();

        /*
        =================================================================================
        12. STACK BEHAVIOR USING LINKEDLIST
        =================================================================================
        */

        list.push(500);   // addFirst
        list.pop();       // removeFirst

        /*
        =================================================================================
        13. ITERATORS
        =================================================================================
        */

        // Iterator (forward)
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }

        // Descending iterator (reverse traversal)
        Iterator<Integer> dit = list.descendingIterator();
        while (dit.hasNext()) {
            dit.next();
        }

        /*
        =================================================================================
        14. LISTITERATOR (BIDIRECTIONAL)
        =================================================================================
        */

        ListIterator<Integer> li = list.listIterator();

        while (li.hasNext()) {
            li.next();
        }

        while (li.hasPrevious()) {
            li.previous();
        }

        /*
        =================================================================================
        15. subList(fromIndex, toIndex)
        =================================================================================
        */

        // fromIndex → INCLUSIVE
        // toIndex   → EXCLUSIVE
        List<Integer> sub = list.subList(0, 2);

        // subList is VIEW
        // changes affect original list

        /*
        =================================================================================
        16. THREAD SAFETY
        =================================================================================
        */

        // LinkedList is NOT thread-safe
        List<Integer> syncList = Collections.synchronizedList(new LinkedList<>());

        /*
        =================================================================================
        17. COMPARISON: ARRAYLIST vs LINKEDLIST
        =================================================================================
        */

        /*
        ArrayList:
        ✔ Fast access
        ❌ Slow insertion/deletion

        LinkedList:
        ✔ Fast insertion/deletion
        ❌ Slow access
        */

        /*
        =================================================================================
        18. INTERVIEW POINTS
        =================================================================================
        */

        /*
        ✔ Implements List, Queue, Deque
        ✔ No RandomAccess
        ✔ Best when frequent insertion/deletion
        ✔ Uses doubly linked list
        ✔ Allows null & duplicates
        */
    }
}
