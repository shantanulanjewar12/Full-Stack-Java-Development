/* 
================================================================================
📌 _3_EncapsulationUseCasesRealWorld.java
================================================================================

This file explains REAL-WORLD use cases of encapsulation with WHY, HOW, and EXAMPLES.

================================================================================
🔹 WHY Encapsulation is used in real applications?
--------------------------------------------------

Encapsulation is used when:

✔ Sensitive data must be protected
✔ A system must validate before updating values
✔ We don't want external components to modify internal logic
✔ Data flow must be controlled
✔ In large scalable systems where multiple modules interact safely

Examples:
- Banking system (balance, passwords)
- Healthcare (medical records)
- Gaming (player stats)
- Online shopping platforms
- Login/session systems

================================================================================
1️⃣ Banking Systems (MOST COMMON EXAMPLE)
-----------------------------------------

Problem:
Anybody should NOT be able to change account balance directly.

Solution:
Use private balance and allow access via deposit/withdraw methods only.

Example:
--------

*/

class BankAccount {

    private double balance;  // hidden sensitive data
    
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("💰 Deposited: " + amount);
        } else {
            System.out.println("❌ Invalid amount");
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("💸 Withdrawn: " + amount);
        } else {
            System.out.println("❌ Insufficient funds / invalid input");
        }
    }
}

/*
📝 WHY USED? 
👉 Prevents direct manipulation of bank balance and ensures control.

SHORT SUMMARY:
✔ Protects financial data and ensures secure transactions.

================================================================================
2️⃣ Healthcare (Patient Medical Records)
----------------------------------------

Patients cannot modify their age, health history, prescriptions, etc.
Only doctors or authorized systems can update it.

*/

class PatientRecord {

    // private String patientName;
    private String medicalHistory;

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void updateMedicalHistory(String newRecord, boolean isDoctor) {
        if(isDoctor) {
            this.medicalHistory = newRecord;
            System.out.println("🩺 Medical record updated.");
        } else {
            System.out.println("❌ Access Denied: Only doctors can update records.");
        }
    }
}

/*
📝 WHY USED?
👉 Protects private medical information and restricts modification.

SHORT SUMMARY:
✔ Ensures privacy and controlled data update in healthcare systems.

================================================================================
3️⃣ Gaming Systems (Player Stats)
---------------------------------

Players should NOT be able to manipulate their XP, score, or health directly 
because it causes cheating.

*/

class Player {

    private int health = 100;
    private int score = 0;

    public int getHealth() { return health; }
    public int getScore() { return score; }

    public void gainScore(int points) {
        score += Math.max(points, 0);
    }

    public void takeDamage(int damage) {
        health = Math.max(health - damage, 0);
    }
}

/*
📝 WHY USED?
👉 Prevents players from cheating by directly modifying internal values.

SHORT SUMMARY:
✔ Maintains fairness and game integrity.

================================================================================
4️⃣ E-Commerce Systems (Order & Price Control)
----------------------------------------------

Customers cannot set product price; only admin/system can.

*/

class Product {

    private double price;
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price, boolean isAdmin) {
        if(isAdmin) {
            this.price = price;
            System.out.println("🛒 Price updated: " + price);
        } else {
            System.out.println("❌ Only admin can change product price.");
        }
    }
}

/*
📝 WHY USED?
👉 Protects pricing logic and prevents manipulation.

SHORT SUMMARY:
✔ Secure price management and controlled access.

================================================================================
5️⃣ Authentication / Login System
---------------------------------

Passwords cannot be stored or accessed directly.

*/

class UserAccount {

    private String password;

    public void setPassword(String password) {
        this.password = encrypt(password);
    }

    public boolean login(String attempt) {
        return encrypt(attempt).equals(password);
    }

    private String encrypt(String input) {
        return "hash_" + input; // fake encryption for example
    }
}

/*
📝 WHY USED?
👉 Protects user credentials and security.

SHORT SUMMARY:
✔ Data protection in authentication systems.

================================================================================
🔥 Final Summary Notes (Write in Notebook)
------------------------------------------

✔ Encapsulation is used where data must be protected and controlled.
✔ Real-world systems like banking, healthcare, login systems, gaming, and e-commerce 
  use encapsulation to prevent unauthorized modifications.
✔ It ensures security, validation, consistency, and system reliability.

================================================================================
*/




// ============================================================================
// TEST CLASS
// ============================================================================
public class _3_EncapsulationUseCasesRealWorld {

    public static void main(String[] args) {

        System.out.println("===== Banking System Example =====");
        BankAccount acc = new BankAccount();
        acc.deposit(5000);
        acc.withdraw(1000);
        System.out.println("Current Balance: " + acc.getBalance());

        System.out.println("\n===== Healthcare Example =====");
        PatientRecord p = new PatientRecord();
        p.updateMedicalHistory("Diabetes patient", false); // unauthorized
        p.updateMedicalHistory("Updated record: Diabetes treatment ongoing.", true);

        System.out.println("\n===== Gaming System Example =====");
        Player player = new Player();
        player.takeDamage(30);
        player.gainScore(20);
        System.out.println("Health: " + player.getHealth() + ", Score: " + player.getScore());
    }
}
