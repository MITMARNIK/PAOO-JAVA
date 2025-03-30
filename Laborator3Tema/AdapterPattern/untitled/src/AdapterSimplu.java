// Interfața Target (ce așteaptă clientul)
interface ElectricitateEuropeana {
    // Definește metoda pe care aparatele europene o așteaptă pentru alimentare.
    void alimenteazaPrizaEuropeana();
}

// Interfața Adaptee (ce avem disponibil)
interface ElectricitateAmericana {
    // Definește metoda oferită de sistemul de alimentare american.
    void alimenteazaPrizaAmericana();
}

// Implementarea Adaptee-ului
class PrizaAmericana implements ElectricitateAmericana {
    // Reprezintă o priză americană existentă.
    @Override
    public void alimenteazaPrizaAmericana() {
        System.out.println("Priza americana alimentează cu 110V.");
    }
}

// Adapter-ul
class AdaptorPriza implements ElectricitateEuropeana {
    // Adapter-ul implementează interfața așteptată de client (ElectricitateEuropeana).
    ElectricitateAmericana prizaAmericana; // Conține o referință la obiectul pe care îl adaptează.

    public AdaptorPriza(ElectricitateAmericana prizaAmericana) {
        // Constructorul primește instanța adaptee-ului (priza americană).
        this.prizaAmericana = prizaAmericana;
    }

    @Override
    public void alimenteazaPrizaEuropeana() {
        // Metoda din interfața target. Aici se face adaptarea.
        System.out.println("Adaptorul transformă...");
        prizaAmericana.alimenteazaPrizaAmericana(); // Apeleză metoda adaptee-ului.
        System.out.println("...și alimentează priza europeană.");
    }
}

// Clientul
class AparatEuropean {
    // Reprezintă un aparat care funcționează cu standard european.
    ElectricitateEuropeana priza; // Depinde de interfața europeană.

    public AparatEuropean(ElectricitateEuropeana priza) {
        // Constructorul primește o implementare a interfeței europene.
        this.priza = priza;
    }

    public void porneste() {
        System.out.println("Aparatul european încearcă să pornească...");
        priza.alimenteazaPrizaEuropeana(); // Apeleză metoda din interfața așteptată.
        System.out.println("Aparatul european funcționează.");
    }
}

public class AdapterSimplu {
    public static void main(String[] args) {
        // Demonstrează utilizarea adapter-ului.
        PrizaAmericana prizaSUA = new PrizaAmericana(); // Obiectul adaptee existent.

        AdaptorPriza adaptor = new AdaptorPriza(prizaSUA); // Creăm adapter-ul, pasând adaptee-ul.

        AparatEuropean aparat = new AparatEuropean(adaptor); // Clientul folosește adapter-ul ca și cum ar fi interfața dorită.

        aparat.porneste(); // Clientul apelează metoda target, care este delegată către adaptee prin adapter.
    }
}