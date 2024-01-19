package tester.demos;

import Graphs.Graph;

public class DemoGraph {
    public static void main(String[] args) {

        Graph<String> graph = new Graph<>();

        // Add vertices
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        // Add edges
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");

        // Print the graph
        System.out.println("Graph before removal:");
        System.out.println(graph);

        // Remove a vertex
        graph.removeVertex("B");

        // Print the graph after removal
        System.out.println("\nGraph after removal:");
        System.out.println(graph);

        // Check if the graph is connected
        System.out.println("\nIs the graph connected? " + graph.isConnected());

        // Get the minimum spanning tree
        Graph<String> mst = graph.getMST();
        System.out.println("\nMinimum Spanning Tree:");
        System.out.println(mst);
    }
}
