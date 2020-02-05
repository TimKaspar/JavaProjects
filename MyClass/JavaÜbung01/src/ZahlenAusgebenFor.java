import java.util.Scanner;

public class ZahlenAusgebenFor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int zahl = 1;
        for (var i = 0; zahl < 100;i++ ){
            System.out.println(zahl);
            zahl++;
        }
    }
}
