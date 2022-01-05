package tests;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class TestHelper {
    public static <E> boolean compareList(List<E> result, List<E> expected) {
        return result.equals(expected);
    }

    public static int[] arrayStringToIntArray(String stringArray) {
        int[] intArray = Arrays.stream(stringArray.substring(1, stringArray.length() - 1).split(","))
                .map(String::trim).mapToInt(Integer::parseInt).toArray();
        return intArray;
    }

    public static int[][] arrayStringTo2DIntArray(String stringArray) {
        return Arrays.stream(stringArray.substring(2, stringArray.length() - 2).split("\\],\\["))
                .map(e -> Arrays.stream(e.split("\\s*,\\s*")).map(String::trim).map(Integer::parseInt).mapToInt(i -> i)
                        .toArray())
                .toArray(int[][]::new);
    }

    public static List<Integer> arrayStringToIntList(String stringArray) {
        List<Integer> list = Arrays.stream(arrayStringToIntArray(stringArray))
                .boxed()
                .collect(Collectors.toList());
        return list;
    }
}