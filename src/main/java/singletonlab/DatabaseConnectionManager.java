package singletonlab;

public class DatabaseConnectionManager {
    private static DatabaseConnectionManager instance;
    private static int instanceCount = 0;

    private DatabaseConnectionManager() {
        instanceCount++;
        System.out.println("[DB Init] Connection pool initialized. Total instances created: " + instanceCount);
    }

    public static DatabaseConnectionManager getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionManager();
        }
        return instance;
    }

    public void executeQuery(String moduleName, String sql) {
        System.out.println("[" + moduleName + "] Executing SQL: " + sql);
    }

    public static int getInstanceCount() {
        return instanceCount;
    }
}