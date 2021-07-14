package com.atguigu.java3;

import com.atguigu.java2.Employee;
import com.atguigu.java2.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPITest2 {
    // 1-刷选与切片
    @Test
    public void test1() {
        // filter(Predicate p) 接受lambda表达式， 从流中排除某些元素
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

        System.out.println("*****************************");

        // limit(n)：截断流，使其元素不超过给定的数量
        list.stream().limit(3).forEach(System.out::println);

        System.out.println("*****************************");

        //skip(n): 跳过元素，返回一个扔掉前n个元素的流，如果元素不足n个，则返回一个空流
        list.stream().skip(3).forEach(System.out::println);

        // distinct(): 刷选，通过流所生成元素的hashcode()和equal()去重复元素

    }

    // 映射
    @Test
    public void test2() {
        // map():
        List<String> strings = Arrays.asList("aa", "bb", "cc", "dd");
        strings.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        System.out.println();
        //
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().filter(e -> e.getName().length() > 3).forEach(System.out::println);
        System.out.println();
        employees.stream().map(Employee::getName).filter(str -> str.length() > 3).forEach(System.out::println);

        System.out.println();

        //使用map遍历双层stream
        strings.stream().map(StreamAPITest2::fromStringToStream).forEach(e -> {
            e.forEach(System.out::println);
        });
        System.out.println();
        // 使用flatMap遍历双层stream
        strings.stream().flatMap(StreamAPITest2::fromStringToStream).forEach(System.out::println);
    }

    public static Stream<Character> fromStringToStream(String str) {
        List<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    // 排序
    @Test
    public void test3() {
        // sorted(): 自然排序
        List<Integer> list = Arrays.asList(12, 10, 45, -12, -5, 23);
        list.stream().sorted().forEach(System.out::print);

        System.out.println();

        // sorted(Comparator com): 定制排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())).forEach(System.out::println);
    }
}
