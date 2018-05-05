package offer;

/**
 * 剑指offer-题39：二叉树的深度
 * 
 * 题一：输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 题二：输入一棵二叉树的根结点，判断该二叉树是否是平衡二叉树。如果某二叉树中任意结点的左右子树 的深度相差不超过1，那么它就是一颗平衡二叉树。
 */

public class Test39 {
	// 第一题
	public int TreeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftLength = TreeDepth(root.left);
		int rightLength = TreeDepth(root.right);
		return leftLength > rightLength ? leftLength + 1 : rightLength + 1;
	}

	// 第二题
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

	public static void main(String[] args) {
		Test39 test39 = new Test39();
		TreeInfo treeInfo = new TreeInfo();
		TreeNode root = treeInfo.treeSet();
		System.out.println(test39.TreeDepth(root));
		
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		a.left = b;
		b.left = c;
		c.left = d;
		System.out.println(test39.IsBalanced_Solution(a));
	}
}
