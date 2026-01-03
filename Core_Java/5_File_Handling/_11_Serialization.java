import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

/*
===============================================================================
  1. INTRODUCTION – WHAT IS SERIALIZATION?
===============================================================================

Serialization is the process of converting an object’s state into a
sequence of bytes so that it can be:
  • Saved to a file
  • Sent over a network
  • Stored in a database

Deserialization is the reversal process — converting the byte stream
back into a live Java object. :contentReference[oaicite:1]{index=1}
*/

public class _11_Serialization {

    public static void main(String[] args) {

        /*
         ===========================================================================
          STEP 1: SERIALIZE (WRITE) A VEHICLE OBJECT TO FILE
         ===========================================================================
        */
        Vehicle bike = new Vehicle("Bike", 1234);
        System.out.println("Serializing objects...");

        try (FileOutputStream fos = new FileOutputStream("vehicle.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(bike); // write object to file
            System.out.println("✔ Object serialized successfully.");

        } catch (IOException e) {
            System.out.println("❌ Error during serialization: " + e.getMessage());
            e.printStackTrace();
        }

        /*
         ===========================================================================
          STEP 2: DESERIALIZE (READ) THE OBJECT BACK
         ===========================================================================
        */
        System.out.println("\nReading object from file...");

        try (FileInputStream fis = new FileInputStream("vehicle.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Vehicle readVehicle = (Vehicle) ois.readObject();
            System.out.println("✔ Object deserialized successfully:");
            readVehicle.display();

        } catch (FileNotFoundException e) {
            System.out.println("⚠ File not found.");
        } catch (IOException e) {
            System.out.println("⚠ I/O error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("⚠ Class not found during deserialization.");
        }
    }
}

/*
===============================================================================
  2. SERIALIZABLE CLASS – VEHICLE
===============================================================================

A class must implement java.io.Serializable to be eligible for serialization.
This is a marker interface — it has no methods but signals that the JVM
can serialize objects of this class. :contentReference[oaicite:2]{index=2}
*/

class Vehicle implements Serializable {

    // Optional version UID for reliability across versions
    private static final long serialVersionUID = 1L;

    private String type;
    private int number;

    public Vehicle(String type, int number) {
        this.type = type;
        this.number = number;
    }

    public void display() {
        System.out.println("Type: " + type + ", Number: " + number);
    }
}

/*
===============================================================================
  3. HOW IT WORKS – STEP-BY-STEP
===============================================================================

✔ ObjectOutputStream wraps a FileOutputStream to convert objects into a
  byte stream.
✔ writeObject(obj) writes the object’s state to the file.
✔ ObjectInputStream wraps a FileInputStream to read bytes back.
✔ readObject() returns a generic Object that must be cast to the
  appropriate class. :contentReference[oaicite:3]{index=3}

Example file ‘vehicle.dat’ will contain binary data, not text.

===============================================================================
  4. serialVersionUID EXPLAINED
===============================================================================

serialVersionUID is a unique identifier for each Serializable class.
It ensures that during deserialization, the sender and receiver of a
serialized object have compatible classes. If not, Java throws
InvalidClassException. :contentReference[oaicite:4]{index=4}

Example declaration (in the class):
  private static final long serialVersionUID = 1L;

Best practice: always define serialVersionUID for Serializable classes.
This avoids unexpected exceptions when class definitions evolve.

===============================================================================
  5. TRANSIENT KEYWORD
===============================================================================

Fields marked with `transient` are NOT serialized.
Useful for sensitive data or values that can be recomputed. :contentReference[oaicite:5]{index=5}

Example:
  transient private String secretInfo;

During deserialization, transient fields are replaced with default values
(e.g., null for objects, 0 for primitives).

===============================================================================
  6. EXCEPTIONS INVOLVED
===============================================================================

✔ FileNotFoundException — file not found.
✔ IOException — problems writing/reading file.
✔ ClassNotFoundException — class not found during deserialization.

Always handle them gracefully.

===============================================================================
  7. WHEN TO USE SERIALIZATION
===============================================================================

✔ Persist object state to file (e.g., save user data).
✔ Send objects over a network connection.
✔ Cache objects to disk. :contentReference[oaicite:6]{index=6}

===============================================================================
  8. INTERVIEW QUESTIONS & ANSWERS
===============================================================================

Q1. What is Java serialization?
→ Converting an object into a stream of bytes for storage or transmission. :contentReference[oaicite:7]{index=7}

Q2. What interface must a class implement to be serializable?
→ java.io.Serializable (marker interface). :contentReference[oaicite:8]{index=8}

Q3. What is serialVersionUID and why is it used?
→ A unique ID to maintain version compatibility during deserialization. :contentReference[oaicite:9]{index=9}

Q4. What keyword prevents a field from being serialized?
→ transient. :contentReference[oaicite:10]{index=10}

Q5. Which streams handle serialization/deserialization?
→ ObjectOutputStream and ObjectInputStream. :contentReference[oaicite:11]{index=11}

===============================================================================
  9. BEST PRACTICES
===============================================================================

✔ Always define serialVersionUID in Serializable classes.  
✔ Use transient for sensitive fields.  
✔ Close streams using try-with-resources.  
✔ Don’t serialize unnecessary fields to save space.

===============================================================================
 END OF FILE
===============================================================================
*/
