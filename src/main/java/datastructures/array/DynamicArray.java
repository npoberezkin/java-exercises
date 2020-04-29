package datastructures.array;

import java.util.Iterator;

/**
 * Analogue of Java ArrayList.
 *
 * @param <T> type of elements in the array
 */
@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {

    private int len;
    private int capacity;
    private T[] arr;

    public DynamicArray() {
        this(16);
    }

    public DynamicArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity should be more than 0");
        }
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public T get(int index) {
        return arr[index];
    }

    public void set(int index, T elem) {
        arr[index] = elem;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            arr[i] = null;
        }
        len = 0;
    }

    public void add(T elem) {
        if (len >= capacity) {
            capacity *= 2;
            T[] newArr = (T[]) new Object[capacity];
            if (len >= 0) {
                System.arraycopy(arr, 0, newArr, 0, len);
            }
            arr = newArr;
        }
        arr[len++] = elem;
    }

    public T remove(int ind) {
        if (ind < 0 || ind >= len) {
            throw new IndexOutOfBoundsException();
        }
        T oldElem = arr[ind];
        int numMoved = len - ind - 1;
        if (numMoved > 0) {
            System.arraycopy(arr, ind + 1, arr, ind, numMoved);
        }
        arr[--len] = null;
        return oldElem;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int ind = 0;

            @Override
            public boolean hasNext() {
                return ind < len;
            }

            @Override
            public T next() {
                return arr[ind++];
            }
        };
    }
}
