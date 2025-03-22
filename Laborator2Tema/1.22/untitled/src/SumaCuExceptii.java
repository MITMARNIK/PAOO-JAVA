//Calculați suma a două numere citite de la tastatură. Folosiți Excepții și NULL.

import java.util.Scanner; //se foloseste pentru a citi numere de la tastatura

public class SumaCuExceptii {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer numar1 = null;
        Integer numar2 = null;

        try {
            System.out.print("Introduceti primul numar: ");
            if (scanner.hasNextInt()) { //verifica daca numarul este intreg
                numar1 = scanner.nextInt();
            } else {
                throw new NumberFormatException("Input invalid pentru primul numar.");
            }

            System.out.print("Introduceti al doilea numar: ");
            if (scanner.hasNextInt()) {
                numar2 = scanner.nextInt();
            } else {
                throw new NumberFormatException("Input invalid pentru al doilea numar.");
            }

            if (numar1 == null || numar2 == null) {
                throw new NullPointerException("Unul sau ambele numere sunt null.");
            }

            int suma = numar1 + numar2;
            System.out.println("Suma este: " + suma);

        } catch (NumberFormatException e) {
            System.out.println("Eroare: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Eroare: " + e.getMessage());
        } finally {
            scanner.close(); // Inchide scanner-ul pentru a elibera resursele
        }
    }
}