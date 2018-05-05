package offer;

/**
 * 剑指offer-题49：把字符串转换成整数
 * 
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 */

public class Test49 {
	public int StrToInt(String str) {
		if (str == null || str.trim().length() == 0) {
			return 0;
		} else {
			char[] charArray = str.toCharArray();
			int num = 0;
			boolean minus = false;
			int i = 0;
			if (charArray[0] == '-') {
				minus = true;
				i = 1;
			} else if (charArray[0] == '+') {
				i = 1;
			}
			for (; i < charArray.length; i++) {
				if(charArray[i] < '0' || charArray[i] > '9'){
					return 0;
				}else {
					num = num * 10 + charArray[i] - '0';
				}
			}
			if(minus){
				return 0 - num;
			}else {
				return num;
			}
		}
	}

	public static void main(String[] args) {
		String str = "-511";
		System.out.println(new Test49().StrToInt(str));
	}
}
