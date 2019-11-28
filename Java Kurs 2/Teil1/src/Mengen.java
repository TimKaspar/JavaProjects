import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Mengen {
    public static void main(String[] args) {
        ElementInteger elementInteger = new ElementInteger();
        ElementDouble elementDouble = new ElementDouble();
        ElementString elementString = new ElementString();

        Scanner scanner = new Scanner(System.in);
        Map<String, Set> menge = new HashMap<>();
        boolean exit = false;

        while (exit == false) {
            System.out.println("1. Eine neue Menge Erstellen\n2. Eine Bestehende Menge löschen\n3. Ein Element aus einer Menge löschen\n4. Ein Element zu einer Menge Hinzufügen\n5. Eine Übersicht aller Mengen anzeigen\n6. Alle Elemente einer Menge anzeigen\n7. Programm beenden\n-----------------------------------------------");
            System.out.print("Eingabe: ");
            int action = scanner.nextInt();
            switch (action) {
                case 1://create new menge

                    System.out.println("Bitte Name eingeben: ");
                    String name = scanner.next();
                    System.out.println("Und jetzt bitte noch die Elemente eingeben");
                    String input = scanner.next();
                    String inputArray[] = input.split(",");

                    //detect what type input is and add to Set
                    for (String txt : inputArray) {
                        try {
                            elementInteger.add(Integer.parseInt(txt));
                        } catch (NumberFormatException ex1) {
                            try {
                                elementDouble.add(Double.parseDouble(txt));
                            } catch (NumberFormatException ex2) {
                                elementString.add(txt);
                            }
                        }
                    }
                    //add menge to Map menge
                    if (!elementInteger.integerSet.isEmpty()) {
                        menge.put(name, elementInteger.integerSet);
                    } else if (!elementDouble.doubleSet.isEmpty()) {
                        menge.put(name, elementDouble.doubleSet);
                    } else {
                        menge.put(name, elementString.stringSet);
                    }
                    break;

                case 2://delete menge
                    System.out.println("Name der zu löschenden Menge");
                    String delete = scanner.next();
                    menge.remove(delete);
                    break;

                case 3://delete element of menge
                    System.out.println("Name der Menge:");
                    String deleteElement = scanner.next();
                    System.out.println("Element: ");
                    String deleteElement2 = scanner.next();

                    //iterate over set to find
                    for (String key : menge.keySet()) {
                        Set set = menge.get(key);
                        for (Object item : set) {
                            if (item == deleteElement2) {
                                //remove element
                                menge.get(deleteElement).remove(deleteElement2);
                            }
                        }
                    }
                    break;

                case 4://add element to menge
                    System.out.println("Name der Menge:");
                    String addMenge = scanner.next();
                    System.out.println("New Element: ");
                    String addElement = scanner.next();
                    menge.get(addMenge).add(addElement);
                    break;

                case 5://show all menges

                    for (String key : menge.keySet()) {
                        System.out.print(key + ": ");
                        Set set = menge.get(key);
                        for (Object item : set) {
                            System.out.print(item + " ");
                        }
                        System.out.println("\n");
                    }
                    break;

                case 6://show all elements of one menge
                    System.out.println("Menge:");
                    String txt = scanner.next();
                    for (String key : menge.keySet()) {

                        Set set = menge.get(key);
                        if (key.equalsIgnoreCase(txt)) {
                            System.out.println("key: "+key);
                            System.out.print("Elemente: ");
                            for (Object item : set) {
                                System.out.print(item + " ");
                            }
                        }
                    }
                    System.out.println("\n");
                    break;

                case 7://exit programm
                    exit = true;
                    System.out.println("Programm beendet");
                    break;
            }
        }
    }
}
