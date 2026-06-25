public class SearchUtil {

    // 1. Linear Search Algorithm (O(n) time complexity)
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product;
            }
        }
        return null; // Product not found
    }

    // 2. Binary Search Algorithm (O(log n) time complexity)
    // Note: The array MUST be sorted before calling this method.
    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (products[mid].getProductId() == targetId) {
                return products[mid]; // Target found
            }
            if (products[mid].getProductId() < targetId) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return null; // Product not found
    }
}