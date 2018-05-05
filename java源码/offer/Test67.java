package offer;

/**
 * 剑指offer-题67：机器人的运动范围
 * 
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数
 * 位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因
 * 为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */

public class Test67 {
	public int movingCount(int threshold, int rows, int cols) {
		boolean[] visited = new boolean[rows * cols];
		int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
		return count;
	}

	public int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
		int count = 0;
		if (cheak(threshold, rows, cols, row, col, visited)) {
			visited[row * cols + col] = true;
			count = 1 + movingCountCore(threshold, rows, cols, row + 1, col, visited)
					+ movingCountCore(threshold, rows, cols, row - 1, col, visited)
					+ movingCountCore(threshold, rows, cols, row, col + 1, visited)
					+ movingCountCore(threshold, rows, cols, row, col - 1, visited);
		}
		return count;
	}

	public boolean cheak(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
		if (row >= 0 && col >= 0 && row < rows && col < cols && !visited[row * cols + col]
				&& getDigitSum(row) + getDigitSum(col) <= threshold) {
			return true;
		}
		return false;
	}

	// 每位数字之和
	public int getDigitSum(int num) {
		int sum = 0;
		while (num != 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		Test67 test67 = new Test67();
		System.out.println(test67.movingCount(2, 10, 10));
	}
}
