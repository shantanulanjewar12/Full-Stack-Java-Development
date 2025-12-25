/*

===========================
 WHAT IS A DATA STREAM?
===========================

A Data Stream in Java represents a FLOW of DATA from:
    → a SOURCE (keyboard, file, network)
    → to a DESTINATION (console, file, network)

Just like water flows through a pipe,
data flows through a STREAM.

In Java, all Input/Output operations are based on STREAMS.

--------------------------------
 REAL LIFE EXAMPLE:
--------------------------------
 Keyboard  --->  Program  --->  Console
 File      --->  Program  --->  Another File

===========================
 JAVA STREAM CLASSIFICATION
===========================

Java streams are mainly divided into:

1️⃣ Byte Streams
   - Works with raw binary data (bytes)
   - Used for images, audio, video, pdf, etc.
   - Base classes:
        InputStream
        OutputStream

   Examples:
        FileInputStream
        FileOutputStream

2️⃣ Character Streams
   - Works with text data (characters)
   - Handles Unicode automatically
   - Base classes:
        Reader
        Writer

   Examples:
        FileReader
        FileWriter

===========================
 STANDARD STREAMS IN JAVA
===========================

Java provides 3 standard streams automatically:

1. System.in
   - Input stream
   - Reads data from keyboard
   - Type: InputStream

2. System.out
   - Output stream
   - Prints output to console
   - Type: PrintStream

3. System.err
   - Error output stream
   - Used to print error messages
   - Type: PrintStream

===========================
 FILE HANDLING USING STREAMS
===========================

Java treats FILES as STREAMS.

Important point:
---------------
java.io.File does NOT read or write data.
It only represents the file path.

To read/write data, we need streams.

===========================
 IMPORTANT FILE CLASSES
===========================

1. File
   - Represents file or directory path

2. FileInputStream
   - Reads data from file (byte by byte)

3. FileOutputStream
   - Writes data to file (byte by byte)

4. FileReader
   - Reads text data from file

5. FileWriter
   - Writes text data to file

6. Scanner
   - Can read data from file easily

===============================================================================
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class _1_DataStream {

    /*
     * ===========================================================================
     * MAIN METHOD
     * ===========================================================================
     */
    public static void main(String[] args) {

        /*
         * ===========================
         * STEP 1: CREATE FILE OBJECT
         * ===========================
         * 
         * File object represents the file path.
         * It does NOT create the file physically.
         */

        File file = new File("example.txt");

        /*
         * ===========================
         * STEP 2: CREATE A FILE
         * ===========================
         */

        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Error while creating file.");
            e.printStackTrace();
        }

        /*
         * ===========================
         * STEP 3: WRITE DATA INTO FILE
         * ===========================
         * 
         * FileWriter is a CHARACTER STREAM.
         * Used for writing TEXT data.
         */

        try {
            FileWriter writer = new FileWriter(file);
            writer.write("Hello Java Streams!\n");
            writer.write("This file is written using FileWriter.\n");
            writer.write("Used for learning Java File Handling.\n");
            writer.close(); // VERY IMPORTANT
            System.out.println("Data written into file.");
        } catch (IOException e) {
            System.out.println("Error while writing to file.");
            e.printStackTrace();
        }

        /*
         * ===========================
         * STEP 4: READ DATA FROM FILE
         * ===========================
         * 
         * Using Scanner class to read file content.
         */

        try {
            Scanner scanner = new Scanner(file);
            System.out.println("\nReading file content:");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error while reading file.");
            e.printStackTrace();
        }

        /*
         * ===========================
         * STEP 5: FILE INFORMATION
         * ===========================
         */

        if (file.exists()) {
            System.out.println("\nFile Information:");
            System.out.println("File Name: " + file.getName());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Writable: " + file.canWrite());
            System.out.println("Readable: " + file.canRead());
            System.out.println("File Size (bytes): " + file.length());
        }
    }
}

/*
 * =============================================================================
 * ==
 * INTERVIEW QUESTIONS & ANSWERS
 * =============================================================================
 * ==
 * 
 * Q1. What is a stream in Java?
 * → A stream is a sequence of data flowing from source to destination.
 * 
 * Q2. Difference between Byte Stream and Character Stream?
 * → Byte Stream handles raw binary data.
 * → Character Stream handles text and Unicode data.
 * 
 * Q3. What is System.in?
 * → It is a standard input stream used to read keyboard input.
 * 
 * Q4. Does File class read/write data?
 * → NO. File only represents the path.
 * 
 * Q5. Why close streams?
 * → To release system resources and avoid memory leaks.
 * 
 * Q6. Which stream is best for text files?
 * → FileReader / FileWriter
 * 
 * Q7. Which stream is best for images/videos?
 * → FileInputStream / FileOutputStream
 * 
 * =============================================================================
 * ==
 * KEY TAKEAWAYS
 * =============================================================================
 * ==
 * 
 * ✔ Streams are the backbone of Java I/O
 * ✔ File handling is done using streams
 * ✔ Always close streams
 * ✔ Choose correct stream type based on data
 * ✔ Very important topic for interviews
 * 
 * =============================================================================
 * ==
 * END OF FILE
 * =============================================================================
 * ==
 */
