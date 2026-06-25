public class ForecastTest {
    public static void main(String[] args) {
        System.out.println("--- Financial Forecasting Tool ---");
        
        double presentValue = 1000.0; // Initial investment
        double annualGrowthRate = 0.05; // 5% growth rate
        int years = 10;

        System.out.println("Present Value: $" + presentValue);
        System.out.println("Growth Rate: " + (annualGrowthRate * 100) + "%");
        System.out.println("Forecasting for " + years + " years...\n");

        // Execute recursive algorithm
        double futureValue = Forecaster.calculateFutureValue(presentValue, annualGrowthRate, years);
        System.out.printf("Predicted Future Value: $%.2f\n\n", futureValue);

        // Required Analysis Output
        System.out.println("--- Algorithm Analysis ---");
        System.out.println("Time Complexity: O(n)");
        System.out.println("Reason: The method makes a single recursive call for each period 'n', resulting in 'n' frames on the call stack.");
        System.out.println("\nOptimization Strategy:");
        System.out.println("1. Memoization: If we were calculating overlapping overlapping subproblems (like a Fibonacci-based growth trend), we could cache past results in a HashMap to avoid excessive redundant computation.");
        System.out.println("2. Space Complexity Reduction: We can optimize the O(n) space complexity of the recursive call stack to O(1) by using an iterative loop or by directly applying the mathematical formula: PV * (1 + r)^n.");
    }
}