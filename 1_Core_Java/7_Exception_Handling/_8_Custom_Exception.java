/**
 * ============================================================
 * FILE NAME  : _8_Custom_Exception.java
 * PACKAGE    : ExceptionHandling
 * TOPIC      : Custom / User Defined Exceptions
 * ============================================================
 *
 * =========================
 * 1. WHAT IS CUSTOM EXCEPTION?
 * =========================
 * - Exception created by programmer
 * - Used to represent BUSINESS LOGIC ERRORS
 * - Makes code more readable and meaningful
 *
 * Example:
 * - AgeNotValidException
 * - InsufficientBalanceException
 * - InvalidUserException
 *
 * =========================
 * 2. WHY CUSTOM EXCEPTION?
 * =========================
 * - Built-in exceptions are generic
 * - Business rules need meaningful errors
 * - Improves debugging
 * - Improves maintainability
 *
 * =========================
 * 3. TYPES OF CUSTOM EXCEPTION
 * =========================
 * 1️⃣ Checked Custom Exception
 *    → Extend Exception
 *
 * 2️⃣ Unchecked Custom Exception
 *    → Extend RuntimeException
 *
 * =========================
 * 4. STEPS TO CREATE CUSTOM EXCEPTION
 * =========================
 * 1. Create a class
 * 2. Extend Exception / RuntimeException
 * 3. Create constructor
 * 4. Use super(message)
 *
 * ============================================================
 */

// ============================================================
// 1️⃣ CHECKED CUSTOM EXCEPTION
// ============================================================

class AgeNotValidException extends Exception {

    // Constructor
    public AgeNotValidException(String message) {
        super(message);
    }
}

// ============================================================
// 2️⃣ UNCHECKED CUSTOM EXCEPTION
// ============================================================

class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// ============================================================
// MAIN CLASS
// ============================================================

public class _8_Custom_Exception {

    public static void main(String[] args) {

        // -----------------------------
        // Checked Custom Exception Demo
        // -----------------------------
        try {
            validateAge(16);
        }
        catch (AgeNotValidException e) {
            System.out.println("Checked Exception Caught: " + e.getMessage());
        }

        System.out.println("--------------------------------");

        // -----------------------------
        // Unchecked Custom Exception Demo
        // -----------------------------
        withdrawAmount(1000, 5000); // will throw runtime exception
    }

    // Method throwing CHECKED custom exception
    static void validateAge(int age) throws AgeNotValidException {

        if (age < 18) {
            throw new AgeNotValidException("Age must be 18 or above");
        }

        System.out.println("Age is valid");
    }

    // Method throwing UNCHECKED custom exception
    static void withdrawAmount(int balance, int amount) {

        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        System.out.println("Withdrawal successful");
    }
}



/*
================================================================================

🎯 INTERVIEW QUESTIONS & ANSWERS

Q1: What is custom exception?
A: Exception created by programmer for business logic.

Q2: Why custom exception is required?
A: To represent meaningful business errors.

Q3: Difference between checked and unchecked custom exception?
A: Checked → compiler forces handling
Unchecked → compiler does not force handling

Q4: Can we create custom runtime exception?
A: ✔ Yes, by extending RuntimeException.

Q5 (TRICKY): Should custom exception extend Throwable?
A: ❌ No, extend Exception or RuntimeException.

Q6 (TRICKY): Can we throw custom exception without throws?
A: ✔ Yes, if it extends RuntimeException.

Q7: Real-world use cases?
A:
✔ Banking
✔ Authentication
✔ Validation
✔ E-commerce



*/