package tester.demos;

import Graphs.Network;

import java.util.Iterator;

public class DemoNetwork {
    public static void main(String[] args) {
        Network<String> network = new Network<>();

        // Add vertices
        network.addVertex("A");
        network.addVertex("B");
        network.addVertex("C");
        network.addVertex("D");

        // Add edges with weights
        network.addEdge("A", "B", 2.0);
        network.addEdge("A", "C", 1.5);
        network.addEdge("B", "D", 3.0);
        network.addEdge("C", "D", 2.5);

        // Print the network
        System.out.println("Network:");
        System.out.println(network);

        // Remove a vertex
        network.removeVertex("B");

        // Print the network after removal
        System.out.println("\nNetwork after removal:");
        System.out.println(network);

        // Get the shortest path and its weight
        int startIndex = network.getIndex("A");
        int targetIndex = network.getIndex("D");
        System.out.print("\nShortest path from A to D: ");
        Iterator<String> shortestPathIterator = network.iteratorShortestPath(startIndex, targetIndex);
        while (shortestPathIterator.hasNext()) {
            System.out.print(shortestPathIterator.next());
            if (shortestPathIterator.hasNext()) {
                System.out.print(" -> ");
            }
        }

        System.out.println("\nShortest path weight from A to D: " + network.shortestPathWeight(startIndex, targetIndex));
    }
}
