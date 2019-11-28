import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyListContainsElement {
    public static void main(String[] args) {

        List<String> texte = new ArrayList<>();
        texte.add("hallo");
        texte.add("gruezi");
        texte.add("guete Tag");
        texte.add("sali");
        Scanner scanner = new Scanner(System.in);
        System.out.println("check:");
        String input = scanner.next();
        if (texte.contains(input)){
            System.out.println("ist enthalten");
        }else {
            System.out.println("ist nicht entahlten");
        }



    }
}
