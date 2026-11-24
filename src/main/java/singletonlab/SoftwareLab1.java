package singletonlab;

public class SoftwareLab1 {
    private final PrintSpooler spooler = PrintSpooler.getInstance();

    public void submitJobs() {
        spooler.addPrintJob("SoftwareLab1", "Lab09_Report.pdf");
        spooler.addPrintJob("SoftwareLab1", "UML_Class_Diagram.png");
    }

    public PrintSpooler getSpooler() {
        return spooler;
    }
}