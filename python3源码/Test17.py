# -*- coding:utf-8 -*-

# 剑指offer-题17：合并两个排序的链表

# 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    # 返回合并后列表
    def Merge(self, pHead1, pHead2):
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


solution = Solution()
aa = ListNode(1)
ab = ListNode(3)
ac = ListNode(5)
ad = ListNode(7)
aa.next = ab
ab.next = ac
ac.next = ad

ba = ListNode(1)
bb = ListNode(2)
bc = ListNode(4)
bd = ListNode(5)
be = ListNode(8)
ba.next = bb
bb.next = bc
bc.next = bd
bd.next = be

newNode = solution.Merge(aa, ba)
while newNode is not None:
    print(newNode.val, end=" ")
    newNode = newNode.next
