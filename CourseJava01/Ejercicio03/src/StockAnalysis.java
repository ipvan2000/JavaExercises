import java.util.ArrayList;

public class StockAnalysis {

    // Calculate the average stock price
    public static float calculateAveragePrice(float[] prices) {
        float sum = 0;
        // Iterate over each price in the array
        for (float price : prices) {
            sum += price; // Accumulate the sum of prices
        }
        // Return the average by dividing the sum by the number of prices
        return sum / prices.length;
    }

    // Find the maximum stock price
    public static float findMaximumPrice(float[] prices) {
        float maxPrice = Float.MIN_VALUE; // Initialize maxPrice to the smallest possible value
        // Iterate over each price in the array
        for (float price : prices) {
            if (price > maxPrice) { // If current price is greater than maxPrice
                maxPrice = price; // Update maxPrice
            }
        }
        // Return the maximum price found
        return maxPrice;
    }

    // Determine the occurrence count of a specific price
    public static int countOccurrences(float[] prices, float targetPrice) {
        int count = 0;
        // Iterate over each price in the array
        for (float price : prices) {
            if (price == targetPrice) { // If current price matches targetPrice
                count++; // Increment count
            }
        }
        // Return the count of occurrences
        return count;
    }

    // Compute the cumulative sum of stock prices
    public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> prices) {
        ArrayList<Float> cumulativeSum = new ArrayList<>();
        float sum = 0;
        // Iterate over each price in the ArrayList
        for (float price : prices) {
            sum += price; // Accumulate the sum
            cumulativeSum.add(sum); // Add the cumulative sum to the ArrayList
        }
        // Return the ArrayList containing cumulative sums
        return cumulativeSum;
    }

    public static void main(String[] args) {
        // Example usage
        float[] pricesArray = {10.5f, 12.3f, 11.7f, 13.2f, 10.8f, 12.5f, 11.9f, 13.8f, 12.0f, 11.4f};
        ArrayList<Float> pricesList = new ArrayList<>();
        for (float price : pricesArray) {
            pricesList.add(price); // Convert array to ArrayList
        }

        // Calculate average price
        float averagePrice = calculateAveragePrice(pricesArray);
        System.out.println("Average Price: " + averagePrice);

        // Find maximum price
        float maxPrice = findMaximumPrice(pricesArray);
        System.out.println("Maximum Price: " + maxPrice);

        // Count occurrences of a specific price
        float targetPrice = 12.3f;
        int occurrences = countOccurrences(pricesArray, targetPrice);
        System.out.println("Occurrences of " + targetPrice + ": " + occurrences);

        // Compute cumulative sum
        ArrayList<Float> cumulativeSum = computeCumulativeSum(pricesList);
        System.out.println("Cumulative Sum: " + cumulativeSum);
    }
}
