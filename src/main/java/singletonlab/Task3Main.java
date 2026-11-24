package singletonlab;

public class Task3Main {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                AuditLogger logger = AuditLogger.getInstance();
                System.out.println(Thread.currentThread().getName() + " -> HashCode: " + System.identityHashCode(logger));
            }, "Worker-" + (i + 1));
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }
    }
}