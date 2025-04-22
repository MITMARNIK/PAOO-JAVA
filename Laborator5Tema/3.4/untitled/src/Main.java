// Printer interface
interface Printer {
    void print();
}

// Scanner interface
interface Scanner {
    void scan();
}

// Fax interface
interface Fax {
    void fax();
}

// MultifunctionalPrinter interface
interface MultifunctionalPrinter extends Printer, Scanner, Fax {
}

// Concrete Printer class
class PrinterImpl implements Printer {
    public void print() {
        System.out.println("Printing a document...");
    }
}

// Concrete PrinterScanner class
class PrinterScanner implements Printer, Scanner {
    public void print() {
        System.out.println("PrinterScanner: Printing a document...");
    }

    public void scan() {
        System.out.println("PrinterScanner: Scanning a document...");
    }
}

// Concrete AllInOnePrinter class
class AllInOnePrinter implements MultifunctionalPrinter {
    public void print() {
        System.out.println("All-in-one: Printing a document...");
    }

    public void scan() {
        System.out.println("All-in-one: Scanning a document...");
    }

    public void fax() {
        System.out.println("All-in-one: Faxing a document...");
    }
}

// Main class to test the implementation
public class Main {
    public static void main(String[] args) {
        Printer printer = new PrinterImpl();
        printer.print();

        PrinterScanner printerScanner = new PrinterScanner();
        printerScanner.print();
        printerScanner.scan();

        MultifunctionalPrinter allInOne = new AllInOnePrinter();
        allInOne.print();
        allInOne.scan();
        allInOne.fax();
    }
}
