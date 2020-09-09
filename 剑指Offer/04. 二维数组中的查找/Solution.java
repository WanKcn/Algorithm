class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                if (matrix[i][j] == target)
                    return true;
            }
        }
        return false;

    }
}