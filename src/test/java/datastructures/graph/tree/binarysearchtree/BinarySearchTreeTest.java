package datastructures.graph.tree.binarysearchtree;

import datastructures.graph.tree.BinarySearchTree;
import datastructures.graph.tree.TreeTraversalOrder;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class BinarySearchTreeTest {

    @Test
    public void test() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(1);
        tree.add(6);
        tree.add(8);
        tree.add(9);
        tree.add(0);


        System.out.println("level iteration");
        Iterator<Integer> lvlIterator = tree.traverse(TreeTraversalOrder.LEVEL_ORDER);
        while (lvlIterator.hasNext()) {
            System.out.print(lvlIterator.next() + " ");
        }

        System.out.println();
        System.out.println("in order iteration");
        Iterator<Integer> inIterator = tree.traverse(TreeTraversalOrder.IN_ORDER);
        while (inIterator.hasNext()) {
            System.out.print(inIterator.next() + " ");
        }

        System.out.println();
        System.out.println("pre order iteration");
        Iterator<Integer> preIterator = tree.traverse(TreeTraversalOrder.PRE_ORDER);
        while (preIterator.hasNext()) {
            System.out.print(preIterator.next() + " ");
        }

        System.out.println();
        System.out.println("post order iteration");
        Iterator<Integer> postIterator = tree.traverse(TreeTraversalOrder.POST_ORDER);
        while (postIterator.hasNext()) {
            System.out.print(postIterator.next() + " ");
        }

        System.out.println();
        System.out.print("removing 11: " + tree.remove(11));

        System.out.println();
        System.out.println("removing 15: " + tree.remove(15));
        Iterator<Integer> lvlIterator2 = tree.traverse(TreeTraversalOrder.LEVEL_ORDER);
        while (lvlIterator2.hasNext()) {
            System.out.print(lvlIterator2.next() + " ");
        }

        System.out.println();
        System.out.println("removing 8: " + tree.remove(8));
        Iterator<Integer> lvlIterator3 = tree.traverse(TreeTraversalOrder.LEVEL_ORDER);
        while (lvlIterator3.hasNext()) {
            System.out.print(lvlIterator3.next() + " ");
        }

        System.out.println();
        System.out.println("removing 1: " + tree.remove(1));
        Iterator<Integer> lvlIterator4 = tree.traverse(TreeTraversalOrder.LEVEL_ORDER);
        while (lvlIterator4.hasNext()) {
            System.out.print(lvlIterator4.next() + " ");
        }

        System.out.println();
        System.out.println("removing 5: " + tree.remove(5));
        Iterator<Integer> lvlIterator5 = tree.traverse(TreeTraversalOrder.LEVEL_ORDER);
        while (lvlIterator5.hasNext()) {
            System.out.print(lvlIterator5.next() + " ");
        }
    }
}
