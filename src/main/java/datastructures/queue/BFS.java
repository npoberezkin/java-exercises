package datastructures.queue;

import datastructures.queue.Tree.Node;

import java.util.LinkedList;

public class BFS {

    public static void main(String[] args) {
        Tree<String> tree = new Tree<>("root");
        Node<String> node_1 = tree.root().add("node_1");
        Node<String> node_2 = tree.root().add("node_2");
        node_1.add("node_1_1");
        node_1.add("node_1_2");
        node_2.add("node_2_1");
        System.out.println(tree);

        LinkedList<Node<String>> nodes = new LinkedList<>();
        nodes.add(tree.root());
        while (!nodes.isEmpty()) {
            Node<String> frontier = nodes.remove();
            frontier.visit();
            nodes.addAll(frontier.getChildren());
            System.out.println(tree);
        }
    }
}
