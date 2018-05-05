# -*- coding:utf-8 -*-

# 剑指offer-题6：重建二叉树

# 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
# 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如
# 输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序
# 列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 返回构造的TreeNode根节点
    def reConstructBinaryTree(self, pre, tin):
        node = TreeNode(pre[0])
        root_index = tin.index(pre[0])
        right_length = len(tin) - root_index - 1
        if root_index > 0:
            node.left = self.reConstructBinaryTree(pre[1: root_index + 1], tin[0:root_index])  # 构造左子树
        if right_length > 0:
            node.right = self.reConstructBinaryTree(pre[root_index + 1:], tin[root_index + 1:])  # 构造右子树
        return node


solution = Solution()
pre = [1, 2, 4, 7, 3, 5, 6, 8]
tin = [4, 7, 2, 1, 5, 3, 8, 6]
node = solution.reConstructBinaryTree(pre, tin)
print(node.val)

