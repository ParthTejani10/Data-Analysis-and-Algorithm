import java.util.Random;
public class SelectionSort {
// Function to perform Selection Sort
public static void selectionSort(int[] arr) {
int n = arr.length;
for (int i = 0; i < n - 1; i++) {
// Find the minimum element in the unsorted part of the array
int minIndex = i;
for (int j = i + 1; j < n; j++) {
if (arr[j] < arr[minIndex]) {
minIndex = j;
}
}
// Swap the found minimum element with the first element of the unsorted part
int temp = arr[minIndex];
arr[minIndex] = arr[i];
arr[i] = temp;
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
selectionSort(arr);
long endTime = System.nanoTime();
// Uncomment the following lines if you want to see the array after sorting
// System.out.println("Sorted array:");
// printArray(arr);
long duration = endTime - startTime;
System.out.println("Time taken to sort 1000 elements using Selection Sort: " +
duration + " nanoseconds");
}
// Time Complexity Analysis
System.out.println("Time Complexity:");
System.out.println("Best Case: O(n^2) = O(1000^2) = 1000000");
System.out.println("Average Case: O(n^2) = O(1000^2) = 1000000");
System.out.println("Worst Case: O(n^2) = O(1000^2) = 1000000");
}
}
