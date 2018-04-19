**题目描述**
--------

请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
创建一个长度为256的整形数组，每个字符根据其ASCLL码值作为数组的下标。数组的初始值都为0，数组存储的是字符在字符流中的位置，从1开始。如果某个字符之前没出现过，则occurrence[i]==0,若出现过，则occurrence[i]>0。当某个出现过的字符再次出现时，由于occurrence[i]>0,此时可以把occurrence[i]赋值为-1，因为这个字符出现了2次，可以不用再考虑了。接着遍历数组，找出第一次出现的不重复的字符。代码如下



java:
```
public class Solution {
    int[] occurrence = new int[256];
	int index = 1;

	// Insert one char from stringstream
	public void Insert(char ch) {
		if (occurrence[ch] == 0) {
			occurrence[ch] = index;
		} else {
			occurrence[ch] = -1;
		}
		index++;
	}

	// return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		int maxIndex = Integer.MAX_VALUE;
		char ch = '#';
		for (int i = 0; i < occurrence.length; i++) {
			if (occurrence[i] > 0 && occurrence[i] < maxIndex) {
				maxIndex = occurrence[i];
				ch = (char) i;
			}
		}
		return ch;
	}
}
```


python:
```
略
```