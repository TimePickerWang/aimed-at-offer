package offer;

/**
 * 剑指offer-题37：两个链表的第一个公共节点
 * 
 * 输入两个链表，找出它们的第一个公共结点。
 */

public class Test37 {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		int list1Length = getListLength(pHead1);
		int list2Length = getListLength(pHead2);
		ListNode longList = null;
		ListNode shortList = null;
		int diff;
		if (list1Length >= list2Length) {
			longList = pHead1;
			shortList = pHead2;
			diff = list1Length - list2Length;
		} else {
			longList = pHead2;
			shortList = pHead2;
			diff = list2Length - list1Length;
		}

		for (int i = 0; i < diff; i++) {
			longList = longList.next;
		}

		while (longList != null && shortList != null & longList != shortList) {
			longList = longList.next;
			shortList = shortList.next;
		}

		if (longList == shortList) {
			return longList;
		} else {
			return null;
		}
	}

	public int getListLength(ListNode node) {
		int length = 0;
		while (node != null) {
			length++;
			node = node.next;
		}
		return length;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode a1 = new ListNode(6);
		ListNode b1 = new ListNode(7);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		a1.next = b1;
		b1.next = c;
		
		ListNode node = new Test37().FindFirstCommonNode(a, a1);
		System.out.println(node.val);
		
		
	}
}
