import java.util.Scanner;

public class ScannerBeispiel {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Bahnhof Zürich Stadelhofen \n Wohin möchten");
        String destination = in.next();
        System.out.println("Sie haben "+destination+" gewält.");
        System.out.println("Erste oder zweite Klasse?");
        String klasse = in.next();
        System.out.println("sie haben "+klasse+"Klasse gewält.");
        System.out.println("....");
        in.close();
    }
}
