import java.util.Scanner;

public class KugelnSpiel {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int kugelnS1 = 100;
        int kugelnS2 = 100;
        int punkteS1 = 0;
        int punkteS2 = 0;
        int q = 0;
        for (int i = 1; i < 11; i++) {
            if (kugelnS1 > 0 && kugelnS2 > 0) {
                System.out.println("Runde " + i + " von 10");
                System.out.println("Spieler 1: Wie viel Kugeln von " + kugelnS1 + " ?");
                int kugelnInS1 = in.nextInt();
                kugelnS1 -= kugelnInS1;
                System.out.println("Spieler 2: Wie viel Kugeln von " + kugelnS2 + " ?");
                int kugelnInS2 = in.nextInt();
                kugelnS2 -= kugelnInS2;
                if (kugelnInS1 > kugelnInS2) {
                    punkteS1++;
                    System.out.println("Spieler 1 hat diese Runde gewonnen!");
                } else if (kugelnInS2 > kugelnInS1) {
                    punkteS2++;
                    System.out.println("Spieler 2 hat diese Runde gewonnen!");
                } else {
                    System.out.println("Unentschieden!");
                }
                System.out.println("Spelstand nach Runde: " + i);
                System.out.println("Spieler 1 hat " + punkteS1 + " punkte und noch " + kugelnS1 + " Kugeln.");
                System.out.println("Spieler 2 hat " + punkteS2 + " punkte und noch " + kugelnS2 + " Kugeln.");
                q++;
            }
        }
        if (kugelnS1 < 0) {
            System.out.println("Spieler 1 hat keine Kugel mehr, sommit gewinnt Spieler 2 alle übrigen Runden");
            punkteS2 += 10 - q;
        } else if (kugelnS2 < 0) {
            System.out.println("Spieler 2 hat keine Kugel mehr, sommit gewinnt Spieler 1 alle übrigen Runden");
            punkteS1 += 10 - q;
        }
        if (punkteS1 > punkteS2) {
            System.out.println("\nSpieler 1 hat gewonnen!");
        } else if (punkteS2 > punkteS1) {
            System.out.println("\nSpieler 2 hat gewonnen!");
        }else{
            System.out.println("Unentschieden!");
        }
    }
    }
