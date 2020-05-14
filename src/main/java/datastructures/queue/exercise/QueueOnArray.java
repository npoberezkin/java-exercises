package datastructures.queue.exercise;

public class QueueOnArray {

    private int capacity;
    int[] elements;
    int head;
    int tail;
    int size;

    public QueueOnArray(int capacity) {
        this.capacity = capacity;
        head = -1;
        tail = -1;
        elements = new int[this.capacity];
    }

    /**
     * this method is used to add element in the queue
     *
     * @param data
     */
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("queue is full");
        } else {
            tail++;
            if (tail == capacity) {
                tail = 0;
                System.out.println("tail jumped");
            }
            elements[tail] = data;
            size++;
            System.out.println(data + " added to the queue");
        }
    }

    /**
     * This method removes an element from the front of the queue
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException();
        } else {
            head++;
            if (head == capacity) {
                head = 0;
                System.out.println("head jumped");
            }
            size--;
            return elements[head];
        }
    }

    private int size() {
        return Math.abs(tail - head) + 1;
    }

    /**
     * This method is use to check if element is full or not
     *
     * @return boolean
     */
    public boolean isFull() {
        if (this.size == capacity) {
            return true;
        }
        return false;
    }

    /**
     * This method is use to check if element is empty or not
     *
     * @return
     */
    public boolean isEmpty() {

        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public static void main(String a[]) {
        QueueOnArray queue = new QueueOnArray(5);
        queue.enqueue(6);
        System.out.println(queue.dequeue());
        queue.enqueue(3);
        queue.enqueue(99);
        queue.enqueue(56);
        queue.enqueue(43);
        queue.enqueue(89);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(32);
        queue.enqueue(232);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
