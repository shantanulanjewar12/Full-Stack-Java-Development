import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 ============================================================================
 📌 JAVA COLLECTION FRAMEWORK (JCF)
 📌 TOPIC: LIST INTERFACE – COMPLETE GUIDE
 ============================================================================
*/


/*
 ----------------------------------------------------------------------------
 1️⃣ WHAT IS LIST?
 ----------------------------------------------------------------------------
 - List is an ORDERED collection of objects.
 - It allows DUPLICATE elements.
 - Elements are stored and accessed using INDEX (starting from 0).
 - In List, insertion, deletion, and access can happen ANYWHERE.
 
 Example:
   [100, 200, 300]
    0    1    2
 ----------------------------------------------------------------------------
 */

/*
 ----------------------------------------------------------------------------
 2️⃣ LIST vs QUEUE
 ----------------------------------------------------------------------------
 QUEUE:
 - Follows FIFO (First In First Out)
 - Insertion → Rear
 - Removal   → Front
 - No random access

 LIST:
 - No FIFO/LIFO restriction
 - Insert / remove / access ANYWHERE using index
 - Random access allowed
 ----------------------------------------------------------------------------
 */

/*
 ----------------------------------------------------------------------------
 3️⃣ JCF HIERARCHY (IMPORTANT INTERVIEW QUESTION)
 ----------------------------------------------------------------------------
 Iterable
   |
 Collection
   |
  List  <---------------------------
   |                               |
 ArrayList                       LinkedList
 Vector
   |
 Stack (legacy)
 ----------------------------------------------------------------------------
 */

/*
 ----------------------------------------------------------------------------
 4️⃣ METHODS AVAILABLE IN LIST
 ----------------------------------------------------------------------------
 A) Collection Interface Methods:
 - size()
 - isEmpty()
 - contains()
 - add(E e)
 - remove(Object o)
 - addAll()
 - removeAll()
 - clear()
 - iterator()
 - stream(), parallelStream()

 B) List Specific Methods:
 - add(int index, E element)
 - addAll(int index, Collection c)
 - get(int index)
 - set(int index, E element)
 - remove(int index)
 - indexOf(Object o)
 - lastIndexOf(Object o)
 - sort(Comparator)
 - replaceAll(UnaryOperator)
 - listIterator()
 - listIterator(int index)
 - subList(fromIndex, toIndex)

 | Method           | Index Based | Modifies List | Inclusive / Exclusive |
| ---------------- | ----------- | ------------- | --------------------- |
| add(index, e)    | ✔           | ✔             | index inclusive       |
| addAll(index, c) | ✔           | ✔             | index inclusive       |
| get(index)       | ✔           | ❌             | index inclusive       |
| set(index, e)    | ✔           | ✔             | index inclusive       |
| remove(index)    | ✔           | ✔             | index inclusive       |
| indexOf          | ❌           | ❌             | first match           |
| lastIndexOf      | ❌           | ❌             | last match            |
| sort             | ❌           | ✔             | full list             |
| replaceAll       | ❌           | ✔             | full list             |
| subList          | ✔           | ✔             | from ✔ / to ❌         |

 ----------------------------------------------------------------------------
 */

public class _1_List_Introduction {

    public static void main(String[] args) {

        /*
         --------------------------------------------------------------------
         5️⃣ ARRAYLIST BASIC EXAMPLE
         --------------------------------------------------------------------
         */
        List<Integer> list = new ArrayList<>();

        list.add(100);
        list.add(200);
        list.add(300);

        System.out.println("Initial List: " + list);

        /*
         --------------------------------------------------------------------
         6️⃣ ADD AT SPECIFIC INDEX
         --------------------------------------------------------------------
         */
        list.add(1, 150); // shifts elements to right
        System.out.println("After add at index 1: " + list);

        /*
         --------------------------------------------------------------------
         7️⃣ ADD ALL AT SPECIFIC INDEX
         --------------------------------------------------------------------
         */
        List<Integer> list2 = new ArrayList<>();
        list2.add(400);
        list2.add(500);

        list.addAll(2, list2);
        System.out.println("After addAll at index 2: " + list);

        /*
         --------------------------------------------------------------------
         8️⃣ GET & SET
         --------------------------------------------------------------------
         */
        System.out.println("Element at index 3: " + list.get(3));

        list.set(3, 999);
        System.out.println("After set at index 3: " + list);

        /*
         --------------------------------------------------------------------
         9️⃣ REMOVE BY INDEX
         --------------------------------------------------------------------
         */
        list.remove(2);
        System.out.println("After removing index 2: " + list);

        /*
         --------------------------------------------------------------------
         🔟 SEARCH METHODS
         --------------------------------------------------------------------
         */
        System.out.println("Index of 999: " + list.indexOf(999));
        System.out.println("Last index of 200: " + list.lastIndexOf(200));

        /*
         --------------------------------------------------------------------
         1️⃣1️⃣ replaceAll() – UnaryOperator
         --------------------------------------------------------------------
         */
        list.replaceAll(val -> -val);
        System.out.println("After replaceAll (negation): " + list);

        /*
         --------------------------------------------------------------------
         1️⃣2️⃣ SORT
         --------------------------------------------------------------------
         */
        list.sort(Integer::compareTo);
        System.out.println("After sorting: " + list);

        /*
         --------------------------------------------------------------------
         1️⃣3️⃣ ITERATOR (FORWARD ONLY)
         --------------------------------------------------------------------
         */
        Iterator<Integer> iterator = list.iterator();
        System.out.print("Iterator traversal: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        /*
         --------------------------------------------------------------------
         1️⃣4️⃣ LISTITERATOR (FORWARD + BACKWARD)
         --------------------------------------------------------------------
         */
        ListIterator<Integer> listIterator = list.listIterator(list.size());

        System.out.print("Backward traversal using ListIterator: ");
        while (listIterator.hasPrevious()) {
            int val = listIterator.previous();
            System.out.print(val + " ");
        }
        System.out.println();

        /*
         --------------------------------------------------------------------
         1️⃣5️⃣ subList() – VERY IMPORTANT INTERVIEW TOPIC
         --------------------------------------------------------------------
         */
        List<Integer> subList = list.subList(1, 3); // fromIndex inclusive, toIndex exclusive
        System.out.println("SubList: " + subList);

        // Changes in subList reflect in main list
        subList.add(-777);
        System.out.println("After modifying subList:");
        System.out.println("Main List: " + list);
        System.out.println("Sub List: " + subList);

        /*
         --------------------------------------------------------------------
         1️⃣6️⃣ THREAD-SAFE VERSION OF LIST
         --------------------------------------------------------------------
         */
        List<Integer> threadSafeList = new CopyOnWriteArrayList<>();
        threadSafeList.add(10);
        threadSafeList.add(20);

        System.out.println("Thread-safe List: " + threadSafeList);
    }
}

/*
 ----------------------------------------------------------------------------
 1️⃣7️⃣ TIME & SPACE COMPLEXITY (ArrayList)
 ----------------------------------------------------------------------------
 Insertion:
 - O(1) → at end (amortized)
 - O(n) → at index (shifting required)

 Deletion:
 - O(n) → shifting elements

 Search:
 - O(1) → by index
 - O(n) → by value

 Space Complexity:
 - O(n)
 ----------------------------------------------------------------------------
 */

/*
 ----------------------------------------------------------------------------
 1️⃣8️⃣ ARRAYLIST PROPERTIES SUMMARY
 ----------------------------------------------------------------------------
 - Thread Safe: ❌ No
 - Maintains Insertion Order: ✅ Yes
 - Allows Null Elements: ✅ Yes
 - Allows Duplicates: ✅ Yes
 - Best for: Frequent READ operations
 ----------------------------------------------------------------------------
 */

/*
 ----------------------------------------------------------------------------
 1️⃣9️⃣ INTERVIEW QUESTIONS (IMPORTANT)
 ----------------------------------------------------------------------------
 Q1. Why List allows duplicates?
 → Because it maintains insertion order using index.

 Q2. Difference between ArrayList & LinkedList?
 → ArrayList uses dynamic array (fast access)
 → LinkedList uses doubly linked list (fast insert/delete)

 Q3. Why subList is dangerous?
 → Because it returns a VIEW, not a copy.

 Q4. Why CopyOnWriteArrayList is thread-safe?
 → It creates a new copy on every modification.

 Q5. Why Vector is avoided?
 → Because it is synchronized and slow (legacy class).
 ----------------------------------------------------------------------------
 */


 /*
 
 1️⃣ add(int index, E element)
🔹 Definition
Inserts the specified element at the given index position in the list.
🔹 Usage
list.add(2, 100);
🔹 How it works:- Element is inserted at index
Existing elements from that index onward are shifted to the right
Index must be between 0 and size() (inclusive)

🔹 Example
List<Integer> list = new ArrayList<>();
list.add(10);
list.add(20);
list.add(30);
list.add(1, 15); // insert at index 1
System.out.println(list);

Output: [10, 15, 20, 30]

🔹 Important Points
✔ Maintains insertion order
❌ Throws IndexOutOfBoundsException if index invalid

⏱ Time Complexity:
ArrayList: O(n) (shifting)
LinkedList: O(n) (traversal)



2️⃣ addAll(int index, Collection c)
🔹 Definition:- Inserts all elements of a collection starting at the given index.
🔹 Usage:- list.addAll(2, anotherList);
🔹 How it works:- 
Inserts entire collection at index
Existing elements shift right
Order of inserted collection is preserved

🔹 Example
List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3));
List<Integer> list2 = List.of(100, 200);

list1.addAll(1, list2);
System.out.println(list1);

Output: [1, 100, 200, 2, 3]

🔹 Key Notes
✔ Index is inclusive
❌ Index > size → exception



3️⃣ get(int index)
🔹 Definition: Returns the element present at the specified index.
🔹 Usage
int value = list.get(2);
🔹 Example
List<String> list = List.of("A", "B", "C");
System.out.println(list.get(1));

Output: B

🔹 Key Points
✔ Random access
❌ No modification

⏱ Time Complexity:
ArrayList: O(1)
LinkedList: O(n)



4️⃣ set(int index, E element)
🔹 Definition: Replaces the element at the specified index with a new element.
🔹 Usage
list.set(1, 500);
🔹 Example
List<Integer> list = new ArrayList<>(List.of(10, 20, 30));
list.set(1, 99);
System.out.println(list);

Output: [10, 99, 30]

🔹 Important
✔ Size remains same
✔ Returns old element
❌ Index must already exist



5️⃣ remove(int index)
🔹 Definition: Removes the element at the specified index.
🔹 Usage
list.remove(2);
🔹 Example
List<Integer> list = new ArrayList<>(List.of(10, 20, 30));
list.remove(1);
System.out.println(list);

Output: [10, 30]

🔹 Notes
Shifts elements left
⏱ O(n) for ArrayList



6️⃣ indexOf(Object o)
🔹 Definition: Returns the index of the first occurrence of the element.
🔹 Usage
int index = list.indexOf(20);
🔹 Example
List<Integer> list = List.of(10, 20, 30, 20);
System.out.println(list.indexOf(20));

Output: 1

🔹 Special Case
If not found → returns -1



7️⃣ lastIndexOf(Object o)
🔹 Definition: Returns the index of the last occurrence of the element.
🔹 Example
System.out.println(list.lastIndexOf(20));

Output: 3




8️⃣ sort(Comparator c)
🔹 Definition: Sorts the list according to the provided comparator.
🔹 Usage
list.sort(Comparator.naturalOrder());
🔹 Example
List<Integer> list = new ArrayList<>(List.of(5, 1, 3));
list.sort((a, b) -> a - b);
System.out.println(list);

Output: [1, 3, 5]

🔹 Key Points
Modifies original list
Uses TimSort internally



9️⃣ replaceAll(UnaryOperator op)
🔹 Definition: Replaces each element with the result of applying the operator.
🔹 Usage
list.replaceAll(x -> x * 2);
🔹 Example
List<Integer> list = new ArrayList<>(List.of(1, 2, 3));
list.replaceAll(x -> -x);
System.out.println(list);

Output: [-1, -2, -3]



🔟 listIterator()
🔹 Definition: Returns a ListIterator to traverse forward and backward.
🔹 Example
ListIterator<Integer> it = list.listIterator();
while (it.hasNext()) {
    System.out.println(it.next());
}

🔹 Special Features
Can move backward
Can modify list during iteration
More powerful than Iterator


1️⃣1️⃣ listIterator(int index)
🔹 Definition: Returns a ListIterator starting at the specified index.
🔹 Example
ListIterator<Integer> it = list.listIterator(2);
🔹 Meaning:
First call to next() returns element at index
Useful for partial traversal



1️⃣2️⃣ subList(int fromIndex, int toIndex)
🔹 Definition: Returns a view of the list between given indices.
🔹 Inclusive / Exclusive Rule
fromIndex → Inclusive
toIndex   → Exclusive
🔹 Example
List<Integer> list = List.of(10, 20, 30, 40, 50);
List<Integer> sub = list.subList(1, 4);
System.out.println(sub);

Output: 20, 30, 40]

subList is backed by original list
Changes in subList affect main list and vice versa
 
 */