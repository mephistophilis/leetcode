package tests;
//82. Remove Duplicates from Sorted List II

//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.ListNode;
import tests.common.TestHelper;

class Solution_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode curHead = dummyHead.next;
        ListNode preHead = dummyHead;

        while(curHead != null) {
            while(curHead.next != null && curHead.val == curHead.next.val) {
                curHead = curHead.next;
            }

            if(preHead.next == curHead) {
                preHead = preHead.next;
            } else {
                preHead.next = curHead.next;
            }

            curHead = curHead.next;
        }

        return dummyHead.next;
    }

    @Test
    void test() {
        Assertions.assertTrue(TestHelper.compareListNode(
                deleteDuplicates(TestHelper.arrayStringToListNode("[1,2,3,3,4,4,5]")),
                TestHelper.arrayStringToListNode("[1,2,5]")));

        Assertions.assertTrue(TestHelper.compareListNode(
                deleteDuplicates(TestHelper.arrayStringToListNode("[1,1,1,2,3]")),
                TestHelper.arrayStringToListNode("[2,3]")));
    }
}