**题目描述**
--------

输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。例如输入12，从1到12这些整数中包含1的数字有1,10,11和12,1一共出现了5次。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
这道题有点难，《剑指offer》上的解法看不是太懂，我是学习了[yi_afly](https://blog.csdn.net/yi_afly/article/details/52012593)的解法后解答的，大神的解法很通俗，代码也比较简练，这里感谢一下大神。大家可以通过点击链接去学习一下，具体代码如下



java:
```
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n < 1) {
			return 0;
		} else {
			int count = 0;
			int base = 1;
			int round = n;
			int weight;
			while (round > 0) {
				weight = round % 10;
				round /= 10;
				count += round * base;
				if (weight > 1) {
					count += base;
				} else if (weight == 1) {
					count += (n % base) + 1;

				}
				
				base *= 10;
			}
			return count;
		}
    }
}
```


python:
```
略
```