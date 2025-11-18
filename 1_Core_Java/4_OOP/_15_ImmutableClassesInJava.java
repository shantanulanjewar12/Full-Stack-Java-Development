/*
===============================================================================
📌 _10_ImmutableClassesInJava.java
===============================================================================
Immutable Objects → Objects whose state CANNOT be changed after creation.

Examples in Java:
✔ String (MOST asked)
✔ Wrapper classes → Integer, Float, Long, Double, Boolean
✔ java.time API → LocalDate, LocalTime (Java 8+)

Why important?
---------------
✔ Thread Safety (no synchronization needed)
✔ Security (value cannot be modified externally)
✔ Used in caching, collections, multithreading,
  and functional programming.

===============================================================================
💡 What is an Immutable Class?
A class whose object cannot be modified once created.

If you want a NEW value, you must create a NEW OBJECT.

Example:
---------
String s = "Hello";
s = s.concat(" World"); // old string unchanged; new object created

===============================================================================
Rules to Create an Immutable Class (VERY IMPORTANT)
---------------------------------------------------
✔ 1. Class must be declared as final → cannot be subclassed
✔ 2. All fields must be private
✔ 3. No setters (never allow modification)
✔ 4. If field is mutable object → return deep copy in getter
✔ 5. Initialize fields ONLY via constructor

===============================================================================
Example: Immutable Class Implementation
===============================================================================
*/

final class Employee {

    private final String name;
    private final int age;
    private final Address address; // mutable reference type

    public Employee(String name, int age, Address address) {
        this.name = name;
        this.age = age;

        // Deep copy to prevent external modification
        this.address = new Address(address.getCity());
    }

    public String getName() {
        return name; // safe → immutable field
    }

    public int getAge() {
        return age; // safe
    }

    public Address getAddress() {
        // Return copy, NOT original → prevents modification
        return new Address(address.getCity());
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + 
               ", city='" + address.getCity() + "'}";
    }
}


// Helper class (MUTABLE)
class Address {

    private String city;

    Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) { // mutable
        this.city = city;
    }
}

/*
===============================================================================
Test Class
===============================================================================
*/

public class _15_ImmutableClassesInJava {

    public static void main(String[] args) {

        Address addr = new Address("Nagpur");
        Employee emp = new Employee("Shantanu", 22, addr);

        System.out.println("Before modification:");
        System.out.println(emp);

        // Trying to modify mutable reference
        addr.setCity("Pune"); // change original object passed in constructor

        System.out.println("\nAfter modifying original address object:");
        System.out.println(emp); // remains unchanged → immutability working

        // Try modifying via getter
        Employee e2 = emp;
        e2.getAddress().setCity("Mumbai");

        System.out.println("\nAfter modifying via getter:");
        System.out.println(emp); // remains unchanged → protected
    }
}

/*
===============================================================================
🧠 Why are Immutable Classes Important?
---------------------------------------
✔ Security: cannot change values once created (good for credentials, keys)
✔ Thread-safe: safe in concurrent environments
✔ Cached and reused: JVM optimizes memory
✔ Predictable behavior without side effects

===============================================================================
🔥 Why is String Immutable? (Interview GOLD Question)
------------------------------------------------------
String is immutable because:

1️⃣ Security:
    - Used in file paths, class loaders, credentials, DB URL.
    - Cannot allow modification.

2️⃣ String Pool Optimization:
    - JVM reuses strings to save memory.
    - Mutable string would break pooling.

3️⃣ Thread Safety:
    - Multiple threads can share same string safely.

4️⃣ Hashing Efficiency:
    - Used as key in HashMap → immutability ensures hashCode consistency.

Notebook Summary:
✔ String immutable for security, performance, thread safety, and caching.

===============================================================================
Immutable vs Mutable Objects
--------------------------------

| Feature          | Immutable (String, Wrapper) | Mutable (StringBuilder, ArrayList) |
|------------------|-----------------------------|-------------------------------------|
| Value change     | ❌ No                       | ✔ Yes                               |
| Thread Safety    | ✔ Yes                      | ❌ No (unless synchronized)         |
| Memory Usage     | Low due to reuse           | Higher                              |
| Example usage    | Keys, config, secure data  | Editing content frequently          |

===============================================================================
Difference: final variable vs Immutable Object
----------------------------------------------

final means → reference cannot change  
immutable means → object value cannot change  

Example:
---------
*/

class TestDifference {
    public static void main(String[] args) {

        final StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World"); // allowed → object mutated

        // sb = new StringBuilder("New"); ❌ not allowed → final reference

        System.out.println(sb);
    }
}

/*
Notebook Summary:
✔ final stops reference reassignment.
✔ immutability stops object modification.

===============================================================================
Real-World Use Cases of Immutability
------------------------------------
✔ API Keys, Tokens, Passwords
✔ Financial calculations (no accidental change)
✔ Multi-threaded systems
✔ Cache systems like String Pool, Flyweight design pattern

===============================================================================
📌 Final Quick Revision Notes (for Exam/Interview)
--------------------------------------------------

✔ Immutable object → state cannot change after creation.
✔ Steps:
   - final class
   - private final variables
   - no setters
   - deep copy for mutable objects
✔ Benefits:
   - Thread-safe
   - Secure
   - Memory efficient
✔ String is immutable to support String Pool and security.

===============================================================================
*/
