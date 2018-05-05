# -*- coding:utf-8 -*-

# 剑指offer-题19：二叉树的镜像

# 操作给定的二叉树，将其变换为源二叉树的镜像。


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # 返回镜像树的根节点
    def Mirror(self, root):
        if root is None:
            return
        elif root.left is None and root.right is None:
            return
        else:
            temp = root.left
            root.left = root.right
            root.right = temp

            if root.left is not None:
                self.Mirror(root.left)
            if root.right is not None:
                self.Mirror(root.right)


solution = Solution()

root = TreeNode(1)
a = TreeNode(2)
b = TreeNode(3)
c = TreeNode(4)
d = TreeNode(5)

root.left = a
root.right = b
a.left = c
a.right = d

solution.Mirror(root)

print(str(root.left.val) + "-" + str(root.right.val))
print(str(a.left.val) + "-" + str(a.right.val))

