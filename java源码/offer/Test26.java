package offer;

/**
 * 剑指offer-题26：复杂链表的复制
 * 
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复
 * 制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */

public class Test26 {
	public RandomListNode Clone(RandomListNode pHead) {
		cloneNodes(pHead);
		connectRandomNodes(pHead);
		return divideList(pHead);
	}

	// 1.复制复杂链表，并将next指针赋值
	public void cloneNodes(RandomListNode pHead) {
		RandomListNode node = pHead;
		while (node != null) {
			RandomListNode cloneNode = new RandomListNode(node.label);
			cloneNode.next = node.next;
			cloneNode.random = null;
			node.next = cloneNode;
			node = cloneNode.next;
		}
	}

	// 2.跟复制的链表的random指正赋值
	public void connectRandomNodes(RandomListNode pHead) {
		RandomListNode node = pHead;
		while (node != null) {
			RandomListNode cloneNode = node.next;
			if (node.random != null) {
				cloneNode.random = node.random.next;
			}
			node = cloneNode.next;
		}
	}

	// 3.将原始的复杂链表和复制的链表分开
	public RandomListNode divideList(RandomListNode pHead) {
		RandomListNode node = pHead;
		RandomListNode cloneListHead = null;
		RandomListNode cloneNode = null;
		if (node != null) {
			cloneListHead = node.next;
			cloneNode = node.next;
			node.next = cloneNode.next;
			node = node.next;
		}
		while (node != null) {
			cloneNode.next = node.next;
			cloneNode = cloneNode.next;
			node.next = cloneNode.next;
			node = node.next;
		}
		return cloneListHead;
	}

	public static void main(String[] args) {
		RandomListNode a = new RandomListNode(1);
		RandomListNode b = new RandomListNode(2);
		RandomListNode c = new RandomListNode(3);
		RandomListNode d = new RandomListNode(4);
		RandomListNode e = new RandomListNode(5);
		RandomListNode f = new RandomListNode(6);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		a.random = c;
		b.random = d;
		c.random = e;
		d.random = a;

		Test26 test26 = new Test26();
		RandomListNode cloneNode = test26.Clone(a);
		while (cloneNode != null) {
			System.out.print(cloneNode.label + "--" );
			if(cloneNode.random != null){
				System.out.print(cloneNode.random.label);
			}
			System.out.println();
			cloneNode = cloneNode.next;
		}
	}
}
