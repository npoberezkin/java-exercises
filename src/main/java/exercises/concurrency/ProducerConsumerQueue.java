package exercises.concurrency;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

import static java.lang.Thread.sleep;

public class ProducerConsumerQueue {

    private Queue<Integer> queue = new ArrayDeque<>();
    private int capacity = 16;

    public void offer(int number) throws InterruptedException {
        synchronized (this) {
            if (queue.size() == capacity) {
                wait();
            }
            System.out.println("producer enqueued " + number + ", queue size: " + queue.size());
            queue.offer(number);
            notify();
        }
    }

    public Integer poll() throws InterruptedException {
        synchronized (this) {
            if (queue.isEmpty()) {
                wait();
            }
            Integer number = queue.poll();
            System.out.println("consumer dequeued " + number + ", queue size: " + queue.size());
            notify();
            return number;
        }
    }

    public static void main(String[] args) {
        ProducerConsumerQueue producerConsumerQueue = new ProducerConsumerQueue();
        Thread producer = new Thread(() -> {
            Random random = new Random();
            try {
                while (true) {
                    producerConsumerQueue.offer(random.nextInt(10));
                    sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    producerConsumerQueue.poll();
                    sleep(3000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }

}
