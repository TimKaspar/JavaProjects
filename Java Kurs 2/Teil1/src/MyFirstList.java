import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyFirstList {


    public static void main(String[] args) {
        List<String> texte = new ArrayList<>();
        while (true) {
            System.out.println("text eingeben");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            texte.add(input);
            for (int i = 0; i < texte.size(); i++) {
                System.out.println(texte.get(i));
            }
        }
    }
}
