/* 
================================================================================
📌 _1_EncapsulationBasics.java
================================================================================

💡 What is Encapsulation?
-------------------------
Encapsulation is the concept of wrapping (binding) data (variables) and methods 
(behaviour) into a single unit (Class) and restricting direct access to that data.

➡ Encapsulation = Data Hiding + Controlled Access (via methods)

================================================================================
🎯 WHY Encapsulation?
----------------------
- To protect sensitive data
- To control read/write access
- To validate inputs before assigning values
- To increase security & maintain clean code

================================================================================
🔹 Key Concepts:
----------------

1️⃣ **Private Variables**
   - Data (fields) must be private so no one can modify directly.

2️⃣ **Getters**
   - Public method that returns_private data.

3️⃣ **Setters**
   - Public method that updates_private data.
   - Validation logic can be added here.

4️⃣ **Data Hiding**
   - Prevents direct access to sensitive values.
   - Only getters/setters expose data safely.

5️⃣ **Access Modifiers Role in Encapsulation:**
   - private   → Data hidden from outside
   - public    → Getters/Setters accessible everywhere
   - protected/default → Rarely used in strict encapsulation

================================================================================
🔹 RULES of Encapsulation:
--------------------------
✔ Make variables private.
✔ Give public getters to read values.
✔ Give public setters to modify values.
✔ Validate input inside setters.
✔ State changes should only happen via setters (not directly).

================================================================================
Encapsulation vs Abstraction (Short Notes)
------------------------------------------
| Feature        | Encapsulation                       | Abstraction                   |
|----------------|--------------------------------------|-------------------------------|
| Purpose        | Protect data and control access      | Hide internal implementation  |
| Achieved Using | Private fields + getters/setters     | Abstract classes & interfaces |
| Focus          | HOW data is accessed                | WHAT functionalities exist    |

================================================================================
Advantages:
-----------
✔ Security
✔ Validation Control
✔ Cleaner Code (OOP Standard)
✔ Loose Coupling
✔ Better Maintainability

Disadvantages:
--------------
✖ More boilerplate code (getters/setters)
✖ Overusing setters may reduce security if not designed properly

================================================================================
📝 2–3 Line Summary for Notebook:
---------------------------------
✔ Encapsulation binds data and methods and hides sensitive data using private variables.  
✔ Access is controlled using getters and setters with validation.  
✔ It improves data protection, maintainability, and coding standards.

================================================================================
*/

class BankAccount {

    // 1️⃣ Private Data Members → Data Hidden
    private String accountHolder;
    private double balance;

    // 2️⃣ Getter → Used to READ private data
    public String getAccountHolder() {
        return accountHolder;
    }

    // 3️⃣ Setter → Used to MODIFY private data (with validation)
    public void setAccountHolder(String accountHolder) {
        if(accountHolder == null || accountHolder.trim().isEmpty()) {
            System.out.println("❌ Invalid Name!");
        } else {
            this.accountHolder = accountHolder;
        }
    }

    // Getter for balance (READ only)
    public double getBalance() {
        return balance;
    }

    // Setter for depositing amount with validation
    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("💰 Amount Deposited Successfully!");
        } else {
            System.out.println("❌ Deposit Amount Must Be Positive");
        }
    }

    // Withdraw method with validation
    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("💸 Withdrawal Successful!");
        } else {
            System.out.println("❌ Insufficient balance or invalid amount.");
        }
    }
}


// ============================================================================
// MAIN CLASS TO TEST ENCAPSULATION
// ============================================================================
public class _1_EncapsulationBasics {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();  // Object Created

        // Setting values using setter (not directly)
        account.setAccountHolder("Shantanu Lanjewar");
        account.deposit(5000);
        account.withdraw(1200);

        // Accessing values using getter
        System.out.println("\n📌 Account Holder: " + account.getAccountHolder());
        System.out.println("📌 Current Balance: ₹" + account.getBalance());
    }
}
