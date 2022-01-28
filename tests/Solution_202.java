package tests;
//986. Interval List Intersections

//https://leetcode.com/problems/interval-list-intersections/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution_202 {

    public boolean isHappy(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = sum(slow);
            fast = sum(fast);
            fast = sum(fast);
        } while (slow != fast);
        if (slow == 1)
            return true;
        else
            return false;
    }

    int sum(int n) {
        int sum = 0;
        while (n != 0) {
            int tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }

    @Test
    void test() {
        Assertions
                .assertFalse(
                        isHappy(2));
        Assertions
                .assertTrue(
                        isHappy(19));

    }
}