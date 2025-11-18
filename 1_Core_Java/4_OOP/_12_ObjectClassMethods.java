/*
===============================================================================
📌 _7_ObjectClassMethods.java
===============================================================================
VERY IMPORTANT FOR INTERVIEWS

Every class in Java implicitly extends java.lang.Object.

So these methods are available in ALL classes:

    1) equals(Object obj)
    2) hashCode()
    3) toString()
    4) clone()
    5) finalize()   (⚠️ Deprecated but still asked in interviews)

These methods are heavily used in:
- Collections (HashSet, HashMap, ArrayList, etc.)
- Comparing objects
- Debugging/logging
- Copying objects
- Garbage Collection concepts

Below, we explain EACH method in detail with:
- Default behavior
- When & how to override
- Rules
- Examples
- Simple interview-oriented notes
===============================================================================
*/

class Student {

    private int id;
    private String name;

    // Constructor
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /*
    ===========================================================================
    1️⃣ equals(Object obj)
    ===========================================================================
    💡 Purpose:
       - To compare two objects for "logical equality" (content-based).

    🧠 Default behavior in Object class:
       - equals() in Object behaves like == (reference comparison)
       - i.e., true only if both references point to SAME object in memory.

       public boolean equals(Object obj) {
           return (this == obj);
       }

    💡 Why override equals()?
       - When you want to compare objects by their DATA instead of memory address.
       - Example: Two students with SAME id should be equal logically.

    ✅ Rules/Contract when overriding equals():
       1. Reflexive   : x.equals(x) must be true
       2. Symmetric   : x.equals(y) == y.equals(x)
       3. Transitive  : if x=y and y=z, then x=z
       4. Consistent  : multiple calls should give same result
       5. Non-nullity : x.equals(null) must be false

    ⚠️ Always override hashCode() when equals() is overridden (VERY IMPORTANT).

    Below is a proper equals() override:
    */

    @Override
    public boolean equals(Object obj) {
        // 1) If same reference → true
        if (this == obj) return true;

        // 2) If obj is null → false
        if (obj == null) return false;

        // 3) If classes are different → false
        if (this.getClass() != obj.getClass()) return false;

        // 4) Type cast and compare fields
        Student other = (Student) obj;
        if (this.id != other.id) return false;

        // Handle null-safe comparison for name
        if (this.name == null && other.name != null) return false;
        if (this.name != null && !this.name.equals(other.name)) return false;

        return true;
    }

    /*
    ===========================================================================
    2️⃣ hashCode()
    ===========================================================================
    💡 Purpose:
       - Returns an integer hash value for the object.
       - Used in hash-based collections like HashMap, HashSet, HashTable.

    🧠 Default behavior in Object:
       - Returns a hash code based on object's memory address (implementation dependent).

    ⚖️ Contract between equals() and hashCode() (VERY IMPORTANT):
       1. If x.equals(y) is true → x.hashCode() MUST be same as y.hashCode()
       2. If x.equals(y) is false → hashCode *may* be same or different
       3. hashCode() should be consistent across multiple calls (if object state unchanged)

    Why important?
       - If you use custom objects as keys in HashMap / stored in HashSet,
         then equals() and hashCode() MUST be consistent.

    Simple hashCode implementation based on 'id' and 'name':
    */

    @Override
    public int hashCode() {
        int result = 17;          // start with non-zero constant
        result = 31 * result + id; // 31 is a commonly used prime number

        // Include name's hashCode if not null
        result = 31 * result + (name == null ? 0 : name.hashCode());
        return result;
    }

    /*
    ===========================================================================
    3️⃣ toString()
    ===========================================================================
    💡 Purpose:
       - Returns a string representation of the object.
       - Very useful for debugging and logging.

    🧠 Default behavior in Object:
       - Returns: ClassName@HexadecimalHashCode
         Example: Student@3f99bd52

    Why override?
       - To get readable and meaningful output for objects, like:
         Student{id=1, name='Shantanu'}

    NOTE:
       - IDEs (IntelliJ/Eclipse) can auto-generate this method.

    Below is a simple override:
    */

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}

/*
===============================================================================
4️⃣ clone()
===============================================================================
💡 Purpose:
   - To create a COPY of the current object.

🧠 Defined in Object class as:
   protected native Object clone() throws CloneNotSupportedException;

⚠️ Default behavior:
   - Performs a SHALLOW COPY (copies field values as they are: primitives by value,
     reference fields by reference)

To use clone():
   1. Class must implement Cloneable interface
   2. Override clone() and make it public
   3. Call super.clone()

Shallow vs Deep Copy:
   - Shallow: Copies fields as they are (nested objects are shared)
   - Deep   : Clones nested objects too (separate copies)

Below Example demonstrates shallow copy:
*/

class Address {
    String city;

    Address(String city) {
        this.city = city;
    }
}

class Employee implements Cloneable {

    int id;
    String name;
    Address address; // reference type → important for shallow vs deep

    Employee(int id, String name, Address addr) {
        this.id = id;
        this.name = name;
        this.address = addr;
    }

    // Overriding clone() - shallow copy
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow copy
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', city='" + address.city + "'}";
    }
}

/*
===============================================================================
5️⃣ finalize()  (⚠️ Deprecated but still asked in interviews)
===============================================================================
💡 Purpose:
   - finalize() was meant to be called by Garbage Collector before object is destroyed,
     used to release resources (files, DB connections, etc.)

🧠 Signature in Object:
   protected void finalize() throws Throwable

⚠️ IMPORTANT:
   - finalize() is DEPRECATED (from Java 9) and REMOVED in newer Java versions.
   - It is NOT reliable:
       - Not guaranteed when it runs
       - May never run
       - Causes performance problems

✨ Current recommended alternatives:
   - try-with-resources
   - finally blocks
   - AutoCloseable / Cleaner API

Still, for interview:
   - Understand that finalize() was a cleanup hook called by GC, but now deprecated.

Demo class (for understanding ONLY):
*/

class ResourceHolder {

    public ResourceHolder() {
        System.out.println("ResourceHolder: Resource acquired.");
    }

    @Override
    protected void finalize() throws Throwable {
        // This is just for demonstration
        System.out.println("ResourceHolder: finalize() called → resource cleanup.");
        super.finalize();
    }
}

/*
===============================================================================
MAIN CLASS TO DEMO ALL METHODS
===============================================================================
*/

public class _12_ObjectClassMethods {

    public static void main(String[] args) throws CloneNotSupportedException {

        // ========================= equals() & hashCode() ======================
        Student s1 = new Student(1, "Shantanu");
        Student s2 = new Student(1, "Shantanu");
        Student s3 = new Student(2, "Rahul");

        System.out.println("s1.equals(s2): " + s1.equals(s2)); // true (same data)
        System.out.println("s1.equals(s3): " + s1.equals(s3)); // false

        System.out.println("s1.hashCode(): " + s1.hashCode());
        System.out.println("s2.hashCode(): " + s2.hashCode()); // should be same as s1
        System.out.println("s3.hashCode(): " + s3.hashCode());

        // ============================= toString() =============================
        System.out.println("s1.toString(): " + s1); // auto calls toString()

        // ============================== clone() ===============================
        Address addr = new Address("Nagpur");
        Employee e1 = new Employee(101, "Shantanu", addr);

        // Shallow clone
        Employee e2 = (Employee) e1.clone();

        System.out.println("\nBefore modifying address:");
        System.out.println("e1: " + e1);
        System.out.println("e2: " + e2);

        // Changing nested object reference (shared in shallow copy)
        e2.address.city = "Pune";

        System.out.println("\nAfter modifying e2.address.city = \"Pune\":");
        System.out.println("e1: " + e1); // city changed for both → shallow copy
        System.out.println("e2: " + e2);

        // ============================ finalize() ==============================
        // Note: We CANNOT RELY on finalize() to run.
        // This is just a conceptual demo.
        ResourceHolder rh = new ResourceHolder();
        rh = null;  // object becomes eligible for GC

        System.gc(); // Request GC (NO guarantee finalize() will run immediately)

        System.out.println("\nProgram end. (finalize() MAY or MAY NOT have been called)");
    }
}

/*
===============================================================================
📌 QUICK INTERVIEW REVISION NOTES (2–3 LINES EACH)
===============================================================================

equals():
- Used to compare two objects for logical equality.
- Default compares references; override to compare fields.
- Maintain equals-hashCode contract.

hashCode():
- Returns integer hash value used in hash collections.
- If equals() is overridden, hashCode() MUST also be overridden.
- Equal objects must have same hashCode.

toString():
- Returns string representation of object.
- Default: ClassName@HexHash; override for readable output.

clone():
- Used to copy objects (shallow by default).
- Class must implement Cloneable and override clone() as public.
- Use deep copy manually if nested objects must be cloned.

finalize():
- Called by GC before destroying object (old behavior, now deprecated).
- Not reliable, not recommended; use try-with-resources instead.
===============================================================================
*/
