**题目描述**
--------

请实现一个函数用来匹配包括'.'和' * '的正则表达式。模式中的字符'.'表示任意一个字符，而' * '表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab * ac * a"匹配，但是与"aa.a"和"ab*a"均不匹配

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
这题需要分以下两种情况：

1.当模式中索引位置后面一个位置的字符不是'*'时：如果字符串中索引位置的字符和模式中索引位置字符相同或者模式中索引位置的字符是'.'，则继续比较字符串和模式的下一个索引位置的字符。如果不同，则直接返回false。例如： aa 和 ab(模式) ，索引为0时字符相同，且模式中索引为1的位置不是'.'，继续比较，当索引为1时字符不同，此时返回false。

2.当模式中索引位置后面一个位置的字符是'*'时：

如果字符串中索引位置的字符和模式中索引位置字符相同或者模式中索引位置的字符是'.'，此时可以把字符中的索引后移1位，模式中索引不变。也可以把字符中的索引不动，模式中的索引后移2位。例如: aab 和 a*b(模式)，索引为0时字符相同，如果字符中索引后移1位，模式中的索引不变。当字符中索引为1，模式中的索引为0时仍然匹配，此时字符中的索引再后移1位，则字符中索引位置的字符是'b',和模式中索引位置的字符不同，模式中索引后移两位继续比较，此时字符都相同，也匹配完毕，则返回true。又例如：ab 和 a *ab,此时需要模式中的索引后移2位，继续比较才能匹配成功

如果字符串中索引位置的字符和模式中索引位置字符不同，模式后移2位继续比较。例如:abc 和 b*abc(模式) ,索引为0时不匹配，模式中索引后移2位指向字符'a',接着继续后面的比较


java:
```
public class Solution {
    public boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null) {
			return false;
		} else if (str.length == 0 && pattern.length == 0) {
			return true;
		}
		return matchCore(str, pattern, 0, 0);
	}

	public boolean matchCore(char[] str, char[] pattern, int strIndex, int patternIndex) {
		int strLength = str.length;
		int patternLength = pattern.length;
		if (strIndex == strLength && patternIndex == patternLength) {
			return true;
		}
		if (strIndex != strLength && patternIndex == patternLength) {
			return false;
		}
		if (patternIndex + 1 < patternLength && pattern[patternIndex + 1] == '*') {
			if ((strIndex < strLength && str[strIndex] == pattern[patternIndex])
					|| (pattern[patternIndex] == '.' && strIndex < strLength)) {
				return matchCore(str, pattern, strIndex, patternIndex + 2)
						|| matchCore(str, pattern, strIndex + 1, patternIndex);
			} else {
				return matchCore(str, pattern, strIndex, patternIndex + 2);
			}
		} else if (patternIndex < patternLength && strIndex < strLength
				&& (str[strIndex] == pattern[patternIndex] || (pattern[patternIndex] == '.'))) {
			return matchCore(str, pattern, ++strIndex, ++patternIndex);
		}
		return false;
	}
}
```


python:
```
略
```