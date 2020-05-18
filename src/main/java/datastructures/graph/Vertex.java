package datastructures.graph;

import java.util.List;
import java.util.Objects;

public class Vertex {
    private String label;
    private List<Edge> edges;
    private int distance;
    private Vertex predecessor;

    public Vertex(String label) {
        this.label = label;
    }

    public Vertex(String label, List<Edge> edges, int distance, Vertex predecessor) {
        this.label = label;
        this.edges = edges;
        this.distance = distance;
        this.predecessor = predecessor;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return distance == vertex.distance &&
                Objects.equals(label, vertex.label) &&
                Objects.equals(edges, vertex.edges) &&
                Objects.equals(predecessor, vertex.predecessor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, edges, distance, predecessor);
    }
}