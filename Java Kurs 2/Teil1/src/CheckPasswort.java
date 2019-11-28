import javax.swing.*;
import java.util.Scanner;

public class CheckPasswort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        char aChar[] = input.toCharArray();
        boolean containes= false;

        for (int i = 0; i < aChar.length; i++) {
            if (aChar[i] == '&' | aChar[i] =='$' | aChar[i] =='%'){

                if(aChar.length >=8) {
                    containes = true;
                }
            }
        }
        if (containes == false){
            System.out.println("schlecht! Du hast das Passwort falsch eingegeben");
        }
    }
}
