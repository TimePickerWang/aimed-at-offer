package offer;

/**
 * 二叉树的前序、中序、后序遍历
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class TreeInfo {
	List<Integer> qianxuNumList;
	List<Integer> zhongxuNumList;
	List<Integer> houxuNumList;

	public TreeInfo() {
		qianxuNumList = new ArrayList<Integer>();
		zhongxuNumList = new ArrayList<Integer>();
		houxuNumList = new ArrayList<Integer>();
	}

	// 用递归的方法进行前序遍历
	public void qinaxuDigui(TreeNode treeNode) {
		qianxuNumList.add(treeNode.val);
		if (treeNode.left != null) {
			qinaxuDigui(treeNode.left);
		}
		if (treeNode.right != null) {
			qinaxuDigui(treeNode.right);
		}
	}

	// 用递归的方法进行中序遍历
	public void zhongxuDigui(TreeNode treeNode) {
		if (treeNode.left != null) {
			zhongxuDigui(treeNode.left);
		}
		zhongxuNumList.add(treeNode.val);
		if (treeNode.right != null) {
			zhongxuDigui(treeNode.right);
		}
	}

	// 用递归的方法进行后序遍历
	public void houxuDigui(TreeNode treeNode) {
		if (treeNode.left != null) {
			houxuDigui(treeNode.left);
		}
		if (treeNode.right != null) {
			houxuDigui(treeNode.right);
		}
		houxuNumList.add(treeNode.val);
	}

	public TreeNode treeSet() { // 构造二叉树，返回根节点
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

		return root;
	}

	public static void main(String[] args) {
		TreeInfo treeInfo = new TreeInfo();
		TreeNode root = treeInfo.treeSet();

		treeInfo.qinaxuDigui(root); // 前序遍历
		System.out.print("前序遍历：");
		for (Integer integer : treeInfo.qianxuNumList) {
			System.out.print(integer + ",");
		}

		System.out.println();
		System.out.print("中序遍历：");
		treeInfo.zhongxuDigui(root); // 中序遍历
		for (Integer integer : treeInfo.zhongxuNumList) {
			System.out.print(integer + ",");
		}

		System.out.println();
		System.out.print("后序遍历：");
		treeInfo.houxuDigui(root); // 后序遍历
		for (Integer integer : treeInfo.houxuNumList) {
			System.out.print(integer + ",");
		}
	}

}
