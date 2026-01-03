import java.util.*;

/*
================================================================================
1. WHAT IS TREESET?
================================================================================

✔ Definition:
- TreeSet is a concrete implementation of the Set interface.
- It stores UNIQUE elements.
- It maintains elements in SORTED ORDER.
- Sorting is based on:
  → Natural Ordering (Comparable)
  → Custom Ordering (Comparator)

✔ Package:
- java.util.TreeSet

✔ Declaration:
    TreeSet<E> set = new TreeSet<>();

================================================================================
*/

/*
================================================================================
2. WHY TREESET IS NEEDED?
================================================================================

Problems with HashSet / LinkedHashSet:
❌ No sorting guarantee

TreeSet solves:
✔ Automatic sorting
✔ Faster range operations
✔ Useful for ordered data

Use when:
- You need sorted + unique elements
- Range queries are required
- Ordered traversal is important

================================================================================
*/

/*
================================================================================
3. REAL-WORLD ANALOGY
================================================================================

Imagine:
- A dictionary
- Words are stored in alphabetical order
- No duplicate words allowed

➡ TreeSet behaves exactly like this.

================================================================================
*/

/*
================================================================================
4. KEY CHARACTERISTICS OF TREESET
================================================================================

✔ No duplicate elements
✔ Elements are always sorted
✔ Does NOT allow null (Java 8+)
✔ Slower than HashSet
✔ Not synchronized (not thread-safe)
✔ Uses Red-Black Tree internally

================================================================================
*/

/*
================================================================================
5. INTERNAL WORKING OF TREESET (VERY IMPORTANT)
================================================================================

✔ TreeSet internally uses TreeMap

Internal Structure:
    TreeMap<E, Object>

✔ Data Structure:
- Self-balancing Red-Black Tree

Insertion Process:
1. Compare elements (compareTo / compare)
2. Decide left or right child
3. Balance tree if needed
4. Reject duplicates (compare returns 0)

================================================================================
*/

/*
================================================================================
6. TREESET CONSTRUCTORS
================================================================================

1. TreeSet()
2. TreeSet(Comparator<? super E> comparator)
3. TreeSet(Collection<? extends E> c)
4. TreeSet(SortedSet<E> s)

================================================================================
*/

/*
================================================================================
7. TIME & SPACE COMPLEXITY
================================================================================

Operation        Average & Worst Case
-------------------------------------
add()              O(log n)
remove()           O(log n)
contains()         O(log n)

Space Complexity:
- O(n)

Reason:
- Tree height is log(n)

================================================================================
*/

public class _4_TreeSet {

    public static void main(String[] args) {

        /*
        ================================================================================
        BASIC TREESET EXAMPLE (NATURAL ORDERING)
        ================================================================================
        */

        TreeSet<Integer> numbers = new TreeSet<>();

        numbers.add(40);
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);
        numbers.add(10); // Duplicate → Ignored

        System.out.println("TreeSet (Sorted): " + numbers);

        /*
        Output:
        [10, 20, 30, 40]
        */

        /*
        ================================================================================
        TREESET WITH STRING (ALPHABETICAL ORDER)
        ================================================================================
        */

        TreeSet<String> languages = new TreeSet<>();

        languages.add("Java");
        languages.add("Python");
        languages.add("C++");
        languages.add("Java"); // Duplicate

        System.out.println("Languages (Sorted): " + languages);

        /*
        ================================================================================
        TREESET WITH CUSTOM OBJECTS (COMPARABLE)
        ================================================================================
        */

        TreeSet<Student> studentsById = new TreeSet<>();

        studentsById.add(new Student(3, "C"));
        studentsById.add(new Student(1, "A"));
        studentsById.add(new Student(2, "B"));

        System.out.println("Students Sorted by ID:");
        for (Student s : studentsById) {
            System.out.println(s);
        }

        /*
        ================================================================================
        TREESET WITH CUSTOM OBJECTS (COMPARATOR)
        ================================================================================
        */

        TreeSet<Student> studentsByName =
                new TreeSet<>(new StudentNameComparator());

        studentsByName.add(new Student(3, "C"));
        studentsByName.add(new Student(1, "A"));
        studentsByName.add(new Student(2, "B"));

        System.out.println("Students Sorted by Name:");
        for (Student s : studentsByName) {
            System.out.println(s);
        }

        /*
        ================================================================================
        TREESET SPECIAL METHODS
        ================================================================================
        */

        System.out.println("First Element : " + numbers.first());
        System.out.println("Last Element  : " + numbers.last());
        System.out.println("HeadSet (<30): " + numbers.headSet(30));
        System.out.println("TailSet (>=30): " + numbers.tailSet(30));
        System.out.println("SubSet (20-40): " + numbers.subSet(20, 40));
    }
}

/*
================================================================================
8. COMPARABLE INTERFACE
================================================================================

✔ Used for natural ordering
✔ Implemented by the class itself
✔ Method:
    int compareTo(T o)

Return:
- Negative → current < other
- Zero     → equal
- Positive → current > other

================================================================================
*/

class Student implements Comparable<Student> {

    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /*
    Natural ordering based on id
    */
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

/*
================================================================================
9. COMPARATOR INTERFACE
================================================================================

✔ Used for custom ordering
✔ Separate class
✔ Method:
    int compare(T o1, T o2)

================================================================================
*/

class StudentNameComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
}

/*
================================================================================
10. TREESET vs HASHSET vs LINKEDHASHSET
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
11. COMMON MISTAKES WITH TREESET
================================================================================

❌ Adding null elements
❌ Objects not implementing Comparable
❌ Inconsistent compare() logic
❌ Expecting insertion order

================================================================================
*/

/*
================================================================================
12. INTERVIEW QUESTIONS – TREESET
================================================================================

BEGINNER:
Q1: What is TreeSet?
A: A Set that stores elements in sorted order.

Q2: Does TreeSet allow duplicates?
A: No.

INTERMEDIATE:
Q3: How does TreeSet maintain order?
A: Using Red-Black Tree.

Q4: Does TreeSet allow null?
A: No (Java 8+).

ADVANCED:
Q5: What happens if compareTo() returns 0?
A: Elements are treated as duplicates.

Q6: Difference between Comparable and Comparator?
A: Comparable = natural order, Comparator = custom order.

================================================================================
*/

/*
================================================================================
13. CODING INTERVIEW PROBLEMS USING TREESET
================================================================================

1. Find kth smallest element
2. Maintain sorted unique stream
3. Range queries
4. Ceiling / Floor operations

Approach:
- Use TreeSet methods like ceiling(), floor()

================================================================================
*/

/*
================================================================================
14. BEST PRACTICES
================================================================================

✔ Use TreeSet when:
- Sorted unique data is required
- Range-based queries are needed

❌ Avoid TreeSet when:
- Performance is critical → Use HashSet
- Order not required
- Null values needed

✔ Ensure consistent compareTo / compare
✔ Prefer immutable objects

================================================================================
END OF TREESET FILE
================================================================================
*/
