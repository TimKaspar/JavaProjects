public class Gorilla implements Animal, Omnivore, MonkeyAnimal, AddCage {


    @Override
    public String toString() {
        return "Gorilla";
    }

    @Override
    public void eat(Meat meat) {
        System.out.println(toString() + " eats " + meat);
    }

    @Override
    public void eat(Plant plant) {
        System.out.println(toString() + " eats " + plant);
    }

    @Override
    public void add(Cage cage) {
        System.out.println(toString() + " is in " + cage);
    }
}