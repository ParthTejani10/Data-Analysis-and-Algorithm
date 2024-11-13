import java.util.Scanner;
public class MergeSort {
// Merge two sorted subarrays into one sorted array
public static void merge(int[] arr, int[] temp, int left, int mid, int right) {
int i = left; // Starting index for left subarray
int j = mid + 1; // Starting index for right subarray
int k = left; // Starting index to be sorted
while (i <= mid && j <= right) {
if (arr[i] <= arr[j]) {
temp[k++] = arr[i++];
} else {
temp[k++] = arr[j++];
}
}
// Copy remaining elements of left subarray, if any
while (i <= mid) {
temp[k++] = arr[i++];
}
// Copy remaining elements of right subarray, if any
while (j <= right) {
temp[k++] = arr[j++];
}
// Copy the sorted subarray into the original array
for (i = left; i <= right; i++) {
arr[i] = temp[i];
}
}
// Recursive function to perform merge sort
public static void mergeSort(int[] arr, int[] temp, int left, int right) {
if (left < right) {
int mid = (left + right) / 2;
// Recursively sort the left half
mergeSort(arr, temp, left, mid);
// Recursively sort the right half
mergeSort(arr, temp, mid + 1, right);
}
// Merge the two halves
merge(arr, temp, left, mid, right);
}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// Input array size
System.out.print("Enter number of elements in the array: ");
int size = scanner.nextInt();
int[] arr = new int[size];
int[] temp = new int[size]; // Temporary array for merging
// Input array elements
System.out.println("Enter elements of the array:");
for (int i = 0; i < size; i++) {
arr[i] = scanner.nextInt();
}
// Perform Merge Sort
mergeSort(arr, temp, 0, size - 1);
// Output sorted array
System.out.println("Sorted array in ascending order:");
for (int i = 0; i < size; i++) {
System.out.print(arr[i] + " ");
}
System.out.println();
scanner.close();
}
}
