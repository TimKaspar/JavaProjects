import java.util.Scanner;
import java.util.*;

public class NavigatebleSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NavigableSet<String> set = new TreeSet<String>();
        String input = "";
        while (!input.contains("lol")) {
            System.out.print("Benutzername: ");
            input = scanner.next();
            set.add(input);
            System.out.println(set);

        }
        String input2 = scanner.next();
        for (String s:set) {
            if (s.startsWith(input2)){
                System.out.print(s+",");
            }
        }
    }
}
