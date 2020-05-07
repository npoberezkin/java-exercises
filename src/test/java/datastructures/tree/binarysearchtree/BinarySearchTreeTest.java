package datastructures.tree.binarysearchtree;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class BinarySearchTreeTest {

    @Test
    public void test() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(6);
        tree.add(4);
        tree.add(10);
        tree.add(2);
        tree.add(5);

        Iterator<Integer> iterator = tree.traverse(TreeTraversalOrder.IN_ORDER);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
