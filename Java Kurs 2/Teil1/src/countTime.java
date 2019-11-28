import java.util.*;
import java.util.Scanner;

public class countTime {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        System.out.println("add:");

        long startTime = System.currentTimeMillis();
        list.add(2);
        long endTimne = System.currentTimeMillis();
        System.out.println("list: " + (endTimne-startTime));

        startTime = System.currentTimeMillis();
        hashSet.add(2);
        endTimne = System.currentTimeMillis();
        System.out.println("hashSet: " + (endTimne-startTime));

        startTime = System.currentTimeMillis();
        treeSet.add(2);
        endTimne = System.currentTimeMillis();
        System.out.println("treeSet: " + (endTimne-startTime));

        System.out.println("add const: ");

        Integer constI = 3;
        startTime = System.currentTimeMillis();
        list.add(constI);
        endTimne = System.currentTimeMillis();
        System.out.println("list: " + (endTimne-startTime));

        startTime = System.currentTimeMillis();
        hashSet.add(constI);
        endTimne = System.currentTimeMillis();
        System.out.println("hashSet: " + (endTimne-startTime));

        startTime = System.currentTimeMillis();
        treeSet.add(constI);
        endTimne = System.currentTimeMillis();
        System.out.println("treeSet: " + (endTimne-startTime));

        System.out.println("check if value exists: ");
        startTime = System.currentTimeMillis();
        list.contains(2);
        endTimne = System.currentTimeMillis();
        System.out.println("list: " + (endTimne-startTime));

        startTime = System.currentTimeMillis();
        hashSet.contains(2);
        endTimne = System.currentTimeMillis();
        System.out.println("hashSet: " + (endTimne-startTime));

        startTime = System.currentTimeMillis();
        treeSet.contains(2);
        endTimne = System.currentTimeMillis();
        System.out.println("treeSet: " + (endTimne-startTime));


    }
}
