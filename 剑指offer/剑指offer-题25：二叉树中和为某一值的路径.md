**题目描述**
--------

输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
![这里写图片描述](https://img-blog.csdn.net/2018032319231731?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/20180323192325209?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/20180323192339869?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/20180323192349121?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/20180323192357751?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)


java:
```
import java.util.ArrayList;
import java.util.Stack;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    int curSum = 0;
    Stack<Integer> pathStack = new Stack<>();
	ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null) {
			return pathList;
		}
		curSum += root.val;
		pathStack.push(root.val);

		boolean isLeafNode = root.left == null && root.right == null;
		if (curSum == target && isLeafNode) {
			ArrayList<Integer> path = new ArrayList<Integer>();
			for (Integer value : pathStack) {
				path.add(value);
			}
			pathList.add(path);
		}
		if (root.left != null) {
			FindPath(root.left, target);
		}
		if (root.right != null) {
			FindPath(root.right, target);
		}
		pathStack.pop();
		curSum -= root.val;
		return pathList;
    }
}
```


python:
```
# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    path_list = []
    stack = []
    cur_sum = 0
    # 返回二维列表，内部每个列表表示找到的路径
    def FindPath(self, root, expectNumber):
        self.path_list = []
        self.stack = []
        self.cur_sum = 0
        return self.get_path(root, expectNumber)

    def get_path(self, root, expectNumber):
        if root is None:
            return self.path_list
        self.cur_sum += root.val
        self.stack.append(root.val)

        is_leaf = root.right is None and root.left is None
        if self.cur_sum == expectNumber and is_leaf:
            temp_path = self.stack[:]
            self.path_list.append(temp_path)
        if root.left:
            self.get_path(root.left, expectNumber)
        if root.right:
            self.get_path(root.right, expectNumber)
        self.stack.pop()
        self.cur_sum -= root.val
        return self.path_list
```