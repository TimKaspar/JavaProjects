import java.util.Scanner;

public class Anstossen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int anzahl = sc.nextInt();
        int myInt =function1(anzahl);
        System.out.println(myInt);
    }

    private static int function1(int anzahl) {
        anzahl -= 1;
        if (anzahl == 0){
            return 0;
        }
        return anzahl+function1(anzahl);
    }
}
