import java.util.Scanner;

public class CheckDoppelBuschstaben {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        char[]  userText =input.toCharArray();

        for(int i = 0;i<userText.length-1;i++) {
            if(userText[i]==userText[i+1]){
                System.out.println(userText[i]+" kommt zweimal vor");
            }

        }


    }
}
