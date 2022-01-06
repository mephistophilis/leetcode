package tests;
//21. Merge Two Sorted Lists

//https://leetcode.com/problems/merge-two-sorted-lists/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.ListNode;
import tests.common.TestHelper;

class Solution_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    @Test
    void test() {
        Assertions.assertTrue(TestHelper.compareListNode(
                mergeTwoLists(TestHelper.arrayStringToListNode("[1,2,4]"),
                        TestHelper.arrayStringToListNode("[1,3,4]")),
                TestHelper.arrayStringToListNode("[1,1,2,3,4,4]")));

        Assertions.assertTrue(TestHelper.compareListNode(
                mergeTwoLists(TestHelper.arrayStringToListNode("[]"), TestHelper.arrayStringToListNode("[]")),
                TestHelper.arrayStringToListNode("[]")));

        Assertions.assertTrue(TestHelper.compareListNode(
                mergeTwoLists(TestHelper.arrayStringToListNode("[]"), TestHelper.arrayStringToListNode("[0]")),
                TestHelper.arrayStringToListNode("[0]")));
    }
}