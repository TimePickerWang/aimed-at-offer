# -*- coding:utf-8 -*-

# 剑指offer-题27：二叉搜索树与双向链表

# 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
# 要求不能创建任何新的结点，只能调整树中结点指针的指向。


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    last_node = None

    def Convert(self, pRootOfTree):
        self.convert_node(pRootOfTree)
        head_node = self.last_node
        while head_node is not None and head_node.left is not None:
            head_node = head_node.left
        return head_node

    def convert_node(self, node):
        if node is None:
            return
        cur_node = node
        if cur_node.left is not None:
            self.convert_node(cur_node.left)
        if self.last_node is not None:
            self.last_node.right = cur_node
            cur_node.left = self.last_node
        self.last_node = cur_node
        if cur_node.right is not None:
            self.convert_node(cur_node.right)

root = TreeNode(10)
a = TreeNode(6)
b = TreeNode(14)
c = TreeNode(4)
d = TreeNode(8)
e = TreeNode(12)
f = TreeNode(16)
root.left = a
root.right = b
a.left = c
a.right = d
b.left = e
b.right = f
solution = Solution()
node = solution.Convert(root)
while node is not None:
    print(node.val, end=" ")
    node = node.right

