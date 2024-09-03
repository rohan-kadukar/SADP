// Strategy interface for flying behavior
interface FlyBehavior {
    void fly();
}

// Concrete implementation of FlyBehavior for flying with wings
class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("I'm flying with wings!");
    }
}

// Concrete implementation of FlyBehavior for flying with no way
class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("I can't fly.");
    }
}

// Strategy interface for quacking behavior
interface QuackBehavior {
    void quack();
}

// Concrete implementation of QuackBehavior for normal quacking
class Quack implements QuackBehavior {
    public void quack() {
        System.out.println("Quack! Quack!");
    }
}

// Concrete implementation of QuackBehavior for silent quacking
class MuteQuack implements QuackBehavior {
    public void quack() {
        System.out.println("<< Silence >>");
    }
}

// Duck class that uses the strategy pattern
class Duck {
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    // Constructor to set initial behaviors
    public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    // Method to perform flying behavior
    public void performFly() {
        flyBehavior.fly();
    }

    // Method to perform quacking behavior
    public void performQuack() {
        quackBehavior.quack();
    }

    // Method to display Duck information
    public void display() {
        System.out.println("I'm a duck!");
    }
}

// Main class to test the Strategy Pattern
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Duck mallard = new Duck(new FlyWithWings(), new Quack());
        mallard.display();
        mallard.performFly();
        mallard.performQuack();

        System.out.println();

        Duck rubberDuck = new Duck(new FlyNoWay(), new MuteQuack());
        rubberDuck.display();
        rubberDuck.performFly();
        rubberDuck.performQuack();
    }
}
