**题目描述**
--------

给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
![这里写图片描述](https://img.blog.csdn.net/20180417222721980?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img.blog.csdn.net/2018041722272981?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)


java:
```
public class Solution {
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
}
```


python:
```
略
```