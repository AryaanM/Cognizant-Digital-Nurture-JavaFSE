import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calc;

    // Runs before every single test
    @Before
    public void setUp() {
        System.out.println("Setting up test fixture...");
        calc = new Calculator(); 
    }

    // Runs after every single test
    @After
    public void tearDown() {
        System.out.println("Tearing down test fixture...\n");
        calc = null; 
    }

    // Basic test using Arrange-Act-Assert (AAA) pattern
    @Test
    public void testAdd() {
        int result = calc.add(5, 3);
        assertEquals("5 + 3 should equal 8", 8, result);
        System.out.println("testAdd passed!");
    }

    // Using different assertions
    @Test
    public void testAssertions() {
        assertTrue("5 should be positive", calc.isPositive(5));
        assertFalse("-5 should not be positive", calc.isPositive(-5));
        assertNull("Object should be null", calc.getNullObject());
        assertNotNull("Calculator instance should not be null", calc);
        System.out.println("testAssertions passed!");
    }
}