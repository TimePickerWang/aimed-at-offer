# -*- coding:utf-8 -*-

# 剑指offer-题25：二叉树中和为某一值的路径

# 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定
# 义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 返回二维列表，内部每个列表表示找到的路径
    def FindPath(self, root, expectNumber):
        self.path_list = []
        self.stack = []
        self.cur_sum = 0
        return self.get_path(root, expectNumber)

    def get_path(self, root, expectNumber):
        if root is None:
            return self.path_list
        self.cur_sum += root.val
        self.stack.append(root.val)

        is_leaf = root.right is None and root.left is None
        if self.cur_sum == expectNumber and is_leaf:
            temp_path = self.stack[:]
            self.path_list.append(temp_path)
            # self.path_list.append(self.stack.copy())
        if root.left:
            self.get_path(root.left, expectNumber)
        if root.right:
            self.get_path(root.right, expectNumber)
        self.stack.pop()
        self.cur_sum -= root.val
        return self.path_list


solution = Solution()
root = TreeNode(10)
a = TreeNode(5)
b = TreeNode(4)
c = TreeNode(7)
d = TreeNode(12)
root.left = a
a.left = b
a.right = c
root.right = d
print(solution.FindPath(root, 22))
print(solution.FindPath(root, 15))

