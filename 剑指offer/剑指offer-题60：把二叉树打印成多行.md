**题目描述**
--------

从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
这题跟之前的[剑指offer-题23：从上往下打印二叉树](https://blog.csdn.net/wang454592297/article/details/79632797)很类似，就是多了一个需要换行打印的条件。这里增加了2个变量，一个是下一层需要打印的结点数:nextNodesNum，还有一个是这一层还需打印的剩余结点数:NeedToAdd，当其值为0时，表示这一层已经打印完毕。代码如下：



java:
```
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


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
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if (pRoot != null) {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			ArrayList<Integer> oneRow = new ArrayList<>();
			queue.offer(pRoot);
			int nextNodesNum = 0;
			int NeedToAdd = 1;
			while (!queue.isEmpty()) {
				TreeNode tempNode = queue.poll();
				oneRow.add(new Integer(tempNode.val));
				if (tempNode.left != null) {
					queue.offer(tempNode.left);
					nextNodesNum++;
				}
				if (tempNode.right != null) {
					queue.offer(tempNode.right);
					nextNodesNum++;
				}
				NeedToAdd--;
				if (NeedToAdd == 0) {
					list.add(oneRow);
					oneRow = new ArrayList<Integer>();
					NeedToAdd = nextNodesNum;
					nextNodesNum = 0;
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