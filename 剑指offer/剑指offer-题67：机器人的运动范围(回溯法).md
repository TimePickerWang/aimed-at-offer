**题目描述**
--------

地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
这题和[剑指offer-题66：矩阵中的路径(回溯法)](https://blog.csdn.net/wang454592297/article/details/80083290)类似，都是用回溯法解决，具体代码如下：


java:
```
public class Solution {
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
}
```


python:
```
略
```