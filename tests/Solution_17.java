package tests;
//17. Letter Combinations of a Phone Number

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.TestHelper;

class Solution_17 {
    List<String> ans = new ArrayList<>();
    String[] keyPad = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return ans;
        backtrack(digits, 0, new StringBuilder(digits));
        return ans;
    }

    void backtrack(String digits, int i, StringBuilder sb) {
        if (i == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        int d = digits.charAt(i) - '0';
        for (char c : keyPad[d].toCharArray()) {
            sb.setCharAt(i, c);
            backtrack(digits, i + 1, sb);
        }
    }

    @Test
    void test() {
        Assertions.assertEquals(
                letterCombinations("23"),
                (TestHelper
                        .arrayStringToStringList("[\"ad\",\"ae\",\"af\",\"bd\",\"be\",\"bf\",\"cd\",\"ce\",\"cf\"]")));
    }
}