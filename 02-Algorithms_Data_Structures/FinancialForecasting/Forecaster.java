public class Forecaster {
    
    // Recursive method to calculate future value
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base case: If 0 periods are left, the value is just the present value
        if (periods == 0) {
            return presentValue;
        }
        
        // Recursive step: Calculate the value for (periods - 1) and apply the growth rate for the current period
        return (1 + growthRate) * calculateFutureValue(presentValue, growthRate, periods - 1);
    }
}