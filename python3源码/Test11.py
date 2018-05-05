# -*- coding:utf-8 -*-

# 剑指offer-题11：数值的整数次方

# 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

class Solution:
    def Power(self, base, exponent):
        # write code here
        if base - 0 > -0.0000001 and base - 0 < 0.0000001 and exponent < 0:
            return 0
        if exponent >= 0:
            return self.powWithUnsignExponent(base, exponent)
        else:
            return 1 / self.powWithUnsignExponent(base, - exponent)

    def powWithUnsignExponent(self, base, absExpoent):
        if absExpoent == 0:
            return 1
        elif absExpoent == 1:
            return base
        result = self.powWithUnsignExponent(base, absExpoent >> 1)
        result *= result
        if absExpoent & 0x1 == 1:
            result *= base
        return result


solution = Solution()
print(solution.Power(2.5, -3))
