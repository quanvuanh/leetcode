package reversesubstringsbetweeneachparenthesis;

import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses
 */
public class Solution2 {
  public String reverseParentheses(String s) {
    Stack<Integer> opened = new Stack<>();
    int[] parenthesisPairs = new int[s.length()];

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        opened.push(i);
        continue;
      }

      if (s.charAt(i) == ')') {
        int openIndex = opened.pop();
        parenthesisPairs[i] = openIndex;
        parenthesisPairs[openIndex] = i;
      }
    }

    int currentPos = 0;
    int direction = 1;
    StringBuilder result = new StringBuilder();
    while (currentPos < s.length()) {
      char c = s.charAt(currentPos);
      if (c == '(' || c == ')') {
        direction *= -1;
        currentPos = parenthesisPairs[currentPos];
      } else {
        result.append(s.charAt(currentPos));
      }

      currentPos += direction;
    }

    return result.toString();
  }

  public static void main(String[] args) {
    Solution2 s = new Solution2();
    String reversed = s.reverseParentheses("(ed(et(oc))el)");
    System.out.println(reversed);
  }
}
