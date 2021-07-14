package com.atguigu.java3;

import com.atguigu.java2.Employee;
import com.atguigu.java2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
    1、Stream关注的是数据运算，与CPU打交道
       集合关注的是数据的存储，与内存打交道
    2、Stream的特点：
        Stream自己不会存储元素
        Stream不会改变源对象，相反会返回一个持有结果的新Stream
        Stream操作是延迟执行的。这意味他们会等到需要结果时才执行
    3、Stream执行流程
        Stream实例化
        一系列的中间操作(过滤、映射....)
        终止操作
    4、说明：
        一个中间操作链，对数据源的数据处理
        一旦执行终止操作，就执行中间操作，并产生结果。之后，不会再被使用
 */
public class StreamAPITest {
    // 创建方式一：通过集合
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        // default Stream<E> stream: 返回一个顺序流
        Stream<Employee> stream = employees.stream();
        // default Stream<E> parallelStream: 返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();
    }

    // 创建方式二：通过数组
    @Test
    public void test2() {
        int[] arr1 = {1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(arr1);

        Employee e1 = new Employee("Tom", 1001);
        Employee e2 = new Employee("Jarry", 1002);
        Employee[] arr2 = {e1, e2};
        Stream<Employee> stream1 = Arrays.stream(arr2);
    }

    // 创建方式三：通过Stream的of()
    @Test
    public void test3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

    }

    // 创建方式四：创建无限流
    @Test
    public void test4() {
        // 迭代
        // public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        // Stream.iterate(0, i -> i + 2).forEach(System.out :: println);
        Stream.iterate(0, i -> i + 2).limit(10).forEach(System.out :: println);

        System.out.println("********************");
        // 生成
        // public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
