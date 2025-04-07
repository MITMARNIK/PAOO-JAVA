import java.io.BufferedReader; // Importă clasa BufferedReader pentru a citi text dintr-un flux de intrare.
import java.io.IOException; // Importă clasa IOException pentru a gestiona erorile de intrare/ieșire.
import java.io.InputStreamReader; // Importă clasa InputStreamReader pentru a converti fluxul de octeți într-un flux de caractere.
import java.net.HttpURLConnection; // Importă clasa HttpURLConnection pentru a realiza conexiuni HTTP.
import java.net.URL; // Importă clasa URL pentru a reprezenta adresele web.

public class WebHelper {

    private static WebHelper instance; // Declară o variabilă statică pentru a stoca singura instanță a clasei.
    private String websiteContent; // Declară o variabilă pentru a stoca conținutul paginii web.
    private boolean contentLoaded = false; // Declară o variabilă booleană pentru a urmări dacă conținutul a fost deja încărcat.
    private final String websiteUrl = "https://central.sonatype.com/artifact/org.json/json/20230227"; // Declară și inițializează URL-ul paginii web care va fi încărcată. Este marcat ca final deoarece nu se va schimba.

    private WebHelper() {
        // Constructor privat pentru a preveni instanțierea directă a clasei din exterior.
        // Aceasta este o parte esențială a modelului Singleton.
    }

    public static WebHelper getInstance() {
        // Metodă statică publică pentru a obține instanța unică a clasei WebHelper.
        if (instance == null) {
            instance = new WebHelper(); // Dacă instanța nu există, o creează. Aceasta se întâmplă doar la prima apelare.
        }
        return instance; // Returnează instanța existentă (sau nou creată).
    }

    public String getWebSiteContent() {
        // Metodă publică pentru a obține conținutul paginii web.
        if (!contentLoaded) {
            websiteContent = loadWebsiteContent(); // Dacă conținutul nu a fost încărcat, îl încarcă.
            contentLoaded = true; // Marchează conținutul ca fiind încărcat pentru a evita reîncărcarea ulterioară.
            System.out.println("Continutul paginii web a fost încarcat.");
        } else {
            System.out.println("Continutul paginii web a fost deja încarcat.");
        }
        return websiteContent; // Returnează conținutul paginii web (încărcat sau deja existent).
    }

    private String loadWebsiteContent() {
        // Metodă privată pentru a încărca efectiv conținutul paginii web de la URL.
        StringBuilder content = new StringBuilder(); // Utilizează StringBuilder pentru a construi eficient conținutul text.
        HttpURLConnection connection = null; // Declară o variabilă pentru conexiunea HTTP.
        BufferedReader reader = null; // Declară o variabilă pentru cititorul de flux.

        try {
            URL url = new URL(websiteUrl); // Creează un obiect URL din șirul websiteUrl.
            connection = (HttpURLConnection) url.openConnection(); // Deschide o conexiune HTTP către URL.
            connection.setRequestMethod("GET"); // Setează metoda de cerere la GET (pentru a obține date).

            int responseCode = connection.getResponseCode(); // Obține codul de răspuns HTTP de la server.
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Dacă codul de răspuns este 200 (OK), înseamnă că cererea a avut succes.
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); // Creează un BufferedReader pentru a citi răspunsul de la server.
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n"); // Citește fiecare linie din răspuns și o adaugă la StringBuilder.
                }
            } else {
                // Dacă codul de răspuns nu este OK, afișează un mesaj de eroare.
                System.err.println("Eroare la încarcarea paginii web. Cod de răspuns: " + responseCode);
                return ""; // Returnează un șir gol în caz de eroare.
            }
        } catch (IOException e) {
            // Prinde excepțiile de intrare/ieșire care pot apărea în timpul procesului de încărcare.
            System.err.println("Eroare I/O la încarcarea paginii web: " + e.getMessage());
            return ""; // Returnează un șir gol în caz de eroare.
        } finally {
            // Bloc finally pentru a asigura că resursele sunt închise, indiferent dacă a apărut o excepție sau nu.
            if (reader != null) {
                try {
                    reader.close(); // Închide BufferedReader-ul dacă a fost deschis.
                } catch (IOException e) {
                    System.err.println("Eroare la inchiderea reader-ului: " + e.getMessage());
                }
            }
            if (connection != null) {
                connection.disconnect(); // Deconectează conexiunea HTTP dacă a fost stabilită.
            }
        }
        return content.toString(); // Returnează conținutul paginii web ca un șir.
    }

    public static void main(String[] args) {
        // Metoda main pentru a demonstra funcționalitatea clasei WebHelper.
        WebHelper helper1 = WebHelper.getInstance(); // Obține prima instanță a clasei WebHelper.
        String content1 = helper1.getWebSiteContent(); // Obține conținutul paginii web prin prima instanță.
        System.out.println("Continut (prima accesare):\n" + content1.substring(0, Math.min(content1.length(), 200)) + "..."); // Afișează primele 200 de caractere ale conținutului (sau tot conținutul dacă este mai scurt).

        WebHelper helper2 = WebHelper.getInstance(); // Obține a doua instanță a clasei WebHelper. Deoarece este Singleton, va fi aceeași instanță ca helper1.
        String content2 = helper2.getWebSiteContent(); // Obține conținutul paginii web prin a doua instanță. De data aceasta, conținutul ar trebui să fie deja încărcat.
        System.out.println("\nContinut (a doua accesare):\n" + content2.substring(0, Math.min(content2.length(), 200)) + "..."); // Afișează primele 200 de caractere ale conținutului (sau tot conținutul dacă este mai scurt).

        System.out.println("\nhelper1 == helper2: " + (helper1 == helper2)); // Verifică dacă cele două variabile referă la aceeași instanță a obiectului. Rezultatul ar trebui să fie true.
    }
}