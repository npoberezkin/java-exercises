package datastructures.graph;

public class Edge {

    private int weight;
    private Vertex source;
    private Vertex target;

    public Edge(int weight, Vertex source, Vertex target) {
        this.weight = weight;
        this.source = source;
        this.target = target;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getTarget() {
        return target;
    }

    public void setTarget(Vertex target) {
        this.target = target;
    }
}
