import java.util.Scanner;

public class ZahlenTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String zahl = in.next();

        if (Integer.parseInt(zahl) > 0){
            System.out.println("Die zahl ist Positiv");
        }else if (Integer.parseInt(zahl) < 0){
            System.out.println("Die zahl ist negativ");
        }
    }
}
