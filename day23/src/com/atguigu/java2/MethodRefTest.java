package com.atguigu.java2;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/*
    方法引用的使用：
        1、使用情景：当要传递给lambda体的操作，已经有实现的方法，可以使用方法的引用

        2、方法引用，本质上就是lambda表达式，而lambda表达式作为函数式接口的实例。所以
                    方法引用也是函数式接口的实例

        3、使用格式： 类(对象) :: 方法名

        4、具体分为如下的三种情况：
            情况一   对象 :: 非静态方法
            情况二   类   :: 静态方法
            情况三   类   :: 非静态方法

        5、方法引用使用的要求：要求接口的抽象方法的形参列表和返回值的类型与方法引用的形参列表和返回值
                             的类型一致（针对情况一和情况二）

 */
public class MethodRefTest {
    @Test
    public void test1() {
        Consumer con = str -> System.out.println(str);
        con.accept("北京");

        System.out.println("*********************");

        Consumer con1 = System.out :: println;
        con1.accept("beijing");
    }

    @Test
    public void test2() {
        Employee employee = new Employee(1001, "Tom", 23, 5000);
        Supplier<String> sup = () -> employee.getName();
        System.out.println(sup.get());

        System.out.println("***************************");

        Supplier<String> sup1 = employee:: getName;
        System.out.println(sup1.get());
    }

    @Test
    public void test3() {
        Comparator<Integer> com1 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(com1.compare(12, 23));

        System.out.println("***********************");

        Comparator<Integer> com2 = Integer :: compare;
        System.out.println(com2.compare(23, 12));
    }

    @Test
    public void test4() {
        Function<Double, Long> fun = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        System.out.println(fun.apply(12.3));

        System.out.println("*******************************");

        Function<Double, Long> fun1 = d -> Math.round(d);
        System.out.println(fun1.apply(14.5));

        System.out.println("*******************************");

        Function<Double, Long> fun2 = Math :: round;
        System.out.println(fun2.apply(13.2));
    }

    @Test
    public void test5() {
        Comparator<String> com1 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com1.compare("abc", "abd"));

        System.out.println("*********************************");

        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("abd", "abc"));
    }

    @Test
    public void test6() {
        BiPredicate<String, String> bip = (o1, o2) -> o1.equals(o2);
        System.out.println(bip.test("abc", "abc"));

        System.out.println("************************************");

        BiPredicate<String, String> bip1 = String::equals;
        System.out.println(bip1.test("abc", "abd"));
    }

    @Test
    public void test7() {
        Employee employee = new Employee(1002, "Jerry", 24, 10000);
        Function<Employee, String> fun = e -> e.getName();
        System.out.println(fun.apply(employee));

        System.out.println("**************************");

        Function<Employee, String> fun1 = Employee :: getName;
        System.out.println(fun1.apply(employee));
    }
}
