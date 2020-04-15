public class Circle extends Shape {

    public Circle(){
        this.kind = getKind();
        this.circumference = getCircumference();
        this.area = getArea();
    }
    @Override
    public String getKind() {
        return "Ein Kreis";
    }

    @Override
    public double getCircumference() {
        return 2.3;
    }

    @Override
    public double getArea() {
        return 3.4;
    }
}
