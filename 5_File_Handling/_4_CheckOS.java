public class _4_CheckOS {

    /*
     * ===========================================================================
     * WHAT IS OPERATING SYSTEM DETECTION?
     * ===========================================================================
     * 
     * Detecting the operating system means finding out *which OS* the Java
     * program is currently running on — such as Windows, macOS, Linux, or others.
     * This is useful when writing cross-platform applications (e.g., dealing
     * with file path separators, running OS commands, configuring OS-specific
     * logic).
     * 
     */

    public static void main(String[] args) {

        /*
         * ===========================================================================
         * STEP 1: GET THE OPERATING SYSTEM NAME
         * ===========================================================================
         * 
         * System.getProperty("os.name") fetches a system property string
         * representing the operating system name. We convert it to lowercase
         * to make string matching easier and case-insensitive.
         */
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println("Operating System (raw os.name): " + osName);

        /*
         * ===========================================================================
         * STEP 2: CHECK SPECIFIC OS KEYWORDS
         * ===========================================================================
         * 
         * Once we have the OS name, we can check whether it contains
         * specific substrings to classify the OS type.
         * 
         * Typical checks:
         * • Windows → "win"
         * • macOS → "mac"
         * • Unix/Linux →
         * "nix" OR "nux" OR (“aix” for some Unix flavors)
         * 
         * These checks are common and work across many platforms.
         * :contentReference[oaicite:2]{index=2}
         */
        if (osName.contains("win")) {
            System.out.println("✔ Detected: Windows operating system");
        } else if (osName.contains("mac")) {
            System.out.println("✔ Detected: macOS operating system");
        } else if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
            System.out.println("✔ Detected: Unix/Linux based operating system");
        } else {
            System.out.println("⚠ Detected: Unknown or unsupported operating system");
        }

        /*
         * ===========================================================================
         * OPTIONAL: PRINT ADDITIONAL OS PROPERTIES
         * ===========================================================================
         * 
         * Java allows you to query many other system properties related to the
         * operating environment (e.g., version, architecture).
         * These are useful for logging or advanced platform behavior:
         * 
         * os.version → OS version
         * os.arch → OS architecture
         * 
         * Note: These aren’t part of the primary StudyEasy article, but
         * are commonly used in real applications. :contentReference[oaicite:3]{index=3}
         */
        System.out.println("\nAdditional OS Properties:");
        System.out.println("OS Version     → " + System.getProperty("os.version"));
        System.out.println("OS Architecture→ " + System.getProperty("os.arch"));
    }
}

/*
 * =============================================================================
 * ==
 * INTERVIEW QUESTIONS & ANSWERS
 * =============================================================================
 * ==
 * 
 * Q1. How do you detect the operating system in Java?
 * → By using System.getProperty("os.name") and simple string matching.
 * :contentReference[oaicite:4]{index=4}
 * 
 * Q2. Why convert the OS name to lowercase?
 * → To ensure case-insensitive comparisons (e.g., "Windows 10" → "windows 10").
 * 
 * Q3. What are common OS name keywords to check?
 * → "win" (Windows), "mac" (macOS), "nix"/"nux"/"aix" (Linux/Unix).
 * :contentReference[oaicite:5]{index=5}
 * 
 * Q4. What property would you use to get the OS version?
 * → System.getProperty("os.version"). :contentReference[oaicite:6]{index=6}
 * 
 * Q5. How can this be useful in real programs?
 * → To run OS-specific logic such as path construction, command execution,
 * or environment configuration.
 * 
 * =============================================================================
 * ==
 * BEST PRACTICES
 * =============================================================================
 * ==
 * 
 * ✔ Always convert strings to lowercase before comparison for reliability.
 * ✔ Use meaningful logs when detecting OS to help debugging.
 * ✔ When possible, avoid tight coupling to OS specifics — use libraries.
 * ✔ Test your application on different platforms if OS logic exists.
 * 
 * =============================================================================
 * ==
 * NOTES
 * =============================================================================
 * ==
 * 
 * 1. Some JVMs/containers may restrict access to system properties
 * via security policies — handle exceptions if needed.
 * 2. There are libraries (like Apache Commons SystemUtils) that wrap
 * system property checks in utility methods.
 * :contentReference[oaicite:7]{index=7}
 * 
 * =============================================================================
 * ==
 * END OF FILE
 * =============================================================================
 * ==
 */
