import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _7_ReadTextFileUsingBufferedReader {

    /*
     ===========================================================================
      WHY READ FILES IN JAVA?
     ===========================================================================
     
     Reading files is a fundamental operation for many Java applications:
       • Load configuration settings
       • Process data stored externally
       • Read logs, reports, or user data
       • Parse structured text files like CSV files

     Java provides efficient mechanisms to read text files line-by-line
     using classes from the java.io package. :contentReference[oaicite:1]{index=1}
    */

    public static void main(String[] args) {

        /*
         ===========================================================================
          STEP 1: PATH OF THE FILE TO READ
         ===========================================================================
         Replace "example.txt" with your file name or path.
         A relative path refers to project root,
         an absolute path refers to full system path.
        */
        String filePath = "example.txt";

        /*
         ===========================================================================
          STEP 2: CREATE A TRY-WITH-RESOURCES BLOCK
         ===========================================================================
         BufferedReader buffers characters for efficient reading.
         FileReader actually reads characters from the file.
         Try-with-resources ensures automatic closure of streams. :contentReference[oaicite:2]{index=2}
        */
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            /*
             ===========================================================================
              STEP 3: READ FILE LINE BY LINE
             ===========================================================================
             readLine() returns a line of text or null if end of file is reached.
             Always store the return value in a variable before using it. :contentReference[oaicite:3]{index=3}
            */
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            /*
             ===========================================================================
              HANDLE POTENTIAL ERRORS
             ===========================================================================
              IOException occurs when:
                • File doesn’t exist
                • Permission denied
                • File is locked or unavailable
            */
            System.out.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

/*
===============================================================================
 INTERVIEW QUESTIONS & ANSWERS
===============================================================================

Q1. What class do you use to read text files efficiently in Java?
→ Use BufferedReader wrapped around FileReader to read text line by line. :contentReference[oaicite:4]{index=4}

Q2. Why use BufferedReader instead of FileReader alone?
→ BufferedReader buffers data so reading is faster and more efficient than reading one character at a time. :contentReference[oaicite:5]{index=5}

Q3. How does readLine() work?
→ readLine() returns the next line of text or null when the end of the file is reached. :contentReference[oaicite:6]{index=6}

Q4. What exception must you handle when reading files?
→ IOException — thrown when a file cannot be opened or read. :contentReference[oaicite:7]{index=7}

Q5. What is the advantage of try-with-resources when reading files?
→ It automatically closes the reader so you don’t need to manually close it in finally block. :contentReference[oaicite:8]{index=8}

===============================================================================
 BEST PRACTICES
===============================================================================

✔ Always use try-with-resources to auto-close streams. :contentReference[oaicite:9]{index=9}  
✔ Check that the file paths are correct before reading.  
✔ Avoid reading very large files entirely into memory at once.  
✔ Handle exceptions gracefully and inform the user when something fails.

===============================================================================
 HOW THIS WORKS — SIMPLE EXPLANATION
===============================================================================

1. **FileReader** opens the text file and reads raw characters.  
2. **BufferedReader** wraps FileReader and adds buffering, which improves performance by reducing disk access. :contentReference[oaicite:10]{index=10}  
3. **readLine()** method reads file line-by-line until null (end of file). :contentReference[oaicite:11]{index=11}

===============================================================================
 EXAMPLE FILE (example.txt)
===============================================================================
Hello World!
Welcome to Java File I/O.
Reading files line by line using BufferedReader.
This is the last line.

===============================================================================
 RUNNING THE PROGRAM
===============================================================================

Assuming example.txt is in your project root:

OUTPUT:
Hello World!
Welcome to Java File I/O.
Reading files line by line using BufferedReader.
This is the last line.

===============================================================================
 END OF FILE
===============================================================================
*/
