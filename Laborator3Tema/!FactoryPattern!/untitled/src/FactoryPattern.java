//Factory Pattern creează obiecte fără ca codul care le folosește să știe exact ce clasă va fi
// instanțiată, oferind o interfață pentru creare și lăsând subclaselor să decidă tipul.

// 1. Produs (interfață)
interface Vehicle {
    void start();
}

// 2. Produse Concrete
class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car is starting.");
    }
}

class Truck implements Vehicle {
    @Override
    public void start() {
        System.out.println("Truck is starting.");
    }
}

class Motorcycle implements Vehicle {
    @Override
    public void start() {
        System.out.println("Motorcycle is starting.");
    }
}

// 3. Fabrica Simplă
class VehicleFactory {
    public Vehicle createVehicle(String type) {
        if ("car".equalsIgnoreCase(type)) {
            return new Car();
        } else if ("truck".equalsIgnoreCase(type)) {
            return new Truck();
        } else if ("motorcycle".equalsIgnoreCase(type)) {
            return new Motorcycle();
        }
        return null; // Sau arunca o excepție pentru tipuri necunoscute
    }
}

// 4. Client
public class FactoryPattern {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();

        Vehicle car = factory.createVehicle("car");
        if (car != null) {
            car.start();
        }

        Vehicle truck = factory.createVehicle("truck");
        if (truck != null) {
            truck.start();
        }

        Vehicle bike = factory.createVehicle("motorcycle");
        if (bike != null) {
            bike.start();
        }

        Vehicle unknown = factory.createVehicle("scooter");
        if (unknown == null) {
            System.out.println("Unknown vehicle type.");
        }
    }
}