import java.util.*;

public class Search {
    public static int sequentialSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void Display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the case:");
        System.out.println("1.Best Case");
        System.out.println("2.Average case");
        System.out.println("3.Worst case");
        int choice = sc.nextInt();

        int size = 100;
        int[] arr = new int[size];

        switch (choice) {
            case 1:
                for (int i = 0; i < size; i++) {
                    arr[i] = i + 1;
                }
                System.out.println("Best case:");
                break;

            case 2:
                Random rand = new Random();
                for (int i = 0; i < size; i++) {
                    arr[i] = rand.nextInt(100);
                }
                Arrays.sort(arr);
                System.out.println("Average case:");
                break;

            case 3:
                for (int i = 0; i < size; i++) {
                    arr[i] = size - i;
                }
                Arrays.sort(arr);
                System.out.println("Worst case:");
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        Display(arr);
        System.out.println("Enter the element to search:");
        int target = sc.nextInt();

        long startTimeSeq = System.nanoTime();
        int resultSeq = sequentialSearch(arr, target);
        long endTimeSeq = System.nanoTime();
        long durationSeq = endTimeSeq - startTimeSeq;

        long startTimeBin = System.nanoTime();
        int resultBin = binarySearch(arr, target);
        long endTimeBin = System.nanoTime();
        long durationBin = endTimeBin - startTimeBin;

        // Display results
        System.out.println("Sequential Search:");
        System.out.println("Index: " + resultSeq);
        System.out.println("Time taken: " + durationSeq / 1000000.0 + " milliseconds");

        System.out.println("Binary Search:");
        System.out.println("Index: " + resultBin);
        System.out.println("Time taken: " + durationBin / 1000000.0 + " milliseconds");

    }
}