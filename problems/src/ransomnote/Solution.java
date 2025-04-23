package ransomnote;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Integer> ransomCount = new HashMap<>();
    for (char character : ransomNote.toCharArray()) {
      ransomCount.put(character, ransomCount.getOrDefault(character, 0) + 1);
    }

    Map<Character, Integer> magazineCount = new HashMap<>();
    for (char character : magazine.toCharArray()) {
      magazineCount.put(character, magazineCount.getOrDefault(character, 0) + 1);
    }

    for (Map.Entry<Character, Integer> entry : ransomCount.entrySet()) {
      int count = magazineCount.getOrDefault(entry.getKey(), 0);
      if (count < entry.getValue()) {
        return false;
      }
    }

    return true;
  }
}