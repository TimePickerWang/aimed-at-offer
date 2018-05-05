# -*- coding:utf-8 -*-

# 剑指offer-题3：二维数组中的查找

# 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增
# 的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

class Solution:
    # array 二维列表
    def Find(self, target, array):
        arrlen = len(array)
        col = len(array[0]) - 1
        if arrlen > 0 and col > 1:
            row = 0
            while row < arrlen and col >= 0:
                if array[row][col] < target:
                    row = row + 1
                elif array[row][col] > target:
                    col = col - 1
                else:
                    return True
            return False
        else:
            return False


a = Solution()
array = [[1, 2, 8, 9], [2, 4, 9, 12], [4, 7, 10, 13], [6, 8, 11, 15]]
array2 = [[]]
print(a.Find(1, array))
print(a.Find(1, array2))
