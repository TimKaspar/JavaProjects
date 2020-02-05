import java.util.Scanner;

public class Schaltjahr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Gib ein Jahr ein");
        int jahrIn = in.nextInt();

        if(jahrIn % 4 == 0){
            System.out.println(jahrIn+" ist ein Schaltjahr");
        }else {
            System.out.println("Das Jahr "+jahrIn+" ist kein Schaltjahr");
        }

    }
}
