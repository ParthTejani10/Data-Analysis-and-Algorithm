import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
class Item {
int value, weight;
// Constructor
public Item(int value, int weight) {
this.value = value;
this.weight = weight;
}
}
public class FractionalKnapsack {
// Function to calculate the maximum value we can get
public static double getMaxValue(int capacity, Item[] items) {
// Sort items by value-to-weight ratio in descending order
Arrays.sort(items, new Comparator<Item>() {
@Override
public int compare(Item item1, Item item2) {
double r1 = (double) item1.value / item1.weight;
double r2 = (double) item2.value / item2.weight;
return Double.compare(r2, r1); // Sort in descending order
}
});
double totalValue = 0.0;
int currentWeight = 0;
// Loop through the items and take as much as possible
for (Item item : items) {
if (currentWeight + item.weight <= capacity) {
// Take the whole item
currentWeight += item.weight;
totalValue += item.value;
} else {
// Take a fraction of the remaining item to fill the knapsack
int remainingCapacity = capacity - currentWeight;
totalValue += item.value * ((double) remainingCapacity / item.weight);
break; // The knapsack is full
}
}
return totalValue;
}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// Input number of items
System.out.print("Enter the number of items: ");
int n = scanner.nextInt();
Item[] items = new Item[n];
// Input values and weights of each item
for (int i = 0; i < n; i++) {
System.out.print("Enter value and weight of item " + (i + 1) + ": ");
int value = scanner.nextInt();
int weight = scanner.nextInt();
items[i] = new Item(value, weight);
}
// Input knapsack capacity
System.out.print("Enter the capacity of the knapsack: ");
int capacity = scanner.nextInt();
// Calculate the maximum value
double maxValue = getMaxValue(capacity, items);
System.out.printf("Maximum value we can obtain = %.2f\n", maxValue);
scanner.close();
}
}
