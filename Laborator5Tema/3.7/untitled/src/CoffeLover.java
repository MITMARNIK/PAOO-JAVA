import java.util.ArrayList;
import java.util.List;

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
    private List<CoffeMachine> coffeMachines;

    public CoffeLover() {
        this.coffeMachines = new ArrayList<>();
    }

    public void addCoffeMachine(CoffeMachine coffeMachine) {
        this.coffeMachines.add(coffeMachine);
    }

    public void setCoffeMachines(List<CoffeMachine> coffeMachines) {
        this.coffeMachines = coffeMachines;
    }

    public void makeCoffe() {
        for (int i = 0; i < 8; i++) {
            System.out.println("Making coffee - Iteration: " + (i + 1));
            coffeMachines.forEach(CoffeMachine::start);
            System.out.println("Coffee made!");
            // You can add a small delay here if needed, e.g., using Thread.sleep(1000);
        }
        System.out.println("Finished making 8 rounds of coffee.");
    }

    public static void main(String[] args) {
        CoffeLover lover = new CoffeLover();
        lover.addCoffeMachine(new SimpleCoffeMachine());
        lover.addCoffeMachine(new ComplexCoffeMachine());

        // Alternatively, you could set the list of machines at once:
        // List<CoffeMachine> machines = List.of(new SimpleCoffeMachine(), new ComplexCoffeMachine());
        // lover.setCoffeMachines(machines);

        lover.makeCoffe();
    }
}