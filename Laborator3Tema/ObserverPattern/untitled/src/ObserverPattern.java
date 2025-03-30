//ObserverPattern permite unui obiect (subiectul) să notifice automat mai multe alte obiecte (observatori)
//atunci când starea sa se schimbă, fără ca subiectul să știe detalii despre acești observatori.

import java.util.ArrayList;
import java.util.List;

// 1. Interfața pentru Subiect (Subject Interface)
interface Subject {
    /**
     * Atașează un observator la subiect.
     * Observatorul va fi adăugat la lista de obiecte care vor fi notificate
     * atunci când starea subiectului se schimbă.
     *
     * @param observer Observatorul care trebuie atașat.
     */
    void attach(Observer observer);

    /**
     * Detașează un observator de la subiect.
     * Observatorul va fi eliminat din lista de obiecte care vor fi notificate.
     *
     * @param observer Observatorul care trebuie detașat.
     */
    void detach(Observer observer);

    /**
     * Notifică toți observatorii atașați despre o schimbare de stare.
     * Această metodă parcurge lista de observatori și apelează metoda lor 'update()'.
     */
    void notifyObservers();
}

// 2. Interfața pentru Observator (Observer Interface)
interface Observer {
    void update(String message);
}

// 3. Subiectul concret (Concrete Subject)
class Magazin implements Subject {
    private List<Observer> clienti = new ArrayList<>();
    private String ultimulProdusAdaugat;

    public void adaugaProdus(String produs) {
        this.ultimulProdusAdaugat = produs;
        System.out.println("Magazin: A fost adăugat un nou produs - " + produs);
        notifyObservers(); // Notifică observatorii când se adaugă un produs nou.
    }

    @Override
    public void attach(Observer observer) {
        // Implementarea metodei 'attach' din interfața Subject.
        // Adaugă observatorul (clientul) la lista internă de clienți ai magazinului.
        clienti.add(observer);
        System.out.println("Magazin: Client atașat.");
    }

    @Override
    public void detach(Observer observer) {
        // Implementarea metodei 'detach' din interfața Subject.
        // Elimină observatorul (clientul) din lista internă de clienți ai magazinului.
        clienti.remove(observer);
        System.out.println("Magazin: Client detașat.");
    }

    @Override
    public void notifyObservers() {
        System.out.println("Magazin: Notifică clienții...");
        for (Observer client : clienti) {
            client.update("Un nou produs a fost adăugat: " + ultimulProdusAdaugat);
        }
    }
}

// 4. Observatorii concreți (Concrete Observers)
//    - Clase care implementează interfața Observer și reacționează la notificări.
class ClientAbonat implements Observer {
    private String nume;

    public ClientAbonat(String nume) {
        this.nume = nume;
    }

    @Override
    public void update(String message) {
        System.out.println(nume + " a primit notificarea: " + message);
        // Aici clientul poate efectua acțiuni specifice în urma notificării.
        System.out.println(nume + " este interesat de noul produs!");
    }
}

class ClientOcazional implements Observer {
    private String nume;

    public ClientOcazional(String nume) {
        this.nume = nume;
    }

    @Override
    public void update(String message) {
        System.out.println(nume + " a primit o notificare generală: " + message);
        // Acest client ar putea avea o reacție diferită sau mai puțin specifică.
        System.out.println(nume + " verifică dacă este ceva interesant.");
    }
}

// 5. Clasa principală pentru demonstrație
public class ObserverPattern {
    public static void main(String[] args) {
        // Creăm subiectul (magazinul).
        Magazin magazinOnline = new Magazin();

        // Creăm observatorii (clienții).
        Observer client1 = new ClientAbonat("Alice");
        Observer client2 = new ClientAbonat("Bob");
        Observer client3 = new ClientOcazional("Charlie");

        // Atașăm observatorii la subiect.
        magazinOnline.attach(client1);
        magazinOnline.attach(client2);
        magazinOnline.attach(client3);

        System.out.println("\n--- Se adaugă un nou produs ---");
        // Când starea subiectului se schimbă (se adaugă un produs), observatorii sunt notificați.
        magazinOnline.adaugaProdus("Laptop Gaming Ultra");

        System.out.println("\n--- Un client se dezabonează ---");
        // Un observator se poate dezabona.
        magazinOnline.detach(client2);

        System.out.println("\n--- Se adaugă un alt produs ---");
        // Doar observatorii rămași vor fi notificați.
        magazinOnline.adaugaProdus("Mouse Wireless Ergonomic");
    }
}