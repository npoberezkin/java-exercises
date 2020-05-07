/**
 * This file contains an implementation of a Binary Search Tree (BST) Any comparable data is allowed
 * within this tree (numbers, strings, comparable Objects, etc...). Supported operations include
 * adding, removing, height, and containment checks. Furthermore, multiple tree traversal Iterators
 * are provided including: 1) Preorder traversal 2) Inorder traversal 3) Postorder traversal 4)
 * Levelorder traversal
 */
package datastructures.tree.binarysearchtree;

import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<T>> {

    // Tracks the number of nodes in this BST
    private int nodeCount = 0;

    // This BST is a rooted tree so we maintain a handle on the root node
    private Node root = null;

    // Internal node containing node references
    // and the actual node data
    private class Node {
        T data;
        Node left, right;

        public Node(Node left, Node right, T elem) {
            this.data = elem;
            this.left = left;
            this.right = right;
        }
    }

    // Check if this binary tree is empty
    public boolean isEmpty() {
        return size() == 0;
    }

    // Get the number of nodes in this binary tree
    public int size() {
        return nodeCount;
    }

    // Add an element to this binary tree. Returns root.
    public Node add(T val) {
        root = add(root, val);
        nodeCount++;
        return root;
    }

    // Private method to recursively add a value in the binary tree
    private Node add(Node node, T val) {

        if (node == null) {
            node = new Node(null, null, val);
        } else if (val.compareTo(node.data) <= 0) {
            node.left = add(node.left, val);
        } else {
            node.right = add(node.right, val);
        }

        return node;
    }

    // Remove a value from this binary tree if it exists, O(n)
    public boolean remove(T val) {
        if (contains(val)) {
            root = remove(root, val);
            nodeCount--;
            return true;
        }
        return false;
    }

    private Node remove(Node node, T elem) {
        return null; // TODO
    }

    // returns true is the element exists in the tree
    public boolean contains(T val) {
        return contains(root, val);
    }

    // private recursive method to find an element in the tree
    private boolean contains(Node node, T val) {

        // Base case: reached bottom, value not found
        if (node == null) return false;

        int cmp = val.compareTo(node.data);

        // Dig into the left subtree because the value we're
        // looking for is smaller than the current value
        if (cmp < 0) return contains(node.left, val);

            // Dig into the right subtree because the value we're
            // looking for is greater than the current value
        else if (cmp > 0) return contains(node.right, val);

            // We found the value we were looking for
        else return true;
    }

    // This method returns an iterator for a given TreeTraversalOrder.
    // The ways in which you can traverse the tree are in four different ways:
    // preorder, inorder, postorder and levelorder.
    public Iterator<T> traverse(TreeTraversalOrder order) {
        switch (order) {
            case PRE_ORDER:
                return null;
            case IN_ORDER:
                return inOrderTraversal();
            case POST_ORDER:
                return null;
            case LEVEL_ORDER:
                return null;
            default:
                return null;
        }
    }

    private Iterator<T> inOrderTraversal() {

        final Stack<Node> stack = new java.util.Stack<>();
        stack.push(root);

        return new Iterator<T>() {
            Node trav = root;

            @Override
            public boolean hasNext() {
                return root != null && !stack.isEmpty();
            }

            @Override
            public T next() {

                // Dig left
                while (trav != null && trav.left != null) {
                    stack.push(trav.left);
                    trav = trav.left;
                }

                Node node = stack.pop();

                // Try moving down right once
                if (node.right != null) {
                    stack.push(node.right);
                    trav = node.right;
                }

                return node.data;
            }
        };
    }
}
