package reversesubstringsbetweeneachparenthesis;

import java.util.Objects;
import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses
 */
public class Solution {
  public String reverseParentheses(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == ')') {
        char r;
        StringBuilder sub = new StringBuilder();
        while ((r = stack.pop()) != '(') {
          sub.append(r);
        }

        for (char re : sub.toString().toCharArray()) {
          stack.push(re);
        }

        continue;
      }

      stack.push(c);
    }

    StringBuilder result = new StringBuilder();
    for (char c : stack) {
      result.append(c);
    }

    return result.toString();
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String reversed = s.reverseParentheses("hel(ol) (ow)rld");
    System.out.println(reversed);
  }
}
