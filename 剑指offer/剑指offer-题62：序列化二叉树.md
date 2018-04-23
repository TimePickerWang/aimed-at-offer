**题目描述**
--------

请实现两个函数，分别用来序列化和反序列化二叉树

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
![这里写图片描述](https://img-blog.csdn.net/20180423184818391?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/201804231848260?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)



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
    int index = -1;
    // 序列化
	String Serialize(TreeNode root) {
		String str = "";
		if (root == null) {
			str = str + '$' + ',';
			return str;
		} else {
			str = str + root.val + ',';
			str = str + Serialize(root.left);
			str = str + Serialize(root.right);
		}
		return str;
	}

	TreeNode Deserialize(String str) {
		TreeNode root = null;
		if (str != null) {
			String[] strArray = str.split(",");
			if (strArray[0] != "$") {
				root = Deserialize(strArray);
			} else {
				return null;
			}
		}
		return root;
	}

	TreeNode Deserialize(String[] strArray) {
		index++;
		TreeNode node = null;
		if (!strArray[index].equals("$")) {
			node = new TreeNode(Integer.parseInt(strArray[index]));
			node.left = Deserialize(strArray);
			node.right = Deserialize(strArray);
		}
		return node;
	}
}
```


python:
```
略
```