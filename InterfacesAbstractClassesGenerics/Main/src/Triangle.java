public class Triangle extends Shape {
    @Override
    public String getKind() {
        return "Ein Dreieck";
    }

    @Override
    public double getCircumference() {
        return 23.5;
    }

    @Override
    public double getArea() {
        return 45.5;
    }

    @Override
    public Box getBoundingBox() {
        return null;
    }
}
