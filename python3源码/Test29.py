# -*- coding:utf-8 -*-

# 剑指offer-题29：数组中出现次数超过一半的数字

# 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
# 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
# 超过数组长度的一半，因此输出2。如果不存在则输出0。


class Solution:
    def MoreThanHalfNum_Solution(self, numbers):
        list_len = len(numbers)
        if numbers is None or list_len == 0:
            return 0
        else:
            times = 1
            num = numbers[0]
            for i in range(1, list_len):
                if times == 0:
                    num = numbers[i]
                    times = 1
                elif numbers[i] == num:
                    times += 1
                else:
                    times -= 1
            totle_num = numbers.count(num)
            if totle_num > list_len/2:
                return num
            else:
                return 0

solution = Solution()
array = [1, 2, 3, 2, 2, 2, 5, 4, 2]
print(solution.MoreThanHalfNum_Solution(array))
