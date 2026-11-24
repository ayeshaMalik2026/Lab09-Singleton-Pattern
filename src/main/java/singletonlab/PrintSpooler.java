package singletonlab;

import java.util.LinkedList;
import java.util.Queue;

public class PrintSpooler {
    private static PrintSpooler instance;
    private final Queue<String> jobQueue;

    private PrintSpooler() {
        this.jobQueue = new LinkedList<>();
    }

    public static PrintSpooler getInstance() {
        if (instance == null) {
            instance = new PrintSpooler();
        }
        return instance;
    }

    public void addPrintJob(String labName, String documentName) {
        String entry = labName + " -> " + documentName;
        jobQueue.add(entry);
        System.out.println("Queued: " + entry + " | Pending jobs: " + getPendingJobCount());
    }

    public String processNextJob() {
        String nextJob = jobQueue.poll();
        if (nextJob != null) {
            System.out.println("Processing (FIFO): " + nextJob + " | Remaining jobs: " + getPendingJobCount());
        } else {
            System.out.println("No print jobs in queue.");
        }
        return nextJob;
    }

    public int getPendingJobCount() {
        return jobQueue.size();
    }
}