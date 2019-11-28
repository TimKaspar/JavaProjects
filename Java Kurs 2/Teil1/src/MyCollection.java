import java.util.Arrays;

public class MyCollection {
    public String texte[] = {};

    void einfügen(String text) {
        addElementUsingArraysCopyOf(text);
    }

    public void addElementUsingArraysCopyOf(String elementToAdd) {
        texte = Arrays.copyOf(texte, texte.length + 1);
        texte[texte.length - 1] = elementToAdd;
    }
}
