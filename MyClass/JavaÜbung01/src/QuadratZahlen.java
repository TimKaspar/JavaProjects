public class QuadratZahlen {

    public static void  main(String[] args){
        int n = 100;
        int summe = 0;
        int z = 0;
        int quadrat = 0;
        while (z < n){
            quadrat = z*z;
            z++;
            summe += quadrat;
        }
        System.out.println(summe);
        System.out.println(quadrat);
    }
}
