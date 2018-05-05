package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指offer-题60：把二叉树打印成多行
 * 
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */

public class Test60 {
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if (pRoot != null) {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			ArrayList<Integer> oneRow = new ArrayList<>();
			queue.offer(pRoot);
			int nextNodesNum = 0;
			int NeedToAdd = 1;
			while (!queue.isEmpty()) {
				TreeNode tempNode = queue.poll();
				oneRow.add(new Integer(tempNode.val));
				if (tempNode.left != null) {
					queue.offer(tempNode.left);
					nextNodesNum++;
				}
				if (tempNode.right != null) {
					queue.offer(tempNode.right);
					nextNodesNum++;
				}
				NeedToAdd--;
				if (NeedToAdd == 0) {
					list.add(oneRow);
					oneRow = new ArrayList<Integer>();
					NeedToAdd = nextNodesNum;
					nextNodesNum = 0;
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

		ArrayList<ArrayList<Integer>> list = new Test60().Print(a);
		for (ArrayList<Integer> oneRow : list) {
			for (Integer num : oneRow) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}
