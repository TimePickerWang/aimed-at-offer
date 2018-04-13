**题目描述**
--------

题一：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串
"I am a student.",则输出"student. a am I"

题二：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串坐旋转操作的 功能。比如输入字符串"abcdefg"和数字2，该函数将返回左旋转2位得到的结果"cdefgab"

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
题一的解题思路：

题一用了2种方式，第一种java的解法是根据书上的方式来的，思路如下：
![这里写图片描述](https://img.blog.csdn.net/20180413211746818?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

第二种python的解法来自于牛客网上他人的解法，觉得很简洁，就搬过来了，可以学习下



题二的解题思路：

题二用了2种方式，第一种java的解法是根据书上的方式来的，思路如下：
![这里写图片描述](https://img.blog.csdn.net/20180413211930911?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

第二种python的解法自己琢磨的，很简单，大家可以看下


题一

java:
```
public class Solution {
    public String ReverseSentence(String str) {
		if(str == null){
			return null;
		}else if (str.trim().equals("")) {
			return str;
		} else {
			char[] charArray = str.toCharArray();
			// 翻转整个字符串
			charArray = reverse(charArray, 0, charArray.length - 1);
			int beginIndex = 0;
			int endIndex = 0;
			while (endIndex < charArray.length) {
				if (charArray[beginIndex] == ' ') {
					beginIndex++;
					endIndex++;
				} else if (charArray[endIndex] == ' ' || endIndex == charArray.length - 1) {
					if (endIndex == charArray.length - 1) {
						charArray = reverse(charArray, beginIndex, endIndex);
					} else {
						charArray = reverse(charArray, beginIndex, --endIndex);
					}
					beginIndex = ++endIndex;
				} else {
					endIndex++;
				}
			}
			return String.valueOf(charArray);
		}
	}

	public char[] reverse(char[] charArray, int i, int j) {
		if (charArray.length == 0) {
			return null;
		}
		while (i < j) {
			char temp = charArray[i];
			charArray[i++] = charArray[j];
			charArray[j--] = temp;
		}
		return charArray;
	}
}
```

python:
```
# -*- coding:utf-8 -*-
class Solution:
    def ReverseSentence(self, s):
        # write code here
        return " ".join(s.split()[::-1]) if s.strip() != "" else s
```


题二

java:
```
public class Solution {
    public String LeftRotateString(String str,int n) {
        if (str == null) {
			return null;
		} else if (n > 0 && n < str.length() && str.length() > 0) {
			char[] charArray = str.toCharArray();
			charArray = reverse(charArray, 0, n - 1);
			charArray = reverse(charArray, n, str.length() - 1);
			charArray = reverse(charArray, 0, str.length() - 1);
			return String.valueOf(charArray);
		} else {
			return str;
		}
    }
    
    public char[] reverse(char[] charArray, int i, int j) {
		if (charArray.length == 0) {
			return null;
		}
		while (i < j) {
			char temp = charArray[i];
			charArray[i++] = charArray[j];
			charArray[j--] = temp;
		}
		return charArray;
	}
}
```

python:
```
# -*- coding:utf-8 -*-
class Solution:
    def LeftRotateString(self, s, n):
        # write code here
        if n > 0 and s != "":
            s_len = len(s)
            n %= s_len
            s = 2*s
            return s[n: s_len + n]
        else:
            return s
```

