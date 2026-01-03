/*
===============================================================================
💡 WHAT ARE NAMING CONVENTIONS?
===============================================================================
👉 Definition:
Naming conventions are standard **rules for naming classes, methods, variables,
packages, interfaces, enums, and constants** in Java.

👉 Purpose:
- Improve readability
- Maintain consistency
- Make code professional & understandable
- Help in teamwork and debugging

===============================================================================
🔹 TYPES OF NAMING CONVENTIONS
===============================================================================

1️⃣ PascalCase (Upper Camel Case)
   - Each word starts with a capital letter.
   - Example: StudentDetails, EmployeeRecord

2️⃣ camelCase (Lower Camel Case)
   - First word lowercase, next words Capital.
   - Example: studentName, calculateMarks()

3️⃣ UPPERCASE_SNAKE_CASE
   - All uppercase with underscore.
   - Example: MAX_VALUE, DATABASE_URL

4️⃣ lowercase
   - All small letters.
   - Example: com.example.project

===============================================================================
🔹 WHERE EACH NAMING CONVENTION IS USED (VERY IMPORTANT)
===============================================================================

| Component     | Naming Convention   | Example                       |
|---------------|---------------------|-------------------------------|
| Class         | PascalCase          | StudentDetails                |
| Interface     | PascalCase          | Runnable, Serializable        |
| Constructor   | PascalCase          | StudentDetails()              |
| Variable      | camelCase           | studentAge, totalMarks        |
| Method        | camelCase           | calculateSalary(), getName()  |
| Constant      | UPPERCASE_SNAKE_CASE| MAX_VALUE, BASE_URL           |
| Package       | lowercase           | com.tech.ecrop                |
| Enum          | PascalCase          | Direction, Status             |
| Enum Values   | UPPERCASE           | NORTH, SOUTH                  |

===============================================================================
🔹 EXAMPLES FOR EACH NAMING CONVENTION
===============================================================================
*/

// // Package name → lowercase
// package com.example.namingconvention;

// Class name → PascalCase
class StudentDetails {

    // Variable → camelCase
    String studentName;
    int studentAge;

    // Constant → UPPERCASE_SNAKE_CASE
    static final int MAX_MARKS = 100;

    // Constructor → PascalCase (same as class name)
    StudentDetails(String name, int age) {
        this.studentName = name;
        this.studentAge = age;
    }

    // Method → camelCase
    void calculatePercentage() {
        System.out.println("Calculating percentage...");
    }
}

// Interface name → PascalCase
interface Vehicle {
    void startEngine();   // Method → camelCase
}

// Enum name → PascalCase, Enum values → UPPERCASE
enum Direction {
    NORTH, SOUTH, EAST, WEST
}

public class _6_NamingConventions {
    public static void main(String[] args) {
        System.out.println("Java Naming Conventions Successfully Explained!");

        StudentDetails s1 = new StudentDetails("Shantanu", 22);
        s1.calculatePercentage();
    }
}

/*
===============================================================================
🔹 INTERVIEW SUMMARY (SPEAKING POINTS)
===============================================================================
👉 Naming conventions improve readability and consistency.
👉 Classes, Interfaces, Enums follow PascalCase.
👉 Methods and Variables follow camelCase.
👉 Constants follow UPPERCASE_SNAKE_CASE.
👉 Packages follow lowercase only.
👉 Constructor uses PascalCase because it must match class name.

===============================================================================
🔹 BONUS INTERVIEW QUESTIONS
===============================================================================
Q1: Are naming conventions mandatory?
A: Not enforced by compiler, but strongly recommended for clean code.

Q2: Why constants use uppercase?
A: To make them easily identifiable and distinguishable from variables.

Q3: Why class names start with capital?
A: They represent real-world entities (nouns).

===============================================================================
*/
