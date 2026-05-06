import java.util.*;
// task 3
public class Graph {

    // Adjacency list representation of the graph
    private Map<String, List<String>> adjacencyList = new HashMap<>();

    // Method to add a vertex and its neighbors
    public void addEdge(String vertex, String... neighbors) {
        adjacencyList.put(vertex, Arrays.asList(neighbors));
    }

    //                            DFS
    // Public method to start DFS
    public void depthFirstSearch(String startVertex) {
        Set<String> visited = new HashSet<>(); // Track visited nodes
        System.out.print("DFS Order: ");
        dfsRecursive(startVertex, visited);
        System.out.println();
    }

    // Recursive DFS helper method
    private void dfsRecursive(String current, Set<String> visited) {

        // If already visited → stop recursion
        if (visited.contains(current)) {
            return;
        }

        // Mark node as visited
        visited.add(current);

        // Process node (print it)
        System.out.print(current + " ");

        // Visit all neighbors of current node
        for (String neighbor : adjacencyList.get(current)) {
            dfsRecursive(neighbor, visited);
        }
    }

    //                           BFS

    // Public method to start BFS
    public void breadthFirstSearch(String startVertex) {

        Set<String> visited = new HashSet<>(); // Track visited nodes
        Queue<String> queue = new LinkedList<>(); // Queue for BFS

        // Initialize with starting node
        queue.add(startVertex);
        visited.add(startVertex);

        System.out.print("BFS Order: ");

        // Loop until queue is empty
        while (!queue.isEmpty()) {

            // Remove front node from queue
            String current = queue.poll();
            System.out.print(current + " ");

            // Add all unvisited neighbors to queue
            for (String neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }

    //                           MAIN
    public static void main(String[] args) {

        Graph graph = new Graph();

        // Build graph using given adjacency list
        graph.addEdge("A", "C", "B", "D");
        graph.addEdge("B", "A", "C", "E", "G");
        graph.addEdge("C", "A", "B", "D");
        graph.addEdge("D", "C", "A");
        graph.addEdge("E", "G", "F", "B");
        graph.addEdge("F", "G", "E");
        graph.addEdge("G", "F", "B");

        // Execute DFS and BFS
        graph.depthFirstSearch("A");
        graph.breadthFirstSearch("A");
    }
}