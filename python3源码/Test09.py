# -*- coding:utf-8 -*-

# 剑指offer-题9：斐波那契数列

# 题目一：大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
# 题目二：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。


class Solution:
    def Fibonacci(self, n):
        fibonacci1 = 0
        fibonacci2 = 1
        if n == 0:
            return 0
        elif n == 1:
            return 1
        else:
            for i in range(2, n+1):
                fibonacci = fibonacci1 + fibonacci2
                fibonacci1 = fibonacci2
                fibonacci2 = fibonacci
            return fibonacci


solution = Solution()
print(solution.Fibonacci(5))
print(solution.Fibonacci(10))



