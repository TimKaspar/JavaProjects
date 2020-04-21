public class Circle extends Shape{

    double radius;

    public Circle(double radius){
        this.radius = radius;
    }
    @Override
    public String getKind() {
        return "Ein Kreis";
    }

    @Override
    public double getCircumference() {
        return radius*2*3.141;
    }

    @Override
    public double getArea() {
        return radius*radius*3.141;
    }

    @Override
    public Box getBoundingBox() {
        Box box = new Box(getX()-radius,)
        return box;
    }


}
