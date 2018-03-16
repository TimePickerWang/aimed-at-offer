**题目描述**
--------

操作给定的二叉树，将其变换为源二叉树的镜像。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
![这里写图片描述](http://img.blog.csdn.net/20180315214138383?watermark/2/text/Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

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
    public void Mirror(TreeNode root) {
        if (root == null) {
			return;
		} else if (root.left == null && root.right == null) {
			return;
		} else {
			TreeNode tempNode = null;
			tempNode = root.left;
			root.left = root.right;
			root.right = tempNode;

			if (root.left != null) {
				Mirror(root.left);
			}
			if (root.right != null) {
				Mirror(root.right);
			}
		}
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
    # 返回镜像树的根节点
    def Mirror(self, root):
        # write code here
        if root is None:
            return
        elif root.left is None and root.right is None:
            return
        else:
            temp = root.left
            root.left = root.right
            root.right = temp

            if root.left is not None:
                self.Mirror(root.left)
            if root.right is not None:
                self.Mirror(root.right)
```