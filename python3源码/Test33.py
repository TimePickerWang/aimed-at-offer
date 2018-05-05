# -*- coding:utf-8 -*-

# 剑指offer-题33：把数组排成最小的数

# 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能
# 拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这
# 三个数字能排成的最小数字为321323。
from functools import cmp_to_key


class Solution:
    def PrintMinNumber(self, numbers):
        numbers = map(str, numbers)  # 把numbers里的元素全部转成字符串
        array = sorted(numbers, key=cmp_to_key(lambda s1, s2: int(s1+s2) - int(s2+s1)))
        return "".join(array)

        # numbers = list(map(str, numbers))
        # numbers.sort(key=cmp_to_key(lambda s1, s2: int(s1+s2) - int(s2+s1)))
        # return "".join(numbers)


soluton = Solution()
a = [3, 32, 321]
print(soluton.PrintMinNumber(a))
