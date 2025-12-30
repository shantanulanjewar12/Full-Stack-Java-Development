
public class IntelliJ_Debugger_And_Shortcuts {

    /*
    ===============================================================================
     1. INTRODUCTION TO IntelliJ IDEA Debugger
    ===============================================================================
    
    • IntelliJ IDEA is a powerful IDE used for Java development. :contentReference[oaicite:1]{index=1}
    • The Debugger helps you inspect the state of your program while it executes:
      – Pause execution at breakpoints
      – Step through code line by line
      – Inspect variable values and evaluate expressions
      – Diagnose and fix bugs interactively. :contentReference[oaicite:2]{index=2}

    The Debugger enables deeper insight than simply printing to the console.
    It brings you *inside* the execution flow.

    ===============================================================================
     2. BASIC DEBUGGING WORKFLOW (STEP-BY-STEP)
    ===============================================================================
    
     Step 1 — Set a Breakpoint:
     • Click in the editor gutter (left of line numbers) to toggle a breakpoint.
     • A red dot indicates the breakpoint. :contentReference[oaicite:3]{index=3}

     Step 2 — Start Debugging:
     • Right-click your class or main() method → “Debug”.
     • Or click the green bug icon in the toolbar.
     • The program starts in Debug mode and stops at the breakpoint. :contentReference[oaicite:4]{index=4}

     Step 3 — Debug Tool Window:
     • When paused, the Debug tool window opens.
     • You see the current stack, variables, watches, and more. :contentReference[oaicite:5]{index=5}

     Step 4 — Inspect Variables:
     • Hover over variables to see their current value.
     • The “Variables” panel shows local variables. :contentReference[oaicite:6]{index=6}

     Step 5 — Step Through Code:
     • Use stepping controls to navigate execution. :contentReference[oaicite:7]{index=7}

     Step 6 — Fix Bugs:
     • Pause and inspect where your logic behaves unexpectedly.
     • Make code edits and rerun/debug if needed.

    ===============================================================================
     3. STEPPING ACTIONS & MEANING
    ===============================================================================
    
     • Step Over (F8): Execute current line, stop at next line.
       Useful when you *don’t* want to enter methods. :contentReference[oaicite:8]{index=8}

     • Step Into (F7): Enter inside the method call on current line.
       Useful to inspect method logic. :contentReference[oaicite:9]{index=9}

     • Step Out (Shift + F8): Finish current method and return to caller. :contentReference[oaicite:10]{index=10}

     • Resume Program (F9): Continue execution until next breakpoint or end. :contentReference[oaicite:11]{index=11}

     • Smart Step Into (Shift + F7): Choose which method to enter when
       multiple calls exist on one line. :contentReference[oaicite:12]{index=12}

     • Run to Cursor (Alt + F9): Jump to a specific line and pause there. :contentReference[oaicite:13]{index=13}

    ===============================================================================
     4. BREAKPOINT TYPES & ADVANCED OPTIONS
    ===============================================================================
    
     Standard Breakpoint:
     • Pause program execution when reached.

     Conditional Breakpoint:
     • Only pause when a condition is true (e.g., i == 10). :contentReference[oaicite:14]{index=14}

     Log Breakpoint:
     • Instead of stopping, log a message when hit.

     Exception Breakpoint:
     • Break when a specific exception is thrown.

     Non-suspending Breakpoint:
     • Log info or evaluate expression without stopping execution. :contentReference[oaicite:15]{index=15}

    ===============================================================================
     5. DEBUGGER FEATURES YOU SHOULD KNOW
    ===============================================================================
    
     • Inline Debugging:
       View variable values directly in the editor next to code. :contentReference[oaicite:16]{index=16}

     • Watches:
       Track custom expressions during debugging.

     • Evaluate Expression (Alt + F8):
       Evaluate or test expressions at runtime without changing code. :contentReference[oaicite:17]{index=17}

     • Frames & Threads:
       See call stack and thread state.

     • Stream Trace (for Java Streams):
       Visualize pipeline execution in debugger. :contentReference[oaicite:18]{index=18}

    ===============================================================================
     6. COMMON SHORTCUTS (WINDOWS / LINUX)
    ===============================================================================
    
     • Toggle Breakpoint — Ctrl + F8 :contentReference[oaicite:19]{index=19}
     • Start Debugging — Shift + F9 :contentReference[oaicite:20]{index=20}
     • Step Over — F8 :contentReference[oaicite:21]{index=21}
     • Step Into — F7 :contentReference[oaicite:22]{index=22}
     • Step Out — Shift + F8 :contentReference[oaicite:23]{index=23}
     • Resume Program — F9 :contentReference[oaicite:24]{index=24}
     • Run to Cursor — Alt + F9 :contentReference[oaicite:25]{index=25}
     • Smart Step Into — Shift + F7 :contentReference[oaicite:26]{index=26}
     • Evaluate Expression — Alt + F8 :contentReference[oaicite:27]{index=27}

    ===============================================================================
     7. PRACTICAL EXAMPLE (DEBUGGING A BUG)
    ===============================================================================
    
     Suppose you have this Java class:

         public class BugDemo {
             public static void main(String[] args) {
                 int sum = calculateSum(5);
                 System.out.println(sum);
             }
             static int calculateSum(int n) {
                 int total = 0;
                 for(int i = 1; i <= n; i++)
                     total += i;
                 return total; // Bug might occur if loop bounds wrong
             }
         }

     • Place a breakpoint at the line `int total = 0;`.
     • Run Debug (Shift + F9).
     • Inspect variable ‘total’ and ‘i’ as loop executes.
     • Use Step Into/Over to verify logic. :contentReference[oaicite:28]{index=28}

    ===============================================================================
     8. TIPS FOR EFFICIENT DEBUGGING
    ===============================================================================
    
     • Start with targeted breakpoints rather than many random ones. :contentReference[oaicite:29]{index=29}
     • Use conditional breakpoints for loops.
     • Evaluate expressions to test logic quickly. :contentReference[oaicite:30]{index=30}
     • Watch variables you care about.
     • Fix issue and rerun Debug mode to confirm. :contentReference[oaicite:31]{index=31}

    ===============================================================================
     9. SUMMARY
    ===============================================================================
    
     ✔ IntelliJ provides a powerful fan of debugging tools. :contentReference[oaicite:32]{index=32}  
     ✔ Breakpoints, stepping, watch, evaluate expressions are the core features. :contentReference[oaicite:33]{index=33}  
     ✔ Shortcuts like F7/F8/F9 speed up debugging significantly. :contentReference[oaicite:34]{index=34}
     ✔ Advanced features like conditional breakpoints and smart step into make debugging more precise. :contentReference[oaicite:35]{index=35}

    ===============================================================================
     END OF FILE
    ===============================================================================
    */
}
