import java.util.*;
/*
================================================================================
1. WHAT IS HASHSET?
================================================================================

✔ Definition:
- HashSet is a concrete implementation of the Set interface.
- It stores UNIQUE elements only.
- It uses HASHING for storage and retrieval.

✔ Package:
- java.util.HashSet

✔ Declaration:
    HashSet<E> set = new HashSet<>();

✔ Key Property:
- Order is NOT guaranteed.

================================================================================
*/

/*
================================================================================
2. WHY HASHSET IS NEEDED?
================================================================================

Problems without HashSet:
- Duplicate data
- Manual duplicate checks
- Slower searching in Lists

HashSet solves:
✔ Automatic duplicate prevention
✔ Very fast search (O(1) average)
✔ Cleaner and safer code

================================================================================
*/

/*
================================================================================
3. REAL-WORLD ANALOGY
================================================================================

Imagine:
- A college registration system
- Each student has a UNIQUE roll number

If a duplicate roll number is entered:
- System rejects it automatically

➡ HashSet behaves the same way.

================================================================================
*/

/*
================================================================================
4. KEY CHARACTERISTICS OF HASHSET
================================================================================

✔ No duplicate elements
✔ Allows only ONE null value
✔ No insertion order guarantee
✔ Not synchronized (not thread-safe)
✔ Backed by HashMap internally

================================================================================
*/

/*
================================================================================
5. INTERNAL WORKING OF HASHSET (VERY IMPORTANT)
================================================================================

✔ HashSet internally uses HashMap

Internal representation:
    HashMap<E, Object>

✔ Element → stored as KEY
✔ Value → Dummy Object (static final Object PRESENT)

Steps when add(element) is called:
1. hashCode() is calculated
2. Bucket index is computed
3. equals() is checked
4. If duplicate → ignored
5. If unique → inserted

================================================================================
*/

/*
================================================================================
6. HASHSET CONSTRUCTORS
================================================================================

1. HashSet()
2. HashSet(int initialCapacity)
3. HashSet(int initialCapacity, float loadFactor)
4. HashSet(Collection<? extends E> c)

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

Space Complexity:
- O(n)

Worst case happens when:
- Too many hash collisions

================================================================================
*/

public class _2_HashSet {

    public static void main(String[] args) {

        /*
        ================================================================================
        BASIC HASHSET EXAMPLE
        ================================================================================
        */

        HashSet<Integer> numbers = new HashSet<>();

        numbers.add(10);   // Stored
        numbers.add(20);   // Stored
        numbers.add(10);   // Duplicate → Ignored
        numbers.add(null); // Allowed
        numbers.add(null); // Duplicate null → Ignored

        System.out.println("HashSet Output: " + numbers);

        /*
        Execution Explanation:
        - hashCode() of 10 calculated
        - Stored in a bucket
        - Duplicate 10 rejected via equals()
        */

        /*
        ================================================================================
        ITERATING OVER HASHSET
        ================================================================================
        */

        System.out.println("Iterating HashSet:");
        for (Integer num : numbers) {
            System.out.println(num);
        }

        /*
        ================================================================================
        HASHSET WITH CUSTOM OBJECTS
        ================================================================================
        */

        HashSet<Employee> employees = new HashSet<>();

        employees.add(new Employee(1, "Alice"));
        employees.add(new Employee(2, "Bob"));
        employees.add(new Employee(1, "Alice Duplicate")); // Duplicate ID

        System.out.println("Employees HashSet:");
        for (Employee e : employees) {
            System.out.println(e);
        }
        // Output: Only 2 unique employees based on ID
        // The duplicate is ignored

        /*
        Important:
        - Duplicate removal depends on equals() and hashCode()
        */

        /*
        ================================================================================
        HASHSET VS LIST (DUPLICATE CHECK)
        ================================================================================
        */

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);

        System.out.println("List allows duplicates: " + list);
        System.out.println("HashSet avoids duplicates automatically");

    }
}

/*
================================================================================
8. equals() and hashCode() – CRITICAL FOR HASHSET
================================================================================

✔ hashCode():
- Determines bucket index

✔ equals():
- Checks equality inside bucket

RULE:
If two objects are equal:
- equals() → true
- hashCode() → same value

Violation causes:
- Duplicate entries
- Data inconsistency

================================================================================
*/

class Employee {

    int id;
    String name;

    Employee(int id, String name) {
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
        if (!(obj instanceof Employee)) return false;
        Employee other = (Employee) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

/*
================================================================================
9. MUTABILITY ISSUE IN HASHSET (TRICKY)
================================================================================

❌ If object fields used in hashCode() are modified after insertion:
- Object becomes unreachable
- contains() may fail
- remove() may fail

✔ Best Practice:
- Use IMMUTABLE objects
- Or avoid modifying key fields

================================================================================
*/

/*
================================================================================
10. HASHSET vs LINKEDHASHSET vs TREESET
================================================================================

Feature            HashSet        LinkedHashSet       TreeSet
--------------------------------------------------------------
Order              No              Yes (Insertion)     Sorted
Performance        Fastest         Slightly slower     Slower
Null Allowed       Yes (1)         Yes (1)             No
Internal DS        HashMap         HashMap + DLL       Red-Black Tree

================================================================================
*/

/*
================================================================================
11. INTERVIEW QUESTIONS – HASHSET
================================================================================

BEGINNER:
Q1: Does HashSet allow duplicates?
A: No.

Q2: Does HashSet maintain order?
A: No.

INTERMEDIATE:
Q3: Why is HashSet fast?
A: O(1) average time due to hashing.

Q4: How many nulls allowed in HashSet?
A: Only one.

ADVANCED:
Q5: What happens if hashCode() changes after insertion?
A: Object becomes unreachable.

Q6: Difference between HashSet and HashMap?
A: HashSet stores only keys; HashMap stores key-value pairs.

================================================================================
*/

/*
================================================================================
12. CODING INTERVIEW PROBLEMS USING HASHSET
================================================================================

1. Find duplicates in array
2. Check if array contains unique elements
3. Find intersection of two arrays
4. Longest substring without repeating characters

Approach:
- Use HashSet for fast lookup

================================================================================
*/

/*
================================================================================
13. BEST PRACTICES
================================================================================

✔ Use HashSet when:
- Order does not matter
- Fast performance is required
- Uniqueness is important

❌ Avoid HashSet when:
- Order matters → Use LinkedHashSet
- Sorted data required → Use TreeSet
- Thread safety required → Use Collections.synchronizedSet()

✔ Prefer immutable keys
✔ Override equals() and hashCode() correctly

================================================================================
END OF HASHSET FILE
================================================================================
*/
