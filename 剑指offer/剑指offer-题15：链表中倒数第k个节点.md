**题目描述**
--------

输入一个链表，输出该链表中倒数第k个结点。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------

![这里写图片描述](http://img.blog.csdn.net/20180309103350888?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](http://img.blog.csdn.net/20180309103357211?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](http://img.blog.csdn.net/20180309103403328?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)


另外，我们还需要注意以下会出现的问题，来增强代码的鲁棒性：

1.输入的链表的头结点为null

2.链表的节点总数少于k个

3.输入的参数k为0


针对问题1和3，我们可以返回null;针对问题2，我们可以在循环时进行判断即可，代码如下：


java:
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
    public ListNode FindKthToTail(ListNode head,int k) {
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
}
```


python:
```
# -*- coding:utf-8 -*-
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def FindKthToTail(self, head, k):
        # write code here
        if head is None or k == 0:
            return None
        first_node = head
        for i in range(0, k-1):
            if first_node.next is not  None:
                first_node = first_node.next
            else:
                return None
        second_node = head
        while first_node.next is not None:
            first_node = first_node.next
            second_node = second_node.next
        return second_node
```