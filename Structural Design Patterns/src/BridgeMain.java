public class BridgeMain {

    public static void main(String[] args) {
        Shape redCircle = new Circle(new RedColor());
        Shape blueCircle = new Circle(new BlueColor());
        Shape blueSquare = new Square(new BlueColor());
        Shape redSquare = new Square(new RedColor());
        redCircle.draw();
        blueCircle.draw();
        redSquare.draw();
        blueSquare.draw();

    }
}
interface Color {
    void applyColor();
}
class RedColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying Red Color");
    }
}

class BlueColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying Blue Color");
    }
}


abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract void draw();
}


class Circle extends Shape {

    public Circle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.print("Drawing Circle → ");
        color.applyColor();
    }
}

class Square extends Shape {

    public Square(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.print("Drawing Square → ");
        color.applyColor();
    }
}
