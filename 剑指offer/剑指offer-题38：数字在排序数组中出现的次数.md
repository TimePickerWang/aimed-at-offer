**题目描述**
--------

统计一个数字在排序数组中出现的次数。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
![这里写图片描述](https://img.blog.csdn.net/20180411171505359?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img.blog.csdn.net/20180411171513560?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

java代码中获取第一个k的位置对应下面的getFirstK()方法，获取最后一个k的位置对应下面的getLastK()方法。python中我是直接用的现有的方法，轻喷哈哈。


java:
```
public class Solution {
    public int GetNumberOfK(int[] array, int k) {
		if (array.length == 0) {
			return 0;
		} else {
			int arrayLength = array.length;
			int firstKIndex = getFirstK(array, k, 0, arrayLength - 1);
			int lastKIndex = getLastK(array, k, 0, arrayLength - 1);
			if (firstKIndex >= 0 && lastKIndex >= 0) {
				return lastKIndex - firstKIndex + 1;
			} else {
				return 0;
			}
		}
	}

	// 获取第一个k的位置
	public int getFirstK(int[] array, int k, int start, int end) {
		if (end < start) {
			return -1;
		} else {
			int middleIndex = (start + end) / 2;
			if (array[middleIndex] == k) {
				if ((middleIndex > 0 && array[middleIndex - 1] != k) || middleIndex == 0) {
					return middleIndex;
				} else {
					end = middleIndex - 1;
				}
			} else if (array[middleIndex] < k) {
				start = middleIndex + 1;
			} else {
				end = middleIndex - 1;
			}
			return getFirstK(array, k, start, end);
		}
	}

	// 获取最后一个k的位置
	public int getLastK(int[] array, int k, int start, int end) {
		if (end < start) {
			return -1;
		} else {
			int middleIndex = (start + end) / 2;
			if (array[middleIndex] == k) {
				if ((middleIndex < array.length - 1 && array[middleIndex + 1] != k)
						|| middleIndex == array.length - 1) {
					return middleIndex;
				} else {
					start = middleIndex + 1;
				}
			} else if (array[middleIndex] < k) {
				start = middleIndex + 1;
			} else {
				end = middleIndex - 1;
			}
			return getLastK(array, k, start, end);
		}
	}
}
```


python:
```
# -*- coding:utf-8 -*-
class Solution:
    def GetNumberOfK(self, data, k):
        # write code here
        return data.count(k)
```