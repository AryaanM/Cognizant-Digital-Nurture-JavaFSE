import java.util.Arrays;

public class SearchTest {
    public static void main(String[] args) {
        System.out.println("--- E-Commerce Search Platform ---");

        // 1. Setup Data
        Product[] inventory = {
            new Product(105, "Wireless Mouse", "Electronics"),
            new Product(101, "Mechanical Keyboard", "Electronics"),
            new Product(108, "Desk Lamp", "Home Office"),
            new Product(103, "Ergonomic Chair", "Furniture"),
            new Product(102, "Noise Cancelling Headphones", "Audio")
        };

        int searchId = 103;

        // 2. Test Linear Search (Works on unsorted arrays)
        System.out.println("\nExecuting Linear Search for Product ID: " + searchId);
        Product foundLinear = SearchUtil.linearSearch(inventory, searchId);
        System.out.println("Result: " + (foundLinear != null ? foundLinear : "Not Found"));

        // 3. Test Binary Search (Requires sorted array)
        System.out.println("\nSorting array for Binary Search...");
        Arrays.sort(inventory); // Sorts based on the compareTo method in Product.java
        
        System.out.println("Executing Binary Search for Product ID: " + searchId);
        Product foundBinary = SearchUtil.binarySearch(inventory, searchId);
        System.out.println("Result: " + (foundBinary != null ? foundBinary : "Not Found"));

        // 4. Analysis output (Required by the problem statement steps)
        System.out.println("\n--- Time Complexity Analysis ---");
        System.out.println("Linear Search:");
        System.out.println(" - Best Case: O(1) (Found at first index)");
        System.out.println(" - Worst Case: O(n) (Found at last index or not present)");
        System.out.println("Binary Search:");
        System.out.println(" - Best Case: O(1) (Found exactly at the middle index)");
        System.out.println(" - Worst Case: O(log n) (Found after continually halving the search space)");
    }
}