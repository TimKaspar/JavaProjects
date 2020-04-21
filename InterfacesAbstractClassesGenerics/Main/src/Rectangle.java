public class Rectangle extends Shape {

    double width;
    double height;

    @Override
    public String getKind() {
        return "Ein Viereck";
    }

    @Override
    public double getCircumference() {
        return 1.1;
    }

    @Override
    public double getArea() {
        return 8.9;
    }

    @Override
    public Box getBoundingBox() {
        Box box = new Box(getX())
        return null;
    }
}
