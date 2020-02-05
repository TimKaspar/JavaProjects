import java.util.Scanner;

public class QuadratischeGleichung {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Gib b ein");
        int b = in.nextInt();
        System.out.println("Gib a ein");
        int a = in.nextInt();
        System.out.println("Gib c ein");
        int c = in.nextInt();


        int D = b*b - 4 * a *c;

        if(D == 0){
            System.out.println("Es gibt eine Lösung");
        }else if (D> 0){
            System.out.println("Es gibt zwei Lösungen");
        }else if (D < 0){
            System.out.println("Es gibt keine Lösung");
        }
    }
}