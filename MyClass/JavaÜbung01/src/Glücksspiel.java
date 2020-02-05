import java.util.Scanner;

public class Glücksspiel {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int random = (int) (Math.random()* 100);
        System.out.println("Erste Zahl");
        int zahl1 = in.nextInt();
        System.out.println("zweite zahl");
        int zahl2 = in.nextInt();
        int zahl1Differenz = zahl1 -random;
        int zahl2Differenz = zahl2 -random;

        if (zahl1Differenz < 0){
            zahl1Differenz = zahl1Differenz * -1;
        }
        if (zahl2Differenz < 0){
            zahl2Differenz = zahl2Differenz * -1;
        }


        if (zahl1Differenz <zahl2Differenz){
            System.out.println("Zahl1 ist näher");
        }else if (zahl2Differenz <zahl1Differenz){
            System.out.println("Zahl2 is näher");
        }else{
            System.out.println("Unentschieden");
        }
        System.out.println(random);
    }
}
