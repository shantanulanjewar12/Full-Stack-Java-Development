import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class _5_WriteContentToFile {

    /*
     ===========================================================================
      WHY WRITE TO FILES?
     ===========================================================================
     Writing content to files is an essential operation in Java so that data
     produced by a program can be persisted outside the running application
     — for example:
       • Logs
       • User data
       • Reports
       • Configuration settings
     This lesson explains how to write text to files in Java using core IO
     classes. :contentReference[oaicite:1]{index=1}
    */

    public static void main(String[] args) {

        /*
         ===========================================================================
          EXAMPLE 1 — SIMPLE WRITE USING BufferedWriter
         ===========================================================================
        */
        System.out.println("=== Example 1: Write to File ===");

        // We create a File object to represent the file on disk
        File file = new File("notes.txt");

        try {
            /*
             * FileWriter opens the file for writing — by default it
             * overwrites existing contents.
             *
             * BufferedWriter wraps FileWriter to buffer data for
             * efficient writing.
             */
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            bw.write("Hello, this is a first line in the file.\n");
            bw.write("We are learning Java file writing.\n");
            bw.write("This text demonstrates writing text content.\n");

            /*
             * IMPORTANT: Always close your writer after writing.
             * This flushes all remaining buffered content to the file.
             */
            bw.close();
            System.out.println("✔ Content successfully written to file.");

        } catch (IOException e) {
            System.out.println("❌ Error occurred while writing to file.");
            e.printStackTrace();
        }

        /*
         ===========================================================================
          EXAMPLE 2 — APPEND MODE (DO NOT OVERWRITE)
         ===========================================================================
         When writing to a file, sometimes you want to *add* more lines
         without erasing existing content.
         To do this, use FileWriter with 'true' as the second parameter. 
        */
        System.out.println("\n=== Example 2: Append to File ===");

        try {
            BufferedWriter bwAppend = new BufferedWriter(
                new FileWriter(file, true)  // 'true' means append
            );

            bwAppend.write("This line will be appended.\n");
            bwAppend.write("Appending another new line.\n");

            bwAppend.close();
            System.out.println("✔ Content appended successfully.");

        } catch (IOException e) {
            System.out.println("❌ Error occurred during append.");
            e.printStackTrace();
        }

        /*
         ===========================================================================
          EXAMPLE 3 — USING File OBJECT AND PATH
         ===========================================================================
         Instead of passing a string path, we can pass a File object
         to FileWriter if we want more flexibility. 
        */
        System.out.println("\n=== Example 3: Using File Object ===");
        File folder = new File("logs");
        folder.mkdirs();  // ensure directory exists

        File logFile = new File(folder, "app_log.txt");

        try {
            BufferedWriter logWriter = new BufferedWriter(
                new FileWriter(logFile, true)
            );

            logWriter.write("Log entry: Application started.\n");

            logWriter.close();
            System.out.println("✔ Log entry written successfully.");
        } catch (IOException e) {
            System.out.println("❌ Log write failed.");
            e.printStackTrace();
        }
    }
}

/*
===============================================================================
 INTERVIEW QUESTIONS & ANSWERS
===============================================================================

Q1. How do you write text to a file in Java?
→ Use FileWriter wrapped in BufferedWriter. FileWriter writes to a file;
   BufferedWriter improves efficiency. :contentReference[oaicite:4]{index=4}

Q2. What is the default behavior of FileWriter?
→ By default, FileWriter overwrites the contents of the file. Using
   FileWriter(file, true) enables append mode. :contentReference[oaicite:5]{index=5}

Q3. Why use BufferedWriter over FileWriter directly?
→ BufferedWriter buffers the characters and writes them in chunks,
   making writing more efficient. :contentReference[oaicite:6]{index=6}

Q4. What happens if you forget to close BufferedWriter?
→ You may lose some buffered characters and experience resource leaks.
   Always close writers. :contentReference[oaicite:7]{index=7}

Q5. Can FileWriter create a file if it doesn’t exist?
→ Yes. FileWriter will create the file automatically if the directory exists.
   If the directory does not exist, an IOException occurs. :contentReference[oaicite:8]{index=8}

===============================================================================
 BEST PRACTICES
===============================================================================

✔ Use append mode (`true`) only when needed.  
✔ Close writers in a finally block or use try-with-resources.  
✔ Always handle IOException when working with files.  
✔ Separate writing logic into utility methods for reusable code.

===============================================================================
 END OF FILE
===============================================================================
*/
