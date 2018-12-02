package newtrait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

/*
 * 一、Stream API 的操作步骤：
 * 
 * 1. 创建 Stream
 * 
 * 2. 中间操作
 * 
 * 3. 终止操作(终端操作)
 */
public class TestStreamaAPI {
	List<Employee> emps = Arrays.asList(new Employee(102, "李四", 59, 6666.66), 
										new Employee(101, "张三", 18, 9999.99),
										new Employee(103, "王五", 28, 3333.33), 
										new Employee(104, "赵六", 8, 7777.77),
										new Employee(104, "赵六", 8, 8888.88), 
										new Employee(104, "赵六", 8, 8888.88),
										new Employee(105, "田七", 28, 5555.55));

	
	// 1. 创建 Stream
	
	
	@Test
	public void test1() {
		// 1. Collection 提供了两个方法 1.串行流：stream() 与2.并行流： parallelStream()
		List<String> strList = new ArrayList<String>();
		Stream<String> stream = strList.stream();

		// 2. 通过 Arrays 中的 stream() 获取一个数组流
		Employee[] employees = new Employee[10];
		Stream<Employee> stream2 = Arrays.stream(employees);

		// 3. 通过 Stream 类中静态方法 of()
		Stream<String> stream3 = Stream.of("aa", "bb", "cc");

		// 4. 创建无限流
		// 迭代
		Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 2);
		iterate.limit(10).forEach(System.out::println);

		// 生成
		Stream<Integer> generate = Stream.generate(() -> (int) (Math.random() * 10));
		generate.limit(10).forEach(System.out::println);
	}


	/*-----------------------------------------------------------------------------*/

	
	// 2. 中间操作
	
	
	/*
	 * 筛选与切片 
	 * filter——接收 Lambda ， 从流中排除某些元素。 
	 * limit——截断流，使其元素不超过给定数量。 
	 * skip —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
	 * distinct —— 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
	 */
	@Test
	public void test2() {
		Stream<Employee> stream = emps.stream().filter((e) -> {
			System.out.println("测试中间操作");// 所有的中间操作不会做任何的处理
			return e.getAge() <= 35;
		});
		// 只有当做终止操作时，所有的中间操作会一次性的全部执行，称为“惰性求值”
		stream.forEach(System.out::println);
	}

	// 在test2的基础上跳过前2个
	@Test
	public void test3() {
		emps.stream().filter((e) -> e.getAge() <= 35)
					 .skip(2)
					 .forEach(System.out::println);
	}
	
	// 在test3的基础上去重
	@Test
	public void test4(){
		emps.stream().filter((e) -> e.getAge() <= 35)
		 .skip(2)
		 .distinct()
		 .forEach(System.out::println);
	}
	
	/*
	 * 映射
	 * map——接收 Lambda, 将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
	 * flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
	 */
	@Test
	public void test5(){
		// 将所有元素转为大写
		List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "ddd");
		list.stream()
			.map((str) -> str.toUpperCase())
			.forEach(System.out::println);
		
		System.out.println("-------------------------------------------");
		
		// 获取所有员工的姓名
		emps.stream()
			.map(Employee::getName)
			.forEach(System.out::println);
	}
	
	/*
	 * sorted()——自然排序
	 * sorted(Comparator com)——定制排序
	 */
	@Test
	public void test6(){
		// 将所有元素按自然顺序排序
		List<String> list = Arrays.asList("ccc","aaa","ddd","eee","bbb");
		list.stream()
			.sorted()
			.forEach(System.out::println);
		
		System.out.println("-------------------------------------------");
		
		// 先按年龄排，年龄相同按薪水排
		emps.stream()
			.sorted((e1,e2)->{
				if(e1.getAge() == e2.getAge()){
					return Double.compare(e1.getSalary(), e2.getSalary());
				}else{
					return e1.getAge() - e2.getAge();
				}
			}).forEach(System.out::println);
	}
	
	
	/*-----------------------------------------------------------------------------*/
	
	
	//3. 终止操作
	
	
	/*
	 * allMatch——检查是否匹配所有元素
	 * anyMatch——检查是否至少匹配一个元素
	 * noneMatch——检查是否没有匹配的元素
	 * findFirst——返回第一个元素
	 * findAny——返回当前流中的任意元素
	 * count——返回流中元素的总个数
	 * max——返回流中最大值
	 * min——返回流中最小值
	 */
	@Test
	public void test7(){
		boolean anyMatch = emps.stream().anyMatch((e) -> e.getAge()==8);
		System.out.println(anyMatch);
		
		// 按薪水排序，返回第一个
		Optional<Employee> findFirst = emps.stream()
										   .sorted((e1,e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
										   .findFirst();
		System.out.println(findFirst.get());
		
		// 获取工资最高的信息
		Optional<Employee> max = emps.stream()
									 .max((e1,e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
		System.out.println(max.get());
		
		// 获取工资最少的值是多少
		Optional<Double> min = emps.stream()
								   .map(Employee::getSalary)
								   .min(Double::compare);
		System.out.println(min.get());
	}
	
	
	/*
	 * 归约  reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
	 */
	@Test
	public void test8(){
		// 计算元素之和
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Integer reduce = list.stream()
							 .reduce(0,(x,y) -> x+y);
		System.out.println(reduce);
		
		System.out.println("-------------------------------------------");
		
		//计算所有员工工资总和
		Optional<Double> reduce2 = emps.stream()
									   .map(Employee::getSalary)
									   .reduce(Double::sum);
		System.out.println(reduce2.get());
	}
	
	
	/*
	 * 收集 collect——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
	 */
	@Test
	public void test9(){
		// 收集所有员工的名字
		emps.stream()
			.map(Employee::getName)
			.collect(Collectors.toSet())
			.forEach(System.out::println);
		
		System.out.println("-------------------------------------------");
		
		// 计算工资平均值
		Double avg = emps.stream()
						 .collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println(avg);
		
		// 计算工资总和
		Double sum = emps.stream()
						 .collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println(sum);
		
		System.out.println("-------------------------------------------");
		
		// 按照员工工资分组
		Map<Double, List<Employee>> map = emps.stream()
											.collect(Collectors.groupingBy(Employee::getSalary));
		System.out.println(map);
	}
	
	@Test
	public void test10(){
		DoubleSummaryStatistics collect = emps.stream()
										.collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println(collect.getAverage());
		System.out.println(collect.getSum());
		System.out.println(collect.getCount());
		
		String str = emps.stream()
						 .map(Employee::getName)
						 .collect(Collectors.joining(","));
		System.out.println(str);
	}
	
}
