package robotcollissions;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * https://leetcode.com/problems/robot-collisions
 */
public class Solution {
  public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
    Integer[] indices = new Integer[positions.length];
    for (int i = 0; i < positions.length; ++i) {
      indices[i] = i;
    }

    Arrays.sort(
      indices,
      Comparator.comparingInt(i -> positions[i])
    );

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < positions.length; i++) {
      int index = indices[i];
      if (directions.charAt(index) == 'R'
        || stack.empty()
        || directions.charAt(stack.peek()) == 'L') {
        stack.push(index);
        continue;
      }

      while (!stack.empty() && healths[index] > 0) {
        if (directions.charAt(stack.peek()) == 'L') {
          stack.push(index);
          break;
        }

        int otherRobotIndex = stack.peek();
        // current robot wins
        if (healths[otherRobotIndex] < healths[index]) {
          stack.pop();
          healths[index]--;
          healths[otherRobotIndex] = 0;
        } else if (healths[otherRobotIndex] > healths[index]) {
          // other robot wins
          healths[otherRobotIndex]--;
          healths[index] = 0;
        } else {
          // both robots lose
          stack.pop();
          healths[index] = 0;
          healths[otherRobotIndex] = 0;
        }
      }
    }

    List<Integer> result = new ArrayList<>();
    for (int health : healths) {
      if (health > 0) {
        result.add(health);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    List<Integer> survivorHealth = s.survivedRobotsHealths(
      new int[]{17,24,18},
      new int[]{1,39,30},
      "LLR"
    );
//    List<Integer> survivorHealth = s.survivedRobotsHealths(
//      new int[]{3,5,2,6},
//      new int[]{10,10,15,12},
//      "RLRL"
//    );

//    List<Integer> survivorHealth = s.survivedRobotsHealths(
//      new int[]{5,4,3,2,1},
//      new int[]{2,17,9,15,10},
//      "RRRRR"
//    );

    System.out.println(survivorHealth);
  }
}
