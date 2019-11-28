public class ArrayUmkehren {
    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 78, 54, 32, 213, 1, 89};
        int[] newArray = new int[array.length];
        for (int i = 0; i <array.length ; i++) {
            newArray[i] = array[array.length-i-1];

        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(newArray[i]+" ");
        }
    }
}
