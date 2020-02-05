import java.util.Scanner;

public class Rechner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welche Rechnung möchtest du ausführen?");
        System.out.println("1.) Addition");
        System.out.println("2.) Subtraktion");
        System.out.println("3.) Multiplikation");
        System.out.println("4.) Division");
        System.out.println("5.) Modulo");
    int rechnung = in.nextInt();
        System.out.println("Was ist dein erster Operand?");
    int operand1 = in.nextInt();
        System.out.println("Was ist dein zweiter Operand?");
    int operand2 = in.nextInt();
    switch (rechnung){
        case 1:
            System.out.println("Resultat: " + operand1 + " + " + operand2 +" = " + (operand1 + operand2));
            break;
        case 2:
            System.out.println("Resultat: " + operand1 + " - " + operand2 +" = " + (operand1 - operand2));
            break;
        case 3:
            System.out.println("Resultat: " + operand1 + " * " + operand2 +" = " + (operand1 * operand2));
            break;
        case 4:
            System.out.println("Resultat: " + operand1 + " / " + operand2 +" = " + (operand1 / operand2));
            break;
        case 5:
            System.out.println("Resultat: " + operand1 + " % " + operand2 +" = " + (operand1 % operand2));
            break;
    }
    }
}
