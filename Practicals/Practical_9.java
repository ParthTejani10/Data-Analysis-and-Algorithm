import java.util.Arrays;
import java.util.Scanner;
public class DynamicChange {
// Function to find the minimum number of coins using dynamic programming
public static int minCoins(int[] coins, int amount) {
// dp[i] will store the minimum number of coins needed for amount i
int[] dp = new int[amount + 1];
// Initialize dp array with a large value (greater than possible number of coins)
Arrays.fill(dp, amount + 1);
// Base case: to make 0 amount, we need 0 coins
dp[0] = 0;
// Build the dp array
for (int i = 1; i <= amount; i++) {
for (int coin : coins) {
if (i >= coin) {
dp[i] = Math.min(dp[i], dp[i - coin] + 1);
}
}
}
// If dp[amount] is still greater than amount, it means it's not possible to make
change
return dp[amount] > amount ? -1 : dp[amount];
}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// Input coin denominations
System.out.print("Enter the number of coin denominations: ");
int numDenominations = scanner.nextInt();
int[] coins = new int[numDenominations];
System.out.println("Enter the coin denominations:");
for (int i = 0; i < numDenominations; i++) {
coins[i] = scanner.nextInt();
}
// Input the amount for which change is to be made
System.out.print("Enter the amount to make change for: ");
int amount = scanner.nextInt();
// Find the minimum number of coins
int result = minCoins(coins, amount);
// Output the result
if (result == -1) {
System.out.println("It's not possible to make change for the given amount with
the provided coins.");
} else {
System.out.println("Minimum number of coins required: " + result);
}
scanner.close();
}
}
