public class ZweierPotenzen {
    public static void main(String[] args) {
        double[] potenz = new double[20];


        for (int i = 0; i < potenz.length; i++) {
            potenz[i] = Math.pow(2.0, i);
        }
        for (double zahl : potenz) {
            System.out.println(zahl);
        }
    }
}
