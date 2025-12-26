import java.io.File;
import java.io.IOException;

public class _2_CreateFile_OnDisk {

    /*
     ------------------------------------------------------------------------
     STEP 1: UNDERSTANDING FILE CREATION IN JAVA
     ------------------------------------------------------------------------

     In Java, creating a file on disk means telling the operating system
     to allocate storage space for a new file with a given name/path.

     Java handles this through the java.io.File class.

     The File class *represents* a file/directory path, but does not
     automatically read or write content until streams or writers are used.

     The method that actually creates a file on disk is:
         boolean createNewFile()
         → returns true if created
         → returns false if file already existed

     It can throw IOException, so proper exception handling is needed.

    */

    public static void main(String[] args) {

        /*
         ------------------------------------------------------------------------
         STEP 2: CREATE A File OBJECT
         ------------------------------------------------------------------------

         Here we're creating a File object that represents
         the file path where we want the file to exist.

         You can provide:
           - just the file name  -> created in project root
           - file name with path -> created in that directory
        */

        File file = new File("myNewFile.txt");

        /*
         ------------------------------------------------------------------------
         STEP 3: TRY CREATING THE FILE ON DISK
         ------------------------------------------------------------------------

         We try calling createNewFile() inside try-catch because
         it throws IOException if something goes wrong:
           • Directory does not exist
           • No write permissions
           • Invalid path
        */
        try {
            if (file.createNewFile()) {
                System.out.println("✔ File successfully created: " + file.getName());
            } else {
                System.out.println("⚠ File already exists: " + file.getName());
            }
        } catch (IOException e) {
            System.out.println("❌ Error occurred while creating file.");
            e.printStackTrace();
        }

        /*
         ------------------------------------------------------------------------
         STEP 4: FILE PATH EXPLANATION
         ------------------------------------------------------------------------

         ✔ Relative Path:
           The file will be created relative to the current working directory.
           Example: "myNewFile.txt" → in project root.

         ✔ Absolute path:
           Provide full path with directories:
           Example: "/home/user/DataFiles/myFile.txt"

         Remember:
           • Windows uses "\" internally
           • Unix/Linux/Mac use "/"
        */
    }
}

/*
===============================================================================
 INTERVIEW QUESTIONS & ANSWERS
===============================================================================

Q1. How do you create a file in Java?
→ Use
      File file = new File("filename.txt");
      file.createNewFile();

   createNewFile() actually creates it on disk.

Q2. What return value does createNewFile() provide?
→ true if newly created, false if already existed.

Q3. Why wrap createNewFile() in try-catch?
→ It throws IOException for errors (permissions, invalid path).

Q4. Does new File("x.txt") create the file automatically?
→ NO — it only creates an object representing the path.

Q5. Can you create a file in a specific folder?
→ Yes — provide the directory path in the File constructor.

===============================================================================
 BEST PRACTICES
===============================================================================

✔ Always handle IOException.  
✔ Use File.separator for cross-OS paths.  
✔ Check existence before writing data.  
✔ Use try-with-resources when writing content.

===============================================================================
 END OF FILE
===============================================================================
*/
