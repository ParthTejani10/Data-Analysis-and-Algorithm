import java.util.*;

public class heapSort {
    public static void heapify(int arr[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, i);
        }
    }

    public static void heapSort(int arr[]) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, n, 0);
        }
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
        System.out.println("1.Best case");
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
                System.out.println("Average case:");
                break;
            case 3:
                for (int i = 0; i < size; i++) {
                    arr[i] = size - i;
                }
                System.out.println("Worst case:");
                break;

            default:
                System.out.println("Invalid choice!");
                break;
        }
        Display(arr);
        long startTime = System.nanoTime();
        heapSort(arr);
        long endTime = System.nanoTime();

        Display(arr);
        long duration = endTime - startTime;

        System.out.println("Start time:" + startTime);
        System.out.println("End time:" + endTime);
        System.out.println("Time taken to sort:" + duration / 1000000.0 + "milliseconds");
    }
}