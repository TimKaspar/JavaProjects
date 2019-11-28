import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyIntList {
    public static void main(String[] args) {

        List<Int> integer = new ArrayList<>();
        Int zahl = new Int();
        zahl.zahl = 4;
        integer.add(zahl);
    }
}

class Int {
    int zahl;
}
