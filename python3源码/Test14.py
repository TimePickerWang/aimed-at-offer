# -*- coding:utf-8 -*-

# 剑指offer-题14：调整数组顺序使奇数位于偶数前面

# 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于
# 数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

class Solution:
    def reOrderArray(self, array):
        i = 1
        while i < len(array) and array[i] & 0x1 == 0:
            i += 1
        while i < len(array):
            j = i - 1
            temp = array[i]
            while j >= 0 and array[j] & 0x1 == 0:
                array[j + 1] = array[j]
                j -= 1
            array[j + 1] = temp
            i += 1
            while i < len(array) and array[i] & 0x1 == 0:
                i += 1


solution = Solution()
array = [1, 2, 3, 4, 5, 6, 7]
solution.reOrderArray(array)
print(array)
