import java.lang.Math;

class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public double modulus() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }
}

interface DoubleToComplexAdapter {
    ComplexNumber adapt(double realPart);
}

interface ComplexToDoubleAdapter {
    double adapt(ComplexNumber complexNumber);
}

class DefaultDoubleToComplexAdapter implements DoubleToComplexAdapter {
    @Override
    public ComplexNumber adapt(double realPart) {
        return new ComplexNumber(realPart, 0.0); // Presupunem partea imaginara 0
    }
}

class ModulusComplexToDoubleAdapter implements ComplexToDoubleAdapter {
    @Override
    public double adapt(ComplexNumber complexNumber) {
        return complexNumber.modulus();
    }
}

class ComplexNumberOperations {

    private DoubleToComplexAdapter doubleToComplexAdapter;
    private ComplexToDoubleAdapter complexToDoubleAdapter;

    public ComplexNumberOperations(DoubleToComplexAdapter doubleToComplexAdapter, ComplexToDoubleAdapter complexToDoubleAdapter) {
        this.doubleToComplexAdapter = doubleToComplexAdapter;
        this.complexToDoubleAdapter = complexToDoubleAdapter;
    }

    // Metoda 1: Adauga un numar real la un numar complex
    public ComplexNumber addRealToComplex(double realNumber, ComplexNumber complexNumber) {
        ComplexNumber adaptedReal = doubleToComplexAdapter.adapt(realNumber);
        return new ComplexNumber(complexNumber.getReal() + adaptedReal.getReal(), complexNumber.getImaginary() + adaptedReal.getImaginary());
    }

    // Metoda 2: Compara un numar complex cu un numar real (verifica daca modulul numarului complex este egal cu numarul real)
    public boolean compareComplexToReal(ComplexNumber complexNumber, double realNumber) {
        double adaptedModulus = complexToDoubleAdapter.adapt(complexNumber);
        return adaptedModulus == realNumber;
    }

    // Metoda 3: Creeaza un numar complex cu partea reala data de un double
    public ComplexNumber createComplexFromReal(double realPart) {
        return doubleToComplexAdapter.adapt(realPart);
    }

    // Metoda 4: Obtine modulul unui numar complex ca un double
    public double getModulusAsDouble(ComplexNumber complexNumber) {
        return complexToDoubleAdapter.adapt(complexNumber);
    }

    // Metoda 5: Verifica daca modulul unui numar complex este mai mare decat un double
    public boolean isModulusGreaterThanDouble(ComplexNumber complexNumber, double realNumber) {
        double adaptedModulus = complexToDoubleAdapter.adapt(complexNumber);
        return adaptedModulus > realNumber;
    }

    // Metoda 6: Scade un numar real (adaptat la complex) dintr-un numar complex
    public ComplexNumber subtractRealFromComplex(ComplexNumber complexNumber, double realNumber) {
        ComplexNumber adaptedReal = doubleToComplexAdapter.adapt(realNumber);
        return new ComplexNumber(complexNumber.getReal() - adaptedReal.getReal(), complexNumber.getImaginary() - adaptedReal.getImaginary());
    }

    // Metoda 7: Compara modulele a doua numere complexe (folosind adapterul ComplexToDouble)
    public boolean compareComplexModule(ComplexNumber c1, ComplexNumber c2) {
        double modulus1 = complexToDoubleAdapter.adapt(c1);
        double modulus2 = complexToDoubleAdapter.adapt(c2);
        return modulus1 == modulus2;
    }

    // Metoda 8: Verifica daca modulul unui numar complex este egal cu modulul altuia (folosind adapterul ComplexToDouble)
    public boolean areModulesEqual(ComplexNumber c1, ComplexNumber c2) {
        return compareComplexModule(c1, c2); // Reutilizam metoda existenta
    }

    public static void main(String[] args) {
        // Cream adaptoarele
        DoubleToComplexAdapter doubleToComplexAdapter = new DefaultDoubleToComplexAdapter();
        ComplexToDoubleAdapter complexToDoubleAdapter = new ModulusComplexToDoubleAdapter();

        // Cream instanta clasei care utilizeaza adaptoarele
        ComplexNumberOperations operations = new ComplexNumberOperations(doubleToComplexAdapter, complexToDoubleAdapter);

        // Cream cateva numere complexe
        ComplexNumber c1 = new ComplexNumber(3.0, 4.0);
        ComplexNumber c2 = new ComplexNumber(5.0, 0.0);

        // Testam metodele
        System.out.println("Numarul complex c1: " + c1);
        System.out.println("Numarul complex c2: " + c2);

        double realNum = 5.0;
        System.out.println("\nAdaugam " + realNum + " la " + c1 + ": " + operations.addRealToComplex(realNum, c1));
        System.out.println("Modulul lui " + c1 + " este egal cu " + realNum + "? " + operations.compareComplexToReal(c1, realNum));
        System.out.println("Cream un numar complex din " + realNum + ": " + operations.createComplexFromReal(realNum));
        System.out.println("Modulul lui " + c1 + " ca double: " + operations.getModulusAsDouble(c1));
        System.out.println("Modulul lui " + c1 + " este mai mare decat " + 4.0 + "? " + operations.isModulusGreaterThanDouble(c1, 4.0));
        System.out.println("Scadem " + 2.0 + " din " + c1 + ": " + operations.subtractRealFromComplex(c1, 2.0));
        System.out.println("Modulele lui " + c1 + " si " + c2 + " sunt egale? " + operations.compareComplexModule(c1, c2));
        System.out.println("Modulele lui " + c1 + " si " + c2 + " sunt egale? (folosind areModulesEqual) " + operations.areModulesEqual(c1, c2));
    }
}