**题目描述**
--------

一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n),空间复杂度是O(1)

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
![这里写图片描述](https://img.blog.csdn.net/20180412171805999?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img.blog.csdn.net/20180412171820462?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)


java:
```
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if (array.length < 2) {
			return;
		}
		int resultXOR = 0;
		for (int i = 0; i < array.length; i++) {
			resultXOR ^= array[i];
		}
		int index = getFirstBitIndex(resultXOR);
		for (int i = 0; i < array.length; i++) {
			if (isBit1(array[i], index)) {
				num1[0] ^= array[i];
			} else {
				num2[0] ^= array[i];
			}
		}
	}

	// 返回进行异或之后二进制中第一个为1的位置
	public int getFirstBitIndex(int num) {
		int index = 0;
		while ((num & 1) != 1 && index < 32) {
			num = num >> 1;
			index++;
		}
		return index;
	}

	// 判断某个数的二进制从右往左数的指定位是否是1
	public boolean isBit1(int num, int index) {
		return (num >> index & 1) == 1;
	}
}
```


python:
```
略
```