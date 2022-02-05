package tests;
//5. Longest Palindromic Substring

//https://leetcode.com/problems/longest-palindromic-substring/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution_5 {
  // public String longestPalindrome(String s) {
  // if (s == null) {
  // return "";
  // }

  // String longest = "";
  // for (int i = 0; i < s.length(); i++) {
  // String oddPalindrome = getPalindrome(s, i, i);
  // String evenPalindrome = getPalindrome(s, i, i + 1);

  // if (longest.length() < oddPalindrome.length()) {
  // longest = oddPalindrome;
  // }
  // if (longest.length() < evenPalindrome.length()) {
  // longest = evenPalindrome;
  // }

  // }
  // return longest;
  // }

  // private String getPalindrome(String s, int left, int right) {
  // while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
  // {
  // left--;
  // right++;
  // }

  // return s.substring(left + 1, right);
  // }

  public String longestPalindrome(String s) {
    int len = s.length();
    int longest = 0;
    int start = 0;

    boolean[][] dp = new boolean[len][len];

    for (int l = len - 1; l >= 0; l--) {
      for (int r = l; r < len; r++) {
        dp[l][r] = s.charAt(l) == s.charAt(r) && (r - l < 3 || dp[l + 1][r - 1]);

        if (dp[l][r] && (r - l + 1 > longest)) {
          start = l;
          longest = r - l + 1;
        }
      }
    }

    return s.substring(start, start + longest);
  }

  @Test
  void test() {
    /*
     * - b a b a d
     * - 0 1 2 3 4
     * 0 t f t f f
     * 1 f t f t f
     * 2 f f t f f
     * 3 f f f t f
     * 4 f f f f t
     */
    Assertions.assertEquals("bab",
        longestPalindrome("babad"));

  }
}
