import java.util.List;

public interface Compound<A extends Animal> {

    void add(A animal);

    void remove(A animal);

    List<A> list();
}
