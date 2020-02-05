public class ChuckALuck {
    public static void main(String[] args) {
        int kapital = 1000;
        int einsatz = 1;

        for (int i = 0; i<1000;i++){
        if (kapital >0) {
            kapital--;
            double random1 = Math.ceil(Math.random()*6);
            System.out.println(random1);
            double random2 = Math.ceil(Math.random()*6);
            System.out.println(random2);
            double random3 = Math.ceil(Math.random()*6);
            System.out.println(random3);
            System.out.println("\n");

//|| (random2 == 6 && (random1 == 6 || random3 == 6)) || (random3 == 6 && (random1 == 6 || random2 == 6))
            if (random1 == 6.0 && random2 == 6.0 && random3 == 6.0) {
                kapital += 4;
            } else if ((random2 == 6.0 &&( random3 == 6.0 || random1 == 6.0)) || (random1 == 6.0 && (random2 == 6.0 || random3 == 6.0)) || (random3 == 6.0 && (random1 == 6.0 || random2 == 6.0))) {
                kapital += 3;
            } else if (random1 == 6.0 || random2 == 6.0 || random3 == 6.0) {
                kapital += 2;
            }
        }
        }
        System.out.println("Kapital: "+kapital);
    }
}
