**题目描述**
--------

输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。例如把9表示成二进制是1001， 有2位是1。因此如果输入9，改函数输出2。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------
一般先会想到用除法和取模来解决，java代码如下：

```
public class Solution {
    public int NumberOf1(int n) {
		int num = 0;
		while (n != 0) {
			int yu = n % 2;
			if (yu == 1) {
				num++;
			}
			n = n / 2;
		}
		return num;
    }
}
```
可是和位移相比起来，除法的效率是很低的，所以会试下通过位移来解决，位运算的相关内容如下：

![这里写图片描述](http://img.blog.csdn.net/20180306153123900?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](http://img.blog.csdn.net/20180306153131271?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

通过位移来解决的java代码如下
```
public class Solution {
    public int NumberOf1(int n) {
		int num = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				num++;
			}
			n = n >> 1;
		}
		return num;
    }
}
```
但是这么做也是有缺点的：正数时可以用右移运算,负数时会陷入死循环。例如整形的-9，其补码为：11111111 11111111 11111111 11110111，会一直右移，且在其左端一直添加1

**负数补码的求法如下：**

![这里写图片描述](http://img.blog.csdn.net/20180306153146318?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)


**解决思路：**
---------
为了避免死循环，可以不右移输入的数字n。首先把n和1做“与”运算，判断n的最低位是不是为1。接着把1左移一位得到2，在和n做“与”运算，就能判断n的次低位是不是1……这样反复左移，每次都能判断n的其中一位是不是1。

java:
```
public class Solution {
    public int NumberOf1(int n) {
		int num = 0;
		int flag = 1;
		while (flag != 0) {
			if ((n & flag) != 0) {
				num++;
			}
			flag = flag << 1;
		}
		return num;
    }
}
```

还有一种更神奇的方法如下：

![这里写图片描述](http://img.blog.csdn.net/20180306170004672?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](http://img.blog.csdn.net/20180306170030247?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)



java:
```
public class Solution {
    public int NumberOf1(int n) {
		int num = 0;
		while (n != 0) {
			n = (n - 1) & n;
			num++;
		}
		return num;
    }
}
```

python(以下方法是牛客网上的，用的是位移32次的方式，由于python3中int类型的长度是没有限制的，所以以上减1然后相与的方式不可行，用python一行代码就解决了):
```
# -*- coding:utf-8 -*-
class Solution:
    def NumberOf1(self, n):
        # write code here
        return sum([(n >> i & 1) for i in range(0, 32)])
```