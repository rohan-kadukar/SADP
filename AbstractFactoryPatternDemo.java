// Shape interface
interface Shape {
    void draw();
}

// Concrete implementations of Shape for 2D shapes
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle.");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle.");
    }
}

// Concrete implementations of Shape for 3D shapes
class Sphere implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Sphere.");
    }
}

class Cube implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Cube.");
    }
}

// Abstract Factory interface
interface ShapeFactory {
    Shape createShape(String shapeType);
}

// Concrete Factory for 2D shapes
class TwoDShapeFactory implements ShapeFactory {
    @Override
    public Shape createShape(String shapeType) {
        switch (shapeType.toLowerCase()) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            default:
                throw new IllegalArgumentException("Unknown shape type: " + shapeType);
        }
    }
}

// Concrete Factory for 3D shapes
class ThreeDShapeFactory implements ShapeFactory {
    @Override
    public Shape createShape(String shapeType) {
        switch (shapeType.toLowerCase()) {
            case "sphere":
                return new Sphere();
            case "cube":
                return new Cube();
            default:
                throw new IllegalArgumentException("Unknown shape type: " + shapeType);
        }
    }
}

// Factory Producer to get the factories
class FactoryProducer {
    public static ShapeFactory getFactory(String choice) {
        switch (choice.toLowerCase()) {
            case "2d":
                return new TwoDShapeFactory();
            case "3d":
                return new ThreeDShapeFactory();
            default:
                throw new IllegalArgumentException("Unknown factory type: " + choice);
        }
    }
}

// Main class to test the Abstract Factory Pattern
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        // Get 2D shape factory
        ShapeFactory twoDFactory = FactoryProducer.getFactory("2d");

        // Create and draw 2D shapes
        Shape circle = twoDFactory.createShape("circle");
        circle.draw();

        Shape rectangle = twoDFactory.createShape("rectangle");
        rectangle.draw();

        System.out.println();

        // Get 3D shape factory
        ShapeFactory threeDFactory = FactoryProducer.getFactory("3d");

        // Create and draw 3D shapes
        Shape sphere = threeDFactory.createShape("sphere");
        sphere.draw();

        Shape cube = threeDFactory.createShape("cube");
        cube.draw();
    }
}
