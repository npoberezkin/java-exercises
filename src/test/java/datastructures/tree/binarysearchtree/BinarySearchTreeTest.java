package datastructures.tree.binarysearchtree;

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
        Iterator<Integer> lelevIterator = tree.traverse(TreeTraversalOrder.LEVEL_ORDER);
        while (lelevIterator.hasNext()) {
            System.out.print(lelevIterator.next() +  " ");
        }

        System.out.println();
        System.out.println("in order iteration");
        Iterator<Integer> inIterator1 = tree.traverse(TreeTraversalOrder.IN_ORDER);
        while (inIterator1.hasNext()) {
            System.out.print(inIterator1.next() +  " ");
        }

        System.out.println();
        System.out.print("removing 11: " + tree.remove(11));

        System.out.println();
        System.out.println("removing 15: " + tree.remove(15));
        Iterator<Integer> inIterator2 = tree.traverse(TreeTraversalOrder.LEVEL_ORDER);
        while (inIterator2.hasNext()) {
            System.out.print(inIterator2.next() +  " ");
        }

        System.out.println();
        System.out.println("removing 8: " + tree.remove(8));
        Iterator<Integer> inIterator3 = tree.traverse(TreeTraversalOrder.LEVEL_ORDER);
        while (inIterator3.hasNext()) {
            System.out.print(inIterator3.next() +  " ");
        }

        System.out.println();
        System.out.println("removing 1: " + tree.remove(1));
        Iterator<Integer> inIterator4 = tree.traverse(TreeTraversalOrder.LEVEL_ORDER);
        while (inIterator4.hasNext()) {
            System.out.print(inIterator4.next() +  " ");
        }

        System.out.println();
        System.out.println("removing 5: " + tree.remove(5));
        Iterator<Integer> inIterator5 = tree.traverse(TreeTraversalOrder.LEVEL_ORDER);
        while (inIterator5.hasNext()) {
            System.out.print(inIterator5.next() +  " ");
        }
    }
}
