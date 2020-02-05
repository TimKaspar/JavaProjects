import java.util.Scanner;

public class AnzahlWoerter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int leerschlaege = 0;
        while (input.contains(" ")){
                int indexofString = input.indexOf(" ");
                input = input.substring(indexofString+1);
                leerschlaege++;

        }
        System.out.println("Die Engabe entählt " + (leerschlaege + 1) + " wörter");
        //sike
    }
}
