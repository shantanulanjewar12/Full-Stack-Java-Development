// ============================================================
// 🔹 _13_ImmutableClass.java
// ============================================================
// Topic: Immutable Class in Java
// ============================================================

import java.util.Date;

/*
===============================================================================
💡 EXAMPLE 1 — SIMPLE IMMUTABLE CLASS
===============================================================================
*/

final class Employee {

    private final int id;
    private final String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name; // String is immutable → safe
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee { id=" + id + ", name='" + name + "' }";
    }
}

/*
===============================================================================
💡 EXAMPLE 2 — IMMUTABLE CLASS WITH MUTABLE FIELD (IMPORTANT)
===============================================================================
*/

final class ImmutableStudent {

    private final String name;
    private final Date dob; // Date is mutable

    public ImmutableStudent(String name, Date dob) {
        this.name = name;
        this.dob = new Date(dob.getTime()); // defensive copy
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return new Date(dob.getTime()); // defensive copy
    }

    @Override
    public String toString() {
        return "ImmutableStudent { name='" + name + "', dob=" + dob + " }";
    }
}

/*
===============================================================================
🔹 MAIN CLASS — TESTING IMMUTABILITY
===============================================================================
*/

public class _13_ImmutableClass {

    public static void main(String[] args) {

        System.out.println("===== Basic Immutable Class =====");
        Employee emp = new Employee(1, "Shantanu");
        System.out.println(emp);

        System.out.println("\n===== Immutable Class with Mutable Field =====");

        Date d = new Date();
        ImmutableStudent s = new ImmutableStudent("Rahul", d);
        System.out.println(s);

        // Modify original date
        d.setTime(0);
        System.out.println("After modifying original Date = " + s);

        // Modify returned date
        Date returned = s.getDob();
        returned.setTime(0);
        System.out.println("After modifying returned Date = " + s);

        // Object remains unchanged ✔
    }
}
