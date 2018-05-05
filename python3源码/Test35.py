# -*- coding:utf-8 -*-

# 剑指offer-题35：第一次只出现一次的字符

# 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一
# 次的字符,并返回它的位置


class Solution:
    def FirstNotRepeatingChar(self, s):
        if s is None or len(s) == 0:
            return -1
        else:
            char_map = {}
            for char in s:
                if char not in char_map:
                    char_map[char] = 1
                else:
                    char_map[char] += 1
            for char in s:
                if char_map[char] == 1:
                    return s.find(char)
            return 0

solution = Solution()
print(solution.FirstNotRepeatingChar("abaccdeff"))
