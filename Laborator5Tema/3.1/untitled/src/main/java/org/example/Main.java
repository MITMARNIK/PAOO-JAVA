//Scrieți o clasa pentru rezolvarea ecuației de gradul I. Salvați soluția in format
//JSON. Faceți re-design la soluție astfel în fișierul final JSON sa se
// reflecte toate situațiile posibile. 3

package org.example;
import EcuatieGradulI.EcuatieGradulI;

public class Main {
    public static void main(String[] args) {
        EcuatieGradulI ecuatie = new EcuatieGradulI();

        // Cazul cu o singura solutie
        String solutie1 = ecuatie.rezolva(2, -4);
        System.out.println(solutie1);

        // Cazul cu infinitate de soluții
        String solutie2 = ecuatie.rezolva(0, 0);
        System.out.println(solutie2);

        // Cazul fără soluții
        String solutie3 = ecuatie.rezolva(0, 5);
        System.out.println(solutie3);
    }
}