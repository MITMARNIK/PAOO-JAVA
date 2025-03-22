//Ordonați o list/vector/etc de Student (atributele nume și notă) după atributul
//nota. Nu scrieți cod pentru a implementa nici una dintre metodele cunoscute de sortare (Quick, bubble,
//insert etc) 17

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student{
    String nume;
    int nota;

    public Student(String nume, int nota){
        this.nume = nume;
        this.nota = nota;
    }

    @Override
    public String toString(){
        return "Student{ " + "nume= " + nume + ", nota= " + nota + "}";
    }
}

public class SortareStudenti{
    public static void main(String[] args) {
        List<Student> listaStudenti = new ArrayList<>();
        listaStudenti.add(new Student("Alice", 8));
        listaStudenti.add(new Student("Martin", 9));
        listaStudenti.add(new Student("Valentin", 7));
        listaStudenti.add(new Student("Matei", 5));

        System.out.println("Lista neordonata" + listaStudenti);

        //Sortarea listei folosind Collection.sort() si un Comparator
        Collections.sort(listaStudenti, Comparator.comparingInt(student -> student.nota));
        System.out.println("Lista ordonata" + listaStudenti);
    }
}