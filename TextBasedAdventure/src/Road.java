
// Eine Strasse, die zu einem Ort führt
public class Road {

    private String description;
    public Place target;

    public Road(String description, Place target) {
        this.description = description;
        this.target = target;
    }


    public String getDescription() {
        return description;
    }

    public Place getTarget() {
        return target;
    }

    public void event(Player player) {
        //Consumables
        Consumable healthPot = new Consumable(0.1, 3, "Du hast ein Heilungs Trank gefunden", 10);

        //Items
        Event schild = new Event(0.15, "findet ein Schild", 0, "Schild");
        Event brustpanzer = new Event(0.1, "findet einen Brustpanzer", 0, "Brustpanzer");
        Event helm = new Event(0.2, "findet ein Helm", 0, "Helm");
        //Actions
        Event event1 = new Event(0.3, "sieht einen Schmetterling", 0, "");
        Event event2 = new Event(0.5, "findet einen Verbandskasten", 25, "");
        Event event3 = new Event(0.2, "wird von einem auto angefahren", -70, "");
        Event event4 = new Event(0.4, "stollpert über einen Stein", -20, "");
        Event event5 = new Event(0.35, "wird von einem aggressiven Krebs angegriffen", -40, "");
        Event event6 = new Event(0.15, "findet ein Heilungs Pilz", 15, "");
        Event event7 = new Event(1, "wird von einem Skelett getötet", -20000, "");

        //player.inventory.add(healthPot);

        if (player.where().getName().equals("Wald")) {
            schild.apply(player);
            brustpanzer.apply(player);
            helm.apply(player);
            event1.apply(player);
            event3.apply(player);
            event4.apply(player);
            event6.apply(player);
            healthPot.apply(player);
        }
        if (player.where().getName().equals("Todes Welt")) {
            event7.apply(player);

        }
        if (player.where().getName().equals("Steiniger Weg")) {
            schild.apply(player);
            event1.apply(player);
            event2.apply(player);
            event4.apply(player);
            event3.apply(player);
            event6.apply(player);
        }
        if (player.where().getName().equals("Fluss")) {
            brustpanzer.apply(player);
            event1.apply(player);
            event2.apply(player);
            event4.apply(player);
            event5.apply(player);
        }
        if (player.where().getName().equals("See")) {
            schild.apply(player);
            helm.apply(player);
            event1.apply(player);
            event4.apply(player);
            event5.apply(player);
        }
    }

    public String toString() {
        return description + " -> " + target;
    }
}
