/**
 * ============================================================
 * FILE NAME  : _4_Checked_Exceptions.java
 * PACKAGE    : ExceptionHandling
 * TOPIC      : Checked Exceptions
 * ============================================================
 *
 * =========================
 * 1. WHAT ARE CHECKED EXCEPTIONS?
 * =========================
 * - Exceptions checked at COMPILE TIME
 * - Compiler forces handling
 * - Must be either:
 *      a) handled using try-catch
 *      b) declared using throws
 *
 * =========================
 * 2. WHY THEY ARE CALLED CHECKED?
 * =========================
 * - Compiler checks possibility of exception
 * - Program will NOT compile if not handled
 *
 * =========================
 * 3. PARENT CLASS
 * =========================
 * - java.lang.Exception
 * - (EXCEPT RuntimeException and its subclasses)
 *
 * ================================================================================
 * 4. COMMON CHECKED EXCEPTIONS
 * ================================================================================
    
    1. IOException
Explanation:
IOException is a general error that happens when there’s an issue with input/output operations, such as reading from or writing to a file, or communicating over a network.
Example:
Imagine you're trying to open a file that doesn't exist or a file that is currently being used by another program, so you can’t access it.
Where it's used:
This exception is used when your program deals with file handling or network connections.
Why it happens:
It happens when there is a problem with accessing or manipulating files or data streams (like reading from or writing to a file).
When it happens:
When the program tries to perform I/O operations and something goes wrong (e.g., file not found, permissions issue, or network failure).

Example Code:

try {
    FileInputStream file = new FileInputStream("myfile.txt");
} catch (IOException e) {
    System.out.println("File not found or could not be opened.");
}


2. FileNotFoundException
Explanation:
FileNotFoundException is a specific kind of IOException that occurs when the program tries to access a file that doesn't exist at the specified location.
Example:
You might have a program that tries to read from a file named data.txt, but that file is missing.
Where it's used:
It’s used in file handling operations when trying to open or read a file that doesn't exist.
Why it happens:
It occurs when the program asks for a file that is either not present, incorrectly named, or placed in the wrong directory.
When it happens:
When the program specifically can't find the file you're trying to work with.

Example Code:
try {
    FileReader fr = new FileReader("missingfile.txt");
} catch (FileNotFoundException e) {
    System.out.println("The file was not found!");
}


3. EOFException (End of File Exception)
Explanation:
EOFException occurs when the program tries to read past the end of a file or data stream.
Example:
Imagine you’re reading a file line by line, but the file ends and you try to read again, even though there’s nothing left.
Where it's used:
It's used when reading files or streams (like when reading from a network socket).
Why it happens:
It happens when the program tries to read more data from a file or stream, but the end of the file or stream is reached.
When it happens:
When your program tries to read after the file or data stream ends.

Example Code:
try {
    DataInputStream data = new DataInputStream(new FileInputStream("data.txt"));
    while (true) {
        String line = data.readLine(); // Might throw EOFException when the end is reached
    }
} catch (EOFException e) {
    System.out.println("Reached the end of the file!");
}


4. SocketException
Explanation:
SocketException occurs when there is a problem with the network connection, such as a failure in establishing a connection or an issue with communication over a network socket.
Example:
You might have a program that connects to a server over the internet. If the connection is lost, you will get a SocketException.
Where it's used:
It’s used in network programming when you're communicating over a network (e.g., HTTP requests, database connections).
Why it happens:
It can happen if the network is down, the server is unreachable, or there’s a timeout while trying to send or receive data.
When it happens:
When a connection or communication error occurs during network operations.

Example Code:
try {
    Socket socket = new Socket("example.com", 80); // Attempting to connect to a server
} catch (SocketException e) {
    System.out.println("Network connection problem!");
}


5. SQLException
Explanation:
SQLException occurs when there is a problem interacting with a database. This can happen due to a bad SQL query, connection issues, or problems with the database itself.
Example:
You might be trying to query a database for a list of users, but your query has an error, or there’s a connection issue with the database.
Where it's used:
It’s used when your program interacts with a database (using SQL queries to insert, update, or retrieve data).
Why it happens:
It happens when there’s a problem with your database operation, such as a wrong SQL query or database server failure.
When it happens:
When your program tries to execute a query or connect to a database and something goes wrong.

Example Code:
try {
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "user", "password");
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM users");  // Error could happen here
} catch (SQLException e) {
    System.out.println("Database error occurred!");
}


6. ClassNotFoundException
Explanation:
ClassNotFoundException occurs when the Java runtime can't find a class that your program is trying to load. This usually happens when you try to load a class dynamically (e.g., using Class.forName()), but the class is not available in the classpath.
Example:
Your program is trying to use a class Employee, but the class file is missing, or the classpath is not set correctly.
Where it's used:
It’s used when your program attempts to load a class dynamically, usually when using reflection or connecting to a database.
Why it happens:
It happens when the class you’re trying to load is either not in the classpath or doesn’t exist.
When it happens:
When the program needs to dynamically load a class (e.g., loading JDBC drivers) but cannot find it.

Example Code:
try {
    Class.forName("com.mysql.cj.jdbc.Driver");  // Error occurs if the class isn't available
} catch (ClassNotFoundException e) {
    System.out.println("Class not found!");
}


7. InterruptedException
Explanation:
InterruptedException happens when a thread (part of a program running in the background) is waiting or sleeping, and someone interrupts it. It’s like stopping a task that’s in progress.
Example:
You have a thread waiting for a response from a server, and the user presses a button to stop the task, causing the thread to be interrupted.
Where it's used:
It’s used when dealing with multi-threading in Java, especially when one thread is waiting or sleeping and gets interrupted by another thread.
Why it happens:
It happens when another thread calls interrupt() on the thread that is currently sleeping or waiting, causing the interrupted thread to wake up and handle the interruption.
When it happens:
When a thread is waiting, sleeping, or performing a blocking operation and gets interrupted.

Example Code:
try {
    Thread.sleep(5000);  // Thread sleeps for 5 seconds
} catch (InterruptedException e) {
    System.out.println("Thread was interrupted during sleep!");
}



 *
 * =========================
 * 5. IMPORTANT RULE
 * =========================
 * - Checked exceptions MUST be handled
 *
 * ============================================================
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class _4_Checked_Exceptions {

    public static void main(String[] args) {

        // -----------------------------
        // Example 1: FileNotFoundException
        // -----------------------------

        // ❌ Compile-time error if not handled
        // FileInputStream fis = new FileInputStream("abc.txt");

        // ✅ Proper handling using try-catch
        try {
            FileInputStream fis = new FileInputStream("abc.txt");
            System.out.println("File opened successfully");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        
        // -----------------------------
        // Example 2: ClassNotFoundException
        // -----------------------------
        try {
            Class.forName("com.fake.MyClass");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }

        System.out.println("Program continues normally");
    }
}

//=====================================================================
/*
🎯 INTERVIEW QUESTIONS & ANSWERS

Q1: What is checked exception?
A: Exception checked at compile time and must be handled.

Q2: Give examples.
A: IOException, SQLException, ClassNotFoundException.

Q3: Parent class of checked exception?
A: java.lang.Exception

Q4: Can checked exception occur at runtime?
A: Yes, but compiler ensures handling beforehand.

Q5 (TRICKY): Is IOException checked or unchecked?
A: Checked exception.

Q6 (TRICKY): Can we convert checked exception to unchecked?
A: Yes, by wrapping inside RuntimeException.
throw new RuntimeException(e);

Q7: Why RuntimeException is excluded?
A: Because they are programming mistakes.


🧪 REAL-WORLD USAGE
✔ File reading
✔ DB connection
✔ Thread sleep
✔ Network calls
*/