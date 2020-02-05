import java.util.Scanner;

public class GoodMorningOrGoodNight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
     String uhr = in.next();
     if (Integer.parseInt(uhr) < 12){
         System.out.println("Good Morning");
     }else if (Integer.parseInt(uhr) == 12){
         System.out.println("Good Day");
     }
     else if (Integer.parseInt(uhr) > 12 && Integer.parseInt(uhr) < 24){
         System.out.println("Good Afternoon");
     }
    }
}
