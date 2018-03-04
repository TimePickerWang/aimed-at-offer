**题目描述**
--------

 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一 个旋转，输出旋转数组的最小元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数 组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------

**解决思路：**
---------
![这里写图片描述](http://img.blog.csdn.net/20180304172035977?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](http://img.blog.csdn.net/20180304172049271?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![这里写图片描述](http://img.blog.csdn.net/20180304172057713?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![这里写图片描述](http://img.blog.csdn.net/20180304172106827?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](http://img.blog.csdn.net/20180304172113901?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](http://img.blog.csdn.net/20180304172122141?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)


java:
```
import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int index1 = 0;
		int index2 = array.length - 1;
		// 赋值为index1的原因：当把数组前0个元素进行旋转时，数组的第一个元素就是最小元素，可以不用循环，直接返回
		int indexMin = index1;
		while (array[index1] >= array[index2]) {
			if (index2 - index1 == 1) {
				indexMin = index2;
				break;
			}
			indexMin = (index1 + index2) / 2;
			if (array[index1] == array[index2] && array[index1] == array[indexMin]) {
				for (int i = index1; i <= index2; i++) {
					if (array[i] <= array[indexMin]) {
						indexMin = i;
					}
				}
				return array[indexMin];
			}else if (array[index1] <= array[indexMin]) {
				index1 = indexMin;
			}else if (array[indexMin] <= array[index2]) {
				index2 = indexMin;
			}
		}
		return array[indexMin];
    }
}
```

python:

```
# -*- coding:utf-8 -*-
class Solution:
    def minNumberInRotateArray(self, rotateArray):
        # write code here
        index1 = 0
        index2 = len(rotateArray) - 1
        index_min = index1
        while rotateArray[index1] >= rotateArray[index2]:
            if index2 - index1 == 1:
                index_min = index2
                break
            index_min = int((index1 + index2) / 2)
            if rotateArray[index1] == rotateArray[index2] and \
                            rotateArray[index1] == rotateArray[index_min]:
                for i in range(index1, index2 + 1):
                    if rotateArray[i] < rotateArray[index_min]:
                        index_min = i
                return rotateArray[index_min]
            if rotateArray[index1] <= rotateArray[index_min]:
                index1 = index_min
            elif rotateArray[index_min] <= rotateArray[index2]:
                index2 = index_min
        return rotateArray[index_min]
```