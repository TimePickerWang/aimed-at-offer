# -*- coding:utf-8 -*-

# 剑指offer-题10：二进制中1的个数

# 输入一个整数，输出该数二进制表示中1的个数。其中负数用
# 补码表示。例如把9表示成二进制是1001， 有2位是1。因此如果输入9，改函数输出2。

class Solution:
    def NumberOf1(self, n):
        return sum([(n >> i & 1) for i in range(0, 32)])

solution = Solution()
print(solution.NumberOf1(-9))
