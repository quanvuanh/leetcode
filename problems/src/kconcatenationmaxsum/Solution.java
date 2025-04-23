package kconcatenationmaxsum;

/**
 * https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 */
public class Solution {
  public int kConcatenationMaxSum(int[] arr, int k) {
    int mod = (int) Math.pow(10, 9) + 7;

    int currentSum = 0;
    int highestSum = 0;
    int bestStartIndex = 0;
    int endIndex = 0;

    int startIndex = 0;
    for (int i = 0; i < arr.length; i++) {
      // if current decreases after adding
      if (currentSum > currentSum + arr[i]) {
        // reset subarray search
        currentSum = arr[i];
        startIndex = i+1;
      } else {
        endIndex = i;
      }

      currentSum = Math.max(arr[i], currentSum + arr[i]);

      if (currentSum > highestSum) {
        highestSum = currentSum;
        bestStartIndex = startIndex;
      }
    }

    if (bestStartIndex > 0 && endIndex < arr.length -1) {
      return highestSum;
    }

    if (bestStartIndex == 0 && endIndex == arr.length -1 ) {
      return highestSum * k;
    }

    if (k >= 2) {

    }

    return 0;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int result = s.kConcatenationMaxSum(new int[]{-2,1, -300, 2, 15, -32}, 2);
    System.out.println(result);
  }
}
