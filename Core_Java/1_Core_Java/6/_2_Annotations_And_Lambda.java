import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/*
================================================================================
                            ANNOTATIONS IN JAVA
================================================================================

🔹 What is Annotation?
--------------------------------
- Annotation is a way to add META-DATA to Java code.
- Meta-data means "data about data".
- It does NOT change program execution directly.
- Its usage is OPTIONAL.
- Can be read at compile time or runtime using Reflection.

--------------------------------
Where annotations can be used?
--------------------------------
✔ Class
✔ Interface
✔ Method
✔ Constructor
✔ Field
✔ Parameter
✔ Local Variable
✔ Package

--------------------------------
Types of Annotations
--------------------------------
1️⃣ Predefined Annotations
   - @Override
   - @Deprecated
   - @SuppressWarnings
   - @FunctionalInterface
   - @SafeVarargs

2️⃣ Meta-Annotations (Used on Annotations)
   - @Target
   - @Retention
   - @Documented
   - @Inherited
   - @Repeatable

3️⃣ Custom (User Defined) Annotations

================================================================================
*/


// ===============================
// FUNCTIONAL INTERFACE
// ===============================
@FunctionalInterface
interface Calculator {

    int add(int a, int b);

    // ❌ If we add another abstract method → compilation error
    // int sub(int a, int b);
}


/*
================================================================================
                            LAMBDA EXPRESSION
================================================================================

🔹 What is Lambda Expression?
--------------------------------
- Lambda provides implementation of Functional Interface.
- Introduced in Java 8.
- Reduces boilerplate code.
- Works ONLY with Functional Interface.

Syntax:
(parameters) -> expression
(parameters) -> { statements }

================================================================================
*/

class LambdaDemo {

    public static void main(String[] args) {

        // Lambda implementation
        Calculator calc = (a, b) -> a + b;

        // Java does NOT support named arguments
        System.out.println("Sum = " + calc.add(10, 20));
    }
}


/*
================================================================================
                            @Override
================================================================================
- Checks at compile time that method is actually overridden.
- Prevents logical errors.
- Used ONLY on methods.
================================================================================
*/

interface Bird {
    void fly();
}

class Eagle implements Bird {

    @Override
    public void fly() {
        System.out.println("Eagle is flying");
    }
}


/*
================================================================================
                            @Deprecated
================================================================================
- Marks class/method/field as outdated.
- Compiler gives WARNING.
- Suggests using a better alternative.
================================================================================
*/

class Mobile {

    @Deprecated
    public void oldFeature() {
        System.out.println("Old feature (Deprecated)");
    }

    public void newFeature() {
        System.out.println("New feature");
    }
}


/*
================================================================================
                            @SuppressWarnings
================================================================================
- Tells compiler to ignore specific warnings.
- Use carefully.
================================================================================
*/

class SuppressWarningDemo {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Mobile m = new Mobile();
        m.oldFeature(); // no warning now
    }
    
    //unused method to demonstrate suppression
    //definaton - keeps compiler from warning about unused methods
    //example - private methods that are not used within the class 
    @SuppressWarnings("unused")
    private void unusedMethod() {
        System.out.println("This method is unused");
    }

    //unchecked warning suppression
    @SuppressWarnings("unchecked")
    public void uncheckedDemo() {
        List list = new ArrayList(); // raw type
        list.add("Hello");
        List<String> strList = list; // unchecked conversion
    }

    //all warnings suppression
    @SuppressWarnings("all")
    public void allWarningsDemo() {
        List list = new ArrayList(); // raw type
        list.add("Hello");
        List<String> strList = list; // unchecked conversion
    }
}




/*
================================================================================
                            @SafeVarargs
================================================================================
- Used to suppress "Heap Pollution" warning.
- Can be applied only to:
   ✔ static
   ✔ final
   ✔ private methods
- Works with varargs of generic types.
- Helps ensure type safety.
- Allows safe use of generic varargs without warnings.
- Introduced in Java 7.
- Used when method accepts variable number of arguments of generic type.
- Prevents potential runtime exceptions due to type mismatches.
- Defination of Heap Pollution:
   ✔ When a variable of a parameterized type refers to an object that is not
     of that parameterized type.
- Definition of Varargs:
   ✔ Allows passing variable number of arguments to a method.
- Definition of @SafeVarargs:
   ✔ Annotation to indicate that a method with varargs is safe from heap
     pollution issues.
     In other words, it tells the compiler that the method does not
        perform unsafe operations on its varargs parameter.
================================================================================
*/

class SafeVarArgsDemo {

    @SafeVarargs
    public static void printNumbers(List<Integer>... lists) {
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);

        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);

        printNumbers(l1, l2);
    }
}
// Explanation:
// In the above example, the method printNumbers accepts a variable number 
// of List<Integer> arguments. By annotating it with @SafeVarargs, we inform 
// the compiler that this method is safe from heap pollution issues, allowing us 
// to avoid warnings related to generic varargs usage

// What is unsafe from heap pollution issues?
// Unsafe operations would include modifying the varargs array in a way that 
// could lead to type mismatches, such as adding elements of the wrong type 
// to the lists. In this case, since we are only reading from the lists and
// not modifying them, it is safe to use @SafeVarargs.

// How will be unsafe from heap pollution issues for this code?
// If we were to add elements of a different type to the lists or perform
// operations that could lead to type mismatches, it would be considered 
// unsafe and could lead to heap pollution issues.



/*
================================================================================
                            CUSTOM ANNOTATION
================================================================================
*/

// Meta-annotations
// (1) @Target - where annotation can be applied
// (2) @Retention - how long annotation is retained
// What does it do?
// - SOURCE  → discarded at compile time
// - CLASS   → present in .class file
// - RUNTIME → available via Reflection

// Other meta-annotations:
// (3) @Documented - included in Javadoc
// (4) @Inherited - inherited by subclasses
// (5) @Repeatable - can be applied multiple times

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyCustomAnnotation {
    String author();
    int version();
}


class AnnotationTest {

    @MyCustomAnnotation(author = "Shantanu", version = 1)
    public void demoMethod() {
        System.out.println("Demo Method Executed");
    }
}


/*
================================================================================
                        READING ANNOTATION USING REFLECTION
================================================================================
*/

class ReflectionDemo {

    public static void main(String[] args) throws Exception {

        Method method = AnnotationTest.class.getMethod("demoMethod");

        MyCustomAnnotation annotation =
                method.getAnnotation(MyCustomAnnotation.class);

        System.out.println("Author : " + annotation.author());
        System.out.println("Version: " + annotation.version());
    }
}


/*
================================================================================
                            INTERVIEW QUESTIONS
================================================================================

Q1. What is Annotation?
👉 Annotation is meta-data added to Java code which can be processed at compile
   time or runtime.

--------------------------------

Q2. Does annotation affect execution?
👉 No, unless explicitly processed (e.g. via Reflection or frameworks).

--------------------------------

Q3. Difference between @Override and method overriding?
👉 @Override is optional but ensures correctness at compile time.

--------------------------------

Q4. What is Functional Interface?
👉 Interface with exactly ONE abstract method.

--------------------------------

Q5. Can Functional Interface have default methods?
👉 Yes.

--------------------------------

Q6. Why @SafeVarargs is needed?
👉 To suppress heap pollution warning in generic varargs.

--------------------------------

Q7. Where @SafeVarargs can be used?
👉 static, final, private methods and constructors.

--------------------------------

Q8. Difference between SOURCE, CLASS, RUNTIME retention?
👉 SOURCE  → discarded at compile time  
👉 CLASS   → present in .class file  
👉 RUNTIME → available via Reflection

--------------------------------

Q9. Can we create custom annotation?
👉 Yes, using @interface keyword.

--------------------------------

Q10. Why annotations are heavily used in Spring?
👉 For dependency injection, configuration, AOP, validation.

================================================================================


================================================================================
//Tree Diagram of Annotations in Java
// ================================================================================
                Annotations in Java
                        |
    ---------------------------------------
    |                  |                  |
Predefined       Meta-Annotations     Custom Annotations
    |                  |                  |
    |                  |                  |
----------------   ----------------   ----------------
|      |      |   |      |      |   |                  |
|      |      |   |      |      |   |                  |
@Override  @Target  @Retention  @Documented   User-defined
|      |      |   |      |      |   |                  |
@Deprecated  @Inherited  @Repeatable




*/
