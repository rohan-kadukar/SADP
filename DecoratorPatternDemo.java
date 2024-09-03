// Component interface for Car
interface Car {
    String assemble();
}

// Concrete implementation of Car for a basic car
class BasicCar implements Car {
    @Override
    public String assemble() {
        return "Basic Car";
    }
}

// Abstract decorator class that implements Car
abstract class CarDecorator implements Car {
    protected Car decoratedCar;

    public CarDecorator(Car decoratedCar) {
        this.decoratedCar = decoratedCar;
    }

    @Override
    public String assemble() {
        return decoratedCar.assemble();
    }
}

// Concrete decorator class for adding sports features
class SportsCarDecorator extends CarDecorator {
    public SportsCarDecorator(Car decoratedCar) {
        super(decoratedCar);
    }

    @Override
    public String assemble() {
        return super.assemble() + ", with Sports Features";
    }
}

// Concrete decorator class for adding luxury features
class LuxuryCarDecorator extends CarDecorator {
    public LuxuryCarDecorator(Car decoratedCar) {
        super(decoratedCar);
    }

    @Override
    public String assemble() {
        return super.assemble() + ", with Luxury Features";
    }
}

// Main class to test the Decorator Pattern
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        // Create a basic car
        Car basicCar = new BasicCar();
        System.out.println(basicCar.assemble());

        // Decorate the basic car with sports features
        Car sportsCar = new SportsCarDecorator(new BasicCar());
        System.out.println(sportsCar.assemble());

        // Decorate the basic car with luxury features
        Car luxuryCar = new LuxuryCarDecorator(new BasicCar());
        System.out.println(luxuryCar.assemble());

        // Decorate the basic car with both sports and luxury features
        Car sportsLuxuryCar = new LuxuryCarDecorator(new SportsCarDecorator(new BasicCar()));
        System.out.println(sportsLuxuryCar.assemble());
    }
}
