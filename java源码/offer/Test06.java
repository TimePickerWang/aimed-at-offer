package offer;

/**
 * 剑指offer-题6：重建二叉树
 * 
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

public class Test06 {

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		TreeNode root = new TreeNode(pre[0]);
		root.left = null;
		root.right = null;
		int rootIndex = 0; // 根节点在中序遍历的位置
		while (rootIndex < in.length && root.val != in[rootIndex]) {
			rootIndex++;
		}
		int rightLength = in.length - rootIndex - 1; // 根节点右子树节点个数

		if (rootIndex > 0) { // 构造左子树
			int[] inTemp = new int[rootIndex];
			int[] preTemp = new int[rootIndex];
			for (int i = 0; i < rootIndex; i++) {
				inTemp[i] = in[i];
			}
			for (int j = 1; j <= rootIndex; j++) {
				preTemp[j - 1] = pre[j];
			}
			root.left = reConstructBinaryTree(preTemp, inTemp);
		}

		if (rightLength > 0) { // 构造右子树
			int[] inTemp = new int[rightLength];
			int[] preTemp = new int[rightLength];
			for (int i = 0; i < rightLength; i++) {
				inTemp[i] = in[rootIndex + 1 + i];
			}
			for (int j = 1; j <= rightLength; j++) {
				preTemp[j - 1] = pre[rootIndex + j];
			}
			root.right = reConstructBinaryTree(preTemp, inTemp);
		}
		return root;
	}

	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
		TreeNode rootNode = new Test06().reConstructBinaryTree(pre, in);
		System.out.println("根节点：" + rootNode.val);

		TreeInfo treeInfo = new TreeInfo();
		System.out.print("后序遍历：");
		treeInfo.houxuDigui(rootNode); // 后序遍历
		for (Integer integer : treeInfo.houxuNumList) {
			System.out.print(integer + ",");
		}
	}

}
