import java.util.Scanner;

public class SortierMethoden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Maximalwert");
        int r = scanner.nextInt();
        System.out.println("anzahl Werte");
        int n = scanner.nextInt();
        int counter = 0;
        int[] list = new int[n];

        for (int i = 0; i < list.length; i++) {
            list[i] = (int) (Math.floor(Math.random() * r + 1));

            //Sortieren mit Bubble sort
/*
            for (int j = 0; j < list.length; j++) {
            counter++;
                if (list[i]<list[j]){
                    int temp = list[j];
                    list[j] = list[i];
                    list[i] = temp;
                }
            }*/
        }

        //Sortieren mit Insertion sort
        for (int i = 1; i < list.length; ++i) {
            int key = list[i];
            int j = i - 1;

            while (j >= 0 && list[j] > key) {
                counter++;
                list[j + 1] = list[j];
                j = j - 1;
            }
            list[j + 1] = key;
        }

        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
        System.out.println("Anzahl Sortiuerungen: "+counter);
    }
}
