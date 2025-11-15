public class FactoryMain {

    public static void main(String[] args) {
        ShapeFactory factory = new CircleFactory();
        Shape shape = factory.createShape();
        shape.draw();

        factory = new RectangleFactory();
        shape = factory.createShape();
        shape.draw();
    }
}

// Product Interface
interface Shape {
    void draw();
}

// Concrete Products
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

// Concrete Products
class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}


// Creator
abstract class ShapeFactory {
    public abstract Shape createShape();
}

// Concrete Creators
class CircleFactory extends ShapeFactory {
    public Shape createShape() {
        return new Circle();
    }
}

class RectangleFactory extends ShapeFactory {
    public Shape createShape() {
        return new Rectangle();
    }
}
