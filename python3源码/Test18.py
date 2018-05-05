# -*- coding:utf-8 -*-

# 剑指offer-题18：树的子结构

# 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def HasSubtree(self, pRoot1, pRoot2):
        result = False
        if pRoot1 is not None and pRoot2 is not None:
            if pRoot1.val == pRoot2.val:
                result = self.DoseTree1HaveTree2(pRoot1, pRoot2)
            if not result:
                result = self.HasSubtree(pRoot1.left, pRoot2)
            if not result:
                result = self.HasSubtree(pRoot1.right, pRoot2)
        return result

    def DoseTree1HaveTree2(self, pRoot1, pRoot2):
        if pRoot2 is None:
            return True
        if pRoot1 is None:
            return False
        if pRoot2.val != pRoot1.val:
            return False
        return self.DoseTree1HaveTree2(pRoot1.right, pRoot2.right) and self.DoseTree1HaveTree2(pRoot1.left, pRoot2.left)


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

root2 = TreeNode(6)
a2 = TreeNode(8)
root2.left = a2
print(solution.HasSubtree(root, root2))
