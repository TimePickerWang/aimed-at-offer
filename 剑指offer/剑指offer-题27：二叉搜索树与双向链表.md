**题目描述**
--------

输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
![这里写图片描述](https://img.blog.csdn.net/20180329190013564?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img.blog.csdn.net/20180329190023168?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img.blog.csdn.net/20180329190031852?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)



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
    TreeNode lastNode = null;
	
	public TreeNode Convert(TreeNode pRootOfTree) {
		convertNode(pRootOfTree);
		TreeNode headNode = lastNode;
		while (headNode != null && headNode.left != null) {
			headNode = headNode.left;
		}
		return headNode;
	}

	public void convertNode(TreeNode node) {
		if (node == null) {
			return;
		}
		TreeNode curNode = node;
		if (curNode.left != null) {
			convertNode(curNode.left);
		}

		if (lastNode != null) {
			lastNode.right = curNode;
			curNode.left = lastNode;
		}
		lastNode = curNode;
		if (curNode.right != null) {
			convertNode(curNode.right);
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
    last_node = None
    
    def Convert(self, pRootOfTree):
        # write code here
        self.convert_node(pRootOfTree)
        head_node = self.last_node
        while head_node is not None and head_node.left is not None:
            head_node = head_node.left
        return head_node

    def convert_node(self, node):
        if node is None:
            return
        cur_node = node
        if cur_node.left is not None:
            self.convert_node(cur_node.left)
        if self.last_node is not None:
            self.last_node.right = cur_node
            cur_node.left = self.last_node
        self.last_node = cur_node
        if cur_node.right is not None:
            self.convert_node(cur_node.right)
```