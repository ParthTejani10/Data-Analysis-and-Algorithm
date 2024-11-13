import java.util.Scanner;
public class GreedyChange {
// Function to implement greedy algorithm to make change
public static void makeChange(int amount, int[] coins) {
int[] count = new int[coins.length]; // To store the count of each coin used
// Traverse through all denominations from largest to smallest
for (int i = 0; i < coins.length; i++) {
if (amount >= coins[i]) {
count[i] = amount / coins[i]; // Calculate number of coins of this denomination
amount = amount % coins[i]; // Reduce the remaining amount
}
}
// Display result
System.out.println("Coins used to make change:");
for (int i = 0; i < coins.length; i++) {
if (count[i] != 0) {
System.out.println(coins[i] + " Rupees: " + count[i] + " coins");
}
}
}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// Input available coin denominations (in descending order for greedy approach)
int[] coins = {20, 10, 5, 2, 1}; // Example: U.S. coin denominations
// Input the amount to make change for
System.out.print("Enter the amount in cents: ");
int amount = scanner.nextInt();
// Call the makeChange function
makeChange(amount, coins);
scanner.close();
}
}
