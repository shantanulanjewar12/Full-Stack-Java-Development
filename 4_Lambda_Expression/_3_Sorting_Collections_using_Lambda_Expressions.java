import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * =================================================================================
 * TOPIC: Sorting Collections using Lambda Expressions (Comparator Interface)
 * =================================================================================
 *
 * THEORY:
 * 1. The Comparator Interface:
 * - To sort a list of custom objects (like the 'Data' class below), Java needs to know
 * the logic for comparing two objects.
 * - The 'java.util.Comparator<T>' interface is used for this purpose.
 * - It is a Functional Interface because it has one abstract method: 'int compare(T o1, T o2)'.
 *
 * 2. Lambda Benefit:
 * - Instead of creating a separate class that implements Comparator, or an anonymous inner class,
 * we can pass a Lambda expression directly to the sort method.
 */

// A simple POJO (Plain Old Java Object) class to represent data.
class Data {
    String name;

    public Data(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class _3_Sorting_Collections_using_Lambda_Expressions {
    public static void main(String[] args) {
        // STEP 1: Create and populate a List of Data objects.
        List<Data> list = new ArrayList<>();
        list.add(new Data("John"));
        list.add(new Data("Gia"));
        list.add(new Data("Chaand"));
        list.add(new Data("Pooja"));
        list.add(new Data("Ed"));

        /*
         * STEP 2: Sort the List using Lambda
         *
         * Method: Collections.sort(List<T> list, Comparator<? super T> c)
         *
         * SYNTAX BREAKDOWN:
         * (o1, o2) -> o1.getName().compareTo(o2.getName())
         *
         * 1. (o1, o2):
         * - These represent the two 'Data' objects being compared.
         * - We do NOT need to specify the type (e.g., (Data o1, Data o2)).
         * - Java's compiler uses "Type Inference" to know they are of type 'Data' because
         * 'list' is defined as List<Data>.
         *
         * 2. ->:
         * - The Lambda operator.
         *
         * 3. o1.getName().compareTo(o2.getName()):
         * - This is the body of the 'compare' method.
         * - We use the String class's 'compareTo' method.
         * - Logic:
         * - Returns negative if o1 < o2
         * - Returns zero if o1 == o2
         * - Returns positive if o1 > o2
         * - This results in natural alphabetical sorting (A-Z).
         */
        Collections.sort(list, (o1, o2) -> o1.getName().compareTo(o2.getName()));

        // STEP 3: Iterate and Print the sorted list
        // The list is now sorted: Chaand, Ed, Gia, John, Pooja
        for (Data temp : list) {
            System.out.println(temp);
        }
    }
}