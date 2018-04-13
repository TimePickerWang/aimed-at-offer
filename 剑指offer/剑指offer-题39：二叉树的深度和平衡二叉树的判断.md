**题目描述**
--------

题一：输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

 题二：输入一棵二叉树的根结点，判断该二叉树是否是平衡二叉树。如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一颗平衡二叉树。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
题一的解题思路：

![这里写图片描述](https://img.blog.csdn.net/20180412151805133?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img.blog.csdn.net/2018041215190554?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

题二的解题思路：

第二题我先说下运行结果吧，运行时间范围为10~20ms。这个方法是我自己琢磨出来的，跟书上的不同。所有结点只需遍历一次，结合后序遍历的思想，从二叉树的叶节点开始判断，如果某个叶结点的左、右子树深度相差超过1，则返回-2作为标志，否则返回左右子树的最大深度值加1。这样就能求出每个节点的左右子树的深度，从而判断是否满足平衡二叉树的条件，由于不满足会返回-2，所以在最后进行一下判断就行了，代码如下


题一

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
    public int TreeDepth(TreeNode root) {
        if (root == null) {
			return 0;
		}
		int leftLength = TreeDepth(root.left);
		int rightLength = TreeDepth(root.right);
		return leftLength > rightLength ? leftLength + 1 : rightLength + 1;
    }
}
```


题二

java:
```
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
		if(root == null || getNodeDepth(root) != -2){
			return true;
		}else{
			return false;
		}
	}

	public int getNodeDepth(TreeNode root) {
		int left = 0;
		int right = 0;
		if (root.left != null) {
			left = getNodeDepth(root.left);
		}
		if (root.right != null) {
			right = getNodeDepth(root.right);
		}
		if (left - right < -1 || left - right > 1) {
			return -2;
		}
		return left > right ? left + 1 : right + 1;
	}
}
```