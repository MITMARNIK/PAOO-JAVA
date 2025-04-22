interface CoffeMachine {
    void start();
}

class SimpleCoffeMachine implements CoffeMachine {
    public void start() {
        System.out.println("Simple coffee machine started.");
        // Add simple coffee making logic here
    }
}

class ComplexCoffeMachine implements CoffeMachine {
    public void start() {
        System.out.println("Complex coffee machine started.");
        // Add complex coffee making logic here
    }
}

public class CoffeLover {
    private SimpleCoffeMachine simple;
    private ComplexCoffeMachine complex;

    public CoffeLover() {
        this.simple = new SimpleCoffeMachine();
        this.complex = new ComplexCoffeMachine();
    }

    public void makeCoffe() {
        for (int i = 0; i < 8; i++) {
            System.out.println("Making coffee - Iteration: " + (i + 1));
            simple.start();
            complex.start();
            System.out.println("Coffee made!");
            // You can add a small delay here if needed, e.g., using Thread.sleep(1000);
        }
        System.out.println("Finished making 8 rounds of coffee.");
    }

    public static void main(String[] args) {
        CoffeLover lover = new CoffeLover();
        lover.makeCoffe();
    }
}