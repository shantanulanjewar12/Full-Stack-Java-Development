import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _8_ReadTextFileUsingScanner {

    /*
     ===========================================================================
      WHY USE SCANNER TO READ FILES?
     ===========================================================================
     
     The Scanner class from java.util allows you to read text from a file.
     → Simple and intuitive API
     → Can read entire lines or break into tokens
     → Useful for small to medium-sized files

     Scanner can read:
       • words/tokens
       • lines
       • numbers and other primitives easily

     This lesson shows how to read a text file line by line using Scanner. :contentReference[oaicite:1]{index=1}
    */

    public static void main(String[] args) {

        System.out.println("=== Reading file using Scanner ===");

        // Step 1: Provide the file path
        // Replace "sample.txt" with the file you want to read
        File file = new File("sample.txt");

        try {
            // Step 2: Create Scanner object passing the File
            Scanner scanner = new Scanner(file);

            /*
             ===========================================================================
              Step 3: Read file content line by line
             ===========================================================================
             
             • hasNextLine() → returns true if there is another line
             • nextLine() → reads and returns the next line
             
             Loop runs until end of file. :contentReference[oaicite:2]{index=2}
            */

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            // Close scanner to release resources
            scanner.close();

        } catch (FileNotFoundException e) {
            /*
             ===========================================================================
              HANDLE EXCEPTIONS
             ===========================================================================
             
             • FileNotFoundException occurs if file doesn't exist
             • Always handle exceptions so program doesn’t crash
            */
            System.out.println("⚠ File not found: " + file.getName());
            e.printStackTrace();
        }
    }
}

/*
===============================================================================
 INTERVIEW QUESTIONS & ANSWERS
===============================================================================

Q1. How do you read a text file using Scanner in Java?
→ Create a Scanner by passing a File object, then loop using hasNextLine() and nextLine(). :contentReference[oaicite:3]{index=3}

Q2. Why do we use hasNextLine() in Scanner?
→ hasNextLine() checks if there is any more line to read. :contentReference[oaicite:4]{index=4}

Q3. How is Scanner different from BufferedReader?
→ Scanner is easier for simple reading and parsing tokens; BufferedReader is faster for large files. :contentReference[oaicite:5]{index=5}

Q4. What exception do you need to catch when reading files with Scanner?
→ FileNotFoundException. :contentReference[oaicite:6]{index=6}

Q5. Can Scanner read numbers from files?
→ Yes — Scanner has methods like nextInt(), nextDouble(), etc., to parse primitives. :contentReference[oaicite:7]{index=7}

===============================================================================
 BEST PRACTICES
===============================================================================

✔ Always close the Scanner to release resources.  
✔ Use try-with-resources for automatic closing.  
✔ Scanner is good for small/medium files or token parsing.  
✔ Avoid using Scanner for very large files due to performance overhead. :contentReference[oaicite:8]{index=8}

===============================================================================
 HOW IT WORKS — SIMPLE EXPLANATION
===============================================================================

1. **File file = new File("sample.txt")**  
   – Represents the text file on disk.

2. **Scanner scanner = new Scanner(file)**  
   – Opens the file for reading.

3. **while(scanner.hasNextLine())**  
   – Checks if there’s more content.

4. **scanner.nextLine()**  
   – Reads the next line of text.

5. **scanner.close()**  
   – Releases the file handle and closes the resource.

===============================================================================
 SAMPLE INPUT (sample.txt)
===============================================================================
Hello World
Welcome to Java I/O
Reading file using Scanner
EOF

===============================================================================
 SAMPLE OUTPUT
===============================================================================
Hello World
Welcome to Java I/O
Reading file using Scanner

===============================================================================
 END OF FILE
===============================================================================
*/
