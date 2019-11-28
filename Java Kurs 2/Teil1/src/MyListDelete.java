import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyListDelete {
    public static void main(String[] args) {

        List<String> texte = new ArrayList<>();
        texte.add("hallo");
        texte.add("gruezi");
        texte.add("guete Tag");
        texte.add("sali");
        Scanner scanner = new Scanner(System.in);
        System.out.println("ramove:");
        String input = scanner.next();
        texte.remove(input);


    }
}
