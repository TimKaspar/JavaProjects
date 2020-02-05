public class UnendlicheZahlenfolge {
    public static void main(String[] args) {
        int zahl = 1;
        System.out.println(zahl);
        for (int i=0;i<1000;i++){

            for(int x = 0; x<4;x++){
                zahl++;
                System.out.println(zahl);
            }for (int y = 0;y<3;y++){
                zahl--;
                System.out.println(zahl);
            }
        }
    }
}
