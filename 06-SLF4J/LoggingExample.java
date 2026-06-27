import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    
    // Initialize the logger for this specific class
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        
        System.out.println("--- Starting SLF4J Logging Operations ---");

        // EXERCISE 1: Logging Error Messages and Warning Levels
        logger.error("CRITICAL: Database connection lost.");
        logger.warn("WARNING: Memory usage exceeding 80%.");

        // EXERCISE 2: Parameterized Logging
        // Instead of messy string concatenation (like "User " + user + " logged in"), 
        // SLF4J uses {} as clean placeholders.
        String username = "system_admin";
        int activeSessions = 4;
        
        logger.info("User '{}' successfully authenticated. Active sessions: {}", username, activeSessions);
        logger.debug("Debugging payload data for current transaction...");
        
        System.out.println("--- Logging Operations Complete ---");
    }
}