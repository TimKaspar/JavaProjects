public class ArrayMehrmalselemente {
    public static void main(String[] args) {
        int array[] = new int[]{4, 5, 4, 3, 6, 1, 6, 5};
        int doppelt = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[i] == array[j + 1]) {
                    System.out.println("array[i]:" + array[i]);
                    System.out.println("array[j+1]:" + array[j + 1]);
                    doppelt++;
                }
            }
        }
        System.out.println(doppelt);
    }
}
