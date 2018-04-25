**题目描述**
--------

请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。例如：以下矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。

```
a b c e 
s f c s 
a d e e
```


实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
![这里写图片描述](https://img-blog.csdn.net/20180425175220483?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)


java:
```
public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if (matrix == null || str == null || matrix.length == 0 || str.length == 0 || rows < 1 || cols < 1) {
			return false;
		}
		boolean[] visited = new boolean[rows * cols];
		int strIndex = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (hasPathCore(matrix, str, visited, rows, cols, row, col, strIndex)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean hasPathCore(char[] matrix, char[] str, boolean[] visited, int rows, int cols, int row, int col,
			int strIndex) {
		if (strIndex == str.length) {
			return true;
		}
		boolean hasPath = false;
		if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row * cols + col] == str[strIndex]
				&& visited[row * cols + col] == false) {
			strIndex++;
			visited[row * cols + col] = true;

			hasPath = hasPathCore(matrix, str, visited, rows, cols, row - 1, col, strIndex)
					|| hasPathCore(matrix, str, visited, rows, cols, row + 1, col, strIndex)
					|| hasPathCore(matrix, str, visited, rows, cols, row, col - 1, strIndex)
					|| hasPathCore(matrix, str, visited, rows, cols, row, col + 1, strIndex);

			if (!hasPath) {
				strIndex--;
				visited[row * cols + col] = false;
			}
		}
		return hasPath;
	}
}
```


python:
```
略
```