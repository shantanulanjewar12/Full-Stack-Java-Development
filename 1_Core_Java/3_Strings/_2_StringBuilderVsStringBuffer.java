
public class _2_StringBuilderVsStringBuffer {
    public static void main(String[] args) {

        // =========================================================
        // 🔹 1. append()
        // =========================================================
        // Definition: Appends the given data (string, number, etc.) at the END of the sequence.
        // Syntax: append(String str)
        // Notes: Extends the length of the sequence.
        System.out.println("🔹 append()");
        StringBuilder sb1 = new StringBuilder("Hello");
        sb1.append(" World");
        System.out.println("StringBuilder: " + sb1); // Output: Hello World

        StringBuffer sbf1 = new StringBuffer("Hello");
        sbf1.append(" Java");
        System.out.println("StringBuffer: " + sbf1); // Output: Hello Java

        // Use Case: Building long strings dynamically, like log messages or queries.
        // Advantage: Fast and flexible concatenation.
        // Disadvantage: Memory grows as you append continuously.

        // =========================================================
        // 🔹 2. insert()
        // =========================================================
        // Definition: Inserts the given text at the specified index.
        // Syntax: insert(int offset, String str)
        // Notes: Index is 0-based. Existing characters are shifted to the right.
        System.out.println("\n🔹 insert()");
        StringBuilder sb2 = new StringBuilder("HelloWorld");
        sb2.insert(5, " ");
        System.out.println("StringBuilder: " + sb2); // Output: Hello World

        StringBuffer sbf2 = new StringBuffer("CodeBuffer");
        sbf2.insert(4, " Java ");
        System.out.println("StringBuffer: " + sbf2); // Output: Code Java Buffer

        // Use Case: Inserting separators, formatting dynamic strings.

        // =========================================================
        // 🔹 3. replace()
        // =========================================================
        // Definition: Replaces characters in a specified range with the given string.
        // Syntax: replace(int start, int end, String str)
        // Notes: start index is INCLUSIVE, end index is EXCLUSIVE.
        System.out.println("\n🔹 replace()");
        StringBuilder sb3 = new StringBuilder("I love Python");
        sb3.replace(7, 13, "Java"); // replaces "Python" → "Java"
        System.out.println("StringBuilder: " + sb3); // Output: I love Java

        StringBuffer sbf3 = new StringBuffer("Good Night");
        sbf3.replace(5, 10, "Morning"); // replaces "Night" → "Morning"
        System.out.println("StringBuffer: " + sbf3); // Output: Good Morning

        // Use Case: Editing dynamic text.
        // Advantage: Efficient for mutable text.
        // Disadvantage: Requires knowing correct indices.

        // =========================================================
        // 🔹 4. delete()
        // =========================================================
        // Definition: Deletes a range of characters from the sequence.
        // Syntax: delete(int start, int end)
        // Notes: start index is INCLUSIVE, end index is EXCLUSIVE.
        System.out.println("\n🔹 delete()");
        StringBuilder sb4 = new StringBuilder("Hello Beautiful World");
        sb4.delete(6, 16); // deletes "Beautiful "
        System.out.println("StringBuilder: " + sb4); // Output: Hello World

        StringBuffer sbf4 = new StringBuffer("DeleteThisText");
        sbf4.delete(6, 10); // deletes "This"
        System.out.println("StringBuffer: " + sbf4); // Output: DeleteText

        // Use Case: Removing substrings or unwanted data.
        // Advantage: Efficient removal.
        // Disadvantage: Risk of StringIndexOutOfBounds if wrong range used.

        // =========================================================
        // 🔹 5. deleteCharAt()
        // =========================================================
        // Definition: Deletes the character at the specified index.
        // Syntax: deleteCharAt(int index)
        // Notes: Index is 0-based.
        System.out.println("\n🔹 deleteCharAt()");
        StringBuilder sb5 = new StringBuilder("ABCDE");
        sb5.deleteCharAt(2); // deletes 'C'
        System.out.println("StringBuilder: " + sb5); // Output: ABDE

        StringBuffer sbf5 = new StringBuffer("HELLO");
        sbf5.deleteCharAt(4); // deletes 'O'
        System.out.println("StringBuffer: " + sbf5); // Output: HELL

        // Use Case: Removing a specific invalid character.

        // =========================================================
        // 🔹 6. reverse()
        // =========================================================
        // Definition: Reverses the entire sequence of characters.
        // Syntax: reverse()
        // Notes: Mutates the same object.
        System.out.println("\n🔹 reverse()");
        StringBuilder sb6 = new StringBuilder("Java");
        sb6.reverse();
        System.out.println("StringBuilder: " + sb6); // Output: avaJ

        StringBuffer sbf6 = new StringBuffer("Code");
        sbf6.reverse();
        System.out.println("StringBuffer: " + sbf6); // Output: edoC

        // Use Case: Palindrome checking, encryption logic.

        // =========================================================
        // 🔹 7. charAt()
        // =========================================================
        // Definition: Returns the character located at the specified index.
        // Syntax: char charAt(int index)
        // Notes: Index is 0-based; throws StringIndexOutOfBoundsException if invalid.
        System.out.println("\n🔹 charAt()");
        StringBuilder sb7 = new StringBuilder("Hello");
        System.out.println("StringBuilder: " + sb7.charAt(1)); // Output: e

        StringBuffer sbf7 = new StringBuffer("World");
        System.out.println("StringBuffer: " + sbf7.charAt(3)); // Output: l

        // Use Case: Accessing individual characters without converting to char array.

        // =========================================================
        // 🔹 8. setCharAt()
        // =========================================================
        // Definition: Sets (replaces) the character at the given index.
        // Syntax: setCharAt(int index, char ch)
        // Notes: Index is 0-based and must be valid.
        System.out.println("\n🔹 setCharAt()");
        StringBuilder sb8 = new StringBuilder("Hollo");
        sb8.setCharAt(1, 'e'); // replaces 'o' with 'e'
        System.out.println("StringBuilder: " + sb8); // Output: Hello

        StringBuffer sbf8 = new StringBuffer("Jxva");
        sbf8.setCharAt(1, 'a');
        System.out.println("StringBuffer: " + sbf8); // Output: Java

        // Use Case: Correcting a single wrong character.

        // =========================================================
        // 🔹 9. length()
        // =========================================================
        // Definition: Returns the current number of characters in the sequence.
        // Syntax: int length()
        System.out.println("\n🔹 length()");
        StringBuilder sb9 = new StringBuilder("Java");
        System.out.println("StringBuilder length: " + sb9.length()); // Output: 4

        StringBuffer sbf9 = new StringBuffer("OpenAI");
        System.out.println("StringBuffer length: " + sbf9.length()); // Output: 6

        // Use Case: Checking string size before processing.

        // =========================================================
        // 🔹 10. capacity()
        // =========================================================
        // Definition: Returns the current capacity (allocated storage) of the buffer.
        // Syntax: int capacity()
        // Notes: Default capacity = 16 for empty constructors.
        System.out.println("\n🔹 capacity()");
        StringBuilder sb10 = new StringBuilder();
        System.out.println("Default capacity: " + sb10.capacity()); // Output: 16
        sb10.append("Hello Java World!");
        System.out.println("After append: " + sb10.capacity());

        StringBuffer sbf10 = new StringBuffer();
        System.out.println("Default capacity: " + sbf10.capacity()); // Output: 16

        // Use Case: For optimizing performance by pre-allocating memory.

        // =========================================================
        // 🔹 11. ensureCapacity()
        // =========================================================
        // Definition: Ensures that the capacity is at least the specified minimum.
        // Syntax: ensureCapacity(int minimumCapacity)
        // Notes: If required, capacity expands automatically.
        System.out.println("\n🔹 ensureCapacity()");
        StringBuilder sb11 = new StringBuilder("Hello");
        sb11.ensureCapacity(50);
        System.out.println("StringBuilder capacity: " + sb11.capacity());

        StringBuffer sbf11 = new StringBuffer("Hi");
        sbf11.ensureCapacity(30);
        System.out.println("StringBuffer capacity: " + sbf11.capacity());

        // Use Case: Avoiding multiple reallocations during concatenation in loops.

        // =========================================================
        // 🔹 12. substring()
        // =========================================================
        // Definition: Returns a substring of the character sequence.
        // Syntax: substring(int start) or substring(int start, int end)
        // Notes: start index is INCLUSIVE, end index is EXCLUSIVE.
        System.out.println("\n🔹 substring()");
        StringBuilder sb12 = new StringBuilder("Hello World");
        System.out.println("StringBuilder substring(6): " + sb12.substring(6)); // World
        System.out.println("StringBuilder substring(0,5): " + sb12.substring(0,5)); // Hello

        StringBuffer sbf12 = new StringBuffer("OpenAI GPT");
        System.out.println("StringBuffer substring(0,6): " + sbf12.substring(0,6)); // OpenAI

        // Use Case: Extracting part of a string like first name or file extension.

        // =========================================================
        // 🔹 13. toString()
        // =========================================================
        // Definition: Converts the mutable StringBuilder/StringBuffer into an immutable String.
        // Syntax: toString()
        System.out.println("\n🔹 toString()");
        StringBuilder sb13 = new StringBuilder("Java");
        String str1 = sb13.toString();
        System.out.println("Converted String: " + str1); // Output: Java

        StringBuffer sbf13 = new StringBuffer("Buffer");
        String str2 = sbf13.toString();
        System.out.println("Converted String: " + str2); // Output: Buffer

        // Use Case: Returning final string output from a builder object.

        // =========================================================
        // ✅ Summary
        // =========================================================
        /*
        🔸 StringBuilder vs StringBuffer Summary:
        --------------------------------------------
        | Feature           | StringBuilder | StringBuffer |
        |-------------------|---------------|---------------|
        | Thread Safe       | ❌ No          | ✅ Yes        |
        | Synchronization   | ❌ No          | ✅ Yes        |
        | Performance       | 🚀 Faster     | 🐢 Slower     |
        | Introduced In     | JDK 1.5       | JDK 1.0       |
        | Comparable Impl.  | ❌ No          | ✅ Yes        |
        | Use Case          | Single-thread | Multi-thread  |
        | Mutability        | ✅ Mutable     | ✅ Mutable     |

        👉 Use StringBuilder → When speed matters and threads are independent.
        👉 Use StringBuffer  → When thread safety is required.
        */
    }
}
