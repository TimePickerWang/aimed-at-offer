# -*- coding:utf-8 -*-

# 剑指offer-题5：从尾到头打印链表

# 输入一个链表，从尾到头打印链表每个节点的值。


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class digui_Solution:  # 递归
    value_list = []
    def printListFromTailToHead(self, listNode):
        if listNode is not None:
            self.printListFromTailToHead(listNode.next)
            self.value_list.append(listNode.val)
        return self.value_list


class Solution:  # 栈
    def printListFromTailToHead(self, listNode):
        stack = []
        value_list = []
        node = listNode
        while node is not None:
            stack.append(node)
            node = node.next
        while len(stack) > 0:
            value_list.append(stack[-1].val)
            stack.pop()
        return value_list


a = ListNode(5)
b = ListNode(8)
c = ListNode(61)
d = ListNode(95)
a.next = b
b.next = c
c.next = d

solu = Solution()
list = solu.printListFromTailToHead(a)
print(list)
solu2 = digui_Solution()
list2 = solu2.printListFromTailToHead(a)
print(list2)
