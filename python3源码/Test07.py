# -*- coding:utf-8 -*-

# 剑指offer-题7：用两个栈实现队列

# 用两个栈来实现一个队列，完成队列的Push和Pop操作。
# 队列中的元素为int类型。


class Solution:
    stack1 = []
    stack2 = []

    def push(self, node):
        self.stack1.append(node)

    def pop(self):
        if len(self.stack2) > 0:
            return self.stack2.pop()
        else:
            while len(self.stack1) > 0:
                self.stack2.append(self.stack1.pop())
            return self.pop()

solution = Solution()
solution.push(3)
solution.push(2)
solution.push(1)
print(solution.pop())
print(solution.pop())
solution.push(4)
print(solution.pop())
print(solution.pop())
