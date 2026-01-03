import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class _6_TryWithResources {

    /*
     ===========================================================================
      WHY DO WE NEED TRY-WITH-RESOURCES?
     ===========================================================================
     
     In Java, many classes such as FileReader, FileWriter, BufferedReader,
     BufferedWriter, network connections, database connections, etc., open
     *resources* that MUST be closed after use.

     Before Java 7, developers had to close resources inside a finally block:
         try {
             // use resource
         } catch (Exception e) {
             // handle
         } finally {
             if (resource != null) resource.close();
         }

     But this approach is:
     • verbose
     • error-prone (risk of forgetting to close resources)
     • hard to maintain

     Java 7 introduced **try-with-resources** to automatically close resources
     that implement the AutoCloseable interface. :contentReference[oaicite:1]{index=1}
    */

    public static void main(String[] args) {

        /*
         ===========================================================================
          EXAMPLE 1 — WRITING A FILE WITH TRY-WITH-RESOURCES
         ===========================================================================
         The resource (BufferedWriter) will be automatically closed once
         the try block finishes — even if an exception is thrown. :contentReference[oaicite:2]{index=2}
        */
        System.out.println("=== Writing to file with try-with-resources ===");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true))) {
            writer.write("Line written using try-with-resources.\n");
            System.out.println("✔ Content written successfully.");
        } catch (IOException e) {
            System.out.println("❌ Error while writing to file.");
            e.printStackTrace();
        }

        /*
         ===========================================================================
          EXAMPLE 2 — READING A FILE WITH TRY-WITH-RESOURCES
         ===========================================================================
        */
        System.out.println("\n=== Reading from file with try-with-resources ===");

        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("❌ Error while reading file.");
            e.printStackTrace();
        }
    }
}

/*
===============================================================================
 INTERVIEW QUESTIONS & ANSWERS
===============================================================================

Q1. What is try-with-resources in Java?
→ It is a special form of try statement introduced in Java 7 that automatically
   closes resources declared within the try block, eliminating the need for a
   finally block. :contentReference[oaicite:3]{index=3}

Q2. What conditions must a class meet to be used in try-with-resources?
→ The class must implement the AutoCloseable interface (includes all Closeable
   classes like streams and readers). :contentReference[oaicite:4]{index=4}

Q3. Why is try-with-resources better than the old try-catch-finally?
→ • Automatically closes resources
   • Reduces code verbosity
   • Prevents resource leaks
   • Avoids common bugs when closing resources manually :contentReference[oaicite:5]{index=5}

Q4. Can multiple resources be declared?
→ Yes — separate each with semicolon within parentheses. :contentReference[oaicite:6]{index=6}

Q5. What happens if an exception occurs inside the try block?
→ The resource is still closed automatically, and the exception propagates as normal
   (suppressed exceptions can also be tracked). :contentReference[oaicite:7]{index=7}

===============================================================================
 BEST PRACTICES
===============================================================================

✔ Always use try-with-resources when working with streams, files, sockets,
   and database connections. :contentReference[oaicite:8]{index=8}

✔ Declare resources inside the try parentheses. :contentReference[oaicite:9]{index=9}

✔ Catch exceptions meaningfully (don’t suppress them silently). :contentReference[oaicite:10]{index=10}

✔ For custom resources, implement AutoCloseable and override close(). :contentReference[oaicite:11]{index=11}

===============================================================================
 NOTES
===============================================================================

📌 The close() method is invoked automatically, even if an exception is thrown
   — this makes your code safer and cleaner compared to try-catch-finally. :contentReference[oaicite:12]{index=12}

📌 Multiple resources declared in try-with-resources are closed in the
   *reverse order* of declaration. :contentReference[oaicite:13]{index=13}

===============================================================================
 END OF FILE
===============================================================================
*/
