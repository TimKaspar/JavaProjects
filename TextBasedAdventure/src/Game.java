import java.util.*;

public class Game {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        List<Player> players = new LinkedList();
        Map<Integer, String> playerNames = Player.inputPlayerNames();
        SpielWelt spielWelt = new SpielWelt();
        spielWelt.createworld();

        for (int i = 0; i < playerNames.size(); i++) {
            // Players für die Namen erschaffen
            Player player = new Player(playerNames.get(i + 1), spielWelt.randomStartPoint());
            players.add(player);
            // Spieler, beginnt das Spiel am Start-Ort
            player.goTo(player.getPosition());
        }

        // game loop: spielen, bis wir am Ziel sind
        while (!players.isEmpty()) {
            for (int i = 0; i < players.size(); i++) {
                Player player = players.get(i);
                if (player.where() != spielWelt.end && player.where() != spielWelt.end2 && !player.isDead()) {
                    Place place = player.where();

                    System.out.println("\n" + player);

                    // Wo kann's hingehen?
                    System.out.println("Mögliche Wege:");
                    List<Road> roads = place.getRoads();

                    // Auswahl: 1..n, entspricht 0..n-1 im Array
                    for (int x = 0; x < roads.size(); x++) {
                        Road road = roads.get(x);
                        System.out.println((x + 1) + ": " + road.getDescription());
                    }
                    System.out.println("Wohin soll's gehen?");

                    // Wo will der Spieler hin?
                    int number = 10;
                    try {
                        number = scanner.nextInt();
                    } catch (InputMismatchException ex) {
                        scanner.nextLine();
                    }
                    if (number > 0 && number <= roads.size()) {
                        int index = number - 1;

                        // Weg auswählen
                        Road chosenRoad = roads.get(index);
                        System.out.println("Ihre Wahl: " + chosenRoad);

                        // Zielort bestimmen
                        Place target = chosenRoad.getTarget();

                        // Spieler verschieben
                        chosenRoad.event(player);
                        if (!player.isDead()) {
                            player.goTo(target);
                        }

                    } else {
                        System.err.println("Ungültige Eingabe");
                    }
                    // Wenn Spiel Fertig ist
                    if (player.isDead()) {
                        System.out.println(player.getName() + ", Sie haben keine Lebenspunkte mehr und haben sommit das Spiel verloren");
                        players.remove(player);
                    } else if (player.where() == spielWelt.end || player.where() == spielWelt.end2) {
                        System.out.println("\nGratulation, " + player.getName() + " sie haben das Spiel mit " + player.health + " Lebenspunkten gemeistert");
                        players.remove(player);
                    }
                }

            }

        }
        System.out.println("\nDas Spiel ist zu Ende");
    }
}

