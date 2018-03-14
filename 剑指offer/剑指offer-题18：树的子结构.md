**题目描述**
--------

输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------

![这里写图片描述](http://img.blog.csdn.net/2018031410475278?watermark/2/text/Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![这里写图片描述](http://img.blog.csdn.net/2018031410480055?watermark/2/text/Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

java:
```
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
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		boolean result = false;
		if (root1 != null && root2 != null) {
			if (root1.val == root2.val) {
				result = DoseTree1HavaTree2(root1, root2);
			}
			if (!result) {
				result = HasSubtree(root1.left, root2);
			}
			if (!result) {
				result = HasSubtree(root1.right, root2);
			}
		}
		return result;
	}

	public boolean DoseTree1HavaTree2(TreeNode root1, TreeNode root2) {
		if (root2 == null) {
			return true;
		}
		if (root1 == null) {
			return false;
		}
		if (root1.val != root2.val) {
			return false;
		}
		return DoseTree1HavaTree2(root1.left, root2.left) && DoseTree1HavaTree2(root1.right, root2.right);
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
    def HasSubtree(self, pRoot1, pRoot2):
        # write code here
        result = False
        if pRoot1 is not None and pRoot2 is not None:
            if pRoot1.val == pRoot2.val:
                result = self.DoseTree1HaveTree2(pRoot1, pRoot2)
            if not result:
                result = self.HasSubtree(pRoot1.left, pRoot2)
            if not result:
                result = self.HasSubtree(pRoot1.right, pRoot2)
        return result

    def DoseTree1HaveTree2(self, pRoot1, pRoot2):
        if pRoot2 is None:
            return True
        if pRoot1 is None:
            return False
        if pRoot2.val != pRoot1.val:
            return False
        return self.DoseTree1HaveTree2(pRoot1.right, pRoot2.right) and self.DoseTree1HaveTree2(pRoot1.left, pRoot2.left)
```