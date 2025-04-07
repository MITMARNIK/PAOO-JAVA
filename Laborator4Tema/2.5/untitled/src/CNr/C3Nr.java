package CNr;

public class C3Nr {
    private double nr1;
    private double nr2;
    private double nr3;

    public C3Nr(double nr1, double nr2, double nr3) {
        this.nr1 = nr1;
        this.nr2 = nr2;
        this.nr3 = nr3;
    }

    public double suma() {
        return nr1 + nr2 + nr3;
    }

    public double getNr1() {
        return nr1;
    }

    public void setNr1(double nr1) {
        this.nr1 = nr1;
    }

    public double getNr2() {
        return nr2;
    }

    public void setNr2(double nr2) {
        this.nr2 = nr2;
    }

    public double getNr3() {
        return nr3;
    }

    public void setNr3(double nr3) {
        this.nr3 = nr3;
    }
}

