package tests;
//139. Word Break

import java.util.List;

//https://leetcode.com/problems/word-break/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.TestHelper;

class Solution_139 {
  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] f = new boolean[s.length() + 1];

    f[0] = true;

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (f[j] && wordDict.contains(s.substring(j, i))) {
          f[i] = true;
          break;
        }
      }
    }

    return f[s.length()];
  }

  @Test
  void test() {
    Assertions.assertTrue(wordBreak("leetcode", TestHelper.arrayStringToStringList("[\"leet\",\"code\"]")));
  }
}