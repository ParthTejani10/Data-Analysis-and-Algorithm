import java.util.Scanner;
public class QuickSort {
// Function to perform partitioning of the array
public static int partition(int[] arr, int low, int high) {
int pivot = arr[high]; // Choose the rightmost element as pivot
int i = low - 1;
// Index of smaller element
for (int j = low; j < high; j++) {
if (arr[j] < pivot) {
i++;
// Swap arr[i] and arr[j]
int temp = arr[i];
arr[i] = arr[j];
arr[j] = temp;
}
}
// Place the pivot in its correct position
int temp = arr[i + 1];
arr[i + 1] = arr[high];
arr[high] = temp;
return i + 1; // Return the pivot index
}
// Function to perform Quick Sort
public static void quickSort(int[] arr, int low, int high) {
if (low < high) {
// Partition the array and get the pivot index
int pivotIndex = partition(arr, low, high);
// Recursively sort elements before and after the partition
quickSort(arr, low, pivotIndex - 1); // Left subarray
quickSort(arr, pivotIndex + 1, high); // Right subarray
}
}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// Input array size
System.out.print("Enter number of elements in the array: ");
int size = scanner.nextInt();
int[] arr = new int[size];
// Input array elements
System.out.println("Enter elements of the array:");
for (int i = 0; i < size; i++) {
arr[i] = scanner.nextInt();
}
// Perform Quick Sort
quickSort(arr, 0, size - 1);
// Output sorted array
System.out.println("Sorted array in ascending order:");
for (int i = 0; i < size; i++) {
System.out.print(arr[i] + " ");
}
System.out.println();
scanner.close();
}
}
