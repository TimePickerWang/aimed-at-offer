**题目描述**
--------

输入两个链表，找出它们的第一个公共结点。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
这题书上列举了两个可行的解法，分别如下

**解法一**：

![这里写图片描述](https://img.blog.csdn.net/20180410142739173?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

**解法二**：

![这里写图片描述](https://img.blog.csdn.net/20180410142931652?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img.blog.csdn.net/20180410142939681?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)


其中解法二我是用java实现的，解法一我用python3实现。跟解法二相比，解法一需要另外两个列表当做栈，相当于用空间换了时间。具体代码如下



java(解法二):
```
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
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
}
```


python(解法一):
```
# -*- coding:utf-8 -*-
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution:
    def FindFirstCommonNode(self, pHead1, pHead2):
        # write code here
        stack1 = []
        stack2 = []
        common_node = None
        while pHead1 is not None:
            stack1.append(pHead1)
            pHead1 = pHead1.next
        while pHead2 is not None:
            stack2.append(pHead2)
            pHead2 = pHead2.next
        while len(stack1) > 0 and len(stack2) > 0 and stack1[-1] == stack2[-1]:
            common_node = stack1[-1]
            stack1.pop()
            stack2.pop()
        return common_node
```