import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double randomPC = Math.round(Math.random() * 50 / 10 + 16);
        double randomMenschAdd = 0;
        String ws = "";
        while (!ws.equals("s") && randomMenschAdd <= 21) {


            double randomMensch = Math.round(Math.random() * 90 / 10 + 2);
            randomMenschAdd += randomMensch;
            if(randomMenschAdd <21) {
                System.out.println("Du hast " + randomMenschAdd);
                System.out.println("weiter(w) oder stopp(s)");
                ws = in.next();
            }
        }
        if (randomMenschAdd > 21 || randomMenschAdd < randomPC) {
            System.out.println("Du hast Verloren!");
        } else if (randomMenschAdd > randomPC) {
            System.out.println("Du hast gewonnen!");
        } else {
            System.out.println("Unentschieden!");
        }
        System.out.println("Deine Zahl"+randomMenschAdd);
        System.out.println("Zahl des Computers"+randomPC);
    }
}
