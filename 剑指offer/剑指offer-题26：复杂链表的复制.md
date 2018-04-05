**题目描述**
--------

输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
下图中的N'和S'均是复制出来的和原链表相对应的节点

![这里写图片描述](https://img.blog.csdn.net/20180324161855354?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img.blog.csdn.net/20180324161906293?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img.blog.csdn.net/20180324161914942?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)



java:
```
/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
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
}
```


python:
```
# -*- coding:utf-8 -*-
# class RandomListNode:
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None
class Solution:
    # 返回 RandomListNode
    def Clone(self, pHead):
        # write code here
        self.clone_nodes(pHead)
        self.connect_random_nodes(pHead)
        return self.divide_list(pHead)

    def clone_nodes(self, pHead):
        node = pHead
        while node is not None:
            clone_node = RandomListNode(node.label)
            clone_node.next = node.next
            node.next = clone_node
            node = clone_node.next

    def connect_random_nodes(self, pHead):
        node = pHead
        while node is not None:
            clone_node = node.next
            if node.random is not None:
                clone_node.random = node.random.next
            node = clone_node.next

    def divide_list(self, pHead):
        node = pHead
        clone_list_head = None
        if node is not None:
            clone_list_head = node.next
            clone_node = node.next
            node.next = clone_node.next
            node = node.next
        while node is not None:
            clone_node.next = node.next
            clone_node = clone_node.next
            node.next = clone_node.next
            node = node.next
        return clone_list_head
```