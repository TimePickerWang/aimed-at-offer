# -*- coding:utf-8 -*-

# 剑指offer-题42：左旋转字符串

# 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
# 请定义一个函数实现字符串坐旋转操作的 功能。比如输入字符串"abcdefg"和数
# 字2，该函数将返回左旋转2位得到的结果"cdefgab"


class Solution:
    def LeftRotateString(self, s, n):
        if n > 0 and s != "":
            s_len = len(s)
            n %= s_len
            s = 2*s
            return s[n: s_len + n]
        else:
            return s


solution = Solution()
s = ""
s = solution.LeftRotateString(s, 2)
print(s)
