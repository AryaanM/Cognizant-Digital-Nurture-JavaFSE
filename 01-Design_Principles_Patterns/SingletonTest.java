public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("--- Starting Singleton Test ---");

        // Request the Logger instance twice
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Print test logs using both variables
        logger1.log("User logged in successfully.");
        logger2.log("Database transaction started.");

        // Verification check: Do both variables point to the exact same object?
        if (logger1 == logger2) {
            System.out.println("\nSUCCESS: Both logger1 and logger2 point to the same instance!");
        } else {
            System.out.println("\nFAILURE: Multiple instances exist.");
        }
    }
}