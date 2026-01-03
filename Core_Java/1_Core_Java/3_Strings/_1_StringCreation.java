
public class _1_StringCreation {
    public static void main(String[] args) {
        // Creating a String using string literal
        String str1 = "Hello, World!";
        System.out.println("String created using literal: " + str1);

        // Creating a String using the 'new' keyword
        String str2 = new String("Hello, Java!");
        System.out.println("String created using 'new' keyword: " + str2);

        // Creating a String from a character array
        char[] charArray = {'J', 'a', 'v', 'a', ' ', 'R', 'o', 'c', 'k', 's'};
        String str3 = new String(charArray);
        System.out.println("String created from character array: " + str3);

        // Creating a String from a byte array
        byte[] byteArray = {72, 101, 108, 108, 111};
        String str4 = new String(byteArray);
        System.out.println("String created from byte array: " + str4);
        
        // Creating a String using StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("Hello from StringBuilder!");
        String str5 = sb.toString();
        System.out.println("String created using StringBuilder: " + str5);

        // Creating a String using StringBuffer
        StringBuffer sbf = new StringBuffer();
        sbf.append("Hello from StringBuffer!");
        String str6 = sbf.toString();
        System.out.println("String created using StringBuffer: " + str6);

        // Creating an empty String
        String str7 = "";
        System.out.println("Empty String: '" + str7 + "'");

        // Creating a String using valueOf method
        int number = 123;
        String str8 = String.valueOf(number);
        System.out.println("String created using valueOf method: " + str8);

        // Creating a String using format method
        String str9 = String.format("Formatted number: %d", number);
        System.out.println(str9);

        // Creating a String using join method
        String str10 = String.join(", ", "Apple", "Banana", "Cherry");
        System.out.println("String created using join method: " + str10);

        // Creating a String using substring method
        String original = "Hello, World!";
        String str11 = original.substring(7, 12);
        System.out.println("String created using substring method: " + str11);

        // Creating a String using replace method
        String str12 = original.replace("World", "Java");
        System.out.println("String created using replace method: " + str12);

        // Creating a String using toLowerCase method
        String str13 = original.toLowerCase();
        System.out.println("String created using toLowerCase method: " + str13);

        // Creating a String using toUpperCase method
        String str14 = original.toUpperCase();
        System.out.println("String created using toUpperCase method: " + str14);

        // Creating a String using trim method
        String str15 = "   Hello, Trim!   ".trim();
        System.out.println("String created using trim method: '" + str15 + "'");

        // == and .equals() demonstration
        String a = "test";
        String b = new String("test");
        System.out.println("Using '==': " + (a == b)); // false, different references
        System.out.println("Using '.equals()': " + a.equals(b)); // true, same content

        // Heap menory vs String Constant Pool demonstration
        String s1 = "example"; // goes to String Constant Pool
        String s2 = "example"; // refers to the same object in String Constant Pool
        String s3 = new String("example"); // creates a new object in Heap memory
        System.out.println("s1 == s2: " + (s1 == s2)); // true
        System.out.println("s1 == s3: " + (s1 == s3)); // false
        


    }
}
