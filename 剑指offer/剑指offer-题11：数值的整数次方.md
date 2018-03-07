**题目描述**
--------

给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------

主要需要注意以下几点：

1.指数可以是正数、零、负数

2.底数是0而指数是负数时会出错

3.浮点数判断是否是0的方式


java代码如下:
```
public class Solution {
    public double Power(double base, int exponent) {
        int absExponent;
		// 判断base是不是0时，不能用“base==0”判断，因为计算机在表示小数时都有误差。只能用两个数差的绝对值是否在一个很小的范围内判断
		// 底数是0且指数为负数则返回0，可以抛出异常或用个变量标识一下
		if (base - 0 < 0.000001 && base - 0 > -0.0000001 && exponent < 0) {
			return 0;
		}
		if (exponent < 0) {
			absExponent = -exponent;
			return 1 / pow(base, absExponent);
		} else {
			absExponent = exponent;
			return pow(base, absExponent);
		}
    }
    
    public double pow(double base, int exponent) {
		double sum = 1;
		for (int i = 0; i < exponent; i++) {
			sum *= base;
		}
		return sum;
	}
    
}
```


此题还有更好的方式来计算乘方，方法如下：

**解决思路**
--------

![这里写图片描述](http://img.blog.csdn.net/20180307133330761?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![这里写图片描述](http://img.blog.csdn.net/20180307133420392?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)


java:
```
public class Solution {
    public double Power(double base, int exponent) {
		int absExponent;
		// 判断base是不是0时，不能用“base==0”判断，因为计算机在表示小数时都有误差。只能用两个数差的绝对值是否在一个很小的范围内判断
		// 底数是0且指数为负数则返回0，可以抛出异常或用个变量标识一下
		if (base - 0 < 0.000001 && base - 0 > -0.0000001 && exponent < 0) {
			return 0;
		}
		if (exponent < 0) {
			absExponent = -exponent;
			return 1 / powWithUnsignExponent_2(base, absExponent);
		} else {
			absExponent = exponent;
			return powWithUnsignExponent_2(base, absExponent);
		}
    }
    
    public double powWithUnsignExponent_2(double base, int exponent) {
		if (exponent == 1) {
			return base;
		} else if (exponent == 0) {
			return 1;
		}
		double result = powWithUnsignExponent_2(base, exponent >> 1);
		result *= result;
		if((exponent & 0x1) == 1){// 判断exponent是否是偶数
			result *=base;
		}
		return result;
	}
    
}
```


python:
```
# -*- coding:utf-8 -*-
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
```