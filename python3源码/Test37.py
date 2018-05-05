# -*- coding:utf-8 -*-

# 剑指offer-题37：两个链表的第一个公共节点

# 输入两个链表，找出它们的第一个公共结点。


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def FindFirstCommonNode(self, pHead1, pHead2):
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


solution = Solution()
a = ListNode(1)
b = ListNode(2)
c = ListNode(3)
d = ListNode(4)
e = ListNode(5)
a1 = ListNode(6)
b1 = ListNode(7)

a.next = b
b.next = c
c.next = d
d.next = e
a1.next = b1
b1.next = c
common_node = solution.FindFirstCommonNode(a1, a)
if common_node is not None:
    print(common_node.val)
