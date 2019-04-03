import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class FactorsTest {
    @Test
    public void testBaseCases() {
        assertEquals(list(), new Basket(0, 0, 0, 0, 0).factors());
        assertEquals(list(1), new Basket(1, 0, 0, 0, 0).factors());

    }

    @Test
    public void givenBasketOfSingleTypeReturn1s() {
        assertEquals(list(1, 1), new Basket(2, 0, 0, 0, 0).factors());
        assertEquals(list(1, 1), new Basket(0, 2, 0, 0, 0).factors());
    }

    @Test
    public void givenBasketOf1_2Return2_1() {
        assertEquals(list(2, 1), new Basket(1, 2, 0, 0, 0).factors());
    }

    @Test
    public void givenBasketOfSetOf5And3Return4_4() {
        assertEquals(list(4, 4), Basket.replace_5_3With_4_4(list(5, 3)));
        assertEquals(list(4, 4), new Basket(1, 1, 2, 2, 2).factors());
    }

    private ArrayList<Integer> list(Integer... i) {
        ArrayList<Integer> returnValue = new ArrayList<>();
        Collections.addAll(returnValue, i);
        return returnValue;
    }
}
