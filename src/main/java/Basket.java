import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Basket {
    public static final Double BOOK_PRICE = 8.0;
    public static final Double[] DISCOUNTS = new Double[]{0.0, 1.0, 0.95, 0.90, 0.80, 0.75};
    ArrayList<Integer> counts;
    ArrayList<Integer> factors;

    public Basket(Integer... itemCounts) {
        counts = list(itemCounts);
        Collections.sort(counts);

        factors = factorize(counts);
    }

    public Double price() {
        return factors.stream().
                mapToDouble(this::setPrice).
                sum();
    }

    private double setPrice(int n) {
        return n * BOOK_PRICE * discount(n);
    }

    private Double discount(int sum) {
        return DISCOUNTS[sum];
    }

    private ArrayList<Integer> list(Integer... i) {
        ArrayList<Integer> returnValue = new ArrayList<>();
        Collections.addAll(returnValue, i);
        return returnValue;
    }

    private ArrayList<Integer> factorize(ArrayList<Integer> integers) {
        ArrayList<Integer> returnValue = new ArrayList<>();

        if (integers.equals(listOfZeroes())) {
            return returnValue;
        } else {
            returnValue.add(countPositive(integers));
            returnValue.addAll((factorize(subtractOnes(integers))));
            return replace_5_3With_4_4(returnValue);
        }
    }

    private ArrayList<Integer> listOfZeroes() {
        return list(0,0,0,0,0);
    }

    public static ArrayList<Integer> replace_5_3With_4_4(ArrayList<Integer> integers) {
        if (integers.contains(5) && integers.contains(3)) {
            integers.remove(new Integer(3));
            integers.remove(new Integer(5));
            integers.add(4);
            integers.add(4);
            return replace_5_3With_4_4(integers);
        } else {
            return integers;
        }
    }

    private ArrayList<Integer> subtractOnes(ArrayList<Integer> integers) {
        return integers.stream().
                map(this::subtractOneIfPositive).
                collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    private int subtractOneIfPositive(int i) {
        if (isPositive(i)) {
            return i - 1;
        } else {
            return 0;
        }
    }

    private Integer countPositive(ArrayList<Integer> integers) {
        return integers.stream().
                filter(this::isPositive).
                collect(Collectors.toList()).
                size();
    }

    private boolean isPositive(Integer i) {
        return i > 0;
    }

    public ArrayList<Integer> factors() {
        return factors;
    }
}
