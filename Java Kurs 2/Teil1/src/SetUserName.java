import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetUserName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while (true) {
            System.out.print("Benutzername: ");
            String input = scanner.next();
            set.add(input);
            System.out.println(set);

        }
    }
}
