package tests;
//384. Shuffle an Array

//https://leetcode.com/problems/shuffle-an-array/

import org.junit.jupiter.api.Test;

class Solution_384 {

  private int[] nums;

  public Solution_384(int[] nums) {
    this.nums = nums;
  }

  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    return nums;
  }

  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
    int[] rand = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      int r = (int) (Math.random() * (i + 1));
      rand[i] = rand[r];
      rand[r] = nums[i];
    }
    return rand;
  }

  @Test
  void test() {

  }
}