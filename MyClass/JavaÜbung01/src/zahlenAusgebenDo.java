import java.util.Scanner;

public class zahlenAusgebenDo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int zahl = 1;
        do{
            System.out.println(zahl);
            zahl++;
        } while(zahl <101);
    }
}
