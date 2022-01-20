package tests;
//413. Arithmetic Slices

//https://leetcode.com/problems/arithmetic-slices/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.TestHelper;

class Solution_413 {
  public int numberOfArithmeticSlices(int[] nums) {
    if (nums == null || nums.length == 0)
      return 0;
    int[] index = new int[nums.length];
    int sum = 0;
    for (int i = 2; i < index.length; i++) {
      if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
        if (index[i - 1] == 0)
          index[i] = 3;
        else
          index[i] = index[i - 1] + 1;
      } else
        index[i] = 0;

      if (index[i] != 0) {
        sum += index[i] - 3 + 1;
      }
    }

    return sum;
  }

  @Test
  void test() {
    Assertions.assertEquals(3,
        numberOfArithmeticSlices(TestHelper.arrayStringToIntArray("[1,2,3,4]")));

  }
}