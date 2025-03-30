//Builder Pattern este o modalitate excelentă de a gestiona crearea de obiecte complexe,
// oferind mai mult control, claritate și flexibilitate decât constructorii tradiționali.

// 1. Produs
class Mesaj {
    private String destinatar;
    private String subiect;
    private String corp;
    private boolean areAtasament;

    public Mesaj(String destinatar, String subiect, String corp, boolean areAtasament) {
        this.destinatar = destinatar;
        this.subiect = subiect;
        this.corp = corp;
        this.areAtasament = areAtasament;
    }

    // Getters (omise pentru concizie)

    @Override
    public String toString() {
        return "Destinatar: " + destinatar + "\nSubiect: " + subiect + "\nCorp: " + corp + (areAtasament ? "\nAre atașament" : "\nNu are atașament");
    }
}

// 2. Interfața Builder
interface MesajBuilder {
    MesajBuilder setDestinatar(String destinatar);
    MesajBuilder setSubiect(String subiect);
    MesajBuilder setCorp(String corp);
    MesajBuilder setAreAtasament(boolean areAtasament);
    Mesaj build();
}

// 3. Builder Concret
class MesajBuilderImpl implements MesajBuilder {
    private String destinatar;
    private String subiect;
    private String corp;
    private boolean areAtasament;

    @Override
    public MesajBuilder setDestinatar(String destinatar) {
        this.destinatar = destinatar;
        return this; // Permite chaining
    }

    @Override
    public MesajBuilder setSubiect(String subiect) {
        this.subiect = subiect;
        return this;
    }

    @Override
    public MesajBuilder setCorp(String corp) {
        this.corp = corp;
        return this;
    }

    @Override
    public MesajBuilder setAreAtasament(boolean areAtasament) {
        this.areAtasament = areAtasament;
        return this;
    }

    @Override
    public Mesaj build() {
        return new Mesaj(destinatar, subiect, corp, areAtasament);
    }
}

// 4. Client
public class BuilderPattern {
    public static void main(String[] args) {
        MesajBuilder builder = new MesajBuilderImpl();
        Mesaj mesaj1 = builder.setDestinatar("user@example.com")
                .setSubiect("Salut!")
                .setCorp("Acesta este un mesaj simplu.")
                .build();

        System.out.println("Mesaj 1:\n" + mesaj1);

        Mesaj mesaj2 = new MesajBuilderImpl()
                .setDestinatar("another@example.com")
                .setSubiect("Important")
                .setCorp("Acest mesaj are un atașament.")
                .setAreAtasament(true)
                .build();

        System.out.println("\nMesaj 2:\n" + mesaj2);

        // Se pot omite pași opționali
        Mesaj mesaj3 = new MesajBuilderImpl()
                .setDestinatar("yet.another@example.com")
                .setCorp("Un mesaj scurt.")
                .build();

        System.out.println("\nMesaj 3:\n" + mesaj3);
    }
}