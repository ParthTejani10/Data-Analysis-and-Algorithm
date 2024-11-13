import java.util.Random;
public class BubbleSort {
// Function to perform Bubble Sort
public static void bubbleSort(int[] arr) {
int n = arr.length;
boolean swapped;
for (int i = 0; i < n - 1; i++) {
swapped = false;
for (int j = 0; j < n - 1 - i; j++) {
if (arr[j] > arr[j + 1]) {
// Swap arr[j] and arr[j + 1]
int temp = arr[j];
arr[j] = arr[j + 1];
arr[j + 1] = temp;
swapped = true;
}
}
// If no two elements were swapped in the inner loop, then the array is sorted
if (!swapped) break;
}
}
// Function to print the array
public static void printArray(int[] arr) {
for (int i : arr) {
System.out.print(i + " ");
}
System.out.println();
}
public static void main(String[] args) {
int n = 1000;
  int[] arr = new int[n];
// Generate random array of 1000 elements
Random rand = new Random();
for (int i = 0; i < n; i++) {
arr[i] = rand.nextInt(10000); // Random number between 0 and 9999
}
// Uncomment the following lines if you want to see the array before sorting
// System.out.println("Unsorted array:");
// printArray(arr);
long startTime = System.nanoTime();
bubbleSort(arr);
long endTime = System.nanoTime();
// Uncomment the following lines if you want to see the array after sorting
// System.out.println("Sorted array:");
// printArray(arr);
long duration = endTime - startTime;
System.out.println("Time taken to sort 1000 elements using Bubble Sort: " +
duration + " nanoseconds");
}
// Time Complexity Analysis
System.out.println("Time Complexity:");
System.out.println("Best Case: O(n) = O(1000) = 1000");
System.out.println("Average Case: O(n^2) = O(1000^2) = 1000000");
System.out.println("Worst Case: O(n^2) = O(1000^2) = 1000000");
}
