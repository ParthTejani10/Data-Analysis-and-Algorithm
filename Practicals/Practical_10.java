import java.util.Scanner;
public class KnapsackDP {
// Function to implement the knapsack problem using dynamic programming
public static int knapsack(int[] values, int[] weights, int capacity, int n) {
// Create a DP table where dp[i][w] represents the maximum value for i items and
weight w
int[][] dp = new int[n + 1][capacity + 1];
// Build the DP table
for (int i = 1; i <= n; i++) {
for (int w = 1; w <= capacity; w++) {
if (weights[i - 1] <= w) {
// Include the item or exclude it, choose the option that gives maximum
value
dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
} else {
// If the current item can't be included, take the value without it
dp[i][w] = dp[i - 1][w];
}
}
}
// The last cell of the DP table will have the maximum value for the full knapsack
}
return dp[n][capacity];
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// Input number of items
System.out.print("Enter the number of items: ");
int n = scanner.nextInt();
  int[] values = new int[n];
int[] weights = new int[n];
// Input values and weights of each item
System.out.println("Enter the values and weights of the items:");
for (int i = 0; i < n; i++) {
System.out.print("Item " + (i + 1) + " value: ");
values[i] = scanner.nextInt();
System.out.print("Item " + (i + 1) + " weight: ");
weights[i] = scanner.nextInt();
}
// Input the knapsack capacity
System.out.print("Enter the knapsack capacity: ");
int capacity = scanner.nextInt();
// Solve the knapsack problem
int maxValue = knapsack(values, weights, capacity, n);
System.out.println("Maximum value that can be obtained: " + maxValue);
scanner.close();
}
}
