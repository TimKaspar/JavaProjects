import java.util.Scanner;

public class Ziel100 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double anfangszahl = Math.round(Math.random() * 300 / 10 + 16);
        int spieler = 1;
        System.out.println("Gebt abwechslungsweise eine Zahl zwischen 1 und 10 ein.");
        System.out.println("Die Anfangszahl ist: "+ anfangszahl);
        while(anfangszahl<100){
            if (anfangszahl%2 ==0){
                System.out.println("Spieler 1! Zahl eingeben.");
                anfangszahl += in.nextInt();
                spieler = 1;
            }else{
                System.out.println("Spieler 2! Zahl eingeben.");
                anfangszahl +=in.nextInt();
                spieler = 2;
            }
            System.out.println("Die Zahl ist "+anfangszahl+"!");
        }
        if (spieler == 1){
            System.out.println("Spieler 1! Hat gewonnen.");
        }else{
            System.out.println("Spieler 2! Zahl eingeben.");
        }
    }
}
