package datastructures.stack.exercise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Only for the purpose of learning, not good implementation
 */
public class TwoQueuesStack {

    Queue<Object> q1 = new LinkedList<>();
    Queue<Object> q2 = new LinkedList<>();
    Boolean sw = true;

    public void push(Object o) {
        if (o == null) throw new IllegalArgumentException();
        q1.offer(o);
    }

    public Object pop() {
        if (sw) {
            if (q1.isEmpty()) {
                throw new RuntimeException();
            }
            while (q1.size() > 1) {
                q2.offer(q1.poll());
            }
            sw = !sw;
            return q1.poll();
        } else {
            if (q2.isEmpty()) {
                throw new RuntimeException();
            }
            while (q2.size() > 1) {
                q1.offer(q2.poll());
            }
            sw = !sw;
            return q2.poll();
        }
    }

    public static void main(String[] args) {
        TwoQueuesStack twoQueuesStack = new TwoQueuesStack();
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();
        System.out.println("1-push:" + o1.hashCode());
        System.out.println("2-push:" + o2.hashCode());
        System.out.println("3-push:" + o3.hashCode());
        twoQueuesStack.push(o1);
        twoQueuesStack.push(o2);
        twoQueuesStack.push(o3);
        System.out.println("1-pop:" + twoQueuesStack.pop().hashCode());
        System.out.println("2-pop:" + twoQueuesStack.pop().hashCode());
        System.out.println("3-pop:" + twoQueuesStack.pop().hashCode());
    }
}
