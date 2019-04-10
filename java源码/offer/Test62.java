package offer;

/**
 * 剑指offer-题62：序列化二叉树
 * 
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */

public class Test62 {
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
