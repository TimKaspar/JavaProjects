public class Human implements Animal, Omnivore {

    @Override
    public void eat(Plant plant) {
        System.out.println(toString() + " eats " + plant);
    }

    @Override
    public void eat(Meat meat) {
        System.out.println(toString() + " eats " + meat);
    }

    @Override
    public String toString() {
        return "Human";
    }
}
