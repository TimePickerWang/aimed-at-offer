package algorithm;

/**
 * 二叉树的前序、中序、后序遍历
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeInfo {
	List<Integer> qianxuNumList;
	List<Integer> zhongxuNumList;
	List<Integer> houxuNumList;

	public TreeInfo() {
		qianxuNumList = new ArrayList<Integer>();
		zhongxuNumList = new ArrayList<Integer>();
		houxuNumList = new ArrayList<Integer>();
	}

	// 用递归的方法进行先序遍历
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

	// 用非递归的方法进行先序遍历
	public void qinaxuFeiDigui(TreeNode treeNode) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (treeNode != null || !stack.isEmpty()) {
			while (treeNode != null) {
				qianxuNumList.add(treeNode.val);
				stack.push(treeNode);
				treeNode = treeNode.left;
			}
			if (!stack.isEmpty()) {
				treeNode = stack.pop();
				treeNode = treeNode.right;
			}
		}
	}

	// 用非递归的方法进行中序遍历
	public void zhongxuFeiDigui(TreeNode treeNode) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (treeNode != null || !stack.isEmpty()) {
			while (treeNode != null) {
				stack.push(treeNode);
				treeNode = treeNode.left;
			}
			if (!stack.isEmpty()) {
				treeNode = stack.pop();
				zhongxuNumList.add(treeNode.val);
				treeNode = treeNode.right;
			}
		}
	}

	// 用非递归的方法进行后序遍历
	public void houxuFeiDigui(TreeNode treeNode) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (treeNode != null || !stack.isEmpty()) {
			while (treeNode != null) {
				stack.push(treeNode);
				treeNode = treeNode.left;
			}
			boolean tag = true;
			TreeNode preNode = null;  // 前驱节点
			while (!stack.isEmpty() && tag == true) {
				treeNode = stack.peek();
				if (treeNode.right == preNode) { // 之前访问的为空节点或是栈顶节点的右子节点
					treeNode = stack.pop();
					houxuNumList.add(treeNode.val);
					if (stack.isEmpty()) {
						return;
					} else {
						preNode = treeNode;
					}
				} else {
					treeNode = treeNode.right;
					tag = false;
				}
			}
		}
	}

	// 构造二叉树，返回根节点
	public TreeNode treeSet() {
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

	// 打印序列
	public void print(int type) {
		if (type == 1) {
			System.out.print("前序遍历：");
			for (Integer integer : this.qianxuNumList) {
				System.out.print(integer + "  ");
			}
			System.out.println();
		} else if (type == 2) {
			System.out.print("中序遍历：");
			for (Integer integer : this.zhongxuNumList) {
				System.out.print(integer + "  ");
			}
			System.out.println();
		} else if (type == 3) {
			System.out.print("后序遍历：");
			for (Integer integer : this.houxuNumList) {
				System.out.print(integer + "  ");
			}
			System.out.println();
		} else {
			return;
		}
	}

	public static void main(String[] args) {
		TreeInfo treeInfo = new TreeInfo();
		TreeNode root = treeInfo.treeSet();

		System.out.println("-------递归---------");
		treeInfo.qinaxuDigui(root); // 前序遍历
		treeInfo.print(1);
		treeInfo.zhongxuDigui(root); // 中序遍历
		treeInfo.print(2);
		treeInfo.houxuDigui(root); // 后序遍历
		treeInfo.print(3);

		System.out.println("------非递归--------");
		treeInfo.qianxuNumList.clear();
		treeInfo.zhongxuNumList.clear();
		treeInfo.houxuNumList.clear();

		treeInfo.qinaxuFeiDigui(root); // 前序遍历
		treeInfo.print(1);
		treeInfo.zhongxuFeiDigui(root);
		treeInfo.print(2);
		treeInfo.houxuFeiDigui(root);
		treeInfo.print(3);
	}

}
