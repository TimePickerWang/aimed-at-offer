**题目描述**
--------

输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
![这里写图片描述](http://img.blog.csdn.net/20180321154106804?/2/text/Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](http://img.blog.csdn.net/20180321154113727?/2/text/Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](http://img.blog.csdn.net/20180321154119896?/2/text/Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)


java:
```
import java.util.Arrays;

public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length <= 0) {
			return false;
		}
		int rootValue = sequence[sequence.length - 1];
		int leftTreeIndex, rightTreeIndex; // 左右子树的索引
		for (leftTreeIndex = 0; leftTreeIndex < sequence.length - 1; leftTreeIndex++) {
			if (sequence[leftTreeIndex] > rootValue) {
				break;
			}
		}
		for (rightTreeIndex = leftTreeIndex; rightTreeIndex < sequence.length - 1; rightTreeIndex++) {
			if (sequence[rightTreeIndex] < rootValue) {
				return false;
			}
		}
		boolean leftTree = true;
		boolean rightTree = true;
		if (leftTreeIndex > 0) {
			int[] leftArray = Arrays.copyOfRange(sequence, 0, leftTreeIndex);
			leftTree = VerifySquenceOfBST(leftArray);
		}
		if (leftTreeIndex < sequence.length - 1) {
			int[] rightArray = Arrays.copyOfRange(sequence, leftTreeIndex, sequence.length - 1);
			rightTree = VerifySquenceOfBST(rightArray);
		}
		return leftTree && rightTree;
    }
}
```


python:
```
# -*- coding:utf-8 -*-
class Solution:
    def VerifySquenceOfBST(self, sequence):
        # write code here
        if len(sequence) == 0 or sequence is None:
            return False
        root_value = sequence[-1]
        left_tree_index = 0
        while sequence[left_tree_index] < root_value and left_tree_index < len(sequence) - 1:
            left_tree_index += 1
        right_tree_index = left_tree_index
        while right_tree_index < len(sequence) - 1:
            if sequence[right_tree_index] < root_value:
                return False
            else:
                right_tree_index += 1
        right = True
        left = True
        if left_tree_index > 0:
            left = self.VerifySquenceOfBST(sequence[0:left_tree_index])
        if left_tree_index < len(sequence) - 1:
            right = self.VerifySquenceOfBST(sequence[left_tree_index: -1])
        return left and right
```