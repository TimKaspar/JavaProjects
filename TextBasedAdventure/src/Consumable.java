import java.util.*;

public class Consumable {
    private double probability;
    private int amount;
    private String text;
    private int lifeDelta;

    public Consumable(double probability, int amount, String text, int lifeDelta) {
        this.probability = probability;
        this.amount = amount;
        this.text = text;
        this.lifeDelta = lifeDelta;
    }
    public List<Consumable> consumables = new LinkedList<>();

    public String apply(Player player) {
        double random = Math.random();

        if (!player.isDead()) {


            player.addHealth(lifeDelta);
        }
        // bei nicht-eintritt: null zurückgeben (nichts passiert)
        return null;
    }



    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
