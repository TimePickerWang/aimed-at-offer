**题目描述**
--------

输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------


**解决思路：**
---------
![这里写图片描述](http://img.blog.csdn.net/20180320151050190?/2/text/Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](http://img.blog.csdn.net/20180320151059418?/2/text/Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](http://img.blog.csdn.net/20180320151110986?/2/text/Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](http://img.blog.csdn.net/2018032015112313?/2/text/Ly9ibG9nLmNzZG4ubmV0L3dhbmc0NTQ1OTIyOTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)


java:
```
import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
		boolean possible = false;
		if (pushA.length > 0 && popA.length > 0) {
			int pushIndex = 0;
			int popIndex = 0;
			Stack<Integer> dataStack = new Stack<Integer>();
			while (popIndex < popA.length) {
				while (dataStack.isEmpty() || dataStack.peek() != popA[popIndex]) {
    				// 将压栈序列压入一个栈中直到： 1.栈顶元素和弹出序列的索引位置相同
    				// 2.压栈序列遍历结束也没有找到和弹出序列的索引位置相同的值
					if (pushIndex == pushA.length) {
						break;
					}
					dataStack.push(new Integer(pushA[pushIndex]));
					pushIndex++;
				}
				if (dataStack.peek() != popA[popIndex]) {
					break;
				}
				dataStack.pop();
				popIndex++;
			}
			if(dataStack.isEmpty() && popIndex == popA.length){
				possible = true;
			}
		}
		return possible;
    }
}
```


python:
```
# -*- coding:utf-8 -*-
class Solution:
    def IsPopOrder(self, pushV, popV):
        # write code here
        possible = False
        if len(pushV) > 0 and len(popV) > 0:
            push_index = 0
            pop_index = 0
            stack = []
            while pop_index < len(popV):
                while len(stack) == 0 or stack[-1] != popV[pop_index]:
                    if push_index == len(pushV):
                        break
                    stack.append(pushV[push_index])
                    push_index += 1
                if stack[-1] != popV[pop_index]:
                    break
                stack.pop()
                pop_index += 1
            if pop_index == len(popV) and len(stack) == 0:
                possible = True
        return possible
```