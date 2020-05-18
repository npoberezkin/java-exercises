package algorithms.graph;

import datastructures.graph.Edge;
import datastructures.graph.Graph;
import datastructures.graph.Vertex;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Dijkstra {

    // test it
    private static void findShortestPaths(Graph graph, Vertex sourceVertex) {
        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new ArrayDeque<>();
        queue.add(sourceVertex);
        visited.add(sourceVertex);
        while (!queue.isEmpty()) {
            Vertex cur = queue.poll();
            for (Edge edge : cur.getEdges()) {
                Vertex source = edge.getSource();
                if (!visited.contains(source)) {
                    Vertex target = edge.getTarget();
                    queue.offer(target);
                    visited.add(source);
                    target.setDistance(Math.min(
                            target.getDistance(),
                            source.getDistance() + edge.getWeight()));

                }
            }
        }
    }

    public static void main(String[] args) {
    }
}
