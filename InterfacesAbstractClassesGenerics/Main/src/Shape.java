public abstract class Shape {
    double x;
    double y;

    public abstract String getKind ();
    public abstract double getCircumference ();
    public abstract double getArea ();
    public abstract Box getBoundingBox();

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setCoordinates (double x,double y){
        this.x = x;
        this.y = y;
    }
}
