import java.util.LinkedList;
import java.util.List;

public class BaseCompound<A extends Animal> implements Compound<A> {

    private  List<A> animals = new LinkedList<>();

    @Override
    public void add(A animal) {
        animals.add(animal);
    }

    @Override
    public void remove(A animal) {
        animals.remove(animal);
    }

    @Override
    public List<A> list() {
        return animals;
    }
}
