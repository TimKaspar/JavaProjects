import java.util.Scanner;

public class WetterStation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1.
        int[] tag = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int[] temp = new int[]{12, 14, 9, 12, 15, 16, 15, 15, 11, 8, 13, 13, 15, 12};

        // 2.
        int summe = 0;
        for (int i = 0; i < tag.length; i++) {
            summe += temp[i];

        }
        System.out.println("Durchschnittstemperatur der zwei Wochen: " + summe / tag.length);

        // 3.
        int max = 0;
        int min = 20;
        for (int i = 0; i < tag.length; i++) {
            if (temp[i] < min) {
                min = temp[i];
            }
            if (temp[i] > max) {
                max = temp[i];
            }
        }
        System.out.println("max Temperatur : " + max);
        System.out.println("min Temperatur : " + min);

        // 4.
        int unterschied = 0;
        int tag1= 0;
        for (int i = 0; i < temp.length- 1; i++) {
            if (temp[i] < temp[i+1]) {
                    if (temp[i+1] - temp[i] > unterschied) {
                        unterschied = temp[i+1] - temp[i];
                        tag1=tag[i];
                    }
                } else  if (temp[i] >= temp[i+1]){
                    if (temp[i] - temp[i+1] > unterschied) {
                        unterschied = temp[i] - temp[i+1];
                        tag1=tag[i];
                    }
                }

        }
        System.out.println("Der Grösste Temperaturunterschied ist vom "+ tag1 +". auf den "+ (tag1 +1)+". Tag und beträgt "+unterschied+"°C");

        //5.
        String tagString ="";
        String tempString ="";
        System.out.print("Tage:       ");
        for (int i = 0; i < tag.length; i++) {
            if (tag[i] < 10){
                System.out.print(" "+tag[i]);
            }else{
                System.out.print(tag[i]);

            }
            System.out.print(", ");
        }
        System.out.print("\n");
        System.out.print("Temperatur: ");
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] < 10){
                System.out.print(" "+temp[i]);
            }else {
                System.out.print(temp[i]);
            }
            System.out.print(", ");

        }
        System.out.println(tagString);
        System.out.println(tempString);

    }
}
