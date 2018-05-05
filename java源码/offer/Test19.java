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

	public static void main(String[] args) {
		TreeInfo treeInfo = new TreeInfo();
		TreeNode root = treeInfo.treeSet();

		treeInfo.qinaxuDigui(root); // 前序遍历
		System.out.print("前序遍历：");
		for (Integer integer : treeInfo.qianxuNumList) {
			System.out.print(integer + ",");
		}

		new Test19().Mirror(root);// 求镜像树
		System.out.println();
		
		TreeInfo newTree = new TreeInfo();
		newTree.qinaxuDigui(root); // 前序遍历
		System.out.print("前序遍历：");
		for (Integer integer : newTree.qianxuNumList) {
			System.out.print(integer + ",");
		}

	}

}
