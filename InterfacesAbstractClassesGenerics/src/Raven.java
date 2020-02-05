public class Raven implements Animal, Omnivore {

    @Override
    public String toString() {
        return "Raven";
    }

    @Override
    public void eat(Meat meat) {
        System.out.println(toString() + " eats " + meat);
    }

    @Override
    public void eat(Plant plant) {
        System.out.println(toString() + " eats " + plant);
    }
}
