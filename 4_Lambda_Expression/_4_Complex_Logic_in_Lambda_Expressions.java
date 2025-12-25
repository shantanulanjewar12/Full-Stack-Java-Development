import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * =================================================================================
 * TOPIC: Complex Logic in Lambda Expressions (Block Syntax with Return)
 * =================================================================================
 *
 * THEORY:
 * 1. Block Lambda Syntax:
 * - In the previous lecture, the lambda body was a single expression:
 * (o1, o2) -> o1.getName().compareTo(o2.getName())
 * In that case, the result of the expression is automatically returned, and curly braces {} are optional.
 *
 * - HOWEVER, if your logic is complex (e.g., involves if-else statements, loops, or multiple lines),
 * you MUST use curly braces { ... } to define a block.
 *
 * 2. The 'return' Keyword:
 * - IMPORTANT RULE: If you use curly braces {} in a lambda that is supposed to return a value
 * (like Comparator's compare method, which returns an int), you MUST explicitly use the 'return' keyword.
 * - In a single-line expression lambda without {}, 'return' is forbidden; it is implied.
 * - In a block lambda with {}, 'return' is mandatory for returning values.
 */

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

public class _4_Complex_Logic_in_Lambda_Expressions {
    public static void main(String[] args) {
        // STEP 1: Create a list of Data objects
        List<Data> list = new ArrayList<>();
        list.add(new Data("John"));
        list.add(new Data("Gia"));
        list.add(new Data("Chaand"));
        list.add(new Data("Pooja"));
        list.add(new Data("Ed"));

        // Previous approach (commented out):
        // Collections.sort(list, (o1, o2) -> o1.getName().compareTo(o2.getName()));

        /*
         * STEP 2: Sorting with Custom Logic (Sort by Name Length)
         *
         * Scenario: Instead of sorting alphabetically (A-Z), we want to sort by the
         * LENGTH of the name (shortest names first).
         *
         * Logic:
         * - If o1's length < o2's length -> Return -1 (o1 comes first)
         * - If o1's length > o2's length -> Return 1 (o2 comes first)
         * - If lengths are equal -> Return 0
         *
         * SYNTAX BREAKDOWN:
         * (o1, o2) -> { ... }
         *
         * 1. (o1, o2): Parameters inferred as 'Data' type.
         * 2. ->: Lambda operator.
         * 3. { ... }: Block body containing the if-else logic.
         */
        Collections.sort(list, (o1, o2) -> {
            // Because we are inside { }, we can write full Java logic.
            if (o1.getName().length() < o2.getName().length()) {
                return -1; // Explicit return required
            } else if (o1.getName().length() > o2.getName().length()) {
                return 1;  // Explicit return required
            } else {
                return 0;  // Explicit return required
            }
        });

        /*
         * STEP 3: Output the Sorted List
         *
         * Expected Order (by length):
         * 1. Ed (Length 2)
         * 2. Gia (Length 3)
         * 3. John (Length 4)
         * 4. Pooja (Length 5)
         * 5. Chaand (Length 6)
         * (Note: If lengths are equal, their relative order is preserved or arbitrary depending on the sort stability,
         * but here we have distinct lengths except for maybe 'John' vs others if we added more).
         */
        for (Data temp : list) {
            System.out.println(temp);
        }
    }
}