**题目描述**
--------

在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


很多人开始是这样解决的：

```
public boolean Find(int target, int[][] array) {
		if (array.length > 0 && array[0].length > 0) {
			int row = array.length;
			int col = array[0].length;
			if (target < array[0][0] || target > array[row - 1][col - 1]) {
				return false;
			} else {
				for (int i = 0; i < row; i++) {
					if (target == array[i][0] || target == array[i][col - 1]) {
						return true;
					} else if (target > array[i][0] || target < array[i][col - 1]) {
						for (int j = 1; j < col - 1; j++) {
							if (target == array[i][j]) {
								return true;
							}
						}
					} else {
						continue;
					}
				}
				return false;
			}
		} else {
			return false;
		}
	}
```
![这里写图片描述](http://img.blog.csdn.net/20180227105811295?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
如上图，这样做会有部分区域重叠



**解决思路：**
---------

![这里写图片描述](http://img.blog.csdn.net/2018022710554853?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)


java:
```
public class Solution {
    public boolean Find(int target, int[][] array) {
		if (array.length > 0 && array[0].length > 0) {
			int arrlen = array.length;
			int col = array[0].length - 1;
			int row = 0;
			while (row < arrlen && col >= 0) {
				if (array[row][col] < target) {
					row++;
				} else if (array[row][col] > target) {
					col--;
				} else {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
    }
}
```

python:
```
# -*- coding:utf-8 -*-
class Solution:
    # array 二维列表
    def Find(self, target, array):
        arrlen = len(array)
        col = len(array[0]) - 1
        if arrlen > 0 and col > 1:
            row = 0
            while row < arrlen and col >= 0:
                if array[row][col] < target:
                    row = row + 1
                elif array[row][col] > target:
                    col = col - 1
                else:
                    return True
            return False
        else:
            return False
```