public class Box {

    double top;
    double bot;
    double left;
    double right;

    Box(double left, double right, double top, double bot){
        this.left = left;
        this.right = right;
        this.bot = bot;
        this.top = top;

    }

    public void setBot(double bot) {
        this.bot = bot;
    }

    public void setLeft(double left) {
        this.left = left;
    }

    public void setTop(double top) {
        this.top = top;
    }

    public void setRight(double right) {
        this.right = right;
    }
}
