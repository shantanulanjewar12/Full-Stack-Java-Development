import java.util.*;
/*
================================================================================
1. WHAT IS LINKEDHASHSET?
================================================================================

✔ Definition:
- LinkedHashSet is a concrete implementation of the Set interface.
- It stores UNIQUE elements.
- It MAINTAINS INSERTION ORDER.
- It is part of Java Collections Framework.

✔ Package:
- java.util.LinkedHashSet

✔ Declaration:
    LinkedHashSet<E> set = new LinkedHashSet<>();

================================================================================
*/

/*
================================================================================
2. WHY LINKEDHASHSET IS NEEDED?
================================================================================

Problems with HashSet:
❌ Does NOT maintain insertion order

Problems with TreeSet:
❌ Sorting overhead (O(log n))
❌ No null allowed

LinkedHashSet solves:
✔ Maintains insertion order
✔ Faster than TreeSet
✔ Allows one null element

Use when:
- Uniqueness + Order both matter
- No need for sorting

================================================================================
*/

/*
================================================================================
3. REAL-WORLD ANALOGY
================================================================================

Imagine:
- A queue of unique visitors entering a museum
- First visitor stays first, duplicates are rejected

➡ LinkedHashSet behaves exactly like this.

================================================================================
*/

/*
================================================================================
4. KEY CHARACTERISTICS OF LINKEDHASHSET
================================================================================

✔ No duplicate elements
✔ Maintains insertion order
✔ Allows ONE null value
✔ Slightly slower than HashSet
✔ Not synchronized (not thread-safe)
✔ Uses HashTable + Doubly Linked List

================================================================================
*/

/*
================================================================================
5. INTERNAL WORKING OF LINKEDHASHSET (VERY IMPORTANT)
================================================================================

✔ LinkedHashSet internally uses LinkedHashMap

Internal Structure:
    LinkedHashMap<E, Object>

✔ Hashing:
- For fast lookup (like HashSet)

✔ Doubly Linked List:
- Maintains insertion order

Steps when add(element) is called:
1. hashCode() is calculated
2. Bucket index is found
3. equals() is checked
4. If duplicate → ignored
5. If unique → stored AND linked in order

================================================================================
*/

/*
================================================================================
6. LINKEDHASHSET CONSTRUCTORS
================================================================================

1. LinkedHashSet()
2. LinkedHashSet(int initialCapacity)
3. LinkedHashSet(int initialCapacity, float loadFactor)
4. LinkedHashSet(Collection<? extends E> c)

================================================================================
*/

/*
================================================================================
7. TIME & SPACE COMPLEXITY
================================================================================

Operation        Average Case     Worst Case
---------------------------------------------
add()              O(1)             O(n)
remove()           O(1)             O(n)
contains()         O(1)             O(n)

Extra Space:
- Doubly Linked List → extra memory

================================================================================
*/

public class _3_LinkedHashSet {

    public static void main(String[] args) {

        /*
        ================================================================================
        BASIC LINKEDHASHSET EXAMPLE
        ================================================================================
        */

        LinkedHashSet<Integer> numbers = new LinkedHashSet<>();

        numbers.add(10);   // Stored
        numbers.add(20);   // Stored
        numbers.add(10);   // Duplicate → Ignored
        numbers.add(30);   // Stored
        numbers.add(null); // Allowed
        numbers.add(null); // Duplicate null → Ignored

        System.out.println("LinkedHashSet Output: " + numbers);

        /*
        Output Order:
        10 → 20 → 30 → null
        */

        /*
        ================================================================================
        ITERATING LINKEDHASHSET
        ================================================================================
        */

        System.out.println("Iterating LinkedHashSet:");
        for (Integer num : numbers) {
            System.out.println(num);
        }

        /*
        ================================================================================
        LINKEDHASHSET WITH CUSTOM OBJECTS
        ================================================================================
        */

        LinkedHashSet<User> users = new LinkedHashSet<>();

        users.add(new User(101, "Alice"));
        users.add(new User(102, "Bob"));
        users.add(new User(101, "Alice Duplicate")); // Duplicate ID

        System.out.println("Users LinkedHashSet:");
        for (User u : users) {
            System.out.println(u);
        }

        /*
        Important:
        - Order of first insertion is preserved
        - Duplicate removal depends on equals() and hashCode()
        */

        /*
        ================================================================================
        LINKEDHASHSET VS HASHSET ORDER COMPARISON
        ================================================================================
        */

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);

        LinkedHashSet<Integer> linkedSet = new LinkedHashSet<>();
        linkedSet.add(1);
        linkedSet.add(2);
        linkedSet.add(3);

        System.out.println("HashSet Order      : " + hashSet);
        System.out.println("LinkedHashSet Order: " + linkedSet);
    }
}

/*
================================================================================
8. equals() and hashCode() IN LINKEDHASHSET
================================================================================

✔ Same rules as HashSet
✔ Hashing decides uniqueness
✔ Linked list decides order

RULE:
If equals() returns true → element is duplicate

================================================================================
*/

class User {

    int id;
    String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /*
    hashCode based on id
    */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /*
    equals based on id
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof User)) return false;
        User other = (User) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

/*
================================================================================
9. EXECUTION FLOW & MEMORY REPRESENTATION
================================================================================

1. Element added
2. Hash computed
3. Bucket selected
4. Duplicate check using equals()
5. Stored in HashMap
6. Linked via doubly linked list

Result:
- Fast lookup
- Predictable iteration order

================================================================================
*/

/*
================================================================================
10. COMMON MISTAKES
================================================================================

❌ Expecting sorting (LinkedHashSet is NOT sorted)
❌ Modifying object fields used in hashCode()
❌ Assuming thread-safety
❌ Using LinkedHashSet when order is irrelevant

================================================================================
*/

/*
================================================================================
11. LINKEDHASHSET vs HASHSET vs TREESET
================================================================================

Feature            HashSet        LinkedHashSet       TreeSet
--------------------------------------------------------------
Order              No              Yes (Insertion)     Sorted
Performance        Fastest         Slightly slower     Slower
Null Allowed       Yes (1)         Yes (1)             No
Internal DS        HashMap         LinkedHashMap       Red-Black Tree

================================================================================
*/

/*
================================================================================
12. INTERVIEW QUESTIONS – LINKEDHASHSET
================================================================================

BEGINNER:
Q1: What is LinkedHashSet?
A: A Set that maintains insertion order.

Q2: Does LinkedHashSet allow duplicates?
A: No.

INTERMEDIATE:
Q3: How does LinkedHashSet maintain order?
A: Using a doubly linked list.

Q4: Is LinkedHashSet faster than TreeSet?
A: Yes, because TreeSet uses O(log n).

ADVANCED:
Q5: Can LinkedHashSet be used as LRU cache?
A: Yes (internally LinkedHashMap supports it).

================================================================================
*/

/*
================================================================================
13. CODING INTERVIEW PROBLEMS USING LINKEDHASHSET
================================================================================

1. Remove duplicates but keep order
2. Unique elements in stream while preserving order
3. First non-repeating character
4. Order-sensitive deduplication

Approach:
- Use LinkedHashSet

================================================================================
*/

/*
================================================================================
14. BEST PRACTICES
================================================================================

✔ Use LinkedHashSet when:
- Uniqueness + insertion order required
- Predictable iteration order needed

❌ Avoid LinkedHashSet when:
- Sorting is required → Use TreeSet
- Order does not matter → Use HashSet
- Memory optimization is critical

✔ Prefer immutable objects
✔ Override equals() and hashCode() properly

*/
