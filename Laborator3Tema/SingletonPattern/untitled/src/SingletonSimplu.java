//Singleton Pattern asigură că o clasă are
// o singură instanță în întreaga aplicație și oferă un punct unic de acces la acea instanță.

public class SingletonSimplu {

    // 1. Declarăm o instanță statică și finală a clasei SingletonSimplu.
    //    - 'static' înseamnă că această instanță aparține clasei în sine, nu oricărei instanțe a clasei.
    //    - 'final' înseamnă că, odată ce instanța este inițializată, nu mai poate fi modificată (referința nu poate fi reatribuită).
    private static final SingletonSimplu INSTANCE = new SingletonSimplu();

    // 2. Constructor privat.
    private SingletonSimplu() {
        System.out.println("Constructorul SingletonSimplu a fost apelat.");
    }

    // 3. Metodă publică statică pentru a obține instanța unică.
    //    - Această metodă returnează singura instanță creată în pasul 1.
    public static SingletonSimplu getInstance() {
        System.out.println("getInstance() a fost apelat.");
        return INSTANCE;
    }

    // 4. O metodă simplă pentru a demonstra că singleton-ul funcționează.
    public void afiseazaMesaj() {
        System.out.println("Salut! Sunt singura instanță a clasei SingletonSimplu.");
    }

    public static void main(String[] args) {

        // Obținem prima instanță a singleton-ului.
        SingletonSimplu primaInstanta = SingletonSimplu.getInstance();
        primaInstanta.afiseazaMesaj();

        System.out.println("--------------------");

        // Obținem a doua instanță a singleton-ului.
        SingletonSimplu aDouaInstanta = SingletonSimplu.getInstance();
        aDouaInstanta.afiseazaMesaj();

        // Verificăm dacă cele două referințe indică către aceeași instanță în memorie.
        if (primaInstanta == aDouaInstanta) {
            System.out.println("Ambele referințe indică către aceeași instanță. Singleton funcționează!");
        } else {
            System.out.println("Ceva nu este în regulă. Ar fi trebuit să avem o singură instanță.");
        }
    }
}