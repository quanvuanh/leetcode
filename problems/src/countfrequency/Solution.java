package countfrequency;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public static void main(String[] args) {

  }

  public static Map<String, Integer> countFrequency(String[] words) {
    Map<String, Integer> frequency = new HashMap<>();
    for (String word : words) {
      frequency.put(
        word,
        frequency.getOrDefault(word, 0) + 1
      );
    }

    return frequency;
  }
}
