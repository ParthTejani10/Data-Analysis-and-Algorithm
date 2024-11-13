import java.util.Arrays;
import java.util.Scanner;
public class SearchAlgorithms {
// Sequential Search (Linear Search) implementation
public static int sequentialSearch(int[] arr, int target) {
for (int i = 0; i < arr.length; i++) {
if (arr[i] == target) {
return i; // Target found, return index
}
}
return -1; // Target not found
}
// Binary Search implementation (array must be sorted)
public static int binarySearch(int[] arr, int target) {
int left = 0;
int right = arr.length - 1;
while (left <= right) {
int mid = left + (right - left) / 2; // Prevents potential overflow
if (arr[mid] == target) {
return mid; // Target found, return index
} else if (arr[mid] < target) {
left = mid + 1; // Target is in the right half
} else {
right = mid - 1; // Target is in the left half
}
}
return -1; // Target not found
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
// Input target element
System.out.print("Enter the element to search: ");
int target = scanner.nextInt();
// Sequential Search
int resultSeq = sequentialSearch(arr, target);
if (resultSeq != -1) {
System.out.println("Sequential Search: Element found at index " + resultSeq);
} else {
System.out.println("Sequential Search: Element not found");
}
// Sorting array for Binary Search
Arrays.sort(arr);
System.out.println("Sorted array for Binary Search: " + Arrays.toString(arr));
// Binary Search
int resultBin = binarySearch(arr, target);
if (resultBin != -1) {
System.out.println("Binary Search: Element found at index " + resultBin);
} else {
System.out.println("Binary Search: Element not found");
}
scanner.close();
}
}
