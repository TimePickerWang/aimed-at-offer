**题目描述**
--------

写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
![这里写图片描述](https://img.blog.csdn.net/20180416174859157?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img.blog.csdn.net/20180416174909360?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

Tips:
不使用新的变量，交换两个变量的值有如下两个方式。

1.a=a+b     b=a-b      a=a-b

2.a=a^b      b=a^b      a=a^b

java:
```
public class Solution {
    public int Add(int num1,int num2) {
        int jin;
		int sum;
		do {
			sum = num1 ^ num2;
			jin = (num1 & num2) << 1;
			num1 = sum;
			num2 = jin;
		} while (jin != 0);
		return sum;
    }
}
```


python:
```
略
```