# -*- coding:utf-8 -*-

# 剑指offer-题22：栈的压入、弹出序列

# 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是
# 否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某
# 栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不
# 可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）


class Solution:
    def IsPopOrder(self, pushV, popV):
        possible = False
        if len(pushV) > 0 and len(popV) > 0:
            push_index = 0
            pop_index = 0
            stack = []
            while pop_index < len(popV):
                while len(stack) == 0 or stack[-1] != popV[pop_index]:
                    if push_index == len(pushV):
                        break
                    stack.append(pushV[push_index])
                    push_index += 1
                if stack[-1] != popV[pop_index]:
                    break
                stack.pop()
                pop_index += 1
            if pop_index == len(popV) and len(stack) == 0:
                possible = True
        return possible


solution = Solution()
push = [1, 2, 3, 4, 5]
pop1 = [4, 5, 3, 2, 1]
pop2 = [4, 3, 5, 1, 2]
print(solution.IsPopOrder(push, pop1))
print(solution.IsPopOrder(push, pop2))
