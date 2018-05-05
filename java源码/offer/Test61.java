package offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 剑指offer-题61：按之字形顺序打印二叉树
 * 
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */

public class Test61 {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> oneRow = new ArrayList<Integer>();
		if (pRoot != null) {
			Stack<TreeNode> stack1 = new Stack<TreeNode>();
			Stack<TreeNode> stack2 = new Stack<TreeNode>();
			stack1.push(pRoot);
			// true表示当前是奇数层,先保存左子结点，后保存右子结点；false表示当前是偶数层,先保存右子结点，后保存左子结点
			boolean flag = true;
			while (!stack1.isEmpty() || !stack2.isEmpty()) {
				TreeNode tempNode;

				if (flag) {
					tempNode = stack1.pop();
					oneRow.add(new Integer(tempNode.val));
					if (tempNode.left != null) {
						stack2.push(tempNode.left);
					}
					if (tempNode.right != null) {
						stack2.push(tempNode.right);
					}
				} else {
					tempNode = stack2.pop();
					oneRow.add(new Integer(tempNode.val));
					if (tempNode.right != null) {
						stack1.push(tempNode.right);
					}
					if (tempNode.left != null) {
						stack1.push(tempNode.left);
					}
				}
				if (flag && stack1.isEmpty()) {
					flag = false;
					list.add(oneRow);
					oneRow = new ArrayList<Integer>();
				} else if (!flag && stack2.isEmpty()) {
					flag = true;
					list.add(oneRow);
					oneRow = new ArrayList<Integer>();
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(8);
		TreeNode b = new TreeNode(6);
		TreeNode c = new TreeNode(10);
		TreeNode d = new TreeNode(5);
		TreeNode e = new TreeNode(7);
		TreeNode f = new TreeNode(9);
		TreeNode g = new TreeNode(11);

		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		c.right = g;

		ArrayList<ArrayList<Integer>> list = new Test61().Print(a);
		for (ArrayList<Integer> oneRow : list) {
			for (Integer num : oneRow) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}
