package offer;

/**
 * 剑指offer-题57：删除链表中重复的结点
 * 
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5
 * 处理后为 1->2->5
 */

public class Test57 {
	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null) {
			return null;
		}
		ListNode node = pHead;
		ListNode preNode = null;
		ListNode nextNode = null;
		while (node != null) {
			nextNode = node.next;
			boolean needDelete = false;
			if (nextNode != null && nextNode.val == node.val) {
				needDelete = true;
			}
			if (!needDelete) {
				preNode = node;
				node = nextNode;
			} else {
				int value = node.val;
				ListNode deleteNode = node;
				while (deleteNode != null && deleteNode.val == value) {
					nextNode = deleteNode.next;
					deleteNode = null;
					deleteNode = nextNode;
				}
				if (preNode == null) {
					pHead = nextNode;
				} else {
					preNode.next = nextNode;
				}
				node = nextNode;
			}
		}
		return pHead;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(3);
		ListNode e = new ListNode(4);
		ListNode f = new ListNode(4);
		ListNode g = new ListNode(5);

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;

		ListNode node = a;
		System.out.print("删除重复结点前：");
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
		node = new Test57().deleteDuplication(a);
		System.out.print("删除重复结点后：");
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
}
