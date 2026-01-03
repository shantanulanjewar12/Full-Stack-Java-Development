import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class _9_Scanner_vs_BufferedReader {

    public static void main(String[] args) {

        System.out.println("=== Scanner vs BufferedReader Comparison Demo ===");

        System.out.println("\n--- Using Scanner to read a file ---");
        try {
            Scanner scanner = new Scanner(new java.io.File("example.txt"));
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Scanner: File reading failed.");
        }

        System.out.println("\n--- Using BufferedReader to read a file ---");
        try (BufferedReader br = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("BufferedReader: File reading failed.");
        }
    }
}

/*
===============================================================================
 UNDERSTANDING SCANNER AND BUFFEREDREADER
===============================================================================

1. Scanner
   • Part of java.util package
   • Reads *tokens* from input like individual parts
   • Supports methods like nextInt(), nextDouble(), nextLine()
   • Simple and easy to use
   • Useful for parsing input into types
   • Great for small files or console input :contentReference[oaicite:1]{index=1}

2. BufferedReader
   • Part of java.io package
   • Reads characters efficiently
   • Usually wrapped around FileReader
   • Best for reading lines line-by-line using readLine()
   • Faster for large files and text data :contentReference[oaicite:2]{index=2}

===============================================================================
 SCANNER VS BUFFEREDREADER — KEY DIFFERENCES
===============================================================================

 1) **Ease of Use**
    Scanner: Simple API with built-in parsing
    BufferedReader: More manual (needs parsing manually) :contentReference[oaicite:3]{index=3}

 2) **Performance**
    BufferedReader is *faster* for reading large files because it buffers
    large chunks of data at once.
    Scanner is slower due to tokenization overhead. :contentReference[oaicite:4]{index=4}

 3) **Parsing**
    Scanner can parse different types (int, float, double) directly.
    BufferedReader only reads text — conversion done manually. :contentReference[oaicite:5]{index=5}

 4) **Package**
    Scanner → java.util
    BufferedReader → java.io :contentReference[oaicite:6]{index=6}

 5) **Buffer Size**
    Scanner uses a *smaller internal buffer*.
    BufferedReader uses a *larger internal buffer* (default ~8KB). :contentReference[oaicite:7]{index=7}

 6) **Exception Handling**
    Scanner hides most exceptions internally.
    BufferedReader explicitly throws IOException. :contentReference[oaicite:8]{index=8}

 7) **Thread Safety**
    BufferedReader is synchronized and thread-safe.
    Scanner is not synchronized — not inherently thread-safe. :contentReference[oaicite:9]{index=9}

===============================================================================
 WHEN TO USE WHICH?
===============================================================================

✔ **Use Scanner When:**
   • You need to read and parse different data types easily.
   • Files are small to medium in size.
   • You want quick, readable code for simple input tasks. :contentReference[oaicite:10]{index=10}

✔ **Use BufferedReader When:**
   • Performance matters (large files / heavy I/O).
   • You only need to read text or lines.
   • You are processing large logs or streaming data. :contentReference[oaicite:11]{index=11}

===============================================================================
 INTERVIEW QUESTIONS & ANSWERS
===============================================================================

Q1. What are the main differences between Scanner and BufferedReader?
→ Scanner parses tokens and is easy to use;
   BufferedReader reads text efficiently and is faster for large data. :contentReference[oaicite:12]{index=12}

Q2. Which one is faster?
→ BufferedReader is generally faster due to larger buffering and lack
   of parsing overhead. :contentReference[oaicite:13]{index=13}

Q3. Can Scanner parse primitive types?
→ Yes — Scanner can parse int, float, double, etc., using nextInt(),
   nextFloat(), etc. :contentReference[oaicite:14]{index=14}

Q4. Why is BufferedReader better for large files?
→ It buffers large chunks of data into memory, reducing physical reads
   and I/O calls. :contentReference[oaicite:15]{index=15}

Q5. Which packages do they belong to?
→ Scanner → java.util
   BufferedReader → java.io :contentReference[oaicite:16]{index=16}

===============================================================================
 BEST PRACTICES
===============================================================================

✔ Close all resources when done (use try-with-resources).  
✔ Use BufferedReader for big text-based files.  
✔ Use Scanner when parsing specific types from input.  
✔ Handle exceptions explicitly for robust code.

===============================================================================
 NOTES
===============================================================================

📌 Scanner is easier for beginners.  
📌 BufferedReader provides performance advantage for heavy I/O.  
📌 Choose based on use case — parsing vs performance. :contentReference[oaicite:17]{index=17}

===============================================================================
 END OF FILE
===============================================================================
*/
