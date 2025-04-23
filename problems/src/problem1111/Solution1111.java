package problem1111;

import java.util.Stack;

/**
 * https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 */
public class Solution1111 {
  public int[] maxDepthAfterSplit(String seq) {
    int[] answer = new int[seq.length()];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < seq.length(); i++) {
      if (seq.charAt(i) == '(') {
        stack.push(i);
      } else {
        int index = stack.pop();
        int group = stack.size() % 2 == 0 ? 1 : 0;
        answer[index] = group;
        answer[i] = group;
      }
    }

    return answer;
  }
}
