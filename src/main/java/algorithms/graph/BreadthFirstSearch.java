package algorithms.graph;

import datastructures.graph.Graph;
import datastructures.graph.Vertex;

import java.util.*;

public class BreadthFirstSearch {

    private static void traverse(Graph graph, Vertex root) {
        Set<Vertex> traversed = new HashSet<>();
        Queue<Vertex> queue = new ArrayDeque<>();
        queue.offer(root);
        traversed.add(root);
        while (!queue.isEmpty()) {
            Vertex cur = queue.poll();
            System.out.println("traversed vertex " + cur.getLabel());
            List<Vertex> adjVertices = graph.getAdjVertices(cur.getLabel());
            for (Vertex vertex : adjVertices) {
                if (!traversed.contains(vertex)) {
                    queue.offer(vertex);
                    traversed.add(vertex);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("10");
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addVertex("0");
        graph.addVertex("3");
        graph.addVertex("11");
        graph.addVertex("20");
        graph.addEdge("10", "1");
        graph.addEdge("1", "2");
        graph.addEdge("1", "4");
        graph.addEdge("4", "5");
        graph.addEdge("5", "0");
        graph.addEdge("0", "20");
        graph.addEdge("20", "11");
        graph.addEdge("11", "3");
        graph.addEdge("3", "4");

        traverse(graph, new Vertex("1"));
    }
}
