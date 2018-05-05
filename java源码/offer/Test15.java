package offer;

/**
 * 剑指offer-题15：链表中倒数第k个节点
 * 
 * 输入一个链表，输出该链表中倒数第k个结点。
 */

public class Test15 {
	public ListNode FindKthToTail(ListNode head, int k) {
		if (head == null || k == 0) {
			return null;
		}
		ListNode firstNode = head;
		ListNode secondeNode = null;

		for (int i = 0; i < k - 1; i++) {
			if (firstNode.next != null) {
				firstNode = firstNode.next;
			}else {
				return null;
			}
		}
		
		secondeNode = head;
		while (firstNode.next != null) {
			firstNode = firstNode.next;
			secondeNode = secondeNode.next;
		}
		return secondeNode;
	}

	public static void main(String[] args) {
		Test15 test15 = new Test15();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(6);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		
		System.out.println(test15.FindKthToTail(a, 3).val);
		
		
	}

}
