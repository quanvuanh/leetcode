package interviewprep.countfrequency;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public static void main(String[] args) {
    Map<String, Integer> a = Solution.countFrequency("This is a text with some word repetitions hi hello is what who he is like that or when he is are we like that okay");
    System.out.println(a);
  }

  public static Map<String, Integer> countFrequency(String text) {
    String[] words = text.split(" ");
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
