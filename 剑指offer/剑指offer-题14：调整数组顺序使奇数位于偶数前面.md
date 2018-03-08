**题目描述**
--------

输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------

**解决思路：**
---------

![这里写图片描述](http://img.blog.csdn.net/20180308132413534?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![这里写图片描述](http://img.blog.csdn.net/20180308132718637?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)


不难写出以下java代码：

```
public class Solution {
    public void reOrderArray(int [] array) {
        int firstIndex = 0;
		int lastIndex = array.length - 1;
		while (firstIndex < lastIndex) {
			while ((array[firstIndex] & 0x1) == 1) {
				firstIndex++;
			}
			while ((array[lastIndex] & 0x1) == 0) {
				lastIndex--;
			}
			if (firstIndex < lastIndex) {
				int temp = array[firstIndex];
				array[firstIndex] = array[lastIndex];
				array[lastIndex] = temp;
			}
		}
    }
}
```

但题目还要求能保证奇数和奇数，偶数和偶数之间的相对位置不变，以上方法就满足不了了，我的解决方式是这样的：结合插入排序的方法，不过这里比较的不是大小，而是某个数是奇数还是偶数，每次循环只需要把某个奇数前面的所有偶数向后移动一位，在把该奇数插入到数组即可，感觉应该还有优化的空间，具体的代码如下：



java:
```
public class Solution {
    public void reOrderArray(int [] array) {
		int j;
		int i = 1;
		while (i < array.length && !isEven(array[i])) {
			i++;
		}
		while (i<array.length) {
			j = i - 1;
			int temp = array[i];
			while (j >= 0 && !isEven(array[j])) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp;
			i++;
			while (i < array.length && !isEven(array[i])) {
				i++;
			}
		}
    }
    
    public boolean isEven(int num) { // 判断是否是奇数，是返回true
		return (num & 0x1) == 1;
	}
}
```


python(在牛客网上运行不通过，但自己运行可以通过，不知道咋回事):
```
# -*- coding:utf-8 -*-
class Solution:
    def reOrderArray(self, array):
        # write code here
        i = 1
        while i < len(array) and array[i] & 0x1 == 0:
            i += 1
        while i < len(array):
            j = i - 1
            temp = array[i]
            while j >= 0 and array[j] & 0x1 == 0:
                array[j + 1] = array[j]
                j -= 1
            array[j + 1] = temp
            i += 1
            while i < len(array) and array[i] & 0x1 == 0:
                i += 1
```