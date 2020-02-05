import java.util.Scanner;

public class BenutzerBegrüssen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Guten Tag. Wie heisst du?");
        String name = in.next();
        System.out.println("Sali "+ name);
    }
}
