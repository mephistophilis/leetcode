package tests;

import java.util.List;

class TestHelper {
    public static <E> boolean compareList(List<E> result, List<E> expected) {
        return result.equals(expected);
    }
}