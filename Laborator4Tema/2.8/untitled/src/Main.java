import java.util.ArrayList;
import java.util.List;

interface AparatElectric {
    String getNume();
    void conectat();
    void deconectat();
}

class AparatCafea implements AparatElectric {
    private String nume = "Aparat de cafea";

    @Override
    public String getNume() {
        return nume;
    }

    @Override
    public void conectat() {
        System.out.println(nume + " a fost conectat la curent.");
    }

    @Override
    public void deconectat() {
        System.out.println(nume + " a fost deconectat de la curent.");
    }
}

class Frigider implements AparatElectric {
    private String nume = "Frigider";

    @Override
    public String getNume() {
        return nume;
    }

    @Override
    public void conectat() {
        System.out.println(nume + " a fost conectat la curent.");
    }

    @Override
    public void deconectat() {
        System.out.println(nume + " a fost deconectat de la curent.");
    }
}

class Televizor implements AparatElectric {
    private String nume = "Televizor";

    @Override
    public String getNume() {
        return nume;
    }

    @Override
    public void conectat() {
        System.out.println(nume + " a fost conectat la curent.");
    }

    @Override
    public void deconectat() {
        System.out.println(nume + " a fost deconectat de la curent.");
    }
}

class Prelungitor {
    private List<AparatElectric> aparateConectate;

    public Prelungitor() {
        this.aparateConectate = new ArrayList<>();
    }

    public void conecteazaAparat(AparatElectric aparat) {
        aparateConectate.add(aparat);
        System.out.println(aparat.getNume() + " a fost conectat la prelungitor.");
    }

    public void deconecteazaAparat(AparatElectric aparat) {
        aparateConectate.remove(aparat);
        System.out.println(aparat.getNume() + " a fost deconectat de la prelungitor.");
    }

    public void conecteazaLaPriza() {
        System.out.println("\nPrelungitorul a fost bagat in priza.");
        for (AparatElectric aparat : aparateConectate) {
            aparat.conectat();
        }
    }

    public void scoateDinPriza() {
        System.out.println("\nPrelungitorul a fost scos din priza.");
        for (AparatElectric aparat : aparateConectate) {
            aparat.deconectat();
        }
    }

    public static void main(String[] args) {
        Prelungitor prelungitor = new Prelungitor();

        AparatCafea cafea = new AparatCafea();
        Frigider frigider = new Frigider();
        Televizor televizor = new Televizor();

        prelungitor.conecteazaAparat(cafea);
        prelungitor.conecteazaAparat(frigider);
        prelungitor.conecteazaAparat(televizor);

        prelungitor.conecteazaLaPriza();
        prelungitor.scoateDinPriza();
    }
}