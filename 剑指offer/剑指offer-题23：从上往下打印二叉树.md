**题目描述**
--------

从上往下打印出二叉树的每个节点，同层节点从左至右打印。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
![这里写图片描述](http://img-blog.csdn.net/20180320220710366?/2/text/Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](http://img-blog.csdn.net/20180320220653978?/2/text/Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](http://img-blog.csdn.net/20180320221445939?watermark/2/text/Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](http://img-blog.csdn.net/20180320220728469?/2/text/Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)


java:
```
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				TreeNode tempNode = queue.poll();
				arrayList.add(tempNode.val);
				if(tempNode.left != null){
					queue.offer(tempNode.left);
				}
				if(tempNode.right != null){
					queue.offer(tempNode.right);
				}
			}
		}
		return arrayList;
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
    # 返回从上到下每个节点值列表，例：[1,2,3]
    def PrintFromTopToBottom(self, root):
        # write code here
        list = []
        if root is not None:
            queue = []
            queue.append(root)
            while len(queue) > 0:
                tempNode = queue.pop(0)
                list.append(tempNode.val)
                if tempNode.left is not None:
                    queue.append(tempNode.left)
                if tempNode.right is not None:
                    queue.append(tempNode.right)
        return list
```