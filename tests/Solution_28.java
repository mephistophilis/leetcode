package tests;
//28. Implement strStr()

//https://leetcode.com/problems/implement-strstr/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution_28 {

  public int strStr(String haystack, String needle) {
    if (needle.length() == 0) {
      return 0;
    }
    if (haystack.length() == 0) {
      return -1;
    }
    int m = needle.length();
    int MOD = 1000000;
    int MAGIC_NUM = 31;

    // 计算power，也就是幂，用于后面删除头用，所以要多计算一位
    int power = 1;
    for (int i = 0; i < m; i++) {
      power = power * MAGIC_NUM % MOD;
    }

    // 计算pat的hash值
    int patHash = 0;
    for (int i = 0; i < m; i++) {
      patHash = (patHash * MAGIC_NUM + needle.charAt(i)) % MOD;
    }

    // subHash
    int subStrHash = 0;
    int n = haystack.length();
    for (int i = 0; i < n; i++) {
      subStrHash = (subStrHash * MAGIC_NUM + haystack.charAt(i)) % MOD;
      // 如果不够pat的长度
      if (i < m - 1) {
        continue;
      }
      // 如果超过pat的长度,要去掉头
      if (i >= m) {
        subStrHash = subStrHash - (haystack.charAt(i - m) * power) % MOD;
        if (subStrHash < 0) {
          subStrHash += MOD;
        }
      }

      // double check
      if (subStrHash == patHash) {
        if (haystack.subSequence(i - m + 1, i + 1).equals(needle)) {
          return i - m + 1;
        }
      }
    }
    return -1;
  }

  @Test
  void test() {
    Assertions.assertEquals(4, strStr("mississippi", "issip"));
  }
}
