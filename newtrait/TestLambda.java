package newtrait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

/*
 * 一、Lambda 表达式的基础语法：Java8中引入了一个新的操作符 "->" 该操作符称为箭头操作符或 Lambda 操作符
 * 						    箭头操作符将 Lambda 表达式拆分成两部分：
 * 左侧：Lambda 表达式的参数列表
 * 右侧：Lambda 表达式中所需执行的功能， 即 Lambda 体
 * 
 * 语法格式一：无参数，无返回值
 * 		() -> System.out.println("Hello Lambda!");
 * 
 * 语法格式二：有一个参数，并且无返回值
 * 		(x) -> System.out.println(x)
 * 
 * 语法格式三：若只有一个参数，小括号可以省略不写
 * 		x -> System.out.println(x)
 * 
 * 语法格式四：有两个以上的参数，有返回值，并且 Lambda 体中有多条语句
 *		Comparator<Integer> com = (x, y) -> {
 *			System.out.println("函数式接口");
 *			return Integer.compare(x, y);
 *		};
 *
 * 语法格式五：若 Lambda 体中只有一条语句， return 和 大括号都可以省略不写
 * 		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
 * 
 * 语法格式六：Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型，即“类型推断”
 * 		(Integer x, Integer y) -> Integer.compare(x, y);
 * 
 * 上联：左右遇一括号省
 * 下联：左侧推断类型省
 * 横批：能省则省
 * 
 * 二、Lambda 表达式需要“函数式接口”的支持
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。 可以使用注解 @FunctionalInterface 修饰
 * 			 可以检查是否是函数式接口
 */

public class TestLambda {
	List<Employee> emps = Arrays.asList(new Employee(100, "张三", 18, 9999.99), 
										new Employee(101, "李四", 18, 6666.66),
										new Employee(102, "王五", 28, 3333.33), 
										new Employee(103, "赵六", 8, 7777.77),
										new Employee(104, "田七", 38, 5555.55));

	@Test
	public void test1() {
		Runnable runnable = () -> System.out.println("hello");
		runnable.run();
	}

	@Test
	public void test2() {
		Comparator<String> comparator = (x, y) -> Integer.parseInt(y + x) - Integer.parseInt(x + y);
		List<String> list = new ArrayList<String>();
		list.add("123");
		list.add("456");
		list.sort(comparator);
		list.forEach(System.out::println);
	}

	@Test
	public void compareByAgeAndName() {
		Collections.sort(emps, (e1, e2) -> {// 先按年龄排序，年龄相同按薪水降序
			if (e1.getAge() == e2.getAge()) {
				return -Double.compare(e1.getSalary(), e2.getSalary());
			} else {
				return Integer.compare(e1.getAge(), e2.getAge());
			}
		});
		emps.forEach(System.out::println);
	}

	@Test
	public void test3() {
		op(100L, 200L, (l1, l2) -> l1 + l2);

		op(100L, 200L, (l1, l2) -> l1 * l2);
	}

	public void op(Long l1, Long l2, MyFunction<Long> mf) {
		System.out.println(mf.getValut(l1, l2));
	}
}
