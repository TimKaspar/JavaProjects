public class FaktorenAusgeben {
    public static void main(String[] args) {
        int zahl = 1;
    while(zahl <= 924){
        if (900900%zahl == 0)
        System.out.println( zahl + "*" +(900900/zahl));
        zahl++;

        }
    }
}
