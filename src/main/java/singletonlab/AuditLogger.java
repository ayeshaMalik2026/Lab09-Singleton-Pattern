package singletonlab;

public class AuditLogger {
    private static AuditLogger instance;

    private AuditLogger() {
        System.out.println("[AuditLogger] Constructing instance on thread: " + Thread.currentThread().getName());
    }

    public static AuditLogger getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            instance = new AuditLogger();
        }
        return instance;
    }
}