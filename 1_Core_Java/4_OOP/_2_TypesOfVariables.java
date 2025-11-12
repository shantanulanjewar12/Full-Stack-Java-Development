public class _2_TypesOfVariables {

    // 🔹 Instance Variable
    // Defined inside the class but outside any method.
    // Each object of this class gets its own copy.
    int instanceVar; // Default value = 0 (if not initialized)

    // 🔹 Static Variable
    // Declared using 'static' keyword.
    // Shared among all objects of the class (common memory).
    static int staticVar = 100;

    public static void main(String[] args) {

        // ============================================================
        // 🔸 LOCAL VARIABLE
        // ============================================================
        // → Declared inside a method, constructor, or block.
        // → Scope: Only within this main() method.
        // → Must be initialized before use (no default value).
        int localVar = 10;
        System.out.println("🔹 Local Variable Value: " + localVar);
        System.out.println("   ↳ Scope: Only inside main() method");
        System.out.println("   ↳ Lifetime: Ends when method finishes\n");

        // ============================================================
        // 🔸 INSTANCE VARIABLE
        // ============================================================
        _2_TypesOfVariables obj1 = new _2_TypesOfVariables();
        _2_TypesOfVariables obj2 = new _2_TypesOfVariables();

        // Assigning different values for different objects
        obj1.instanceVar = 20;
        obj2.instanceVar = 40;

        System.out.println("🔹 Instance Variable (obj1): " + obj1.instanceVar);
        System.out.println("🔹 Instance Variable (obj2): " + obj2.instanceVar);
        System.out.println("   ↳ Scope: Inside the class (accessible via object)");
        System.out.println("   ↳ Lifetime: Exists till the object is alive\n");

        // ============================================================
        // 🔸 STATIC VARIABLE
        // ============================================================
        // Can be accessed directly (without object) using class name
        System.out.println("🔹 Static Variable (via class): " + _2_TypesOfVariables.staticVar);

        // Also accessible via object, but not recommended
        obj1.staticVar = 200;
        System.out.println("🔹 Static Variable (after change via obj1): " + staticVar);
        System.out.println("   ↳ Shared among all objects (common memory)");
        System.out.println("   ↳ Lifetime: Exists till program ends (class unloaded)");
    }
}



/*

                 +----------------------------------------------+
         |              💾 JVM MEMORY MODEL              |
         +----------------------------------------------+
         |                                              |
         |   🧮 STACK MEMORY (method execution area)     |
         |   ---------------------------------------     |
         |   Method: main()                              |
         |     ├── localVar = 10                         | ← Local Variable
         |     ├── obj1 (reference → object in heap)     |
         |     └── obj2 (reference → object in heap)     |
         |                                              |
         +----------------------------------------------+
         |                                              |
         |   🧱 HEAP MEMORY (object storage area)        |
         |   ---------------------------------------     |
         |   Object 1 (obj1):                            |
         |     └── instanceVar = 20                      | ← Instance Variable
         |   Object 2 (obj2):                            |
         |     └── instanceVar = 40                      | ← Instance Variable
         |                                              |
         +----------------------------------------------+
         |                                              |
         |   🏛 CLASS / METHOD AREA (common memory)      |
         |   ---------------------------------------     |
         |   Class: _2_TypesOfVariables                  |
         |     └── staticVar = 200                       | ← Static Variable
         |                                              |
         +----------------------------------------------+


 */

/*
   (1) Local Variable (localVar)

Created when the method is called.
Stored in Stack Memory.
Destroyed when the method exits.
Each method call gets its own copy.
❌ No default value — must be initialized.

(2)Instance Variable (instanceVar)

Belongs to an object, not the class.
Stored in Heap Memory.
Each object has its own independent value.
✅ Gets default values (e.g., 0, null, false).
Accessed via object reference (obj.instanceVar).

(3)Static Variable (staticVar)

Belongs to the class, not any instance.
Stored in Method Area (Class Area).
Shared among all objects.
✅ Gets default values.
Accessed via class name (ClassName.staticVar).
 */