import java.util.*;

public class CaesarVerschluesslung {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Text zum verschlüsseln: ");
        String input = scanner.next();
        char[] charArray = input.toCharArray();
        System.out.println("Passwort: ");
        if (scanner.nextInt() == 897) {
            Map<Character, Character> cipher = new HashMap<>();
            cipher.put('a', 'x');
            cipher.put('b', 'y');
            cipher.put('c', 'z');
            cipher.put('d', 'a');
            cipher.put('e', 'b');
            cipher.put('f', 'c');
            cipher.put('g', 'd');
            cipher.put('h', 'e');
            cipher.put('i', 'f');
            cipher.put('j', 'g');
            cipher.put('k', 'h');
            cipher.put('l', 'i');
            cipher.put('m', 'j');
            cipher.put('n', 'k');
            cipher.put('o', 'l');
            cipher.put('p', 'm');
            cipher.put('q', 'n');
            cipher.put('r', 'o');
            cipher.put('s', 'p');
            cipher.put('t', 'q');
            cipher.put('u', 'r');
            cipher.put('v', 's');
            cipher.put('w', 't');
            cipher.put('x', 'u');
            cipher.put('y', 'v');
            cipher.put('z', 'w');
            for (int i = 0; i < input.length(); i++) {
                charArray[i] = cipher.get(charArray[i]);
            }
            System.out.println("Verschlüsslung: ");
            for (int i = 0; i < input.length(); i++) {
                System.out.print(charArray[i]);
            }
            System.out.println("\n");
        }

        //Entschlüsseln
        System.out.println("Entschlüsseln\n-------------");
        System.out.println("Passwort: ");
        if (scanner.nextInt() == 897) {
            Map<Character, Character> cipher = new HashMap<>();
            cipher.put('a', 'd');
            cipher.put('b', 'e');
            cipher.put('c', 'f');
            cipher.put('d', 'g');
            cipher.put('e', 'h');
            cipher.put('f', 'i');
            cipher.put('g', 'j');
            cipher.put('h', 'k');
            cipher.put('i', 'l');
            cipher.put('j', 'm');
            cipher.put('k', 'n');
            cipher.put('l', 'o');
            cipher.put('m', 'p');
            cipher.put('n', 'q');
            cipher.put('o', 'r');
            cipher.put('p', 's');
            cipher.put('q', 't');
            cipher.put('r', 'u');
            cipher.put('s', 'v');
            cipher.put('t', 'w');
            cipher.put('u', 'x');
            cipher.put('v', 'y');
            cipher.put('w', 'z');
            cipher.put('x', 'a');
            cipher.put('y', 'b');
            cipher.put('z', 'c');
            for (int i = 0; i < input.length(); i++) {
                charArray[i] = cipher.get(charArray[i]);
            }
            System.out.println("Entschlüsslung: ");
            for (int i = 0; i < input.length(); i++) {
                System.out.print(charArray[i]);
            }
        }
    }
}
