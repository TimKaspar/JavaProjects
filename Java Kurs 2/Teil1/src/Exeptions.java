import java.util.*;

public class Exeptions {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        try{
            for (int i = 0; i < 10000001; i++) {
                list.add(i);
                System.out.println(list.get(i));
            }
        }finally{
            throw new IndexOutOfBoundsException();
        }

    }
}
