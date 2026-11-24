package singletonlab;

public class Task1Main {
    public static void main(String[] args) {
        DatabaseConnectionManager studentPortalDb = DatabaseConnectionManager.getInstance();
        DatabaseConnectionManager feeBillingDb = DatabaseConnectionManager.getInstance();
        DatabaseConnectionManager attendanceDb = DatabaseConnectionManager.getInstance();

        System.out.println("StudentPortal Identity HashCode:   " + System.identityHashCode(studentPortalDb));
        System.out.println("FeeBillingService Identity HashCode: " + System.identityHashCode(feeBillingDb));
        System.out.println("AttendanceTracker Identity HashCode: " + System.identityHashCode(attendanceDb));

        studentPortalDb.executeQuery("StudentPortal", "SELECT * FROM students WHERE id = 101");
        feeBillingDb.executeQuery("FeeBillingService", "SELECT balance FROM fee_ledger WHERE student_id = 101");
        attendanceDb.executeQuery("AttendanceTracker", "INSERT INTO attendance VALUES (101, CURRENT_DATE, 'P')");

        boolean sameRef1 = (studentPortalDb == feeBillingDb);
        boolean sameRef2 = (feeBillingDb == attendanceDb);

        System.out.println("studentPortalDb == feeBillingDb: " + sameRef1);
        System.out.println("feeBillingDb == attendanceDb: " + sameRef2);
        System.out.println("Total constructor invocations: " + DatabaseConnectionManager.getInstanceCount());
    }
}