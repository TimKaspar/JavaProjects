import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OutputMyIntListAsArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integer = new ArrayList<>();
        while (true) {
            System.out.println("Eingabe:");
            int input = scanner.nextInt();
            integer.add(input);
            Integer toOtherArray[] = new Integer[integer.size()];
            toOtherArray = integer.toArray(toOtherArray);
                System.out.println(integer);

        }
    }
}

