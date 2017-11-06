package test;

/**
 * Created by mengdongqi on 17-09-06.
 */
public class RotateMatrix {
  public static void swapRows(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
      return;
    }
    int m = matrix.length, start = 0, end = m - 1;
    while (start < end) {
      int[] tmp = matrix[start];
      matrix[start] = matrix[end];
      matrix[end] = tmp;

      start++;
      end--;
    }
  }


  // transpose a matrix [i, j] to [j, i]
  public static void transpose(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
      return;
    }
    int m = matrix.length, n = matrix[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = i + 1; j < n; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
      }
    }
  }
  public static void main(String args[]){

  }
}
