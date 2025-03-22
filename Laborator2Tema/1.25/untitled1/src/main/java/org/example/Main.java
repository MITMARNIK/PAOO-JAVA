package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String url = "https://www.ucv.ro";
        try {
            // 1. Descarcă pagina HTML
            Document doc = Jsoup.connect(url).get();

            // 2. Selectează elementul care conține titlul știrilor
            // Această parte este specifică structurii HTML a paginii
            // Va trebui să inspectezi pagina web pentru a găsi selectorul corect
            Elements titluriStiri = doc.select(".o_stire"); // exemplu de selector CSS

            // 3. Extrage primul titlu
            if (!titluriStiri.isEmpty()) {
                Element primulTitlu = titluriStiri.first();
                String textTitlu = primulTitlu.text();
                System.out.println("Primul titlu din stiri: " + textTitlu);
            } else {
                System.out.println("Nu s-au găsit titluri de știri.");
            }

        } catch (IOException e) {
            System.err.println("Eroare la accesarea paginii web: " + e.getMessage());
        }
    }
}