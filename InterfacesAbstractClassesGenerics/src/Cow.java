public class Cow implements Animal, Herbivore, Talking{

    @Override
    public String toString() {
        return "Cow";
    }

    @Override
    public void eat(Plant plant){
        System.out.println(toString() +" eats "+ plant);
    }

    @Override
    public void talk(Word word){
        System.out.println(toString()+" says "+ word);
    }
}
