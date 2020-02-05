import java.util.List;

public interface CompoundGorilla<Gorilla extends CompoundMonkey> {

    void add(Gorilla gorilla);

    void remove(Gorilla gorilla);


    List<Gorilla> List();
}
