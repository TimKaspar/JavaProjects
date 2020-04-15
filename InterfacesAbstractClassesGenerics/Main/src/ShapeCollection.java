import java.util.ArrayList;
import java.util.List;

public class ShapeCollection {

    private List<Shape> shapes = new ArrayList<>();


    public void add(Shape shape) {
        shapes.add(shape);
    }

    public void remove(Shape shape) {
        shapes.remove(shape);
    }

    public void listShapes() {
        for (Shape shape : shapes) {
            System.out.println("Area: " + shape.getArea() + " Kind: "+shape.getKind() + " Circumference: " + shape.getCircumference());
        }
    }

    public double getTotalCircumference() {
        double value=0;
        for (Shape shape : shapes) {
            value +=shape.getCircumference();
        }
        return value;
    }
    public double gettotalArea (){
        double value=0;
        for (Shape shape : shapes) {
            value +=shape.getArea();
        }
        return value;
    }
}
