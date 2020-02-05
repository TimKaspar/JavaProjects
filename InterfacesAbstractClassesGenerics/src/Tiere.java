import java.util.List;

public class Tiere {
    public static void main(String[] args) {
        Baboon baboon = new Baboon();
        Ape ape = new Ape();
        Bee bee = new Bee();
        Giraff giraff = new Giraff();
        Raven raven = new Raven();
        Turtle turtle = new Turtle();
        Lion lion = new Lion();
        Sunflower sunflower = new Sunflower();
        Plant salad = new Salad();
        Gorilla gorilla = new Gorilla();
        CageGorilla cageGorilla = new CageGorilla();
        CageMonkey cageMonkey = new CageMonkey();

        Cow cow = new Cow();
        Word roar = new Roar();
        Word muh = new Muh();

        lion.talk(roar);
        cow.talk(muh);

        Human human = new Human();
        Meat bacon = new Bacon();
        Meat steak = new Steak();

        human.eat(bacon);
        human.eat(salad);
        human.eat(lion);

        ape.add(cageMonkey);
        baboon.add(cageMonkey);
        gorilla.add(cageGorilla);
        gorilla.add(cageMonkey);

        BaseCompound<Cow> cowFarm = new BaseCompound<>();
        cowFarm.add(cow);
        BaseCompound<Bee> beeHive = new BaseCompound<>();
        beeHive.add(bee);
        beeHive.add(bee);
        beeHive.add(bee);
        System.out.println("Beehive now contains " + beeHive.list().size() + " bee(s)");
        System.out.println("cowFarm now contains " + cowFarm.list().size() + " cow(s)");


        ape.add(cageGorilla);

        giraff.eat(sunflower);
        giraff.eat(salad);


    }
}