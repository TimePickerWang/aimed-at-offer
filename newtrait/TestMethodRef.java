package newtrait;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.Test;

/*
 * 一、方法引用：若 Lambda 体中的功能，已经有方法提供了实现，可以使用方法引用
 * 			  （可以将方法引用理解为 Lambda 表达式的另外一种表现形式）
 * 1. 对象的引用 :: 实例方法名
 * 2. 类名 :: 静态方法名
 * 3. 类名 :: 实例方法名
 * 
 * 注意(important)：
 * 	 ①方法引用所引用的方法的参数列表与返回值类型，需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！
 * 	 ②若Lambda的参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数时，格式： ClassName::MethodName
 * 
 * 二、构造器引用 :构造器的参数列表，需要与函数式接口中参数列表保持一致！
 * 1. 类名 :: new
 * 
 * 三、数组引用
 * 	类型[] :: new;
 */

public class TestMethodRef {

	// 对象的引用 :: 实例方法名
	@Test
	public void test() {
		Consumer<String> comsumer = System.out::println;
		comsumer.accept("hello world");
	}

	@Test
	public void test2() {
		Employee employee = new Employee(1, "hello", 21, 222.22);
		Supplier<Integer> supplier = employee::getAge;
		System.out.println(supplier.get());
	}

	// 类名 :: 静态方法名
	@Test
	public void test3() {
		Comparator<Integer> comparator = Integer::compareTo;
	}

	// 构造器引用 类名 :: new
	@Test
	public void test4() {
		Supplier<Employee> supplier = () -> new Employee();

		// 构造器引用方式,调用无参构造方法
		Supplier<Employee> supplier2 = Employee::new;
		System.out.println(supplier2.get());
	}

	@Test
	public void test5() {
		Function<Integer, Employee> function = (x) -> new Employee(x);

		Function<Integer, Employee> function2 = Employee::new;
		System.out.println(function2.apply(10));
	}

	// 数组引用
	@Test
	public void test6() {
		Function<Integer, String[]> function = (x) -> new String[x];
		String[] strings = function.apply(10);
		System.out.println(strings.length);

		Function<Integer, String[]> function2 = String[]::new;
		String[] strings2 = function2.apply(20);
		System.out.println(strings2.length);
	}

}
