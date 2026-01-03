// ============================================================
// 🔹 _11_EnumClass.java
// ============================================================
// Topic: ENUM in Java
// Author: Shantanu Lanjewar
// ============================================================

/*
===============================================================================
💡 WHAT IS ENUM IN JAVA?
===============================================================================
An ENUM (short for *Enumeration*) is a special data type that represents a group
of **fixed constant values**.

Example:
    enum Day { MONDAY, TUESDAY, WEDNESDAY }

Enum provides:
✔ Type-safety  
✔ Readable constants  
✔ Prevents invalid values  
✔ Used when values NEVER change  

===============================================================================
💡 WHY DO WE USE ENUM?
===============================================================================
✔ Better than constant variables  
✔ No invalid values allowed  
✔ Easy to maintain  
✔ Comes with built-in methods  
✔ Used in switch statements  
✔ Represents predefined categories  
   (Days, Directions, Status, Levels, Payment modes)

===============================================================================
🔹 BASIC ENUM EXAMPLE
===============================================================================
*/

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

/*
===============================================================================
🔹 ENUM IN ACTION (Using switch)
===============================================================================
*/

class EnumSwitchDemo {

    void printMessage(Day day) {
        switch (day) {
            case MONDAY:
                System.out.println("Start of the week!");
                break;
            case FRIDAY:
                System.out.println("Weekend is near!");
                break;
            case SUNDAY:
                System.out.println("Holiday!");
                break;
            default:
                System.out.println("Mid-week day");
        }
    }
}

/*
===============================================================================
🔹 ENUM WITH FIELDS, CONSTRUCTOR, METHODS
===============================================================================
Note:
✔ Enum constructor is ALWAYS private (default)
✔ Each constant calls the constructor
===============================================================================
*/

enum Level {

    LOW(1), MEDIUM(2), HIGH(3);

    private int code;

    Level(int code) {  // private constructor
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

/*
===============================================================================
🔹 ENUM IMPLEMENTING INTERFACE
===============================================================================
*/

interface Printable {
    void print();
}

enum Color implements Printable {
    RED, GREEN, BLUE;

    @Override
    public void print() {
        System.out.println("Color: " + this.name());
    }
}

/*
===============================================================================
🔹 PREDEFINED ENUM METHODS (VERY IMPORTANT)
===============================================================================
1) values()        → returns array of enum constants
2) valueOf(String) → returns constant matching string
3) ordinal()       → returns index (0,1,2...)
*/

class EnumMethodsDemo {

    void showMethods() {
        System.out.println("All Days:");

        for (Day d : Day.values())
            System.out.println(d + " → ordinal: " + d.ordinal());

        Day x = Day.valueOf("FRIDAY");
        System.out.println("ValueOf FRIDAY = " + x);
    }
}

/*
===============================================================================
🔹 REAL-WORLD EXAMPLE — ORDER STATUS
===============================================================================
*/

enum OrderStatus {
    PENDING, PROCESSING, SHIPPED, DELIVERED, CANCELLED;
}

class Order {
    OrderStatus status;

    Order(OrderStatus status) {
        this.status = status;
    }

    void printStatus() {
        System.out.println("Order Status: " + status);
        if (status == OrderStatus.DELIVERED)
            System.out.println("Your order has been delivered!");
    }
}

/*
===============================================================================
🔹 MAIN CLASS — DEMO
===============================================================================
*/

public class _11_EnumClass {
    public static void main(String[] args) {

        System.out.println("===== Basic Enum =====");
        EnumSwitchDemo demo = new EnumSwitchDemo();
        demo.printMessage(Day.MONDAY);

        System.out.println("\n===== Enum with Fields & Methods =====");
        System.out.println("Level HIGH Code = " + Level.HIGH.getCode());

        System.out.println("\n===== Enum Implementing Interface =====");
        Color.RED.print();

        System.out.println("\n===== Enum Methods =====");
        new EnumMethodsDemo().showMethods();

        System.out.println("\n===== Real World Example =====");
        Order order = new Order(OrderStatus.SHIPPED);
        order.printStatus();
    }
}

/*
===============================================================================
🔹 ENUM VS CLASS (INTERVIEW)
===============================================================================

| Feature | Enum | Class |
|---------|------|--------|
| Extends class? | ✔ extends java.lang.Enum | Can extend a class |
| Instantiation | ❌ Not allowed | ✔ Allowed |
| Constructor | private only | any modifier |
| Number of Objects | fixed | unlimited |
| Type Safety | ✔ High | medium |
| Usage | constants grouping | logic/model |

===============================================================================
🔹 ADVANTAGES OF ENUM
===============================================================================
✔ Type-safe constant values  
✔ Easy to read and maintain  
✔ Prevent invalid values  
✔ Can have methods, variables, constructors  
✔ Works well in switch-case  
✔ Excellent for fixed groups  

===============================================================================
🔹 LIMITATIONS OF ENUM
===============================================================================
❌ Values cannot be changed at runtime  
❌ No inheritance (cannot extend a class)  
❌ Cannot create object using new  
❌ Cannot have public constructors  

===============================================================================
🔹 IMPORTANT INTERVIEW QUESTIONS
===============================================================================

Q1️⃣ What is enum?
👉 A special class representing fixed constants.

------------------------------------

Q2️⃣ Can enum extend a class?
👉 ❌ No, because it implicitly extends java.lang.Enum.

------------------------------------

Q3️⃣ Can enum implement interfaces?
👉 ✔ Yes.

------------------------------------

Q4️⃣ Why is enum constructor private?
👉 To prevent creating new enum objects.

------------------------------------

Q5️⃣ Can enum have methods & variables?
👉 ✔ Yes.

------------------------------------

Q6️⃣ Can we use enum in switch?
👉 ✔ Yes.

------------------------------------

Q7️⃣ What is ordinal()?
👉 Returns index (0-based) of the enum constant.

------------------------------------

Q8️⃣ Can enum be generic?
👉 ❌ No.

------------------------------------

Q9️⃣ Can enum have abstract methods?
👉 ✔ Yes, and each constant must override it.

===============================================================================
🔹 TRICKY QUESTIONS
===============================================================================

⭐ Q1: Can enum have abstract methods?
👉 ✔ Yes, and each enum constant MUST implement it.

⭐ Q2: Can enum constants override methods?
👉 ✔ Yes, each constant can override behavior individually.

⭐ Q3: Can we compare enums with == ?
👉 ✔ Yes, safe and recommended, because enums are singleton objects.

⭐ Q4: Are enum constants threadsafe?
👉 ✔ Yes, because they are final and immutable.

⭐ Q5: Can you serialize an enum?
👉 ✔ Yes, enums handle serialization automatically.

===============================================================================
🔹 SPOKEN SUMMARY (FOR INTERVIEW)
===============================================================================

“An enum is a special class used to define constant values. It is type-safe,
fixed, and prevents invalid values. Enums can have fields, constructors, and
methods, and they extend java.lang.Enum automatically. They are commonly used
for statuses, categories, days, and directions. Enums improve readability,
safety, and maintainability.”

===============================================================================
*/
