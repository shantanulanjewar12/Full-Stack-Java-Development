public class _5_StringvsStringBuffervsStringBuilder {
    public static void main(String[] args) {

        /*
        ========================================================================
         1️⃣ STRING (IMMUTABLE)
         -----------------------------------------------------------------------
         • Every modification creates a NEW object
         • Stored in SCP or Heap
         • Slower for frequent modifications
         • BEST FOR: Fixed data (e.g., Constants, config, names, IDs)
        ========================================================================
        */
        String s = "Java";
        s.concat("World");
        System.out.println(s); // Java (unchanged)
        String s2 = s.concat("World");
        System.out.println(s2); // JavaWorld (new object)


        /*
        ========================================================================
         2️⃣ STRINGBUFFER (MUTABLE + THREAD SAFE)
         -----------------------------------------------------------------------
         • Supports modification on same object
         • SYNCHRONIZED → THREAD SAFE
         • Slightly slower due to locking
         • BEST FOR: Multithreaded applications
        ========================================================================
        */
        StringBuffer sb = new StringBuffer("Java");
        sb.append("World");
        System.out.println(sb); // JavaWorld


        /*
        ========================================================================
         3️⃣ STRINGBUILDER (MUTABLE + NOT THREAD SAFE)
         -----------------------------------------------------------------------
         • Best performance (fastest in String family)
         • NOT SYNCHRONIZED → NOT THREAD SAFE
         • BEST FOR: Single-thread routines, data processing, loops
        ========================================================================
        */
        StringBuilder sb2 = new StringBuilder("Java");
        sb2.append("World");
        System.out.println(sb2); // JavaWorld
    }
}


/*
===============================================================================
 ⚡ KEY DIFFERENCE TABLE (100% INTERVIEW GUARANTEED)
===============================================================================

Feature              | String              | StringBuffer         | StringBuilder
---------------------|---------------------|-----------------------|-----------------------
Mutability           | ❌ Immutable        | ✔ Mutable             | ✔ Mutable
Thread Safe?         | Yes (because immutable) | ✔ Yes (synchronized) | ❌ No
Performance          | Slowest             | Medium (due to locks) | Fastest 🚀
Stored In            | SCP / Heap          | Heap                  | Heap
Use Case             | Fixed values        | Multi-threaded systems| High performance apps
Example Methods      | concat(), substring()| append(), insert()    | append(), delete()

===============================================================================
 💡 MEMORY & MUTABILITY BEHAVIOR
===============================================================================

String s = "Java";
s.concat("World");

        BEFORE:    "Java"         (SCP)
                      ↑
                      s

        AFTER concat():
                      s → "Java"
                      NEW → "JavaWorld"


StringBuffer sb = new StringBuffer("Java");
sb.append("World");

        BEFORE & AFTER (same object):
                      "JavaWorld"  (HEAP)
                       ↑
                      sb

===============================================================================
 🚀 PERFORMANCE BENCHMARK (CONCEPTUAL)
===============================================================================

Scenario: Add 100,000 Strings

String               → ❌ Too slow (creates 100k+ objects)
StringBuffer         → ✔ Good (safe + controlled)
StringBuilder        → ⭐ Best (no thread locking)

Conclusion:
✔ Use StringBuilder for heavy modifications
✔ Use String for constants / small manipulation
✔ Use StringBuffer ONLY when concurrency matters

===============================================================================
 🧠 INTERVIEW QUESTIONS (MASTER THESE)
===============================================================================

❓ Why is String immutable?
✔ Security, class loading protection
✔ SCP memory reuse benefit
✔ Hashcode caching for performance

❓ Can we make String mutable?
✔ No. But we can wrap it in StringBuilder/StringBuffer

❓ Why StringBuffer is thread-safe?
✔ All key methods are synchronized

❓ Why StringBuilder is faster?
✔ No synchronization overhead

❓ Which to use in multi-thread environment?
✔ StringBuffer

❓ Which to use in loops for concatenation?
✔ StringBuilder

===============================================================================
 🧪 PRACTICE QUESTIONS (TO SAVE IN PRACTICE FOLDER)
===============================================================================

1️⃣ Take input sentence and reverse using StringBuilder
2️⃣ Convert JSON-like string to key:value using split + replace
3️⃣ Build 1M characters and measure performance of SB & SBuilder
4️⃣ Convert all vowel characters to '*' using mutable classes
5️⃣ Remove all special characters from text in-place

===============================================================================
 END OF FILE
===============================================================================
*/
