public class _2_String_Memory_Model_SCP_vs_Heap {

    public static void main(String[] args) {

        // ==============================
        // SIMPLE SCP vs Heap Example
        // ==============================
        String s1 = "Telusko";
        String s2 = "Telusko";
        String s3 = new String("Telusko");

        System.out.println(s1 == s2);  // true  (SCP reference reused)
        System.out.println(s1 == s3);  // false (SCP vs Heap)
        System.out.println(s1.equals(s3)); // true (content same)

        // ==============================
        // IMMUTABILITY DEMO
        // ==============================
        String s4 = "Hello";
        s4.concat("World");
        System.out.println(s4); // Hello → unchanged (immutable)

        String s5 = s4.concat("World");
        System.out.println(s5); // HelloWorld → new object created
    }
}


/*
================================================================================
💡 STRING MEMORY MODEL - SCP vs HEAP
================================================================================

A string literal is stored in the **String Constant Pool**, inside JVM Method Area.
A String created with **new** keyword is stored in the Heap.

--------------------------------------------------------------------------------
 A️⃣ SIMPLE ASCII DIAGRAM
--------------------------------------------------------------------------------

SCP (String Constant Pool):
---------------------------
"Telusko"  ← s1, s2 (same memory)


HEAP:
---------------------------
new String("Telusko")  ← s3


So:
s1 == s2     → true   (same reference)
s1 == s3     → false  (different reference)
s1.equals(s3) → true  (same content)
--------------------------------------------------------------------------------


--------------------------------------------------------------------------------
 B️⃣ DETAILED MEMORY BOX DIAGRAM
--------------------------------------------------------------------------------

Step 1:
String s1 = "Telusko";

     +---------------------------+
     |      SCP (JVM Area)       |
     |---------------------------|
     | "Telusko"  <-- s1         |
     +---------------------------+


Step 2:
String s2 = "Telusko";

     +---------------------------+
     | "Telusko" <-- s1, s2      |  ⬅ SAME reference reused
     +---------------------------+


Step 3:
String s3 = new String("Telusko");

     +---------------------------+         +-----------------------------+
     |          SCP              |         |            HEAP             |
     |---------------------------|         |-----------------------------|
     | "Telusko" <-- s1, s2      |         | new String("Telusko") <--s3 |
     +---------------------------+         +-----------------------------+


Step 4 (Immutability):
String s4 = "Hello";
s4.concat("World");

     +---------------------------+
     | "Hello" <-- s4            |
     +---------------------------+


Step 5:
String s5 = s4.concat("World");

     +---------------------------+         +-----------------------------+
     | "Hello" <-- s4            |         | "HelloWorld" <-- s5         |
     +---------------------------+         +-----------------------------+


================================================================================
🧠 INTERVIEW REVISION QUICK NOTES
================================================================================

• SCP = No Duplicates, Reuse memory → Because of **immutability**
• new String("x") = Heap object + literal check in SCP
• == compares reference / memory address
• equals() compares content
• String is **immutable** → Cannot change existing value, will create new object

Why immutable❓ (Very Important)
✔ Security (Classloader, Passwords)
✔ Performance (Hashcode caching)
✔ Thread-safety
✔ SCP reuse benefit

================================================================================
END OF FILE
================================================================================
*/
