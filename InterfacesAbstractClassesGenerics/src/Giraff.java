public class Giraff implements Animal, Herbivore {

    @Override
    public String toString() {
        return "Giraff";
    }

    @Override
    public void eat(Plant plant) {
        System.out.println(toString() + " eats " + plant);
    }
}
