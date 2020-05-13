package datastructures.queue.priorityqueue;

import java.util.*;

/**
 * HEAP INVARIANT - it is a rule that guarantees that each parent node is ordered with respect
 * to all children nodes, for all pair of nodes in the heap. Example: if rule states that each
 * parent node is less than each child node, than it should be that way for all pairs of
 * parent/child nodes.
 *
 * @param <T> Type of heap elements.
 */
public class BinaryHeapQuickRemovals<T extends Comparable<T>> {

    List<T> heap;

    // The internal capacity of the heap
    private int heapCapacity = 0;

    /**
     * Lookup table for faster removals. We store key/value pairs in it
     * where key is the value of the element in heap and value is indexes
     * on which that element is located.
     */
    Map<T, TreeSet<Integer>> lookup = new HashMap<>();

    public BinaryHeapQuickRemovals() {
        this.heap = new ArrayList<>();
    }

    public BinaryHeapQuickRemovals(int heapSize) {
        this.heap = new ArrayList<>(heapSize);
    }

    /**
     * Add an element to the end the heap and ensure that HEAP INVARIANT(*) is satisfied.
     *
     * @param elem element to add.
     */
    public void add(T elem) {
        if (elem == null) {
            throw new IllegalArgumentException("Element can't be null");
        }

        // add element to the end of heap and elem:index to lookup table
        heap.add(elem);
        addLookup(elem, heap.size() - 1);

        swim(heap.size() - 1);
    }

    /**
     * Gets element from the head of the queue, but doesn't remove it.
     *
     * @return element on 0 position.
     */
    public T peek() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    /**
     * Gets and removes element from the head of the queue.
     *
     * @return element on 0 position.
     */
    public T poll() {
        return removeAt(0);
    }

    /**
     * Gets and removes element by its value.
     *
     * @param elem element value.
     * @return removed element.
     */
    public T remove(T elem) {
        Integer last = lookup.get(elem).last();
        return removeAt(last);
    }

    private T removeAt(int ind) {
        if (isEmpty()) {
            return null;
        }

        // swap element to remove with the last element in heap
        T swap = heap.get(ind);
        T last = heap.get(size() - 1);
        swap(ind, size() - 1);
        swapLookup(swap, last, ind, size() - 1);

        // remove last element from heap and element:index from lookup
        T removed = heap.remove(size() - 1);
        removeLookup(removed, size());

        // save elem and try to sink swapped element
        T elem = heap.get(ind);
        sink(ind);

        // if sinking didn't work, try swimming
        if (heap.get(ind).equals(elem)) {
            swim(ind);
        }

        return removed;
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void addLookup(T elem, int ind) {
        TreeSet<Integer> indexes = lookup.get(elem);

        if (indexes == null) {
            indexes = new TreeSet<>();
            indexes.add(ind);
            lookup.put(elem, indexes);
        } else {
            indexes.add(ind);
        }
    }

    private void removeLookup(T elem, int ind) {
        TreeSet<Integer> indexes = lookup.get(elem);
        indexes.remove(ind);
    }


    private void swap(int ind1, int ind2) {
        T swap = heap.get(ind1);
        heap.set(ind1, heap.get(ind2));
        heap.set(ind2, swap);
    }

    private void swapLookup(T e1, T e2, int ind1, int ind2) {
        TreeSet<Integer> vals1 = lookup.get(e1);
        vals1.remove(ind1);
        vals1.add(ind2);
        TreeSet<Integer> vals2 = lookup.get(e2);
        vals2.remove(ind2);
        vals2.add(ind1);
    }

    /**
     * Bubbles up/Pushes element with passed index higher in heap,
     * until the HEAP INVARIANT(*) is satisfied.
     *
     * @param ind index of the element to bubble up.
     */
    private void swim(int ind) {
        int parentInd = (ind - 1) / 2;
        while (ind > 0 && heap.get(parentInd).compareTo(heap.get(ind)) > 0) {
            T swap = heap.get(ind);
            T parent = heap.get(parentInd);
            swap(ind, parentInd);
            swapLookup(swap, parent, ind, parentInd);
            ind = parentInd;
            parentInd = (ind - 1) / 2;
        }
    }

    /**
     * Bubbles down/Pushes element lower in heap, until the HEAP INVARIANT(*) is satisfied.
     *
     * @param ind index of the element to sink.
     */
    private void sink(int ind) {
        while (true) {

            int left = 2 * ind + 1; // Left  node
            int right = 2 * ind + 2; // Right node
            int smallest = left; // Assume left is the smallest node of the two children

            // Find which is smaller left or right
            // If right is smaller set smallest to be right
            if (right < size() && heap.get(right).compareTo(heap.get(left)) < 0) smallest = right;

            // Stop if we're outside the bounds of the tree
            // or stop early if we cannot sink k anymore
            if (left >= size() || heap.get(ind).compareTo(heap.get(smallest)) < 0) break;

            // Move down the tree following the smallest node
            swap(smallest, ind);
            ind = smallest;
        }
    }

    // Returns index of smaller element or first if equal.
    private int less(int ind1, int ind2) {
        T e1 = heap.get(ind1);
        T e2 = heap.get(ind2);
        if (e1.compareTo(e2) > 0) {
            return ind2;
        }
        return ind1;
    }

    @Override
    public String toString() {
        return heap.toString();
    }

}
