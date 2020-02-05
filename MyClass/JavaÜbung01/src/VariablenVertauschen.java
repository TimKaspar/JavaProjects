public class VariablenVertauschen {
    public static void  main(String [] args){
        int a = 1;
        int b = 2;
        int wechsel;
        wechsel = a;
        a=b;
        b=wechsel;

        System.out.println(a + ", "+ b);
    }
}
