import java.util.Scanner;

public class BuchstabneEingabe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long zeit = System.currentTimeMillis();
        int punkte = 0;
        System.out.println("Tippe so viel mal n wie möglich");
        while ((zeit+5000)>System.currentTimeMillis()){
            System.out.println("Eingabe");
            String eingabe = in.next();
            if(eingabe.equals("n")){
            punkte++;
            }

    }
        System.out.println("Sie haben "+punkte+" Eingben geschaft");
}
}
