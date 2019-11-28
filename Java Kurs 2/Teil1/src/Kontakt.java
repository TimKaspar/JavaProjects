import java.util.Collection;
import java.util.Scanner;

public class Kontakt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        int counter = 0;
        Contact[] contacts = new Contact[20];

        do {
            System.out.println("\n");
            System.out.println("1. Kontakt Erstellen");
            System.out.println("2. Alle Kontakte anzeigen");
            System.out.println("3. Kontakt Löschen");
            System.out.println("4. Kontakt bearbeiten");
            System.out.println("5. Programm verlassen");
            input = scanner.nextInt();
            //Kontakt erstellen
            if (input == 1) {
                System.out.println("Name: ");
                String kntName = scanner.next();
                System.out.println("Telefon Nummber: ");
                String kntTele = scanner.next();
                contacts[counter] = new Contact(kntName, kntTele);
            }
            //Kontaktliste ausgeben
            if (input == 2) {
                for (int i = 0; i < contacts.length; i++) {
                    if (contacts[i] != null) {
                        System.out.println(i + ". ");
                        System.out.println("Name: "+contacts[i].name);
                        System.out.println("Telefon Nummber: "+contacts[i].telNummber);
                    }
                }
            }
            //Kontakte Löschen
            if (input == 3) {
                System.out.println("Gib position von Kontakt ein oder gib 69 ein um alle Kontakte zu löschen");
                int inputX = scanner.nextInt();
                try {
                    contacts[inputX] = null;
                } catch (IndexOutOfBoundsException ex) {
                    if (inputX == 69) {
                        for (int i = 0; i < contacts.length; i++) {
                            contacts[i] = null;
                        }
                    } else {
                        System.err.println("Ungültige Eingabe");
                    }
                }

            }
            if (input == 4) {
                System.out.println("Gib position von Kontakt ein");
                int inputY = scanner.nextInt();

                try {
                    System.out.println("1 für Namen 2 für Telefon Nummer");
                    int inputX = scanner.nextInt();
                    if (inputX==1){
                        System.out.println("Neuer Name: ");
                        contacts[inputY].name = scanner.next();
                    } else if (inputX==2){
                        System.out.println("Neue Telefon Nummer: ");
                        contacts[inputY].telNummber = scanner.next();
                    }
                } catch (IndexOutOfBoundsException ex) {
                        System.err.println("Ungültige Eingabe");
                }
            }
            counter++;
        } while (input != 5);
    }
}

class Contact {
    String name;
    String telNummber;

    public Contact(String name, String telNummber) {
        this.name = name;
        this.telNummber = telNummber;
    }
}
