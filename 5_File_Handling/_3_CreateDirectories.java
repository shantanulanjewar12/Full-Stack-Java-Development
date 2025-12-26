import java.io.File;

public class _3_CreateDirectories {

    /*
     ------------------------------------------------------------------------
     1. WHAT IS A DIRECTORY?
     ------------------------------------------------------------------------

     A *directory* (folder) is used to organize files and other folders
     on your computer.

     ▶ In Java, directories are managed using the java.io.File class.

     ▶ Creating, deleting, and checking directories are common tasks in file
       system manipulation.
    */

    public static void main(String[] args) {

        /*
         ------------------------------------------------------------------------
         2. CREATE A SINGLE DIRECTORY USING mkdir()
         ------------------------------------------------------------------------

         • mkdir() creates *only* the last directory in the path.
         • It returns true if the directory was created,
           false if it already existed or could not be created.
        */

        System.out.println("=== mkdir() Example ===");

        File singleDir = new File("SampleDir");

        if (singleDir.mkdir()) {
            System.out.println("✔ Directory created: " + singleDir.getName());
        } else {
            System.out.println("⚠ Directory already exists or failed: " + singleDir.getName());
        }

        /*
         ------------------------------------------------------------------------
         3. CREATE NESTED DIRECTORIES USING mkdirs()
         ------------------------------------------------------------------------

         • mkdirs() creates *all directories in the path* that do not exist.
         • Eg: "Parent/Child/GrandChild" → creates Parent, Child, and GrandChild.
         • Useful when you need to make a full folder structure. 
        */

        System.out.println("\n=== mkdirs() Example ===");

        File nestedDirs = new File("ParentFolder/ChildFolder/GrandChildFolder");

        if (nestedDirs.mkdirs()) {
            System.out.println("✔ Nested folders created successfully!");
        } else {
            System.out.println("⚠ Nested folders already exist or creation failed!");
        }

        /*
         ------------------------------------------------------------------------
         4. CHECK DIRECTORY EXISTENCE
         ------------------------------------------------------------------------

         Before creating a directory, it's common to check if it already exists:
        */

        System.out.println("\n=== Directory Existence Check ===");

        File checkDir = new File("SampleDir");

        if (checkDir.exists() && checkDir.isDirectory()) {
            System.out.println("✔ Directory already exists: " + checkDir.getAbsolutePath());
        } else {
            System.out.println("⚠ Directory does not exist yet.");
        }

        /*
         ------------------------------------------------------------------------
         5. DELETE A DIRECTORY
         ------------------------------------------------------------------------

         The delete() method removes a directory only if it is *empty*.
         If it has files inside, deletion will fail.
        */
        System.out.println("\n=== Deleting Directory ===");

        if (singleDir.delete()) {
            System.out.println("✔ Successfully deleted directory: " + singleDir.getName());
        } else {
            System.out.println("⚠ Could not delete directory (maybe not empty).");
        }
    }
}

/*
===============================================================================
 INTERVIEW QUESTIONS & ANSWERS
===============================================================================

Q1. What is the difference between mkdir() and mkdirs() in Java?
→ mkdir() creates a single directory.
→ mkdirs() creates multiple directories, including any nonexistent parents. :contentReference[oaicite:4]{index=4}

Q2. What does File.exists() do?
→ It checks if the file *or* directory exists.

Q3. Can mkdir() create parent folders if they don’t exist?
→ No. mkdir() only creates the last folder in the path. For parent folders,
→ use mkdirs(). :contentReference[oaicite:5]{index=5}

Q4. How do you delete a directory in Java?
→ Use delete(). It succeeds *only if* directory is empty.

Q5. What does File.isDirectory() check?
→ It confirms that the File object points to a folder, not a file.

===============================================================================
 BEST PRACTICES
===============================================================================

✔ Use mkdirs() when working with multi-level folder structures.  
✔ Always check `.exists()` first if you want to avoid overwriting logic.  
✔ Ensure you have proper permissions to create folders.  
✔ Use `File.separator` for platform-independent paths.

===============================================================================
 NOTES
===============================================================================

✔ In Java, File can represent either files or directories.  
✔ mkdir() and mkdirs() both return boolean status.  
✔ Always handle the result to avoid silent failures.

===============================================================================
 END OF FILE
===============================================================================
*/
