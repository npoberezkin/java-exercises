package datastructures.stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T> implements Iterable<T> {

    LinkedList<T> elements = new LinkedList<>();

    // Create an empty stack
    public Stack() {
    }

    // Create a Stack with an initial element
    public Stack(T firstElem) {
        push(firstElem);
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public void push(T elem) {
        elements.addLast(elem);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.removeLast();
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.peekLast();
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }
}
