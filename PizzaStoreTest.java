// Abstract Pizza class
abstract class Pizza {
    String name;

    void prepare() {
        System.out.println("Preparing " + name);
    }

    void bake() {
        System.out.println("Baking " + name);
    }

    void cut() {
        System.out.println("Cutting " + name);
    }

    void box() {
        System.out.println("Boxing " + name);
    }

    public String getName() {
        return name;
    }
}

// Concrete Pizza class for New York Style Cheese Pizza
class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        name = "Chicken Pizza";
    }
}

// Abstract PizzaStore class
abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    // Factory method
    protected abstract Pizza createPizza(String type);
}

// Concrete PizzaStore class for New York Style Pizza Store
class NYStylePizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new NYStyleCheesePizza();
        }
        // Add more pizza types here if needed
        return null;
    }
}

// Main class to test the implementation
public class PizzaStoreTest {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYStylePizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ordered a " + pizza.getName());
    }
}
