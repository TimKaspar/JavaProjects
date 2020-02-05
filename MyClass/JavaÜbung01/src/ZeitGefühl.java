import java.util.Scanner;
import java.lang.Object;
import java.text.Format;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class ZeitGefühl {
    public static void main(String[] args) {
        DecimalFormat format = new DecimalFormat("0.#");
        boolean widerholen = true;
        while (widerholen == true) {
            Scanner in = new Scanner(System.in);
            double zufallszahl = Math.round(Math.random() * 100 / 10 + 10);
            //zeit messen
            System.out.println("Versuchen Sie möglichst genau " + format.format(zufallszahl) + " Sekunen zwischen Ihren nächsten zwei eingaben zu erreichen");
            in.next();
            long anfang = System.currentTimeMillis();
            System.out.println(anfang);
            in.next();
            long schluss = System.currentTimeMillis();
            System.out.println(schluss);
            double AbweichnungZM = zufallszahl * 1000 - (schluss - anfang);
            double AbweichnungSAM = (schluss - anfang) - zufallszahl * 1000;

            //Zeit u Abweichung ausgeben
            System.out.println("Erwartete Zeit = " + format.format(zufallszahl));
            System.out.println("Ihre Zeit = " + format.format(Math.floor((schluss - anfang) / 1000)) + " Sekunden und " + format.format((schluss - anfang) % 1000) + " Millisekunden.");
            System.out.println("Erlaubte abweichung = 1s");
            if ((schluss - anfang) < zufallszahl * 1000) {
                System.out.println("Ihre Abweichung = " + format.format(Math.floor(AbweichnungZM / 1000)) + " Sekunden und " + format.format(AbweichnungZM % 1000) + " Millisekunden.");
            } else if ((schluss - anfang) > zufallszahl * 1000) {
                System.out.println("Ihre Abweichung = " + format.format(Math.floor(AbweichnungSAM / 1000)) + " Sekunden und " + format.format(AbweichnungSAM % 1000) + " Millisekunden.");
            }
            //geschaft/nochmals versuchen
            if (((schluss - anfang) > (zufallszahl * 1000 - 1000)) && ((schluss - anfang) < (zufallszahl * 1000 + 1000))) {
                System.out.println("Super. Sie haben es geschaft");
                widerholen=  false;
            } else {
                System.out.println("Nicht ganz. Versuchen Sie es Nochmals.");
            }
        }
    }
}
