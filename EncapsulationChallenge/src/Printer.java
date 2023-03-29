public class Printer {
    private int tonerLevel;
    private long pagesPrinted;
    private boolean duplex;


    public Printer() {
        this(0,0,false);
    }

    public Printer(int tonerLevel, long pagesPrinted, boolean duplex) {
        this.tonerLevel = tonerLevel;
        this.pagesPrinted = pagesPrinted;
        this.duplex = duplex;
    }

    public int addToner (int tonerAmount){
        int newTonerLevel = tonerLevel+tonerAmount;

        if (newTonerLevel < 0 || newTonerLevel > 100){
            System.out.println("Invalid amount of toner being added!");
            return - 1;
        }

        tonerLevel = newTonerLevel;
        System.out.println("Toner level set to: " + tonerLevel);
        return newTonerLevel;
    }

    public void printPages(int numberOfPagesToPrint){
        if (tonerLevel <= 0){
            System.out.println("Insufficient toner amount!");
            return;
        }
        int sheetsNeeded = calculateSheetsNeeded(numberOfPagesToPrint);
        System.out.println("Printing " + numberOfPagesToPrint  + " pages, using " + sheetsNeeded + " sheets of paper.");

        addPagesPrintedCount(sheetsNeeded);
        System.out.println("Total number of sheets printed on this device: " + getPagesPrinted());
    }

    private int calculateSheetsNeeded(int numberOfPagesToPrint){
        return (duplex) ? (numberOfPagesToPrint/2 + numberOfPagesToPrint%2) : numberOfPagesToPrint;
    }

    private void addPagesPrintedCount(int pageCountToAdd){
        setPagesPrinted(pagesPrinted+pageCountToAdd);
    }

    private void setPagesPrinted(long pagesPrinted) {
        this.pagesPrinted = pagesPrinted;
    }

    private long getPagesPrinted() {
        return pagesPrinted;
    }
}
