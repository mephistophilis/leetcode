package tests;
//201. Bitwise AND of Numbers Range

//https://leetcode.com/problems/bitwise-and-of-numbers-range/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution_201 {

  public int rangeBitwiseAnd(int left, int right) {
    if (left == 0) {
      return 0;
    }
    int moveFactor = 1;
    while (left != right) {
      left >>= 1;
      right >>= 1;
      moveFactor <<= 1;
    }
    return left * moveFactor;
  }

  @Test
  void test() {
    Assertions.assertEquals(4,
        rangeBitwiseAnd(5, 7));
  }
}