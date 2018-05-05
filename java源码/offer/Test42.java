package offer;

/**
 * 剑指offer-题42：翻转单词顺序VS左旋转字符串
 * 
 * 题一：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入 字符串"I am a
 * student.",则输出"student. a am I"
 * 
 * 题二：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串坐旋转操作的 功能。比如输入
 * 字符串"abcdefg"和数字2，该函数将返回左旋转2位得到的结果"cdefgab"
 */

public class Test42 {
	// 题一
	public String ReverseSentence(String str) {
		if (str == null) {
			return null;
		} else if (str.trim().equals("")) {
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

	// 题二
	public String LeftRotateString(String str, int n) {
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

	public static void main(String[] args) {
		Test42 test42 = new Test42();
		String str1 = "I am a student.";
		String str2 = "abcdefg";
		System.out.println(test42.ReverseSentence(str1));
		System.out.println(test42.LeftRotateString(str2, 2));
	}
}
