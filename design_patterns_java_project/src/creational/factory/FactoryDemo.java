package creational.factory;

interface Shape { void draw(); }

class Circle implements Shape { public void draw() { System.out.println("Drawing a Circle"); } }
class Rectangle implements Shape { public void draw() { System.out.println("Drawing a Rectangle"); } }

class ShapeFactory {
    public Shape getShape(String type) {
        if (type.equalsIgnoreCase("circle")) return new Circle();
        if (type.equalsIgnoreCase("rectangle")) return new Rectangle();
        return null;
    }
}

public class FactoryDemo {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape s1 = factory.getShape("circle");
        Shape s2 = factory.getShape("rectangle");
        s1.draw();
        s2.draw();
    }
}