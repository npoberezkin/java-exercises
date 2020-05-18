package datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<Vertex, List<Vertex>> adjVertices = new HashMap<>();

    public void addVertex(String label) {
        if (label == null) throw new IllegalArgumentException("vertex label should not be null");
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void removeVertex(String label) {
        if (label == null) throw new IllegalArgumentException("vertex label should not be null");
        Vertex vertex = new Vertex(label);
        adjVertices.values().forEach(vertices -> vertices.remove(vertex));
        adjVertices.remove(vertex);
    }

    public void addEdge(String label1, String label2) {
        Vertex vertex1 = new Vertex(label1);
        Vertex vertex2 = new Vertex(label2);
        adjVertices.get(vertex1).add(vertex2);
        adjVertices.get(vertex2).add(vertex1);
    }

    public void removeEdge(String label1, String label2) {
        Vertex vertex1 = new Vertex(label1);
        Vertex vertex2 = new Vertex(label2);
        List<Vertex> adjV1 = adjVertices.get(vertex1);
        List<Vertex> adjV2 = adjVertices.get(vertex2);
        if (adjV1 != null)
            adjV1.remove(vertex2);
        if (adjV2 != null)
            adjV2.remove(vertex1);
    }

    public List<Vertex> getAdjVertices(String label) {
        return adjVertices.get(new Vertex(label));
    }

}


