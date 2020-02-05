import java.util.Scanner;

public class Echo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Echo:");
        System.out.println(in.next());
        in.close();
    }
}
