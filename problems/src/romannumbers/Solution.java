package romannumbers;

import java.util.*;

class Solution {
  private final Map<String, Integer> numbers;
  private final Map<String, Integer> specialNumbers;

  public Solution() {
    this.numbers = new HashMap<>();
    numbers.put("I", 1);
    numbers.put("V", 5);
    numbers.put("X", 10);
    numbers.put("L", 50);
    numbers.put("C", 100);
    numbers.put("D", 500);
    numbers.put("M", 1000);

    this.specialNumbers = new HashMap<>();
    specialNumbers.put("CM", 900);
    specialNumbers.put("CD", 400);
    specialNumbers.put("XL", 40);
    specialNumbers.put("XC", 90);
    specialNumbers.put("IV", 4);
    specialNumbers.put("IX", 9);
  }

  /**
   * Converts the roman string number to int number
   *
   * @param s roman number string
   * @return int representation of roman number string
   */
  public int romanToInt(String s) {
    for (Map.Entry<String, Integer> entry : specialNumbers.entrySet()) {
      s = s.replaceAll(entry.getKey(), entry.getValue().toString() + ",");
    }
    for (Map.Entry<String, Integer> entry : numbers.entrySet()) {
      s = s.replaceAll(entry.getKey(), entry.getValue().toString() + ",");
    }
    String[] a = s.split(",");

    return Arrays.stream(a).mapToInt(Integer::parseInt).sum();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.romanToInt("MMM"));
  }
}
