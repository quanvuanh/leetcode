package commoncharacters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public List<String> commonChars(String[] words) {
    String commonChars = words[0];
    for (int i = 1; i < words.length; i++) {
      commonChars = findCommon(commonChars, words[i]);
    }

    if (commonChars.isEmpty()) {
      return new ArrayList<>();
    }

    return Arrays.asList(commonChars.split(""));
  }

  private static String findCommon(String word1, String word2) {
    List<String> commons = new ArrayList<>();
    for (String cw2 : word2.split("")) {
      int index = word1.indexOf(cw2);
      if (index >= 0) {
        commons.add(cw2);
        word1 = word1.replaceFirst(cw2, "");
      }
    }

    return String.join("", commons);
  }

  public static void main(String[] args) {
    String common = Solution.findCommon("hello", "lhaobl");
    System.out.println(common);
  }
}
