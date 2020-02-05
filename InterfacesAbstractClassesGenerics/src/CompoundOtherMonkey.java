import java.util.List;

public interface CompoundOtherMonkey<Monkey extends CompoundMonkey> {

    void add(Monkey monkey);

    void remove(Monkey monkey);

    List<Monkey> List();
}
