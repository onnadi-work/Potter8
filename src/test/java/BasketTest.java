import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasketTest {
    static final int BOOK_PRICE = 8;

    @Test
    public void testBaseCases() {
        assertEquals(0, new Basket(0, 0, 0, 0, 0).price(), 0.01);
        assertEquals(BOOK_PRICE, new Basket(1, 0, 0, 0, 0).price(), 0.01);
        assertEquals(BOOK_PRICE * 2 * 0.95, new Basket(1, 1, 0, 0, 0).price(), 0.01);
        assertEquals(BOOK_PRICE * 3 * 0.90, new Basket(1, 1, 1, 0, 0).price(), 0.01);
        assertEquals(BOOK_PRICE * 4 * 0.80, new Basket(1, 1, 1, 1, 0).price(), 0.01);
        assertEquals(BOOK_PRICE * 5 * 0.75, new Basket(1, 1, 1, 1, 1).price(), 0.01);
    }

    @Test
    public void givenSetOf5and3ReturnPriceOfSetOf4And4() {
        assertEquals(2 * (BOOK_PRICE * 4 * 0.8), new Basket(2, 2, 2, 1, 1).price(), 0.01);
    }

    @Test
    public void givenSetOf5and3inNonCanonicalOrderReturnPriceof4and4() {
        assertEquals(2 * (BOOK_PRICE * 4 * 0.8), new Basket(2, 1, 2, 2, 1).price(), 0.01);
    }

    @Test
    public void givenSetof5_3_1ReturnPriceOf4_4_1() {
        assertEquals(BOOK_PRICE + 2 * (BOOK_PRICE * 4 * 0.8), new Basket(2, 1, 3, 2, 1).price(), 0.01);
    }

    @Test
    public void givenTwoSetsOf1ReturnTwicePriceOf1() {
        assertEquals(BOOK_PRICE * 2, new Basket(0, 2, 0, 0, 0).price(), 0.01);
    }

    @Test
    public void given2SetsOf5sReturnTwicePriceOf5() {
        assertEquals(2 * BOOK_PRICE * 5 * 0.75, new Basket(2, 2, 2, 2, 2).price(), 0.01);
    }

    @Test
    public void givenFourSetsOf5AndOneSetOf3ReturnPriceOfThreeSetsOf5AndTwoSetsOf4() {
        assertEquals((3 * BOOK_PRICE * 5 * 0.75) + (2 * BOOK_PRICE * 4 * 0.8), new Basket(5, 5, 4, 5, 4).price(), 0.01);
    }
}
