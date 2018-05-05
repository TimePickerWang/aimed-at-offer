package offer;

import java.util.ArrayList;

/**
 * 剑指offer-题20：顺时针打印矩阵
 * 
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 * 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

public class Test20 {
	ArrayList<Integer> arrayList;

	public ArrayList<Integer> printMatrix(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		if (rows == 0 || cols == 0) {
			return null;
		}
		int start = 0;
		arrayList = new ArrayList<Integer>();
		while (cols > 2 * start && rows > 2 * start) {
			printMatrixInCircle(matrix, rows, cols, start);
			start++;
		}
		return arrayList;
	}

	public void printMatrixInCircle(int[][] matrix, int rows, int cols, int start) {
		int endX = cols - 1 - start;
		int endY = rows - 1 - start;

		// 从左到右打印一行
		for (int i = start; i <= endX; i++) {
			arrayList.add(new Integer(matrix[start][i]));
		}

		// 从上到下打印一列
		if (endY > start) {
			for (int i = start + 1; i <= endY; i++) {
				arrayList.add(new Integer(matrix[i][endX]));
			}
		}

		// 从右往左打印一行
		if (endY > start && endX > start) {
			for (int i = endX - 1; i >= start; i--) {
				arrayList.add(new Integer(matrix[endY][i]));
			}
		}

		// 从下往上打印一列
		if (endX > start && endY > start + 1) {
			for (int i = endY - 1; i > start; i--) {
				arrayList.add(new Integer(matrix[i][start]));
			}

		}

	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		ArrayList<Integer> list = new Test20().printMatrix(matrix);
		for (Integer integer : list) {
			System.out.print(integer + ", ");
		}
	}
}
