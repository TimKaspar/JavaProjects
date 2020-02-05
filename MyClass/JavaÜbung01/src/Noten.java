import java.util.Arrays;
import java.lang.Object;
import java.text.Format;
import java.text.NumberFormat;
import java.text.DecimalFormat;
public class Noten {
    public static void main(String[] args) {
        DecimalFormat format = new DecimalFormat("0.#");
        double durchschnitt = 0;
        double zahlGross = 0;
        double zahlKlein = 6;

        for (int i =0;i<20;i++){
            double rand= Math.round(Math.random()*50/10+1);
            durchschnitt += rand;
            if(rand<zahlKlein){
                zahlKlein= rand;
            }else if (rand> zahlGross){
                zahlGross=rand;
            }


        }
        durchschnitt += -zahlGross-zahlKlein;
        System.out.println("Durchshcnitt von 20 zufällig generierten Noten:");
        System.out.println(format.format(Math.round((durchschnitt/18)*2)/2.0));
    }
}
//NOT FINISHED