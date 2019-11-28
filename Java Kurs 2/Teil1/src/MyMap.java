import java.util.*;
import java.util.Scanner;

public class MyMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NavigableMap<String, Integer> map = new TreeMap<>();
        String stringInput = "";
        int intInput;
        do {
            System.out.print("Name: ");
            stringInput = scanner.next();
            System.out.print("Telefon Nummer: ");
            intInput = scanner.nextInt();
            map.put(stringInput, intInput);
            for(String keys : map.keySet()){
                System.out.println(keys + ":"+ map.get(keys));
            }
        } while(intInput != 666);
        for (char c='A'; c<= 'Z'; c++){
            System.out.println("=="+c+"==");
            for(String keys : map.keySet()){
                if(keys.startsWith(Character.toString(c)))
                System.out.println(keys + ":"+ map.get(keys));
            }
        }
    }
}
