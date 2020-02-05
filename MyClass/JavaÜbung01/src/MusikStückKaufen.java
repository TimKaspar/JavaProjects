import java.util.Scanner;

public class MusikStückKaufen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Wie viel Stücke wollen Sie?");
        int anzahl = in.nextInt();
        int preis = 0;
        for (int i = 0; i<anzahl;i++){
            if (i>5 && i<=35){
                preis +=20;
            }else if (i>35){
                preis += 15;
            }
            System.out.println(i +". "+ preis);

        }
        System.out.println("Total: "+preis+" CHF");
    }
}
