import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class IndexOutOfBoundsTest {


    @Test
    public void testIndexOutOfBounds() {

        double num = Math.random() * 10 + 1;
        List<Integer> list = new ArrayList<>();

        for (Integer i = 0; i < 100; i++) {
            list.add(i);
        }
        Assert.assertTrue(list.size() > num);
    }
}
