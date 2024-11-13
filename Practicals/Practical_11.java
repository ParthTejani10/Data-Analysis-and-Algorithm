import java.util.Scanner;
public class FloydWarshall {
final static int INF = 99999; // Representing infinity as a large number
// Function to implement Floyd-Warshall Algorithm
public static void floydWarshall(int[][] graph, int V) {
// Create a distance matrix initialized with the graph adjacency matrix
int[][] dist = new int[V][V];
// Initialize the solution matrix same as input graph matrix
for (int i = 0; i < V; i++) {
for (int j = 0; j < V; j++) {
dist[i][j] = graph[i][j];
}
}
// Update the solution matrix by considering all vertices as intermediate vertices
for (int k = 0; k < V; k++) {
// Pick all vertices as source one by one
for (int i = 0; i < V; i++) {
// Pick all vertices as destination for the above-picked source
for (int j = 0; j < V; j++) {
// If vertex k is on the shortest path from i to j, update the dist[i][j]
if (dist[i][k] + dist[k][j] < dist[i][j]) {
dist[i][j] = dist[i][k] + dist[k][j];
}
}
}
}
// Print the shortest distance matrix
printSolution(dist, V);
}
// Function to print the solution matrix
public static void printSolution(int[][] dist, int V) {
System.out.println("Shortest distances between every pair of vertices:");
for (int i = 0; i < V; i++) {
for (int j = 0; j < V; j++) {
if (dist[i][j] == INF) {
System.out.print("INF ");
} else {
System.out.print(dist[i][j] + " ");
}
}
System.out.println();
}
}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// Input the number of vertices
System.out.print("Enter the number of vertices: ");
int V = scanner.nextInt();
// Input the adjacency matrix of the graph
int[][] graph = new int[V][V];
System.out.println("Enter the adjacency matrix (use 99999 for no direct path):");
for (int i = 0; i < V; i++) {
for (int j = 0; j < V; j++) {
graph[i][j] = scanner.nextInt();
}
}
// Call the Floyd-Warshall algorithm to find the shortest paths
floydWarshall(graph, V);
scanner.close();
}
}
