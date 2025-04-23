package problem374;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int guess = solution.guessNumber(2126753390);

    System.out.println(guess);
  }

  public int guessNumber(int n) {
    int currentGuess = n;
    int upperBound = n;
    int lowerBound = 1;

    int result;
    while((result = guess(currentGuess)) !=0) {
      if (result == -1) {
        upperBound = currentGuess;
      }

      if (result == 1) {
        lowerBound = currentGuess;
      }

      currentGuess = lowerBound + ((upperBound - lowerBound)/2);
    }

    return currentGuess;
  }

  private int guess(int guess) {
    return Integer.compare(1702766719, guess);
  }
}
