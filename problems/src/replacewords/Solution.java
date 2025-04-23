package replacewords;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/replace-words
 */
public class Solution {
  public String replaceWords(List<String> dictionary, String sentence) {
    String[] words = sentence.split(" ");
    dictionary.sort(Comparator.comparingInt(String::length));

    for (int i = 0; i < words.length; i++) {
      for (String dictionaryWord : dictionary) {
        if (words[i].startsWith(dictionaryWord)) {
          words[i] = dictionaryWord;
        }
      }
    }

    return String.join(" ", words);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    List<String> dictionary = new ArrayList<>();
    dictionary.add("cattl");
    dictionary.add("cat");
    dictionary.add("bat");
    dictionary.add("rat");

    String replaced = s.replaceWords(dictionary, "the cattle was rattled by the battery");
    System.out.println(replaced);
  }
}
