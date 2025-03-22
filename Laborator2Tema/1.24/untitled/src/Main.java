//Considerați un fișier care poate conține numere întregi, float sau șiruri
//oarecare. Scrieți o clasă care calculează suma tuturor numerelor întregi din fișier, ignorându-le pe toate
//celelalte. Tratați excepțiile.

import java.io.BufferedReader; //este folosit pentru citirea linie cu linie
import java.io.IOException; //se foloseste pentru tratarea exceptiilor la nivel de fisier
import java.io.FileReader; //se foloseste pentru citirea din fisier
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String numeFisier = "date.txt";
        int suma = 0;

        try(BufferedReader reader = new BufferedReader(new FileReader(numeFisier))){
            String line;
            while((line = reader.readLine()) != null){
                Scanner sc = new Scanner(line);
                while(sc.hasNext()){
                    if(sc.hasNextInt()){
                        suma = suma + sc.nextInt();
                    }else{
                        sc.next();
                    }
                }
                sc.close();
            }
            System.out.println("Suma numerelor intregi este: " + suma);
        }catch(IOException e){
            System.err.println("Eroare la citirea fisierului " + e.getMessage());

        }catch (NumberFormatException e){
            System.err.println("Eroare de formatare a numarului " + e.getMessage());
        }
    }
}