**题目描述**
--------

用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

实验平台：[牛客网](https://www.nowcoder.com/ta/coding-interviews?page=1)

----------

**解决思路：**
---------
![这里写图片描述](http://img.blog.csdn.net/20180303155408968?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](http://img.blog.csdn.net/20180303155416118?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](http://img.blog.csdn.net/2018030315542348?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2FuZzQ1NDU5MjI5Nw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)


java:
```
import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        if(!stack2.isEmpty()){
			return stack2.pop();
		}else{
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			return pop();
		}
    }
}
```

python:

```
# -*- coding:utf-8 -*-
class Solution:
    stack1 = []
    stack2 = []

    def push(self, node):
        self.stack1.append(node)

    def pop(self):
        if len(self.stack2) > 0:
            return self.stack2.pop()
        else:
            while len(self.stack1) > 0:
                self.stack2.append(self.stack1.pop())
            return self.pop()
```