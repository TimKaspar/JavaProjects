import java.util.Scanner;

public class SternchenDreieck {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Höhe:");
        int anzahl = in.nextInt();
        String sternchen= "*";
        String sternchenStr = "*";
        String leerSchlag = " ";
        String leerSchlagStr ="    ";
        for (int z = 0;z<(anzahl-1);z++){
            leerSchlagStr += leerSchlag;
        }
        for (var i = 0; i < anzahl;i++ ){
            System.out.println(leerSchlagStr+sternchenStr+leerSchlagStr);
            leerSchlagStr = " ";
            for (int x = 0;x<2;x++) {
                sternchenStr +=sternchen;
            }
            for (int x = 0;x<(anzahl-i+1);x++) {
                leerSchlagStr  += leerSchlag;
            }

        }

    }
}
