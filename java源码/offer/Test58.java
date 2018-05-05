package offer;

/**
 * 剑指offer-题58：二叉树下的一个结点
 * 
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */

public class Test58 {
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null) {
			return null;
		} else {
			TreeLinkNode nextNode = null;
			if (pNode.right != null) {
				nextNode = pNode.right;
				while (nextNode.left != null) {
					nextNode = nextNode.left;
				}
			} else {
				TreeLinkNode currentNode = pNode;
				TreeLinkNode parentNode = pNode.next;
				while (parentNode != null && parentNode.right == currentNode) {
					currentNode = parentNode;
					parentNode = currentNode.next;
				}
				nextNode = parentNode;
			}
			return nextNode;
		}
	}

	public static void main(String[] args) {
		TreeLinkNode a = new TreeLinkNode(1);
		TreeLinkNode b = new TreeLinkNode(2);
		TreeLinkNode c = new TreeLinkNode(3);
		TreeLinkNode d = new TreeLinkNode(4);
		TreeLinkNode e = new TreeLinkNode(5);
		TreeLinkNode f = new TreeLinkNode(6);
		TreeLinkNode g = new TreeLinkNode(7);
		TreeLinkNode h = new TreeLinkNode(8);
		TreeLinkNode i = new TreeLinkNode(9);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		e.left = h;
		e.right = i;
		c.left = f;
		c.right = g;

		b.next = a;
		c.next = a;
		d.next = b;
		e.next = b;
		h.next = e;
		i.next = e;
		f.next = c;
		g.next = c;

		System.out.println(new Test58().GetNext(f).val);
	}
}
