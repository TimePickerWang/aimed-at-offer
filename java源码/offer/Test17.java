package offer;

/**
 * 剑指offer-题17：合并两个排序的链表
 * 
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */

public class Test17 {
	public ListNode Merge(ListNode list1, ListNode list2) {		
		if(list1 == null){
			return list2;
		}else if (list2 == null) {
			return list1;
		}
		
		ListNode newNode = null; 
		
		if(list1.val < list2.val){
			newNode = list1;
			newNode.next = Merge(list1.next, list2);
		}else {
			newNode = list2;
			newNode.next = Merge(list1, list2.next);
		}
		return newNode;
	}

	public static void main(String[] args) {
		ListNode aa = new ListNode(1);
		ListNode ab = new ListNode(3);
		ListNode ac = new ListNode(5);
		ListNode ad = new ListNode(7);
		aa.next = ab;
		ab.next = ac;
		ac.next = ad;

		ListNode ba = new ListNode(1);
		ListNode bb = new ListNode(2);
		ListNode bc = new ListNode(4);
		ListNode bd = new ListNode(5);
		ListNode be = new ListNode(8);
		ba.next = bb;
		bb.next = bc;
		bc.next = bd;
		bd.next = be;

		Test17 test17 = new Test17();
		ListNode newNode = test17.Merge(aa, ba);
		while (newNode != null) {
			System.out.print(newNode.val + ", ");
			newNode = newNode.next;
		}

	}
}
