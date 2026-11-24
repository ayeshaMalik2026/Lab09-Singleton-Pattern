package singletonlab;

public class NetworkingLab2 {
    private final PrintSpooler spooler = PrintSpooler.getInstance();

    public void submitJob() {
        spooler.addPrintJob("NetworkingLab2", "Packet_Capture_Trace.pcapng");
    }

    public PrintSpooler getSpooler() {
        return spooler;
    }
}