/**
 * This file contains an implementation of a Binary Search Tree (BST) Any comparable data is allowed
 * within this tree (numbers, strings, comparable Objects, etc...). Supported operations include
 * adding, removing, height, and containment checks. Furthermore, multiple tree traversal Iterators
 * are provided including: 1) Preorder traversal 2) Inorder traversal 3) Postorder traversal 4)
 * Levelorder traversal
 */
package datastructures.tree;

import datastructures.tree.TreeTraversalOrder;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
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

        if (node == null) return null;

        int cmp = elem.compareTo(node.data);

        // dig into left subtree
        if (cmp < 0) {
            node.left = remove(node.left, elem);
        }

        // dig into right subtree
        else if (cmp > 0) {
            node.right = remove(node.right, elem);
        }

        // remove element in 4 different cases: no children, only left/right, both
        else {

            // only right or no subtree
            if (node.left == null) {
                Node right = node.right;

                node.data = null;
                node.right = null;
                node.left = null;

                return right;
            }

            // only left or no subtree
            else if (node.right == null) {
                Node left = node.left;

                node.data = null;
                node.right = null;
                node.left = null;

                return left;
            }

            // both subtrees
            else {
                // Find the leftmost node in the right subtree
                Node minRight = minRight(node.right);

                // Swap the data
                node.data = minRight.data;

                // Go into the right subtree and remove the leftmost node we
                // found and swapped data with. This prevents us from having
                // two nodes in our tree with the same value.
                remove(node.right, minRight.data);
            }
        }

        return node;
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

    // Searching min in right subtree
    private Node minRight(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // This method returns an iterator for a given TreeTraversalOrder.
    // The ways in which you can traverse the tree are in four different ways:
    // preorder, inorder, postorder and levelorder.
    public Iterator<T> traverse(TreeTraversalOrder order) {
        switch (order) {
            case PRE_ORDER:
                return preOrderTraversal();
            case IN_ORDER:
                return inOrderTraversal();
            case POST_ORDER:
                return postOrderTraversal();
            case LEVEL_ORDER:
                return levelOrderTraversal();
            default:
                return null;
        }
    }

    private Iterator<T> preOrderTraversal() {

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        return new Iterator<T>() {
            Node trav = root;

            @Override
            public boolean hasNext() {
                return root != null && !stack.isEmpty();
            }

            @Override
            public T next() {

                Node node = stack.pop();

                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }

                return node.data;
            }
        };
    }

    private Iterator<T> inOrderTraversal() {

        Stack<Node> stack = new Stack<>();
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

    // Returns as iterator to traverse the tree in post order
    private java.util.Iterator<T> postOrderTraversal() {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            if (node != null) {
                stack2.push(node);
                if (node.left != null) stack1.push(node.left);
                if (node.right != null) stack1.push(node.right);
            }
        }
        return new java.util.Iterator<T>() {
            @Override
            public boolean hasNext() {
                return root != null && !stack2.isEmpty();
            }

            @Override
            public T next() {
                return stack2.pop().data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private Iterator<T> levelOrderTraversal() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        return new Iterator<T>() {
            Node trav;

            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public T next() {
                trav = queue.poll();

                if (trav != null) {
                    if (trav.left != null) {
                        queue.offer(trav.left);
                    }
                    if (trav.right != null) {
                        queue.offer(trav.right);
                    }
                }

                return trav.data;
            }
        };
    }
}
