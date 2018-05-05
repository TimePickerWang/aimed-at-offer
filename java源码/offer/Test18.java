package offer;

/**
 * 剑指offer-题18：树的子结构
 * 
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */

public class Test18 {
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		boolean result = false;
		if (root1 != null && root2 != null) {
			if (root1.val == root2.val) {
				result = DoseTree1HavaTree2(root1, root2);
			}
			if (!result) {
				result = HasSubtree(root1.left, root2);
			}
			if (!result) {
				result = HasSubtree(root1.right, root2);
			}
		}
		return result;
	}

	public boolean DoseTree1HavaTree2(TreeNode root1, TreeNode root2) {
		if (root2 == null) {
			return true;
		}
		if (root1 == null) {
			return false;
		}
		if (root1.val != root2.val) {
			return false;
		}
		return DoseTree1HavaTree2(root1.left, root2.left) && DoseTree1HavaTree2(root1.right, root2.right);
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(7);
        TreeNode g = new TreeNode(8);
        root.left = a;
        root.right = b;
        a.left = c;
        c.right = f;
        b.left = d;
        b.right = e;
        e.left = g;
        
        TreeNode root2 = new TreeNode(6);
		TreeNode a2 = new TreeNode(8);
		root2.left = a2;
//		TreeNode b2 = new TreeNode(9);
//		root2.right = b2;
		System.out.println(new Test18().HasSubtree(root, root2));
		
	}
}
