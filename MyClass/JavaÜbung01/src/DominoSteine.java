public class DominoSteine {
    public static void main(String[] args){
    int zahl1 = 0;
    int zahl2 = 0;
    for(int i = 0; i<6; i++){
        zahl1++;
        zahl2 = 0;
        for(int x = 0; x<6; x++){
            zahl2++;
            if (zahl1 <=zahl2) {
                System.out.println("(" + zahl1 + "|" + zahl2 + ")");
            }
        }
    }
    }
}
