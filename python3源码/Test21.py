# -*- coding:utf-8 -*-

# 剑指offer-题21：包含min函数的栈

# 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。


class Solution:
    data_stack = []
    min_stack = []

    def push(self, node):
        self.data_stack.append(node)
        if len(self.min_stack) == 0 or node < self.min_stack[-1]:
            self.min_stack.append(node)
        else:
            self.min_stack.append(self.min_stack[-1])

    def pop(self):
        if len(self.data_stack) > 0:
            self.data_stack.pop()
            self.min_stack.pop()

    def top(self):
        return self.data_stack[-1]

    def min(self):
        return self.min_stack[-1]


solution = Solution()
solution.push(4)
solution.push(3)
solution.push(2)
print(solution.min())
solution.push(1)
print(solution.min())
solution.pop()
print(solution.min())
