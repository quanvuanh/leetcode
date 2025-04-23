package handofstraights;

import java.util.*;

/**
 * https://leetcode.com/problems/hand-of-straights/
 */
public class Solution {
  public boolean isNStraightHand(int[] hand, int groupSize) {
    if (hand.length % groupSize != 0) {
      return false;
    }

    // use Tree Map as it sorts automatically
    Map<Integer, Integer> frequencyMap = new TreeMap<>();
    for (int card : hand) {
      frequencyMap.put(card, frequencyMap.getOrDefault(card, 0) + 1);
    }

    while (!frequencyMap.isEmpty()) {
      Set<Integer> keys = frequencyMap.keySet();
      int smallest = keys.iterator().next();
      for (int i = smallest; i < smallest + groupSize; i++) {
        int count = frequencyMap.getOrDefault(i, 0);
        if (count == 0) {
          return false;
        }

        if (count == 1) {
          frequencyMap.remove(i);
        } else {
          frequencyMap.put(i, count - 1);
        }
      }
    }

    return true;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] hand = {1,2,3,6,2,3,4,7,8};

    System.out.println(s.isNStraightHand(hand, 3));
  }
}
