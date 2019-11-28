import java.util.*;

public class Player {

    private Place place = new Place("noch nicht im Spiel");
    private String name;
    public int health;
    private int healthIn10Percent;
    private Place position;
    public List<String> inventory = new LinkedList<>();

    public Player(String playerName, Place position) {
        this.name = playerName;
        this.position = position;
        this.inventory = inventory;
        health = getMaxHealth();
    }

    public int getMaxHealth() {
        return 200;
    }

    public void addHealth(int points) {
        health += points;
        if (health > getMaxHealth()) {
            health = getMaxHealth();
        }
        if (health < 0) {
            health = 0;
        }
    }


    public boolean isDead() {
        if (health <= 0) {
            return true;
        } else {
            return false;
        }
    }


    public Place where() {
        return place;
    }

    public void goTo(Place next) {
        this.place = next;
    }

    public String getName() {
        return name;
    }

    public static Map<Integer, String> inputPlayerNames() {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> playerNames = new HashMap<>();
        String name = " ";
        System.out.println("Bitte geben Sie die Spieler Namen ein. Wenn Sie alle Spielernamen eingegebn haben drücken Sie die Enter Taste.");
        //isEmty() dass Map beim zweiten Abfragen nicht nochmals gefühlt wird
        for (int i = 1; !name.isEmpty(); i++) {
            int number = i;
            System.out.println(i + ". ");
            //.nextLine() um auch Enter also Eingabe zu akzeptieren
            name = scanner.nextLine();
            ;
            if (!name.isEmpty()) {
                playerNames.put(number, name);
            }
        }
        return playerNames;
    }

    public String healtInSigns() {
        healthIn10Percent = health / ((int) (getMaxHealth() * 0.1));
        String hashtags = "";
        //for every 10% health
        for (int i = 0; i < healthIn10Percent; i++) {
            hashtags += "#";
        }
        //for everv 10% health misisng
        for (int i = 0; i < 10 - healthIn10Percent; i++) {
            hashtags += " ";
        }

        return hashtags;
    }

    public String toString() {
        return getName() + ", [" + healtInSigns() + "] " + health + "/" + getMaxHealth() + " , Position : " + place + ", Inventar: " + inventory;
    }

    public Place getPosition() {
        return position;
    }
}
