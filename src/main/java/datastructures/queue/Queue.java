package datastructures.queue;

import java.util.Iterator;
import java.util.LinkedList;

public class Queue<T> implements Iterable<T> {

    private LinkedList<T> elements;

    public Queue() {
        this.elements = new LinkedList<>();
    }

    public void add(T e) {
        elements.add(e);
    }

    public T remove() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return elements.remove();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }
}
