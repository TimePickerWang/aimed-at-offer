**题目描述**
--------

从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2~10为数字本身，A为1，J为11， Q为12，K为13，而大小王可以看成任意数字。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
![这里写图片描述](https://img.blog.csdn.net/20180414225219901?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)



java:
```
import java.util.Arrays;

public class Solution {
    public boolean isContinuous(int [] numbers) {
        if (numbers.length < 1) {
			return false;
		} else {
			Arrays.sort(numbers);
			int numberOfZeros = 0; // 数组中0的个数
			int gapNum = 0; // 排序后数组中的差值
			for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
				numberOfZeros++;
			}
			int smallIndex = numberOfZeros; // 排序后数组中最小非0值的索引
			int bigIndex = numberOfZeros + 1;
			while (bigIndex < numbers.length) {
				if(numbers[bigIndex] == numbers[smallIndex]){
					return false;
				}
				gapNum += numbers[bigIndex] - numbers[smallIndex] - 1;
				smallIndex = bigIndex;
				bigIndex++;
			}
			return gapNum > numberOfZeros ? false : true;
		}
    }
}
```


python:
```
略
```