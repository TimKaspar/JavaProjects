import java.util.Scanner;

public class Dividierbar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Max: ");
        int max= in.nextInt();
        System.out.println("Div: ");
        int div= in.nextInt();

        for(int i= 0; i< max;i++){
            if (i%div == 0){
                System.out.println(i);
            }
        }
    }
}