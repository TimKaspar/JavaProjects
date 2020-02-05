import java.util.Scanner;

public class RateSpiel {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Gib eine Zahl zwischen 1-10 ein.");
        int eingabe = in.nextInt();
        while(eingabe != 6) {
            switch (eingabe) {
                case 1:
                case 2:
                case 3:
                case 9:
                case 10:

                    System.out.println("Danneben!");
                    eingabe = in.nextInt();
                    break;
                case 4:
                case 5:
                case 7:
                case 8:
                    System.out.println("Knapp danneben!");
                    eingabe = in.nextInt();
                    break;
                case 6:
                    eingabe = in.nextInt();
                    break;

            }
        }
        System.out.println("Richtig!");
    }
}
