public class EuklidischerAlgorithmus {
    public static void main(String[] args) {
        int a = 66;
        int b = 156;
        int z = 1;
        int z1 = a;
        int z2 = b;

        while(a!=0&& b != 0) {
            if (a > b) {
                a = a % b;


            } else if (a < b) {
                //variablen tauschen
                z = a;
                a = b;
                b = z;

                a = a % b;
            }
        }
        System.out.println("Der GGt von "+z1+" und "+z2+"ist: "+b);

    }
}
