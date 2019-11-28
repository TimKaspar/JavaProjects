import java.util.*;


public class LevelGenerator {
    int probability = (int)(Math.random());

    public static String generate() {
        Map<String, String> plc = new LinkedHashMap<>();
        plc.put("Dorf","s");
        plc.put("Feld","s");
        plc.put("Schiff","s");
        plc.put("Ebene","f");
        plc.put("Höle","f");
        plc.put("Felsen","m");
        plc.put("Stadt","f");

        List<String> adj = new LinkedList<String>();
        adj.add("Sonnig");
        adj.add("Düster");
        adj.add("Einsam");
        adj.add("Verzaubert");
        adj.add("Sumpfig");


        //random from plc Map
        List<String> valuesList = new ArrayList<String>(plc.keySet());
        int randomIndex = new Random().nextInt(valuesList.size());
        String randomKey = valuesList.get(randomIndex);

        String randomAdj = adj.get(new Random().nextInt(adj.size()));

        // String mit plc und angepasstem adj zurückgeben
        if(plc.get(randomKey).contains("s")){
            return randomAdj+"es "+randomKey;
        } else if(plc.get(randomKey).contains("f")){
            return randomAdj+"e " +randomKey;
        }else if(plc.get(randomKey).contains("m")){
            return randomAdj+"er "+randomKey;
        }


        return randomKey;
    }
}
