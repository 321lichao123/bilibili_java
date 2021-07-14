package com.atguigu.java2;

import org.junit.Test;
import sun.security.util.Length;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/*
    一、构造器引用：
        和方法引用类似：函数式接口的抽象方法的形参列表和构造器的形参列表一致。
                        抽象方法的返回值类型即为构造器所属的类的类型
    二、数组引用

 */
public class ConstructorRefTest {
    @Test
    public void test1() {
        Supplier<Employee> sup = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println(sup.get());
        System.out.println("*********************");

        Supplier<Employee> sup1 = () -> new Employee();
        System.out.println(sup1.get());

        System.out.println("***********************");

        Supplier<Employee> sup2 = Employee :: new;
        System.out.println(sup2.get());
    }

    @Test
    public void test2() {
        Function<Integer, Employee> fun1 = id -> new Employee(id);
        System.out.println(fun1.apply(1003));

        System.out.println("********************************");

        Function<Integer, Employee> fun2 = Employee :: new;
        System.out.println(fun2.apply(1004));
    }

    @Test
    public void test3() {
        BiFunction<String, Integer, Employee> bif1 = (name, id) -> new Employee(name, id);
        System.out.println(bif1.apply("Tom", 1005));

        System.out.println("*******************************");

        BiFunction<String, Integer, Employee> bif2 = Employee :: new;
        System.out.println(bif2.apply("Jarry", 1006));
    }

    @Test
    public void test4() {
        Function<Integer, String[]> fun1 = length -> new String[length];
        String[] strings = fun1.apply(5);
        System.out.println(Arrays.toString(strings));

        System.out.println("*************************");

        Function<Integer, String[]> fun2 = String[] :: new;
        String[] strings1 = fun2.apply(4);
        System.out.println(Arrays.toString(strings1));
    }
}
