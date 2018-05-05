# -*- coding:utf-8 -*-

# 剑指offer-题8：旋转数组的最小数字

# 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的
# 数组的一个旋转，输出旋转数组的最小元素。如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的
# 最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。


class Solution:
    def minNumberInRotateArray(self, rotateArray):
        index1 = 0
        index2 = len(rotateArray) - 1
        index_min = index1
        while rotateArray[index1] >= rotateArray[index2]:
            if index2 - index1 == 1:
                index_min = index2
                break
            index_min = int((index1 + index2) / 2)
            if rotateArray[index1] == rotateArray[index2] and \
                            rotateArray[index1] == rotateArray[index_min]:
                for i in range(index1, index2 + 1):
                    if rotateArray[i] < rotateArray[index_min]:
                        index_min = i
                return rotateArray[index_min]
            if rotateArray[index1] <= rotateArray[index_min]:
                index1 = index_min
            elif rotateArray[index_min] <= rotateArray[index2]:
                index2 = index_min
        return rotateArray[index_min]


a = [4, 5, 6, 7, 8, 1, 2, 3]
b = [4, 5, 6, 7, 8]
c = [1, 0, 1, 1, 1]
solution = Solution()
print(solution.minNumberInRotateArray(a))
print(solution.minNumberInRotateArray(b))
print(solution.minNumberInRotateArray(c))