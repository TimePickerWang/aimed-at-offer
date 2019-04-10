package offer;

/**
 * 剑指offer-题19：二叉树的镜像
 * 
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */

public class Test19 {
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
