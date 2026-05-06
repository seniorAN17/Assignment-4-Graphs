import java.util.*;
// task 5
// Node class for priority queue
// Stores city name and current shortest distance
class Node implements Comparable<Node> {

    String name;
    int distance;

    public Node(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    // Sort by smallest distance (min-heap behavior)
    @Override
    public int compareTo(Node other) {
        return this.distance - other.distance;
    }
}

public class DijkstraGraph {

    // Graph represented as adjacency list
    private Map<String, List<Node>> adjacencyList = new HashMap<>();

    // Add undirected weighted edge
    public void addEdge(String from, String to, int weight) {

        adjacencyList
                .computeIfAbsent(from, k -> new ArrayList<>())
                .add(new Node(to, weight));

        adjacencyList
                .computeIfAbsent(to, k -> new ArrayList<>())
                .add(new Node(from, weight));
    }

    // Dijkstra algorithm
    public void dijkstra(String startVertex) {

        // Stores shortest distances
        Map<String, Integer> distances = new HashMap<>();

        // Stores previous node for path reconstruction
        Map<String, String> parent = new HashMap<>();

        // Priority queue for selecting smallest distance node
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // Initialize distances
        for (String vertex : adjacencyList.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }

        // Start node distance = 0
        distances.put(startVertex, 0);
        pq.add(new Node(startVertex, 0));

        // Main loop
        while (!pq.isEmpty()) {

            Node current = pq.poll();

            // Skip outdated entries
            if (current.distance > distances.get(current.name)) continue;

            // Check neighbors
            for (Node neighbor : adjacencyList.get(current.name)) {

                int newDistance = distances.get(current.name) + neighbor.distance;

                // Relaxation step
                if (newDistance < distances.get(neighbor.name)) {
                    distances.put(neighbor.name, newDistance);
                    parent.put(neighbor.name, current.name);
                    pq.add(new Node(neighbor.name, newDistance));
                }
            }
        }

        // ===== OUTPUT DISTANCES =====
        System.out.println("Shortest distances from " + startVertex + ":\n");

        for (String city : distances.keySet()) {
            System.out.println(city + " → " + distances.get(city));
        }

        // ===== SHORTEST PATH TO DUNDEE =====
        System.out.println("\nShortest path from Edinburgh to Dundee:");

        List<String> path = new ArrayList<>();
        String step = "Dundee";

        // Backtrack path using parent map
        while (step != null) {
            path.add(step);
            step = parent.get(step);
        }

        Collections.reverse(path);

        System.out.println(String.join(" → ", path));
        System.out.println("Total distance: " + distances.get("Dundee"));
    }

    // MAIN METHOD
    public static void main(String[] args) {

        DijkstraGraph graph = new DijkstraGraph();

        // Road network
        graph.addEdge("Edinburgh", "Stirling", 50);
        graph.addEdge("Edinburgh", "Glasgow", 70);
        graph.addEdge("Edinburgh", "Perth", 100);
        graph.addEdge("Stirling", "Perth", 40);
        graph.addEdge("Stirling", "Glasgow", 50);
        graph.addEdge("Perth", "Dundee", 60);

        // Run algorithm
        graph.dijkstra("Edinburgh");
    }
}