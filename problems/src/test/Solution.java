package test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int subarraysDivByK(int[] nums, int k) {
    Map<Integer, Integer> prefixSumRemainder = new HashMap<>();
    prefixSumRemainder.put(0, 1);
    int sum = 0;
    for (int num : nums) {
      sum += num;
      int remainder = sum % k;
      if (remainder < 0) {
        remainder = k + remainder;
      }
      prefixSumRemainder.put(remainder, prefixSumRemainder.getOrDefault(remainder, 0) + 1);
    }

    int total = 0;
    for (int count : prefixSumRemainder.values()) {
      if (count < 2) {
        continue;
      }

      for (int i=1; i<count;i++) {
        total += i;
      }
    }

    return total;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] a = {2,2,2};
    // {0, 2, 4, 6}
    // {0, 0, 0, 0} mode 2
    int c = s.subarraysDivByK(a, 2);


    int[] b = {4,5,0,-2,-3,1};
    // {0, 4, 9, 9, 7, 4, 5}
    // {0, 4, 4, 4, 2, 4, 0} mod 5
    int bRes = s.subarraysDivByK(b, 5);

    int[] ok = {-1,2,9}; // k = 2; expected = 2
    // 0, -1, 1, 10
    // 0, -1, 1, 0
//    System.out.println(s.subarraysDivByK(ok, 2));

    int[] x = {2,-2,2,-4}; // k = 6; expected = 2
    // {0, 2, 0, 2, -2}
    // {0, 2, 0, 2, -2}
    int xres = s.subarraysDivByK(x, 6);
    System.out.println(xres);
  }
}
