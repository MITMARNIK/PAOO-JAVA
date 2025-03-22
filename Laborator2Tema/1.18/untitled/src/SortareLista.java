import java.util.ArrayList; //este folosit pentru a crea o lista dinamica de numere intregi
import java.util.Collections; //contine metode utile precum sort;
import java.util.List;  //este interfata pentru liste;

public class SortareLista {
    public static void main(String[] args) {
        List<Integer> listaNumere = new ArrayList<>(); //creaza o lista goala de numere intregi
        listaNumere.add(1); //adauga numere in lista
        listaNumere.add(3);
        listaNumere.add(7);
        listaNumere.add(5);
        listaNumere.add(2);

        System.out.println("Lista neordonata " + listaNumere);

        Collections.sort(listaNumere); // sorteaza lista crescator
        System.out.println("Lista ordonata " + listaNumere);
    }
}