import java.util.Collection;

public class Collections {
    public static void main(String[] args) {
        MyCollection collection = new MyCollection();
        collection.einfügen("slai");
        collection.einfügen("slaidaas");
        collection.einfügen("slaidasadsas");
        for (int i = 0; i <collection.texte.length; i++) {
            System.out.println(i +": "+collection.texte[i]);
        }

    }
}

