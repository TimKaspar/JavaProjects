import java.util.Scanner;

public class DreimalPasswortEingebn {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Passwort:");
        String input = in.next();
        for(int i = 1; i<3;i++){
            System.out.println(input);
            if (input.equals("098756")){
                System.out.println("BERECHTIGT!");
                break;
            }else{
                System.out.println("Passwort falsch! Dies war der " + i + "/3 versuch");
            }
            System.out.println("Passwort:");
            input = in.next();
        }
        System.out.println("KONTO GESPERRT: ANZAHL VERSUCHE ÜBERSCHRITTEN!");
    }
}
