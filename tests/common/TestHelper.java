package tests.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestHelper {
    public static <E> boolean compareList(List<E> result, List<E> expected) {
        return result.equals(expected);
    }

    public static int[] arrayStringToIntArray(String stringArray) {
        if (stringArray.length() <= 2) {
            return null;
        }
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

    public static ListNode arrayStringToListNode(String stringArray) {
        return intArrayToListNode(arrayStringToIntArray(stringArray));
    }

    public static ListNode intArrayToListNode(int arr[]) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode curNode = new ListNode(0);
        ListNode dummyNode = curNode;

        for (int val : arr) {
            curNode.next = new ListNode(val);
            curNode = curNode.next;
        }

        return dummyNode.next;
    }

    public static boolean compareListNode(ListNode n1, ListNode n2) {
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                return false;
            } else {
                n1 = n1.next;
                n2 = n2.next;
            }
        }
        if (n1 == null && n2 == null) {
            return true;
        }

        return false;
    }
}