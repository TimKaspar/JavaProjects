public class Lion implements Animal, Carnivore, Talking{

    @Override
    public String toString() {
        return "Lion";
    }

    @Override
    public void eat(Meat meat){
        System.out.println(toString() +" eats "+ meat);
    }

    @Override
    public void talk(Word word){
        System.out.println(toString()+" says "+ word);
    }
}
