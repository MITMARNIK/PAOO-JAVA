import org.example.Config.Config;


    public static void main(String[] args) {
        // Testare
        Config config1 = Config.getInstance();
        System.out.println("Culoare (prima accesare): " + config1.getCuloare());
        System.out.println("Weight (prima accesare): " + config1.getWeight());

        Config config2 = Config.getInstance();
        System.out.println("Culoare (a doua accesare): " + config2.getCuloare());
        System.out.println("Weight (a doua accesare): " + config1.getWeight());

        System.out.println("config1 == config2: " + (config1 == config2));
    }
