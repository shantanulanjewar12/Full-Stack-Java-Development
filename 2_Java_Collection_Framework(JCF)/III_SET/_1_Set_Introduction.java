import java.util.*;

/*
================================================================================
1. WHAT IS A SET IN JAVA?
================================================================================

✔ Definition:
- A Set is a collection that does NOT allow duplicate elements.
- It is part of the Java Collections Framework.
- Set is an INTERFACE present in java.util package.

✔ Key Point:
- If you try to add duplicate elements, Set silently ignores them.

✔ Declaration:
    Set<E> set = new HashSet<>();

✔ Set extends Collection interface:
    Collection → Set → (HashSet, LinkedHashSet, TreeSet)

================================================================================
*/

/*
================================================================================
2. WHY DO WE NEED SET?
================================================================================

✔ Problem with List:
- List allows duplicates
- Sometimes duplicates are meaningless or harmful

✔ Example:
- Unique user IDs
- Unique email addresses
- Unique roll numbers
- Unique visited URLs

✔ Solution:
- Set automatically enforces uniqueness

================================================================================
*/

/*
================================================================================
3. REAL-WORLD ANALOGY
================================================================================

Imagine:
- A box of lottery ticket numbers
- Each ticket number must be unique

If you try to put the same number again:
- It is rejected

➡ This is exactly how Set works.

================================================================================
*/

/*
================================================================================
4. KEY CHARACTERISTICS OF SET
================================================================================

✔ No duplicate elements
✔ At most ONE null element (depends on implementation)
✔ No index-based access
✔ Order depends on implementation
✔ Faster lookup compared to List (mostly)

================================================================================
*/

/*
================================================================================
5. IMPORTANT RULES OF SET
================================================================================

Rule 1: Duplicate elements are not allowed
Rule 2: equals() determines duplication
Rule 3: hashCode() is used in hash-based sets
Rule 4: Ordering depends on implementation
Rule 5: Mutating elements inside Set is dangerous

================================================================================
*/

/*
================================================================================
6. SET INTERFACE
================================================================================

✔ Definition:
- Set is an interface that represents a collection with no duplicates.

✔ Important Methods:
- add(E e)
- remove(Object o)
- contains(Object o)
- size()
- isEmpty()
- iterator()

================================================================================
*/

/*
================================================================================
7. HASHSET
================================================================================

✔ Definition:
- HashSet is the most commonly used Set implementation.
- Uses HashTable (HashMap internally).

✔ Characteristics:
- No duplicates
- No guaranteed order
- Allows ONE null
- Fast performance

✔ Internal Working:
- Backed by HashMap
- Elements stored as keys
- Value is a dummy constant

✔ Time Complexity:
- add(): O(1)
- remove(): O(1)
- contains(): O(1)

================================================================================
*/

public class _1_Set_Introduction {

    public static void main(String[] args) {

        /*
        ================================================================================
        BASIC SET EXAMPLE
        ================================================================================
        */

        Set<Integer> basicSet = new HashSet<>();

        basicSet.add(10);  // Added
        basicSet.add(20);  // Added
        basicSet.add(10);  // Duplicate → Ignored
        basicSet.add(30);  // Added

        /*
        Execution Flow:
        - HashCode generated for each element
        - Bucket selected
        - equals() checked for duplicates
        */

        System.out.println("Basic HashSet: " + basicSet);

        /*
        Time Complexity:
        - O(1) average
        Space Complexity:
        - O(n)
        */

        /*
        ================================================================================
        LINKEDHASHSET
        ================================================================================
        */

        /*
        ✔ Definition:
        - Maintains insertion order
        - Slightly slower than HashSet
        - Uses doubly linked list internally
        */

        Set<String> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add("Java");
        linkedHashSet.add("Python");
        linkedHashSet.add("Java"); // Duplicate
        linkedHashSet.add("C++");

        System.out.println("LinkedHashSet: " + linkedHashSet);

        /*
        Order maintained:
        Java → Python → C++
        */

        /*
        ================================================================================
        TREESET
        ================================================================================
        */

        /*
        ✔ Definition:
        - Stores elements in sorted order
        - Does NOT allow null
        - Uses Red-Black Tree internally
        */

        Set<Integer> treeSet = new TreeSet<>();

        treeSet.add(40);
        treeSet.add(10);
        treeSet.add(30);
        treeSet.add(20);

        System.out.println("TreeSet (Sorted): " + treeSet);

        /*
        Time Complexity:
        - add(): O(log n)
        - remove(): O(log n)
        */

        /*
        ================================================================================
        COMPARABLE vs COMPARATOR
        ================================================================================
        */

        /*
        Comparable:
        - Natural ordering
        - Implemented by class itself
        - compareTo()

        Comparator:
        - Custom ordering
        - Separate class
        - compare()
        */

        Set<Student> students = new TreeSet<>(new StudentAgeComparator());

        students.add(new Student(1, "A", 22));
        students.add(new Student(2, "B", 20));
        students.add(new Student(3, "C", 21));

        System.out.println("Students Sorted by Age:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}

/*
================================================================================
8. equals() and hashCode()
================================================================================

✔ hashCode():
- Determines bucket location
✔ equals():
- Determines equality within bucket

RULE:
If equals() returns true → hashCode() MUST be same

Failure causes:
- Duplicate entries
- Memory leaks
- Incorrect behavior

================================================================================
*/

class Student {
    int id;
    String name;
    int age;

    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student other = (Student) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + age;
    }
}

/*
================================================================================
COMPARATOR IMPLEMENTATION
================================================================================
*/

class StudentAgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.age, s2.age);
    }
}

/*
================================================================================
9. EXECUTION FLOW & MEMORY
================================================================================

1. add(element) called
2. hashCode() computed
3. Bucket index calculated
4. equals() checked
5. If duplicate → ignored
6. If unique → stored

================================================================================
*/

/*
================================================================================
10. COMMON MISTAKES
================================================================================

❌ Not overriding equals() and hashCode()
❌ Mutating object fields used in hashCode
❌ Using TreeSet with non-comparable objects
❌ Expecting index-based access

================================================================================
*/

/*
================================================================================
11. INTERVIEW PREPARATION SECTION
================================================================================

BEGINNER QUESTIONS:
Q1: What is Set?
A: A collection that does not allow duplicates.

Q2: Difference between List and Set?
A: List allows duplicates, Set does not.

INTERMEDIATE QUESTIONS:
Q3: Why hashCode is important?
A: Used for bucket location.

Q4: Difference between HashSet and TreeSet?
A: HashSet unordered, TreeSet sorted.

ADVANCED QUESTIONS:
Q5: What happens if hashCode changes after insertion?
A: Object becomes unreachable in Set.

================================================================================
*/

/*
================================================================================
CODING INTERVIEW QUESTIONS
================================================================================

1. Remove duplicates from array
2. Find common elements between arrays
3. Find first repeated element
4. Check if array contains duplicates

Approach:
- Use HashSet

================================================================================
*/

/*
================================================================================
12. BEST PRACTICES
================================================================================

✔ Use Set when uniqueness matters
✔ Use HashSet for performance
✔ Use LinkedHashSet for order
✔ Use TreeSet for sorting
✔ Avoid mutable keys

WHEN NOT TO USE SET:
- When duplicates are needed
- When index-based access required

ALTERNATIVES:
- List
- Map

*/
