package longestpalindrome;

import java.util.*;

class Solution {
  public int longestPalindrome(String s) {
    if (s.length() == 1) {
      return 1;
    }

    Map<Character, Integer> charCount = new HashMap<>();
    for (char character : s.toCharArray()) {
      charCount.put(character, charCount.getOrDefault(character, 0) + 1);
    }

    boolean oddExists = charCount.values().stream().anyMatch(value -> value % 2 == 1);

    int sum = charCount
      .values()
      .stream()
      .mapToInt(Integer::intValue)
      .map(i -> i % 2 == 0 ? i - 1 : i )
      .sum();

    if (oddExists) {
      sum++;
    }

    return sum;
  }
}