import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SmallerZero {

    @Test
    public void testSmallerZero() {
        int num1 = 13;
        int num = 3+num1-50;
        Assert.assertTrue(num<0);
    }
}
