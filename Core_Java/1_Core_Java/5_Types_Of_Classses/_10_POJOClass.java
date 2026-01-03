// ============================================================
// 🔹 _10_POJOClass.java
// ============================================================
// Topic: POJO (Plain Old Java Object)
// Author: Shantanu Lanjewar
// ============================================================

/*
===============================================================================
💡 WHAT IS A POJO?
===============================================================================
POJO stands for **Plain Old Java Object**.

It is a simple Java class that:
✔ Contains variables (fields)  
✔ Contains getters & setters  
✔ Contains constructors  
✔ Contains no business logic  
✔ NOT bound to any special framework  

POJO is mainly used for:
✔ Carrying data  
✔ Object representation  
✔ Mapping data in database / API responses  

===============================================================================
💡 WHY USE POJO?
===============================================================================
✔ To represent data in a clean, simple object  
✔ Easy to serialize/deserialize (JSON/XML)  
✔ Used in Hibernate, Spring, REST APIs, Collections  
✔ Reduces complexity → just a simple container for values  

===============================================================================
🔹 CHARACTERISTICS / RULES OF POJO (VERY IMPORTANT)
===============================================================================
1️⃣ Simple class with private variables  
2️⃣ Public getters & setters  
3️⃣ Must NOT extend framework-specific classes  
4️⃣ Must NOT implement special interfaces like Serializable (not compulsory)  
5️⃣ Should NOT contain business logic  

NOTE:  
✔ A POJO *can* be empty.  
✔ A POJO *can* have constructors.  
✔ A POJO is NOT required to be Serializable, but JavaBeans must be.  

===============================================================================
🔹 EXAMPLE 1 — SIMPLE POJO CLASS
===============================================================================
*/

class StudentPOJO {

    private int id;
    private String name;
    private int age;

    // Default constructor
    public StudentPOJO() { }

    // Parameterized constructor
    public StudentPOJO(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getter methods
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    // Setter methods
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "StudentPOJO { id=" + id + ", name=" + name + ", age=" + age + " }";
    }
}

/*
===============================================================================
🔹 EXAMPLE 2 — IMMUTABLE POJO CLASS
    Immutable means values cannot be changed once object is created.
===============================================================================
*/

final class ImmutableUser {

    private final String username;
    private final int age;

    public ImmutableUser(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() { return username; }
    public int getAge() { return age; }

    // No setter → cannot modify values!
}

/*
===============================================================================
🔹 EXAMPLE 3 — POJO USED IN REAL WORLD (API Response Model)
===============================================================================
*/

class ProductPOJO {

    private String productName;
    private double price;

    public ProductPOJO(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    // Getters & Setters
    public String getProductName() { return productName; }
    public double getPrice() { return price; }

    public void setProductName(String productName) { this.productName = productName; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "ProductPOJO { productName=" + productName + ", price=" + price + " }";
    }
}

/*
===============================================================================
🔹 MAIN CLASS – DEMONSTRATION
===============================================================================
*/

public class _10_POJOClass {
    public static void main(String[] args) {

        System.out.println("===== SIMPLE POJO EXAMPLE =====");
        StudentPOJO s = new StudentPOJO(1, "Shantanu", 21);
        System.out.println(s);

        System.out.println("\n===== IMMUTABLE POJO EXAMPLE =====");
        ImmutableUser user = new ImmutableUser("john_doe", 25);
        System.out.println("User: " + user.getUsername() + ", Age: " + user.getAge());

        System.out.println("\n===== REAL WORLD POJO (Product) =====");
        ProductPOJO p = new ProductPOJO("Laptop", 55000.50);
        System.out.println(p);

        p.setPrice(53000.00);  // POJO values can be updated
        System.out.println("Updated Product: " + p);
    }
}

/*
===============================================================================
🔹 POJO vs JavaBean (INTERVIEW MUST)
===============================================================================

| Feature | POJO | JavaBean |
|---------|-------|-----------|
| Getters/Setters | Optional | Required |
| Serializable | Optional | Must implement Serializable |
| Constructor | Any | Must have no-arg constructor |
| Naming conventions | Flexible | Must follow JavaBean naming rules |
| Framework dependency | None | Often used for frameworks |

➡ All JavaBeans are POJOs  
❌ Not all POJOs are JavaBeans

===============================================================================
🔹 ADVANTAGES OF POJO
===============================================================================
✔ Simple to create and read  
✔ Reusable data format  
✔ Works everywhere → database, API, UI  
✔ Easily serialized  
✔ Decouples business logic from data  

===============================================================================
🔹 LIMITATIONS
===============================================================================
❌ Only stores data → no business logic  
❌ Too many getters/setters can make class heavy  
❌ Sometimes unclear separation of data vs. behavior  

===============================================================================
🔹 INTERVIEW QUESTIONS (WITH ANSWERS)
===============================================================================

Q1️⃣ What is a POJO class?  
👉 A simple Java object containing fields, constructors, getters, and setters.

------------------------------------

Q2️⃣ Why POJOs are used?  
👉 To represent data in Java applications (API, DB mapping, services).

------------------------------------

Q3️⃣ Is POJO required to be Serializable?  
👉 ❌ No. That's only required for JavaBeans.

------------------------------------

Q4️⃣ Does POJO require getters and setters?  
👉 No, but recommended.

------------------------------------

Q5️⃣ Can POJO have business logic?  
👉 ❌ Ideally no — POJO should only store data.

------------------------------------

Q6️⃣ Can POJO extend class or implement interface?  
👉 ✔ Yes, as long as it’s not tied to framework logic.

------------------------------------

Q7️⃣ What is the difference between POJO and DTO?  
👉 DTO is a stricter POJO used specifically for data transfer.

------------------------------------

Q8️⃣ Is POJO thread-safe?  
👉 ❌ No, unless immutable or synchronized.

===============================================================================
🔹 TRICKY QUESTIONS
===============================================================================

⭐ Q1: Why POJO classes must have private variables?  
👉 To follow encapsulation and provide controlled access.

⭐ Q2: Can we create immutable POJO?  
👉 ✔ Yes (use final fields + no setters).

⭐ Q3: Can POJO contain static fields?  
👉 ✔ Yes, no restriction.

⭐ Q4: Are POJOs mandatory in Hibernate / JPA?  
👉 ✔ Yes, entities are POJOs.

⭐ Q5: Can POJO have overloaded constructors?  
👉 ✔ Yes.

===============================================================================
🔹 SPOKEN SUMMARY (FOR INTERVIEW)
===============================================================================

“A POJO is a Plain Old Java Object used to represent data. It contains fields,
constructors, and getters/setters, and no business logic. POJOs are framework-
independent and help in clean data modelling. They are used extensively in
APIs, databases, serialization, and ORM frameworks.”

===============================================================================
*/
