import java.util.*;


public class Solution {
    /**
     * 逆时针旋转矩阵
     *
     * @param matrix int整型二维数组 输入矩阵
     * @return int整型二维数组
     */
    public int[][] RotateMatrix(int[][] matrix) {
        // 从矩阵的最后一列开始遍历，把元素存进一个队列中，然后矩阵双层遍历用数组中的元素赋值
        Queue<Integer> queue = new LinkedList<>();
        int h = matrix.length;  // j
        int l = matrix[0].length;  // 3
        for (int j = l - 1; j >= 0; j--) {
            for (int i = 0; i < h; i++) {
                queue.add(matrix[i][j]);
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++)
                matrix[i][j] = queue.remove();
        }

        return matrix;

    }


}

/*
public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 0, 0}};
        int h = matrix.length;
        int l = matrix[0].length;


        System.out.println(matrix[0][2]);
        System.out.println(matrix[1][2]);
        System.out.println(matrix[2][2]);
        System.out.println(matrix[3][2]);

        System.out.println();
        System.out.println();

        for (int j = l - 1; j >= 0; j--) {
            for (int i = 0; i < h; i++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.println();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++)
                System.out.print(matrix[i][j] + " ");
        }


//        System.out.println(matrix[0][0]);
//        System.out.println(matrix[0][1]);
//        System.out.println(matrix[0][2]);
//        System.out.println(matrix[1][0]);
//        System.out.println(matrix[1][1]);
//        System.out.println(matrix[1][2]);


//        for (int i = 0; i <= h; i++) {
//            for (int j = l - 1; j >= 0; j--) {
//
//            }
//        }
* */
