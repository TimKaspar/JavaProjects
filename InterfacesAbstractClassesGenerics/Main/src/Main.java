import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Circle circle =  new Circle();
        Triangle triangle = new Triangle();
        Rectangle rectangle = new Rectangle();
        ShapeCollection shapeCollection = new ShapeCollection();
        shapeCollection.add(circle);
        shapeCollection.listShapes();

        Scanner  sc= new Scanner(System.in);
        System.out.printf("Shape:");
        String input = sc.next();
        System.out.printf("Enter Area");

        if (input.equals("circle")){
            Circle circle2 =  new Circle();
            circle2.setArea(Integer.parseInt(sc.next()));
            circle2.setKind((sc.next()));
            circle2.setCircumference(Integer.parseInt(sc.next()));
        }else if (input.equals("rectangle")){
            Rectangle rectangle2 = new Rectangle();
            rectangle2.setArea(Integer.parseInt(sc.next()));
            rectangle2.setKind((sc.next()));
            rectangle2.setCircumference(Integer.parseInt(sc.next()));
        }else if(input.equals("triangle")){
            Triangle triangle2 = new Triangle();
            triangle2.setArea(Integer.parseInt(sc.next()));
            triangle2.setKind(sc.next());
            triangle2.setCircumference(Integer.parseInt(sc.next()));
        }

    }
}
