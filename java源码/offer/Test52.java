package offer;

/**
 * 剑指offer-题52：构建乘积数组
 * 
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */

public class Test52 {
	public int[] multiply(int[] A) {
		int[] array = new int[A.length];
		if (A.length > 1) {
			array[0] = 1;
			for (int i = 1; i < A.length; i++) {
				array[i] = array[i - 1] * A[i - 1];
			}
			int temp = 1;
			for (int i = A.length - 2; i >= 0; i--) {
				temp *= A[i + 1];
				array[i] *= temp;
			}
		}
		return array;
	}

	public static void main(String[] args) {
		int[] A = { 2, 3, 4, 5};
		int[] array = new Test52().multiply(A);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
