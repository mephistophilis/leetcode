package tests.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestHelper {
    public static <E> boolean compareList(List<E> result, List<E> expected) {
        return result.equals(expected);
    }

    public static Node arrayStringToNode(String stringArray) {

        Integer arr[] = arrayStringToIntegerArray(stringArray);

        if (arr.length == 0) {
            return null;
        }

        return arrayToNode(arr, 0);
    }

    public static boolean isSameNode(Node s, Node t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;

        if (s.val != t.val)
            return false;

        if (s.next != null && t.next == null) {
            return false;
        }

        if (s.next == null && t.next != null) {
            return false;
        }

        if (s.next != null && t.next != null) {
            if (s.next.val != t.next.val)
                return false;
        }

        return isSameNode(s.left, t.left) && isSameNode(s.right, t.right);
    }

    public static boolean isSameTreeNode(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;

        if (s.val != t.val)
            return false;

        return isSameTreeNode(s.left, t.left) && isSameTreeNode(s.right, t.right);
    }

    public static TreeNode arrayStringToTreeNode(String stringArray) {
        int arr[] = arrayStringToIntArray(stringArray);

        if (arr.length == 0) {
            return null;
        }

        return arrayToTreeNode(arr, 0);
    }

    static TreeNode arrayToTreeNode(int[] array, int index) {
        return index < array.length
                ? new TreeNode(array[index], arrayToTreeNode(array, index * 2 + 1),
                        arrayToTreeNode(array, index * 2 + 2))
                : null;
    }

    static Node arrayToNode(Integer[] array, int index) {

        if (index < array.length) {
            if (array[index] == null) {
                return null;
            }

            return new Node(array[index], arrayToNode(array, index * 2 + 1), arrayToNode(array, index * 2 + 2), null);
        }

        return null;
    }

    public static Integer[] arrayStringToIntegerArray(String stringArray) {
        String[] items = stringArray.replaceAll("\\[", "").replaceAll("\\]",
                "").replaceAll("\\s", "").split(",");

        Integer[] results = new Integer[items.length];

        for (int i = 0; i < items.length; i++) {
            try {
                results[i] = Integer.parseInt(items[i]);
            } catch (NumberFormatException nfe) {
                if (items[i] == "null" || items[i] == "#") {
                    results[i] = null;
                }
            }
        }
        return results;
    }

    public static int[] arrayStringToIntArray(String stringArray) {

        if (stringArray.length() <= 2) {
            return new int[0];
        }
        int[] intArray = Arrays.stream(stringArray.substring(1, stringArray.length() - 1).split(","))
                .map(String::trim).mapToInt(Integer::parseInt).toArray();
        return intArray;
    }

    public static int[][] arrayStringTo2DIntArray(String stringArray) {
        if (stringArray.length() <= 4) {
            return new int[0][0];
        }
        return Arrays.stream(stringArray.substring(2, stringArray.length() - 2).split("\\],\\["))
                .map(e -> Arrays.stream(e.split("\\s*,\\s*")).map(String::trim).map(Integer::parseInt).mapToInt(i -> i)
                        .toArray())
                .toArray(int[][]::new);
    }

    public static char[][] arrayStringTo2DCharArray(String stringArray) {
        if (stringArray.length() <= 4) {
            return new char[0][0];
        }

        Character[][] characters = Arrays.stream(stringArray.substring(2, stringArray.length() - 2)
                .split("\\],\\["))
                .map(e -> Arrays.stream(e.split("\\s*,\\s*"))
                        .map(String::trim)
                        .map(s -> s.charAt(1))
                        .toArray(Character[]::new))
                .toArray(Character[][]::new);

        char[][] ret = new char[characters.length][characters[0].length];

        for (int r = 0; r < characters.length; r++) {
            for (int c = 0; c < characters[0].length; c++) {
                ret[r][c] = characters[r][c];
            }
        }

        return ret;
    }

    public static List<Integer> arrayStringToIntList(String stringArray) {
        List<Integer> list = Arrays.stream(arrayStringToIntArray(stringArray))
                .boxed()
                .collect(Collectors.toList());
        return list;
    }

    public static List<List<Integer>> array2DStringToIntList(String stringArray) {
        int[][] arrs = arrayStringTo2DIntArray(stringArray);

        if (arrs == null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        for (int[] arr : arrs) {
            List<Integer> list = Arrays.stream(arr)
                    .boxed()
                    .collect(Collectors.toList());

            lists.add(list);
        }

        return lists;
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