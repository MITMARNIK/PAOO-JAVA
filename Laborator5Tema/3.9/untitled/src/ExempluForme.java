import java.util.List;

// Interfață pentru toate formele geometrice care pot avea o arie.
interface Calculabil {
    double arie(); // Metoda pentru calcularea ariei.
}

class Cerc implements Calculabil {
    private double raza;

    public Cerc(double raza) {
        this.raza = raza;
    }

    @Override
    public double arie() {
        return Math.PI * raza * raza;
    }
}

class Patrat implements Calculabil {
    private double latura;

    public Patrat(double latura) {
        this.latura = latura;
    }

    @Override
    public double arie() {
        return latura * latura;
    }
}

class Dreptunghi implements Calculabil {
    private double lungime;
    private double latime;

    public Dreptunghi(double lungime, double latime) {
        this.lungime = lungime;
        this.latime = latime;
    }

    @Override
    public double arie() {
        return lungime * latime;
    }
}

// Clasă responsabilă cu calcularea ariei totale a unei liste de forme.
class CalculatorArie {
    public double arieTotala(List<? extends Calculabil> forme) {
        double total = 0;
        for (Calculabil forma : forme) {
            total += forma.arie();
        }
        return total;
    }
}

public class ExempluForme {
    public static void main(String[] args) {
        Cerc cerc = new Cerc(5);
        Patrat patrat = new Patrat(4);
        Dreptunghi dreptunghi = new Dreptunghi(6, 3);

        List<Calculabil> forme = List.of(cerc, patrat, dreptunghi);

        CalculatorArie calculator = new CalculatorArie();
        double arieTotala = calculator.arieTotala(forme);

        System.out.println("Aria cercului: " + cerc.arie());
        System.out.println("Aria patratului: " + patrat.arie());
        System.out.println("Aria dreptunghiului: " + dreptunghi.arie());
        System.out.println("Aria totala a formelor: " + arieTotala);
    }
}