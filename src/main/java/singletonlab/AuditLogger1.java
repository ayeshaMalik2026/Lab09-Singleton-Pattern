package singletonlab;

public class AuditLogger1 {
    private static volatile AuditLogger1 instance;

    private AuditLogger1() {
        System.out.println("[AuditLogger1] Constructing single safe instance on thread: " + Thread.currentThread().getName());
    }

    public static AuditLogger1 getInstance() {
        if (instance == null) {
            synchronized (AuditLogger1.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    instance = new AuditLogger1();
                }
            }
        }
        return instance;
    }
}