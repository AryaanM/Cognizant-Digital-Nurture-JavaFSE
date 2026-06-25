public class Logger {
    // Private static instance of the same class
    private static Logger instance;

    // Private constructor prevents instantiation from other classes
    private Logger() {
        System.out.println("Logger instance initialized.");
    }

    // Public static method to provide global access to the single instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger(); // Lazy initialization
        }
        return instance;
    }

    // Simple utility method for testing
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}