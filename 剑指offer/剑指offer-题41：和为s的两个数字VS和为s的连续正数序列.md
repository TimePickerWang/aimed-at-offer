**题目描述**
--------

题一：输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。

题二：输入一个正数s，打印出所有和为s的连续正数序列（至少含有2个数），例如输入15，由于1+2+3+4+5=4+5+6=7+8=15。所以结果打印出3个连续序列1 ~ 5，4 ~ 6，7 ~ 8

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
题一的解题思路：

![这里写图片描述](https://img.blog.csdn.net/20180413154021766?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img.blog.csdn.net/20180413154027866?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

由于题目要求在有多对数字的和等于S的情况下，需要输出两个数的乘积最小的。所以，我们需要遍历整个数组，当两个数字的和等于S时，用两个变量分别存储此时两个数字的值，从而在之后的遍历中，如果又有新的两个数字的和等于S，将它们的积与之前存储的两个变量的积相比较，取积小的两个数即可。


题二的解题思路：

![这里写图片描述](https://img.blog.csdn.net/20180413154040759?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img.blog.csdn.net/20180413154047328?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

题一

java:
```
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> twoNum = new ArrayList<Integer>();
		if (array.length == 0) {
			return twoNum;
		} else {
			int smallIndex = 0;
			int bigIndex = array.length - 1;
			int smallNum = 0;
			int bigNum = 0;
			int multyplyResult = array[bigIndex] * array[bigIndex - 1];

			while (smallIndex < bigIndex) {
				if (array[smallIndex] + array[bigIndex] == sum && array[smallIndex] * array[bigIndex] <= multyplyResult) {
					smallNum = array[smallIndex];
					bigNum = array[bigIndex];
					multyplyResult = smallNum * bigNum;
					bigIndex--;
				} else if (array[smallIndex] + array[bigIndex] > sum) {
					bigIndex--;
				} else {
					smallIndex++;
				}
			}
			if(smallNum + bigNum == sum){
				twoNum.add(new Integer(smallNum));
				twoNum.add(new Integer(bigNum));
			}
			return twoNum;
		}
    }
}
```


题二

java:
```
import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
       ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if (sum < 2) {
			return list;
		} else {
			int small = 1;
			int big = 2;
			int middle = (sum + 1) / 2;
			int curSum = small + big;
			while (small < middle) {
				if (curSum == sum) {
					list.add(getList(small, big));
				}
				while (curSum > sum && small < middle) {
					curSum -= small;
					small++;
					if (curSum == sum) {
						list.add(getList(small, big));
					}
				}
				big++;
				curSum += big;
			}
			return list;
		}
    }
    
    public ArrayList<Integer> getList(int small, int big) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int i = small; i <= big; i++) {
			arrayList.add(new Integer(i));
		}
		return arrayList;
	}
}
```