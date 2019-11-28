/**
 * Ein Ereignis, dass stattfinden kann
 */
public class Event {
    private double probability;
    private String text;
    private int lifeDelta;
    private String item;

    /**
     * \
     * Ereignis erstellen
     *
     * @param probability Eintrittswahrscheinlichkeit [0..1], d.h. 0-100%
     * @param text        Beschreibung des Ereignisses
     * @param lifeDelta   Leben, das der Spieler erhält (wenn es > 0 ist) oder verliert (< 0).
     */
    public Event(double probability, String text, int lifeDelta, String item) {
        this.probability = probability;
        this.text = text;
        this.lifeDelta = lifeDelta;
        this.item = item;
    }

    /**
     * Ereignis auf dem Spieler anwenden, und Text zurückgeben
     */
    public String apply(Player player) {
        double random = Math.random();

        if (!player.isDead()) {
            // eintrittswahrscheinlichkeit auswürfeln
            // wenn das ereignis eintritt: leben hinzufügen/abziehen, und ereignistext zurückgeben
            if (random <= probability) {
                System.out.println(text);
                if (!player.inventory.contains(item)) {
                    player.inventory.add(item);
                }
                //  Damage mitigation due to items
                if (lifeDelta < 0) {
                    double factor = 1;
                    if (player.inventory.contains("Schild")) {
                        factor *= 0.5;
                    }
                    if (player.inventory.contains("Brustpanzer")) {
                        factor *= 0.7;
                    }
                    if (player.inventory.contains("Helm")) {
                        factor *= 0.1;
                    }
                    lifeDelta = (int) (lifeDelta * factor);
                }
                player.addHealth(lifeDelta);
                return text;

            }
        }
        // bei nicht-eintritt: null zurückgeben (nichts passiert)
        return null;
    }
}
