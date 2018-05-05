package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指offer-题23：从上往下打印二叉树
 * 
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */

public class Test23 {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				TreeNode tempNode = queue.poll();
				arrayList.add(tempNode.val);
				if(tempNode.left != null){
					queue.offer(tempNode.left);
				}
				if(tempNode.right != null){
					queue.offer(tempNode.right);
				}
			}
		}
		return arrayList;
	}

	public static void main(String[] args) {
		TreeInfo treeInfo = new TreeInfo();
		TreeNode rootNode = treeInfo.treeSet();
		ArrayList<Integer> array = new Test23().PrintFromTopToBottom(rootNode);
		for (Integer integer : array) {
			System.out.print(integer + ", ");
		}
	}

}
