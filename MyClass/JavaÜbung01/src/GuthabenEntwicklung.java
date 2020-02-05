import java.util.Scanner;
import java.lang.Object;
import java.text.Format;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class GuthabenEntwicklung {
    public static void main(String[] args) {
        DecimalFormat format = new DecimalFormat("0.##");
        Scanner in = new Scanner(System.in);
        System.out.println("Guthaben:");
        double g = in.nextDouble();
        System.out.println("Zins:");
        double z = in.nextDouble();
        System.out.println(g);
        for(int i=0;i<10;i++){
            g = g*(1.0+z/100.0);
            System.out.println(format.format(g));
        }

    }
}