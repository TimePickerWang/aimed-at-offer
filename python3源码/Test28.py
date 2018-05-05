# -*- coding:utf-8 -*-

# 剑指offer-题28：字符串的排列

# 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
# 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。


class Solution:
    def Permutation(self, ss):
        str_list = []
        if ss is not None and len(ss) != 0:
            self.get_list(0, list(ss), str_list)
            str_list.sort()  # 这里用sort()而不用sorted()可以避免不必要的内存开销
        return str_list

    def get_list(self, begin, str_array, str_list):
        if begin == len(str_array):
            str = "".join(str_array)
            if str not in str_list:
                str_list.append(str)
        for i in range(begin, len(str_array)):
            temp = str_array[i]
            str_array[i] = str_array[begin]
            str_array[begin] = temp

            self.get_list(begin+1, str_array, str_list)

            temp = str_array[i]
            str_array[i] = str_array[begin]
            str_array[begin] = temp

solution = Solution()
str_list = solution.Permutation("dbca")
for str in str_list:
    print(str)
