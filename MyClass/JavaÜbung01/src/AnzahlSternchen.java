import java.util.Scanner;

public class AnzahlSternchen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Gib eine Zahl ein");
        int zahl = in.nextInt();
        String sternchen = "";

        for (int i =0; zahl>i; i++){
            sternchen += "* ";
        }
        System.out.println(sternchen);
    }
}
