**题目描述**
--------

输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
![这里写图片描述](http://img.blog.csdn.net/20180312105819636?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](http://img.blog.csdn.net/20180312105827972?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)


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
    public ListNode Merge(ListNode list1,ListNode list2) {
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
    # 返回合并后列表
    def Merge(self, pHead1, pHead2):
        # write code here
        if pHead1 is None:
            return pHead2
        elif pHead2 is None:
            return pHead1

        if pHead1.val < pHead2.val:
            node = pHead1
            node.next = self.Merge(pHead1.next, pHead2)
        else:
            node = pHead2
            node.next = self.Merge(pHead1, pHead2.next)
        return node
```