/*
 * =============================================================================
 * ==
 * WHAT IS A STRING IN JAVA?
 * =============================================================================
 * ==
 * 
 * • In Java, anything inside double quotes " " is treated as a String object.
 * Examples:
 * " ", "123", "A", "@#$", "Telusko" // All are Strings
 * 
 * • String is a class in java.lang package.
 * • String is treated as an Object in Java.
 * 
 * =============================================================================
 * ===
 * TYPES OF STRING OBJECTS
 * =============================================================================
 * ===
 * 
 * There are **2 types of String objects** (based on mutability):
 * 
 * 1️⃣ Immutable Strings
 * → Created using the String class.
 * → Once created, their value cannot be changed.
 * → Stored in:
 * ✔ String Constant Pool (SCP)
 * ✔ Heap (when using `new` keyword)
 * 
 * 2️⃣ Mutable Strings
 * → Can be modified after creation.
 * → Classes:
 * ✔ StringBuffer (Thread-safe, Synchronized)
 * ✔ StringBuilder (Not Thread-safe, Faster)
 * 
 * 
 * =============================================================================
 * ===
 * MEMORY ALLOCATION OF STRING OBJECTS
 * =============================================================================
 * ===
 * 
 * ⚠ IMPORTANT DIFFERENCE
 * 
 * 1) String s1 = "Telusko";
 * • Stored in SCP (String Constant Pool)
 * • Duplicate values NOT allowed in SCP
 * • If same value already exists → reference reused
 * 
 * 2) String s2 = new String("Telusko");
 * • Stored in Heap
 * • ALSO maintains a copy in SCP (if not already there)
 * • => 2 objects created → 1 in Heap, 1 in SCP
 * 
 * 
 * 
 * =============================================================================
 * ===
 * STRING COMPARISON IN JAVA
 * =============================================================================
 * ===
 * 
 * Ways to compare Strings:
 * 
 * Method Compares Use Case
 * ------------------- ---------------------- ----------------------------
 * == Reference (memory) Same object or not?
 * equals() Actual value Check content
 * equalsIgnoreCase() Value ignoring case "HELLO" vs "hello"
 * compareTo() Lexicographic (ASCII) Alphabetical order comparison
 * 
 * 
 * Example:
 * --------------------------------------------------------------------
 * String s1 = "Telusko";
 * String s2 = "Telusko";
 * System.out.println(s1 == s2); // true (SCP - same location)
 * System.out.println(s1.equals(s2)); // true (content same)
 * 
 * String s3 = new String("Telusko");
 * System.out.println(s1 == s3); // false (Heap vs SCP)
 * System.out.println(s1.equals(s3)); // true (content same)
 * 
 * 
 * 
 * =============================================================================
 * String s1 = "Telusko";
 * String s2 = s1.concat(" Java"); // Creates a new String object
 * String s3 = "Telusko Java";
 * 
 * System.out.println(s2 == s3); // false
 * 
 * String s4 = s1 + s2; // "+" also creates a new String object
 * 
 * System.out.println(s3 == s4); // false
 * 
 * --------------------------------------------------------------------
 * 📌 Explanation
 * 
 * String s1 = "Telusko";
 * Stored in String Pool.
 * 
 * s1.concat(" Java")
 * 
 * concat() does not modify s1 because Strings are immutable.
 * 
 * It creates a new String object "Telusko Java" in the heap and returns its
 * reference to s2.
 * 
 * String s3 = "Telusko Java";
 * 
 * This literal is stored in the String Pool.
 * 
 * System.out.println(s2 == s3); → false
 * 
 * == compares memory references, not values.
 * 
 * s2 (heap object) and s3 (pool object) are not the same memory reference.
 * 
 * String s4 = s1 + s2;
 * 
 * + operator also creates a new object in heap.
 * 
 * Therefore, s4 and s3 are different references.
 * 
 * System.out.println(s3 == s4); → false
 * 
 * Both have same value but different locations in memory, so == returns false.
 * 
 * 
 * =============================================================================
 * String x1= "Apple"+ "Banana"+ "Mango"+ "Orange"+ "Grapes";
 * String x2= "Apple"+ "Banana"+ "Mango"+ "Orange"+ "Grapes";
 * System.out.println(x1==x2); // true
 * // Reason: Compile-time optimization (constant folding)
 * // Both x1 and x2 refer to same SCP object
 * // x1 and x2 are optimized to a single literal in SCP
 * // Hence, same reference
 * // While using + with only literals, Java optimizes at compile-time
 * // to store a single object in SCP
 * // This is called constant folding
 * --------------------------------------------------------------------
 * 📌 Explanation
 * // Both x1 and x2 are created using only string literals.
 * // During compilation, Java optimizes these concatenations.
 * // It combines them into a single string literal "AppleBananaMangoOrangeGrapes"
 * // and stores it once in the String Constant Pool (SCP).
 * // Therefore, both x1 and x2 point to the same memory location in SCP.
 * // Hence, x1 == x2 evaluates to true.
 * 
 * 
 * 
 * 
 * =============================================================================
 * Anything added to a String using concat() or + creates a new String object
 * in Heap memory.
 * 
 * adding two string literals results in a single object in SCP due to compile-time
 * optimization. 
 * 
 * 
 * 
 * 
 * 
 * 
 * --------------------------------------------------------------------
 * 
 * =============================================================================
 * ===
 * IMMUTABILITY DEMO (BASED ON YOUR BOARD FLOW)
 * =============================================================================
 * ===
 * 
 * String str = "Telusko";
 * str.concat("Bengaluru");
 * System.out.println(str);
 * // Output: Telusko ❌ No change to original
 * 
 * String str2 = str.concat("Bengaluru");
 * System.out.println(str2);
 * // Output: TeluskoBengaluru ✔ New object created in Heap
 * 
 * 
 * =============================================================================
 * ===
 * MUTABLE STRING DEMO
 * =============================================================================
 * ===
 * 
 * StringBuffer sb = new StringBuffer("Telusko");
 * sb.append("Bengaluru");
 * System.out.print(sb);
 * 
 * // Output: TeluskoBengaluru
 * // Modified on SAME memory (Mutable Object)
 * 
 * (Related to last board page)
 * 
 * =============================================================================
 * ===
 * QUICK REVISION SUMMARY
 * =============================================================================
 * ===
 * 
 * ✔ String = Immutable, stored in SCP or Heap
 * ✔ Mutable alternatives = StringBuffer & StringBuilder
 * ✔ String comparison:
 * == → reference
 * equals() → value
 * compareTo() → lexicographical
 * ✔ SCP does not allow duplicates
 * ✔ Using 'new' always creates new object in Heap
 * 
 * =============================================================================
 * ===
 * END OF FILE
 * =============================================================================
 * ===
 */
