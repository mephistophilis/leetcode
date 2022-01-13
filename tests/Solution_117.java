package tests;
//117. Populating Next Right Pointers in Each Node II

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.Node;
import tests.common.TestHelper;

class Solution_117 {

    public Node connect(Node root) {
        Node node = root, levelHead = new Node(0);

        while (node != null) {

            Node needle = levelHead;

            while (node != null) {

                if (node.left != null) {
                    needle.next = node.left;
                    needle = needle.next;
                }
                if (node.right != null) {
                    needle.next = node.right;
                    needle = needle.next;
                }

                node = node.next;
            }

            node = levelHead.next;

            levelHead.next = null;
        }

        return root;
    }

    @Test
    void test() {

        Assertions
                .assertTrue(TestHelper.isSameNode(connect(TestHelper.arrayStringToNode("[1,2,3,4,5,null,7]")),
                        connect(TestHelper.arrayStringToNode("[1,2,3,4,5,null,7]"))));

    }
}