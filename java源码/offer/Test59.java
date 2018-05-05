package offer;

/**
 * 剑指offer-题59：对称的二叉树
 * 
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。如果一个二叉树和它的镜像是一样的，那么它是对称的。
 */

public class Test59 {
	boolean isSymmetrical(TreeNode pRoot) {
		return isSymmetrical(pRoot, pRoot);
	}

	boolean isSymmetrical(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null) {
			return true;
		}
		if (node1 == null || node2 == null) {
			return false;
		}
		if (node1.val != node2.val) {
			return false;
		}
		return isSymmetrical(node1.right, node2.left) && isSymmetrical(node1.left, node2.right);
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(8);
		TreeNode b1 = new TreeNode(6);
		TreeNode b2 = new TreeNode(6);
		TreeNode c1 = new TreeNode(5);
		TreeNode d1 = new TreeNode(7);
		TreeNode c2 = new TreeNode(7);
		TreeNode d2 = new TreeNode(5);

		a.left = b1;
		a.right = b2;
		b1.left = c1;
		b1.right = d1;
		b2.left = c2;
		b2.right = d2;

		System.out.println(new Test59().isSymmetrical(a));
	}
}
