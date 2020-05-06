package datastructures.queue;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {
    private Node<T> root;

    public Tree(T data) {
        root = new Node<T>(null, data);
        root.children = new ArrayList<>();
    }

    public Node<T> root() {
        return root;
    }

    public static class Node<T> {
        private Node<T> parent;
        private List<Node<T>> children;
        private T data;
        private Boolean visited;

        public Node(Node<T> parent, T data) {
            this.parent = parent;
            this.children = new ArrayList<>();
            this.data = data;
            this.visited = false;
        }

        public Node<T> add(T data) {
            Node<T> newNode = new Node<>(this, data);
            this.children.add(newNode);
            return newNode;
        }

        public void visit() {
            if (visited) {
                System.out.println("already visited");
            }
            visited = true;
        }

        public List<Node<T>> getChildren() {
            return children;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.data + " - " + this.visited + "\n");
            for (Node<T> node : this.children) {
                stringBuilder.append(node.toString());
            }
            return stringBuilder.toString();
        }
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
