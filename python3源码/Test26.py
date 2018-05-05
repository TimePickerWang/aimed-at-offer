# -*- coding:utf-8 -*-

# 剑指offer-题26：复杂链表的复制

# 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指
# 向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复
# 杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）


class RandomListNode:
    def __init__(self, x):
        self.label = x
        self.next = None
        self.random = None


class Solution:
    # 返回 RandomListNode
    def Clone(self, pHead):
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

a = RandomListNode(1)
b = RandomListNode(2)
c = RandomListNode(3)
d = RandomListNode(4)
e = RandomListNode(5)
f = RandomListNode(6)
a.next = b
b.next = c
c.next = d
d.next = e
e.next = f
a.random = c
b.random = d
c.random = e
d.random = a
solution = Solution()

node = solution.Clone(a)
while node is not None:
    print(node.label, end="--")
    if node.random is not None:
        print(node.random.label)
    node = node.next
