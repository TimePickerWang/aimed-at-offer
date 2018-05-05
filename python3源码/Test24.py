# -*- coding:utf-8 -*-

# 剑指offer-题24：二叉搜索树的后续遍历序列

# 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
# 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同


class Solution:
    def VerifySquenceOfBST(self, sequence):
        if len(sequence) == 0 or sequence is None:
            return False
        root_value = sequence[-1]
        left_tree_index = 0
        while sequence[left_tree_index] < root_value and left_tree_index < len(sequence) - 1:
            left_tree_index += 1
        right_tree_index = left_tree_index
        while right_tree_index < len(sequence) - 1:
            if sequence[right_tree_index] < root_value:
                return False
            else:
                right_tree_index += 1
        right = True
        left = True
        if left_tree_index > 0:
            left = self.VerifySquenceOfBST(sequence[0:left_tree_index])
        if left_tree_index < len(sequence) - 1:
            right = self.VerifySquenceOfBST(sequence[left_tree_index: -1])
        return left and right


solution = Solution()
array = [5, 7, 6, 9, 11, 10, 8]
print(solution.VerifySquenceOfBST(array))
