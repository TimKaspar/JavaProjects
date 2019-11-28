import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class getWordPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int leerschlaege = 0;
        List<String> lines = new LinkedList<>();
        String input;
        do {
            input = scanner.nextLine();
            lines.add(input);

        } while (input.length() > 0);
        String line = "";
        System.out.println("nach welchem Wort wollen Sie suchen");
        String wort = scanner.next();
        int zeile = 1;
        for (String x : lines) {
            zeile++;
            if (x.contains(wort)) {
                line = x;
                break;
            }
        }
        String[] rest = line.split(wort);
        line = rest[0];
        System.out.println(line);

        while (line.contains(" ")){
            int indexofString = line.indexOf(" ");
            line = line.substring(indexofString+1);
            leerschlaege++;

        }
        System.out.println("Das wort ist das " + (leerschlaege + 1) + ". in der " + (zeile - 1) + " Zeile");
    }
}