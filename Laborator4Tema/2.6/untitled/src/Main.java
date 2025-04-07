class Product {
    private int id;
    private String name;
    private double priceUSD;

    public Product(int id, String name, double priceUSD) {
        this.id = id;
        this.name = name;
        this.priceUSD = priceUSD;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPriceUSD() {
        return priceUSD;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priceUSD=" + priceUSD +
                '}';
    }
}

class Produs {
    private int id;
    private String nume;
    private double pretLei;

    public Produs(int id, String nume, double pretLei) {
        this.id = id;
        this.nume = nume;
        this.pretLei = pretLei;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public double getPretLei() {
        return pretLei;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", pretLei=" + pretLei +
                '}';
    }
}

class ProductAdapterHelper {

    private double exchangeRateUSDToRON; // Cursul de schimb USD/RON

    public ProductAdapterHelper(double exchangeRateUSDToRON) {
        this.exchangeRateUSDToRON = exchangeRateUSDToRON;
    }

    // Metoda pentru a converti un Product in Produs
    public Produs ProductToProdus(Product product) {
        int id = product.getId();
        String nume = product.getName();
        double pretLei = product.getPriceUSD() * exchangeRateUSDToRON;
        return new Produs(id, nume, pretLei);
    }

    // Metoda pentru a converti un Produs in Product
    public Product ProdusToProduct(Produs produs) {
        int id = produs.getId();
        String name = produs.getNume();
        double pretUSD = produs.getPretLei() / exchangeRateUSDToRON;
        return new Product(id, name, pretUSD);
    }

    public static void main(String[] args) {
        // Exemplu de utilizare a adaptorului
        double currentExchangeRate = 4.95; // Exemplu de curs de schimb
        ProductAdapterHelper adapter = new ProductAdapterHelper(currentExchangeRate);

        Product product = new Product(1, "Laptop", 1200.50);
        System.out.println("Product: " + product);

        Produs produs = adapter.ProductToProdus(product);
        System.out.println("Produs (dupa adaptare): " + produs);

        Produs initialProdus = new Produs(2, "Mouse", 25.00);
        System.out.println("Produs initial: " + initialProdus);

        Product convertedProduct = adapter.ProdusToProduct(initialProdus);
        System.out.println("Product (dupa adaptare): " + convertedProduct);
    }
}