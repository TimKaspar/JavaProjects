import java.util.Scanner;

public class UserText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        char[]  userText =input.toCharArray();
        char inbetween;
        for(int i = 0;i<userText.length-1;i+=2) {
            inbetween = userText[i];
            userText[i] = userText[i+1];
            userText[i+1] = inbetween;
        }

        System.out.println(userText);

    }
}
