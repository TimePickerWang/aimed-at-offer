package offer;

/**
 * 剑指offer-题11：数值的整数次方
 * 
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */

public class Test11 {
	public double Power(double base, int exponent) {
		int absExponent;
		// 判断base是不是0时，不能用“base==0”判断，因为计算机在表示小数时都有误差。只能用两个数差的绝对值是否在一个很小的范围内判断
		// 底数是0且指数为负数则返回0，可以抛出异常或用个全局变量标识一下
		if (base - 0 < 0.000001 && base - 0 > -0.0000001 && exponent < 0) {
			return 0;
		}
		if (exponent < 0) {
			absExponent = -exponent;
			return 1 / powWithUnsignExponent_2(base, absExponent);
		} else {
			absExponent = exponent;
			return powWithUnsignExponent_2(base, absExponent);
		}
	}

	public double powWithUnsignExponent_1(double base, int exponent) {
		double resule = 1;
		for (int i = 0; i < exponent; i++) {
			resule *= base;
		}
		return resule;
	}
	
	// 递归的方式
	public double powWithUnsignExponent_2(double base, int exponent) {
		if (exponent == 1) {
			return base;
		} else if (exponent == 0) {
			return 1;
		}
		double result = powWithUnsignExponent_2(base, exponent >> 1);
		result *= result;
		if ((exponent & 0x1) == 1) {// 判断exponent是否是偶数
			result *= base;
		}
		return result;
	}

	public static void main(String[] args) {
		Test11 test11 = new Test11();
		System.out.println(test11.Power(2.5, -3));
	}

}
