package interview.concurrency.threads;

/**
 * You have thread T1, T2, and T3, how will you ensure that thread T2 run after T1 and thread T3 run after T2?
 */
public class ThreadsOrder {

    private static class ParallelTask implements Runnable {

        Thread predecessor;

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "started");
            if (predecessor != null) {
                try {
                    predecessor.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "finished");
        }

        public void setPredecessor(Thread predecessor) {
            this.predecessor = predecessor;
        }
    }

    public static void main(String[] args) {
        ParallelTask p1 = new ParallelTask();
        ParallelTask p2 = new ParallelTask();
        ParallelTask p3 = new ParallelTask();

        Thread t1 = new Thread(new ParallelTask(), "T1");
        Thread t2 = new Thread(new ParallelTask(), "T2");
        Thread t3 = new Thread(new ParallelTask(), "T3");

        p2.setPredecessor(t1);
        p3.setPredecessor(t2);

        t1.start();
        t2.start();
        t3.start();
    }
}
