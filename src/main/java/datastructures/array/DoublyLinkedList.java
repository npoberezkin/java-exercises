package datastructures.array;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {

    int size = 0;
    Node<T> head, tail;

    public DoublyLinkedList() {
    }

    public T get(int ind) {
        Node<T> trav;
        if (ind < (size >> 1)) {
            trav = head;
            for (int i = 0; i < ind; i++) {
                trav = trav.next;
            }
        } else {
            trav = tail;
            for (int i = size - 1; i > ind; i--) {
                trav = trav.prev;
            }
        }
        return trav.value;
    }

    // O(n)
    public void clear() {
        Node<T> trav = head;
        while (trav != null) {
            Node<T> next = trav.next;
            trav.next = trav.prev = null;
            trav.value = null;
            trav = next;
        }
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // O(1)
    public void add(T elem) {
        addLast(elem);
    }

    // O(1)
    public void addLast(T elem) {
        if (isEmpty()) {
            tail = head = new Node<T>(elem, null, null);
        } else {
            tail.next = new Node<T>(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    // O(1)
    public void addFirst(T elem) {
        if (isEmpty()) {
            tail = head = new Node<T>(elem, null, null);
        } else {
            head.prev = new Node<T>(elem, null, head);
            head = head.prev;
        }
        size++;
    }

    public T peekFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        return head.value;
    }

    public T peekLast() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        return tail.value;
    }

    // O(1)
    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        T value = head.value;
        head = head.next;
        --size;
        if (isEmpty()) {
            tail = null;
        } else {
            head.prev = null;
        }
        return value;
    }

    // O(1)
    public T removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        T value = tail.value;
        tail = tail.prev;
        --size;
        if (isEmpty()) {
            head = null;
        } else {
            tail.next = null;
        }
        return value;
    }

    // O(1)
    private T remove(Node<T> node) {
        T value;
        if (node.prev == null) {
            value = removeFirst();
        } else if (node.next == null) {
            value = removeLast();
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            value = node.value;
            node.value = null;
            node = node.next = node.prev = null;
        }
        --size;
        return value;
    }

    public T removeAt(int ind) {
        if (ind < 0 || ind >= size) {
            throw new IllegalArgumentException();
        }
        T value;
        if (ind == 0) {
            value = removeFirst();
        } else if (ind == size - 1) {
            value = removeLast();
        } else {
            Node<T> trav;
            if (ind < (size >> 1)) {
                trav = head;
                for (int i = 0; i < ind; i++) {
                    trav = trav.next;
                }
            } else {
                trav = tail;
                for (int i = size - 1; i > ind; i--) {
                    trav = trav.prev;
                }
            }
            value = remove(trav);
        }
        return value;
    }

    // O(n)
    public boolean remove(T obj) {
        Node<T> trav = head;

        // Support searching for null
        if (obj == null) {
            for (trav = head; trav != null; trav = trav.next) {
                if (trav.value == null) {
                    remove(trav);
                    return true;
                }
            }
            // Search for non null object
        } else {
            for (trav = head; trav != null; trav = trav.next) {
                if (obj.equals(trav.value)) {
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }

    // Find the index of a particular value in the linked list, O(n)
    public int indexOf(Object obj) {
        int index = 0;
        Node<T> trav = head;

        // Support searching for null
        if (obj == null) {
            for (; trav != null; trav = trav.next, index++) {
                if (trav.value == null) {
                    return index;
                }
            }
            // Search for non null object
        } else
            for (; trav != null; trav = trav.next, index++) {
                if (obj.equals(trav.value)) {
                    return index;
                }
            }

        return -1;
    }

    // Check is a value is contained within the linked list
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    private static class Node<T> {
        T value;
        Node<T> prev, next;

        private Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            private Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav.next != null;
            }

            @Override
            public T next() {
                T value = trav.value;
                trav = trav.next;
                return value;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> trav = head;
        while (trav != null) {
            sb.append(trav.value + ", ");
            trav = trav.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}
