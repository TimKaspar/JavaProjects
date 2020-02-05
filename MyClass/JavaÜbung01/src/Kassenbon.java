import java.util.Scanner;

public class Kassenbon {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String produkt1 = "Wurst";
        String produkt2 = "Käse";
        String produkt3 = "Salat";
        String produkt4 = "Brot";
        double preis1 = 3.30;
        double preis2 = 4.50;
        double preis3 = 7.50;
        double preis4 = 4.00;

        System.out.println("Wie viel "+ produkt1+" möchten Sie?");
        String anzahl1 = in.next();
        System.out.println("Wie viel "+ produkt2+" möchten Sie?");
        String anzahl2 = in.next();
        System.out.println("Wie viel "+ produkt3+" möchten Sie?");
        String anzahl3 = in.next();
        System.out.println("Wie viel "+ produkt4+" möchten Sie?");
        String anzahl4 = in.next();


        System.out.println(produkt1 +"\t"+ anzahl1+" * "+preis1+" CHF = "+ preis1 * Integer.parseInt(anzahl1));
        System.out.println(produkt2 +"\t"+ anzahl2+" * "+preis2+" CHF = "+ preis2 * Integer.parseInt(anzahl2));
        System.out.println(produkt3 +"\t"+ anzahl3+" * "+preis3+" CHF = "+ preis3 * Integer.parseInt(anzahl3));
        System.out.println(produkt4 +"\t"+ anzahl4+" * "+preis4+" CHF = "+ preis4 * Integer.parseInt(anzahl4));

        System.out.println("----------------------------------- \n Gesamt");
        System.out.println( preis1 * Integer.parseInt(anzahl1) + preis2 * Integer.parseInt(anzahl2) + preis3 * Integer.parseInt(anzahl3) + preis4 * Integer.parseInt(anzahl4));
    }
}
