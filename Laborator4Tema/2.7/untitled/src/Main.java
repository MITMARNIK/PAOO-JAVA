import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Student {
    private String nume;

    public Student(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    // Simuleaza trimiterea prezentei (random)
    public String trimitePrezenta() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return "prezent";
        } else {
            return "absent";
        }
    }
}

class Curs {
    private String numeCurs;
    private List<Student> studentiInscrisi;

    public Curs(String numeCurs) {
        this.numeCurs = numeCurs;
        this.studentiInscrisi = new ArrayList<>();
    }

    public void inscrieStudent(Student student) {
        studentiInscrisi.add(student);
    }

    public void prezenta() {
        System.out.println("Prezenta la cursul: " + numeCurs);
        for (Student student : studentiInscrisi) {
            String status = student.trimitePrezenta();
            System.out.println("Student: " + student.getNume() + ", Status: " + status);
        }
        System.out.println("--- Sfarsit prezenta ---");
    }

    public static void main(String[] args) {
        Curs programare = new Curs("Programare Java");

        Student ion = new Student("Ion Popescu");
        Student ana = new Student("Ana Maria");
        Student andrei = new Student("Andrei Georgescu");

        programare.inscrieStudent(ion);
        programare.inscrieStudent(ana);
        programare.inscrieStudent(andrei);

        System.out.println("Apelare prezenta 1:");
        programare.prezenta();

        System.out.println("\nApelare prezenta 2:");
        programare.prezenta();

        System.out.println("\nApelare prezenta 3:");
        programare.prezenta();
    }
}