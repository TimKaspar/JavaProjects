public class Main {
    public static void main(String[] args) {
        Circle circle =  new Circle();
        Triangle triangle = new Triangle();
        Rectangle rectangle = new Rectangle();
        ShapeCollection shapeCollection = new ShapeCollection();
        shapeCollection.add(circle);
        shapeCollection.listShapes();
    }
}
