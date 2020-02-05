public class Bee implements Animal, Herbivore {

    @Override
    public String toString() {
        return "Bee";
    }

    @Override
    public void eat(Plant plant) {
        System.out.println(toString() + " eats " + plant);
    }
}
