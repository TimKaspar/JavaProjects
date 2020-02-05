
public class Teilbar {
    public static void main(String[] args) {
        int zahl = 1;
        for(int i = 1; i < 101; i++){

            if(zahl%3 == 0){
                System.out.println("foo");
            }else if (zahl % 5== 0){
                System.out.println("bar");
            }else if (zahl%5 == 0 && zahl%3 == 0){
                System.out.println("foobar");
            }
            else{
                System.out.println(zahl);
            }
            zahl++;
        }

    }
}
