
import java.util.Arrays;

public class _4_Common_String_Methods{

    public static void main(String[] args) {

        /*
        =============================================================================
         1️⃣ LENGTH()
         → returns total number of characters in the string.
        =============================================================================
        */
        String str = "Hello World";
        System.out.println(str.length()); // 11


        /*
        =============================================================================
         2️⃣ CHARAT(index)
         → returns character at specific position (0-based index)
        =============================================================================
        */
        System.out.println(str.charAt(1)); // e


        /*
        =============================================================================
         3️⃣ SUBSTRING(beginIndex, endIndex) → [begin, end)
         → extracts a portion from string
        =============================================================================
        */
        System.out.println(str.substring(0, 5)); // Hello


        /*
        =============================================================================
         4️⃣ CONCAT / + OPERATOR
         → joins two strings
         ⚠ IMMUTABLE: creates new object
        =============================================================================
        */
        String s = "Java";
        String s2 = s.concat("Program");
        System.out.println(s);  // Java  (Not changed)
        System.out.println(s2); // JavaProgram


        /*
        =============================================================================
         5️⃣ toUpperCase() / toLowerCase()
         =============================================================================
        */
        System.out.println("java".toUpperCase()); // JAVA
        System.out.println("JAVA".toLowerCase()); // java


        /*
        =============================================================================
         6️⃣ TRIM()
         → removes leading & trailing spaces
        =============================================================================
        */
        String t = "   India   ";
        System.out.println(t.trim()); // India


        /*
        =============================================================================
         7️⃣ REPLACE(old, new) / replaceAll(regex, new)
         =============================================================================
        */
        String rep = "Hello India";
        System.out.println(rep.replace("India", "World")); // Hello World
        System.out.println(rep.replaceAll("[A-Z]", "*")); // *ello *ndia


        /*
        =============================================================================
         8️⃣ SPLIT(regex)
         → splits string into array
        =============================================================================
        */
        String cities = "Delhi,Mumbai,Pune,Hyderabad";
        String[] arr = cities.split(",");
        System.out.println(Arrays.toString(arr)); // [Delhi, Mumbai, Pune, Hyderabad]


        /*
        =============================================================================
         9️⃣ INDEXOF()
         → returns index of first occurrence
        =============================================================================
        */
        System.out.println("Java Programming".indexOf("a")); // 1
        System.out.println("Java Programming".lastIndexOf("a")); // 3


        /*
        =============================================================================
         🔟 STARTSWITH() / ENDSWITH()
        =============================================================================
        */
        System.out.println("Hello".startsWith("He")); // true
        System.out.println("Hello".endsWith("lo")); // true


        /*
        =============================================================================
         1️⃣1️⃣ EQUALS() VS CONTENTEQUALS()
         =============================================================================
        */
        String z1 = "Java";
        StringBuilder z2 = new StringBuilder("Java");
        System.out.println(z1.equals(z2)); // false (different class)
        System.out.println(z1.contentEquals(z2)); // true (value check)

    }
}

/*
===============================================================================
 ⚠️ MEMORY IMPACT (VERY IMPORTANT)
===============================================================================

📌 Most String methods DO NOT modify original string
➡ Because Strings are IMMUTABLE

Examples that create new objects:
✔ concat()
✔ replace()
✔ substring()
✔ toUpperCase() / toLowerCase()
✔ trim()

Memory Summary:
---------------
Original: "Java"
After : toUpperCase()
Stored as: "JAVA"  (NEW OBJECT)
Because: Immutable

===============================================================================
 🧠 INTERVIEW SHORT NOTES
===============================================================================

Method               | Returns            | Immutable Effect
---------------------|--------------------|-------------------------------
length()             | int (# of chars)   | no object creation
substring()          | new String         | new object if changed
concat()             | new String         | new object always
replace()            | new String         | new object always
split()              | String[]           | immutable still
toUpperCase()        | new String         | yes, new object
trim()               | new String         | new object

===============================================================================
 🎯 MOST ASKED INTERVIEW QUESTIONS
===============================================================================

❓ Why substring() creates a new object?
✔ Because original cannot be changed, so new instance is produced.

❓ split() vs toCharArray() difference?
✔ split() → returns String[] (uses regex)
✔ toCharArray() → returns char[]

❓ contentEquals() vs equals()?
✔ equals → compares only Strings
✔ contentEquals → can compare StringBuilder/StringBuffer

❓ Why replaceAll sometimes slower than replace?
✔ replaceAll uses regex → heavy processing

===============================================================================
 🧪 PRACTICE QUESTIONS (For your 07_Practice Folder)
===============================================================================

1️⃣ Reverse words in a string using split()
2️⃣ Count vowels / consonants
3️⃣ Replace spaces with underscore
4️⃣ Count words in a sentence
5️⃣ Validate email format using regex + matches()

===============================================================================
 END OF FILE
===============================================================================
*/
