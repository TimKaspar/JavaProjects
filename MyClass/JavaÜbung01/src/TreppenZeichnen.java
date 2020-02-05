import java.util.Scanner;

public class TreppenZeichnen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Anzahl Stuffen?");
        int anzahlStufen = in.nextInt();
        int anzahlZeichen = 1;
        String zeichen = "";
        String leerschlaege = "";
        for (int x = 0; x< anzahlStufen; x++) {
            for (int i = 0; anzahlZeichen > i; i++) {
                zeichen += "-";
                leerschlaege += " ";
            }
            System.out.println("+" + zeichen + "+\n" +
                    "|" + leerschlaege + "|");

            zeichen += "----";
            leerschlaege += "    ";

        }
    }
}
