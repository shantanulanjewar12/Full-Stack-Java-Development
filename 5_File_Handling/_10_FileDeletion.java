import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _10_FileDeletion {

    public static void main(String[] args) {

        /*
         ===========================================================================
          DELETE USING java.io.File.delete()
         ===========================================================================
         The File.delete() method attempts to delete the file or directory
         denoted by the File object and returns true if deletion succeeded.
         It does NOT throw any exception by itself — it returns false instead
         on failure. :contentReference[oaicite:1]{index=1}
        */

        System.out.println("=== Using File.delete() ===");

        File file1 = new File("sample.txt");

        // Check if file exists before deletion
        if (file1.exists()) {
            boolean deleted = file1.delete();
            if (deleted) {
                System.out.println("✔ File deleted successfully: " + file1.getName());
            } else {
                System.out.println("⚠ File could not be deleted: " + file1.getName());
            }
        } else {
            System.out.println("⚠ File does not exist: " + file1.getName());
        }

        /*
         ===========================================================================
          DELETE USING java.nio.file.Files.delete()
         ===========================================================================
         This method deletes the file and throws an exception if deletion fails.
         It provides stronger error-handling compared to File.delete(). :contentReference[oaicite:2]{index=2}
        */

        System.out.println("\n=== Using Files.delete(Path) ===");

        Path pathToDelete = Paths.get("example2.txt");

        try {
            Files.delete(pathToDelete);
            System.out.println("✔ Successfully deleted using Files.delete(): " + pathToDelete);
        } catch (IOException e) {
            System.out.println("⚠ Deletion failed for " + pathToDelete + ": " + e.getMessage());
        }

        /*
         ===========================================================================
          DELETE IF EXISTS USING java.nio.file.Files.deleteIfExists()
         ===========================================================================
         This method tries to delete if the file exists and returns true if
         deletion was performed; false otherwise. :contentReference[oaicite:3]{index=3}
        */

        System.out.println("\n=== Using Files.deleteIfExists(Path) ===");

        Path pathMaybe = Paths.get("optional.txt");

        try {
            boolean wasDeleted = Files.deleteIfExists(pathMaybe);
            if (wasDeleted) {
                System.out.println("✔ Successfully deleted: " + pathMaybe);
            } else {
                System.out.println("⚠ File did not exist so not deleted: " + pathMaybe);
            }
        } catch (IOException e) {
            System.out.println("⚠ Exception happened while deleting " + pathMaybe + ": " + e.getMessage());
        }
    }
}

/*
===============================================================================
 INTERVIEW QUESTIONS & ANSWERS
===============================================================================

Q1. How do you delete a file in Java?
→ You can use File.delete(), Files.delete(Path), or Files.deleteIfExists(Path). :contentReference[oaicite:4]{index=4}

Q2. What does File.delete() return?
→ It returns true if deletion was successful; false if not. :contentReference[oaicite:5]{index=5}

Q3. Does File.delete() throw exceptions?
→ No — it returns false on failure, no exception. For exceptions, use NIO. :contentReference[oaicite:6]{index=6}

Q4. When should you use Files.deleteIfExists()?
→ When you want to safely delete without worrying if the file exists first. :contentReference[oaicite:7]{index=7}

Q5. Can File.delete() remove directories?
→ Yes — but only if the directory is empty. :contentReference[oaicite:8]{index=8}

===============================================================================
 BEST PRACTICES
===============================================================================

✔ Always check file existence before deletion to avoid logic errors.  
✔ Use java.nio.file.Files methods when you need richer exception info.  
✔ Handle IOException for robust deletion flow.  
✔ For directories with contents, delete contents before deletion.  
✔ Avoid silent failures — log or report deletion results clearly. :contentReference[oaicite:9]{index=9}

===============================================================================
 NOTES
===============================================================================

📌 File.delete permanently removes the file — no trash/recycle bin. :contentReference[oaicite:10]{index=10}  
📌 Files.delete() throws exception details which help in debugging. :contentReference[oaicite:11]{index=11}  
📌 Use deleteIfExists to avoid unnecessary exceptions. :contentReference[oaicite:12]{index=12}

===============================================================================
 END OF FILE
===============================================================================
*/
