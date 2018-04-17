**题目描述**
--------

求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
这题的解答方法来源于牛客网，是通过递归解决的，感觉很巧妙。虽然是递归，但是满足题目给的要求，没有用题目中的关键字。利用了运算符“&&”的“短路”这一特性，当&&左边为假时，就不会继续运算或者判断右边的表达式了。这个思路中，从最大的数开始计算，一直加直到1时结束。代码如下


java:
```
public class Solution {
    public int Sum_Solution(int n) {
        int sum = n;
		boolean flag = n > 0 && (sum += Sum_Solution(n - 1)) > 0;
		return sum;
    }
}
```


python:
```
略
```