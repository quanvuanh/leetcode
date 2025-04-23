package problem1380;

import java.util.ArrayList;
import java.util.List;

public class Solution1380 {
  public List<Integer> luckyNumbers(int[][] matrix) {
    int rows = matrix.length;
    int columns = matrix[0].length;
    int[] minRow = new int[rows];
    int[] maxCol = new int[columns];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        maxCol[j] = Math.max(matrix[i][j], maxCol[j]);
        if (minRow[i] == 0) {
          minRow[i] = matrix[i][j];
        } else {
          minRow[i] = Math.min(matrix[i][j], minRow[i]);
        }
      }
    }

    List<Integer> luckyNumbers = new ArrayList<>();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (minRow[i] == maxCol[j] && !luckyNumbers.contains(minRow[i])) {
          luckyNumbers.add(minRow[i]);
        }
      }
    }

    return luckyNumbers;
  }

  public static void main(String[] args) {
    // 01, 10, 04, 02 -> 01
    // 09, 03, 08, 07 -> 03
    // 15, 16, 17, 12 -> 12

    // 15, 16, 17, 12
    Solution1380 s = new Solution1380();
    int[][] matrix = new int[][]{
      new int[]{1,10,4,2},
      new int[]{9,3,8,7},
      new int[]{15,16,17,12},

    };

    List<Integer> res = s.luckyNumbers(matrix);
    System.out.println(res);
  }
}
