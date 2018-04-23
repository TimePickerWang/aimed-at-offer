**题目描述**
--------

给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
![这里写图片描述](https://img-blog.csdn.net/20180423185709200?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)


java:
```
/*
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
    int k = 0;

	TreeNode KthNode(TreeNode pRoot, int k) {
		if (pRoot == null || k == 0) {
			return null;
		}
		this.k = k;
		return getKthNode(pRoot);
	}

	TreeNode getKthNode(TreeNode pRoot) {
		TreeNode target = null;
		if (pRoot.left != null) {
			target = getKthNode(pRoot.left);
		}
		if (target == null) {
			if (k == 1) {
				target = pRoot;
			} else {
				k--;
			}
		}
		if (target == null && pRoot.right != null) {
			target = getKthNode(pRoot.right);
		}
		return target;
	}
}
```


python:
```
略
```