# -*- coding:utf-8 -*-

# 剑指offer-题4：替换空格

# 请实现一个函数，将一个字符串中的空格替换成“%20”。
# 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

class Solution:
    # s 源字符串

    def replaceSpace(self, s):
        str_array = list(s)  # 将字符串转为列表
        origin_str_length = len(str_array)
        origin_index = origin_str_length - 1
        new_str_array = []
        while origin_index >= 0:
            if str_array[origin_index] != ' ':
                new_str_array.insert(0, str_array[origin_index])
            else:
                new_str_array.insert(0, '%20')
            origin_index -= 1
        return "".join(new_str_array)  # 将列表转为字符串


solution = Solution()
str = "hello  world a b"
newStr = solution.replaceSpace(str)

print(newStr)
print(len(str))
print(len(newStr))

