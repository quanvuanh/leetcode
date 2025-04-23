package subsequence;

class Solution {
  public static int appendCharacters(String s, String t) {
    int sCounter = 0;
    int tCounter = 0;
    while (sCounter < s.length() && tCounter < t.length()) {
      if (s.charAt(sCounter) == t.charAt(tCounter)) {
        sCounter++;
        tCounter++;
      } else {
        sCounter++;
      }
    }

    return t.length() - tCounter;
  }

  public static void main(String[] args) {
    System.out.println(
      Solution.appendCharacters("coaching", "coding")
    );
  }
}