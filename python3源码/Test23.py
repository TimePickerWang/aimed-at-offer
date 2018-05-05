# -*- coding:utf-8 -*-

# 剑指offer-题23：从上往下打印二叉树

# 从上往下打印出二叉树的每个节点，同层节点从左至右打印


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def PrintFromTopToBottom(self, root):
        list = []
        if root is not None:
            queue = []
            queue.append(root)
            while len(queue) > 0:
                tempNode = queue.pop(0)
                list.append(tempNode.val)
                if tempNode.left is not None:
                    queue.append(tempNode.left)
                if tempNode.right is not None:
                    queue.append(tempNode.right)
        return list



solution = Solution()
root = TreeNode(1)
a = TreeNode(2)
b = TreeNode(3)
c = TreeNode(4)
d = TreeNode(5)
e = TreeNode(6)
f = TreeNode(7)
g = TreeNode(8)
root.left = a
root.right = b
a.left = c
c.right = f
b.left = d
b.right = e
e.left = g
print(solution.PrintFromTopToBottom(root))


