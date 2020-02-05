import java.util.Scanner;

public class MannOderFrau {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Geben Sie ihr Nachname ein");
        String nachname = in.next();
        System.out.println("1) Frau");
        System.out.println("2) Mann");
        String geschlecht = in.next();

        if (Integer.parseInt(geschlecht) == 2){
            System.out.println("Guten Tag Herr " + nachname);
        }else if (Integer.parseInt(geschlecht) == 1){
            System.out.println("Guten Tag Frau " + nachname);
        }else{
            System.out.println("Bite 1 oder 2 eingebe!");
        }

    }
}
