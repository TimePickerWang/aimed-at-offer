# -*- coding:utf-8 -*-

# 剑指offer-题34：丑数

# 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
# 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。


class Solution:
    def GetUglyNumber_Solution(self, index):
        if index <= 0:
            return 0
        else:
            ugly_num_list = [1]
            ugly_num_index = 1
            multiply2index = 0
            multiply3index = 0
            multiply5index = 0
            while ugly_num_index < index:
                min = self.min(ugly_num_list[multiply2index] * 2, ugly_num_list[multiply3index] * 3, ugly_num_list[multiply5index] * 5)
                ugly_num_list.append(min)
                while ugly_num_list[multiply2index] * 2 <= ugly_num_list[ugly_num_index]:
                    multiply2index += 1
                while ugly_num_list[multiply3index] * 3 <= ugly_num_list[ugly_num_index]:
                    multiply3index += 1
                while ugly_num_list[multiply5index] * 5 <= ugly_num_list[ugly_num_index]:
                    multiply5index += 1
                ugly_num_index += 1
            return ugly_num_list[ugly_num_index - 1]

    def min(self, a, b, c):
        min = a if a < b else b
        return min if min < c else c

solution = Solution()
print(solution.GetUglyNumber_Solution(1500))
