package datastructures.priorityqueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BinaryHeapQuickRemovalTest {

    @Test
    public void defaultConstructorTest() {
        BinaryHeapQuickRemovals<Integer> queue = new BinaryHeapQuickRemovals<>();
        assertEquals(0, queue.size());
    }

    @Test
    public void sizeConstructorTest() {
        BinaryHeapQuickRemovals<Integer> queue = new BinaryHeapQuickRemovals<>(10);
        assertEquals(0, queue.size());
    }

    @Test
    public void addNullElemTest() {
        BinaryHeapQuickRemovals<Integer> queue = new BinaryHeapQuickRemovals<>();
        assertThrows(IllegalArgumentException.class, () -> queue.add(null));
    }

    @Test
    public void operations() {
        BinaryHeapQuickRemovals<Integer> queue = new BinaryHeapQuickRemovals<>();

        // adding
        queue.add(5);
        System.out.println(queue);
        queue.add(1);
        System.out.println(queue);
        queue.add(10);
        System.out.println(queue);
        queue.add(0);
        System.out.println(queue);
        queue.add(20);
        queue.add(40);
        queue.add(3);
        queue.add(5);
        queue.add(2);
        System.out.println(queue);

        // peeking
        System.out.println(queue.peek());
        System.out.println(queue.peek());

        // polling
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);

        // removing
        queue.remove(10);
        System.out.println(queue);
        queue.remove(5);
        System.out.println(queue);
    }
}
