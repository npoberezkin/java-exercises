package datastructures.tree;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    private class Node {
        Node left, right;
        Integer data;

        Node(Node left, Node right, Integer data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }

    Node root;

    public boolean add(Integer data) {
        if (data == null) {
            System.out.println("data should not be null");
            return false;
        }
        if (root == null) {
            root = new Node(null, null, data);
            System.out.println("added root " + data);
            return true;
        }
        Node trav = root;
        LinkedList<Node> nodes = new LinkedList<>();
        while (trav.left != null && trav.right != null) {
            nodes.offer(trav.left);
            nodes.offer(trav.right);
            trav = nodes.poll();
        }
        if (trav.left == null) {
            trav.left = new Node(null, null, data);
            System.out.println("added left child " + data);
        } else if (trav.right == null) {
            trav.right = new Node(null, null, data);
            System.out.println("added right child " + data);
        }
        return true;
    }

    public Iterator<Integer> traverse(TreeTraversalOrder order) {
        switch (order) {
            case PRE_ORDER: {
                return preOrderTraversal();
            }
            case IN_ORDER: {
                return inOrderTraversal();
            }
            case POST_ORDER: {
                return postOrderTraversal();
            }
            case LEVEL_ORDER: {
                return lvlOrderTraversal();
            }
            default:
                throw new IllegalArgumentException();
        }
    }

    private Iterator<Integer> preOrderTraversal() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        return new Iterator<Integer>() {
            private Node trav;

            @Override
            public boolean hasNext() {
                return root != null && !stack.isEmpty();
            }

            @Override
            public Integer next() {
                trav = stack.pop();

                if (trav.right != null) {
                    stack.push(trav.right);
                }
                if (trav.left != null) {
                    stack.push(trav.left);
                }

                return trav.data;
            }
        };
    }

    private Iterator<Integer> inOrderTraversal() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        return new Iterator<Integer>() {
            Node trav = root;

            @Override
            public boolean hasNext() {
                return root != null && !stack.isEmpty();
            }

            @Override
            public Integer next() {
                while (trav.left != null) {
                    stack.push(trav.left);
                    trav = trav.left;
                }

                Node node = stack.pop();

                if (node.right != null) {
                    stack.push(node.right);
                    trav = node.right;
                }

                return node.data;
            }
        };
    }

    private Iterator<Integer> postOrderTraversal() {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            stack2.push(node);
            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }

        return new Iterator<Integer>() {
            Node trav = root;

            @Override
            public boolean hasNext() {
                return !stack2.isEmpty();
            }

            @Override
            public Integer next() {
                return stack2.pop().data;
            }
        };
    }

    private Iterator<Integer> lvlOrderTraversal() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return root != null && !queue.isEmpty();
            }

            @Override
            public Integer next() {
                Node node = queue.poll();

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

                return node.data;
            }
        };
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.add(7);
        tree.add(10);
        tree.add(2);
        tree.add(4);
        tree.add(6);

        System.out.println("pre order");
        Iterator<Integer> preOrderTraversal = tree.traverse(TreeTraversalOrder.PRE_ORDER);
        while (preOrderTraversal.hasNext()) {
            System.out.print(preOrderTraversal.next());
        }

        System.out.println();
        System.out.println("in order");
        Iterator<Integer> inOrderTraversal = tree.traverse(TreeTraversalOrder.IN_ORDER);
        while (inOrderTraversal.hasNext()) {
            System.out.print(inOrderTraversal.next());
        }

        System.out.println();
        System.out.println("post order");
        Iterator<Integer> postOrderTraversal = tree.traverse(TreeTraversalOrder.POST_ORDER);
        while (postOrderTraversal.hasNext()) {
            System.out.print(postOrderTraversal.next());
        }

        System.out.println();
        System.out.println("level order");
        Iterator<Integer> levelOrderTraversal = tree.traverse(TreeTraversalOrder.LEVEL_ORDER);
        while (levelOrderTraversal.hasNext()) {
            System.out.print(levelOrderTraversal.next());
        }
    }
}
