package offer;

/**
 * 剑指offer-题4：替换空格
 * 
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */

public class Test04 {

	public String replaceSpace(StringBuffer str) {
//		return str.toString().replaceAll("\\s", "%20");
		
		char[] originStr = str.toString().toCharArray();// 将字符串转为字符数组
		int spaceNum = 0;// 字符串中空格数量
		for (int i = 0; i < originStr.length; i++) {
			if (originStr[i] == ' ') {
				spaceNum++;
			}
		}
		int newStrLength = originStr.length + 2 * spaceNum;
		char[] newStr = new char[newStrLength];
		int originIndex = originStr.length - 1;
		int newStrIndex = newStrLength - 1;
		
		for (; originIndex >= 0; originIndex--) {
			if(originStr[originIndex] != ' '){
				newStr[newStrIndex--] = originStr[originIndex];
			}else {
				newStr[newStrIndex--] = '0';
				newStr[newStrIndex--] = '2';
				newStr[newStrIndex--] = '%';
			}
		}
		return new String(newStr);
	}

	public static void main(String[] args) {
		String oldString = "hello  world a b";
		StringBuffer sb = new StringBuffer(oldString);
		String newString = new Test04().replaceSpace(sb);
		
		System.out.println(newString);
		System.out.println(oldString.length());
		System.out.println(newString.length());
	}

}
