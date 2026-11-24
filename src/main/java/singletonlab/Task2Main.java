package singletonlab;

public class Task2Main {
    public static void main(String[] args) {
        SoftwareLab1 lab1 = new SoftwareLab1();
        NetworkingLab2 lab2 = new NetworkingLab2();

        lab1.submitJobs();
        lab2.submitJob();

        System.out.println("Total pending jobs before processing: " + PrintSpooler.getInstance().getPendingJobCount());

        while (PrintSpooler.getInstance().getPendingJobCount() > 0) {
            PrintSpooler.getInstance().processNextJob();
        }

        System.out.println("Final pending job count: " + PrintSpooler.getInstance().getPendingJobCount());
    }
}