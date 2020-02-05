
public class ZahlenDreieckDo {
    public static void main(String[] args) {
        String zahlStr = "";
        int zahl = 0;
            do{zahl++;
            zahlStr += zahl;
            System.out.println(zahlStr);
        }while (zahl < 10);

    }
}
