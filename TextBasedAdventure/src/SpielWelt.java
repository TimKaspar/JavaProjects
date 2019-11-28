import java.util.*;

public class SpielWelt {
    List<Place> places = new LinkedList<Place>();
    List<Place> startPoints = new LinkedList<>();

    public Place end;
    public Place end2;

    public void createworld() {
        Place dorf = new Place("Kleines Dörfchen");
        Place hoele = new Place("Dunkle Höle");
        Place weg = new Place("Steiniger Weg");
        Place wald = new Place("Wald");
        Place see = new Place("See");
        Place stadt = new Place(LevelGenerator.generate());
        Place fluss = new Place("Fluss");
        Place hexenhaus = new Place("Hexenhaus");
        Place schlucht = new Place("Schlucht");
        Place random = new Place(LevelGenerator.generate());
        Place todesWelt = new Place("Todes Welt");

        places.add(dorf);
        places.add(hoele);
        places.add(weg);
        places.add(wald);
        places.add(see);
        places.add(stadt);
        places.add(fluss);
        places.add(hexenhaus);
        places.add(schlucht);
        places.add(random);
        places.add(todesWelt);

        List<Road> startRoads = new LinkedList<Road>();
        startRoads.add(new Road("verlasse Dorf", weg));
        dorf.setRoads(startRoads);

        List<Road> start2Roads = new LinkedList<Road>();
        start2Roads.add(new Road("verlasse Höle", weg));
        start2Roads.add(new Road("gehe nach Süd-Osten", fluss));
        hoele.setRoads(start2Roads);

        List<Road> wegRoads = new LinkedList<Road>();
        wegRoads.add(new Road("betrete Wald", wald));
        weg.setRoads(wegRoads);

        List<Road> waldRoads = new LinkedList<Road>();
        waldRoads.add(new Road("gehe zurück", weg));
        waldRoads.add(new Road("bleibe hier", wald));
        waldRoads.add(new Road("gehe nach Osten", see));
        waldRoads.add(new Road("gehe nach Westen", stadt));
        waldRoads.add(new Road("gehe zum Süden", random));
        waldRoads.add(new Road("gehe zum Fluss", fluss));
        waldRoads.add(new Road("betrette das Reich der Toten", todesWelt));
        wald.setRoads(waldRoads);

        List<Road> flussRoads = new LinkedList<Road>();
        flussRoads.add(new Road("gehe dem Fluss entlang", hexenhaus));
        flussRoads.add(new Road("betrete denn Wald", wald));
        fluss.setRoads(flussRoads);


        List<Road> seeRoads = new LinkedList<Road>();
        seeRoads.add(new Road("gehe nach Westen", wald));
        seeRoads.add(new Road("gehe nach Norden", stadt));
        seeRoads.add(new Road("gehe in die Schlucht", schlucht));
        see.setRoads(seeRoads);

        List<Road> schluchtRoads = new LinkedList<Road>();
        schluchtRoads.add(new Road("Sackgasse, gehe wieder zurück", see));
        schlucht.setRoads(schluchtRoads);

        List<Road> randomRoads = new LinkedList<Road>();
        randomRoads.add(new Road("folge dem Pfad", see));
        random.setRoads(randomRoads);

        List<Road> todesWeltRoads = new LinkedList<Road>();
        todesWeltRoads.add(new Road("gehe weiter", see));
        todesWelt.setRoads(todesWeltRoads);


        List<List<Road>> roads = new LinkedList<>();
        roads.add(startRoads);
        roads.add(start2Roads);
        roads.add(wegRoads);
        roads.add(waldRoads);
        roads.add(flussRoads);
        roads.add(seeRoads);
        roads.add(randomRoads);
        roads.add(todesWeltRoads);

        //startpoints mit allen places füllen, um nacher alle places die nicht startPoints sind zu entfernen
        startPoints = places;
        for (int x = 0; x < roads.size(); x++) {
            for (int i = 0; i < roads.get(x).size(); i++) {
                if (places.contains(roads.get(x).get(i).getTarget())) {
                    startPoints.remove(roads.get(x).get(i).getTarget());
                }
            }
        }
        end = stadt;
        end2 = hexenhaus;
    }
    public Place randomStartPoint() {
        int random = (int) (Math.random() * 2);
        return startPoints.get(random);
    }
}


