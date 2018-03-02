**题目描述**
--------

输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------

和二叉树相关的遍历方式如下：
![这里写图片描述](http://img.blog.csdn.net/20180302221348159?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![这里写图片描述](http://img.blog.csdn.net/20180302221401486?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)


java:

```
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = new TreeNode(pre[0]);
		root.left = null;
		root.right = null;
		int rootIndex = 0; // 根节点在中序遍历的位置
		while (rootIndex < in.length && root.val != in[rootIndex]) {
			rootIndex++;
		}

		int rightLength = in.length - rootIndex - 1; // 根节点右子树节点个数

		if (rootIndex > 0) { // 构造左子树
			int[] inTemp = new int[rootIndex];
			int[] preTemp = new int[rootIndex];
			for (int i = 0; i < rootIndex; i++) {
				inTemp[i] = in[i];
			}
			for (int j = 1; j <= rootIndex; j++) {
				preTemp[j - 1] = pre[j];
			}

			root.left = reConstructBinaryTree(preTemp, inTemp);
		}
		if (rightLength > 0) { // 构造右子树
			int[] inTemp = new int[rightLength];
			int[] preTemp = new int[rightLength];
			for (int i = 0; i < rightLength; i++) {
				inTemp[i] = in[rootIndex + 1 + i];
			}
			for (int j = 1; j <= rightLength; j++) {
				preTemp[j - 1] = pre[rootIndex + j];
			}

			root.right = reConstructBinaryTree(preTemp, inTemp);
		}
		return root;
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
    # 返回构造的TreeNode根节点
    def reConstructBinaryTree(self, pre, tin):
        # write code here
        node = TreeNode(pre[0])
        root_index = tin.index(pre[0])
        right_length = len(tin) - root_index - 1
        if root_index > 0:
            node.left = self.reConstructBinaryTree(pre[1: root_index + 1], tin[0:root_index])  # 构造左子树
        if right_length > 0:
            node.right = self.reConstructBinaryTree(pre[root_index + 1:], tin[root_index + 1:])  # 构造右子树
        return node
```