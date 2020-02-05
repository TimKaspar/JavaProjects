import java.util.List;

public interface CompoundMonkey<Monkey> {

    void add(Monkey monkey);

    void remove(Monkey monkey);

    List<Monkey> List();
}
