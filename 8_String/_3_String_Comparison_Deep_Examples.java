public class _3_String_Comparison_Deep_Examples {
    public static void main(String[] args) {

        /*
         ===========================================================================
          1️⃣ == OPERATOR  (REFERENCE COMPARISON)
         ===========================================================================
         • Compares memory address / reference
         • Checks if both references point to the SAME object
         • DOES NOT compare actual content
        */

        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");

        System.out.println(s1 == s2);   // true  → both in SCP, same reference
        System.out.println(s1 == s3);   // false → heap vs SCP, diff memory
        

        /*
         ===========================================================================
          2️⃣ equals() METHOD  (VALUE / CONTENT COMPARISON)
         ===========================================================================
         • Checks actual characters in the string
         • Case-sensitive
         • Recommended for checking content equality
        */

        String s4 = "Hello";
        String s5 = "Hello";
        String s6 = new String("Hello");

        System.out.println(s4.equals(s5)); // true
        System.out.println(s4.equals(s6)); // true


        /*
         ===========================================================================
          3️⃣ equalsIgnoreCase() (Case-Insensitive Value Check)
         ===========================================================================
         • Ignores uppercase/lowercase differences
        */

        String t1 = "JAVA";
        String t2 = "java";

        System.out.println(t1.equalsIgnoreCase(t2)); // true


        /*
         ===========================================================================
          4️⃣ compareTo()  (LEXICOGRAPHICAL COMPARISON)
         ===========================================================================
         • Compares strings based on ASCII / Unicode values
         • Returns:
              0  → equal
             >0 → first string is "greater"
             <0 → first string is "smaller"
        */

        System.out.println("apple".compareTo("banana")); // -1 (a < b)
        System.out.println("banana".compareTo("apple")); // 1  (b > a)
        System.out.println("cat".compareTo("cat")); // 0


        /*
         ===========================================================================
          5️⃣ compareToIgnoreCase()  (Case-Insensitive Lexical Comparison)
        */

        System.out.println("A".compareToIgnoreCase("a")); // 0   ✔️ case ignored
    }
}


/*
===============================================================================
 📍 MEMORY + COMPARISON DIAGRAM
===============================================================================

String s1 = "Java";
String s2 = "Java";
String s3 = new String("Java");

       SCP (String Constant Pool)
     +------------------------+
     |  "Java" <--- s1,s2     |
     +------------------------+

       HEAP MEMORY
     +------------------------+
     |  "Java" <--- s3        |
     +------------------------+

✔ s1 == s2 → true  (same reference)
❌ s1 == s3 → false (diff blocks)
✔ s1.equals(s3) → true (same content)

===============================================================================
 🧠 DIFFERENCE TABLE FOR REVISION
===============================================================================

Method                   | Compares            | Case?     | Level
--------------------------|---------------------|-----------|------------------
==                        | Reference/Mem Addr | N/A       | Memory Level
equals()                  | Value/Content      | Sensitive | Logical Level
equalsIgnoreCase()        | Value/Content      | No        | Logical Level
compareTo()               | Lexicographic      | Sensitive | Sorting/Order
compareToIgnoreCase()     | Lexicographic      | No        | Sorting/Order


===============================================================================
 ⚠️ INTERVIEW TRAPS (ANSWER CAREFULLY)
===============================================================================

❓ Q1: Why does `"Java" == "Java"` return true?
✔ Because both are literals → stored in SCP → reused reference

❓ Q2: Why does `new String("Java") == "Java"` return false?
✔ new always creates a new object in HEAP

❓ Q3: Best way to compare string values in Java?
✔ Use equals() (or equalsIgnoreCase()) — NOT ==

❓ Q4: When to use compareTo()?
✔ When performing alphabetical sorting or ordering

❓ Q5: What is lexicographical comparison?
✔ Character-by-character comparison using ASCII/Unicode numeric values


===============================================================================
 🚀 REAL-WORLD USAGE EXAMPLES (VERY IMPORTANT)
===============================================================================

// Login Validation
if(userInput.equals(storedUsername)) { ... }

// Searching a name in DB (case-insensitive)
if(name.equalsIgnoreCase("admin")) { ... }

// Sorting names alphabetically
Collections.sort(listOfNames); // internally compareTo() used


===============================================================================
 🧪 CODING QUESTIONS FOR PRACTICE
===============================================================================

1) Write program to check if two strings are anagrams.
2) Write program to count occurrence of each character.
3) Remove duplicate characters from string without using extra space.
4) Sort a list of strings using compareTo().
5) Implement your own version of equals() logic manually.

(We will solve these in file 07_Practice_Questions later)

===============================================================================
 END OF FILE
===============================================================================
*/
