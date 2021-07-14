package com.atguigu.java3;

import com.atguigu.java2.Employee;
import com.atguigu.java2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamAPiTest3 {
    // 匹配与查找
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        // allMatch(predicate p) 检查是否匹配所有元素
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 10);
        System.out.println(allMatch);

        // anyMatch(Predicate p) 检查是否至少匹配一个元素
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(anyMatch);

        // noneMatch(Predicate p) 检查是否没有匹配的元素
        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().contains("雷"));
        System.out.println(noneMatch);

        // findFirst: 返回第一个元素
        Optional<Employee> findFirst = employees.stream().findFirst();
        System.out.println(findFirst);

        // findAny: 返回当前流中的任意元素
        Optional<Employee> findAny = employees.parallelStream().findAny();
        System.out.println(findAny);

        // count: 返回流的总个数
        long count = employees.stream().count();
        System.out.println(count);

        // max(Comparator c): 返回流的最大值
        Optional<Double> max = employees.stream().map(Employee::getSalary).max((e1, e2) -> Double.compare(e1, e2));
        System.out.println(max);

        // min(Comparator c): 返回流的最小值
        Optional<Double> min = employees.stream().map(Employee::getSalary).min((e1, e2) -> Double.compare(e1, e2));
        System.out.println(min);

        // forEach(Consumer c): 内部迭代

    }

    // 归约
    @Test
    public void test2() {
        // reduce(T identity, BinaryOperator): 可以将流中元素反复结合起来，得到一个值
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

        List<Employee> employees = EmployeeData.getEmployees();
        Double reduce1 = employees.stream().map(Employee::getSalary).reduce(0.0, Double::sum);
        System.out.println(reduce1);
    }

    // 收集
    @Test
    public void test3() {
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> list = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println();

        Set<Employee> set = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        set.forEach(System.out::println);
    }
}
