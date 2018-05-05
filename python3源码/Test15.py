# -*- coding:utf-8 -*-

# 剑指offer-题15：链表中倒数第k个节点

# 输入一个链表，输出该链表中倒数第k个结点。


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def FindKthToTail(self, head, k):
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


solution = Solution()
a = ListNode(1)
b = ListNode(2)
c = ListNode(3)
d = ListNode(4)
e = ListNode(5)
f = ListNode(6)
g = ListNode(7)
a.next = b
b.next = c
c.next = d
d.next = e
e.next = f
f.next = g
print(solution.FindKthToTail(a, 1).val)

