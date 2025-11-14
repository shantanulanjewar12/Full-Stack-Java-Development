/*
===============================================================================
💡 WHAT ARE ACCESS MODIFIERS?
===============================================================================
Access Modifiers in Java are **keywords** that define the **visibility / accessibility**
of classes, methods, variables, and constructors.

They control *who* can access which part of the code.

===============================================================================
🔹 TYPES OF ACCESS MODIFIERS IN JAVA
===============================================================================

1️⃣ public  
2️⃣ private  
3️⃣ protected  
4️⃣ default (no keyword)

===============================================================================
🔹 WHY ACCESS MODIFIERS ARE IMPORTANT?
===============================================================================
✔ Implement encapsulation  
✔ Improve security  
✔Prevent accidental misuse  
✔ Hide internal details from other classes  
✔ Improve clean code architecture  

===============================================================================
🔹 ACCESS CONTROL TABLE (VERY IMPORTANT)
===============================================================================

| Modifier   | Same Class | Same Package | Subclass | Different Package |
|-----------|------------|--------------|----------|-------------------|
| public    | ✔          | ✔            | ✔        | ✔                 |
| protected | ✔          | ✔            | ✔        | ❌ (except via inheritance) |
| default   | ✔          | ✔            | ❌        | ❌                 |
| private   | ✔          | ❌            | ❌        | ❌                 |

===============================================================================
*/

// ===========================
// EXAMPLES OF EACH MODIFIER
// ===========================

class AccessExample {

    public int publicVar = 10;         // accessible everywhere
    private int privateVar = 20;       // accessible only inside class
    protected int protectedVar = 30;   // accessible in same package + subclass
    int defaultVar = 40;               // default → same package only

    public void publicMethod() {
        System.out.println("Public Method");
    }

    private void privateMethod() {
        System.out.println("Private Method");
    }

    protected void protectedMethod() {
        System.out.println("Protected Method");
    }

    void defaultMethod() {
        System.out.println("Default Method");
    }
}

// ============================
// SUBCLASS IN SAME PACKAGE
// ============================
class SubClassSamePackage extends AccessExample {
    void test() {
        System.out.println(publicVar);      // ✔ allowed
        System.out.println(protectedVar);   // ✔ allowed
        System.out.println(defaultVar);     // ✔ allowed
        // System.out.println(privateVar);  // ❌ not allowed
    }
}

// ============================
// SUBCLASS IN DIFFERENT PACKAGE
// ============================


class SubClassDifferentPackage extends AccessExample {
    void test() {
        System.out.println(publicVar);      // ✔ allowed
        System.out.println(protectedVar);   // ✔ allowed (only via inheritance)
        // System.out.println(defaultVar);  // ❌ not allowed
        // System.out.println(privateVar);  // ❌ not allowed
    }
}

// ============================
// MAIN CLASS
// ============================
public class _7_AccessModifiers {
    public static void main(String[] args) {
        AccessExample obj = new AccessExample();

        System.out.println(obj.publicVar);      // ✔
        // System.out.println(obj.privateVar);  // ❌ not allowed
        System.out.println(obj.protectedVar);   // ✔ same package
        System.out.println(obj.defaultVar);     // ✔ same package

        obj.publicMethod();      // ✔
        obj.protectedMethod();   // ✔
        obj.defaultMethod();     // ✔
        // obj.privateMethod();  // ❌
    }
}

/*
===============================================================================
🔹 DETAIL OF EACH ACCESS MODIFIER
===============================================================================

1️⃣ PUBLIC
------------------------------------
✔ Accessible everywhere  
✔ Used for APIs, reusable functions  
✔ Best for classes meant to be used universally  

Example:
public class Student { }

Use Case:
- Public functions like main(), utility methods, constants  

Key Points:
- Least restrictive  
- Allows maximum access  

------------------------------------

2️⃣ PRIVATE
------------------------------------
✔ Highest protection level  
✔ Accessible only within same class  

Example:
private int age;

Use Case:
- Encapsulation  
- Sensitive data (password, accountBalance)  

Key Points:
- Must use getters/setters to access  

------------------------------------

3️⃣ PROTECTED
------------------------------------
✔ Accessible:
   - Same class  
   - Same package  
   - Subclasses (even different package)  

Example:
protected void show() { }

Use Case:
- OOP inheritance  
- When child should access but world should not  

Key Points:
- Cannot be accessed via object in another package  
- Only subclass can access through inheritance  

------------------------------------

4️⃣ DEFAULT (PACKAGE-PRIVATE)
------------------------------------
✔ No keyword  
✔ Accessible only within same package  

Example:
int rollNo;

Use Case:
- Grouping related classes  
- Package-based development  

Key Points:
- Not visible outside package  
- Common for backend layers  

===============================================================================
🔹 ADVANTAGES OF ACCESS MODIFIERS
===============================================================================
✔ Improve security  
✔ Prevent accidental misuse  
✔ Implement encapsulation  
✔ Cleaner architecture  
✔ Controlled visibility  

===============================================================================
🔹 MOST ASKED INTERVIEW QUESTIONS (with answers)
===============================================================================

Q1️⃣: What is the difference between private and protected?
👉 Private → only in same class  
👉 Protected → same class + same package + subclass in different package  

------------------------------------

Q2️⃣: Can a top-level class be private?
👉 ❌ No.  
Only public or default allowed.  

------------------------------------

Q3️⃣: What is default access modifier?
👉 Package-private → accessible only within same package.

------------------------------------

Q4️⃣: Can protected members be accessed without inheritance?
👉 ✔ Yes, **if in same package**  
👉 ❌ No, if in different package  

------------------------------------

Q5️⃣: Which modifier gives maximum security?
👉 private  

------------------------------------

Q6️⃣: Can we access private members in subclass?
👉 ❌ No, private is class-level only.  

------------------------------------

Q7️⃣: Why main() method is public?
👉 Because JVM must access it from outside the class.  

------------------------------------

Q8️⃣: Can constructors be private?
👉 ✔ Yes (Singleton pattern).  

------------------------------------

Q9️⃣: Which modifiers can be applied to a class?
👉 public, default  
Not: private, protected  

------------------------------------

Q🔟: Difference between public class and default class?
👉 public → accessible everywhere  
👉 default → only same package  

===============================================================================
🔹 TRICKY INTERVIEW QUESTIONS (VERY IMPORTANT)
===============================================================================

⭐ Q1: Can protected members be accessed through object in different package?
❌ No.  
✔ Only through inheritance reference:  
   `SubClass obj = new SubClass(); obj.protectedVar;`  

------------------------------------

⭐ Q2: If a subclass is in different package, can it access default members?
❌ No. Default works only within same package.  

------------------------------------

⭐ Q3: Can we override a method and reduce its visibility?
❌ No.  
You can only increase visibility, not reduce it.  
Example:  
protected → public ✔  
public → protected ❌  

------------------------------------

⭐ Q4: Can private methods be inherited?
❌ No, but they can exist in memory (not accessible).  

------------------------------------

⭐ Q5: If class is default and method is public, can method be accessed outside package?
❌ No. Class itself is not visible outside package.

------------------------------------

⭐ Q6: Can variables be public?
✔ Yes, but not recommended (breaks encapsulation).  

------------------------------------

⭐ Q7: Can an interface have private methods?
✔ From Java 9 onwards → private methods allowed.  

===============================================================================
🔹 INTERVIEW SUMMARY (SPOKEN VERSION)
===============================================================================
“In Java, access modifiers define the scope and visibility of classes, methods, 
and variables. Java provides four modifiers — public, private, protected, and 
default. Public gives full access, private gives class-level access, protected 
gives access to same package and subclasses, and default gives package-level 
access. They help implement encapsulation and control access properly.”

===============================================================================
*/
