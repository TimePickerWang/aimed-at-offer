# -*- coding:utf-8 -*-

# 剑指offer-题16：反转链表

# 输入一个链表的头结点，反转该链表并输出反转后链表的头结点。


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # 返回ListNode
    def ReverseList(self, pHead):
        pNode = pHead
        pPrev = None
        pReversedHead = None
        while pNode is not None:
            pNext = pNode.next
            if pNext is None:
                pReversedHead = pNode
            pNode.next = pPrev
            pPrev = pNode
            pNode = pNext
        return pReversedHead

solution = Solution()
a = ListNode(1)
b = ListNode(2)
c = ListNode(3)
d = ListNode(4)
e = ListNode(5)
f = ListNode(6)
a.next = b
b.next = c
c.next = d
d.next = e
e.next = f
node = solution.ReverseList(a)
while node is not None:
    print(node.val, end=", ")
    node = node.next

