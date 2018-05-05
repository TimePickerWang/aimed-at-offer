package offer;

/**
 * 剑指offer-题54：表示数值的字符串
 * 
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数
 * 值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */

public class Test54 {
	public boolean isNumeric(char[] str) {
		int strLenght = str.length;
		if (str == null || strLenght == 0) {
			return false;
		}
		int index = 0;
		if (str[index] == '+' || str[index] == '-') {
			index++;
		}
		if (index == strLenght) {
			return false;
		}
		// 整数0~9部分
		while (index < strLenght && str[index] >= '0' && str[index] <= '9') {
			index++;
		}
		if (index != strLenght) {
			if (str[index] == '.') {// 含有小数点时
				index++;
				while (index < strLenght && str[index] >= '0' && str[index] <= '9') {
					index++;
				}
				if (index < strLenght && (str[index] == 'e' || str[index] == 'E')) {
					return isExponential(str, strLenght, index);
				}
			} else if (str[index] == 'e' || str[index] == 'E') {
				return isExponential(str, strLenght, index);
			} else {
				return false;
			}
		}
		return index == strLenght;
	}

	// 判断是否是科学计数法
	public boolean isExponential(char[] str, int strLenght, int index) {
		index++;
		if (index < strLenght && (str[index] == '+' || str[index] == '-')) {
			index++;
		}
		if (index == strLenght) {
			return false;
		}
		while (index < strLenght && str[index] >= '0' && str[index] <= '9') {
			index++;
		}
		return index == strLenght ? true : false;
	}

	public static void main(String[] args) {
		Test54 test54 = new Test54();
		char[] numChar1 = "-25E-2".toCharArray();
		char[] numChar2 = "-2.2E+2".toCharArray();
		char[] numChar3 = "12e".toCharArray();
		char[] numChar4 = "12e+5.4".toCharArray();
		System.out.println(test54.isNumeric(numChar1));
		System.out.println(test54.isNumeric(numChar2));
		System.out.println(test54.isNumeric(numChar3));
		System.out.println(test54.isNumeric(numChar4));
	}
}
