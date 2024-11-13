import java.util.Scanner;
public class MatrixChainMultiplication {
// Function to implement matrix chain multiplication using dynamic programming
public static int matrixChainOrder(int[] p, int n) {
// m[i][j] will store the minimum number of scalar multiplications required
// to multiply matrices from i to j
int[][] m = new int[n][n];
// cost is zero when multiplying one matrix
for (int i = 1; i < n; i++) {
m[i][i] = 0;
}
// L is the chain length
for (int L = 2; L < n; L++) { // L is the chain length
for (int i = 1; i < n - L + 1; i++) {
int j = i + L - 1;
m[i][j] = Integer.MAX_VALUE; // Set to a large value initially
// Try every possible split point to find the minimum cost
for (int k = i; k <= j - 1; k++) {
// cost of splitting at k
int cost = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
// Update the minimum cost
if (cost < m[i][j]) {
m[i][j] = cost;
}
}
}
}
// The final result is stored in m[1][n-1] which gives the minimum number of
// scalar multiplications required to multiply matrices from 1 to n-1
return m[1][n - 1];
}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// Input the number of matrices
System.out.print("Enter the number of matrices: ");
int n = scanner.nextInt();
p[i]
// Input the dimensions of the matrices
// The array `p` stores the dimensions where the i-th matrix has dimensions p[i-1] x
int[] p = new int[n + 1];
System.out.println("Enter the dimensions of the matrices:");
for (int i = 0; i <= n; i++) {
p[i] = scanner.nextInt();
}
// Find the minimum number of scalar multiplications required
int result = matrixChainOrder(p, n + 1);
// Output the result
System.out.println("Minimum number of scalar multiplications is: " + result);
scanner.close();
}
}
