/* 
================================================================================
📌 _2_EncapsulationInterviewQuestions.java
================================================================================

This file contains the MOST IMPORTANT Encapsulation Interview Questions with
real-world answers, examples, and simplified explanations.

================================================================================
1️⃣ What is Encapsulation? (MOST ASKED)
---------------------------------------

✔ Encapsulation means wrapping data (variables) and methods into a single class 
  and restricting direct access to data using private access modifiers.

➡ Simply put: DATA HIDING + CONTROLLED ACCESS.

Example:

    private int balance;  // hidden data
    public int getBalance() { return balance; } // controlled access

Real-Life Example:
- ATM: You see your balance, buttons & options, but banking logic and confidential 
  data are hidden inside → That is encapsulation.

Why asked?
- Checks if candidate knows the core OOP pillar.

Short Notebook Summary:
✔ Encapsulation = Data hiding + getters/setters + private variables.

================================================================================
2️⃣ Why do we use Encapsulation in Java?
----------------------------------------

We use encapsulation to:

✔ Protect data from unauthorized modification  
✔ Provide controlled access  
✔ Improve code security  
✔ Add validation before updating fields  
✔ Make code maintainable and scalable  

Example:

    public void setAge(int age) {
        if(age >= 0) this.age = age;
        else System.out.println("Invalid age");
    }

Short Summary:
✔ Encapsulation improves data protection, validation, and maintainability.

================================================================================
3️⃣ What is Data Hiding and how is it related to Encapsulation?
---------------------------------------------------------------

Data hiding means preventing direct access to class fields.

Encapsulation is the mechanism that IMPLEMENTS data hiding using:
- private variables
- getters
- setters

Example:
    obj.balance = -5000; // ❌ Not allowed (private)

Short Summary:
✔ Data hiding prevents direct access; encapsulation enforces it.

================================================================================
4️⃣ Why are variables private and methods public in encapsulation?
------------------------------------------------------------------

- Variables are private to secure and protect them.
- Methods (getters/setters) are public so the outside can safely read/update values.

This prevents misuse and allows validation.

Example:
    setSalary(100);  // allowed
    salary = 100;    // ❌ blocked

Short Summary:
✔ Private hides data, public methods control access.

================================================================================
5️⃣ Can we achieve encapsulation without getters and setters?
------------------------------------------------------------

YES — private variables alone hide data → BUT encapsulation is complete only when 
controlled access exists (setters/getters).

So in practice → Encapsulation usually involves both.

Short Summary:
✔ Technically yes, but complete encapsulation includes controlled access.

================================================================================
6️⃣ How is Encapsulation different from Abstraction?
----------------------------------------------------

| Feature         | Encapsulation                          | Abstraction                    |
|----------------|-----------------------------------------|--------------------------------|
| Purpose        | Protect data using access control       | Hide implementation complexity |
| Achieved Using | Private fields + Getters/Setters        | Abstract classes + Interfaces  |
| Focus          | HOW data is accessed                   | WHAT system does              |

Simple Example:

Abstraction → "Car starts"  
Encapsulation → Engine is private and protected

Short Summary:
✔ Abstraction hides complexity; encapsulation protects data.

================================================================================
7️⃣ Can Encapsulation exist without OOP?
----------------------------------------

YES — conceptually encapsulation exists in procedural programming (modules, files),
but object-oriented programming implements it BETTER using classes.

Short Summary:
✔ Yes, but OOP gives better structure and control.

================================================================================
8️⃣ What happens if we do NOT encapsulate data?
-----------------------------------------------

❌ Anyone can:

- Change variables directly
- Insert invalid/unsafe values
- Break business logic

Example:
    student.age = -10;  // makes no sense

Encapsulation prevents such scenarios.

Short Summary:
✔ Without encapsulation, data becomes unsafe and inconsistent.

================================================================================
9️⃣ Real-World Example of Encapsulation (Strong Answer)
-------------------------------------------------------

Example: **Medical Prescription System**

Patients cannot edit their medical records directly.
Only authorized doctors update them.
Patients can view them through a controlled interface.

➡ Data is protected → controlled access → encapsulation.

Short Summary:
✔ Real world uses encapsulation for privacy and security.

================================================================================
🔟 When should you use Encapsulation? (Advanced Practical Question)
-------------------------------------------------------------------

Use encapsulation when:

✔ Data must be protected  
✔ Validation is needed before update  
✔ You want to change the internal logic later without affecting other code  
✔ Working on real-world secure systems (banking, healthcare, payments, etc.)

Short Summary:
✔ Use encapsulation when safety, validation, and modularity matter.

================================================================================
*/

// ============================================================================
// Example Encapsulated Model for Real-World Use Case:
// ============================================================================
class Employee {
    
    private String name;  // hidden
    private double salary; // hidden

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty())
            System.out.println("❌ Invalid Name");
        else
            this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary < 0)
            System.out.println("❌ Salary can't be negative");
        else
            this.salary = salary;
    }
}


// ============================================================================
// TEST CLASS
// ============================================================================
public class _2_EncapsulationInterviewQuestions {

    public static void main(String[] args) {

        Employee emp = new Employee();

        emp.setName("Shantanu");
        emp.setSalary(45000);

        System.out.println("\n👤 Employee Name: " + emp.getName());
        System.out.println("💰 Salary: ₹" + emp.getSalary());
    }
}
