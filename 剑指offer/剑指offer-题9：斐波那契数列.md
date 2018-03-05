**题目描述**
--------

题目一：大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39

题目二：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**题目一**
--------

在牛客网上，这题只允许循环解答，用递归会报stackoverflowerror异常，即栈溢出。可以知道递归的效率是很低的，时间复杂度是呈指数增长的。

java:
```
public class Solution {
    public int Fibonacci(int n) {
		int fibonacci1 = 0;
		int fibonacci2 = 1;
		int fibonacci = 0;
		if (n == 0) {
			return fibonacci1;
		}else if (n==1) {
			return fibonacci2;
		} else {
			for (int i = 2; i <= n; i++) {
				fibonacci = fibonacci1 + fibonacci2;
				fibonacci1 = fibonacci2;
				fibonacci2 = fibonacci;
			}
			return fibonacci;
		}
    }
}
```


python:
```
# -*- coding:utf-8 -*-
class Solution:
    def Fibonacci(self, n):
        # write code here
        fibonacci1 = 0
        fibonacci2 = 1
        if n == 0:
            return 0
        elif n == 1:
            return 1
        else:
            for i in range(2, n+1):
                fibonacci = fibonacci1 + fibonacci2
                fibonacci1 = fibonacci2
                fibonacci2 = fibonacci
            return fibonacci
```




**题目二**
--------
**解决思路**

![这里写图片描述](http://img.blog.csdn.net/20180305173359840?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](http://img.blog.csdn.net/20180305173406421?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

java:
```
public class Solution {
    public int JumpFloor(int target) {
        int sum1 = 1;
		int sum2 = 2;
		int sum = 0;
		if (target == 1) {
			return sum1;
		} else if (target == 2) {
			return sum2;
		} else {
			for (int i = 2; i < target; i++) {
				sum = sum1 + sum2;
				sum1 = sum2;
				sum2 = sum;
			}
			return sum;
		}
    }
}
```


python:
```
照的之前的稍作改动即可
```