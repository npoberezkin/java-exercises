package exercises;

import datastructures.graph.tree.BinaryTree;

public class IsBinaryTreeBST {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.add(3);
        tree.add(10);
        tree.add(2);
        tree.add(4);
        tree.add(11);

        System.out.println(tree.isBST());

        BinaryTree tree2 = new BinaryTree();
        tree2.add(5);
        tree2.add(3);
        tree2.add(7);
        tree2.add(1);
        tree2.add(4);
        tree2.add(6);
        tree2.add(8);

        System.out.println(tree2.isBST());
    }
}
