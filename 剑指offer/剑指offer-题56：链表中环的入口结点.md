**题目描述**
--------

一个链表中包含环，请找出该链表的环的入口结点。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
![这里写图片描述](https://img-blog.csdn.net/20180421222315449?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/20180421222322551?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)



java:
```
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
		ListNode meeeingNode = meetingNodes(pHead);
		if (meeeingNode == null) {
			return null;
		}
		int nodeNumOfLoop = 1;
		ListNode node1 = meeeingNode.next;
		while (node1 != meeeingNode) {
			node1 = node1.next;
			nodeNumOfLoop++;
		}
		node1 = pHead;
		for (int i = 0; i < nodeNumOfLoop; i++) {
			node1 = node1.next;
		}
		ListNode node2 = pHead;
		while (node1 != node2) {
			node1 = node1.next;
			node2 = node2.next;
		}
		return node1;
	}

	// 一快一慢两个指针从链表头开始遍历链表，两个指针相遇的结点即是环内的一个结点
	public ListNode meetingNodes(ListNode pHead) {
		if (pHead == null) {
			return null;
		}
		ListNode slow = pHead.next;
		if (slow == null) {
			return null;
		}
		ListNode fast = slow.next;
		while (slow != null && fast != null) {
			if (slow == fast) {
				return fast;
			}
			slow = slow.next;
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			}
		}
		return null;
	}
}
```


python:
```
略
```