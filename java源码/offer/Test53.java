package offer;

/**
 * 剑指offer-题53：正则表达式匹配
 * 
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次 （包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但 是与"aa.a"和"ab*a"均不匹配
 */

public class Test53 {
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

	public static void main(String[] args) {
		char[] str = { 'a', 'a', 'a' };
		char[] pattern = { 'a', '*' };
		System.out.println(new Test53().match(str, pattern));
	}

}
