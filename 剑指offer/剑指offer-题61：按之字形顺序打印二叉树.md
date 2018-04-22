**题目描述**
--------

请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
![这里写图片描述](https://img-blog.csdn.net/20180422221016696?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/20180422221025625?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/20180422221053261?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/20180422221035386?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)



java:
```
import java.util.ArrayList;
import java.util.Stack;

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
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> oneRow = new ArrayList<Integer>();
		if (pRoot != null) {
			Stack<TreeNode> stack1 = new Stack<TreeNode>();
			Stack<TreeNode> stack2 = new Stack<TreeNode>();
			stack1.push(pRoot);
			// true表示当前是奇数层,先保存左子结点，后保存右子结点；false表示当前是偶数层,先保存右子结点，后保存左子结点
			boolean flag = true;
			while (!stack1.isEmpty() || !stack2.isEmpty()) {
				TreeNode tempNode;

				if (flag) {
					tempNode = stack1.pop();
					oneRow.add(new Integer(tempNode.val));
					if (tempNode.left != null) {
						stack2.push(tempNode.left);
					}
					if (tempNode.right != null) {
						stack2.push(tempNode.right);
					}
				} else {
					tempNode = stack2.pop();
					oneRow.add(new Integer(tempNode.val));
					if (tempNode.right != null) {
						stack1.push(tempNode.right);
					}
					if (tempNode.left != null) {
						stack1.push(tempNode.left);
					}
				}
				if (flag && stack1.isEmpty()) {
					flag = false;
					list.add(oneRow);
					oneRow = new ArrayList<Integer>();
				} else if (!flag && stack2.isEmpty()) {
					flag = true;
					list.add(oneRow);
					oneRow = new ArrayList<Integer>();
				}
			}
		}
		return list;
    }
}
```


python:
```
略
```