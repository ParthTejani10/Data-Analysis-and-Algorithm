import java.util.Scanner;
public class LongestCommonSubsequence {
// Function to find the length of the longest common subsequence
public static int lcs(String X, String Y) {
int m = X.length();
int n = Y.length();
// Create a 2D array to store the lengths of LCS
int[][] dp = new int[m + 1][n + 1];
// Fill the dp array
for (int i = 1; i <= m; i++) {
for (int j = 1; j <= n; j++) {
if (X.charAt(i - 1) == Y.charAt(j - 1)) {
// If characters match, add 1 to the result of the previous characters
dp[i][j] = dp[i - 1][j - 1] + 1;
} else {
// If characters don't match, take the maximum of excluding current
character from one of the strings
dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
}
}
}
// Return the length of LCS
}
return dp[m][n];
// Function to print the longest common subsequence
public static String printLCS(String X, String Y) {
int m = X.length();
int n = Y.length();
// Create a 2D array to store the lengths of LCS
int[][] dp = new int[m + 1][n + 1];
// Fill the dp array as before
for (int i = 1; i <= m; i++) {
for (int j = 1; j <= n; j++) {
if (X.charAt(i - 1) == Y.charAt(j - 1)) {
dp[i][j] = dp[i - 1][j - 1] + 1;
} else {
dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
}
}
}
// Reconstruct LCS from the dp table
StringBuilder lcs = new StringBuilder();
int i = m, j = n;
while (i > 0 && j > 0) {
if (X.charAt(i - 1) == Y.charAt(j - 1)) {
// If characters match, it is part of LCS
lcs.append(X.charAt(i - 1));
i--;
j--;
} else if (dp[i - 1][j] > dp[i][j - 1]) {
// Move up in the dp table
i--;
} else {
// Move left in the dp table
j--;
}
}
// LCS is built in reverse order, so reverse the string before returning
}
return lcs.reverse().toString();
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// Input two strings
System.out.print("Enter the first string: ");
String X = scanner.nextLine();
System.out.print("Enter the second string: ");
String Y = scanner.nextLine();
// Find the length of the LCS
int lcsLength = lcs(X, Y);
System.out.println("Length of the Longest Common Subsequence: " + lcsLength);
// Print the LCS
String lcsString = printLCS(X, Y);
System.out.println("Longest Common Subsequence: " + lcsString);
scanner.close();
}
}
