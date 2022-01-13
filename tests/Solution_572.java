package tests;
//572. Subtree of Another Tree

//https://leetcode.com/problems/subtree-of-another-tree/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.TestHelper;
import tests.common.TreeNode;

class Solution_572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        if (isSame(s, t))
            return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;

        if (s.val != t.val)
            return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    @Test
    void test() {
        Assertions.assertTrue(
                isSubtree(TestHelper.arrayStringToTreeNode("[3,4,5,1,2]"),
                        TestHelper.arrayStringToTreeNode("[4,1,2]")));

    }
}