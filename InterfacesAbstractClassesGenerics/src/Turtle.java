public class Turtle implements Animal, Herbivore{

    @Override
    public String toString() {
        return "Turtle";
    }

    @Override
    public void eat(Plant plant){
        System.out.println(toString() +" eats "+ plant);
    }
}
