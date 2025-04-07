import CNr.C2Nr;
import CNr.C3Nr;

public static void main(String[] args) {
    C2Nr calculator2Nr = new C2Nr(5.0, 3.0);
    double suma2 = calculator2Nr.suma();
    System.out.println("Suma a doua numere (" + calculator2Nr.getNr1() + " + " + calculator2Nr.getNr2() + "): " + suma2);

    calculator2Nr.setNr1(10.0);
    calculator2Nr.setNr2(7.5);
    suma2 = calculator2Nr.suma();
    System.out.println("Noua suma a doua numere (" + calculator2Nr.getNr1() + " + " + calculator2Nr.getNr2() + "): " + suma2);

    C3Nr calculator3Nr = new C3Nr(2.0, 4.0, 6.0);
    double suma3 = calculator3Nr.suma();
    System.out.println("Suma a trei numere (" + calculator3Nr.getNr1() + " + " + calculator3Nr.getNr2() + " + " + calculator3Nr.getNr3() + "): " + suma3);

    calculator3Nr.setNr1(1.5);
    calculator3Nr.setNr2(3.5);
    calculator3Nr.setNr3(5.5);
    suma3 = calculator3Nr.suma();
    System.out.println("Noua suma a trei numere (" + calculator3Nr.getNr1() + " + " + calculator3Nr.getNr2() + " + " + calculator3Nr.getNr3() + "): " + suma3);

}