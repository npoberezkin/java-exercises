package datastructures.array;

public class SinglyLinkedList<T> {

    Node head;
    Node tail;

    private class Node {

        public T value;
        public Node next;

        Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public SinglyLinkedList() {
    }

    public boolean addLast(T val) {
        if (val == null) return false;
        if (isEmpty()) {
            head = tail = new Node(val, null);
        } else {
            tail.next = new Node(val, null);
            tail = tail.next;
        }
        return true;
    }

    public boolean removeLast() {
        if (isEmpty()) {
            System.out.println("list is empty");
            return false;
        }
        Node cur = head;
        if (cur.next == null) {
            head = tail = null;
            System.out.println("removed last element");
        } else {
            while (cur.next != tail) {
                cur = cur.next;
            }
            tail = cur;
            cur.next = null;
        }
        return true;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node cur = head;
        while (cur != null) {
            builder.append(cur.value + " ");
            cur = cur.next;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        System.out.println(singlyLinkedList.addLast(5));
        System.out.println(singlyLinkedList.addLast(3));
        System.out.println(singlyLinkedList.addLast(4));
        System.out.println(singlyLinkedList.addLast(6));
        System.out.println(singlyLinkedList.toString());
        System.out.println(singlyLinkedList.removeLast());
        System.out.println(singlyLinkedList.removeLast());
        System.out.println(singlyLinkedList.removeLast());
        System.out.println(singlyLinkedList.toString());
        System.out.println(singlyLinkedList.removeLast());
        System.out.println(singlyLinkedList.removeLast());
    }
}
