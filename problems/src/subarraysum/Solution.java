package subarraysum;

import java.util.*;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/continuous-subarray-sum
 */
class Solution {
  public boolean checkSubarraySum(int[] nums, int k) {
    // prefixSum array is longer because first element is always 0
    // remainder -> index
    HashMap<Integer, Integer> prefixSum = new HashMap<>();
    prefixSum.put(0, -1);
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      int remainder =  sum % k;
      if (prefixSum.containsKey(remainder)) {
        if (prefixSum.get(remainder) - i <= -2) {
          return true;
        }
      } else {
        prefixSum.put(remainder, i);
      }
    }

    return false;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] array = {0, 0};
    boolean a = s.checkSubarraySum(array, 13);

    System.out.println(a);
  }
}
