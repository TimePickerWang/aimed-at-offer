**题目描述**
--------

在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
![这里写图片描述](https://img.blog.csdn.net/20180408181119559?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img.blog.csdn.net/20180408181132356?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img.blog.csdn.net/20180408181141144?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img.blog.csdn.net/20180408181150995?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)



java:
```
public class Solution {
    public int InversePairs(int[] array) {
		if (array.length == 0) {
			return 0;
		} else {
			int[] copyArray = new int[array.length];
			for (int i = 0; i < array.length; i++) {
				copyArray[i] = array[i];
			}
			return InversePairsCore(0, array.length - 1, array, copyArray) % 1000000007;
		}
	}

	public int InversePairsCore(int start, int end, int[] array, int[] copyArray) {
		if (start == end) {
			copyArray[start] = array[start];
			return 0;
		}
		int length = (end - start) / 2;
		int left = InversePairsCore(start, start + length, copyArray, array);
		int right = InversePairsCore(start + length + 1, end, copyArray, array);
		int i = start + length; // 前半段最后一个数字的下表
		int j = end;// 后半段最后一个数字的下表
		int copyIndex = end;
		int count = 0;
		while (i >= start && j >= start + length + 1) {
			if (array[i] > array[j]) {
				copyArray[copyIndex--] = array[i--];
				count += j - start - length;
			} else {
				copyArray[copyIndex--] = array[j--];
			}
		}
		for (; i >= start;) {
			copyArray[copyIndex--] = array[i--];
		}
		for (; j >= start + length + 1;) {
			copyArray[copyIndex--] = array[j--];
		}
		return left + right + count;
	}
}
```


python:
```
略
```