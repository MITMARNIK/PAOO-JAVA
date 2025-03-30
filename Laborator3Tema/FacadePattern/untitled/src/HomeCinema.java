//Facade Pattern oferă o interfață simplificată pentru un sistem complex, ascunzând detaliile
// și făcându-l mai ușor de utilizat.

// Subsistemul simplu (două clase)
class SistemAudio {
    public void pornesteAmplificatorul() {
        System.out.println("Amplificatorul audio pornit.");
    }

    public void seteazaVolumul(int nivel) {
        System.out.println("Volumul audio setat la " + nivel);
    }

    public void opresteAmplificatorul() {
        System.out.println("Amplificatorul audio oprit.");
    }
}

class SistemVideo {
    public void pornesteProiectorul() {
        System.out.println("Proiectorul video pornit.");
    }

    public void seteazaIntrarea(String sursa) {
        System.out.println("Intrarea video setată pe " + sursa);
    }

    public void opresteProiectorul() {
        System.out.println("Proiectorul video oprit.");
    }
}

// Facade
class SistemHomeCinemaFacade {
    private SistemAudio audioSystem;
    private SistemVideo videoSystem;

    public SistemHomeCinemaFacade() {
        this.audioSystem = new SistemAudio();
        this.videoSystem = new SistemVideo();
    }

    public void pornesteFilm(String sursa) {
        System.out.println("Pregătire pentru vizionare film...");
        videoSystem.pornesteProiectorul();
        videoSystem.seteazaIntrarea(sursa);
        audioSystem.pornesteAmplificatorul();
        audioSystem.seteazaVolumul(5); // Un nivel de volum implicit
        System.out.println("Filmul a început!");
    }

    public void opresteFilm() {
        System.out.println("Oprire film...");
        videoSystem.opresteProiectorul();
        audioSystem.opresteAmplificatorul();
        System.out.println("Sistemul home cinema este oprit.");
    }
}

// Client
public class HomeCinema {
    public static void main(String[] args) {
        SistemHomeCinemaFacade homeCinema = new SistemHomeCinemaFacade();

        // Clientul folosește o singură metodă a facade-ului pentru a efectua o operațiune complexă.
        homeCinema.pornesteFilm("Blu-ray Player");

        System.out.println("\n--- După ce am terminat ---");

        // Clientul folosește o altă metodă simplă pentru a opri totul.
        homeCinema.opresteFilm();
    }
}