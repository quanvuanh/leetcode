package problem1605;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/
 */
public class Solution1605 {

  public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
    int[][] matrix = new int[rowSum.length][colSum.length];

    for (int i = 0; i < rowSum.length; i++) {
      for (int j = 0; j < colSum.length; j++) {
        matrix[i][j] = Math.min(rowSum[i], colSum[j]);
        rowSum[i] -= matrix[i][j];
        colSum[j] -= matrix[i][j];
      }
    }

    return matrix;
  }

  public static void main(String[] args) {
    int[] rowSum = new int[]{5,7,10};
    int[] colSum = new int[]{8,6,8};

    Solution1605 s = new Solution1605();
    int[][] matrix = s.restoreMatrix(rowSum, colSum);
    System.out.println(Arrays.deepToString(matrix));
//    5 0 0 -> 5  -> 0
//    3 4 0 -> 7  -> 4 -> 0
//    0 2 8 -> 10 -> 8
//
//    8 6 8
//    3 2
//    0 0
  }
}
